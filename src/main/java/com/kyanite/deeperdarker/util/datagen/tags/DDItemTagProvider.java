package com.kyanite.deeperdarker.util.datagen.tags;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
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

        copy(DDTags.Blocks.ECHO_LOGS, DDTags.Items.ECHO_LOGS);
        copy(DDTags.Blocks.BLOOMING_STEMS, DDTags.Items.BLOOMING_STEMS);

        add(ItemTags.BOATS, DDItems.ECHO_BOAT, DDItems.BLOOM_BOAT);
        add(ItemTags.CHEST_BOATS, DDItems.ECHO_CHEST_BOAT, DDItems.BLOOM_CHEST_BOAT);
        add(ItemTags.CLUSTER_MAX_HARVESTABLES, DDItems.RESONARIUM_PICKAXE, DDItems.WARDEN_PICKAXE);
        add(ItemTags.SHOVELS, DDItems.RESONARIUM_SHOVEL, DDItems.WARDEN_SHOVEL);
        add(ItemTags.PICKAXES, DDItems.RESONARIUM_PICKAXE, DDItems.WARDEN_PICKAXE);
        add(ItemTags.AXES, DDItems.RESONARIUM_AXE, DDItems.WARDEN_AXE);
        add(ItemTags.HOES, DDItems.RESONARIUM_HOE, DDItems.WARDEN_HOE);
        add(ItemTags.SWORDS, DDItems.RESONARIUM_SWORD, DDItems.WARDEN_SWORD);

        add(ItemTags.HEAD_ARMOR, DDItems.RESONARIUM_HELMET, DDItems.WARDEN_HELMET);
        add(ItemTags.CHEST_ARMOR, DDItems.RESONARIUM_CHESTPLATE, DDItems.WARDEN_CHESTPLATE);
        add(ItemTags.LEG_ARMOR, DDItems.RESONARIUM_LEGGINGS, DDItems.WARDEN_LEGGINGS);
        add(ItemTags.FOOT_ARMOR, DDItems.RESONARIUM_BOOTS, DDItems.WARDEN_BOOTS);
        add(ItemTags.DURABILITY_ENCHANTABLE, DDItems.SOUL_ELYTRA);
        add(ItemTags.EQUIPPABLE_ENCHANTABLE, DDItems.SOUL_ELYTRA);

        add(DDTags.Items.RESONARIUM_ARMOR, DDItems.RESONARIUM_HELMET, DDItems.RESONARIUM_CHESTPLATE, DDItems.RESONARIUM_LEGGINGS, DDItems.RESONARIUM_BOOTS);
        add(DDTags.Items.DAMPENS_VIBRATIONS, DDItems.WARDEN_BOOTS);
        add(DDTags.Items.SCUTES, Items.TURTLE_SCUTE, Items.ARMADILLO_SCUTE);

        copy(ConventionalBlockTags.STONES, ConventionalItemTags.STONES);
        copy(ConventionalBlockTags.COBBLESTONES, ConventionalItemTags.STONES);
        add(ConventionalItemTags.BERRIES_FOODS, DDItems.BLOOM_BERRIES);
        add(ConventionalItemTags.DUSTS, DDItems.SOUL_DUST);
    }
}