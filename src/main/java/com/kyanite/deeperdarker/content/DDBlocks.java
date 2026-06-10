package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.*;
import com.kyanite.deeperdarker.content.blocks.vegetation.*;
import com.kyanite.deeperdarker.content.entities.blocks.DDCampfireBlockEntity;
import com.kyanite.deeperdarker.content.entities.blocks.DDHangingSignBlockEntity;
import com.kyanite.deeperdarker.content.entities.blocks.DDSignBlockEntity;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.trees.EchoTreeGrower;
import com.kyanite.deeperdarker.world.trees.SculkSpruceTreeGrower;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("NullableProblems")
public class DDBlocks {
    private static final BlockSetType ECHO_SET = new BlockSetType(new ResourceLocation(DeeperDarker.MOD_ID, "echo").toString(), true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    public static final WoodType ECHO = new WoodTypeBuilder().soundGroup(SoundType.WOOD).hangingSignSoundGroup(SoundType.HANGING_SIGN).fenceGateCloseSound(SoundEvents.FENCE_GATE_CLOSE).fenceGateOpenSound(SoundEvents.FENCE_GATE_OPEN).register(new ResourceLocation(DeeperDarker.MOD_ID, "echo"), ECHO_SET);
    private static final BlockSetType BLOOM_SET = new BlockSetType(new ResourceLocation(DeeperDarker.MOD_ID, "bloom").toString(), true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    public static final WoodType BLOOM = new WoodTypeBuilder().soundGroup(SoundType.WOOD).hangingSignSoundGroup(SoundType.HANGING_SIGN).fenceGateCloseSound(SoundEvents.FENCE_GATE_CLOSE).fenceGateOpenSound(SoundEvents.FENCE_GATE_OPEN).register(new ResourceLocation(DeeperDarker.MOD_ID, "bloom"), BLOOM_SET);
    private static final BlockSetType SCULK_SPRUCE_SET = new BlockSetType(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_spruce").toString(), true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    public static final WoodType SCULK_SPRUCE = new WoodTypeBuilder().soundGroup(SoundType.WOOD).hangingSignSoundGroup(SoundType.HANGING_SIGN).fenceGateCloseSound(SoundEvents.FENCE_GATE_CLOSE).fenceGateOpenSound(SoundEvents.FENCE_GATE_OPEN).register(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_spruce"), SCULK_SPRUCE_SET);

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
        public boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
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

    public static final Block BLOOMING_STEM = register("blooming_stem", new BloomingStemBlock(BlockBehaviour.Properties.of().strength(1f).randomTicks().sound(SoundType.WOOD).mapColor(MapColor.COLOR_CYAN).ignitedByLava().noOcclusion()));
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

    public static final Block SCULK_SPRUCE_LOG = register("sculk_spruce_log", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.COLOR_CYAN)));
    public static final Block SCULK_SPRUCE_WOOD = register("sculk_spruce_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_CYAN)));
    public static final Block STRIPPED_SCULK_SPRUCE_LOG = register("stripped_sculk_spruce_log", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block STRIPPED_SCULK_SPRUCE_WOOD = register("stripped_sculk_spruce_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block SCULK_SPRUCE_PLANKS = register("sculk_spruce_planks", new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block SCULK_SPRUCE_STAIRS = register("sculk_spruce_stairs", new StairBlock(SCULK_SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block SCULK_SPRUCE_SLAB = register("sculk_spruce_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block SCULK_SPRUCE_FENCE = register("sculk_spruce_fence", new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Block SCULK_SPRUCE_FENCE_GATE = register("sculk_spruce_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE));
    public static final Block SCULK_SPRUCE_DOOR = register("sculk_spruce_door", new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE_SET));
    public static final Block SCULK_SPRUCE_TRAPDOOR = register("sculk_spruce_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE_SET));
    public static final Block SCULK_SPRUCE_PRESSURE_PLATE = register("sculk_spruce_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE_SET));
    public static final Block SCULK_SPRUCE_BUTTON = register("sculk_spruce_button", new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SCULK_SPRUCE_SET, 30, true));
    public static final Block SCULK_SPRUCE_LEAVES = register("sculk_spruce_leaves", new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).mapColor(MapColor.SNOW)));
    public static final Block SCULK_SPRUCE_SAPLING = register("sculk_spruce_sapling", new SaplingBlock(new SculkSpruceTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)) {
        @Override
        public boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
            return super.mayPlaceOn(blockState, blockGetter, blockPos) || blockState.is(Blocks.SNOW_BLOCK) || blockState.is(SNOWY_SCULK_PERMAFROST) || blockState.is(SCULK_STONE);
        }
    });

    public static final Block SCULK_SPRUCE_SIGN = registerWithoutItem("sculk_spruce_sign", new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final Block SCULK_SPRUCE_WALL_SIGN = registerWithoutItem("sculk_spruce_wall_sign", new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(SCULK_SPRUCE_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });
    public static final Block SCULK_SPRUCE_HANGING_SIGN = registerWithoutItem("sculk_spruce_hanging_sign", new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final Block SCULK_SPRUCE_WALL_HANGING_SIGN = registerWithoutItem("sculk_spruce_wall_hanging_sign", new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(SCULK_SPRUCE_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), SCULK_SPRUCE) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDHangingSignBlockEntity(pPos, pState);
        }
    });

    public static final Block POTTED_SCULK_SPRUCE_SAPLING = registerWithoutItem("potted_sculk_spruce_sapling", createFlowerPot(SCULK_SPRUCE_SAPLING));

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

    public static final Block SCULK_FERN = register("sculk_fern", new SculkFernBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Block LARGE_SCULK_FERN = register("large_sculk_fern", new LargeSculkFernBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final Block SCULK_PERMAFROST = register("sculk_permafrost", new Block(BlockBehaviour.Properties.copy(SCULK_STONE).strength(1.5f, 4f).mapColor(MapColor.ICE)));
    public static final Block SNOWY_SCULK_PERMAFROST = register("snowy_sculk_permafrost", new Block(BlockBehaviour.Properties.copy(SCULK_STONE).strength(1.5f, 4f).mapColor(MapColor.SNOW)));
    public static final Block SCULK_TUBERS = registerWithoutItem("sculk_tubers", new SculkTubersBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XYZ).mapColor(state -> state.getValue(BlockStateProperties.SNOWY) ? MapColor.SNOW : MapColor.GRASS)));
    public static final Block ICICLE = register("icicle", new IcicleBlock(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.ICE).friction(0.98f).randomTicks().strength(0.25f).sound(SoundType.GLASS).lightLevel(state -> 3)));

    public static final Block BLOOMING_SCULK_STONE = register("blooming_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE).strength(1.5f, 4f).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final Block BLOOMING_MOSS_BLOCK = register("blooming_moss_block", new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).sound(SoundType.SCULK).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final Block SCULK_BERRY = registerWithoutItem("sculk_berry", new SculkBerryBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).mapColor(state -> MapColor.COLOR_CYAN)));

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
    public static final Block GLOOMSLATE_BARRIER = register("gloomslate_barrier", new Block(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(-1, 3600000.0f).mapColor(MapColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops()));
    public static final Block FRAGILE_GLOOMSLATE_BRICKS = register("fragile_gloomslate_bricks", new FragileBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS).noLootTable().instabreak()));
    public static final Block GLOOMSLATE_LOCK = register("gloomslate_lock", new LockBlock(LockBlock.KeyType.LARGE, BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS).strength(-1, 3600000.0f).noLootTable()));
    public static final Block FORTIFIED_CUT_GLOOMSLATE = register("fortified_cut_gloomslate", new Block(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE).strength(-1, 3600000.0f).lightLevel(state -> 3).requiresCorrectToolForDrops()));

    public static final Block SCULK_GRIME = register("sculk_grime", new MudBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.6f).mapColor(MapColor.COLOR_CYAN)));
    public static final Block SCULK_GRIME_BRICKS = register("sculk_grime_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final Block SCULK_GRIME_BRICK_SLAB = register("sculk_grime_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_GRIME_BRICK_STAIRS = register("sculk_grime_brick_stairs", new StairBlock(SCULK_GRIME_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_GRIME_BRICK_WALL = register("sculk_grime_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block FRAGILE_SCULK_GRIME_BRICKS = register("fragile_sculk_grime_bricks", new FragileBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS).noLootTable().instabreak()));
    public static final Block SCULK_GRIME_LOCK = register("sculk_grime_lock", new LockBlock(LockBlock.KeyType.SMALL, BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS).strength(-1, 3600000.0f).noLootTable()));
    public static final Block FORTIFIED_SCULK_GRIME_BRICKS = register("fortified_sculk_grime_bricks", new Block(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS).strength(-1, 3600000.0f).lightLevel(state -> 3).requiresCorrectToolForDrops()));

    public static final Block ECHO_SOIL = register("echo_soil", new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f).mapColor(MapColor.COLOR_PURPLE)));
    public static final Block ECHO_FARMLAND = register("echo_farmland", new EchoFarmlandBlock(BlockBehaviour.Properties.copy(ECHO_SOIL).strength(0.3f).mapColor(MapColor.COLOR_PURPLE)));
    public static final Block GLOOMY_SCULK = register("gloomy_sculk", new GloomySculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)));
    public static final Block GLOOMY_GEYSER = register("gloomy_geyser", new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 9)));
    public static final Block CRYSTALLIZED_AMBER = register("crystallized_amber", new CrystallizedAmberBlock(BlockBehaviour.Properties.of().strength(0.3f, 3f).lightLevel(state -> 1).sound(SoundType.GLASS).mapColor(MapColor.COLOR_ORANGE).noOcclusion()));
    public static final Block SCULK_GLEAM = register("sculk_gleam", new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 10).mapColor(MapColor.SAND)));

    public static final Block SCULK_STONE_COAL_ORE = register("sculk_stone_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(1, 4)));
    public static final Block SCULK_STONE_IRON_ORE = register("sculk_stone_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_COPPER_ORE = register("sculk_stone_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_GOLD_ORE = register("sculk_stone_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_REDSTONE_ORE = register("sculk_stone_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.copy(SCULK_STONE).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Block SCULK_STONE_EMERALD_ORE = register("sculk_stone_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(5, 10)));
    public static final Block SCULK_STONE_LAPIS_ORE = register("sculk_stone_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(4, 8)));
    public static final Block SCULK_STONE_DIAMOND_ORE = register("sculk_stone_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(5, 10)));
    public static final Block SCULK_STONE_LEAD_ORE = register("sculk_stone_lead_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block GLOOMSLATE_COAL_ORE = register("gloomslate_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(1, 4)));
    public static final Block GLOOMSLATE_IRON_ORE = register("gloomslate_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_COPPER_ORE = register("gloomslate_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_GOLD_ORE = register("gloomslate_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_REDSTONE_ORE = register("gloomslate_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.copy(GLOOMSLATE).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Block GLOOMSLATE_EMERALD_ORE = register("gloomslate_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(5, 10)));
    public static final Block GLOOMSLATE_LAPIS_ORE = register("gloomslate_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(4, 8)));
    public static final Block GLOOMSLATE_DIAMOND_ORE = register("gloomslate_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(5, 10)));

    public static final Block RAW_LEAD_BLOCK = register("raw_lead_block", new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.TERRACOTTA_CYAN)));
    public static final Block LEAD_BLOCK = register("lead_block", new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.TERRACOTTA_CYAN)));

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
    public static final Block LILY_FLOWER = registerWithoutItem("lily_flower", new LilyFlowerBlock(MobEffects.GLOWING, 6, BlockBehaviour.Properties.of().lightLevel(state -> 7).noCollission().instabreak().sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));

    public static final Block ANCIENT_VASE = register("ancient_vase", new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE)));

    public static final Block INFESTED_SCULK = register("infested_sculk", new InfestedSculkBlock(Blocks.SCULK, BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Block SCULK_JAW = register("sculk_jaw", new SculkJawBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).randomTicks()));
    public static final Block SOUNDPROOF_GLASS = register("soundproof_glass", new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS)));
    public static final Block SCULK_LAMP = register("sculk_lamp", new SculkLampBlock(BlockBehaviour.Properties.copy(SCULK_GLEAM).strength(-1, 3600000.0f).lightLevel(Blocks.litBlockEmission(15)).pushReaction(PushReaction.BLOCK)));
    public static final Block PROTECTED_SCULK_GLEAM = register("protected_sculk_gleam", new HalfTransparentBlock(BlockBehaviour.Properties.copy(SCULK_GLEAM).lightLevel(state -> 15).strength(-1, 3600000.0f).pushReaction(PushReaction.BLOCK)));
    public static final Block PROTECTED_SCULK_GRIME_GLASS = register("protected_sculk_grime_glass", new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(-1, 3600000.0f).pushReaction(PushReaction.BLOCK).mapColor(MapColor.COLOR_CYAN)));
    public static final Block SCULK_GRIME_GLASS = register("sculk_grime_glass", new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).mapColor(MapColor.COLOR_CYAN).strength(0.3f)));
    public static final Block SCULK_GRIME_GLASS_PANE = register("sculk_grime_glass_pane", new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_CYAN).strength(0.3f)));
    public static final Block RETURN_STATUE = register("return_statue", new ReturnStatueBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(-1, 3600000.0f).forceSolidOn().noLootTable().pushReaction(PushReaction.BLOCK).isSuffocating(Blocks::never)));

    public static final Block SCULK_TISSUE = register("sculk_tissue", new SculkTissueBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.5f)));
    public static final Block SCULK_TISSUE_BRICKS = register("sculk_tissue_bricks", new Block(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_TISSUE_BRICK_STAIRS = register("sculk_tissue_brick_stairs", new StairBlock(SCULK_TISSUE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_TISSUE_BRICKS)));
    public static final Block SCULK_TISSUE_BRICK_SLAB = register("sculk_tissue_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_TISSUE_BRICKS)));
    public static final Block SCULK_TISSUE_BRICK_WALL = register("sculk_tissue_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_TISSUE_BRICKS)));
    public static final Block DARK_FOUNTAIN = register("dark_fountain", new DarkFountainBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.5f)));
    public static final Block SHADOW_CRYSTAL_BLOCK = register("shadow_crystal_block", new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block TOXIC_AIR = registerWithoutItem("toxic_air", new ToxicAirBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noCollission().randomTicks().noLootTable().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY)));

    public static final Block SCULK_BASALT = register("sculk_basalt", new Block(BlockBehaviour.Properties.copy(Blocks.BASALT).mapColor(MapColor.COLOR_BLACK)));
    public static final Block ACID = registerWithoutItem("acid", new AcidLiquidBlock(DDFluids.ACID, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).replaceable().noCollission().randomTicks().strength(100.0f).lightLevel(blockState -> 15).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY)));
    public static final Block FIZZ_BLOCK = register("fizz_block", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final Block RADIOACTIVE_BLOCK = register("radioactive_block", new Block(BlockBehaviour.Properties.copy(LEAD_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN)));

    public static final Block RED_CRYSTAL_BLOCK = register("red_crystal_block", new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 8)));
    public static final Block GREEN_CRYSTAL_BLOCK = register("green_crystal_block", new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 8)));
    public static final Block BLUE_CRYSTAL_BLOCK = register("blue_crystal_block", new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 8)));

    public static final Block SCULK_FIRE = registerWithoutItem("sculk_fire", new SculkFireBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_FIRE).mapColor(MapColor.COLOR_CYAN).lightLevel(blockState -> 15)));
    public static final Block SCULK_TORCH = registerWithoutItem("sculk_torch", new TorchBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_TORCH).lightLevel(blockState -> 15), DDParticleTypes.SCULK_FIRE_FLAME));
    public static final Block SCULK_WALL_TORCH = registerWithoutItem("sculk_wall_torch", new WallTorchBlock(BlockBehaviour.Properties.copy(SCULK_TORCH).dropsLike(SCULK_TORCH), DDParticleTypes.SCULK_FIRE_FLAME));
    public static final Block SCULK_CAMPFIRE = register("sculk_campfire", new CampfireBlock(false, 2, BlockBehaviour.Properties.copy(Blocks.SOUL_CAMPFIRE).lightLevel(Blocks.litBlockEmission(15))) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new DDCampfireBlockEntity(pos, state);
        }

        @Override
        @Nullable
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
            if (level.isClientSide()) {
                if (blockState.getValue(LIT)) {
                    return createTickerHelper(blockEntityType, DDBlockEntities.CAMPFIRE, DDCampfireBlockEntity::particleTick);
                }
            } else {
                if (blockState.getValue(LIT)) {
                    return createTickerHelper(blockEntityType, DDBlockEntities.CAMPFIRE, DDCampfireBlockEntity::cookTick);
                }
                return createTickerHelper(blockEntityType, DDBlockEntities.CAMPFIRE, DDCampfireBlockEntity::cooldownTick);
            }
            return null;
        }
    });
    public static final Block SCULK_LANTERN = register("sculk_lantern", new LanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN).lightLevel(blockState -> 15)));
    public static final Block PATIENCE_SOUL_FIRE = registerWithoutItem("patience_soul_fire", new DDSoulFireBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().instabreak().lightLevel(blockState -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY), () -> DDItems.PATIENCE_SOUL.getDefaultInstance()));
    public static final Block FORTITUDE_SOUL_FIRE = registerWithoutItem("fortitude_soul_fire", new DDSoulFireBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().lightLevel(blockState -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY), () -> DDItems.FORTITUDE_SOUL.getDefaultInstance()));
    public static final Block CORRUPTION_SOUL_FIRE = registerWithoutItem("corruption_soul_fire", new DDSoulFireBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).noCollission().instabreak().lightLevel(blockState -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY), () -> DDItems.CORRUPTION_SOUL.getDefaultInstance()));
    public static final Block PURITY_SOUL_FIRE = registerWithoutItem("purity_soul_fire", new DDSoulFireBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().lightLevel(blockState -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY), () -> DDItems.PURITY_SOUL.getDefaultInstance()));
    public static final Block VIRTUE_SOUL_FIRE = registerWithoutItem("virtue_soul_fire", new DDSoulFireBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().lightLevel(blockState -> 15).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY), () -> DDItems.VIRTUE_SOUL.getDefaultInstance()));

    public static final Block DEAD_MANS_CHEST = register("dead_mans_chest", new DeadMansChestBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));

    public static final Block SHATTERED_HEAD = registerWithoutItem("shattered_head", new ShatteredHeadBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CUSTOM_HEAD).strength(1.0f).pushReaction(PushReaction.DESTROY)));
    public static final Block SHATTERED_WALL_HEAD = registerWithoutItem("shattered_wall_head", new ShatteredWallHeadBlock(BlockBehaviour.Properties.of().strength(1.0f).dropsLike(SHATTERED_HEAD).pushReaction(PushReaction.DESTROY)));

    private static FlowerPotBlock createFlowerPot(Block block, FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(
                PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }

        return new FlowerPotBlock(block, properties);
    }

    public static Block register(String name, Block block) {
        Block registeredBlock = registerWithoutItem(name, block);
        DDItems.register(name, new BlockItem(block, new Item.Properties()));
        return registeredBlock;
    }

    public static Block registerWithoutItem(String name, Block block) {
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

        StrippableBlockRegistry.register(SCULK_SPRUCE_LOG, STRIPPED_SCULK_SPRUCE_LOG);
        StrippableBlockRegistry.register(SCULK_SPRUCE_WOOD, STRIPPED_SCULK_SPRUCE_WOOD);
        
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_LOG, 3, 3);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_WOOD, 3, 3);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_SCULK_SPRUCE_LOG, 3, 3);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_SCULK_SPRUCE_WOOD, 3, 3);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SCULK_SPRUCE_PLANKS, 5, 20);

        TillableBlockRegistry.register(ECHO_SOIL, HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(ECHO_FARMLAND.defaultBlockState()));
    }
}
