package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.*;
import com.kyanite.deeperdarker.content.blocks.entity.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.content.blocks.entity.DDSignBlockEntity;
import com.kyanite.deeperdarker.content.blocks.flammable.*;
import com.kyanite.deeperdarker.content.blocks.vegetation.*;
import com.kyanite.deeperdarker.world.trees.EchoTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class DDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperDarker.MOD_ID);

    private static final BlockSetType ECHO_SET = BlockSetType.register(new BlockSetType("echo"));
    public static final WoodType ECHO = WoodType.register(new WoodType("echo", ECHO_SET));
    public static final RegistryObject<RotatedPillarBlock> ECHO_LOG = register("echo_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.COLOR_PURPLE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> ECHO_WOOD = register("echo_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_PURPLE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_LOG = register("stripped_echo_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_LIGHT_GRAY), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_WOOD = register("stripped_echo_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_LIGHT_GRAY), 5, 5));
    public static final RegistryObject<Block> ECHO_PLANKS = register("echo_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<StairBlock> ECHO_STAIRS = register("echo_stairs", () -> new FlammableStairBlock(() -> ECHO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<SlabBlock> ECHO_SLAB = register("echo_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<FenceBlock> ECHO_FENCE = register("echo_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<FenceGateBlock> ECHO_FENCE_GATE = register("echo_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO, 20, 5));
    public static final RegistryObject<DoorBlock> ECHO_DOOR = register("echo_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final RegistryObject<TrapDoorBlock> ECHO_TRAPDOOR = register("echo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final RegistryObject<PressurePlateBlock> ECHO_PRESSURE_PLATE = register("echo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO_SET));
    public static final RegistryObject<ButtonBlock> ECHO_BUTTON = register("echo_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), ECHO_SET, 30, true));
    public static final RegistryObject<LeavesBlock> ECHO_LEAVES = register("echo_leaves", () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).mapColor(MapColor.COLOR_PURPLE), 60, 30));
    public static final RegistryObject<SaplingBlock> ECHO_SAPLING = register("echo_sapling", () -> new SaplingBlock(new EchoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)) {
        @Override
        protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
            return pState.is(DDBlocks.ECHO_SOIL.get()) || pState.is(DDBlocks.SCULK_GRIME.get());
        }
    });
    public static final RegistryObject<StandingSignBlock> ECHO_SIGN = BLOCKS.register("echo_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallSignBlock> ECHO_WALL_SIGN = BLOCKS.register("echo_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).lootFrom(ECHO_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<CeilingHangingSignBlock> ECHO_HANGING_SIGN = BLOCKS.register("echo_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallHangingSignBlock> ECHO_WALL_HANGING_SIGN = BLOCKS.register("echo_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).lootFrom(ECHO_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<Block> POTTED_ECHO_SAPLING = BLOCKS.register("potted_echo_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ECHO_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    private static final BlockSetType BLOOM_SET = BlockSetType.register(new BlockSetType("bloom"));
    public static final WoodType BLOOM = WoodType.register(new WoodType("bloom", BLOOM_SET));
    public static final RegistryObject<Block> BLOOMING_STEM = register("blooming_stem", () -> new BloomingStemBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).mapColor(MapColor.COLOR_CYAN).ignitedByLava().noOcclusion()));
    public static final RegistryObject<Block> STRIPPED_BLOOMING_STEM = register("stripped_blooming_stem", () -> new BloomingStemBlock(BlockBehaviour.Properties.copy(BLOOMING_STEM.get())));
    public static final RegistryObject<Block> BLOOM_PLANKS = register("bloom_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GLOW_LICHEN), 20, 5));
    public static final RegistryObject<StairBlock> BLOOM_STAIRS = register("bloom_stairs", () -> new FlammableStairBlock(() -> BLOOM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GLOW_LICHEN), 20, 5));
    public static final RegistryObject<SlabBlock> BLOOM_SLAB = register("bloom_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.GLOW_LICHEN), 20, 5));
    public static final RegistryObject<FenceBlock> BLOOM_FENCE = register("bloom_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.GLOW_LICHEN), 20, 5));
    public static final RegistryObject<FenceGateBlock> BLOOM_FENCE_GATE = register("bloom_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GLOW_LICHEN), BLOOM, 20, 5));
    public static final RegistryObject<DoorBlock> BLOOM_DOOR = register("bloom_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM_SET));
    public static final RegistryObject<TrapDoorBlock> BLOOM_TRAPDOOR = register("bloom_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM_SET));
    public static final RegistryObject<PressurePlateBlock> BLOOM_PRESSURE_PLATE = register("bloom_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GLOW_LICHEN), BLOOM_SET));
    public static final RegistryObject<ButtonBlock> BLOOM_BUTTON = register("bloom_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BLOOM_SET, 30, true));
    public static final RegistryObject<StandingSignBlock> BLOOM_SIGN = BLOCKS.register("bloom_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallSignBlock> BLOOM_WALL_SIGN = BLOCKS.register("bloom_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).lootFrom(BLOOM_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<CeilingHangingSignBlock> BLOOM_HANGING_SIGN = BLOCKS.register("bloom_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallHangingSignBlock> BLOOM_WALL_HANGING_SIGN = BLOCKS.register("bloom_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).lootFrom(BLOOM_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), BLOOM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<Block> POTTED_BLOOMING_STEM = BLOCKS.register("potted_blooming_stem", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLOOMING_STEM, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final RegistryObject<Block> SCULK_STONE = register("sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops()));
    public static final RegistryObject<StairBlock> SCULK_STONE_STAIRS = register("sculk_stone_stairs", () -> new StairBlock(() -> SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> SCULK_STONE_SLAB = register("sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_WALL = register("sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> COBBLED_SCULK_STONE = register("cobbled_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> COBBLED_SCULK_STONE_STAIRS = register("cobbled_sculk_stone_stairs", () -> new StairBlock(() -> COBBLED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> COBBLED_SCULK_STONE_SLAB = register("cobbled_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> COBBLED_SCULK_STONE_WALL = register("cobbled_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final RegistryObject<Block> POLISHED_SCULK_STONE = register("polished_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> POLISHED_SCULK_STONE_STAIRS = register("polished_sculk_stone_stairs", () -> new StairBlock(() -> POLISHED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> POLISHED_SCULK_STONE_SLAB = register("polished_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> POLISHED_SCULK_STONE_WALL = register("polished_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final RegistryObject<Block> SCULK_STONE_BRICKS = register("sculk_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> SCULK_STONE_BRICK_STAIRS = register("sculk_stone_brick_stairs", () -> new StairBlock(() -> SCULK_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final RegistryObject<SlabBlock> SCULK_STONE_BRICK_SLAB = register("sculk_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_BRICK_WALL = register("sculk_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final RegistryObject<Block> SCULK_STONE_TILES = register("sculk_stone_tiles", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> SCULK_STONE_TILE_STAIRS = register("sculk_stone_tile_stairs", () -> new StairBlock(() -> SCULK_STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get())));
    public static final RegistryObject<SlabBlock> SCULK_STONE_TILE_SLAB = register("sculk_stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_TILE_WALL = register("sculk_stone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get())));
    public static final RegistryObject<Block> SMOOTH_SCULK_STONE = register("smooth_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> SMOOTH_SCULK_STONE_STAIRS = register("smooth_sculk_stone_stairs", () -> new StairBlock(() -> SMOOTH_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> SMOOTH_SCULK_STONE_SLAB = register("smooth_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> SMOOTH_SCULK_STONE_WALL = register("smooth_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get())));
    public static final RegistryObject<Block> CUT_SCULK_STONE = register("cut_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> CUT_SCULK_STONE_STAIRS = register("cut_sculk_stone_stairs", () -> new StairBlock(() -> CUT_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> CUT_SCULK_STONE_SLAB = register("cut_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> CUT_SCULK_STONE_WALL = register("cut_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get())));
    public static final RegistryObject<Block> CHISELED_SCULK_STONE = register("chiseled_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));

    public static final RegistryObject<Block> SCULK_GRIME = register("sculk_grime", () -> new MudBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.6f).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> SCULK_GRIME_BRICKS = register("sculk_grime_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final RegistryObject<SlabBlock> SCULK_GRIME_BRICK_SLAB = register("sculk_grime_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS.get())));
    public static final RegistryObject<StairBlock> SCULK_GRIME_BRICK_STAIRS = register("sculk_grime_brick_stairs", () -> new StairBlock(() -> SCULK_GRIME_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS.get())));
    public static final RegistryObject<WallBlock> SCULK_GRIME_BRICK_WALL = register("sculk_grime_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS.get())));

    public static final RegistryObject<Block> BLOOMING_SCULK_STONE = register("blooming_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get()).strength(1.5f, 4f).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLOOMING_MOSS_BLOCK = register("blooming_moss_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).sound(SoundType.SCULK).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> GLOOMSLATE = register("gloomslate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f, 4.5f).mapColor(MapColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops()));
    public static final RegistryObject<StairBlock> GLOOMSLATE_STAIRS = register("gloomslate_stairs", () -> new StairBlock(() -> GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<SlabBlock> GLOOMSLATE_SLAB = register("gloomslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<WallBlock> GLOOMSLATE_WALL = register("gloomslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<Block> COBBLED_GLOOMSLATE = register("cobbled_gloomslate", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<StairBlock> COBBLED_GLOOMSLATE_STAIRS = register("cobbled_gloomslate_stairs", () -> new StairBlock(() -> COBBLED_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get())));
    public static final RegistryObject<SlabBlock> COBBLED_GLOOMSLATE_SLAB = register("cobbled_gloomslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get())));
    public static final RegistryObject<WallBlock> COBBLED_GLOOMSLATE_WALL = register("cobbled_gloomslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get())));
    public static final RegistryObject<Block> POLISHED_GLOOMSLATE = register("polished_gloomslate", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<StairBlock> POLISHED_GLOOMSLATE_STAIRS = register("polished_gloomslate_stairs", () -> new StairBlock(() -> POLISHED_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get())));
    public static final RegistryObject<SlabBlock> POLISHED_GLOOMSLATE_SLAB = register("polished_gloomslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get())));
    public static final RegistryObject<WallBlock> POLISHED_GLOOMSLATE_WALL = register("polished_gloomslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get())));
    public static final RegistryObject<Block> GLOOMSLATE_BRICKS = register("gloomslate_bricks", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<StairBlock> GLOOMSLATE_BRICK_STAIRS = register("gloomslate_brick_stairs", () -> new StairBlock(() -> GLOOMSLATE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get())));
    public static final RegistryObject<SlabBlock> GLOOMSLATE_BRICK_SLAB = register("gloomslate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get())));
    public static final RegistryObject<WallBlock> GLOOMSLATE_BRICK_WALL = register("gloomslate_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get())));
    public static final RegistryObject<Block> GLOOMSLATE_TILES = register("gloomslate_tiles", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<StairBlock> GLOOMSLATE_TILE_STAIRS = register("gloomslate_tile_stairs", () -> new StairBlock(() -> GLOOMSLATE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get())));
    public static final RegistryObject<SlabBlock> GLOOMSLATE_TILE_SLAB = register("gloomslate_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get())));
    public static final RegistryObject<WallBlock> GLOOMSLATE_TILE_WALL = register("gloomslate_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get())));
    public static final RegistryObject<Block> SMOOTH_GLOOMSLATE = register("smooth_gloomslate", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<StairBlock> SMOOTH_GLOOMSLATE_STAIRS = register("smooth_gloomslate_stairs", () -> new StairBlock(() -> SMOOTH_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get())));
    public static final RegistryObject<SlabBlock> SMOOTH_GLOOMSLATE_SLAB = register("smooth_gloomslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get())));
    public static final RegistryObject<WallBlock> SMOOTH_GLOOMSLATE_WALL = register("smooth_gloomslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get())));
    public static final RegistryObject<Block> CUT_GLOOMSLATE = register("cut_gloomslate", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<StairBlock> CUT_GLOOMSLATE_STAIRS = register("cut_gloomslate_stairs", () -> new StairBlock(() -> CUT_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get())));
    public static final RegistryObject<SlabBlock> CUT_GLOOMSLATE_SLAB = register("cut_gloomslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get())));
    public static final RegistryObject<WallBlock> CUT_GLOOMSLATE_WALL = register("cut_gloomslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get())));
    public static final RegistryObject<Block> CHISELED_GLOOMSLATE = register("chiseled_gloomslate", () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));

    public static final RegistryObject<Block> ECHO_SOIL = register("echo_soil", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> GLOOMY_SCULK = register("gloomy_sculk", () -> new GloomySculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<GeyserBlock> GLOOMY_GEYSER = register("gloomy_geyser", () -> new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 9).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> CRYSTALLIZED_AMBER = register("crystallized_amber", () -> new CrystallizedAmberBlock(BlockBehaviour.Properties.of().lightLevel(state -> 1).sound(SoundType.GLASS).mapColor(MapColor.COLOR_ORANGE).noOcclusion()));
    public static final RegistryObject<Block> SCULK_GLEAM = register("sculk_gleam", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15).mapColor(MapColor.SAND)));

    public static final RegistryObject<Block> SCULK_STONE_COAL_ORE = register("sculk_stone_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(1, 4)));
    public static final RegistryObject<Block> SCULK_STONE_IRON_ORE = register("sculk_stone_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> SCULK_STONE_COPPER_ORE = register("sculk_stone_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> SCULK_STONE_GOLD_ORE = register("sculk_stone_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<Block> SCULK_STONE_REDSTONE_ORE = register("sculk_stone_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final RegistryObject<Block> SCULK_STONE_EMERALD_ORE = register("sculk_stone_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(5, 10)));
    public static final RegistryObject<Block> SCULK_STONE_LAPIS_ORE = register("sculk_stone_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> SCULK_STONE_DIAMOND_ORE = register("sculk_stone_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(5, 10)));
    public static final RegistryObject<Block> GLOOMSLATE_COAL_ORE = register("gloomslate_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), UniformInt.of(1, 4)));
    public static final RegistryObject<Block> GLOOMSLATE_IRON_ORE = register("gloomslate_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<Block> GLOOMSLATE_COPPER_ORE = register("gloomslate_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<Block> GLOOMSLATE_GOLD_ORE = register("gloomslate_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final RegistryObject<Block> GLOOMSLATE_REDSTONE_ORE = register("gloomslate_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get()).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final RegistryObject<Block> GLOOMSLATE_EMERALD_ORE = register("gloomslate_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), UniformInt.of(5, 10)));
    public static final RegistryObject<Block> GLOOMSLATE_LAPIS_ORE = register("gloomslate_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> GLOOMSLATE_DIAMOND_ORE = register("gloomslate_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> GLOWING_FLOWERS = register("glowing_flowers", () -> new GlowingFlowersBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).lightLevel(state -> 9).mapColor(MapColor.GLOW_LICHEN)));
    public static final RegistryObject<Block> GLOWING_GRASS = register("glowing_grass", () -> new GlowingGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 11).mapColor(MapColor.GLOW_LICHEN)));
    public static final RegistryObject<Block> GLOOMY_GRASS = register("gloomy_grass", () -> new GloomyGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 1).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> GLOOMY_CACTUS = register("gloomy_cactus", () -> new GloomyCactusBlock(BlockBehaviour.Properties.of().strength(0.5f).lightLevel(state -> 6).sound(SoundType.WOOL).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<SculkTendrilsBlock> SCULK_TENDRILS = register("sculk_tendrils", () -> new SculkTendrilsBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).randomTicks().noCollission().instabreak().mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<SculkTendrilsPlantBlock> SCULK_TENDRILS_PLANT = BLOCKS.register("sculk_tendrils_plant", () -> new SculkTendrilsPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).noCollission().instabreak().mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<SculkVinesBlock> SCULK_VINES = register("sculk_vines", () -> new SculkVinesBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).randomTicks().noCollission().instabreak().mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<SculkVinesPlantBlock> SCULK_VINES_PLANT = BLOCKS.register("sculk_vines_plant", () -> new SculkVinesPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.SCULK).noCollission().instabreak().mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<GlowingRootsBlock> GLOWING_ROOTS = register("glowing_roots", () -> new GlowingRootsBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).randomTicks().noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<GlowingRootsPlantBlock> GLOWING_ROOTS_PLANT = BLOCKS.register("glowing_roots_plant", () -> new GlowingRootsPlantBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<GlowingVinesBlock> GLOWING_VINES = BLOCKS.register("glowing_vines", () -> new GlowingVinesBlock(BlockBehaviour.Properties.of().sound(SoundType.CAVE_VINES).randomTicks().noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE).noLootTable()));
    public static final RegistryObject<GlowingVinesPlantBlock> GLOWING_VINES_PLANT = BLOCKS.register("glowing_vines_plant", () -> new GlowingVinesPlantBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(GlowingVinesPlantBlock.BERRIES) ? 14 : 0).sound(SoundType.CAVE_VINES).noCollission().instabreak().mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> INFESTED_SCULK = register("infested_sculk", () -> new InfestedSculkBlock(Blocks.SCULK, BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final RegistryObject<Block> SCULK_JAW = register("sculk_jaw", () -> new SculkJawBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).randomTicks().mapColor(MapColor.COLOR_BLACK)));

    public static final RegistryObject<Block> ANCIENT_VASE = register("ancient_vase", () -> new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE).mapColor(MapColor.DEEPSLATE)));
    public static final RegistryObject<OthersidePortalBlock> OTHERSIDE_PORTAL = BLOCKS.register("otherside_portal", () -> new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        DDItems.ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        return registeredBlock;
    }
}
