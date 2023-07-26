package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.entities.goals.DisturbanceListener;
import AnimationState;
import Callback;
import EntityGroup;
import ListenerData;
import com.kyanite.deeperdarker.entities.goals.DisturbanceGoal;
import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.GameEventTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.EntityPositionSource;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.PositionSource;
import net.minecraft.world.event.Vibrations;
import net.minecraft.world.event.listener.EntityGameEventHandler;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public class ShatteredEntity extends HostileEntity implements DisturbanceListener, Vibrations {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    private final EntityGameEventHandler<VibrationListener> entityGameEventHandler;
    private final Callback vibrationCallback;
    private final ListenerData vibrationData;
    private BlockPos disturbanceLocation;

    public ShatteredEntity(EntityType<? extends HostileEntity> pEntityType, World world) {
        super(pEntityType, world);
        this.entityGameEventHandler = new EntityGameEventHandler<>(new VibrationListener(this));
        this.vibrationCallback = new ShatteredEntity.VibrationCallback();
        this.vibrationData = new ListenerData();
        this.setPathfindingPenalty(PathNodeType.LAVA, 8);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.1, true));
        this.goalSelector.add(2, new DisturbanceGoal(this, 1.1));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.5));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    public static DefaultAttributeContainer.Builder createShatteredAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 50).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2).add(EntityAttributes.GENERIC_ARMOR, 3.5).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10);
    }

    @Override
    public EntityGroup getGroup() {
        return DeeperDarkerEntityGroups.SCULK;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return DeeperDarkerSounds.SHATTERED_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DeeperDarkerSounds.SHATTERED_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DeeperDarkerSounds.SHATTERED_HURT;
    }

    @Override
    public boolean tryAttack(Entity pEntity) {
        this.getWorld().sendEntityStatus(this, (byte) 4);
        return super.tryAttack(pEntity);
    }

    @Override
    public void tick() {
        if(this.getWorld() instanceof ServerWorld world) {
            Ticker.tick(world, this.vibrationData, this.vibrationCallback);
        }

        super.tick();

        if (getWorld().isClient()) {
            if (!this.attackState.isRunning() && !this.idleState.isRunning()) {
                this.idleState.start(this.age);
            }
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == (byte)4) {
            this.idleState.stop();
            this.attackState.start(this.age);
        } else {
            super.handleStatus(status);
        }
    }

    @Override
    public void updateEventHandler(BiConsumer<EntityGameEventHandler<?>, ServerWorld> callback) {
        if (this.getWorld() instanceof ServerWorld serverWorld) {
            callback.accept(this.entityGameEventHandler, serverWorld);
        }
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        return this.getWorld() == target.getWorld() && !this.isTeammate(target) && target.getType() != EntityType.ARMOR_STAND && target.getType() != DeeperDarkerEntityTypes.SHATTERED && !target.isInvulnerable() && !target.isDead() && this.getWorld().getWorldBorder().contains(target.getBoundingBox());
    }

    @Override
    public BlockPos getDisturbanceLocation() {
        return this.disturbanceLocation;
    }

    @Override
    public void setDisturbanceLocation(BlockPos disturbancePos) {
        this.disturbanceLocation = disturbancePos;
    }

    @Override
    public ListenerData getVibrationListenerData() {
        return this.vibrationData;
    }

    @Override
    public Callback getVibrationCallback() {
        return this.vibrationCallback;
    }

    class VibrationCallback implements Vibrations.Callback {
        private final PositionSource positionSource = new EntityPositionSource(ShatteredEntity.this, ShatteredEntity.this.getEyeHeight(ShatteredEntity.this.getPose()));

        @Override
        public int getRange() {
            return 16;
        }

        public PositionSource getPositionSource() {
            return this.positionSource;
        }

        @Override
        public boolean accepts(ServerWorld world, BlockPos pos, GameEvent event, GameEvent.Emitter emitter) {
            if (!isAiDisabled() && !isDead() && !getBrain().hasMemoryModule(MemoryModuleType.VIBRATION_COOLDOWN) && ShatteredEntity.this.getWorld().getWorldBorder().contains(pos)) {
                Entity entity = emitter.sourceEntity();
                if (entity instanceof LivingEntity livingEntity) return canTarget(livingEntity);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void accept(ServerWorld world, BlockPos pos, GameEvent event, @Nullable Entity sourceEntity,
                           @Nullable Entity entity, float distance) {
            if (isDead()) return;
            playSound(SoundEvents.ENTITY_WARDEN_TENDRIL_CLICKS, 2.0f, 1.0f);
            if (entity instanceof LivingEntity livingEntity) {
                if (canTarget(livingEntity)) {
                    if (entity instanceof HostileEntity && ((HostileEntity)entity).getGroup() != DeeperDarkerEntityGroups.SCULK) setTarget((LivingEntity) entity);
                    if (entity instanceof PlayerEntity) setTarget((LivingEntity) entity);
                    return;
                }
            }

            if(getTarget() != null) setTarget(null);
            disturbanceLocation = pos;
        }

        public TagKey<GameEvent> getTag() {
            return GameEventTags.WARDEN_CAN_LISTEN;
        }

        public boolean triggersAvoidCriterion() {
            return true;
        }
    }
}