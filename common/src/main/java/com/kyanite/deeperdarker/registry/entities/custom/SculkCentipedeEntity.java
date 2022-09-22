package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.registry.entities.custom.ai.SculkLeechMelee;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SculkCentipedeEntity extends Monster implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Spider.class, EntityDataSerializers.BYTE);

    public SculkCentipedeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.5D).build();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 5, this::predicate));
    }
    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean pClimbing) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if(pClimbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 10));
        this.goalSelector.addGoal(4, new SculkLeechMelee(this, 1.5D, false));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public void setYBodyRot(float pOffset) {
        super.setYBodyRot(pOffset);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sculk_centipede.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sculk_centipede.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
