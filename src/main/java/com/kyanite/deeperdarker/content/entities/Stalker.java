package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.entities.goals.DisturbanceGoal;
import com.kyanite.deeperdarker.content.entities.goals.DisturbanceListener;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

@SuppressWarnings("NullableProblems")
public class Stalker extends Monster implements DisturbanceListener, VibrationListener.VibrationListenerConfig {
    private static final EntityDataAccessor<Integer> RING_COOLDOWN = SynchedEntityData.defineId(Stalker.class, EntityDataSerializers.INT);
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState ringAttackState = new AnimationState();
    public final AnimationState emergeState = new AnimationState();
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);
    private final DynamicGameEventListener<VibrationListener> dynamicGameEventListener;
    public BlockPos disturbanceLocation;
    private int emerging;

    public Stalker(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationListener(new EntityPositionSource(this, this.getEyeHeight()), 20, this, null, 0, 0));
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 8);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity pAttackTarget) {
                return 8.0 + pAttackTarget.getBbWidth();
            }
        });
        this.goalSelector.addGoal(2, new DisturbanceGoal(this, 1.1));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200).add(Attributes.ATTACK_DAMAGE, 22).add(Attributes.MOVEMENT_SPEED, 0.3f).add(Attributes.KNOCKBACK_RESISTANCE, 1).build();
    }

    @Override
    public void setCustomName(@Nullable Component pName) {
        super.setCustomName(pName);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.STALKER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DDSounds.STALKER_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DDSounds.STALKER_HURT.get();
    }

    @Override
    public MobType getMobType() {
        return DDMobType.SCULK;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RING_COOLDOWN, getRandom().nextInt(200, 600));
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level.broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(pEntity);
    }

    @Override
    public void tick() {
        if(this.level instanceof ServerLevel serverLevel) {
            this.dynamicGameEventListener.getListener().tick(serverLevel);
        }

        super.tick();

        if(this.getPose() == Pose.EMERGING && ++emerging > 70) this.setPose(Pose.STANDING);

        if(level.isClientSide()) {
            if(!this.attackState.isStarted() && !this.idleState.isStarted()) {
                this.idleState.start(this.tickCount);
            }

            if(this.getPose() == Pose.EMERGING) {
                double sX = this.random.nextGaussian() * 0.02;
                double sY = this.random.nextGaussian() * 0.02;
                double sZ = this.random.nextGaussian() * 0.02;
                level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn()), this.getX() - this.random.nextDouble(), this.getY() + 1, this.getZ() - this.random.nextDouble(), sX, sY, sZ);
            }
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
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
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if(pKey.equals(DATA_POSE)) {
            if(this.getPose() == Pose.EMERGING) this.emergeState.start(this.tickCount);
            if(this.getPose() == Pose.STANDING) this.emergeState.stop();
        }

        super.onSyncedDataUpdated(pKey);
    }

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.bossEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.bossEvent.removePlayer(pServerPlayer);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        if(pReason == MobSpawnType.TRIGGERED) this.setPose(Pose.EMERGING);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> pListenerConsumer) {
        if(this.level instanceof ServerLevel serverLevel) {
            pListenerConsumer.accept(this.dynamicGameEventListener, serverLevel);
        }
    }

    public boolean canTargetEntity(Entity target) {
        if(target instanceof LivingEntity entity) {
            return this.level == target.level && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target) && !this.isAlliedTo(target) && entity.getType() != EntityType.ARMOR_STAND && entity.getType() != DDEntities.SHATTERED.get() && !entity.isInvulnerable() && !entity.isDeadOrDying() && this.level.getWorldBorder().isWithinBounds(entity.getBoundingBox());
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

    public TagKey<GameEvent> getListenableEvents() {
        return GameEventTags.WARDEN_CAN_LISTEN;
    }

    public boolean canTriggerAvoidVibration() {
        return true;
    }

    @Override
    public boolean shouldListen(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pGameEvent, GameEvent.Context pContext) {
        if(!isNoAi() && !isDeadOrDying() && !getBrain().hasMemoryValue(MemoryModuleType.VIBRATION_COOLDOWN) && pLevel.getWorldBorder().isWithinBounds(pPos)) {
            if(pContext.sourceEntity() instanceof LivingEntity target) return canTargetEntity(target);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onSignalReceive(ServerLevel pLevel, GameEventListener pListener, BlockPos pSourcePos, GameEvent pGameEvent, @Nullable Entity pSourceEntity, @Nullable Entity pProjectileOwner, float pDistance) {
        if(isDeadOrDying()) return;
        playSound(SoundEvents.WARDEN_TENDRIL_CLICKS, 2, 1);
        if(pSourceEntity != null && canTargetEntity(pSourceEntity)) {
            if(pSourceEntity instanceof LivingEntity target && target.getMobType() != DDMobType.SCULK) setTarget(target);
            return;
        }

        if(getTarget() != null) setTarget(null);
        disturbanceLocation = pSourcePos;
    }
}
