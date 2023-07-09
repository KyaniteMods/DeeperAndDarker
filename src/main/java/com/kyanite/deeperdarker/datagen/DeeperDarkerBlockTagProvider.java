package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DeeperDarkerBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DeeperDarkerBlockTagProvider(FabricDataOutput output,
                                        CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final TagKey<Block> ECHO_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "echo_logs"));

    private static final TagKey<Block> MINEABLE_PICKAXE = TagKey.of(RegistryKeys.BLOCK, new Identifier("mineable/pickaxe"));
    private static final TagKey<Block> CEILING_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("ceiling_hanging_signs"));
    private static final TagKey<Block> WOODEN_BUTTONS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_buttons"));
    private static final TagKey<Block> WOODEN_DOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_doors"));
    private static final TagKey<Block> FENCE_GATES = TagKey.of(RegistryKeys.BLOCK, new Identifier("fence_gates"));
    private static final TagKey<Block> WOODEN_FENCES = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_fences"));
    private static final TagKey<Block> LEAVES = TagKey.of(RegistryKeys.BLOCK, new Identifier("leaves"));
    private static final TagKey<Block> LOGS_THAT_BURN = TagKey.of(RegistryKeys.BLOCK, new Identifier("logs_that_burn"));
    private static final TagKey<Block> PLANKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("planks"));
    private static final TagKey<Block> WOODEN_SLABS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_slabs"));
    private static final TagKey<Block> WOODEN_STAIRS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_stairs"));
    private static final TagKey<Block> STANDING_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("standing_signs"));
    private static final TagKey<Block> WALL_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wall_hanging_signs"));
    private static final TagKey<Block> WALL_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wall_signs"));
    private static final TagKey<Block> WOODEN_PRESSURE_PLATES = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_pressure_plates"));
    private static final TagKey<Block> WOODEN_TRAPDOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_trapdoors"));
    private static final TagKey<Block> WALLS = TagKey.of(RegistryKeys.BLOCK, new Identifier("walls"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ECHO_LOGS).add(DeeperDarkerBlocks.ECHO_LOG, DeeperDarkerBlocks.ECHO_WOOD, DeeperDarkerBlocks.STRIPPED_ECHO_LOG, DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);

        getOrCreateTagBuilder(CEILING_HANGING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_HANGING_SIGN);
        getOrCreateTagBuilder(WALL_HANGING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(WOODEN_BUTTONS).setReplace(false).add(DeeperDarkerBlocks.ECHO_BUTTON);
        getOrCreateTagBuilder(WOODEN_DOORS).setReplace(false).add(DeeperDarkerBlocks.ECHO_DOOR);
        getOrCreateTagBuilder(FENCE_GATES).setReplace(false).add(DeeperDarkerBlocks.ECHO_FENCE_GATE);
        getOrCreateTagBuilder(WOODEN_FENCES).setReplace(false).add(DeeperDarkerBlocks.ECHO_FENCE);
        getOrCreateTagBuilder(LEAVES).setReplace(false).add(DeeperDarkerBlocks.ECHO_LEAVES);
        getOrCreateTagBuilder(LOGS_THAT_BURN).setReplace(false).addTag(ECHO_LOGS);
        getOrCreateTagBuilder(PLANKS).setReplace(false).add(DeeperDarkerBlocks.ECHO_PLANKS);
        getOrCreateTagBuilder(WOODEN_SLABS).setReplace(false).add(DeeperDarkerBlocks.ECHO_SLAB);
        getOrCreateTagBuilder(WOODEN_STAIRS).setReplace(false).add(DeeperDarkerBlocks.ECHO_STAIRS);
        getOrCreateTagBuilder(STANDING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_SIGN);
        getOrCreateTagBuilder(WALL_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_WALL_SIGN);
        getOrCreateTagBuilder(WOODEN_PRESSURE_PLATES).setReplace(false).add(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE);
        getOrCreateTagBuilder(WOODEN_TRAPDOORS).setReplace(false).add(DeeperDarkerBlocks.ECHO_TRAPDOOR);

        getOrCreateTagBuilder(MINEABLE_PICKAXE).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE,
                DeeperDarkerBlocks.SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_WALL,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL,
                DeeperDarkerBlocks.SCULK_STONE_BRICKS,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL,
                DeeperDarkerBlocks.SCULK_STONE_TILES,
                DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS,
                DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB,
                DeeperDarkerBlocks.SCULK_STONE_TILE_WALL,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL,
                DeeperDarkerBlocks.CUT_SCULK_STONE,
                DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS,
                DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB,
                DeeperDarkerBlocks.CUT_SCULK_STONE_WALL,
                DeeperDarkerBlocks.CHISELED_SCULK_STONE
        );

        getOrCreateTagBuilder(WALLS).setReplace(false).add(
                DeeperDarkerBlocks.SCULK_STONE_WALL,
                DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL,
                DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL,
                DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL,
                DeeperDarkerBlocks.SCULK_STONE_TILE_WALL,
                DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL,
                DeeperDarkerBlocks.CUT_SCULK_STONE_WALL
        );
    }
}