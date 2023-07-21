package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShriekWormEntity extends HostileEntity {
    private static final TrackedData<Integer> IDLE_TIMER = DataTracker.registerData(ShriekWormEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState asleepState = new AnimationState();
    public final AnimationState emergeState = new AnimationState();
    public final AnimationState descendState = new AnimationState();

    public ShriekWormEntity(EntityType<? extends HostileEntity> pEntityType, World world) {
        super(pEntityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MeleeAttackGoal(this, 0, true));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public boolean isInvulnerable() {
        return this.isInPose(EntityPose.EMERGING) || this.isInPose(EntityPose.DIGGING);
    }

    public static DefaultAttributeContainer.Builder createShriekWormAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DeeperDarkerSounds.SHRIEK_WORM_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DeeperDarkerSounds.SHRIEK_WORM_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DeeperDarkerSounds.SHRIEK_WORM_HURT;
    }

    @Override
    public EntityGroup getGroup() {
        return DeeperDarkerEntityGroups.SCULK;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IDLE_TIMER, getRandom().nextBetween(160, 300));
    }

    @Override
    public boolean tryAttack(Entity entity) {
        this.getWorld().sendEntityStatus(this, (byte) 4);
        return super.tryAttack(entity);
    }

    @Override
    public void tick() {
        super.tick();

        if (getWorld().isClient()) {
            if (this.idleState.isRunning()) {
                this.dataTracker.set(IDLE_TIMER, this.dataTracker.get(IDLE_TIMER) - 1);

                if (this.dataTracker.get(IDLE_TIMER) <= 0) {
                    this.idleState.stop();
                    if (this.random.nextFloat() < 1f) this.asleepState.start(this.age);
                    else this.descendState.start(this.age); // chance for descend is 0 bc kill function is broken
                }
            } else if (!this.asleepState.isRunning() && !this.descendState.isRunning()) {
                if (!this.attackState.isRunning()) {
                    this.idleState.start(this.age);
                } else if (this.dataTracker.get(IDLE_TIMER) < 160) {
                    this.dataTracker.set(IDLE_TIMER, getRandom().nextBetween(160, 300));
                }
            }
        }

        PlayerEntity player = getWorld().getClosestPlayer(this, 3);
        if (player == null || player.isDead() || player.isCreative()) {
            if (this.attackState.isRunning()) {
                this.attackState.stop();
                this.idleState.start(this.age);
            }
        }

        if (this.descendState.isRunning()) {
            this.dataTracker.set(IDLE_TIMER, this.dataTracker.get(IDLE_TIMER) - 1);
            if (this.dataTracker.get(IDLE_TIMER) <= -90) {
                getWorld().setBlockState(this.getSteppingPos(), DeeperDarkerBlocks.INFESTED_SCULK.getDefaultState(), 3);
                // TODO: kill does not work... make it work (change descent chance once fixed)
                this.kill();
                this.remove(RemovalReason.KILLED);
            }
        }
    }

    @Override
    public void handleStatus(byte pId) {
        if(pId == 4) {
            this.idleState.stop();
            this.asleepState.stop();
            this.attackState.start(this.age);
        } else {
            super.handleStatus(pId);
        }
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void takeKnockback(double pStrength, double pX, double pZ) {
        this.setVelocity(Vec3d.ZERO);
    }
}