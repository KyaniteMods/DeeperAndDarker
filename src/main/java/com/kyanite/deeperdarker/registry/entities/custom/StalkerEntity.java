package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.ai.CustomAttackAnimMelee;
import com.kyanite.deeperdarker.registry.entities.custom.ai.ShatteredGoToDisturbanceGoal;
import com.kyanite.deeperdarker.registry.particle.DDParticleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StalkerEntity extends ActionAnimatedEntity implements IAnimatable, VibrationListener.VibrationListenerConfig {
    private final AnimationFactory factory = new AnimationFactory(this);

    private final DynamicGameEventListener<VibrationListener> dynamicGameEventListener;

    private static final EntityDataAccessor<Boolean> CROUCHED = SynchedEntityData.defineId(StalkerEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> CROUCH_TIME = SynchedEntityData.defineId(StalkerEntity.class, EntityDataSerializers.INT);

    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("animation.stalker.idle", DDUtils.secondsToTicks(3), true, false));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("animation.stalker.walk", DDUtils.secondsToTicks(2), true, false));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("animation.stalker.emerge", DDUtils.secondsToTicks(3.5f), false, true));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("animation.stalker.attack", DDUtils.secondsToTicks(1), false, true));

    public static EntityState CROUCH_IDLE = new EntityState(true, new EntityAnimationHolder("animation.stalker.crouched_idle", DDUtils.secondsToTicks(4), true, false));
    public static EntityState CROUCH_WALK = new EntityState(true, new EntityAnimationHolder("animation.stalker.crouched_walk", DDUtils.secondsToTicks(1), true, false));

    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (entity) -> {
        return entity.getMobType() != MobType.UNDEAD && entity.getMobType() != DDTypes.SCULK;
    };
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(25.0D).selector(LIVING_ENTITY_SELECTOR);

    public StalkerEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationListener(new EntityPositionSource(this, this.getEyeHeight()), 16, this, (VibrationListener.ReceivingEvent)null, 0.0F, 0));
        this.xpReward = 45;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.75));
        this.goalSelector.addGoal(3, new CustomAttackAnimMelee(this, 0.75, true, 14, 7, ATTACK));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
    }

    public static AttributeSupplier attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 30.0D).build();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CROUCHED, false);
        this.entityData.define(CROUCH_TIME, getRandom().nextInt(100, 600));
    }

    public boolean isCrouched() {
        return this.entityData.get(CROUCHED);
    }

    public int getCrouchTimer() {
        return this.entityData.get(CROUCH_TIME);
    }

    public void setCrouchTimer(int time) {
        this.entityData.set(CROUCH_TIME, time);
    }
    public void setCrouching(boolean value) {
        this.entityData.set(CROUCHED, value);
    }

    public boolean noSpace(Level getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }

    public boolean shouldUncrouch() {
        if(noSpace(level, blockPosition(), 4))
            return false;
        else
            return true;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("Crouched", isCrouched());
        pCompound.putInt("CrouchTime", getCrouchTimer());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setCrouching(pCompound.getBoolean("Crouched"));
        setCrouchTimer(pCompound.getInt("CrouchTime"));
    }

    @Override
    protected AABB makeBoundingBox() {
        return isCrouched() ? EntityDimensions.scalable(0.9f, 1.2f).makeBoundingBox(position()) : EntityDimensions.scalable(0.85f, 4.2f).makeBoundingBox(position());
    }

    @Override
    public void tick() {
        super.tick();
        if(isDeadOrDying()) return;

        Level level = this.level;
        if(level instanceof ServerLevel serverlevel) {
            this.dynamicGameEventListener.getListener().tick(serverlevel);
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());

            if(getTarget() != null) {
                if(this.distanceToSqr(this.getTarget()) > 10 && !this.isCrouched()) {
                    setCrouching(true);
                    setState(isCrouched() ? CROUCH_IDLE : IDLE);
                    this.refreshDimensions();
                }
            }

            if(getCrouchTimer() > 0) {
                setCrouchTimer(getCrouchTimer() - 1);
            }else{
                if(isCrouched() && shouldUncrouch())
                    setCrouching(false);
                else if(!isCrouched())
                    setCrouching(true);

                setState(isCrouched() ? CROUCH_IDLE : IDLE);
                this.refreshDimensions();

                setCrouchTimer(getRandom().nextInt(100, 450));
            }

            if(getCurrentState() != EMERGE) {
                for(Player player : level.getNearbyPlayers(TARGETING_CONDITIONS, this, this.getBoundingBox().inflate(20.0D, 8.0D, 20.0D))) {
                    if(!player.isDeadOrDying()) {
                        this.bossEvent.addPlayer((ServerPlayer) player);
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
        return List.of(IDLE, CROUCH_IDLE, EMERGE, WALK, CROUCH_WALK, ATTACK);
    }


    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return getCurrentState() == EMERGE ? true : super.isInvulnerableTo(pSource);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if(pSource.getEntity() != null) {
            if(pSource.getEntity() instanceof LivingEntity livingEntity) {
                livingEntity.knockback(0.3, 0.3, 0.3);
            }
        }
        return super.hurt(pSource, pAmount);
    }

    @Override
    public boolean isPushable() {
        return getCurrentState() == EMERGE ? false : super.isPushable();
    }

    @Override
    public EntityState getMovingState() {
        return this.isCrouched() ? CROUCH_WALK : WALK;
    }

    @Override
    public void stateDone(EntityState entityState) {
        if(WALK.equals(entityState) || CROUCH_WALK.equals(entityState))
            setState(this.isCrouched() ? CROUCH_IDLE : IDLE);
        else if(EMERGE.equals(entityState)) {
            setState(this.isCrouched() ? CROUCH_IDLE : IDLE);
            setNoAi(false);
        }else if(ATTACK.equals(entityState)) {
            if(this.getTarget() != null)
                this.doHurtTarget(this.getTarget());

            setState(this.isCrouched() ? CROUCH_IDLE : IDLE);
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
    public int getTransitionTick(EntityState entityState) {return getCurrentState() == EMERGE ? 0 : 3;}

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {return null;}

    @Override
    public boolean shouldListen(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pEvent, GameEvent.Context pContext) {
        return true;
    }

    @Override
    public void onSignalReceive(ServerLevel pLevel, GameEventListener pListener, BlockPos pPos, GameEvent pEvent, @Nullable Entity p_223869_, @Nullable Entity p_223870_, float pDistance) {

    }

    @Override
    protected float nextStep() {return isCrouched() ? super.nextStep() : this.moveDist + 0.3f;}

    @Override
    public float getSpeed() {
        if(getCurrentState() == ATTACK) return 0;
        return isCrouched() ? super.getSpeed() * 3f : super.getSpeed();
    }

    @Override
    public TagKey<GameEvent> getListenableEvents() {
        return GameEventTags.WARDEN_CAN_LISTEN;
    }

    @Override
    public AnimationFactory getFactory() {return this.factory;}

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
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
}
