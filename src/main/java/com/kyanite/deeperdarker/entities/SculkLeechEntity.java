package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class SculkLeechEntity extends HostileEntity {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();

    public SculkLeechEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public SculkLeechEntity(World world) {
        super(DeeperDarkerEntityTypes.SCULK_LEECH, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.5));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createSculkLeechAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 4).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DeeperDarkerSounds.LEECH_HURT;
    }

    @Override
    public EntityGroup getGroup() {
        return DeeperDarkerEntityGroups.SCULK;
    }

    @Override
    public boolean tryAttack(Entity entity) {
        this.getWorld().sendEntityStatus(this, (byte) 4);
        return super.tryAttack(entity);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            if (!this.attackState.isRunning() && !this.idleState.isRunning()) {
                this.idleState.start(this.age);
            }
        }
    }

    @Override
    public void handleStatus(byte id) {
        if (id == 4) {
            this.idleState.stop();
            this.attackState.start(this.age);
        } else {
            super.handleStatus(id);
        }
    }
}