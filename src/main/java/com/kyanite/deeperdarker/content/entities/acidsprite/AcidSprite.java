package com.kyanite.deeperdarker.content.entities.acidsprite;

import com.google.common.collect.Sets;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.entities.Bubblox;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.HashSet;

public class AcidSprite extends Monster implements Merchant {
    @Nullable
    private Player tradingPlayer = null;
    @Nullable
    protected MerchantOffers offers;

    public final AnimationState idleAnimationState = new AnimationState();

    public AcidSprite(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AcidSpriteTradeWithPlayerGoal(this));
        this.goalSelector.addGoal(2, new AcidSpriteLookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5f));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.7));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 5));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true, entity -> !isFriendlyPlayer(entity)));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 5).add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.KNOCKBACK_RESISTANCE, -1.0).add(Attributes.MOVEMENT_SPEED, 0.5).build();
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        spawnGroupData = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        float f = difficultyInstance.getSpecialMultiplier();
        if (this.random.nextFloat() < f * 0.2f) {
            this.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(new AttributeModifier("Acid sprite bonus", this.random.nextDouble() + 1.0, AttributeModifier.Operation.MULTIPLY_TOTAL));
            this.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(new AttributeModifier("Acid sprite debuff", -this.random.nextDouble() * 0.1, AttributeModifier.Operation.ADDITION));
        } else if (this.random.nextFloat() < 0.5f - f * 0.25) {
            this.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(new AttributeModifier("Acid sprite debuff", 0.0, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return spawnGroupData;
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!walkAnimation.isMoving(), this.tickCount);
        }
        if (deeperdarker$isInAcid() && !isDeadOrDying() && !hasCustomName()) {
            discard();
            Bubblox bubblox = new Bubblox(level(), getX(), getY(), getZ());
            bubblox.setSize((byte) getRandom().nextIntBetweenInclusive(0, 2));
            level().addFreshEntity(bubblox);
        }
        super.tick();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        MerchantOffers merchantOffers = this.getOffers();
        if (!merchantOffers.isEmpty()) {
            compoundTag.put("offers", merchantOffers.createTag());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("offers", CompoundTag.TAG_COMPOUND)) {
            offers = new MerchantOffers(compoundTag.getCompound("offers"));
        }
    }

    @Override
    public boolean isSensitiveToWater() {
        return true;
    }

    @Override
    @Nullable
    public Entity changeDimension(ServerLevel serverLevel) {
        stopTrading();
        return super.changeDimension(serverLevel);
    }

    protected void stopTrading() {
        this.setTradingPlayer(null);
    }

    @Override
    public void die(DamageSource damageSource) {
        super.die(damageSource);
        stopTrading();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!itemStack.is(DDItems.ACID_SPRITE_SPAWN_EGG) && isAlive() && !isTrading() && isFriendlyPlayer(player)) {
            if (getOffers().isEmpty()) {
                return InteractionResult.sidedSuccess(level().isClientSide());
            }
            if (!level().isClientSide()) {
                setTradingPlayer(player);
                openTradingScreen(player, getDisplayName(), 1);
            }
            return InteractionResult.sidedSuccess(level().isClientSide());
        }
        return super.mobInteract(player, interactionHand);
    }

    public boolean isFriendlyPlayer(LivingEntity entity) {
        if (!(entity instanceof Player)) return false;
        for (ItemStack stack : entity.getArmorSlots()) {
            if (!stack.is(DDTags.Items.ALLOWS_ACID_SPRITE_TRADES)) return false;
        }
        return true;
    }

    @Override
    public void setTradingPlayer(@Nullable Player player) {
        if (player == null) {
            tradingPlayer = null;
            return;
        }
        if (!isFriendlyPlayer(player)) return;
        tradingPlayer = player;
    }

    @Override
    public @Nullable Player getTradingPlayer() {
        return tradingPlayer;
    }

    public boolean isTrading() {
        return tradingPlayer != null;
    }

    @Override
    public MerchantOffers getOffers() {
        if (offers == null) {
            offers = new MerchantOffers();
            updateTrades();
        }
        return offers;
    }

    protected void updateTrades() {
        VillagerTrades.ItemListing[] itemListings = AcidSpriteTrades.TRADES.get(1);
        VillagerTrades.ItemListing[] itemListings2 = AcidSpriteTrades.TRADES.get(2);
        if (itemListings == null || itemListings2 == null) {
            return;
        }
        MerchantOffers merchantOffers = getOffers();
        addOffersFromItemListings(merchantOffers, itemListings, 2);
        for (VillagerTrades.ItemListing itemListing : itemListings2) {
            MerchantOffer merchantOffer = itemListing.getOffer(this, random);
            if (merchantOffer != null) {
                merchantOffers.add(merchantOffer);
            }
        }
    }

    protected void addOffersFromItemListings(MerchantOffers merchantOffers, VillagerTrades.ItemListing[] itemListings, int i) {
        HashSet<Integer> set = Sets.newHashSet();
        if (itemListings.length > i) {
            while (set.size() < i) {
                set.add(getRandom().nextInt(itemListings.length));
            }
        } else {
            for (int j = 0; j < itemListings.length; ++j) {
                set.add(j);
            }
        }
        for (Integer integer : set) {
            VillagerTrades.ItemListing itemListing = itemListings[integer];
            MerchantOffer merchantOffer = itemListing.getOffer(this, getRandom());
            if (merchantOffer == null) continue;
            merchantOffers.add(merchantOffer);
        }
    }

    @Override
    public void overrideOffers(MerchantOffers merchantOffers) {
    }

    @Override
    public void notifyTrade(MerchantOffer merchantOffer) {
        merchantOffer.increaseUses();
    }

    @Override
    public void notifyTradeUpdated(ItemStack itemStack) {
    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int i) {
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.VILLAGER_YES; // todo: custom sound effect
    }

    @Override
    public boolean isClientSide() {
        return level().isClientSide();
    }

    public static class AcidSpriteTradeWithPlayerGoal extends Goal {
        private final AcidSprite mob;

        public AcidSpriteTradeWithPlayerGoal(AcidSprite acidSprite) {
            this.mob = acidSprite;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!this.mob.isAlive()) {
                return false;
            }
            if (this.mob.isInWater()) {
                return false;
            }
            if (!this.mob.onGround()) {
                return false;
            }
            if (this.mob.hurtMarked) {
                return false;
            }
            Player player = this.mob.getTradingPlayer();
            if (player == null) {
                return false;
            }
            if (this.mob.distanceToSqr(player) > 16.0) {
                return false;
            }
            return player.containerMenu != null;
        }

        @Override
        public void start() {
            this.mob.getNavigation().stop();
        }

        @Override
        public void stop() {
            this.mob.setTradingPlayer(null);
        }
    }

    public static class AcidSpriteLookAtTradingPlayerGoal extends LookAtPlayerGoal {
        private final AcidSprite acidSprite;

        public AcidSpriteLookAtTradingPlayerGoal(AcidSprite acidSprite) {
            super(acidSprite, Player.class, 8.0f);
            this.acidSprite = acidSprite;
        }

        @Override
        public boolean canUse() {
            if (this.acidSprite.isTrading()) {
                this.lookAt = this.acidSprite.getTradingPlayer();
                return true;
            }
            return false;
        }
    }
}
