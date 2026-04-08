package com.kyanite.deeperdarker.util.datagen.tags;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class DDItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public DDItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    public FabricTagProvider<Item>.FabricTagBuilder add(TagKey<Item> tag, Block... blocks) {
        FabricTagBuilder builder = getOrCreateTagBuilder(tag).setReplace(false);
        for (Block block : blocks) {
            builder.add(block.asItem());
        }
        return builder;
    }

    public FabricTagProvider<Item>.FabricTagBuilder add(TagKey<Item> tag, Item... items) {
        FabricTagBuilder builder = getOrCreateTagBuilder(tag).setReplace(false);
        for (Item item : items) {
            builder.add(item);
        }
        return builder;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);

        copy(BlockTags.COAL_ORES, ItemTags.COAL_ORES);
        copy(BlockTags.IRON_ORES, ItemTags.IRON_ORES);
        copy(BlockTags.COPPER_ORES, ItemTags.COPPER_ORES);
        copy(BlockTags.GOLD_ORES, ItemTags.GOLD_ORES);
        copy(BlockTags.REDSTONE_ORES, ItemTags.REDSTONE_ORES);
        copy(BlockTags.EMERALD_ORES, ItemTags.EMERALD_ORES);
        copy(BlockTags.LAPIS_ORES, ItemTags.LAPIS_ORES);
        copy(BlockTags.DIAMOND_ORES, ItemTags.DIAMOND_ORES);

        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
        copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        copy(BlockTags.COAL_ORES, ItemTags.COAL_ORES);
        copy(BlockTags.IRON_ORES, ItemTags.IRON_ORES);
        copy(BlockTags.COPPER_ORES, ItemTags.COPPER_ORES);
        copy(BlockTags.GOLD_ORES, ItemTags.GOLD_ORES);
        copy(BlockTags.REDSTONE_ORES, ItemTags.REDSTONE_ORES);
        copy(BlockTags.EMERALD_ORES, ItemTags.EMERALD_ORES);
        copy(BlockTags.LAPIS_ORES, ItemTags.LAPIS_ORES);
        copy(BlockTags.DIAMOND_ORES, ItemTags.DIAMOND_ORES);

        add(ItemTags.BEACON_PAYMENT_ITEMS, DDItems.LEAD_INGOT, DDItems.RADIOACTIVE_INGOT);

        copy(DDTags.Blocks.ECHO_LOGS, DDTags.Items.ECHO_LOGS);
        copy(DDTags.Blocks.BLOOMING_STEMS, DDTags.Items.BLOOMING_STEMS);
        copy(DDTags.Blocks.SCULK_SPRUCE_LOGS, DDTags.Items.SCULK_SPRUCE_LOGS);

        add(ItemTags.BOATS, DDItems.ECHO_BOAT, DDItems.BLOOM_BOAT, DDItems.SCULK_SPRUCE_BOAT);
        add(ItemTags.CHEST_BOATS, DDItems.ECHO_CHEST_BOAT, DDItems.BLOOM_CHEST_BOAT, DDItems.SCULK_SPRUCE_CHEST_BOAT);
        add(ItemTags.CLUSTER_MAX_HARVESTABLES, DDItems.RESONARIUM_PICKAXE, DDItems.WARDEN_PICKAXE);
        add(ItemTags.SHOVELS, DDItems.RESONARIUM_SHOVEL, DDItems.WARDEN_SHOVEL);
        add(ItemTags.PICKAXES, DDItems.RESONARIUM_PICKAXE, DDItems.WARDEN_PICKAXE);
        add(ItemTags.AXES, DDItems.RESONARIUM_AXE, DDItems.WARDEN_AXE);
        add(ItemTags.HOES, DDItems.RESONARIUM_HOE, DDItems.WARDEN_HOE);
        add(ItemTags.SWORDS, DDItems.RESONARIUM_SWORD, DDItems.WARDEN_SWORD);

        add(ItemTags.PIGLIN_REPELLENTS, DDItems.SCULK_TORCH, DDBlocks.SCULK_CAMPFIRE.asItem(), DDBlocks.SCULK_LANTERN.asItem());

        add(DDTags.Items.RESONARIUM_ARMOR, DDItems.RESONARIUM_HELMET, DDItems.RESONARIUM_CHESTPLATE, DDItems.RESONARIUM_LEGGINGS, DDItems.RESONARIUM_BOOTS);
        add(DDTags.Items.DAMPENS_VIBRATIONS, DDItems.WARDEN_BOOTS);
        add(DDTags.Items.SCUTES, Items.SCUTE);
        add(DDTags.Items.PAINTINGS, Items.PAINTING);
        add(DDTags.Items.SCULK_TRANSMITTERS,
                DDItems.SCULK_TRANSMITTER,
                DDItems.WHITE_SCULK_TRANSMITTER,
                DDItems.ORANGE_SCULK_TRANSMITTER,
                DDItems.MAGENTA_SCULK_TRANSMITTER,
                DDItems.LIGHT_BLUE_SCULK_TRANSMITTER,
                DDItems.YELLOW_SCULK_TRANSMITTER,
                DDItems.LIME_SCULK_TRANSMITTER,
                DDItems.PINK_SCULK_TRANSMITTER,
                DDItems.GRAY_SCULK_TRANSMITTER,
                DDItems.LIGHT_GRAY_SCULK_TRANSMITTER,
                DDItems.CYAN_SCULK_TRANSMITTER,
                DDItems.PURPLE_SCULK_TRANSMITTER,
                DDItems.BLUE_SCULK_TRANSMITTER,
                DDItems.BROWN_SCULK_TRANSMITTER,
                DDItems.GREEN_SCULK_TRANSMITTER,
                DDItems.RED_SCULK_TRANSMITTER,
                DDItems.BLACK_SCULK_TRANSMITTER,
                DDItems.SUPER_SCULK_TRANSMITTER
        );
        add(DDTags.Items.UNLOCKS_SMALL_LOCK, DDItems.DAINTY_KEY);
        add(DDTags.Items.UNLOCKS_LARGE_LOCK, DDItems.KEYBRAND);
        add(DDTags.Items.FULLBRIGHT, DDItems.FIZZ);
        add(DDTags.Items.ACID_RESISTANT, DDItems.FIZZ);

        add(DDTags.Items.ACID_IMMUNE_ARMOR, DDItems.RADIOACTIVE_HELMET, DDItems.RADIOACTIVE_CHESTPLATE, DDItems.RADIOACTIVE_LEGGINGS, DDItems.RADIOACTIVE_BOOTS);
        add(DDTags.Items.ALLOWS_ACID_SPRITE_TRADES, DDItems.RADIOACTIVE_HELMET, DDItems.RADIOACTIVE_CHESTPLATE, DDItems.RADIOACTIVE_LEGGINGS, DDItems.RADIOACTIVE_BOOTS);
        add(DDTags.Items.SHIELD_AUGMENT_ITEMS, DDItems.PATIENCE_SOUL, DDItems.FORTITUDE_SOUL, DDItems.CORRUPTION_SOUL);

        add(ItemTags.NOTE_BLOCK_TOP_INSTRUMENTS, DDItems.SHATTERED_HEAD);

        add(ItemTags.TRIMMABLE_ARMOR, DDItems.WARDEN_HELMET, DDItems.WARDEN_CHESTPLATE, DDItems.WARDEN_LEGGINGS, DDItems.WARDEN_BOOTS, DDItems.RESONARIUM_HELMET, DDItems.RESONARIUM_CHESTPLATE, DDItems.RESONARIUM_LEGGINGS, DDItems.RESONARIUM_BOOTS, DDItems.LEAD_HELMET, DDItems.LEAD_CHESTPLATE, DDItems.LEAD_LEGGINGS, DDItems.LEAD_BOOTS, DDItems.LEAD_SWORD, DDItems.LEAD_PICKAXE, DDItems.LEAD_AXE, DDItems.LEAD_SHOVEL, DDItems.LEAD_HOE, DDItems.RADIOACTIVE_HELMET, DDItems.RADIOACTIVE_CHESTPLATE, DDItems.RADIOACTIVE_LEGGINGS, DDItems.RADIOACTIVE_BOOTS, DDItems.RADIOACTIVE_SWORD, DDItems.RADIOACTIVE_PICKAXE, DDItems.RADIOACTIVE_AXE, DDItems.RADIOACTIVE_SHOVEL, DDItems.RADIOACTIVE_HOE);

        add(ConventionalItemTags.FOODS, DDItems.BLOOM_BERRIES, DDItems.SCULK_TUBER, DDItems.SCULK_BERRY_SPROUT, DDItems.SCULK_BERRY);
        add(ConventionalItemTags.DUSTS, DDItems.SOUL_DUST);
        add(ConventionalItemTags.ORES, DDBlocks.LEAD_BLOCK);
        add(ConventionalItemTags.RAW_ORES, DDItems.RAW_LEAD);
        add(ConventionalItemTags.INGOTS, DDItems.LEAD_INGOT, DDItems.RADIOACTIVE_INGOT);
        add(ConventionalItemTags.CHESTS, DDBlocks.DEAD_MANS_CHEST.asItem());
    }
}