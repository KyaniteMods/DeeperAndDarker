package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidType;

@SuppressWarnings("deprecation, NullableProblems")
public class ShriekWorm extends Monster {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState asleepState = new AnimationState();
    public final AnimationState emergeState = new AnimationState();
    public final AnimationState descendState = new AnimationState();
    private int emergeTime;
    private int idleTime;
    private int descentTime;
    private int attackCooldown;

    public ShriekWorm(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0, false));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 100).add(Attributes.ATTACK_DAMAGE, 7).add(Attributes.MOVEMENT_SPEED, 0).add(Attributes.ATTACK_KNOCKBACK, 0).add(Attributes.KNOCKBACK_RESISTANCE, 1).build();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.SHRIEK_WORM_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DDSounds.SHRIEK_WORM_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return DDSounds.SHRIEK_WORM_HURT.get();
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {
        this.idleTime = 0;
        this.level().broadcastEntityEvent(this, (byte) 4);
        this.attackCooldown = 21;
        return super.doHurtTarget(level, target);
    }

    @Override
    public void tick() {
        super.tick();

        if(this.getPose() == Pose.EMERGING && ++emergeTime > 80) this.setPose(Pose.STANDING);
        if(this.getPose() == Pose.STANDING && ++idleTime >= 1200) this.setPose(Pose.DIGGING);
        if(this.getPose() == Pose.DIGGING && ++descentTime >= 83) {
            level().setBlock(this.getOnPos(), DDBlocks.INFESTED_SCULK.get().defaultBlockState(), 3);
            this.remove(RemovalReason.DISCARDED);
        }

        if(this.attackCooldown > 0) this.attackCooldown--;

        if(level().isClientSide()) {
            if(this.getPose() == Pose.STANDING && this.attackCooldown == 1) {
                this.attackState.stop();
                this.idleState.startIfStopped(this.tickCount);
            }
            if(isUnableToAttack()) level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn()), getRandomX(1), getY() + 0.2, getRandomZ(1), 0, 0, 0);
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id == 4) {
            this.idleTime = 0;
            this.idleState.stop();
            this.attackState.start(this.tickCount);
            this.attackCooldown = 21;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean isWithinMeleeAttackRange(LivingEntity entity) {
        return getAttackBoundingBox(3).intersects(entity.getBoundingBox());
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return !isUnableToAttack() && super.canAttack(target);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if(key.equals(DATA_POSE)) {
            if(this.getPose() == Pose.EMERGING) {
                this.emergeState.start(this.tickCount);
            } else if(this.getPose() == Pose.STANDING) {
                this.emergeState.stop();
                this.idleState.start(this.tickCount);
            } else if(this.getPose() == Pose.DIGGING) {
                this.idleState.stop();
                this.descendState.start(this.tickCount);
            }
        }

        super.onSyncedDataUpdated(key);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("EmergeTime", this.emergeTime);
        output.putInt("IdleTime", this.idleTime);
        output.putInt("DescentTime", this.descentTime);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.emergeTime = input.getIntOr("EmergeTime", 0);
        this.idleTime = input.getIntOr("IdleTime", 0);
        this.descentTime = input.getIntOr("DescentTime", 0);
    }

    @Override
    public boolean isInvulnerableTo(ServerLevel level, DamageSource source) {
        return isUnableToAttack() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || super.isInvulnerableTo(level, source);
    }

    private boolean isUnableToAttack() {
        return this.hasPose(Pose.EMERGING) || this.hasPose(Pose.DIGGING);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @org.jspecify.annotations.Nullable SpawnGroupData groupData) {
        if(spawnReason == EntitySpawnReason.TRIGGERED) this.setPose(Pose.EMERGING);
        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }

    @Override
    public void knockback(double pStrength, double pX, double pZ) {
        this.setDeltaMovement(Vec3.ZERO);
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        EntityDimensions hitbox = super.getDefaultDimensions(pose);
        return isUnableToAttack() ? EntityDimensions.fixed(hitbox.width(), 1.5f) : hitbox;
    }
}
