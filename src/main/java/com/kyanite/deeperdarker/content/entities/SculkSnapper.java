package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NullableProblems")
public class SculkSnapper extends TamableAnimal {
    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState sitState = new AnimationState();
    private int droppedBooks;

    public SculkSnapper(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.setTame(false, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1, true));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1, 8, 2));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.5));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 7));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier createAttributes() {
        return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 12).add(Attributes.ATTACK_DAMAGE, 3).add(Attributes.MOVEMENT_SPEED, 0.3).build();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DDSounds.SNAPPER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return DDSounds.SNAPPER_HURT.get();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(this.isInvulnerableTo(source)) return false;
        if(!this.level().isClientSide) {
            this.setInSittingPose(false);
            this.setOrderedToSit(false);
        }

        return super.hurt(source, amount);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        level().broadcastEntityEvent(this, (byte) 4);
        this.playSound(DDSounds.SNAPPER_BITE.get());
        return super.doHurtTarget(entity);
    }

    @Override
    public void tick() {
        super.tick();

        if(this.isTame() && this.getOwner() != null) {
            if(droppedBooks < DeeperDarkerConfig.snapperDropLimit && this.getOwner().distanceTo(this) < 5 && this.random.nextFloat() < 0.00025f) {
                Registry<Enchantment> registry = this.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
                List<Enchantment> enchantments = new ArrayList<>();
                registry.forEach(enchantment -> {
                    if(!enchantment.effects().has(EnchantmentEffectComponents.PREVENT_ARMOR_CHANGE) && !enchantment.effects().has(EnchantmentEffectComponents.PREVENT_EQUIPMENT_DROP)) enchantments.add(enchantment);
                });
                Enchantment enchantment1 = enchantments.remove(this.random.nextInt(enchantments.size()));
                Enchantment enchantment2 = enchantments.get(this.random.nextInt(enchantments.size()));

                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(registry.wrapAsHolder(enchantment1), this.random.nextInt(1, enchantment1.getMaxLevel() + 1)));
                if(this.random.nextFloat() < 0.2f) book.enchant(registry.wrapAsHolder(enchantment2), BiasedToBottomInt.of(1, enchantment2.getMaxLevel()).sample(this.random));
                this.level().addFreshEntity(new ItemEntity(this.level(), this.blockPosition().getX(), this.blockPosition().getY(), this.blockPosition().getZ(), book));
                droppedBooks++;
            }
        }

        if(level().isClientSide()) {
            if(this.isInSittingPose() && !this.sitState.isStarted()) {
                this.idleState.stop();
                this.sitState.start(this.tickCount);
            }
            if(!this.isInSittingPose() && this.sitState.isStarted()) {
                this.sitState.stop();
            }
            if(!this.idleState.isStarted() && !this.attackState.isStarted() && !this.sitState.isStarted()) {
                this.idleState.start(this.tickCount);
            }
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.NETHERITE_CHESTPLATE) && stack.has(DataComponents.ENCHANTMENTS);
    }

    @Override
    protected void applyTamingSideEffects() {
        if(this.isTame()) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(16);
            this.setHealth(16f);
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(this.isFood(stack) && !this.isTame()) {
            this.usePlayerItem(player, hand, stack);
            if(!level().isClientSide()) {
                this.tame(player);
                this.setOwnerUUID(player.getUUID());
                setTarget(null);
                level().broadcastEntityEvent(this, (byte) 18);
            }

            return InteractionResult.SUCCESS;
        }

        if(this.isTame()) {
            if(stack.has(DataComponents.ENCHANTMENTS) && this.getHealth() < this.getMaxHealth()) {
                this.usePlayerItem(player, hand, stack);
                if(!level().isClientSide()) {
                    this.heal(getMaxHealth());
                    this.gameEvent(GameEvent.EAT, this);
                }

                return InteractionResult.SUCCESS;
            }

            InteractionResult interact = super.mobInteract(player, hand);
            if (!interact.consumesAction() && this.isOwnedBy(player)) {
                this.setInSittingPose(!this.isInSittingPose());
                this.setOrderedToSit(!this.isOrderedToSit());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
                return InteractionResult.SUCCESS;
            } else {
                return interact;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id == 4) {
            this.idleState.stop();
            this.attackState.start(this.tickCount);
        } else if(id == 18) {
            for(int i = 0; i < 7; i++) {
                double sX = this.random.nextGaussian() * 0.02;
                double sY = this.random.nextGaussian() * 0.02;
                double sZ = this.random.nextGaussian() * 0.02;
                this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1), this.getRandomY() + 0.5, this.getRandomZ(1), sX, sY, sZ);
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }
}
