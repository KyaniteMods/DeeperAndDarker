package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagsProvider extends BlockTagsProvider {
    public DDBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_AXE).addTags(DDTags.Blocks.ECHO_LOGS, DDTags.Blocks.BLOOM_STEMS).add(DDBlocks.ECHO_PLANKS.get(), DDBlocks.ECHO_STAIRS.get(), DDBlocks.ECHO_SLAB.get(), DDBlocks.ECHO_FENCE.get(), DDBlocks.ECHO_FENCE_GATE.get(), DDBlocks.ECHO_DOOR.get(), DDBlocks.ECHO_TRAPDOOR.get(), DDBlocks.ECHO_PRESSURE_PLATE.get(), DDBlocks.ECHO_BUTTON.get(),
                DDBlocks.BLOOMING_STEM.get(), DDBlocks.STRIPPED_BLOOMING_STEM.get(), DDBlocks.BLOOM_PLANKS.get(), DDBlocks.BLOOM_STAIRS.get(), DDBlocks.BLOOM_SLAB.get(), DDBlocks.BLOOM_FENCE.get(), DDBlocks.BLOOM_FENCE_GATE.get(), DDBlocks.BLOOM_DOOR.get(), DDBlocks.BLOOM_TRAPDOOR.get(), DDBlocks.BLOOM_PRESSURE_PLATE.get(), DDBlocks.BLOOM_BUTTON.get(),
                DDBlocks.GLOWING_GRASS.get(), DDBlocks.GLOOMY_GRASS.get(), DDBlocks.ICE_LILY.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.ECHO_LEAVES.get(), DDBlocks.GLOOMY_SCULK.get(), DDBlocks.GLOOMY_GEYSER.get(), DDBlocks.SCULK_GLEAM.get(), DDBlocks.GLOWING_FLOWERS.get(), DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get(), DDBlocks.GLOWING_ROOTS.get(), DDBlocks.GLOWING_ROOTS_PLANT.get(), DDBlocks.GLOWING_VINES.get(), DDBlocks.GLOWING_VINES_PLANT.get(), DDBlocks.INFESTED_SCULK.get(), DDBlocks.SCULK_JAW.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_TILES.get(), DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE.get(), DDBlocks.CHISELED_SCULK_STONE.get(),
                DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get(), DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), DDBlocks.CUT_SCULK_STONE_STAIRS.get(),
                DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), DDBlocks.CUT_SCULK_STONE_SLAB.get(),
                DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_TILE_WALL.get(), DDBlocks.SMOOTH_SCULK_STONE_WALL.get(), DDBlocks.CUT_SCULK_STONE_WALL.get(),
                DDBlocks.BLOOMING_SCULK_STONE.get(), DDBlocks.BLOOMING_MOSS_BLOCK.get(),
                DDBlocks.GLOOMSLATE.get(), DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE.get(), DDBlocks.CHISELED_GLOOMSLATE.get(),
                DDBlocks.GLOOMSLATE_STAIRS.get(), DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), DDBlocks.CUT_GLOOMSLATE_STAIRS.get(),
                DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), DDBlocks.CUT_GLOOMSLATE_SLAB.get(),
                DDBlocks.GLOOMSLATE_WALL.get(), DDBlocks.COBBLED_GLOOMSLATE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(), DDBlocks.CUT_GLOOMSLATE_WALL.get(),
                DDBlocks.SCULK_GRIME_BRICKS.get(), DDBlocks.SCULK_GRIME_BRICK_STAIRS.get(), DDBlocks.SCULK_GRIME_BRICK_SLAB.get(), DDBlocks.SCULK_GRIME_BRICK_WALL.get(),
                DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get(),
                DDBlocks.GLOOMSLATE_COAL_ORE.get(), DDBlocks.GLOOMSLATE_IRON_ORE.get(), DDBlocks.GLOOMSLATE_COPPER_ORE.get(), DDBlocks.GLOOMSLATE_GOLD_ORE.get(), DDBlocks.GLOOMSLATE_REDSTONE_ORE.get(), DDBlocks.GLOOMSLATE_EMERALD_ORE.get(), DDBlocks.GLOOMSLATE_LAPIS_ORE.get(), DDBlocks.GLOOMSLATE_DIAMOND_ORE.get(),
                DDBlocks.CRYSTALLIZED_AMBER.get(), DDBlocks.ANCIENT_VASE.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(DDBlocks.ECHO_SOIL.get(), DDBlocks.SCULK_GRIME.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.GLOOMSLATE_IRON_ORE.get(), DDBlocks.GLOOMSLATE_COPPER_ORE.get(), DDBlocks.GLOOMSLATE_LAPIS_ORE.get(), DDBlocks.CRYSTALLIZED_AMBER.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), DDBlocks.GLOOMSLATE_GOLD_ORE.get(), DDBlocks.GLOOMSLATE_REDSTONE_ORE.get(), DDBlocks.GLOOMSLATE_EMERALD_ORE.get(), DDBlocks.GLOOMSLATE_DIAMOND_ORE.get());
        tag(BlockTags.SWORD_EFFICIENT).add(DDBlocks.GLOWING_GRASS.get(), DDBlocks.GLOWING_FLOWERS.get(), DDBlocks.GLOOMY_GRASS.get(), DDBlocks.ICE_LILY.get());

        tag(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS);
        tag(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS.get(), DDBlocks.BLOOM_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(DDBlocks.ECHO_STAIRS.get(), DDBlocks.BLOOM_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(DDBlocks.ECHO_SLAB.get(), DDBlocks.BLOOM_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(DDBlocks.ECHO_FENCE.get(), DDBlocks.BLOOM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE.get(), DDBlocks.BLOOM_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(DDBlocks.ECHO_DOOR.get(), DDBlocks.BLOOM_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.ECHO_TRAPDOOR.get(), DDBlocks.BLOOM_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.ECHO_PRESSURE_PLATE.get(), DDBlocks.BLOOM_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(DDBlocks.ECHO_BUTTON.get(), DDBlocks.BLOOM_BUTTON.get());
        tag(BlockTags.LEAVES).add(DDBlocks.ECHO_LEAVES.get());
        tag(BlockTags.SAPLINGS).add(DDBlocks.ECHO_SAPLING.get());
        tag(BlockTags.STANDING_SIGNS).add(DDBlocks.ECHO_SIGN.get(), DDBlocks.BLOOM_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DDBlocks.ECHO_WALL_SIGN.get(), DDBlocks.BLOOM_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(DDBlocks.ECHO_HANGING_SIGN.get(), DDBlocks.BLOOM_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(DDBlocks.ECHO_WALL_HANGING_SIGN.get(), DDBlocks.BLOOM_WALL_HANGING_SIGN.get());
        tag(BlockTags.STAIRS).add(DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get(), DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), DDBlocks.CUT_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_GRIME_BRICK_STAIRS.get(),
                DDBlocks.GLOOMSLATE_STAIRS.get(), DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), DDBlocks.CUT_GLOOMSLATE_STAIRS.get());
        tag(BlockTags.SLABS).add(DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), DDBlocks.CUT_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_GRIME_BRICK_SLAB.get(),
                DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), DDBlocks.CUT_GLOOMSLATE_SLAB.get());
        tag(BlockTags.WALLS).add(DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_TILE_WALL.get(), DDBlocks.SMOOTH_SCULK_STONE_WALL.get(), DDBlocks.CUT_SCULK_STONE_WALL.get(), DDBlocks.SCULK_GRIME_BRICK_WALL.get(),
                DDBlocks.GLOOMSLATE_WALL.get(), DDBlocks.COBBLED_GLOOMSLATE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(), DDBlocks.CUT_GLOOMSLATE_WALL.get());

        tag(BlockTags.COAL_ORES).add(DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.GLOOMSLATE_COAL_ORE.get());
        tag(BlockTags.IRON_ORES).add(DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.GLOOMSLATE_IRON_ORE.get());
        tag(BlockTags.COPPER_ORES).add(DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.GLOOMSLATE_COPPER_ORE.get());
        tag(BlockTags.GOLD_ORES).add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.GLOOMSLATE_GOLD_ORE.get());
        tag(BlockTags.REDSTONE_ORES).add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.GLOOMSLATE_REDSTONE_ORE.get());
        tag(BlockTags.EMERALD_ORES).add(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.GLOOMSLATE_EMERALD_ORE.get());
        tag(BlockTags.LAPIS_ORES).add(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.GLOOMSLATE_LAPIS_ORE.get());
        tag(BlockTags.DIAMOND_ORES).add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), DDBlocks.GLOOMSLATE_DIAMOND_ORE.get());

        tag(BlockTags.FLOWER_POTS).add(DDBlocks.POTTED_ECHO_SAPLING.get(), DDBlocks.POTTED_BLOOMING_STEM.get());
        tag(BlockTags.DIRT).add(DDBlocks.BLOOMING_MOSS_BLOCK.get());
        tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(DDBlocks.BLOOMING_MOSS_BLOCK.get());
        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(DDBlocks.BLOOMING_MOSS_BLOCK.get());
        tag(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(DDBlocks.BLOOMING_MOSS_BLOCK.get());
        tag(BlockTags.FLOWERS).add(DDBlocks.GLOWING_FLOWERS.get());
        tag(BlockTags.SMALL_FLOWERS).add(DDBlocks.LILY_FLOWER.get());
        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(DDBlocks.GLOWING_FLOWERS.get(), DDBlocks.ICE_LILY.get());
        tag(BlockTags.CLIMBABLE).add(DDBlocks.SCULK_TENDRILS.get(), DDBlocks.SCULK_TENDRILS_PLANT.get(), DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get(), DDBlocks.GLOWING_VINES.get(), DDBlocks.GLOWING_VINES_PLANT.get());
        tag(BlockTags.PORTALS).add(DDBlocks.OTHERSIDE_PORTAL.get());

        tag(Tags.Blocks.STONE).add(DDBlocks.SCULK_STONE.get(), DDBlocks.GLOOMSLATE.get());
        tag(Tags.Blocks.ORES).add(DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get(),
                DDBlocks.GLOOMSLATE_COAL_ORE.get(), DDBlocks.GLOOMSLATE_IRON_ORE.get(), DDBlocks.GLOOMSLATE_COPPER_ORE.get(), DDBlocks.GLOOMSLATE_GOLD_ORE.get(), DDBlocks.GLOOMSLATE_REDSTONE_ORE.get(), DDBlocks.GLOOMSLATE_EMERALD_ORE.get(), DDBlocks.GLOOMSLATE_LAPIS_ORE.get(), DDBlocks.GLOOMSLATE_DIAMOND_ORE.get());
        tag(Tags.Blocks.ORES_COAL).add(DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.GLOOMSLATE_COAL_ORE.get());
        tag(Tags.Blocks.ORES_IRON).add(DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.GLOOMSLATE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_COPPER).add(DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.GLOOMSLATE_COPPER_ORE.get());
        tag(Tags.Blocks.ORES_GOLD).add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.GLOOMSLATE_GOLD_ORE.get());
        tag(Tags.Blocks.ORES_REDSTONE).add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.GLOOMSLATE_REDSTONE_ORE.get());
        tag(Tags.Blocks.ORES_EMERALD).add(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.GLOOMSLATE_EMERALD_ORE.get());
        tag(Tags.Blocks.ORES_LAPIS).add(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.GLOOMSLATE_LAPIS_ORE.get());
        tag(Tags.Blocks.ORES_DIAMOND).add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), DDBlocks.GLOOMSLATE_DIAMOND_ORE.get());

        tag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG.get(), DDBlocks.ECHO_WOOD.get(), DDBlocks.STRIPPED_ECHO_LOG.get(), DDBlocks.STRIPPED_ECHO_WOOD.get());
        tag(DDTags.Blocks.BLOOM_STEMS).add(DDBlocks.BLOOMING_STEM.get(), DDBlocks.STRIPPED_BLOOMING_STEM.get());
        tag(DDTags.Blocks.SCULK_STONE_REPLACEABLES).add(DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_GRIME.get());
        tag(DDTags.Blocks.SCULK_REPLACEABLES).add(Blocks.SCULK, DDBlocks.SCULK_GRIME.get());
        tag(DDTags.Blocks.GLOOMSLATE_REPLACEABLE).add(DDBlocks.GLOOMY_SCULK.get(), DDBlocks.GLOOMY_GEYSER.get());
        tag(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE.get(), DDBlocks.GLOOMSLATE.get(), DDBlocks.SCULK_GRIME.get(), DDBlocks.ECHO_SOIL.get(), DDBlocks.GLOOMY_SCULK.get());
        tag(DDTags.Blocks.BLOOMING_POOL_REPLACEABLE).add(DDBlocks.BLOOMING_SCULK_STONE.get(), DDBlocks.BLOOMING_MOSS_BLOCK.get());
        tag(DDTags.Blocks.SCULK_VINE_PLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE.get(), DDBlocks.ECHO_LEAVES.get());
        tag(DDTags.Blocks.GLOWING_VINE_PLACEABLE).add(Blocks.SCULK, DDBlocks.SCULK_STONE.get());
        tag(DDTags.Blocks.TRANSMITTABLE).addTags(BlockTags.SHULKER_BOXES, BlockTags.ANVIL).add(Blocks.CRAFTING_TABLE, Blocks.STONECUTTER, Blocks.CARTOGRAPHY_TABLE, Blocks.SMITHING_TABLE, Blocks.GRINDSTONE, Blocks.LOOM, Blocks.FURNACE, Blocks.SMOKER, Blocks.BLAST_FURNACE, Blocks.CHIPPED_ANVIL, Blocks.ENCHANTING_TABLE, Blocks.BREWING_STAND, Blocks.BEACON, Blocks.CHEST, Blocks.BARREL, Blocks.DISPENSER, Blocks.DROPPER, Blocks.HOPPER, Blocks.TRAPPED_CHEST);
        tag(DDTags.Blocks.INFINIBURN_OTHERSIDE).addTag(BlockTags.INFINIBURN_NETHER).add(DDBlocks.GLOOMSLATE.get());
    }
}
