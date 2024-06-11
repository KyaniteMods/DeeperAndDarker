package com.kyanite.deeperdarker.content.entities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class AnglerFish extends AbstractFish {
    public final AnimationState attackState = new AnimationState();

    public AnglerFish(EntityType<? extends AbstractFish> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier createAttributeSupplier() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 6).add(Attributes.ATTACK_DAMAGE, 3).add(Attributes.MOVEMENT_SPEED, 1.5).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AnglerFishAttackGoal(this, 1.5, true));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 40));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::validTarget));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Cod.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Salmon.class, true));
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public MobType getMobType() {
        return DDMobType.SCULK;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(pEntity);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if(pId == 4) this.attackState.start(this.tickCount);
        else super.handleEntityEvent(pId);
    }

    public boolean validTarget(LivingEntity entity) {
        return entity != null && entity.isInWater();
    }

    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }

    static class AnglerFishAttackGoal extends MeleeAttackGoal {
        private final AnglerFish fish;

        public AnglerFishAttackGoal(AnglerFish fish, double speedModifier, boolean followIfNotSeen) {
            super(fish, speedModifier, followIfNotSeen);
            this.fish = fish;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.fish.validTarget(this.fish.getTarget());
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.fish.validTarget(this.fish.getTarget());
        }
    }
}
