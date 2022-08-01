package com.kyanite.deeperdarker.api;

import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.stringtemplate.v4.ST;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

import java.util.Arrays;
import java.util.List;

public abstract class ActionAnimatedEntity extends Monster implements IAnimatable {
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(ActionAnimatedEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ANIMATION_TIME = SynchedEntityData.defineId(ActionAnimatedEntity.class, EntityDataSerializers.INT);
    private List<EntityState> states;
    private EntityState lastState;

    protected ActionAnimatedEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 5, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(getCurrentState().doAnimate == false) return PlayState.STOP;
        event.getController().setAnimation(new AnimationBuilder().addAnimation(getCurrentState().animationHolder.animationId, getCurrentState().doAnimate));
        return PlayState.CONTINUE;
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

    @Override
    public void tick() {
        super.tick();
        if (isDeadOrDying()) return;

        if(this.entityData.get(ANIMATION_TIME) != 0)
        {
            this.entityData.set(ANIMATION_TIME, this.entityData.get(ANIMATION_TIME) + 1);
            if(this.entityData.get(ANIMATION_TIME) > this.getCurrentState().animationHolder.lengthInTicks) {
                this.entityData.set(ANIMATION_TIME, 0);
            }
        }
        if(this.entityData.get(ANIMATION_TIME) == 0)
            stateDone(getCurrentState());
    }

    public abstract List<EntityState> createStates();
    public abstract void stateDone(EntityState entityState);
}
