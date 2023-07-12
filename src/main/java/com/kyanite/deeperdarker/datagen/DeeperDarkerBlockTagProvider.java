package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.tags.DeeperDarkerTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DeeperDarkerBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DeeperDarkerBlockTagProvider(FabricDataOutput output,
                                        CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(DeeperDarkerTags.Blocks.ECHO_LOGS).add(DeeperDarkerBlocks.ECHO_LOG, DeeperDarkerBlocks.ECHO_WOOD, DeeperDarkerBlocks.STRIPPED_ECHO_LOG, DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);

        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).setReplace(false).add(DeeperDarkerBlocks.ECHO_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).setReplace(false).add(DeeperDarkerBlocks.ECHO_DOOR);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).setReplace(false).add(DeeperDarkerBlocks.ECHO_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).setReplace(false).add(DeeperDarkerBlocks.ECHO_FENCE);
        getOrCreateTagBuilder(BlockTags.LEAVES).setReplace(false).add(DeeperDarkerBlocks.ECHO_LEAVES);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).setReplace(false).addTag(DeeperDarkerTags.Blocks.ECHO_LOGS);
        getOrCreateTagBuilder(BlockTags.PLANKS).setReplace(false).add(DeeperDarkerBlocks.ECHO_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).setReplace(false).add(DeeperDarkerBlocks.ECHO_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).setReplace(false).add(DeeperDarkerBlocks.ECHO_STAIRS);
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).setReplace(false).add(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).setReplace(false).add(DeeperDarkerBlocks.ECHO_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE,
                DeeperDarkerBlocks.SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_SLAB,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_BRICKS,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_TILES,
                DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.CUT_SCULK_STONE,
                DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.CHISELED_SCULK_STONE,
                DeeperDarkerBlocks.SCULK_GRIME_BRICKS,
                DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS,
                DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB,
                DeeperDarkerBlocks.GLOOMSLATE,
                DeeperDarkerBlocks.GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.COBBLED_GLOOMSLATE,
                DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.POLISHED_GLOOMSLATE,
                DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.GLOOMSLATE_BRICKS,
                DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS,
                DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB,
                DeeperDarkerBlocks.GLOOMSLATE_TILES,
                DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS,
                DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB,
                DeeperDarkerBlocks.SMOOTH_GLOOMSLATE,
                DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.CUT_GLOOMSLATE,
                DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.CHISELED_GLOOMSLATE,
                DeeperDarkerBlocks.SCULK_STONE_COAL_ORE,
                DeeperDarkerBlocks.SCULK_STONE_IRON_ORE,
                DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE,
                DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE,
                DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE,
                DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE,
                DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE,
                DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE,
                DeeperDarkerBlocks.ANCIENT_VASE,
                DeeperDarkerBlocks.CRYSTALLIZED_AMBER
        );

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE_IRON_ORE,
                DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE,
                DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE,
                DeeperDarkerBlocks.CRYSTALLIZED_AMBER
        );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE,
                DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE,
                DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE,
                DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE
        );

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_GRIME,
                DeeperDarkerBlocks.ECHO_SOIL
        );

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).setReplace(false).add(
                DeeperDarkerBlocks.ECHO_LEAVES,
                DeeperDarkerBlocks.SCULK_GLEAM,
                DeeperDarkerBlocks.SCULK_VINES_PLANT,
                DeeperDarkerBlocks.SCULK_VINES
        );

        getOrCreateTagBuilder(BlockTags.WALLS).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE_WALL,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL,
                DeeperDarkerBlocks.SCULK_STONE_TILE_WALL,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL,
                DeeperDarkerBlocks.CUT_SCULK_STONE_WALL,
                DeeperDarkerBlocks.SCULK_GRIME_BRICK_WALL,
                DeeperDarkerBlocks.GLOOMSLATE_WALL,
                DeeperDarkerBlocks.COBBLED_GLOOMSLATE_WALL,
                DeeperDarkerBlocks.POLISHED_GLOOMSLATE_WALL,
                DeeperDarkerBlocks.GLOOMSLATE_BRICK_WALL,
                DeeperDarkerBlocks.GLOOMSLATE_TILE_WALL,
                DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_WALL,
                DeeperDarkerBlocks.CUT_GLOOMSLATE_WALL
        );

        getOrCreateTagBuilder(BlockTags.STAIRS).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS,
                DeeperDarkerBlocks.GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS,
                DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS,
                DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS,
                DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS
        );

        getOrCreateTagBuilder(BlockTags.SLABS).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE_SLAB,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB,
                DeeperDarkerBlocks.GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB,
                DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB,
                DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB,
                DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB
        );

        getOrCreateTagBuilder(BlockTags.COAL_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).setReplace(false).add(DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE);

        getOrCreateTagBuilder(BlockTags.CLIMBABLE).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_TENDRILS_PLANT,
                DeeperDarkerBlocks.SCULK_TENDRILS,
                DeeperDarkerBlocks.SCULK_VINES_PLANT,
                DeeperDarkerBlocks.SCULK_VINES
        );

        getOrCreateTagBuilder(DeeperDarkerTags.Blocks.GLOOMY_SCULK_REPLACEABLE).setReplace(false).add(
                Blocks.SCULK,
                DeeperDarkerBlocks.SCULK_STONE,
                DeeperDarkerBlocks.GLOOMSLATE,
                DeeperDarkerBlocks.ECHO_SOIL,
                DeeperDarkerBlocks.GLOOMY_SCULK
        );
    }
}