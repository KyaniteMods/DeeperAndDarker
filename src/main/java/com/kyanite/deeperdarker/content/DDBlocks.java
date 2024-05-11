package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.*;
import com.kyanite.deeperdarker.content.blocks.vegetation.*;
import com.kyanite.deeperdarker.content.entities.blocks.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.content.entities.blocks.DDSignBlockEntity;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.trees.EchoTreeGrower;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.mixin.content.registry.FireBlockMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.PushReaction;

@SuppressWarnings("NullableProblems")
public class DDBlocks {
    private static final BlockSetType ECHO_SET = new BlockSetType(new ResourceLocation(DeeperDarker.MOD_ID, "echo").toString(), true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    public static final WoodType ECHO = WoodType.register(new WoodType(new ResourceLocation(DeeperDarker.MOD_ID, "echo").toString(), ECHO_SET, SoundType.WOOD, SoundType.HANGING_SIGN, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    private static final BlockSetType BLOOM_SET = new BlockSetType(new ResourceLocation(DeeperDarker.MOD_ID, "bloom").toString(), true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    public static final WoodType BLOOM = WoodType.register(new WoodType(new ResourceLocation(DeeperDarker.MOD_ID, "bloom").toString(), BLOOM_SET, SoundType.WOOD, SoundType.HANGING_SIGN, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));

    public static final Block ENRICHED_ECHO_LOG = register("enriched_echo_log", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.COLOR_PURPLE)));
    public static final Block ECHO_LOG = register("echo_log", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.COLOR_PURPLE)));
    public static final Block ECHO_WOOD = register("echo_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_PURPLE)));
    public static final Block STRIPPED_ECHO_LOG = register("stripped_echo_log", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block STRIPPED_ECHO_WOOD = register("stripped_echo_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_PLANKS = register("echo_planks", new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_STAIRS = register("echo_stairs", new StairBlock(ECHO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_SLAB = register("echo_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_FENCE = register("echo_fence", new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_FENCE_GATE = register("echo_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO));
    public static final Block ECHO_DOOR = register("echo_door", new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final Block ECHO_TRAPDOOR = register("echo_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final Block ECHO_PRESSURE_PLATE = register("echo_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final Block ECHO_BUTTON = register("echo_button", new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), ECHO_SET, 30, true));
    public static final Block ECHO_LEAVES = register("echo_leaves", new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).mapColor(MapColor.COLOR_PURPLE)));
    public static final Block ECHO_SAPLING = register("echo_sapling", new SaplingBlock(new EchoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)) {
        @Override
        protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
            return pState.is(DDTags.Blocks.ECHO_SOIL);
        }
    });

    public static final Block ECHO_SIGN = registerWithoutItem("echo_sign", new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final Block ECHO_WALL_SIGN = registerWithoutItem("echo_wall_sign", new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(ECHO_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final Block ECHO_HANGING_SIGN = registerWithoutItem("echo_hanging_sign", new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final Block ECHO_WALL_HANGING_SIGN = registerWithoutItem("echo_wall_hanging_sign", new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(ECHO_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });

    public static final Block POTTED_ECHO_SAPLING = registerWithoutItem("potted_echo_sapling", createFlowerPot(ECHO_SAPLING));

    public static final Block BLOOMING_STEM = register("blooming_stem", new BloomingStemBlock(BlockBehaviour.Properties.of().strength(1f).mapColor(MapColor.COLOR_CYAN).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final Block STRIPPED_BLOOMING_STEM = register("stripped_blooming_stem", new BloomingStemBlock(BlockBehaviour.Properties.copy(BLOOMING_STEM).mapColor(MapColor.GLOW_LICHEN)));
    public static final Block BLOOM_PLANKS = register("bloom_planks", new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GLOW_LICHEN)));
    public static final Block BLOOM_STAIRS = register("bloom_stairs", new StairBlock(BLOOM_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GLOW_LICHEN)));
    public static final Block BLOOM_SLAB = register("bloom_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.GLOW_LICHEN)));
    public static final Block BLOOM_FENCE = register("bloom_fence", new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.GLOW_LICHEN)));
    public static final Block BLOOM_FENCE_GATE = register("bloom_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GLOW_LICHEN), BLOOM));
    public static final Block BLOOM_DOOR = register("bloom_door", new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.GLOW_LICHEN), BLOOM_SET));
    public static final Block BLOOM_TRAPDOOR = register("bloom_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GLOW_LICHEN), BLOOM_SET));
    public static final Block BLOOM_PRESSURE_PLATE = register("bloom_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GLOW_LICHEN), BLOOM_SET));
    public static final Block BLOOM_BUTTON = register("bloom_button", new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BLOOM_SET, 30, true));

    public static final Block BLOOM_SIGN = registerWithoutItem("bloom_sign", new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.GLOW_LICHEN), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final Block BLOOM_WALL_SIGN = registerWithoutItem("bloom_wall_sign", new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(BLOOM_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final Block BLOOM_HANGING_SIGN = registerWithoutItem("bloom_hanging_sign", new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final Block BLOOM_WALL_HANGING_SIGN = registerWithoutItem("bloom_wall_hanging_sign", new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(BLOOM_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });

    public static final Block POTTED_BLOOMING_STEM = registerWithoutItem("potted_blooming_stem", createFlowerPot(BLOOMING_STEM));

    public static final Block SCULK_STONE = register("sculk_stone", new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_CYAN).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Block SCULK_STONE_STAIRS = register("sculk_stone_stairs", new StairBlock(SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_SLAB = register("sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_WALL = register("sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE = register("cobbled_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE_STAIRS = register("cobbled_sculk_stone_stairs", new StairBlock(COBBLED_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE_SLAB = register("cobbled_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE_WALL = register("cobbled_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE = register("polished_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE_STAIRS = register("polished_sculk_stone_stairs", new StairBlock(POLISHED_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE_SLAB = register("polished_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE_WALL = register("polished_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE)));
    public static final Block SCULK_STONE_BRICKS = register("sculk_stone_bricks", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_BRICK_STAIRS = register("sculk_stone_brick_stairs", new StairBlock(SCULK_STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS)));
    public static final Block SCULK_STONE_BRICK_SLAB = register("sculk_stone_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS)));
    public static final Block SCULK_STONE_BRICK_WALL = register("sculk_stone_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS)));
    public static final Block SCULK_STONE_TILES = register("sculk_stone_tiles", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_TILE_STAIRS = register("sculk_stone_tile_stairs", new StairBlock(SCULK_STONE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_TILES)));
    public static final Block SCULK_STONE_TILE_SLAB = register("sculk_stone_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES)));
    public static final Block SCULK_STONE_TILE_WALL = register("sculk_stone_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES)));
    public static final Block SMOOTH_SCULK_STONE = register("smooth_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SMOOTH_SCULK_STONE_STAIRS = register("smooth_sculk_stone_stairs", new StairBlock(SMOOTH_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE)));
    public static final Block SMOOTH_SCULK_STONE_SLAB = register("smooth_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE)));
    public static final Block SMOOTH_SCULK_STONE_WALL = register("smooth_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE)));
    public static final Block CUT_SCULK_STONE = register("cut_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block CUT_SCULK_STONE_STAIRS = register("cut_sculk_stone_stairs", new StairBlock(CUT_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(CUT_SCULK_STONE)));
    public static final Block CUT_SCULK_STONE_SLAB = register("cut_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE)));
    public static final Block CUT_SCULK_STONE_WALL = register("cut_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE)));
    public static final Block CHISELED_SCULK_STONE = register("chiseled_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));

    public static final Block BLOOMING_SCULK_STONE = register("blooming_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE).strength(1.5f, 4f).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final Block BLOOMING_MOSS_BLOCK = register("blooming_moss_block", new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).sound(SoundType.SCULK).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final Block GLOOMSLATE = register("gloomslate", new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f, 4.5f).mapColor(MapColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops()));
    public static final Block GLOOMSLATE_STAIRS = register("gloomslate_stairs", new StairBlock(GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_SLAB = register("gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_WALL = register("gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE = register("cobbled_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE_STAIRS = register("cobbled_gloomslate_stairs", new StairBlock(COBBLED_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE_SLAB = register("cobbled_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE_WALL = register("cobbled_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE = register("polished_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE_STAIRS = register("polished_gloomslate_stairs", new StairBlock(POLISHED_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE_SLAB = register("polished_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE_WALL = register("polished_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE)));
    public static final Block GLOOMSLATE_BRICKS = register("gloomslate_bricks", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_BRICK_STAIRS = register("gloomslate_brick_stairs", new StairBlock(GLOOMSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS)));
    public static final Block GLOOMSLATE_BRICK_SLAB = register("gloomslate_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS)));
    public static final Block GLOOMSLATE_BRICK_WALL = register("gloomslate_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS)));
    public static final Block GLOOMSLATE_TILES = register("gloomslate_tiles", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_TILE_STAIRS = register("gloomslate_tile_stairs", new StairBlock(GLOOMSLATE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_TILES)));
    public static final Block GLOOMSLATE_TILE_SLAB = register("gloomslate_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES)));
    public static final Block GLOOMSLATE_TILE_WALL = register("gloomslate_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES)));
    public static final Block SMOOTH_GLOOMSLATE = register("smooth_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block SMOOTH_GLOOMSLATE_STAIRS = register("smooth_gloomslate_stairs", new StairBlock(SMOOTH_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE)));
    public static final Block SMOOTH_GLOOMSLATE_SLAB = register("smooth_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE)));
    public static final Block SMOOTH_GLOOMSLATE_WALL = register("smooth_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE = register("cut_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE_STAIRS = register("cut_gloomslate_stairs", new StairBlock(CUT_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(CUT_GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE_SLAB = register("cut_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE_WALL = register("cut_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE)));
    public static final Block CHISELED_GLOOMSLATE = register("chiseled_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));

    public static final Block SCULK_GRIME = register("sculk_grime", new MudBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.6f).mapColor(MapColor.COLOR_CYAN)));
    public static final Block SCULK_GRIME_BRICKS = register("sculk_grime_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final Block SCULK_GRIME_BRICK_SLAB = register("sculk_grime_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_GRIME_BRICK_STAIRS = register("sculk_grime_brick_stairs", new StairBlock(SCULK_GRIME_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_GRIME_BRICK_WALL = register("sculk_grime_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));

    public static final Block ECHO_SOIL = register("echo_soil", new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f).mapColor(MapColor.COLOR_PURPLE)));
    public static final Block GLOOMY_SCULK = register("gloomy_sculk", new GloomySculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)));
    public static final Block GLOOMY_GEYSER = register("gloomy_geyser", new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 9).noLootTable()));
    public static final Block CRYSTALLIZED_AMBER = register("crystallized_amber", new CrystallizedAmberBlock(BlockBehaviour.Properties.of().strength(0.3f, 3f).lightLevel(state -> 1).sound(SoundType.GLASS).mapColor(MapColor.COLOR_ORANGE).noOcclusion()));
    public static final Block SCULK_GLEAM = register("sculk_gleam", new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15).mapColor(MapColor.SAND)));

    public static final Block SCULK_STONE_COAL_ORE = register("sculk_stone_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(1, 4)));
    public static final Block SCULK_STONE_IRON_ORE = register("sculk_stone_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_COPPER_ORE = register("sculk_stone_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_GOLD_ORE = register("sculk_stone_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_REDSTONE_ORE = register("sculk_stone_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.copy(SCULK_STONE).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Block SCULK_STONE_EMERALD_ORE = register("sculk_stone_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(5, 10)));
    public static final Block SCULK_STONE_LAPIS_ORE = register("sculk_stone_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(4, 8)));
    public static final Block SCULK_STONE_DIAMOND_ORE = register("sculk_stone_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(5, 10)));
    public static final Block GLOOMSLATE_COAL_ORE = register("gloomslate_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(1, 4)));
    public static final Block GLOOMSLATE_IRON_ORE = register("gloomslate_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_COPPER_ORE = register("gloomslate_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_GOLD_ORE = register("gloomslate_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_REDSTONE_ORE = register("gloomslate_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.copy(GLOOMSLATE).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Block GLOOMSLATE_EMERALD_ORE = register("gloomslate_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(5, 10)));
    public static final Block GLOOMSLATE_LAPIS_ORE = register("gloomslate_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(4, 8)));
    public static final Block GLOOMSLATE_DIAMOND_ORE = register("gloomslate_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(5, 10)));

    public static final Block GLOWING_FLOWERS = register("glowing_flowers", new BloomingFlowersBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).lightLevel(state -> 9)));
    public static final Block GLOWING_GRASS = register("glowing_grass", new GlowingGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 11)));
    public static final Block GLOOMY_GRASS = register("gloomy_grass", new GloomyGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 1)));
    public static final Block GLOOMY_CACTUS = register("gloomy_cactus", new GloomyCactusBlock(BlockBehaviour.Properties.of().strength(0.5f).lightLevel(state -> 6).sound(SoundType.WOOL).mapColor(MapColor.COLOR_ORANGE)));

    public static final Block SCULK_TENDRILS = register("sculk_tendrils", new SculkTendrilsBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).randomTicks().noCollission().instabreak()));
    public static final Block SCULK_TENDRILS_PLANT = registerWithoutItem("sculk_tendrils_plant", new SculkTendrilsPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).noCollission().instabreak()));
    public static final Block SCULK_VINES = register("sculk_vines", new SculkVinesBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).noCollission().instabreak().randomTicks()));
    public static final Block SCULK_VINES_PLANT = registerWithoutItem("sculk_vines_plant", new SculkVinesPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).noCollission().instabreak()));
    public static final Block GLOWING_ROOTS = register("glowing_roots", new GlowingRootsBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).randomTicks().noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final Block GLOWING_ROOTS_PLANT = registerWithoutItem("glowing_roots_plant", new GlowingRootsPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final Block GLOWING_VINES = registerWithoutItem("glowing_vines", new GlowingVinesBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).randomTicks().noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE).noLootTable()));
    public static final Block GLOWING_VINES_PLANT = registerWithoutItem("glowing_vines_plant", new GlowingVinesPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).lightLevel(state -> state.getValue(GlowingVinesPlantBlock.BERRIES) ? 14 : 0).noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final Block ICE_LILY = registerWithoutItem("ice_lily", new IceLilyBlock(BlockBehaviour.Properties.of().lightLevel(state -> 7).sound(SoundType.LILY_PAD).noOcclusion().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE).pushReaction(PushReaction.DESTROY)));

    public static final Block ANCIENT_VASE = register("ancient_vase", new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE)));

    public static final Block INFESTED_SCULK = register("infested_sculk", new InfestedSculkBlock(Blocks.SCULK, BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Block SCULK_JAW = register("sculk_jaw", new SculkJawBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).randomTicks()));
    public static final Block SOUNDPROOF_GLASS = register("soundproof_glass", new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS)));

    public static final Block OTHERSIDE_PORTAL = registerWithoutItem("otherside_portal", new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

    private static FlowerPotBlock createFlowerPot(Block block, FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(
                PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }

        return new FlowerPotBlock(block, properties);
    }

    private static Block register(String name, Block block) {
        Block registeredBlock = registerWithoutItem(name, block);
        DDItems.register(name, new BlockItem(block, new Item.Properties()));
        return registeredBlock;
    }

    private static Block registerWithoutItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, name), block);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering blocks");
        StrippableBlockRegistry.register(ECHO_LOG, STRIPPED_ECHO_LOG);
        StrippableBlockRegistry.register(ECHO_WOOD, STRIPPED_ECHO_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(ENRICHED_ECHO_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_ECHO_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_ECHO_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ECHO_PLANKS, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(BLOOMING_STEM, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_BLOOMING_STEM, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BLOOM_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BLOOM_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BLOOM_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BLOOM_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BLOOM_PLANKS, 5, 20);
    }
}
