package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.function.BiConsumer;

public class SculkWormEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(SculkWormEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DESCEND_COUNTDOWN = SynchedEntityData.defineId(SculkWormEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ANIMATION_TIME = SynchedEntityData.defineId(SculkWormEntity.class, EntityDataSerializers.INT);
    public SculkWormEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 5, this::predicate));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 50F));
        this.goalSelector.addGoal(4, new SculkWormAttack(this, 0, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.WARDEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WARDEN_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WARDEN_AMBIENT;
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
    public float getSpeed() {
        return 0;
    }

    public boolean removeWhenFarAway(double p_219457_) {
        return false;
    }

    public boolean checkSpawnObstruction(LevelReader p_219398_) {
        return false;
    }
    public float getWalkTargetValue(BlockPos p_219410_, LevelReader p_219411_) {
        return 0.0F;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    @Override
    public void knockback(double p_147241_, double p_147242_, double p_147243_) {

    }

    @Override
    public void tick() {
        super.tick();

        if(isDeadOrDying()) return;

        if(this.getState() == SculkWormState.AWAKE)
        {
            if(getDescendTime() != 0) {
                setDescendTime(getDescendTime() - 1);
            }else {
                setDescendTime(1200);
                this.setState(SculkWormState.DESCENDING);
            }
        }

        if(this.getState() == SculkWormState.DESCENDING)
        {
            setAnimationTime(getAnimationTime() + 1);
            clientDiggingParticles();
            if(getAnimationTime() > 85) {
                setAnimationTime(0);
                setDescendTime(0);
                this.level.setBlock(this.getOnPos(), DDBlocks.INFESTED_SCULK.get().defaultBlockState(), 3);
                this.remove(RemovalReason.KILLED);
            }
        }

        if(this.getState() == SculkWormState.EMERGING)
        {
            setAnimationTime(getAnimationTime() + 1);
            clientDiggingParticles();
            if(getAnimationTime() > 85) {
                setDescendTime(1200);
                setAnimationTime(0);
                this.setState(SculkWormState.AWAKE);
            }
        }

        if(this.getState() == SculkWormState.ATTACKING)
        {
            setAnimationTime(getAnimationTime() + 1);
            if(getAnimationTime() > 8) {
                setAnimationTime(0);
                this.setState(SculkWormState.AWAKE);
                if(this.getTarget() != null)
                    this.doHurtTarget(this.getTarget());
            }
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return super.isInvulnerableTo(pSource);
    }

    public static AttributeSupplier attributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 550)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5f)
                .add(Attributes.ATTACK_DAMAGE, 7).build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.getState().equals(SculkWormState.EMERGING)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("emerge", false));
            return PlayState.CONTINUE;
        }else if(this.getState().equals(SculkWormState.ATTACKING)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("melee", false));
            return PlayState.CONTINUE;
        }else if(this.getState().equals(SculkWormState.SLEEPING)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("asleep", true));
            return PlayState.CONTINUE;
        }else if(this.getState().equals(SculkWormState.DESCENDING)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("descend", false));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    private void clientDiggingParticles() {
        RandomSource randomsource = this.getRandom();
        BlockState blockstate = this.getBlockStateOn();
        if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            for (int i = 0; i < 30; ++i) {
                double d0 = this.getX() + (double) Mth.randomBetween(randomsource, -0.7F, 0.7F);
                double d1 = this.getY();
                double d2 = this.getZ() + (double) Mth.randomBetween(randomsource, -0.7F, 0.7F);
                this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DESCEND_COUNTDOWN, 1200);
        this.entityData.define(STATE, SculkWormState.SLEEPING.getValue());
        this.entityData.define(ANIMATION_TIME, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        pCompound.putInt("DescendTime", this.getDescendTime());
        pCompound.putInt("AnimationTime", this.getAnimationTime());
        pCompound.putInt("State", this.getState().getValue());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);

        this.setState(SculkWormState.values()[pCompound.getInt("State")]);
        this.setAnimationTime(pCompound.getInt("AnimationTime"));
        this.setDescendTime(pCompound.getInt("DescendTime"));
    }

    public SculkWormState getState() {
        return SculkWormState.values()[this.entityData.get(STATE)];
    }

    public void setState(SculkWormState state) {
        this.entityData.set(STATE, state.getValue());
    }

    public int getDescendTime() {
        return this.entityData.get(DESCEND_COUNTDOWN);
    }

    public void setDescendTime(int value) {
        this.entityData.set(DESCEND_COUNTDOWN, value);
    }

    public int getAnimationTime() {
        return this.entityData.get(ANIMATION_TIME);
    }

    public void setAnimationTime(int value) {
        this.entityData.set(ANIMATION_TIME, value);
    }

    public enum SculkWormState {
        SLEEPING(0),
        AWAKE(1),
        EMERGING(2),
        DESCENDING(3),
        ATTACKING(4);

        int value;
        SculkWormState(int x)
        {
            this.value = x;
        }
        public int getValue()
        {
            return value;
        }
    }
}