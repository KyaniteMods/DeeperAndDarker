package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.ai.CustomAttackAnimMelee;
import com.kyanite.deeperdarker.registry.entities.custom.ai.GoToDisturbanceGoal;
import com.kyanite.deeperdarker.registry.entities.custom.ai.IDisturbanceListener;
import com.kyanite.deeperdarker.registry.particle.DDParticleUtils;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class StalkerEntity extends ActionAnimatedEntity implements IAnimatable, VibrationListener.VibrationListenerConfig, IDisturbanceListener {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private static final EntityDataAccessor<Integer> RING_COOLDOWN = SynchedEntityData.defineId(StalkerEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Boolean> HAS_VASE = SynchedEntityData.defineId(StalkerEntity.class, EntityDataSerializers.BOOLEAN);
    private final DynamicGameEventListener<VibrationListener> dynamicGameEventListener;

    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("animation.stalker.idle", 60, true, false));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("animation.stalker.walk", 40, true, false));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("animation.stalker.emerge", 70, false, true));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("animation.stalker.attack", 10, false, true));
    public static EntityState RING = new EntityState(true, new EntityAnimationHolder("animation.stalker.ring", 60, false, true));

    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (entity) -> entity.getMobType() != DDTypes.SCULK;
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(25.0D).selector(LIVING_ENTITY_SELECTOR);
    private static final TargetingConditions ITEM_TARGETING_CONDITIONS = TargetingConditions.forCombat().range(25.0D);
    public BlockPos disturbanceLocation = null;

    public DamageSource damageSource = new DamageSource("ring");

    public StalkerEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationListener(new EntityPositionSource(this, this.getEyeHeight()), 16, this, null, 0.0F, 0));
        this.xpReward = 45;
        this.getNavigation().setCanFloat(true);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
    }

    @Override
    public boolean dampensVibrations() {
        return true;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new CustomAttackAnimMelee(this, 0.75D, true, 17, 4, ATTACK));
        this.goalSelector.addGoal(8, new GoToDisturbanceGoal(this));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.75D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
    }

    public static AttributeSupplier.Builder attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250).add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 17.0D);
    }

    public boolean isPerformingAction() {
        return getCurrentState() == EMERGE || getCurrentState() == RING || getCurrentState() == ATTACK;
    }

    public boolean hasVase() {
        return this.entityData.get(HAS_VASE);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if(getHealth() < getMaxHealth() / 2 && this.entityData.get(HAS_VASE)) {
            this.entityData.set(HAS_VASE, false);
            playSound(DDSounds.VASE_BREAK.get(), 4, 1);
            for(int i = 0; i < getRandom().nextInt(5, 8); i++) {
                SculkLeechEntity sculkLeechEntity = DDEntities.SCULK_LEECH.get().create(level);
                sculkLeechEntity.moveTo(position());
                level.addFreshEntity(sculkLeechEntity);
            }
        }
        return super.hurt(pSource, pAmount);
    }

    @Override
    public void tick() {
        super.tick();
        if(isDeadOrDying()) return;

        if(this.entityData.get(RING_COOLDOWN) > 0) {
            this.entityData.set(RING_COOLDOWN, this.entityData.get(RING_COOLDOWN) - 1);
        } else {
            if(getCurrentState() != RING && !isMoving) {
                setState(RING);
                playSound(DDSounds.STALKER_RING.get(), 0.1f, 0.5f);
            }
        }

        Level level = this.level;
        if(level instanceof ServerLevel serverlevel) {
            this.dynamicGameEventListener.getListener().tick(serverlevel);
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());

            if(getCurrentState() != EMERGE) {
                if(this.entityData.get(HAS_VASE)) {
                    if(this.getRandom().nextInt(0, 85) == 0) {
                        SculkLeechEntity entity = DDEntities.SCULK_LEECH.get().create(level);
                        entity.moveTo(position());
                        level.addFreshEntity(entity);
                    }
                }

                Warden.applyDarknessAround(serverlevel, position(), this, 20);

                for(LivingEntity livingEntity : level.getEntitiesOfClass(LivingEntity.class, new AABB(blockPosition()).inflate(20, 8, 20))) {
                    if(!livingEntity.isDeadOrDying() && livingEntity.getMobType() != DDTypes.SCULK) {
                        if(livingEntity instanceof Player player)
                            this.bossEvent.addPlayer((ServerPlayer) player);

                        if(getCurrentState() == RING) {
                            livingEntity.hurt(damageSource, 0.8f);
                            livingEntity.knockback(0.2f, 1, 1);
                        }
                    }
                }
                for(Player player : level.getNearbyPlayers(TARGETING_CONDITIONS, this, this.getBoundingBox().inflate(20.0D, 8.0D, 20.0D))) {
                    if(!player.isDeadOrDying()) {
                        this.bossEvent.addPlayer((ServerPlayer) player);
                        if(getCurrentState() == RING) {
                            player.hurt(damageSource, 1.4f);
                            player.knockback(0.2f, -0.4f, -0.4f);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        if(getCurrentState() != EMERGE)
            this.bossEvent.removePlayer(pServerPlayer);
    }

    public static StalkerEntity emergeFromVase(BlockPos pos, Level level) {
        StalkerEntity entity = DDEntities.STALKER.get().create(level);
        entity.setState(EMERGE);
        entity.moveTo(pos, 0, 0);
        level.addFreshEntity(entity);
        entity.setNoAi(true);
        return entity;
    }

    @Override
    public List<EntityState> createStates() {
        return List.of(IDLE, EMERGE, WALK, ATTACK, RING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RING_COOLDOWN, getRandom().nextInt(350, 800));
        this.entityData.define(HAS_VASE, true);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return getCurrentState() == EMERGE || super.isInvulnerableTo(pSource);
    }

    @Override
    public boolean isPushable() {
        return !isPerformingAction() && super.isPushable();
    }

    @Override
    public EntityState getMovingState() {
        return isPerformingAction() ? null : WALK;
    }

    @Override
    public boolean removeWhenFarAway(double d) {
        return false;
    }


    @Override
    public void stateDone(EntityState entityState) {
        if(IDLE.equals(entityState)) {
            // nothing
        } else if(WALK.equals(entityState)) {
            setState(IDLE);
        } else if(EMERGE.equals(entityState)) {
            setState(IDLE);
            setNoAi(false);
        } else if(ATTACK.equals(entityState)) {
            if(this.getTarget() != null) this.doHurtTarget(this.getTarget());
            setState(IDLE);
        } else if(RING.equals(entityState)) {
            this.entityData.set(RING_COOLDOWN, getRandom().nextInt(350, 800));
            setState(IDLE);
        }
    }

    @Override
    public void stateTick(EntityState entityState) {
        if(entityState == EMERGE) {
            if(this.getAnimationTime() < 25 && this.getAnimationTime() > 5) {
                playSound(this.getBlockStateOn().getSoundType().getHitSound());
                DDParticleUtils.clientDiggingParticles(this.getRandom(), this.getBlockStateOn(), this.blockPosition(), this.level);
            }
        }
    }

    @Override
    public float getSpeed() {
        if(isPerformingAction()) return 0;
        return !this.entityData.get(HAS_VASE) ? 0.6f : super.getSpeed();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("HasVase", this.entityData.get(HAS_VASE));
        pCompound.putInt("RingDelay", this.entityData.get(RING_COOLDOWN));
        VibrationListener.codec(this).encodeStart(NbtOps.INSTANCE, this.dynamicGameEventListener.getListener()).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((tag) -> pCompound.put("listener", tag));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(HAS_VASE, pCompound.getBoolean("HasVase"));
        this.entityData.set(RING_COOLDOWN, pCompound.getInt("RingDelay"));
        if(pCompound.contains("listener", 10)) {
            VibrationListener.codec(this).parse(new Dynamic<>(NbtOps.INSTANCE, pCompound.getCompound("listener"))).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((vibrationListener) -> this.dynamicGameEventListener.updateListener(vibrationListener, this.level));
        }
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.STALKER_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return DDSounds.STALKER_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DDSounds.STALKER_HURT.get();
    }

    @Override
    public int getTransitionTick(EntityState entityState) {
        return getCurrentState() == EMERGE ? 0 : 4;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public boolean shouldListen(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pEvent, GameEvent.Context pContext) {
        if(!this.isDeadOrDying() && level.getWorldBorder().isWithinBounds(pPos) && !this.isRemoved() && this.level == level) {
            Entity entity = pContext.sourceEntity();
            if(entity instanceof LivingEntity livingentity) {
                return this.canTargetEntity(livingentity);
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean canTargetEntity(Entity entity) {
        if(entity instanceof LivingEntity livingentity) {
            return this.level == entity.level && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(entity) && !this.isAlliedTo(entity) && livingentity.getType() != EntityType.ARMOR_STAND && livingentity.getMobType() != DDTypes.SCULK && !livingentity.isInvulnerable() && !livingentity.isDeadOrDying() && this.level.getWorldBorder().isWithinBounds(livingentity.getBoundingBox());
        }

        return false;
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> consumer) {
        Level level = this.level;
        if(level instanceof ServerLevel serverlevel) {
            consumer.accept(this.dynamicGameEventListener, serverlevel);
        }
    }

    @Override
    public boolean canTriggerAvoidVibration() {
        return true;
    }

    @Override
    public void onSignalReceive(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pEvent, @Nullable Entity entity1, @Nullable Entity entity2, float pDistance) {
        if(isDeadOrDying()) return;

        this.playSound(SoundEvents.WARDEN_TENDRIL_CLICKS, 0.4F, -1);

        if(entity1 != null) {
            if(canTargetEntity(entity1)) {
                if(entity1 instanceof Monster && ((Monster) entity1).getMobType() != DDTypes.SCULK)
                    this.setTarget((LivingEntity) entity1);
                if(entity1 instanceof Player) this.setTarget((LivingEntity) entity1);

                return;
            }
        }

        if(this.getTarget() != null)
            this.setTarget(null);

        this.disturbanceLocation = pPos;
    }

    @Override
    protected float nextStep() {
        return this.moveDist + 0.3f;
    }

    @Override
    public TagKey<GameEvent> getListenableEvents() {
        return GameEventTags.WARDEN_CAN_LISTEN;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new GroundPathNavigation(this, pLevel) {
            protected PathFinder createPathFinder(int pMaxVisitedNodes) {
                this.nodeEvaluator = new WalkNodeEvaluator();
                this.nodeEvaluator.setCanPassDoors(true);
                return new PathFinder(this.nodeEvaluator, pMaxVisitedNodes) {
                    protected float distance(Node pFirst, Node pSecond) {
                        return pFirst.distanceToXZ(pSecond);
                    }
                };
            }
        };
    }

    @Override
    public BlockPos getDisturbanceLocation() {
        return disturbanceLocation;
    }

    @Override
    public void setDisturbanceLocation(BlockPos disturbanceLocation) {
        this.disturbanceLocation = disturbanceLocation;
    }
}
