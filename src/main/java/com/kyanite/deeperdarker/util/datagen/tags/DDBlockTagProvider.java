package com.kyanite.deeperdarker.util.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DDBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public FabricTagProvider<Block>.FabricTagBuilder add(TagKey<Block> tag, Block... blocks) {
        FabricTagBuilder builder = getOrCreateTagBuilder(tag).setReplace(false);
        for (Block block : blocks) {
            builder.add(block);
        }
        return builder;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        add(BlockTags.MINEABLE_WITH_AXE,
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
        ).addTag(DDTags.Blocks.ECHO_LOGS).addTag(DDTags.Blocks.BLOOMING_STEMS);

        add(BlockTags.MINEABLE_WITH_HOE,
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

        add(BlockTags.MINEABLE_WITH_PICKAXE, DDBlocks.SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_TILES, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE, DDBlocks.CHISELED_SCULK_STONE,
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
        add(BlockTags.SMALL_FLOWERS, DDBlocks.LILY_FLOWER);
        add(BlockTags.MINEABLE_WITH_SHOVEL, DDBlocks.ECHO_SOIL, DDBlocks.SCULK_GRIME);
        add(BlockTags.NEEDS_STONE_TOOL, DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_IRON_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE, DDBlocks.CRYSTALLIZED_AMBER);
        add(BlockTags.NEEDS_IRON_TOOL, DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);
        add(BlockTags.SWORD_EFFICIENT, DDBlocks.GLOWING_GRASS, DDBlocks.GLOWING_FLOWERS, DDBlocks.GLOOMY_GRASS, DDBlocks.ICE_LILY);

        add(BlockTags.LOGS_THAT_BURN, DDBlocks.BLOOMING_STEM, DDBlocks.ENRICHED_ECHO_LOG).addTag(DDTags.Blocks.ECHO_LOGS);
        add(BlockTags.PLANKS, DDBlocks.ECHO_PLANKS, DDBlocks.BLOOM_PLANKS);
        add(BlockTags.WOODEN_STAIRS, DDBlocks.ECHO_STAIRS, DDBlocks.BLOOM_STAIRS);
        add(BlockTags.WOODEN_SLABS, DDBlocks.ECHO_SLAB, DDBlocks.BLOOM_SLAB);
        add(BlockTags.WOODEN_FENCES, DDBlocks.ECHO_FENCE, DDBlocks.BLOOM_FENCE);
        add(BlockTags.FENCE_GATES, DDBlocks.ECHO_FENCE_GATE, DDBlocks.BLOOM_FENCE_GATE);
        add(BlockTags.WOODEN_DOORS, DDBlocks.ECHO_DOOR, DDBlocks.BLOOM_DOOR);
        add(BlockTags.WOODEN_TRAPDOORS, DDBlocks.ECHO_TRAPDOOR, DDBlocks.BLOOM_TRAPDOOR);
        add(BlockTags.WOODEN_PRESSURE_PLATES, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.BLOOM_PRESSURE_PLATE);
        add(BlockTags.WOODEN_BUTTONS, DDBlocks.ECHO_BUTTON, DDBlocks.BLOOM_BUTTON);
        add(BlockTags.LEAVES, DDBlocks.ECHO_LEAVES);
        add(BlockTags.SAPLINGS, DDBlocks.ECHO_SAPLING);
        add(BlockTags.STANDING_SIGNS, DDBlocks.ECHO_SIGN, DDBlocks.BLOOM_SIGN);
        add(BlockTags.WALL_SIGNS, DDBlocks.ECHO_WALL_SIGN, DDBlocks.BLOOM_WALL_SIGN);
        add(BlockTags.CEILING_HANGING_SIGNS, DDBlocks.ECHO_HANGING_SIGN, DDBlocks.BLOOM_HANGING_SIGN);
        add(BlockTags.WALL_HANGING_SIGNS, DDBlocks.ECHO_WALL_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN);
        add(BlockTags.FLOWER_POTS, DDBlocks.POTTED_ECHO_SAPLING, DDBlocks.POTTED_BLOOMING_STEM);

        add(BlockTags.STAIRS, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.SCULK_GRIME_BRICK_STAIRS,
                DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_STAIRS);
        add(BlockTags.SLABS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.SCULK_GRIME_BRICK_SLAB,
                DDBlocks.GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_SLAB);
        add(BlockTags.WALLS, DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE_WALL, DDBlocks.SCULK_GRIME_BRICK_WALL,
                DDBlocks.GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE_WALL);

        add(BlockTags.COAL_ORES, DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.GLOOMSLATE_COAL_ORE);
        add(BlockTags.IRON_ORES, DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.GLOOMSLATE_IRON_ORE);
        add(BlockTags.COPPER_ORES, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE);
        add(BlockTags.GOLD_ORES, DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE);
        add(BlockTags.REDSTONE_ORES, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        add(BlockTags.EMERALD_ORES, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE);
        add(BlockTags.LAPIS_ORES, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE);
        add(BlockTags.DIAMOND_ORES, DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);

        add(BlockTags.DIRT, DDBlocks.BLOOMING_MOSS_BLOCK);
        add(BlockTags.SMALL_DRIPLEAF_PLACEABLE, DDBlocks.BLOOMING_MOSS_BLOCK);
        add(BlockTags.SNIFFER_DIGGABLE_BLOCK, DDBlocks.BLOOMING_MOSS_BLOCK);
        add(BlockTags.SNIFFER_EGG_HATCH_BOOST, DDBlocks.BLOOMING_MOSS_BLOCK);
        add(BlockTags.FLOWERS, DDBlocks.GLOWING_FLOWERS);
        add(BlockTags.INSIDE_STEP_SOUND_BLOCKS, DDBlocks.GLOWING_FLOWERS);
        add(BlockTags.CLIMBABLE, DDBlocks.SCULK_TENDRILS, DDBlocks.SCULK_TENDRILS_PLANT, DDBlocks.SCULK_VINES, DDBlocks.SCULK_VINES_PLANT, DDBlocks.GLOWING_ROOTS, DDBlocks.GLOWING_ROOTS_PLANT, DDBlocks.GLOWING_VINES, DDBlocks.GLOWING_VINES_PLANT);
        add(BlockTags.PORTALS, DDBlocks.OTHERSIDE_PORTAL);
        add(BlockTags.OCCLUDES_VIBRATION_SIGNALS, DDBlocks.SOUNDPROOF_GLASS);
        add(BlockTags.IMPERMEABLE, DDBlocks.SOUNDPROOF_GLASS);

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
        getOrCreateTagBuilder(DDTags.Blocks.OTHERSIDE_CARVER_REPLACEABLES).add(Blocks.WATER, Blocks.DEEPSLATE, Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.SCULK_GRIME, DDBlocks.GLOOMSLATE, DDBlocks.GLOOMY_SCULK, DDBlocks.BLOOMING_SCULK_STONE, DDBlocks.BLOOMING_MOSS_BLOCK);

        add(ConventionalBlockTags.GLASS_BLOCKS, DDBlocks.SOUNDPROOF_GLASS);
    }
}