package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
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
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SculkSnapperEntity extends TameableEntity {
    private static final TrackedData<Integer> SNIFF_COUNTER = DataTracker.registerData(SculkSnapperEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState sniffState = new AnimationState();
    public final AnimationState digState = new AnimationState();
    public final AnimationState emergeState = new AnimationState();
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

    @Override
    public EntityGroup getGroup() {
        return DeeperDarkerEntityGroups.SCULK;
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

        if (this.isTamed() && this.getOwner() != null) {
            if(this.getOwner().distanceTo(this) < 6 && this.random.nextFloat() < 0.0004f) {
                List<Enchantment> enchantments = new ArrayList<>();
                Registries.ENCHANTMENT.forEach(enchant -> {
                    if(!enchant.isCursed()) enchantments.add(enchant);
                });
                Enchantment enchantment1 = enchantments.remove(this.random.nextInt(enchantments.size()));
                Enchantment enchantment2 = enchantments.get(this.random.nextInt(enchantments.size()));

                ItemStack book = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment1, this.random.nextBetween(1, enchantment1.getMaxLevel() + 1)));
                if(this.random.nextFloat() < 0.2f) EnchantedBookItem.addEnchantment(book, new EnchantmentLevelEntry(enchantment2, 1));
                if(!book.isEmpty()) this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), book));
            }
        }

        if (getWorld().isClient()) {
            if (!this.attackState.isRunning() && !this.idleState.isRunning()) {
                this.idleState.start(this.age);
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
        } else if (status == 18) {
            for (int i = 0; i < 7; i++) {
                double sX = this.random.nextGaussian() * 0.02;
                double sY = this.random.nextGaussian() * 0.02;
                double sZ = this.random.nextGaussian() * 0.02;
                this.getWorld().addParticle(ParticleTypes.HEART, this.getParticleX(1), this.getRandomBodyY() + 0.5,
                        this.getParticleZ(1), sX, sY, sZ);
            }
        } else {
            super.handleStatus(status);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.NETHERITE_CHESTPLATE) && !stack.getEnchantments().isEmpty();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if(this.isBreedingItem(stack) && !this.isTamed()) {
            this.eat(player, hand, stack);
            if(!getWorld().isClient()) {
                this.setOwner(player);
                this.setOwnerUuid(player.getUuid());
                setTarget(null);
                getWorld().sendEntityStatus(this, (byte) 18);
            }

            return ActionResult.SUCCESS;
        }

        if(!stack.getEnchantments().isEmpty() && isTamed() && this.getHealth() < this.getMaxHealth()) {
            this.eat(player, hand, stack);
            if(!getWorld().isClient()) {
                this.heal(getMaxHealth());
                this.emitGameEvent(GameEvent.EAT, this);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
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
