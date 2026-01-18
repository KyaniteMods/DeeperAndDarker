package com.kyanite.deeperdarker.util.datagen.tags;

import com.kyanite.deeperdarker.compat.create.DDCreateCompat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DDBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public FabricTagProvider<Block>.FabricTagBuilder tagBuilder(TagKey<Block> tag) {
        return getOrCreateTagBuilder(tag).setReplace(false);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tagBuilder(BlockTags.MINEABLE_WITH_AXE).addTag(DDTags.Blocks.ECHO_LOGS).addTag(DDTags.Blocks.BLOOMING_STEMS).addTag(DDTags.Blocks.SCULK_SPRUCE_LOGS).add(
                DDBlocks.ECHO_PLANKS,
                DDBlocks.ECHO_STAIRS,
                DDBlocks.ECHO_SLAB,
                DDBlocks.ECHO_FENCE,
                DDBlocks.ECHO_FENCE_GATE,
                DDBlocks.ECHO_DOOR,
                DDBlocks.ECHO_TRAPDOOR,
                DDBlocks.ECHO_PRESSURE_PLATE,
                DDBlocks.ECHO_BUTTON,
                DDBlocks.BLOOMING_STEM,
                DDBlocks.STRIPPED_BLOOMING_STEM,
                DDBlocks.BLOOM_PLANKS,
                DDBlocks.BLOOM_STAIRS,
                DDBlocks.BLOOM_SLAB,
                DDBlocks.BLOOM_FENCE,
                DDBlocks.BLOOM_FENCE_GATE,
                DDBlocks.BLOOM_DOOR,
                DDBlocks.BLOOM_TRAPDOOR,
                DDBlocks.BLOOM_PRESSURE_PLATE,
                DDBlocks.BLOOM_BUTTON,
                DDBlocks.SCULK_SPRUCE_PLANKS,
                DDBlocks.SCULK_SPRUCE_STAIRS,
                DDBlocks.SCULK_SPRUCE_SLAB,
                DDBlocks.SCULK_SPRUCE_FENCE,
                DDBlocks.SCULK_SPRUCE_FENCE_GATE,
                DDBlocks.SCULK_SPRUCE_DOOR,
                DDBlocks.SCULK_SPRUCE_TRAPDOOR,
                DDBlocks.SCULK_SPRUCE_PRESSURE_PLATE,
                DDBlocks.SCULK_SPRUCE_BUTTON,
                DDBlocks.GLOWING_GRASS,
                DDBlocks.GLOOMY_GRASS,
                DDBlocks.ICE_LILY
        );
        tagBuilder(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.ECHO_LEAVES, DDBlocks.GLOOMY_SCULK, DDBlocks.GLOOMY_GEYSER, DDBlocks.SCULK_GLEAM, DDBlocks.GLOWING_FLOWERS, DDBlocks.SCULK_VINES, DDBlocks.SCULK_VINES_PLANT, DDBlocks.GLOWING_ROOTS, DDBlocks.GLOWING_ROOTS_PLANT, DDBlocks.GLOWING_VINES, DDBlocks.GLOWING_VINES_PLANT, DDBlocks.SCULK_TUBERS, DDBlocks.INFESTED_SCULK, DDBlocks.SCULK_JAW);
        tagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_TILES, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE, DDBlocks.CHISELED_SCULK_STONE,
                DDBlocks.SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_STAIRS,
                DDBlocks.SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_SLAB,
                DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE_WALL,
                DDBlocks.SNOWY_SCULK_STONE, DDBlocks.BLOOMING_SCULK_STONE, DDBlocks.BLOOMING_MOSS_BLOCK,
                DDBlocks.GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_TILES, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CHISELED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BARRIER,
                DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_STAIRS,
                DDBlocks.GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_SLAB,
                DDBlocks.GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE_WALL,
                DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICK_WALL,
                DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.SCULK_STONE_DIAMOND_ORE,
                DDBlocks.GLOOMSLATE_COAL_ORE, DDBlocks.GLOOMSLATE_IRON_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE,
                DDBlocks.CRYSTALLIZED_AMBER, DDBlocks.ANCIENT_VASE, DDBlocks.FRAGILE_SCULK_GRIME_BRICKS).addOptional(reverseLookup(DDCreateCompat.Blocks.WARDEN_BACKTANK));
        tagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(DDBlocks.ECHO_SOIL, DDBlocks.SCULK_GRIME);
        tagBuilder(BlockTags.NEEDS_STONE_TOOL).add(DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_IRON_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE, DDBlocks.CRYSTALLIZED_AMBER);
        tagBuilder(BlockTags.NEEDS_IRON_TOOL).add(DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);
        tagBuilder(BlockTags.SWORD_EFFICIENT).add(DDBlocks.GLOWING_GRASS, DDBlocks.GLOWING_FLOWERS, DDBlocks.GLOOMY_GRASS, DDBlocks.ICE_LILY, DDBlocks.SCULK_TUBERS, DDBlocks.SCULK_TISSUE, DDBlocks.DARK_FOUNTAIN);

        tagBuilder(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS).addTag(DDTags.Blocks.SCULK_SPRUCE_LOGS);
        tagBuilder(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS, DDBlocks.BLOOM_PLANKS, DDBlocks.SCULK_SPRUCE_PLANKS);
        tagBuilder(BlockTags.WOODEN_STAIRS).add(DDBlocks.ECHO_STAIRS, DDBlocks.BLOOM_STAIRS, DDBlocks.SCULK_SPRUCE_STAIRS);
        tagBuilder(BlockTags.WOODEN_SLABS).add(DDBlocks.ECHO_SLAB, DDBlocks.BLOOM_SLAB, DDBlocks.SCULK_SPRUCE_SLAB);
        tagBuilder(BlockTags.WOODEN_FENCES).add(DDBlocks.ECHO_FENCE, DDBlocks.BLOOM_FENCE, DDBlocks.SCULK_SPRUCE_FENCE);
        tagBuilder(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE, DDBlocks.BLOOM_FENCE_GATE, DDBlocks.SCULK_SPRUCE_FENCE_GATE);
        tagBuilder(BlockTags.WOODEN_DOORS).add(DDBlocks.ECHO_DOOR, DDBlocks.BLOOM_DOOR, DDBlocks.SCULK_SPRUCE_DOOR);
        tagBuilder(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.ECHO_TRAPDOOR, DDBlocks.BLOOM_TRAPDOOR, DDBlocks.SCULK_SPRUCE_TRAPDOOR);
        tagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.BLOOM_PRESSURE_PLATE, DDBlocks.SCULK_SPRUCE_PRESSURE_PLATE);
        tagBuilder(BlockTags.WOODEN_BUTTONS).add(DDBlocks.ECHO_BUTTON, DDBlocks.BLOOM_BUTTON, DDBlocks.SCULK_SPRUCE_BUTTON);
        tagBuilder(BlockTags.LEAVES).add(DDBlocks.ECHO_LEAVES, DDBlocks.SCULK_SPRUCE_LEAVES);
        tagBuilder(BlockTags.SAPLINGS).add(DDBlocks.ECHO_SAPLING, DDBlocks.SCULK_SPRUCE_SAPLING);
        tagBuilder(BlockTags.STANDING_SIGNS).add(DDBlocks.ECHO_SIGN, DDBlocks.BLOOM_SIGN, DDBlocks.SCULK_SPRUCE_SIGN);
        tagBuilder(BlockTags.WALL_SIGNS).add(DDBlocks.ECHO_WALL_SIGN, DDBlocks.BLOOM_WALL_SIGN, DDBlocks.SCULK_SPRUCE_WALL_SIGN);
        tagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(DDBlocks.ECHO_HANGING_SIGN, DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.SCULK_SPRUCE_HANGING_SIGN);
        tagBuilder(BlockTags.WALL_HANGING_SIGNS).add(DDBlocks.ECHO_WALL_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN, DDBlocks.SCULK_SPRUCE_WALL_HANGING_SIGN);
        tagBuilder(BlockTags.STAIRS).add(DDBlocks.SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.SCULK_GRIME_BRICK_STAIRS,
                DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_STAIRS);
        tagBuilder(BlockTags.SLABS).add(DDBlocks.SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.SCULK_GRIME_BRICK_SLAB,
                DDBlocks.GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_SLAB);
        tagBuilder(BlockTags.WALLS).add(DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE_WALL, DDBlocks.SCULK_GRIME_BRICK_WALL,
                DDBlocks.GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE_WALL);

        tagBuilder(BlockTags.COAL_ORES).add(DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.GLOOMSLATE_COAL_ORE);
        tagBuilder(BlockTags.IRON_ORES).add(DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.GLOOMSLATE_IRON_ORE);
        tagBuilder(BlockTags.COPPER_ORES).add(DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE);
        tagBuilder(BlockTags.GOLD_ORES).add(DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE);
        tagBuilder(BlockTags.REDSTONE_ORES).add(DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        tagBuilder(BlockTags.EMERALD_ORES).add(DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE);
        tagBuilder(BlockTags.LAPIS_ORES).add(DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE);
        tagBuilder(BlockTags.DIAMOND_ORES).add(DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);

        tagBuilder(BlockTags.FLOWER_POTS).add(DDBlocks.POTTED_ECHO_SAPLING, DDBlocks.POTTED_BLOOMING_STEM, DDBlocks.POTTED_SCULK_SPRUCE_SAPLING);
        tagBuilder(BlockTags.DIRT).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        tagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        tagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        tagBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(DDBlocks.BLOOMING_MOSS_BLOCK);
        tagBuilder(BlockTags.FLOWERS).add(DDBlocks.GLOWING_FLOWERS);
        tagBuilder(BlockTags.SMALL_FLOWERS).add(DDBlocks.LILY_FLOWER);
        tagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(DDBlocks.GLOWING_FLOWERS, DDBlocks.ICE_LILY);
        tagBuilder(BlockTags.CLIMBABLE).add(DDBlocks.SCULK_TENDRILS, DDBlocks.SCULK_TENDRILS_PLANT, DDBlocks.SCULK_VINES, DDBlocks.SCULK_VINES_PLANT, DDBlocks.GLOWING_VINES, DDBlocks.GLOWING_VINES_PLANT);
        tagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS).add(DDBlocks.SOUNDPROOF_GLASS, DDBlocks.PROTECTED_SCULK_GLEAM, DDBlocks.PROTECTED_SCULK_GRIME_GLASS);
        tagBuilder(BlockTags.PORTALS).add(DDBlocks.OTHERSIDE_PORTAL);

        tagBuilder(BlockTags.COAL_ORES).add(DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.GLOOMSLATE_COAL_ORE);
        tagBuilder(BlockTags.IRON_ORES).add(DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.GLOOMSLATE_IRON_ORE);
        tagBuilder(BlockTags.COPPER_ORES).add(DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.GLOOMSLATE_COPPER_ORE);
        tagBuilder(BlockTags.GOLD_ORES).add(DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.GLOOMSLATE_GOLD_ORE);
        tagBuilder(BlockTags.REDSTONE_ORES).add(DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        tagBuilder(BlockTags.EMERALD_ORES).add(DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.GLOOMSLATE_EMERALD_ORE);
        tagBuilder(BlockTags.LAPIS_ORES).add(DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.GLOOMSLATE_LAPIS_ORE);
        tagBuilder(BlockTags.DIAMOND_ORES).add(DDBlocks.SCULK_STONE_DIAMOND_ORE, DDBlocks.GLOOMSLATE_DIAMOND_ORE);

        tagBuilder(BlockTags.IMPERMEABLE).add(DDBlocks.SOUNDPROOF_GLASS, DDBlocks.SCULK_GRIME_GLASS, DDBlocks.PROTECTED_SCULK_GRIME_GLASS);
        tagBuilder(BlockTags.SNAPS_GOAT_HORN).add(DDBlocks.ECHO_LOG, DDBlocks.SCULK_SPRUCE_LOG);

        tagBuilder(DDTags.Blocks.ECHO_SOIL).add(DDBlocks.ECHO_SOIL, Blocks.SCULK);

        tagBuilder(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG, DDBlocks.ECHO_WOOD, DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.STRIPPED_ECHO_WOOD);
        tagBuilder(DDTags.Blocks.BLOOMING_STEMS).add(DDBlocks.BLOOMING_STEM, DDBlocks.STRIPPED_BLOOMING_STEM);
        tagBuilder(DDTags.Blocks.SCULK_SPRUCE_LOGS).add(DDBlocks.SCULK_SPRUCE_LOG, DDBlocks.SCULK_SPRUCE_WOOD, DDBlocks.STRIPPED_SCULK_SPRUCE_LOG, DDBlocks.STRIPPED_SCULK_SPRUCE_WOOD);

        tagBuilder(DDTags.Blocks.OTHERSIDE_CARVER_REPLACEABLES).add(Blocks.WATER, Blocks.DEEPSLATE, Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.SCULK_GRIME, DDBlocks.GLOOMSLATE, DDBlocks.GLOOMY_SCULK, DDBlocks.SNOWY_SCULK_STONE, DDBlocks.BLOOMING_SCULK_STONE, DDBlocks.BLOOMING_MOSS_BLOCK, DDBlocks.SCULK_TISSUE, DDBlocks.DARK_FOUNTAIN);
        tagBuilder(DDTags.Blocks.SCULK_STONE_REPLACEABLES).add(DDBlocks.SCULK_STONE, DDBlocks.SCULK_GRIME);
        tagBuilder(DDTags.Blocks.SCULK_REPLACEABLES).add(Blocks.SCULK, DDBlocks.SCULK_GRIME);
        tagBuilder(DDTags.Blocks.DEEPLANDS_COLUMN_REPLACEABLE).add(Blocks.SCULK, DDBlocks.INFESTED_SCULK);
        tagBuilder(DDTags.Blocks.DEEPLANDS_COLUMN_BASE).addOptionalTag(ConventionalBlockTags.ORES).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.SCULK_GRIME, DDBlocks.INFESTED_SCULK);

        tagBuilder(DDTags.Blocks.GLOOMSLATE_REPLACEABLE).add(DDBlocks.GLOOMY_SCULK, DDBlocks.GLOOMY_GEYSER);
        tagBuilder(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.GLOOMSLATE, DDBlocks.SCULK_GRIME, DDBlocks.ECHO_SOIL, DDBlocks.GLOOMY_SCULK);
        tagBuilder(DDTags.Blocks.OVERCAST_COLUMN_REPLACEABLE).add(DDBlocks.GLOOMY_SCULK, DDBlocks.GLOOMY_GEYSER);
        tagBuilder(DDTags.Blocks.OVERCAST_COLUMN_BASE).addOptionalTag(ConventionalBlockTags.ORES).add(Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, DDBlocks.GLOOMY_SCULK, DDBlocks.GLOOMSLATE);

        tagBuilder(DDTags.Blocks.BLOOMING_POOL_REPLACEABLE).add(DDBlocks.BLOOMING_SCULK_STONE, DDBlocks.BLOOMING_MOSS_BLOCK);
        tagBuilder(DDTags.Blocks.SCULK_VINE_PLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.ECHO_LEAVES);
        tagBuilder(DDTags.Blocks.GLOWING_VINE_PLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE);

        tagBuilder(DDTags.Blocks.SCULK_SPRUCE_FOREST_REPLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.SNOWY_SCULK_STONE, Blocks.DEEPSLATE);
        tagBuilder(DDTags.Blocks.ICE_REPLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE, DDBlocks.SNOWY_SCULK_STONE, Blocks.DEEPSLATE);
        tagBuilder(DDTags.Blocks.ICE_BASE).add(Blocks.PACKED_ICE, Blocks.BLUE_ICE);

        tagBuilder(DDTags.Blocks.DARK_FOUNTAIN_BEAM_PASSTHROUGH).add(DDBlocks.DARK_FOUNTAIN);

        tagBuilder(DDTags.Blocks.TRANSMITTABLE)
                .addOptionalTag(BlockTags.SHULKER_BOXES)
                .addOptionalTag(BlockTags.ANVIL)
                .addOptionalTag(ConventionalBlockTags.CHESTS)
                .addOptionalTag(ConventionalBlockTags.SHULKER_BOXES)
                .addOptionalTag(ConventionalBlockTags.WOODEN_BARRELS)
                .add(
                        Blocks.CRAFTING_TABLE,
                        Blocks.STONECUTTER,
                        Blocks.CARTOGRAPHY_TABLE,
                        Blocks.SMITHING_TABLE,
                        Blocks.GRINDSTONE,
                        Blocks.LOOM,
                        Blocks.FURNACE,
                        Blocks.SMOKER,
                        Blocks.BLAST_FURNACE,
                        Blocks.CHIPPED_ANVIL,
                        Blocks.ENCHANTING_TABLE,
                        Blocks.BREWING_STAND,
                        Blocks.BEACON,
                        Blocks.CHEST,
                        Blocks.BARREL,
                        Blocks.DISPENSER,
                        Blocks.DROPPER,
                        Blocks.HOPPER,
                        Blocks.TRAPPED_CHEST,
                        Blocks.DRAGON_EGG
                )
                .addOptional(new ResourceLocation("ironchest", "copper_chest"))
                .addOptional(new ResourceLocation("ironchest", "iron_chest"))
                .addOptional(new ResourceLocation("ironchest", "gold_chest"))
                .addOptional(new ResourceLocation("ironchest", "diamond_chest"))
                .addOptional(new ResourceLocation("ironchest", "emerald_chest"))
                .addOptional(new ResourceLocation("ironchest", "crystal_chest"))
                .addOptional(new ResourceLocation("ironchest", "obsidian_chest"))
                .addOptional(new ResourceLocation("ironchest", "netherite_chest"))
                .addOptional(new ResourceLocation("ironchest", "christmas_chest"))
                .addOptional(new ResourceLocation("toms_storage", "ts.storage_terminal"))
                .addOptional(new ResourceLocation("toms_storage", "ts.crafting_terminal"));
        tagBuilder(DDTags.Blocks.INFINIBURN_OTHERSIDE).addOptionalTag(BlockTags.INFINIBURN_NETHER).add(DDBlocks.GLOOMSLATE);

        tagBuilder(DDTags.Blocks.MAZE_CANNOT_HIDE_CHEST).add(Blocks.WATER);

        tagBuilder(ConventionalBlockTags.GLASS_BLOCKS).add(DDBlocks.SOUNDPROOF_GLASS, DDBlocks.SCULK_GRIME_GLASS, DDBlocks.PROTECTED_SCULK_GRIME_GLASS);
        tagBuilder(ConventionalBlockTags.GLASS_PANES).add(DDBlocks.SCULK_GRIME_GLASS_PANE);
    }
}