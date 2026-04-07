package com.kyanite.deeperdarker.content.entities.acidsprite;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

public final class AcidSpriteTrades {
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> TRADES = new Int2ObjectOpenHashMap<>(
            ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                    new ItemStacksToItemStack(new ItemStack(Items.QUARTZ, 8), new ItemStack(DDItems.FIZZ), 5, 1),
                    new ItemStacksToItemStack(new ItemStack(Items.SHULKER_SHELL, 4), new ItemStack(DDItems.SHADOW_CRYSTAL), 5, 1),
                    new ItemStacksToItemStack(new ItemStack(Items.BONE, 6), new ItemStack(DDItems.SCULK_BONE), 3, 1),
                    new ItemStacksToItemStack(new ItemStack(DDItems.HEART_OF_THE_DEEP), new ItemStack(DDItems.SOUL_CRYSTAL), 3, 2),
                    new ItemStacksToItemStack(new ItemStack(DDItems.RADIOACTIVE_INGOT, 2), new ItemStack(Items.ECHO_SHARD), 3, 1)
            }, 2, new VillagerTrades.ItemListing[]{
                    new VillagerTrades.ItemsForEmeralds(Items.TROPICAL_FISH_BUCKET, 5, 1, 4, 1),
                    new VillagerTrades.ItemsForEmeralds(Items.PUFFERFISH_BUCKET, 5, 1, 4, 1),
                    new VillagerTrades.ItemsForEmeralds(Items.PACKED_ICE, 3, 1, 6, 1),
                    new VillagerTrades.ItemsForEmeralds(Items.BLUE_ICE, 6, 1, 6, 1),
                    new VillagerTrades.ItemsForEmeralds(Items.GUNPOWDER, 1, 1, 8, 1),
                    new VillagerTrades.ItemsForEmeralds(Items.PODZOL, 3, 3, 6, 1)
            }));

    public static class ItemStacksToItemStack implements VillagerTrades.ItemListing {
        private final ItemStack fromItem;
        private final ItemStack fromItem2;
        private final ItemStack toItem;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public ItemStacksToItemStack(ItemStack fromItem, ItemStack toItem, int maxUses, int villagerXp) {
            this(fromItem, ItemStack.EMPTY, toItem, maxUses, villagerXp);
        }

        public ItemStacksToItemStack(ItemStack fromItem, ItemStack fromItem2, ItemStack toItem, int maxUses, int villagerXp) {
            this.fromItem = fromItem;
            this.fromItem2 = fromItem2;
            this.toItem = toItem;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
            this.priceMultiplier = 0.05f;
        }

        @Override
        @Nullable
        public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
            return new MerchantOffer(fromItem.copy(), fromItem2.copy(), toItem.copy(), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }
}
