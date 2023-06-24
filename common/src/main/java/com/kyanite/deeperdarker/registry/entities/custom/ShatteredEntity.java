package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.entities.custom.ai.CustomAttackAnimMelee;
import com.kyanite.deeperdarker.registry.entities.custom.ai.GoToDisturbanceGoal;
import com.kyanite.deeperdarker.registry.entities.custom.ai.IDisturbanceListener;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.BiConsumer;

public class ShatteredEntity extends ActionAnimatedEntity implements GeoAnimatable, VibrationSystem, IDisturbanceListener {
    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("animation.shattered.idle", DDUtils.secondsToTicks(3), true, false));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("animation.shattered.walk", DDUtils.secondsToTicks(1.5f), true, false));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("animation.shattered.attack", DDUtils.secondsToTicks(0.5f), false, true));
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private final DynamicGameEventListener<VibrationSystem.Listener> dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationSystem.Listener(this));
    public BlockPos disturbanceLocation = null;

    private VibrationSystem.Data vibrationData = new VibrationSystem.Data();
    private final VibrationSystem.User vibrationUser = new VibrationUser();

    public ShatteredEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.getNavigation().setCanFloat(true);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
    }

    public static AttributeSupplier.Builder attributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 10.0D).add(Attributes.MAX_HEALTH, 50D).add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.ATTACK_DAMAGE, 6D).add(Attributes.ARMOR, 3.5D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new CustomAttackAnimMelee(this, 1.0D, true, 14, 7, ATTACK));
        this.goalSelector.addGoal(8, new GoToDisturbanceGoal(this));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
    }

    @Override
    public boolean dampensVibrations() {
        return true;
    }

    @Override
    protected float nextStep() {
        return this.moveDist + 0.3f;
    }

    @Override
    public void tick() {
        super.tick();
        if(isDeadOrDying()) return;

        Level level = this.level();
        if(level instanceof ServerLevel) {
            Ticker.tick(level, vibrationData, vibrationUser);
        }
    }

    @Override
    public List<EntityState> createStates() {
        return List.of(IDLE, WALK, ATTACK);
    }

    @Override
    public EntityState getMovingState() {
        return WALK;
    }

    @Override
    public float getSpeed() {
        if(ATTACK.equals(getCurrentState())) {
            return 0;
        }

        return super.getSpeed();
    }

    @Override
    public void stateDone(EntityState entityState) {
        if(IDLE.equals(entityState)) {
        } else if(WALK.equals(entityState)) {
            setState(IDLE);
        } else if(ATTACK.equals(entityState)) {
            if(this.getTarget() != null) this.doHurtTarget(this.getTarget());

            setState(IDLE);
        }
    }

    @Override
    public void stateTick(EntityState entityState) {
    }

    @Override
    public int getTransitionTick(EntityState entityState) {
        return 4;
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> consumer) {
        if(level() instanceof ServerLevel serverlevel) {
            consumer.accept(this.dynamicGameEventListener, serverlevel);
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        Data.CODEC.encodeStart(NbtOps.INSTANCE, this.vibrationData).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((tag) -> pCompound.put("listener", tag));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if(pCompound.contains("listener", 10)) {
            Data.CODEC.parse(new Dynamic<>(NbtOps.INSTANCE, pCompound.getCompound("listener"))).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((data) -> this.vibrationData = data);
        }
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.SHATTERED_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return DDSounds.SHATTERED_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DDSounds.SHATTERED_HURT.get();
    }

    public boolean canTargetEntity(Entity entity) {
        if(entity instanceof LivingEntity livingentity) {
            return level() == entity.level() && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(entity) && !this.isAlliedTo(entity) && livingentity.getType() != EntityType.ARMOR_STAND && livingentity.getMobType() != DDTypes.SCULK && !livingentity.isInvulnerable() && !livingentity.isDeadOrDying() && level().getWorldBorder().isWithinBounds(livingentity.getBoundingBox());
        }
        return false;
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new GroundPathNavigation(this, pLevel) {
            protected PathFinder createPathFinder(int pMaxVisitedNodes) {
                this.nodeEvaluator = new WalkNodeEvaluator();
                this.nodeEvaluator.setCanPassDoors(true);
                return new PathFinder(this.nodeEvaluator, pMaxVisitedNodes) {
                    protected float distance(Node node1, Node node2) {
                        return node1.distanceToXZ(node2);
                    }
                };
            }
        };
    }

    @Override
    public BlockPos getDisturbanceLocation() {
        return this.disturbanceLocation;
    }

    @Override
    public void setDisturbanceLocation(BlockPos disturbanceLocation) {
        this.disturbanceLocation = disturbanceLocation;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public Data getVibrationData() {
        return vibrationData;
    }

    @Override
    public User getVibrationUser() {
        return vibrationUser;
    }

    class VibrationUser implements VibrationSystem.User {
        PositionSource positionSource = new EntityPositionSource(ShatteredEntity.this, ShatteredEntity.this.getEyeHeight());

        VibrationUser() {}

        @Override
        public int getListenerRadius() {
            return 16;
        }

        @Override
        public PositionSource getPositionSource() {
            return positionSource;
        }

        public TagKey<GameEvent> getListenableEvents() {
            return GameEventTags.WARDEN_CAN_LISTEN;
        }

        @Override
        public boolean canTriggerAvoidVibration() {
            return true;
        }

        @Override
        public boolean canReceiveVibration(ServerLevel serverLevel, BlockPos blockPos, GameEvent gameEvent, GameEvent.Context context) {
            if(gameEvent.equals(GameEvent.STEP)) return false;

            if(!isDeadOrDying() && serverLevel.getWorldBorder().isWithinBounds(blockPos) && !isRemoved() && level() == serverLevel) {
                Entity entity = context.sourceEntity();
                if(entity instanceof LivingEntity livingentity) {
                    return canTargetEntity(livingentity);
                }
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void onReceiveVibration(ServerLevel serverLevel, BlockPos blockPos, GameEvent gameEvent, @Nullable Entity entity, @Nullable Entity entity2, float f) {
            if(isDeadOrDying()) return;

            playSound(SoundEvents.WARDEN_TENDRIL_CLICKS, 0.4F, -1);

            if(entity != null) {
                if(canTargetEntity(entity)) {
                    if(entity instanceof Monster && ((Monster) entity).getMobType() != DDTypes.SCULK)
                        setTarget((LivingEntity) entity);
                    if(entity instanceof Player)
                        setTarget((LivingEntity) entity);

                    return;
                }
            }

            if(getTarget() != null) setTarget(null);

            disturbanceLocation = blockPos;
        }
    }
}
