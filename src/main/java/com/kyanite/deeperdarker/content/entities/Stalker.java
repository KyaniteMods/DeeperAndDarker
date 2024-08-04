package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.entities.goals.DisturbanceGoal;
import com.kyanite.deeperdarker.content.entities.goals.DisturbanceListener;
import com.kyanite.deeperdarker.util.DDDamageTypes;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
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
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.pathfinder.PathType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.BiConsumer;

@SuppressWarnings("deprecation, NullableProblems")
public class Stalker extends Monster implements DisturbanceListener, VibrationSystem {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState ringAttackState = new AnimationState();
    public final AnimationState emergeState = new AnimationState();
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(true);
    private final DynamicGameEventListener<Listener> dynamicGameEventListener;
    private final User vibrationUser;
    private final Data vibrationData;
    public BlockPos disturbanceLocation;
    private int emergingTime;
    private int rangedCooldown = 440;

    public Stalker(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new Listener(this));
        this.vibrationUser = new VibrationUser();
        this.vibrationData = new Data();
        this.setPathfindingMalus(PathType.LAVA, 8);
        this.setPathfindingMalus(PathType.POWDER_SNOW, 8);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(2, new DisturbanceGoal(this, 1.1));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200).add(Attributes.ATTACK_DAMAGE, 22).add(Attributes.MOVEMENT_SPEED, 0.3f).add(Attributes.ARMOR, 4).add(Attributes.KNOCKBACK_RESISTANCE, 1).build();
    }

    @Override
    public void setCustomName(Component name) {
        super.setCustomName(name);
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
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return DDSounds.STALKER_HURT.get();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(entity);
    }

    @Override
    public void tick() {
        if(level() instanceof ServerLevel level) {
            Ticker.tick(level, this.vibrationData, this.vibrationUser);
        }

        super.tick();

        if(this.getPose() == Pose.EMERGING) {
            if(++emergingTime > 70) this.setPose(Pose.STANDING);
            this.setTarget(null);
        }

        List<Player> players = level().getNearbyPlayers(TargetingConditions.forCombat().range(10), this, this.getBoundingBox().inflate(10, 8, 10));
        if(!players.isEmpty()) {
            this.rangedCooldown--;
            if(this.rangedCooldown < -200) {
                if(level().isClientSide()) this.ringAttackState.stop();
                this.rangedCooldown = 440;
            } else if(this.rangedCooldown < 0 && !level().isClientSide()) {
                for(Player player : players) {
                    player.hurt(DDDamageTypes.source(this.level(), DDDamageTypes.RING, player, this), 2);
                }
                if(this.rangedCooldown % 40 == 0 && level() instanceof ServerLevel serverLevel) {
                    int spawn = this.random.nextIntBetweenInclusive(1, 3);
                    for(int i = 0; i < spawn; i++) {
                        BlockPos spawnPos = new BlockPos((int) getRandomX(5), (int) getRandomY(), (int) getRandomZ(5));
                        DDEntities.SCULK_LEECH.get().spawn(serverLevel, spawnPos, MobSpawnType.EVENT);
                    }
                }
            }
        } else if(this.rangedCooldown < 0) this.rangedCooldown--;

        if(level().isClientSide()) {
            if(!this.idleState.isStarted() && !this.attackState.isStarted() && !this.ringAttackState.isStarted()) {
                this.idleState.start(this.tickCount);
            }

            if(this.rangedCooldown == 0) {
                this.idleState.stop();
                this.attackState.stop();
                this.ringAttackState.start(this.tickCount);
            }

            if(this.getPose() == Pose.EMERGING) {
                double sX = this.random.nextGaussian() * 0.02;
                double sY = this.random.nextGaussian() * 0.02;
                double sZ = this.random.nextGaussian() * 0.02;
                level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn()), getRandomX(1), getY(), getRandomZ(1), sX, sY, sZ);
            }
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id == 4) {
            this.idleState.stop();
            this.attackState.start(this.tickCount);
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean isWithinMeleeAttackRange(LivingEntity entity) {
        return getAttackBoundingBox().inflate(2.8, 1, 2.8).intersects(entity.getBoundingBox());
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if(key.equals(DATA_POSE)) {
            if(this.getPose() == Pose.EMERGING) this.emergeState.start(this.tickCount);
            if(this.getPose() == Pose.STANDING) this.emergeState.stop();
        }

        super.onSyncedDataUpdated(key);
    }

    @Override
    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        this.bossEvent.addPlayer(serverPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.bossEvent.removePlayer(serverPlayer);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData spawnGroupData) {
        if(spawnType == MobSpawnType.TRIGGERED) this.setPose(Pose.EMERGING);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> listenerConsumer) {
        if(this.level() instanceof ServerLevel level) {
            listenerConsumer.accept(this.dynamicGameEventListener, level);
        }
    }

    public boolean canTargetEntity(Entity target) {
        if(target instanceof LivingEntity entity) {
            return this.level() == target.level() && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target) && !this.isAlliedTo(target) && entity.getType() != EntityType.ARMOR_STAND && !entity.getType().is(DDTags.Misc.SCULK) && !entity.isInvulnerable() && !entity.isDeadOrDying() && this.level().getWorldBorder().isWithinBounds(entity.getBoundingBox());
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
        private final PositionSource positionSource = new EntityPositionSource(Stalker.this, Stalker.this.getEyeHeight());

        @Override
        public int getListenerRadius() {
            return 20;
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
        public boolean canReceiveVibration(ServerLevel level, BlockPos pPos, Holder<GameEvent> gameEvent, GameEvent.Context context) {
            if(!isNoAi() && !isDeadOrDying() && !getBrain().hasMemoryValue(MemoryModuleType.VIBRATION_COOLDOWN) && level.getWorldBorder().isWithinBounds(pPos)) {
                if(context.sourceEntity() instanceof LivingEntity target) return canTargetEntity(target);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void onReceiveVibration(ServerLevel level, BlockPos pPos, Holder<GameEvent> gameEvent, @Nullable Entity entity, @Nullable Entity playerEntity, float distance) {
            if(isDeadOrDying()) return;
            playSound(SoundEvents.WARDEN_TENDRIL_CLICKS, 2, 1);
            if(entity != null && canTargetEntity(entity)) {
                if(entity instanceof LivingEntity target && !target.getType().is(DDTags.Misc.SCULK)) setTarget(target);
                return;
            }

            if(getTarget() != null) setTarget(null);
            disturbanceLocation = pPos;
        }
    }
}
