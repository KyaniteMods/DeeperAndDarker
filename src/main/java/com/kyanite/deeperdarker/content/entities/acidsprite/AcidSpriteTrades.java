package com.kyanite.deeperdarker.content.entities.acidsprite;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public final class AcidSpriteTrades {
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> TRADES = new Int2ObjectOpenHashMap<>(
            ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                    new ItemStacksToItemStack(Items.QUARTZ, 8, new ItemStack(DDItems.FIZZ), 5, 1),
                    new ItemStacksToItemStack(Items.SHULKER_SHELL, 4, new ItemStack(DDItems.SHADOW_CRYSTAL), 5, 1),
                    new ItemStacksToItemStack(Items.BONE, 6, new ItemStack(DDItems.SCULK_BONE), 3, 1),
                    new ItemStacksToItemStack(DDItems.RADIOACTIVE_INGOT, 2, new ItemStack(Items.ECHO_SHARD), 3, 1)
            }, 2, new VillagerTrades.ItemListing[]{
                    new ItemStacksToItemStack(DDBlockItems.PATIENCE_SOUL, 1, DDItems.SOUL_CRYSTAL, 2, new ItemStack(DDItems.SHIELD_AUGMENT), 5, 2),
                    new ItemStacksToItemStack(DDBlockItems.FORTITUDE_SOUL, 1, DDItems.SOUL_CRYSTAL, 2, new ItemStack(DDItems.SHIELD_AUGMENT), 5, 2),
                    new ItemStacksToItemStack(DDBlockItems.CORRUPTION_SOUL, 1, DDItems.SOUL_CRYSTAL, 2, new ItemStack(DDItems.SHIELD_AUGMENT), 5, 2)
            }));

    public static class ItemStacksToItemStack implements VillagerTrades.ItemListing {
        private final ItemLike fromItem;
        private final int fromItemCost;
        private final Optional<ItemLike> fromItem2;
        private final int fromItem2Cost;
        private final ItemStack toItem;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public ItemStacksToItemStack(ItemLike fromItem, int fromItemCost, ItemStack toItem, int maxUses, int villagerXp) {
            this(fromItem, fromItemCost, Optional.empty(), 0, toItem, maxUses, villagerXp);
        }

        public ItemStacksToItemStack(ItemLike fromItem, int fromItemCost, ItemLike fromItem2, int fromItem2Cost, ItemStack toItem, int maxUses, int villagerXp) {
            this(fromItem, fromItemCost, Optional.of(fromItem2), fromItem2Cost, toItem, maxUses, villagerXp);
        }

        public ItemStacksToItemStack(ItemLike fromItem, int fromItemCost, Optional<ItemLike> fromItem2, int fromItem2Cost, ItemStack toItem, int maxUses, int villagerXp) {
            this.fromItem = fromItem;
            this.fromItemCost = fromItemCost;
            this.fromItem2 = fromItem2;
            this.fromItem2Cost = fromItem2Cost;
            this.toItem = toItem;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
            this.priceMultiplier = 0.05f;
        }

        @Override
        @Nullable
        public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
            return new MerchantOffer(new ItemCost(fromItem, fromItemCost), fromItem2.map(itemLike -> new ItemCost(itemLike, fromItem2Cost)), toItem.copy(), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }
}
