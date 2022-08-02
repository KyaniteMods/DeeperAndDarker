package com.kyanite.deeperdarker.registry.entities.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.api.ActionAnimatedEntity;
import com.kyanite.deeperdarker.api.EntityAnimationHolder;
import com.kyanite.deeperdarker.api.EntityState;
import com.kyanite.deeperdarker.registry.entities.custom.ai.SculkSnapperMelee;
import com.kyanite.deeperdarker.util.DDParticleUtils;
import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class SculkSnapperEntity extends ActionAnimatedEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("idle", 80, true, false));
    public static EntityState MOUTH_OPEN = new EntityState(true, new EntityAnimationHolder("openmouth", 10, false, true));
    public static EntityState SNIFF = new EntityState(true, new EntityAnimationHolder("sniff", 30, false, true));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("walk", 20, true, false));

    public static EntityState DIG = new EntityState(true, new EntityAnimationHolder("dig", 60, false, true));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("emerge", 14, false, true));

    private static final EntityDataAccessor<Integer> SNIFF_COUNTER = SynchedEntityData.defineId(SculkSnapperEntity.class, EntityDataSerializers.INT);
    private static BlockPos TARGET_POS = null;

    public SculkSnapperEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 17F));
        this.goalSelector.addGoal(9, new SculkSnapperMelee(this, 0.3F, false));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.3F));
    }

    public static AttributeSupplier attributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_DAMAGE, 3).build();
    }

    @Override
    public void tick() {
        super.tick();

        if(this.entityData.get(SNIFF_COUNTER) > 1)
        {
            this.entityData.set(SNIFF_COUNTER, this.entityData.get(SNIFF_COUNTER) - 1);
        }else{
            if(this.getCurrentState() != WALK)
            {
                this.setState(SNIFF);
                this.entityData.set(SNIFF_COUNTER, getRandom().nextInt(150, 500));
            }
        }
    }

    @Override
    public boolean isInvulnerable() {
        if(this.getCurrentState() == DIG || this.getCurrentState() == EMERGE) return true;

        return super.isInvulnerable();
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        if(this.getCurrentState() == DIG || this.getCurrentState() == EMERGE) return true;
        
        return super.isInvulnerableTo(pSource);
    }

    @Override
    public List<EntityState> createStates() {
        return Arrays.asList(IDLE, WALK, MOUTH_OPEN, SNIFF, DIG, EMERGE);
    }

    @Override
    public EntityState getDefaultState() {
        return IDLE;
    }

    @Override
    public EntityState getMovingState() {
        if(this.getCurrentState() != SNIFF && this.getCurrentState() != MOUTH_OPEN && this.getCurrentState() != EMERGE && this.getCurrentState() != DIG)
            return WALK;
        else
            return null;
    }

    @Override
    public void stateDone(EntityState entityState) {
        if(entityState.equals(WALK))
        {
            setState(IDLE);
        }else if(entityState.equals(SNIFF))
        {
            findTarget();
        }else if(entityState.equals(MOUTH_OPEN))
        {
            if (this.getTarget() != null)
                this.doHurtTarget(this.getTarget());

            setState(IDLE);
        }else if(entityState.equals(DIG))
        {
            moveTo(TARGET_POS.above(), 0, 0);
            setState(EMERGE);
            TARGET_POS = null;
        }else if(entityState.equals(EMERGE))
        {
            this.lookControl.setLookAt(getTarget());
            setState(IDLE);
        }
    }

    @Override
    public void stateTick(EntityState entityState) {
        if(entityState == DIG || entityState == EMERGE) {
            if(this.getAnimationTime() < 10)
            {
                playSound(this.getBlockStateOn().getSoundType().getHitSound());
                DDParticleUtils.clientDiggingParticles(this.getRandom(), this.getBlockStateOn(), this.blockPosition(), this.level);
            }
        }
    }

    protected void findTarget() {
        Player player = getLevel().getNearestPlayer(this, 60);
        if(player == null || player.isDeadOrDying())
        {
            setState(IDLE);
            return;
        }

        setTarget(player);

        Vec3 lookAngle = getTarget().getLookAngle();
        BlockPos pos = new BlockPos(lookAngle.x * 2.5F + player.getX(), lookAngle.y * 2.5F + player.getY(), lookAngle.z * 2.5F + player.getZ());
        if(level.getBlockState(pos).is(Blocks.AIR) || level.getBlockState(pos.above()).is(Blocks.AIR)) {
            this.setState(DIG);
            TARGET_POS = pos;
        }else{
            setState(IDLE);
            return;
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SNIFF_COUNTER, getRandom().nextInt(150, 500));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("SniffCounter", this.entityData.get(SNIFF_COUNTER));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(SNIFF_COUNTER, pCompound.getInt("SniffCounter"));
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
    public boolean isFood(ItemStack pStack) {
        if(pStack.is(Items.DIAMOND_CHESTPLATE)) {
            if(!pStack.getAllEnchantments().isEmpty())
                return true;
        }
        return false;
    }
}
