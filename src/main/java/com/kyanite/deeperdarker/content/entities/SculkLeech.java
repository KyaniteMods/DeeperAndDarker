package com.kyanite.deeperdarker.content.entities;

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
import org.jetbrains.annotations.NotNull;

public class SculkLeech extends Monster {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    private int idleTimeout;

    public SculkLeech(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
    public boolean doHurtTarget(@NotNull Entity pEntity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(pEntity);
    }

    @Override
    public void tick() {
        super.tick();

        if(level().isClientSide()) {
            if(this.idleTimeout <= 0) {
                this.idleTimeout = this.random.nextInt(40, 120);
                this.idleState.start(this.tickCount);
            } else {
                this.idleTimeout--;
            }
        }
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if(pId == 4) {
            this.idleState.stop();
            this.attackState.start(this.tickCount);
        } else {
            super.handleEntityEvent(pId);
        }
    }
}
