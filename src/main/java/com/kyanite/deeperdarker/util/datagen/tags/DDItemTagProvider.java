package com.kyanite.deeperdarker.util.datagen.tags;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class DDItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public DDItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    public void add(TagKey<Item> tag, Block... blocks) {
        for (Block block: Arrays.stream(blocks).toList()) {
            getOrCreateTagBuilder(tag).setReplace(false).add(block.asItem());
        }
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        add(DDTags.Items.ECHO_LOGS, DDBlocks.ECHO_LOG, DDBlocks.ECHO_WOOD, DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.STRIPPED_ECHO_WOOD);
        add(DDTags.Items.BLOOMING_STEMS, DDBlocks.BLOOMING_STEM, DDBlocks.STRIPPED_BLOOMING_STEM);
        getOrCreateTagBuilder(DDTags.Items.DAMPENS_VIBRATIONS).add(DDItems.WARDEN_BOOTS);
        getOrCreateTagBuilder(DDTags.Items.AVOIDS_SNIFFING).add(DDItems.RESONARIUM_HELMET, DDItems.RESONARIUM_CHESTPLATE, DDItems.RESONARIUM_LEGGINGS, DDItems.RESONARIUM_BOOTS);

        add(ItemTags.PLANKS, DDBlocks.ECHO_PLANKS, DDBlocks.BLOOM_PLANKS);
        add(ItemTags.WOODEN_STAIRS, DDBlocks.ECHO_STAIRS, DDBlocks.BLOOM_STAIRS);
        add(ItemTags.WOODEN_SLABS, DDBlocks.ECHO_SLAB, DDBlocks.BLOOM_SLAB);
        add(ItemTags.WOODEN_FENCES, DDBlocks.ECHO_FENCE, DDBlocks.BLOOM_FENCE);
        add(ItemTags.FENCE_GATES, DDBlocks.ECHO_FENCE_GATE, DDBlocks.BLOOM_FENCE_GATE);
        add(ItemTags.WOODEN_DOORS, DDBlocks.ECHO_DOOR, DDBlocks.BLOOM_DOOR);
        add(ItemTags.WOODEN_TRAPDOORS, DDBlocks.ECHO_TRAPDOOR, DDBlocks.BLOOM_TRAPDOOR);
        add(ItemTags.WOODEN_PRESSURE_PLATES, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.BLOOM_PRESSURE_PLATE);
        add(ItemTags.WOODEN_BUTTONS, DDBlocks.ECHO_BUTTON, DDBlocks.BLOOM_BUTTON, DDBlocks.BLOOM_BUTTON);
        add(ItemTags.LEAVES, DDBlocks.ECHO_LEAVES);
        getOrCreateTagBuilder(ItemTags.SIGNS).setReplace(false).add(DDItems.ECHO_SIGN, DDItems.BLOOM_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).setReplace(false).add(DDItems.ECHO_HANGING_SIGN, DDItems.BLOOM_HANGING_SIGN);
        getOrCreateTagBuilder(ItemTags.BOATS).setReplace(false).add(DDItems.ECHO_BOAT, DDItems.BLOOM_BOAT);
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).setReplace(false).add(DDItems.ECHO_CHEST_BOAT, DDItems.BLOOM_CHEST_BOAT);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).setReplace(false).addTag(DDTags.Items.ECHO_LOGS).add(DDBlocks.BLOOMING_STEM.asItem()).add(DDBlocks.ENRICHED_ECHO_LOG.asItem());
        getOrCreateTagBuilder(ItemTags.SWORDS).setReplace(false).add(DDItems.WARDEN_SWORD, DDItems.RESONARIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).setReplace(false).add(DDItems.WARDEN_PICKAXE, DDItems.RESONARIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).setReplace(false).add(DDItems.WARDEN_AXE, DDItems.RESONARIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).setReplace(false).add(DDItems.WARDEN_SHOVEL, DDItems.RESONARIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).setReplace(false).add(DDItems.WARDEN_HOE, DDItems.RESONARIUM_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).setReplace(false).add(
                DDItems.RESONARIUM_HELMET,
                DDItems.RESONARIUM_CHESTPLATE,
                DDItems.RESONARIUM_LEGGINGS,
                DDItems.RESONARIUM_BOOTS,
                DDItems.WARDEN_HELMET,
                DDItems.WARDEN_CHESTPLATE,
                DDItems.WARDEN_LEGGINGS,
                DDItems.WARDEN_BOOTS
        );

        add(ItemTags.WALLS,
                DDBlocks.SCULK_STONE_WALL,
                DDBlocks.COBBLED_SCULK_STONE_WALL,
                DDBlocks.POLISHED_SCULK_STONE_WALL,
                DDBlocks.SCULK_STONE_BRICK_WALL,
                DDBlocks.SCULK_STONE_TILE_WALL,
                DDBlocks.SMOOTH_SCULK_STONE_WALL,
                DDBlocks.CUT_SCULK_STONE_WALL,
                DDBlocks.SCULK_GRIME_BRICK_WALL,
                DDBlocks.GLOOMSLATE_WALL,
                DDBlocks.COBBLED_GLOOMSLATE_WALL,
                DDBlocks.POLISHED_GLOOMSLATE_WALL,
                DDBlocks.GLOOMSLATE_BRICK_WALL,
                DDBlocks.GLOOMSLATE_TILE_WALL,
                DDBlocks.SMOOTH_GLOOMSLATE_WALL,
                DDBlocks.CUT_GLOOMSLATE_WALL
        );

        add(ItemTags.STAIRS,
                DDBlocks.SCULK_STONE_STAIRS,
                DDBlocks.COBBLED_SCULK_STONE_STAIRS,
                DDBlocks.POLISHED_SCULK_STONE_STAIRS,
                DDBlocks.SCULK_STONE_BRICK_STAIRS,
                DDBlocks.SCULK_STONE_TILE_STAIRS,
                DDBlocks.SMOOTH_SCULK_STONE_STAIRS,
                DDBlocks.CUT_SCULK_STONE_STAIRS,
                DDBlocks.SCULK_GRIME_BRICK_STAIRS,
                DDBlocks.GLOOMSLATE_STAIRS,
                DDBlocks.COBBLED_GLOOMSLATE_STAIRS,
                DDBlocks.POLISHED_GLOOMSLATE_STAIRS,
                DDBlocks.GLOOMSLATE_BRICK_STAIRS,
                DDBlocks.GLOOMSLATE_TILE_STAIRS,
                DDBlocks.SMOOTH_GLOOMSLATE_STAIRS,
                DDBlocks.CUT_GLOOMSLATE_STAIRS
        );

        add(ItemTags.SLABS,
                DDBlocks.SCULK_STONE_SLAB,
                DDBlocks.COBBLED_SCULK_STONE_SLAB,
                DDBlocks.POLISHED_SCULK_STONE_SLAB,
                DDBlocks.SCULK_STONE_BRICK_SLAB,
                DDBlocks.SCULK_STONE_TILE_SLAB,
                DDBlocks.SMOOTH_SCULK_STONE_SLAB,
                DDBlocks.CUT_SCULK_STONE_SLAB,
                DDBlocks.SCULK_GRIME_BRICK_SLAB,
                DDBlocks.GLOOMSLATE_SLAB,
                DDBlocks.COBBLED_GLOOMSLATE_SLAB,
                DDBlocks.POLISHED_GLOOMSLATE_SLAB,
                DDBlocks.GLOOMSLATE_BRICK_SLAB,
                DDBlocks.GLOOMSLATE_TILE_SLAB,
                DDBlocks.SMOOTH_GLOOMSLATE_SLAB,
                DDBlocks.CUT_GLOOMSLATE_SLAB
        );

        add(ItemTags.COAL_ORES, DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.GLOOMSLATE_COAL_ORE);
        add(ItemTags.IRON_ORES, DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.GLOOMSLATE_IRON_ORE);
        add(ItemTags.COPPER_ORES, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE);
        add(ItemTags.GOLD_ORES, DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE);
        add(ItemTags.REDSTONE_ORES, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        add(ItemTags.EMERALD_ORES, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE);
        add(ItemTags.LAPIS_ORES, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE);
        add(ItemTags.DIAMOND_ORES, DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);

        add(ItemTags.SAPLINGS, DDBlocks.ECHO_SAPLING);
    }
}