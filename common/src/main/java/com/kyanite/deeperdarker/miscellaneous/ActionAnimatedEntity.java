package com.kyanite.deeperdarker.miscellaneous;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;

public abstract class ActionAnimatedEntity extends TamableAnimal implements GeoAnimatable {
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(ActionAnimatedEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ANIMATION_TIME = SynchedEntityData.defineId(ActionAnimatedEntity.class, EntityDataSerializers.INT);
    private final List<EntityState> states;
    public boolean isMoving = false;
    private EntityState lastState;
    private boolean wasMoving = false;

    protected ActionAnimatedEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.states = this.createStates();
    }

    public EntityState getCurrentState() {
        return states.get(this.entityData.get(STATE));
    }

    public void setState(EntityState state) {
        this.entityData.set(STATE, states.indexOf(state));
        this.entityData.set(ANIMATION_TIME, 1);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 0, state -> {
            state.getController().transitionLength(getTransitionTick(getCurrentState()));

            if(state.isMoving() && getMovingState() != null) {
                wasMoving = true;
                isMoving = state.isMoving();
                this.setState(getMovingState());
                state.getController().setAnimation(RawAnimation.begin().thenLoop(getCurrentState().animationHolder.animationId));

                return PlayState.CONTINUE;
            }

            if(wasMoving != state.isMoving() && getMovingState() != null) {
                stateDone(getMovingState());
                wasMoving = state.isMoving();
            }
            if(getCurrentState().animationHolder.loop) state.getController().setAnimation(RawAnimation.begin().thenLoop(getCurrentState().animationHolder.animationId));
            else state.getController().setAnimation(RawAnimation.begin().thenPlay(getCurrentState().animationHolder.animationId));

            return PlayState.CONTINUE;
        }));
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ANIMATION_TIME, 0);
        this.entityData.define(STATE, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("AnimationTime", this.entityData.get(ANIMATION_TIME));
        pCompound.putInt("State", this.entityData.get(STATE));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(ANIMATION_TIME, pCompound.getInt("AnimationTime"));
        this.entityData.set(STATE, pCompound.getInt("State"));
    }

    public int getAnimationTime() {
        return this.entityData.get(ANIMATION_TIME);
    }

    @Override
    public void tick() {
        super.tick();
        if(isDeadOrDying()) return;

        if(!this.getCurrentState().animationHolder.countTicks) return;

        if(this.entityData.get(ANIMATION_TIME) != 0) {
            this.entityData.set(ANIMATION_TIME, this.entityData.get(ANIMATION_TIME) + 1);
            stateTick(this.getCurrentState());
            if(this.entityData.get(ANIMATION_TIME) > this.getCurrentState().animationHolder.lengthInTicks) {
                this.entityData.set(ANIMATION_TIME, 0);
            }
        }
        if(this.entityData.get(ANIMATION_TIME) == 0)
            stateDone(getCurrentState());
    }

    public abstract List<EntityState> createStates();

    public abstract EntityState getMovingState();

    public abstract void stateDone(EntityState entityState);

    public abstract void stateTick(EntityState entityState);

    public abstract int getTransitionTick(EntityState entityState);

    public static class EntityAnimationHolder {
        public String animationId;
        public int lengthInTicks;
        public boolean loop;
        public boolean countTicks;

        public EntityAnimationHolder(String animationId, int lengthInTicks, boolean loop, boolean countTicks) {
            this.animationId = animationId;
            this.lengthInTicks = lengthInTicks;
            this.loop = loop;
            this.countTicks = countTicks;
        }
    }

    public static class EntityState {
        public String name;
        public boolean doAnimate;
        public EntityAnimationHolder animationHolder;

        public EntityState(boolean doAnimate, EntityAnimationHolder animationHolder) {
            this.doAnimate = doAnimate;
            this.animationHolder = animationHolder;
        }
    }
}
