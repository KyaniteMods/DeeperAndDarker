package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class StalkerEntity extends ActionAnimatedEntity implements IAnimatable, VibrationListener.VibrationListenerConfig, IDisturbanceListener {
    private final AnimationFactory factory = new AnimationFactory(this);

    private static final EntityDataAccessor<Integer> RING_COOLDOWN = SynchedEntityData.defineId(StalkerEntity.class, EntityDataSerializers.INT);
    private final DynamicGameEventListener<VibrationListener> dynamicGameEventListener;

    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("animation.stalker.idle", DDUtils.secondsToTicks(3), true, false));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("animation.stalker.walk", DDUtils.secondsToTicks(2), true, false));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("animation.stalker.emerge", DDUtils.secondsToTicks(3.5f), false, true));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("animation.stalker.attack", DDUtils.secondsToTicks(0.5f), false, true));
    public static EntityState RING = new EntityState(true, new EntityAnimationHolder("animation.stalker.ring", DDUtils.secondsToTicks(3), false, true));

    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (entity) -> {
        return entity.getMobType() != MobType.UNDEAD && entity.getMobType() != DDTypes.SCULK;
    };
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(25.0D).selector(LIVING_ENTITY_SELECTOR);

    public BlockPos disturbanceLocation = null;

    public StalkerEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationListener(new EntityPositionSource(this, this.getEyeHeight()), 16, this, (VibrationListener.ReceivingEvent)null, 0.0F, 0));
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
        this.goalSelector.addGoal(2, new CustomAttackAnimMelee(this, 0.75D, true, 17, 20, ATTACK));
        this.goalSelector.addGoal(8, new GoToDisturbanceGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.75D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
    }

    public static AttributeSupplier attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 30.0D).build();
    }

    @Override
    public void tick() {
        super.tick();
        if(isDeadOrDying()) return;

        if(this.entityData.get(RING_COOLDOWN) > 0) {
            this.entityData.set(RING_COOLDOWN, this.entityData.get(RING_COOLDOWN) - 1);
            DeeperAndDarker.LOGGER.info(String.valueOf(this.entityData.get(RING_COOLDOWN)));
        }else{
            if(getCurrentState() != RING && !isMoving)
                setState(RING);

            playSound(DDSounds.STALKER_RING.get(), 0.1f, 0.5f);
        }

        Level level = this.level;
        if(level instanceof ServerLevel serverlevel) {
            this.dynamicGameEventListener.getListener().tick(serverlevel);
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());

            if(getCurrentState() != EMERGE) {
                for(Player player : level.getNearbyPlayers(TARGETING_CONDITIONS, this, this.getBoundingBox().inflate(20.0D, 8.0D, 20.0D))) {
                    if(!player.isDeadOrDying()) {
                        this.bossEvent.addPlayer((ServerPlayer) player);
                        if(getCurrentState() == RING) {
                            player.hurt(DamageSource.GENERIC, 1.2f);
                            player.knockback(0.2f, 0.4, 0.4);
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
        this.entityData.define(RING_COOLDOWN, getRandom().nextInt(100, 800));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return getCurrentState() == EMERGE ? true : super.isInvulnerableTo(pSource);
    }

    @Override
    public boolean isPushable() {
        return getCurrentState() == EMERGE ? false : super.isPushable();
    }

    @Override
    public EntityState getMovingState() {
        return getCurrentState() == RING ? RING : WALK;
    }

    @Override
    public void stateDone(EntityState entityState) {
        if (IDLE.equals(entityState)) {}
        else if(WALK.equals(entityState) )
            setState(IDLE);
        else if(EMERGE.equals(entityState)) {
            setState(IDLE);
            setNoAi(false);
        }else if(ATTACK.equals(entityState)) {
            if(this.getTarget() != null)
                this.doHurtTarget(this.getTarget());
            setState(IDLE);
        }else if(RING.equals(entityState)) {
            this.entityData.set(RING_COOLDOWN, getRandom().nextInt(100, 800));
            setState(IDLE);
        }
    }

    @Override
    public void stateTick(EntityState entityState) {
        if(entityState == EMERGE) {
            if(this.getAnimationTime() < 25 && this.getAnimationTime() > 5)
            {
                playSound(this.getBlockStateOn().getSoundType().getHitSound());
                DDParticleUtils.clientDiggingParticles(this.getRandom(), this.getBlockStateOn(), this.blockPosition(), this.level);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("RingDelay", this.entityData.get(RING_COOLDOWN));
        VibrationListener.codec(this).encodeStart(NbtOps.INSTANCE, this.dynamicGameEventListener.getListener()).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((tag) -> pCompound.put("listener", tag));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(RING_COOLDOWN, pCompound.getInt("RingDelay"));
        if(pCompound.contains("listener", 10)) {
            VibrationListener.codec(this).parse(new Dynamic<>(NbtOps.INSTANCE, pCompound.getCompound("listener"))).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((vibrationListener) -> this.dynamicGameEventListener.updateListener(vibrationListener, this.level));
        }
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }

    @Override
    public int getTransitionTick(EntityState entityState) {return getCurrentState() == EMERGE ? 0 : 4;}

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {return null;}

    @Override
    public boolean shouldListen(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pEvent, GameEvent.Context pContext) {
        if (!this.isDeadOrDying() && level.getWorldBorder().isWithinBounds(pPos) && !this.isRemoved() && this.level == level) {
            Entity entity = pContext.sourceEntity();
            if (entity instanceof LivingEntity livingentity) {
                return this.canTargetEntity(livingentity);
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean canTargetEntity(Entity entity) {
        if (entity instanceof LivingEntity livingentity) {
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
            if(canTargetEntity(entity1))
            {
                if(entity1 instanceof Monster && ((Monster)entity1).getMobType() != DDTypes.SCULK)
                    this.setTarget((LivingEntity) entity1);
                if(entity1 instanceof Player)
                    this.setTarget((LivingEntity) entity1);

                return;
            }
        }

        if(this.getTarget() != null)
            this.setTarget(null);

        this.disturbanceLocation = pPos;
    }

    @Override
    protected float nextStep() {return this.moveDist + 0.3f;}

    @Override
    public TagKey<GameEvent> getListenableEvents() {
        return GameEventTags.WARDEN_CAN_LISTEN;
    }

    @Override
    public AnimationFactory getFactory() {return this.factory;}

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new GroundPathNavigation(this, pLevel) {
            protected PathFinder createPathFinder(int p_219479_) {
                this.nodeEvaluator = new WalkNodeEvaluator();
                this.nodeEvaluator.setCanPassDoors(true);
                return new PathFinder(this.nodeEvaluator, p_219479_) {
                    protected float distance(Node p_219486_, Node p_219487_) {
                        return p_219486_.distanceToXZ(p_219487_);
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
    public @Nullable void setDisturbanceLocation(BlockPos disturbanceLocation) {
        this.disturbanceLocation = disturbanceLocation;
    }
}
