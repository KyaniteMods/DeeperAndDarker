package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class SculkLeech extends Monster {
    public final AnimationState attackState = new AnimationState();

    public SculkLeech(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.5));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 4).add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.MOVEMENT_SPEED, 0.25).build();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return DDSounds.LEECH_HURT.get();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        if (entity instanceof Player player) player.giveExperiencePoints(-4);
        return super.doHurtTarget(entity);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id == 4) this.attackState.start(this.tickCount);
        else super.handleEntityEvent(id);
    }
}
