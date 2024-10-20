package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;

@SuppressWarnings("NullableProblems")
public class AnglerFish extends AbstractFish {
    public final AnimationState attackState = new AnimationState();

    public AnglerFish(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createAttributesSupplier() {
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
    protected SoundEvent getDeathSound() {
        return DDSounds.ANGLER_FISH_DEATH.get();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return DDSounds.ANGLER_FISH_FLOP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return DDSounds.ANGLER_FISH_HURT.get();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(entity);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id == 4) this.attackState.start(this.tickCount);
        else super.handleEntityEvent(id);
    }

    @Override
    public boolean isWithinMeleeAttackRange(LivingEntity entity) {
        return getAttackBoundingBox().inflate(1).intersects(entity.getBoundingBox());
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    public boolean validTarget(LivingEntity entity) {
        return entity != null && entity.isInWater();
    }

    public static boolean checkSpawnRules(EntityType<? extends LivingEntity> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos).is(Blocks.WATER);
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
