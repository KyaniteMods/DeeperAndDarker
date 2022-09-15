package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.entities.custom.ai.CustomAttackAnimMelee;
import com.kyanite.deeperdarker.registry.entities.custom.ai.GoToDisturbanceGoal;
import com.kyanite.deeperdarker.registry.entities.custom.ai.IDisturbanceListener;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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

public class ShatteredEntity extends ActionAnimatedEntity implements IAnimatable, VibrationListener.VibrationListenerConfig, IDisturbanceListener {
    private final AnimationFactory factory = new AnimationFactory(this);

    private final DynamicGameEventListener<VibrationListener> dynamicGameEventListener;

    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("animation.shattered.idle", DDUtils.secondsToTicks(3), true, false));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("animation.shattered.walk", DDUtils.secondsToTicks(1), true, false));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("animation.shattered.attack", DDUtils.secondsToTicks(1), false, true));

    public BlockPos disturbanceLocation = null;

    public ShatteredEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationListener(new EntityPositionSource(this, this.getEyeHeight()), 16, this, null, 0.0F, 0));
        this.getNavigation().setCanFloat(true);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new CustomAttackAnimMelee(this, 1.0D, true, 14, 7, ATTACK));
        this.goalSelector.addGoal(8, new GoToDisturbanceGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
    }

    @Override
    public boolean dampensVibrations() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if(isDeadOrDying()) return;

        Level level = this.level;
        if(level instanceof ServerLevel serverlevel) {
            this.dynamicGameEventListener.getListener().tick(serverlevel);
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
    public void stateTick(EntityState entityState) { }

    @Override
    public int getTransitionTick(EntityState entityState) {
        return 4;
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> consumer) {
        Level level = this.level;
        if(level instanceof ServerLevel serverlevel) {
            consumer.accept(this.dynamicGameEventListener, serverlevel);
        }
    }

    @Override
    public TagKey<GameEvent> getListenableEvents() {
        return GameEventTags.WARDEN_CAN_LISTEN;
    }

    @Override
    public boolean canTriggerAvoidVibration() {
        return true;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        VibrationListener.codec(this).encodeStart(NbtOps.INSTANCE, this.dynamicGameEventListener.getListener()).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((tag) -> pCompound.put("listener", tag));
    }


    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if(pCompound.contains("listener", 10)) {
            VibrationListener.codec(this).parse(new Dynamic<>(NbtOps.INSTANCE, pCompound.getCompound("listener"))).resultOrPartial(DeeperAndDarker.LOGGER::error).ifPresent((vibrationListener) -> this.dynamicGameEventListener.updateListener(vibrationListener, this.level));
        }
    }

    public static AttributeSupplier.Builder attributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 10.0D).add(Attributes.MAX_HEALTH, 50D).add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.ATTACK_DAMAGE, 6D).add(Attributes.ARMOR, 3.5D);
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }
    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public boolean shouldListen(ServerLevel level, GameEventListener eventListener, BlockPos pos, GameEvent event, GameEvent.Context context) {
        if(event.equals(GameEvent.STEP)) return false;

        if(!this.isDeadOrDying() && level.getWorldBorder().isWithinBounds(pos) && !this.isRemoved() && this.level == level) {
            Entity entity = context.sourceEntity();
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
    public void onSignalReceive(ServerLevel level, GameEventListener eventListener, BlockPos pos, GameEvent event, @Nullable Entity entity1, @Nullable Entity entity2, float f) {
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

        this.disturbanceLocation = pos;
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
    public @Nullable void setDisturbanceLocation(BlockPos disturbanceLocation) {
        this.disturbanceLocation = disturbanceLocation;
    }
}