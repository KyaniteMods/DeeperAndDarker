package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.entities.goals.DisturbanceGoal;
import com.kyanite.deeperdarker.entities.goals.DisturbanceListener;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.GameEventTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.EntityPositionSource;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.PositionSource;
import net.minecraft.world.event.Vibrations;
import net.minecraft.world.event.listener.EntityGameEventHandler;

import java.util.List;
import java.util.function.BiConsumer;

public class StalkerEntity extends HostileEntity implements DisturbanceListener, Vibrations {
    private static final TrackedData<Integer> RING_COOLDOWN = DataTracker.registerData(StalkerEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState ringAttackState = new AnimationState();
    private final EntityGameEventHandler<VibrationListener> dynamicGameEventListener;
    private final Callback vibrationCallback;
    private final ListenerData vibrationData;
    public BlockPos disturbanceLocation;
    private boolean playersInRange;
    private boolean ring;

    public StalkerEntity(EntityType<? extends HostileEntity> pEntityType, World world) {
        super(pEntityType, world);
        this.dynamicGameEventListener = new EntityGameEventHandler<>(new VibrationListener(this));
        this.vibrationCallback = new StalkerEntity.VibrationCallback();
        this.vibrationData = new ListenerData();
        this.setPathfindingPenalty(PathNodeType.LAVA, 8);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.3, true));
        this.goalSelector.add(2, new DisturbanceGoal(this, 1.1));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.7));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    public static DefaultAttributeContainer.Builder createStalkerAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 200).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 19).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    public EntityGroup getGroup() {
        return DeeperDarkerEntityGroups.SCULK;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(RING_COOLDOWN, getRandom().nextBetween(200, 600));
    }

    @Override
    public boolean tryAttack(Entity entity) {
        this.getWorld().sendEntityStatus(this, (byte) 4);
        return super.tryAttack(entity);
    }

    @Override
    public void tick() {
        if (this.getWorld() instanceof ServerWorld world) {
            Ticker.tick(world, this.vibrationData, this.vibrationCallback);
        }

        super.tick();

        if (getWorld().isClient()) {
            this.dataTracker.set(RING_COOLDOWN, this.dataTracker.get(RING_COOLDOWN) - 1);
            if(!this.attackState.isRunning() && !this.idleState.isRunning()) {
                this.idleState.start(this.age);
            }
        }

        System.out.println(this.dataTracker.get(RING_COOLDOWN));
        List<PlayerEntity> players = getWorld().getPlayers(TargetPredicate.createAttackable().setBaseMaxDistance(10), this, this.getBoundingBox().expand(10, 8, 10));
        if (!players.isEmpty()) {
            if (this.dataTracker.get(RING_COOLDOWN) <= -100) {
                this.playersInRange = false;
                ring = false;
                this.dataTracker.set(RING_COOLDOWN, getRandom().nextBetween(200, 600));
                if (getWorld().isClient()) this.ringAttackState.stop();
            } else if (this.dataTracker.get(RING_COOLDOWN) <= 0) {
                if (getWorld().isClient()) this.ringAttackState.start(this.age);
                this.playersInRange = true;
                ring = true;
            }
        } else if (this.playersInRange) {
            this.playersInRange = false;
            this.dataTracker.set(RING_COOLDOWN, getRandom().nextBetween(200, 600));
            if (getWorld().isClient()) this.ringAttackState.stop();
        }

        if(!players.isEmpty()) {
            System.out.println("1= " + getWorld().isClient() + ", " + ring);
            if(ring) {
                System.out.println("2= " + getWorld().isClient() + ", " + ring);
                for(PlayerEntity player : players) {
                    player.damage(getWorld().getDamageSources().magic(), 2.5f);
                    player.takeKnockback(0.2f, 0.4f, 0.4f);
                }
            }
        }
    }

    @Override
    public void handleStatus(byte pId) {
        if(pId == 4) {
            this.idleState.stop();
            this.attackState.start(this.age);
        } else {
            super.handleStatus(pId);
        }
    }

    @Override
    public void updateEventHandler(BiConsumer<EntityGameEventHandler<?>, ServerWorld> callback) {
        if(this.getWorld() instanceof ServerWorld level) {
            callback.accept(this.dynamicGameEventListener, level);
        }
    }

    public boolean canTargetEntity(Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            return this.getWorld() == entity.getWorld() && !this.isTeammate(entity) && livingEntity.getType() != EntityType.ARMOR_STAND && livingEntity.getType() != DeeperDarkerEntityTypes.STALKER && !livingEntity.isInvulnerable() && !livingEntity.isDead() && this.getWorld().getWorldBorder().contains(livingEntity.getBoundingBox());
        }

        return false;
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
        private final PositionSource positionSource = new EntityPositionSource(StalkerEntity.this, StalkerEntity.this.getEyeHeight(StalkerEntity.this.getPose()));

        public int getRange() {
            return 20;
        }

        public PositionSource getPositionSource() {
            return this.positionSource;
        }

        public TagKey<GameEvent> getTag() {
            return GameEventTags.WARDEN_CAN_LISTEN;
        }

        public boolean triggersAvoidCriterion() {
            return true;
        }

        @Override
        public boolean accepts(ServerWorld level, BlockPos bounds, GameEvent gameEvent, GameEvent.Emitter emitter) {
            if(!isAiDisabled() && !isDead() && !getBrain().hasMemoryModule(MemoryModuleType.VIBRATION_COOLDOWN) && level.getWorldBorder().contains(bounds)) {
                Entity entity = emitter.sourceEntity();
                if(entity instanceof LivingEntity livingEntity) return canTargetEntity(livingEntity);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void accept(ServerWorld level, BlockPos pos, GameEvent gameEvent, Entity entity, Entity entity2, float v) {
            if (isDead()) return;
            playSound(SoundEvents.ENTITY_WARDEN_TENDRIL_CLICKS, 2.0f, 1.0f);
            if (entity != null) {
                if (canTargetEntity(entity)) {
                    if (entity instanceof HostileEntity && ((HostileEntity) entity).getGroup() != DeeperDarkerEntityGroups.SCULK) setTarget((LivingEntity) entity);
                    if (entity instanceof PlayerEntity) setTarget((LivingEntity) entity);
                    return;
                }
            }

            if (getTarget() != null) setTarget(null);
            disturbanceLocation = pos;
        }
    }
}