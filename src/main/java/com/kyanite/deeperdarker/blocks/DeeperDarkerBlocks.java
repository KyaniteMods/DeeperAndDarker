package com.kyanite.deeperdarker.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerBlockEntityTypes;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerHangingSignBlockEntity;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerSignBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DeeperDarkerBlocks {
    public static final BlockSetType ECHO_BLOCK_SET_TYPE = new BlockSetTypeBuilder().register(new Identifier(DeeperDarker.MOD_ID, "echo"));
    public static final WoodType ECHO_WOOD_TYPE = new WoodTypeBuilder().register(new Identifier(DeeperDarker.MOD_ID, "echo"), ECHO_BLOCK_SET_TYPE);

    public static final Block ECHO_LOG;
    public static final Block ECHO_WOOD;
    public static final Block STRIPPED_ECHO_LOG;
    public static final Block STRIPPED_ECHO_WOOD;
    public static final Block ECHO_BUTTON;
    public static final Block ECHO_DOOR;
    public static final Block ECHO_FENCE_GATE;
    public static final Block ECHO_FENCE;
    public static final Block ECHO_HANGING_SIGN;
    public static final Block ECHO_WALL_HANGING_SIGN;
    public static final Block ECHO_LEAVES;
    public static final Block ECHO_PLANKS;
    public static final Block ECHO_PRESSURE_PLATE;
    public static final Block ECHO_SAPLING;
    public static final Block ECHO_SIGN;
    public static final Block ECHO_WALL_SIGN;
    public static final Block ECHO_SLAB;
    public static final Block ECHO_STAIRS;
    public static final Block ECHO_TRAPDOOR;
    public static final Block SCULK_STONE;
    public static final Block SCULK_STONE_STAIRS;
    public static final Block SCULK_STONE_SLAB;
    public static final Block SCULK_STONE_WALL;
    public static final Block COBBLED_SCULK_STONE;
    public static final Block COBBLED_SCULK_STONE_STAIRS;
    public static final Block COBBLED_SCULK_STONE_SLAB;
    public static final Block COBBLED_SCULK_STONE_WALL;
    public static final Block POLISHED_SCULK_STONE;
    public static final Block POLISHED_SCULK_STONE_STAIRS;
    public static final Block POLISHED_SCULK_STONE_SLAB;
    public static final Block POLISHED_SCULK_STONE_WALL;
    public static final Block SCULK_STONE_BRICKS;
    public static final Block SCULK_STONE_BRICK_STAIRS;
    public static final Block SCULK_STONE_BRICK_SLAB;
    public static final Block SCULK_STONE_BRICK_WALL;
    public static final Block SCULK_STONE_TILES;
    public static final Block SCULK_STONE_TILE_STAIRS;
    public static final Block SCULK_STONE_TILE_SLAB;
    public static final Block SCULK_STONE_TILE_WALL;
    public static final Block SMOOTH_SCULK_STONE;
    public static final Block SMOOTH_SCULK_STONE_STAIRS;
    public static final Block SMOOTH_SCULK_STONE_SLAB;
    public static final Block SMOOTH_SCULK_STONE_WALL;
    public static final Block CUT_SCULK_STONE;
    public static final Block CUT_SCULK_STONE_STAIRS;
    public static final Block CUT_SCULK_STONE_SLAB;
    public static final Block CUT_SCULK_STONE_WALL;
    public static final Block CHISELED_SCULK_STONE;

    static {
        ECHO_LOG = registerBlock("echo_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(state -> state.get(
                Properties.AXIS).isVertical() ? MapColor.LIGHT_GRAY : MapColor.PURPLE)));
        ECHO_WOOD = registerBlock("echo_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.PURPLE)));

        STRIPPED_ECHO_LOG = registerBlock("stripped_echo_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.LIGHT_GRAY)));
        STRIPPED_ECHO_WOOD = registerBlock("stripped_echo_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.LIGHT_GRAY)));
        ECHO_BUTTON = registerBlock("echo_button", new ButtonBlock(AbstractBlock.Settings.copy(Blocks.OAK_BUTTON),
                ECHO_BLOCK_SET_TYPE, 30, true));
        ECHO_DOOR = registerBlock("echo_door", new DoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.LIGHT_GRAY),
                ECHO_BLOCK_SET_TYPE));
        ECHO_FENCE_GATE = registerBlock("echo_fence_gate", new FenceGateBlock(AbstractBlock.Settings.copy(
                Blocks.OAK_FENCE_GATE).mapColor(MapColor.LIGHT_GRAY), ECHO_WOOD_TYPE));
        ECHO_FENCE = registerBlock("echo_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.LIGHT_GRAY)));
        ECHO_WALL_HANGING_SIGN = registerBlock("echo_wall_hanging_sign", new WallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY), ECHO_WOOD_TYPE) {
            @Override
            public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new DeeperDarkerHangingSignBlockEntity(pos, state);
            }
        });
        ECHO_HANGING_SIGN = registerBlock("echo_hanging_sign", new HangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY), ECHO_WOOD_TYPE) {
            @Override
            public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new DeeperDarkerHangingSignBlockEntity(pos, state);
            }
        });
        ECHO_LEAVES = registerBlock("echo_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.PURPLE)));
        ECHO_PLANKS = registerBlock("echo_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.LIGHT_GRAY)));
        ECHO_PRESSURE_PLATE = registerBlock("echo_pressure_plate", new PressurePlateBlock(
                PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.LIGHT_GRAY), ECHO_BLOCK_SET_TYPE));
        // currently uses oak sapling generator, change that later when echo trees are added
        ECHO_SAPLING = registerBlock("echo_sapling", new SaplingBlock(new OakSaplingGenerator(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
        ECHO_SIGN = registerBlock("echo_sign", new SignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapColor.LIGHT_GRAY), ECHO_WOOD_TYPE) {
            @Override
            public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new DeeperDarkerSignBlockEntity(pos, state);
            }
        });
        ECHO_WALL_SIGN = registerBlock("echo_wall_sign", new WallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.LIGHT_GRAY), ECHO_WOOD_TYPE) {
            @Override
            public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new DeeperDarkerSignBlockEntity(pos, state);
            }
        });
        ECHO_SLAB = registerBlock("echo_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.LIGHT_GRAY)));
        ECHO_STAIRS = registerBlock("echo_stairs", new StairsBlock(ECHO_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.LIGHT_GRAY)));
        ECHO_TRAPDOOR = registerBlock("echo_trapdoor", new TrapdoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.LIGHT_GRAY), ECHO_BLOCK_SET_TYPE));
        SCULK_STONE = registerBlock("sculk_stone", new Block(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.CYAN)));
        SCULK_STONE_STAIRS = registerBlock("sculk_stone_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_SLAB = registerBlock("sculk_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_SLAB).mapColor(MapColor.CYAN)));
        SCULK_STONE_WALL = registerBlock("sculk_stone_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        COBBLED_SCULK_STONE = registerBlock("cobbled_sculk_stone", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
        COBBLED_SCULK_STONE_STAIRS = registerBlock("cobbled_sculk_stone_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(COBBLED_SCULK_STONE)));
        COBBLED_SCULK_STONE_SLAB = registerBlock("cobbled_sculk_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(SCULK_STONE_SLAB)));
        COBBLED_SCULK_STONE_WALL = registerBlock("cobbled_sculk_stone_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        POLISHED_SCULK_STONE = registerBlock("polished_sculk_stone", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
        POLISHED_SCULK_STONE_STAIRS = registerBlock("polished_sculk_stone_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(POLISHED_SCULK_STONE)));
        POLISHED_SCULK_STONE_SLAB = registerBlock("polished_sculk_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(SCULK_STONE_SLAB)));
        POLISHED_SCULK_STONE_WALL = registerBlock("polished_sculk_stone_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_BRICKS = registerBlock("sculk_stone_bricks", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_BRICK_STAIRS = registerBlock("sculk_stone_brick_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(SCULK_STONE_BRICKS)));
        SCULK_STONE_BRICK_SLAB = registerBlock("sculk_stone_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(SCULK_STONE_SLAB)));
        SCULK_STONE_BRICK_WALL = registerBlock("sculk_stone_brick_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_TILES = registerBlock("sculk_stone_tiles", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_TILE_STAIRS = registerBlock("sculk_stone_tile_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(SCULK_STONE_TILES)));
        SCULK_STONE_TILE_SLAB = registerBlock("sculk_stone_tile_slab", new SlabBlock(AbstractBlock.Settings.copy(SCULK_STONE_SLAB)));
        SCULK_STONE_TILE_WALL = registerBlock("sculk_stone_tile_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        SMOOTH_SCULK_STONE = registerBlock("smooth_sculk_stone", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
        SMOOTH_SCULK_STONE_STAIRS = registerBlock("smooth_sculk_stone_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(SMOOTH_SCULK_STONE)));
        SMOOTH_SCULK_STONE_SLAB = registerBlock("smooth_sculk_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(SCULK_STONE_SLAB)));
        SMOOTH_SCULK_STONE_WALL = registerBlock("smooth_sculk_stone_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        CUT_SCULK_STONE = registerBlock("cut_sculk_stone", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
        CUT_SCULK_STONE_STAIRS = registerBlock("cut_sculk_stone_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(CUT_SCULK_STONE)));
        CUT_SCULK_STONE_SLAB = registerBlock("cut_sculk_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(SCULK_STONE_SLAB)));
        CUT_SCULK_STONE_WALL = registerBlock("cut_sculk_stone_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        CHISELED_SCULK_STONE = registerBlock("chiseled_sculk_stone", new Block(AbstractBlock.Settings.copy(SCULK_STONE)));
    }

    private static Block registerBlock(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(DeeperDarker.MOD_ID, id), block);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker blocks");
    }
}