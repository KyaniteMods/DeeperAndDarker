package com.kyanite.deeperdarker.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerHangingSignBlockEntity;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerSignBlockEntity;
import com.kyanite.deeperdarker.blocks.sapling.EchoSaplingGenerator;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import com.kyanite.deeperdarker.tags.DeeperDarkerTags;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.kyrptonaught.customportalapi.util.PortalLink;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;

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
    public static final Block SCULK_GRIME;
    public static final Block SCULK_GRIME_BRICKS;
    public static final Block SCULK_GRIME_BRICK_STAIRS;
    public static final Block SCULK_GRIME_BRICK_SLAB;
    public static final Block SCULK_GRIME_BRICK_WALL;
    public static final Block GLOOMSLATE;
    public static final Block GLOOMSLATE_STAIRS;
    public static final Block GLOOMSLATE_SLAB;
    public static final Block GLOOMSLATE_WALL;
    public static final Block COBBLED_GLOOMSLATE;
    public static final Block COBBLED_GLOOMSLATE_STAIRS;
    public static final Block COBBLED_GLOOMSLATE_SLAB;
    public static final Block COBBLED_GLOOMSLATE_WALL;
    public static final Block POLISHED_GLOOMSLATE;
    public static final Block POLISHED_GLOOMSLATE_STAIRS;
    public static final Block POLISHED_GLOOMSLATE_SLAB;
    public static final Block POLISHED_GLOOMSLATE_WALL;
    public static final Block GLOOMSLATE_BRICKS;
    public static final Block GLOOMSLATE_BRICK_STAIRS;
    public static final Block GLOOMSLATE_BRICK_SLAB;
    public static final Block GLOOMSLATE_BRICK_WALL;
    public static final Block GLOOMSLATE_TILES;
    public static final Block GLOOMSLATE_TILE_STAIRS;
    public static final Block GLOOMSLATE_TILE_SLAB;
    public static final Block GLOOMSLATE_TILE_WALL;
    public static final Block SMOOTH_GLOOMSLATE;
    public static final Block SMOOTH_GLOOMSLATE_STAIRS;
    public static final Block SMOOTH_GLOOMSLATE_SLAB;
    public static final Block SMOOTH_GLOOMSLATE_WALL;
    public static final Block CUT_GLOOMSLATE;
    public static final Block CUT_GLOOMSLATE_STAIRS;
    public static final Block CUT_GLOOMSLATE_SLAB;
    public static final Block CUT_GLOOMSLATE_WALL;
    public static final Block CHISELED_GLOOMSLATE;
    public static final Block ECHO_SOIL;
    public static final Block SCULK_GLEAM;
    public static final Block SCULK_JAW;
    public static final Block SCULK_STONE_COAL_ORE;
    public static final Block SCULK_STONE_IRON_ORE;
    public static final Block SCULK_STONE_COPPER_ORE;
    public static final Block SCULK_STONE_GOLD_ORE;
    public static final Block SCULK_STONE_REDSTONE_ORE;
    public static final Block SCULK_STONE_EMERALD_ORE;
    public static final Block SCULK_STONE_LAPIS_ORE;
    public static final Block SCULK_STONE_DIAMOND_ORE;
    public static final Block SCULK_TENDRILS_PLANT;
    public static final Block SCULK_TENDRILS;
    public static final Block SCULK_VINES_PLANT;
    public static final Block SCULK_VINES;
    public static final Block GLOOMY_CACTUS;
    public static final Block GLOOMY_GRASS;
    public static final Block GLOOMY_SCULK;
    public static final Block GLOOMY_GEYSER;
    public static final Block ANCIENT_VASE;
    public static final Block CRYSTALLIZED_AMBER;
    public static final Block OTHERSIDE_PORTAL;
    public static final Block INFESTED_SCULK;

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
        ECHO_SAPLING = registerBlock("echo_sapling", new SaplingBlock(new EchoSaplingGenerator(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)) {
            @Override
            protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
                return floor.isIn(DeeperDarkerTags.Blocks.ECHO_SOIL);
            }
        });
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
        SCULK_STONE = registerBlock("sculk_stone", new Block(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.CYAN).sounds(
                DeeperDarkerSounds.SCULK_STONE)));
        SCULK_STONE_STAIRS = registerBlock("sculk_stone_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_SLAB = registerBlock("sculk_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_SLAB).mapColor(MapColor.CYAN).sounds(
                DeeperDarkerSounds.SCULK_STONE)));
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

        SCULK_GRIME = registerBlock("sculk_grime", new Block(AbstractBlock.Settings.copy(Blocks.SCULK).strength(0.6f).mapColor(MapColor.CYAN)));
        SCULK_GRIME_BRICKS = registerBlock("sculk_grime_bricks", new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).mapColor(MapColor.TERRACOTTA_GREEN)));
        SCULK_GRIME_BRICK_STAIRS = registerBlock("sculk_grime_brick_stairs", new StairsBlock(SCULK_STONE.getDefaultState(), AbstractBlock.Settings.copy(SCULK_GRIME_BRICKS)));
        SCULK_GRIME_BRICK_SLAB = registerBlock("sculk_grime_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB).mapColor(MapColor.TERRACOTTA_GREEN)));
        SCULK_GRIME_BRICK_WALL = registerBlock("sculk_grime_brick_wall", new WallBlock(AbstractBlock.Settings.copy(SCULK_GRIME_BRICKS)));

        GLOOMSLATE = registerBlock("gloomslate", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(2.5f, 4.5f).mapColor(MapColor.TERRACOTTA_BROWN)));
        GLOOMSLATE_STAIRS = registerBlock("gloomslate_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(GLOOMSLATE)));
        GLOOMSLATE_SLAB = registerBlock("gloomslate_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE_SLAB).mapColor(MapColor.CYAN)));
        GLOOMSLATE_WALL = registerBlock("gloomslate_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        COBBLED_GLOOMSLATE = registerBlock("cobbled_gloomslate", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));
        COBBLED_GLOOMSLATE_STAIRS = registerBlock("cobbled_gloomslate_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(COBBLED_GLOOMSLATE)));
        COBBLED_GLOOMSLATE_SLAB = registerBlock("cobbled_gloomslate_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOOMSLATE_SLAB)));
        COBBLED_GLOOMSLATE_WALL = registerBlock("cobbled_gloomslate_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        POLISHED_GLOOMSLATE = registerBlock("polished_gloomslate", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));
        POLISHED_GLOOMSLATE_STAIRS = registerBlock("polished_gloomslate_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(POLISHED_GLOOMSLATE)));
        POLISHED_GLOOMSLATE_SLAB = registerBlock("polished_gloomslate_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOOMSLATE_SLAB)));
        POLISHED_GLOOMSLATE_WALL = registerBlock("polished_gloomslate_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        GLOOMSLATE_BRICKS = registerBlock("gloomslate_bricks", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));
        GLOOMSLATE_BRICK_STAIRS = registerBlock("gloomslate_brick_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(GLOOMSLATE_BRICKS)));
        GLOOMSLATE_BRICK_SLAB = registerBlock("gloomslate_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOOMSLATE_SLAB)));
        GLOOMSLATE_BRICK_WALL = registerBlock("gloomslate_brick_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        GLOOMSLATE_TILES = registerBlock("gloomslate_tiles", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));
        GLOOMSLATE_TILE_STAIRS = registerBlock("gloomslate_tile_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(GLOOMSLATE_TILES)));
        GLOOMSLATE_TILE_SLAB = registerBlock("gloomslate_tile_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOOMSLATE_SLAB)));
        GLOOMSLATE_TILE_WALL = registerBlock("gloomslate_tile_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        SMOOTH_GLOOMSLATE = registerBlock("smooth_gloomslate", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));
        SMOOTH_GLOOMSLATE_STAIRS = registerBlock("smooth_gloomslate_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(SMOOTH_GLOOMSLATE)));
        SMOOTH_GLOOMSLATE_SLAB = registerBlock("smooth_gloomslate_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOOMSLATE_SLAB)));
        SMOOTH_GLOOMSLATE_WALL = registerBlock("smooth_gloomslate_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        CUT_GLOOMSLATE = registerBlock("cut_gloomslate", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));
        CUT_GLOOMSLATE_STAIRS = registerBlock("cut_gloomslate_stairs", new StairsBlock(GLOOMSLATE.getDefaultState(), AbstractBlock.Settings.copy(CUT_GLOOMSLATE)));
        CUT_GLOOMSLATE_SLAB = registerBlock("cut_gloomslate_slab", new SlabBlock(AbstractBlock.Settings.copy(GLOOMSLATE_SLAB)));
        CUT_GLOOMSLATE_WALL = registerBlock("cut_gloomslate_wall", new WallBlock(AbstractBlock.Settings.copy(GLOOMSLATE)));
        CHISELED_GLOOMSLATE = registerBlock("chiseled_gloomslate", new Block(AbstractBlock.Settings.copy(GLOOMSLATE)));

        ECHO_SOIL = registerBlock("echo_soil", new Block(AbstractBlock.Settings.copy(Blocks.SCULK).strength(0.3f).mapColor(MapColor.PURPLE)));
        SCULK_GLEAM = registerBlock("sculk_gleam", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(Blocks.SCULK).luminance((state) -> 15).mapColor(MapColor.PALE_YELLOW), UniformIntProvider.create(1, 3)));
        SCULK_JAW = registerBlock("sculk_jaw", new SculkJawBlock(AbstractBlock.Settings.copy(Blocks.SCULK).ticksRandomly()));

        SCULK_STONE_COAL_ORE = registerBlock("sculk_stone_coal_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE),
                UniformIntProvider.create(1, 4)));
        SCULK_STONE_IRON_ORE = registerBlock("sculk_stone_iron_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_COPPER_ORE = registerBlock("sculk_stone_copper_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_GOLD_ORE = registerBlock("sculk_stone_gold_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE)));
        SCULK_STONE_REDSTONE_ORE = registerBlock("sculk_stone_redstone_ore", new RedstoneOreBlock(AbstractBlock.Settings.copy(SCULK_STONE).ticksRandomly().luminance((state) -> state.get(Properties.LIT) ? 9 : 0)));
        SCULK_STONE_EMERALD_ORE = registerBlock("sculk_stone_emerald_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE),
                UniformIntProvider.create(5, 10)));
        SCULK_STONE_LAPIS_ORE = registerBlock("sculk_stone_lapis_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE),
                UniformIntProvider.create(4, 8)));
        SCULK_STONE_DIAMOND_ORE = registerBlock("sculk_stone_diamond_ore", new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SCULK_STONE),
                UniformIntProvider.create(5, 10)));

        SCULK_TENDRILS_PLANT = registerBlock("sculk_tendrils_plant", new SculkTendrilsPlantBlock(AbstractBlock.Settings.create().sounds(
                BlockSoundGroup.SCULK).nonOpaque().noCollision().breakInstantly()));
        SCULK_TENDRILS = registerBlock("sculk_tendrils", new SculkTendrilsBlock(AbstractBlock.Settings.copy(SCULK_TENDRILS_PLANT).ticksRandomly()));
        SCULK_VINES_PLANT = registerBlock("sculk_vines_plant", new SculkVinesPlantBlock(AbstractBlock.Settings.create().sounds(
                BlockSoundGroup.SCULK).nonOpaque().noCollision().breakInstantly()));
        SCULK_VINES = registerBlock("sculk_vines", new SculkVinesBlock(AbstractBlock.Settings.copy(SCULK_VINES_PLANT).ticksRandomly()));
        GLOOMY_CACTUS = registerBlock("gloomy_cactus", new GloomyCactusBlock(AbstractBlock.Settings.create().strength(0.5f).luminance((state) -> 6).mapColor(MapColor.ORANGE).sounds(
                BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
        GLOOMY_GRASS = registerBlock("gloomy_grass", new GloomyGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS).luminance((state) -> 1)));
        GLOOMY_SCULK = registerBlock("gloomy_sculk", new GloomySculkBlock(AbstractBlock.Settings.copy(Blocks.SCULK)));
        GLOOMY_GEYSER = registerBlock("gloomy_geyser", new GloomyGeyserBlock(AbstractBlock.Settings.copy(Blocks.SCULK).luminance((state) -> 9).pistonBehavior(
                PistonBehavior.DESTROY)));
        ANCIENT_VASE = registerBlock("ancient_vase", new AncientVaseBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(2.0f, 6.0f).sounds(DeeperDarkerSounds.ANCIENT_VASE).pistonBehavior(PistonBehavior.DESTROY)));
        CRYSTALLIZED_AMBER = registerBlock("crystallized_amber", new TransparentBlock(AbstractBlock.Settings.create().luminance((state) -> 1).mapColor(MapColor.ORANGE).sounds(
                BlockSoundGroup.GLASS).nonOpaque()));
        OTHERSIDE_PORTAL = registerBlock("otherside_portal", new CustomPortalBlock(AbstractBlock.Settings.copy(Blocks.NETHER_PORTAL)));
        INFESTED_SCULK = registerBlock("infested_sculk", new InfestedSculkBlock(Blocks.SCULK, AbstractBlock.Settings.copy(Blocks.SCULK)));
    }

    private static Block registerBlock(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(DeeperDarker.MOD_ID, id), block);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker blocks");
        StrippableBlockRegistry.register(DeeperDarkerBlocks.ECHO_LOG, DeeperDarkerBlocks.STRIPPED_ECHO_LOG);
        StrippableBlockRegistry.register(DeeperDarkerBlocks.ECHO_WOOD, DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);
        PortalLink portalLink = new PortalLink();
        portalLink.setPortalBlock((CustomPortalBlock)OTHERSIDE_PORTAL);
        portalLink.dimID = new Identifier(DeeperDarker.MOD_ID, "otherside");
        portalLink.portalIgnitionSource = PortalIgnitionSource.ItemUseSource(DeeperDarkerItems.HEART_OF_THE_DEEP);
        portalLink.setPortalIgniteEvent((player, world, portalPos, framePos, portalIgnitionSource) -> {
            if (!player.isCreative() && player.getStackInHand(player.getActiveHand()).isOf(DeeperDarkerItems.HEART_OF_THE_DEEP)) {
                player.getStackInHand(player.getActiveHand()).decrement(1);
            }
        });
        portalLink.forcedWidth = 6;
        portalLink.colorID = 0xFF003C56;
        CustomPortalApiRegistry.addPortal(Blocks.REINFORCED_DEEPSLATE, portalLink);
    }
}