package com.kyanite.deeperdarker.registry.entities.custom;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.miscellaneous.ActionAnimatedEntity;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.entities.custom.ai.CustomAttackAnimMelee;
import com.kyanite.deeperdarker.registry.particle.DDParticleUtils;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Arrays;
import java.util.List;

public class SculkSnapperEntity extends ActionAnimatedEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public static EntityState IDLE = new EntityState(true, new EntityAnimationHolder("idle", DDUtils.secondsToTicks(4), true, false));
    public static EntityState MOUTH_OPEN = new EntityState(true, new EntityAnimationHolder("openmouth", DDUtils.secondsToTicks(0.5f), false, true));
    public static EntityState SNIFF = new EntityState(true, new EntityAnimationHolder("sniff", DDUtils.secondsToTicks(1.5f), false, true));
    public static EntityState WALK = new EntityState(true, new EntityAnimationHolder("walk", DDUtils.secondsToTicks(1), true, false));

    public static EntityState DIG = new EntityState(true, new EntityAnimationHolder("dig", DDUtils.secondsToTicks(3), false, true));
    public static EntityState EMERGE = new EntityState(true, new EntityAnimationHolder("emerge", DDUtils.secondsToTicks(0.8f), false, true));

    private static final EntityDataAccessor<Integer> SNIFF_COUNTER = SynchedEntityData.defineId(SculkSnapperEntity.class, EntityDataSerializers.INT);
    private BlockPos TARGET_POS = null;

    public SculkSnapperEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void reassessTameGoals() {
        super.reassessTameGoals();
        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.3F, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(3, new CustomAttackAnimMelee(this, 0.4F, true, 12, 4, MOUTH_OPEN));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(9, new CustomAttackAnimMelee(this, 0.4F, true, 12, 4, MOUTH_OPEN));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.3F));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    public float getSpeed() {
        return isPerformingAction() ? 0 : super.getSpeed();
    }

    @Override
    public MobType getMobType() {
        return DDTypes.SCULK;
    }

    public static AttributeSupplier.Builder attributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.ATTACK_DAMAGE, 3);
    }

    public boolean isPerformingAction() {
        return this.getCurrentState() == DIG || this.getCurrentState() == EMERGE || this.getCurrentState() == MOUTH_OPEN || this.getCurrentState() == SNIFF;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return DDSounds.SCULK_SNAPPER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.SCULK_SNAPPER_AMBIENT;
    }

    @Override
    public void tick() {
        super.tick();

        if(this.isTame() && this.getOwner().distanceTo(this) < 13) {
            if(this.getRandom().nextInt(0, 1100) == 0) {
                List<Enchantment> enchantments = (List<Enchantment>) Registry.ENCHANTMENT_REGISTRY;
                int randomIndex = this.getRandom().nextInt(enchantments.size());
                Enchantment randomEnchantment = enchantments.get(randomIndex);
                EnchantmentInstance instance = new EnchantmentInstance(randomEnchantment, 1);
                ItemStack randomBook = EnchantedBookItem.createForEnchantment(instance);
                if(!randomBook.isEmpty()) {
                    ItemEntity itementity = new ItemEntity(this.level, this.blockPosition().getX(), this.blockPosition().getY(), this.blockPosition().getZ(), randomBook);
                    this.level.addFreshEntity(itementity);
                }
            }
        }

        if(!this.isTame()) {
            if(this.entityData.get(SNIFF_COUNTER) > 1) {
                this.entityData.set(SNIFF_COUNTER, this.entityData.get(SNIFF_COUNTER) - 1);
            } else {
                if(this.getCurrentState() != WALK) {
                    this.playSound(DDSounds.SCULK_SNAPPER_SNIFF, 0.5f, 0.75F);
                    this.setState(SNIFF);
                    this.entityData.set(SNIFF_COUNTER, getRandom().nextInt(150, 500));
                }
            }
        }
    }

    @Override
    @Nullable
    public boolean isInvulnerable() {
        if(this.getCurrentState() == DIG || this.getCurrentState() == EMERGE) return true;

        return super.isInvulnerable();
    }

    @Override
    @Nullable
    public boolean isInvulnerableTo(DamageSource pSource) {
        if(this.getCurrentState() == DIG || this.getCurrentState() == EMERGE) return true;

        return super.isInvulnerableTo(pSource);
    }

    @Override
    public int getTransitionTick(EntityState entityState) {
        return 4;
    }

    @Override
    public List<EntityState> createStates() {
        return Arrays.asList(IDLE, WALK, MOUTH_OPEN, SNIFF, DIG, EMERGE);
    }

    @Override
    @Nullable
    public EntityState getMovingState() {
        if(!isPerformingAction()) return WALK;
        else return null;
    }

    @Override
    @Nullable
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if(isFood(itemstack) && !this.isTame()) {
            this.usePlayerItem(pPlayer, pHand, itemstack);
            if(!this.level.isClientSide()) {
                this.tame(pPlayer);
                this.setOwnerUUID(pPlayer.getUUID());
                setTarget(null);
                DDParticleUtils.spawnHeartParticles(this, this.getRandom());
                this.level.broadcastEntityEvent(this, (byte) 244);
            }
        }

        if(!itemstack.getEnchantmentTags().isEmpty() && isTame() && this.getHealth() != this.getMaxHealth()) {
            this.usePlayerItem(pPlayer, pHand, itemstack);
            if(!this.level.isClientSide()) {
                this.heal(getMaxHealth());
                DDParticleUtils.spawnHeartParticles(this, this.getRandom());
                this.level.broadcastEntityEvent(this, (byte) 244);
            }
        }
        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if(pId == 244) {
            DDParticleUtils.spawnHeartParticles(this, this.getRandom());
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public void stateDone(EntityState entityState) {
        if(entityState.equals(WALK)) {
            setState(IDLE);
        } else if(entityState.equals(SNIFF)) {
            findTarget();
        } else if(entityState.equals(MOUTH_OPEN)) {
            if(this.getTarget() != null) this.doHurtTarget(this.getTarget());

            this.playSound(DDSounds.SCULK_SNAPPER_BITE, 0.6F, 0.8f);

            setState(IDLE);
        } else if(entityState.equals(DIG)) {
            if(TARGET_POS != null) {
                setPosRaw(TARGET_POS.above().getX(), TARGET_POS.above().getY(), TARGET_POS.above().getZ());
            }

            setState(EMERGE);
            TARGET_POS = null;
        } else if(entityState.equals(EMERGE)) {
            setState(IDLE);
        }
    }

    @Override
    public void stateTick(EntityState entityState) {
        if(entityState == DIG || entityState == EMERGE) {
            if(this.getAnimationTime() < 10) {
                playSound(this.getBlockStateOn().getSoundType().getHitSound());
                DDParticleUtils.clientDiggingParticles(this.getRandom(), this.getBlockStateOn(), this.blockPosition(), this.level);
            }
        }
    }

    public void digTo(BlockPos pos) {
        if(pos == null) {
            setState(IDLE);
            return;
        }
        this.setState(DIG);
        TARGET_POS = pos;
    }

    public void findTarget() {
        if(this.isTame()) {
            setState(IDLE);
            return;
        }

        Player player = getLevel().getNearestPlayer(this, 40);
        if(player == null || player.isDeadOrDying() || player.isCreative() || player.blockPosition() == null) {
            setState(IDLE);
            return;
        }

        setTarget(player);
        Vec3 lookAngle = getTarget().getLookAngle();
        if(lookAngle == null || getTarget().blockPosition() == null) {
            setState(IDLE);
            return;
        }
        BlockPos pos = new BlockPos(lookAngle.x * 2.5F + getTarget().position().x, lookAngle.y * 2.5F + getTarget().position().y, lookAngle.z * 2.5F + getTarget().position().z);
        digTo(pos);
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
        if(pStack.is(Items.NETHERITE_CHESTPLATE)) {
            return !pStack.getEnchantmentTags().isEmpty();
        }
        return false;
    }
}