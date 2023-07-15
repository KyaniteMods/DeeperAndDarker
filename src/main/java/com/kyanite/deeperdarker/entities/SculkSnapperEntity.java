package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SculkSnapperEntity extends TameableEntity {
    private static final TrackedData<Integer> SNIFF_COUNTER = DataTracker.registerData(SculkSnapperEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState sniffState = new AnimationState();
    public final AnimationState digState = new AnimationState();
    public final AnimationState emergeState = new AnimationState();
    private int idleTimeout;
    private BlockPos targetPos;

    protected SculkSnapperEntity(EntityType<? extends TameableEntity> entityType,
                                 World world) {
        super(entityType, world);
        this.dataTracker.set(SNIFF_COUNTER, getRandom().nextBetween(180, 400));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.1, true));
        this.goalSelector.add(2, new FollowOwnerGoal(this, 0.9, 12, 2, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.5));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 7));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return (this.isInPose(EntityPose.DIGGING) || this.isInPose(EntityPose.EMERGING)) && !damageSource.isIn(
                DamageTypeTags.BYPASSES_INVULNERABILITY) || super.isInvulnerableTo(damageSource);
    }

    public static DefaultAttributeContainer.Builder createSculkSnapperAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 12).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return DeeperDarkerSounds.SCULK_SNAPPER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DeeperDarkerSounds.SCULK_SNAPPER_HURT;
    }

    @Override
    public boolean tryAttack(Entity target) {
        this.getWorld().sendEntityStatus(this, (byte)4);
        this.playSound(DeeperDarkerSounds.SCULK_SNAPPER_BITE, 1.0f, 1.0f);
        return super.tryAttack(target);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SNIFF_COUNTER, getRandom().nextBetween(180, 400));
    }

    @Override
    public void tick() {
        super.tick();

        if (getWorld().isClient) {
            if (this.idleTimeout <= 0) {
                this.idleTimeout = this.random.nextBetween(40, 120);
                this.idleState.start(this.age);
            } else {
                this.idleTimeout--;
            }

            if(!this.isTamed()) {
                this.dataTracker.set(SNIFF_COUNTER, this.dataTracker.get(SNIFF_COUNTER) - 1);
                if(this.dataTracker.get(SNIFF_COUNTER) % 20 == 0) System.out.println("sniff == " + this.dataTracker.get(SNIFF_COUNTER) / 20);

                if(this.dataTracker.get(SNIFF_COUNTER) == 0) {
                    playSound(DeeperDarkerSounds.SCULK_SNAPPER_SNIFF, 1.0f, 1.0f);
                    this.idleState.stop();
                    this.sniffState.start(this.age);
                }

                if(this.dataTracker.get(SNIFF_COUNTER) < -31) {
                    this.dataTracker.set(SNIFF_COUNTER, getRandom().nextBetween(180, 400));
                    if (findTarget()) {
                        System.out.println(targetPos);
                        this.digState.start(this.age);
                    }
                }
            }
        }
    }

    private boolean findTarget() {
        PlayerEntity target = getWorld().getClosestPlayer(this, 30);
        if (target == null || target.isDead() || target.isCreative()) {
            return false;
        }

        setTarget(target);
        Vec3d lookAngle = getTarget().getRotationVector();
        this.targetPos = new BlockPos((int) (lookAngle.x * 2.5 + getTarget().getPos().x), (int) (lookAngle.y * 2.5 + getTarget().getPos().y), (int) (lookAngle.z * 2.5 + getTarget().getPos().z));
        return true;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == (byte)4) {
            this.idleState.stop();
            this.attackState.start(this.age);
        } else {
            super.handleStatus(status);
        }
    }

    @Override
    public EntityView method_48926() {
        return null;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
