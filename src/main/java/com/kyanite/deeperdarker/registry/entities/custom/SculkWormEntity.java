package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.api.ActionAnimatedEntity;
import com.kyanite.deeperdarker.api.EntityAnimationHolder;
import com.kyanite.deeperdarker.api.EntityState;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.util.DDParticleUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Attr;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SculkWormEntity extends ActionAnimatedEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Integer> DESCEND_COUNTDOWN = SynchedEntityData.defineId(SculkWormEntity.class, EntityDataSerializers.INT);

    public static EntityState SLEEPING = new EntityState(true, new EntityAnimationHolder("asleep", 80, true));
    public static EntityState AWAKE = new EntityState(true, new EntityAnimationHolder("idle", 80, true));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("emerge",80, false));
    public static EntityState DESCEND = new EntityState(true, new EntityAnimationHolder("descend", 80, false));
    public static EntityState ATTACK = new EntityState(true, new EntityAnimationHolder("melee", 8, false));

    public SculkWormEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 50F));
        this.goalSelector.addGoal(4, new SculkWormAttack(this, 0, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    public static AttributeSupplier attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 550)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5f)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.MOVEMENT_SPEED, 0).build();
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
    public List<EntityState> createStates() {
        return Arrays.asList(SLEEPING, AWAKE, EMERGE, DESCEND, ATTACK);
    }

    @Override
    public void stateTick(EntityState entityState) {
        if(entityState.equals(this.AWAKE)) {
            if (getDescendTime() != 0) {
                setDescendTime(getDescendTime() - 1);
            } else {
                setDescendTime(1200);
                this.setState(DESCEND);
            }
        }
        if(entityState.equals(this.DESCEND) || entityState.equals(this.EMERGE)) {
            DDParticleUtils.clientDiggingParticles(this.getRandom(), this.getBlockStateOn(), this.blockPosition(), this.level);
        }
    }

    @Override
    public void stateDone(EntityState entityState) {
        if (EMERGE.equals(entityState)) {
            setState(AWAKE);
        }else if(DESCEND.equals(entityState)) {
            this.level.setBlock(this.getOnPos(), DDBlocks.INFESTED_SCULK.get().defaultBlockState(), 3);
            this.remove(RemovalReason.KILLED);
        }else if(ATTACK.equals(entityState)) {
            setState(AWAKE);
            if (this.getTarget() != null)
                this.doHurtTarget(this.getTarget());
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        setState(EMERGE);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
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
