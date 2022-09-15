package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.custom.ai.CustomAttackAnimMelee;
import com.kyanite.deeperdarker.registry.particle.DDParticleUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Arrays;
import java.util.List;

public class SculkWormEntity extends ActionAnimatedEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    private static final EntityDataAccessor<Integer> DESCEND_COUNTDOWN = SynchedEntityData.defineId(SculkWormEntity.class, EntityDataSerializers.INT);
    public static EntityState AWAKE = new EntityState(true, new EntityAnimationHolder("idle", DDUtils.secondsToTicks(4), true, false));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("emerge", DDUtils.secondsToTicks(4), false, true));
    public static EntityState DESCEND = new EntityState(true, new EntityAnimationHolder("descend", DDUtils.secondsToTicks(4), false, true));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("melee", DDUtils.secondsToTicks(1), false, true));

    public SculkWormEntity(EntityType<? extends ActionAnimatedEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 50F));
        this.goalSelector.addGoal(4, new CustomAttackAnimMelee(this, 0, true, 16, 55, ATTACK));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    public static AttributeSupplier.Builder attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 550).add(Attributes.ATTACK_KNOCKBACK, 0).add(Attributes.ATTACK_DAMAGE, 7);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public void knockback(double strength, double x, double z) {

    }

    @Override
    public List<EntityState> createStates() {
        return Arrays.asList(AWAKE, EMERGE, DESCEND, ATTACK);
    }

    @Override
    public EntityState getMovingState() {
        return null;
    }

    @Override
    public void stateTick(EntityState entityState) {
        if(entityState.equals(DESCEND) || entityState.equals(EMERGE)) {
            DDParticleUtils.clientDiggingParticles(this.getRandom(), this.getBlockStateOn(), this.blockPosition(), this.level);
        }
    }

    @Override
    public int getTransitionTick(EntityState entityState) {
        return 0;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getCurrentState().equals(AWAKE)) {
            if(getDescendTime() != 0) {
                setDescendTime(getDescendTime() - 1);
            } else {
                setDescendTime(1200);
                this.setState(DESCEND);
            }
        }
    }

    @Override
    public void stateDone(EntityState entityState) {
        if(EMERGE.equals(entityState)) {
            setState(AWAKE);
        } else if(DESCEND.equals(entityState)) {
            this.level.setBlock(this.getOnPos(), DDBlocks.INFESTED_SCULK.defaultBlockState(), 3);
            this.remove(RemovalReason.KILLED);
        } else if(ATTACK.equals(entityState)) {
            setState(AWAKE);
            if(this.getTarget() != null) {
                this.doHurtTarget(this.getTarget());
                if(this.getTarget() instanceof Player plr)
                    if(plr.totalExperience > 2)
                        plr.giveExperiencePoints(-2);
                    else plr.kill();
            }
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DESCEND_COUNTDOWN, 1200);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        pCompound.putInt("DescendTime", this.getDescendTime());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);

        this.setDescendTime(pCompound.getInt("DescendTime"));
    }


    public int getDescendTime() {
        return this.entityData.get(DESCEND_COUNTDOWN);
    }
    public void setDescendTime(int value) {
        this.entityData.set(DESCEND_COUNTDOWN, value);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SCULK_SHRIEKER_SHRIEK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SCULK_SENSOR_BREAK;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SCULK_BLOCK_CHARGE;
    }
}