package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.entities.goals.DisturbanceGoal;
import com.kyanite.deeperdarker.content.entities.goals.DisturbanceListener;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.function.BiConsumer;

@SuppressWarnings("NullableProblems")
public class Shattered extends Monster implements DisturbanceListener, VibrationSystem {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    private final DynamicGameEventListener<Listener> dynamicGameEventListener;
    private final User vibrationUser;
    private final Data vibrationData;
    public BlockPos disturbanceLocation;

    public Shattered(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new Listener(this));
        this.vibrationUser = new VibrationUser();
        this.vibrationData = new Data();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 8);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0);
    }

    @Override
    protected float getSoundVolume() {
        return 0.15f;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.4, true));
        this.goalSelector.addGoal(2, new DisturbanceGoal(this, 1.2));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.6));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 50).add(Attributes.ATTACK_DAMAGE, 6).add(Attributes.MOVEMENT_SPEED, 0.2).add(Attributes.ARMOR, 3.5).add(Attributes.FOLLOW_RANGE, 10).build();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.SHATTERED_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DDSounds.SHATTERED_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DDSounds.SHATTERED_HURT;
    }

    @Override
    public MobType getMobType() {
        return DDMobType.SCULK;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(pEntity);
    }

    @Override
    public void tick() {
        if(this.level() instanceof ServerLevel level) {
            Ticker.tick(level, this.vibrationData, this.vibrationUser);
        }

        super.tick();

        if(level().isClientSide()) {
            if(!this.attackState.isStarted() && !this.idleState.isStarted()) {
                this.idleState.start(this.tickCount);
            }
        }
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int i, boolean bl) {
        super.dropCustomDeathLoot(damageSource, i, bl);
        Entity entity = damageSource.getEntity();
        if (entity instanceof Creeper creeper && creeper.canDropMobsSkull()) {
            creeper.increaseDroppedSkulls();
            this.spawnAtLocation(DDItems.SHATTERED_HEAD);
        }
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if(pId == 4) {
            this.idleState.stop();
            this.attackState.start(this.tickCount);
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> pListenerConsumer) {
        if(this.level() instanceof ServerLevel level) {
            pListenerConsumer.accept(this.dynamicGameEventListener, level);
        }
    }

    public boolean canTargetEntity(Entity target) {
        if(target instanceof LivingEntity entity) {
            return this.level() == target.level() && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target) && !this.isAlliedTo(target) && entity.getType() != EntityType.ARMOR_STAND && entity.getType() != DDEntities.SHATTERED && !entity.isInvulnerable() && !entity.isDeadOrDying() && this.level().getWorldBorder().isWithinBounds(entity.getBoundingBox());
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
    public Data getVibrationData() {
        return this.vibrationData;
    }

    @Override
    public User getVibrationUser() {
        return this.vibrationUser;
    }

    class VibrationUser implements User {
        private final PositionSource positionSource = new EntityPositionSource(Shattered.this, Shattered.this.getEyeHeight());

        @Override
        public int getListenerRadius() {
            return 16;
        }

        @Override
        public PositionSource getPositionSource() {
            return this.positionSource;
        }

        @Override
        public TagKey<GameEvent> getListenableEvents() {
            return GameEventTags.WARDEN_CAN_LISTEN;
        }

        @Override
        public boolean canTriggerAvoidVibration() {
            return true;
        }

        @Override
        public boolean canReceiveVibration(ServerLevel pLevel, BlockPos pPos, GameEvent pGameEvent, GameEvent.Context pContext) {
            if(!isNoAi() && !isDeadOrDying() && !getBrain().hasMemoryValue(MemoryModuleType.VIBRATION_COOLDOWN) && pLevel.getWorldBorder().isWithinBounds(pPos)) {
                if(pContext.sourceEntity() instanceof LivingEntity target) return canTargetEntity(target);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void onReceiveVibration(ServerLevel level, BlockPos pos, GameEvent gameEvent, Entity entity, Entity playerEntity, float distance) {
            if(isDeadOrDying()) return;
            playSound(DDSounds.SHATTERED_NOTICE, 2, 1);
            if(entity != null && canTargetEntity(entity)) {
                if(entity instanceof LivingEntity target && target.getMobType() != DDMobType.SCULK) setTarget(target);
                return;
            }

            if(getTarget() != null) setTarget(null);
            disturbanceLocation = pos;
        }
    }
}
