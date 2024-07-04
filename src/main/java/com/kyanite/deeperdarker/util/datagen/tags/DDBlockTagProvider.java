package com.kyanite.deeperdarker.util.datagen.tags;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DDBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .addTag(DDTags.Blocks.ECHO_LOGS)
                .addTag(DDTags.Blocks.BLOOMING_STEMS).add(
                        DDBlocks.ENRICHED_ECHO_LOG,
                        DDBlocks.ECHO_PLANKS,
                        DDBlocks.ECHO_STAIRS,
                        DDBlocks.ECHO_SLAB,
                        DDBlocks.ECHO_FENCE,
                        DDBlocks.ECHO_FENCE_GATE,
                        DDBlocks.ECHO_DOOR,
                        DDBlocks.ECHO_TRAPDOOR,
                        DDBlocks.ECHO_PRESSURE_PLATE,
                        DDBlocks.ECHO_BUTTON,

                        DDBlocks.BLOOM_PLANKS,
                        DDBlocks.BLOOM_PLANKS,
                        DDBlocks.BLOOM_STAIRS,
                        DDBlocks.BLOOM_FENCE,
                        DDBlocks.BLOOM_FENCE_GATE,
                        DDBlocks.BLOOM_DOOR,
                        DDBlocks.BLOOM_TRAPDOOR,
                        DDBlocks.BLOOM_PRESSURE_PLATE,
                        DDBlocks.BLOOM_BUTTON,

                        DDBlocks.GLOWING_GRASS,
                        DDBlocks.GLOOMY_GRASS
                );

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE).add(
                DDBlocks.ECHO_LEAVES,
                DDBlocks.GLOOMY_SCULK,
                DDBlocks.GLOOMY_GEYSER,
                DDBlocks.SCULK_GLEAM,
                DDBlocks.GLOWING_FLOWERS,
                DDBlocks.SCULK_VINES,
                DDBlocks.SCULK_VINES_PLANT,
                DDBlocks.GLOWING_ROOTS,
                DDBlocks.GLOWING_ROOTS_PLANT,
                DDBlocks.GLOWING_VINES,
                DDBlocks.GLOWING_VINES_PLANT,
                DDBlocks.INFESTED_SCULK,
                DDBlocks.SCULK_JAW
        );

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_TILES, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE, DDBlocks.CHISELED_SCULK_STONE,
                DDBlocks.SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_STAIRS,
                DDBlocks.SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_SLAB,
                DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE_WALL,
                DDBlocks.GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_TILES, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CHISELED_GLOOMSLATE,
                DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_STAIRS,
                DDBlocks.GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_SLAB,
                DDBlocks.GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE_WALL,
                DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICK_WALL,
                DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.SCULK_STONE_DIAMOND_ORE,
                DDBlocks.GLOOMSLATE_COAL_ORE, DDBlocks.GLOOMSLATE_IRON_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE,
                DDBlocks.CRYSTALLIZED_AMBER, DDBlocks.ANCIENT_VASE);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(DDBlocks.ECHO_SOIL, DDBlocks.SCULK_GRIME);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_IRON_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE, DDBlocks.CRYSTALLIZED_AMBER);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).add(DDBlocks.GLOWING_GRASS, DDBlocks.GLOWING_FLOWERS, DDBlocks.GLOOMY_GRASS, DDBlocks.ICE_LILY);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.BLOOMING_STEM).add(DDBlocks.ENRICHED_ECHO_LOG);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS, DDBlocks.BLOOM_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(DDBlocks.ECHO_STAIRS, DDBlocks.BLOOM_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(DDBlocks.ECHO_SLAB, DDBlocks.BLOOM_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(DDBlocks.ECHO_FENCE, DDBlocks.BLOOM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE, DDBlocks.BLOOM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(DDBlocks.ECHO_DOOR, DDBlocks.BLOOM_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.ECHO_TRAPDOOR, DDBlocks.BLOOM_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.BLOOM_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(DDBlocks.ECHO_BUTTON, DDBlocks.BLOOM_BUTTON);
        getOrCreateTagBuilder(BlockTags.LEAVES).add(DDBlocks.ECHO_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(DDBlocks.ECHO_SAPLING);
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(DDBlocks.ECHO_SIGN, DDBlocks.BLOOM_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(DDBlocks.ECHO_WALL_SIGN, DDBlocks.BLOOM_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(DDBlocks.ECHO_HANGING_SIGN, DDBlocks.BLOOM_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(DDBlocks.ECHO_WALL_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(DDBlocks.POTTED_ECHO_SAPLING, DDBlocks.POTTED_BLOOMING_STEM);

        getOrCreateTagBuilder(BlockTags.STAIRS).add(DDBlocks.SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.SCULK_GRIME_BRICK_STAIRS,
                DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(DDBlocks.SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.SCULK_GRIME_BRICK_SLAB,
                DDBlocks.GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS).add(DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE_WALL, DDBlocks.SCULK_GRIME_BRICK_WALL,
                DDBlocks.GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE_WALL);

        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.GLOOMSLATE_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.GLOOMSLATE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);

        getOrCreateTagBuilder(BlockTags.DIRT).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        getOrCreateTagBuilder(BlockTags.FLOWERS).add(DDBlocks.GLOWING_FLOWERS);
        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(DDBlocks.GLOWING_FLOWERS);
        getOrCreateTagBuilder(BlockTags.CLIMBABLE).add(DDBlocks.SCULK_TENDRILS, DDBlocks.SCULK_TENDRILS_PLANT, DDBlocks.SCULK_VINES, DDBlocks.SCULK_VINES_PLANT, DDBlocks.GLOWING_ROOTS, DDBlocks.GLOWING_ROOTS_PLANT, DDBlocks.GLOWING_VINES, DDBlocks.GLOWING_VINES_PLANT);
        getOrCreateTagBuilder(BlockTags.PORTALS).add(DDBlocks.OTHERSIDE_PORTAL);
        getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS).add(DDBlocks.SOUNDPROOF_GLASS);

        getOrCreateTagBuilder(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG, DDBlocks.ECHO_WOOD, DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.STRIPPED_ECHO_WOOD);
        getOrCreateTagBuilder(DDTags.Blocks.BLOOMING_STEMS).add(DDBlocks.BLOOMING_STEM, DDBlocks.STRIPPED_BLOOMING_STEM);
        getOrCreateTagBuilder(DDTags.Blocks.ECHO_SOIL).add(DDBlocks.ECHO_SOIL, Blocks.SCULK);
        getOrCreateTagBuilder(DDTags.Blocks.SCULK_STONE_REPLACEABLES).add(DDBlocks.SCULK_STONE, DDBlocks.SCULK_GRIME);
        getOrCreateTagBuilder(DDTags.Blocks.SCULK_REPLACEABLES).add(Blocks.SCULK, DDBlocks.SCULK_GRIME);
        getOrCreateTagBuilder(DDTags.Blocks.GLOOMSLATE_REPLACEABLE).add(DDBlocks.GLOOMY_SCULK, DDBlocks.GLOOMY_GEYSER);
        getOrCreateTagBuilder(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.GLOOMSLATE, DDBlocks.SCULK_GRIME, DDBlocks.ECHO_SOIL, DDBlocks.GLOOMY_SCULK);
        getOrCreateTagBuilder(DDTags.Blocks.BLOOMING_POOL_REPLACEABLE).add(DDBlocks.BLOOMING_SCULK_STONE, DDBlocks.BLOOMING_MOSS_BLOCK);
        getOrCreateTagBuilder(DDTags.Blocks.SCULK_VINE_PLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.ECHO_LEAVES);
        getOrCreateTagBuilder(DDTags.Blocks.GLOWING_VINE_PLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE);
        getOrCreateTagBuilder(DDTags.Blocks.TRANSMITTABLE).forceAddTag(BlockTags.SHULKER_BOXES).forceAddTag(BlockTags.ANVIL).add(Blocks.CRAFTING_TABLE, Blocks.STONECUTTER, Blocks.CARTOGRAPHY_TABLE, Blocks.SMITHING_TABLE, Blocks.GRINDSTONE, Blocks.LOOM, Blocks.FURNACE, Blocks.SMOKER, Blocks.BLAST_FURNACE, Blocks.ENCHANTING_TABLE, Blocks.BREWING_STAND, Blocks.BEACON, Blocks.CHEST, Blocks.BARREL, Blocks.DISPENSER, Blocks.DROPPER, Blocks.HOPPER, Blocks.TRAPPED_CHEST);

        getOrCreateTagBuilder(DDTags.Blocks.INFINIBURN_OTHERSIDE).forceAddTag(BlockTags.INFINIBURN_NETHER).add(DDBlocks.GLOOMSLATE);
    }
}