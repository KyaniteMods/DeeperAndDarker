package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DeeperDarker.MODID);

    // Echo wood set
    private static final BlockSetType ECHO_SET = BlockSetType.register(new BlockSetType("echo"));
    public static final WoodType ECHO = WoodType.register(new WoodType("echo", ECHO_SET));
    public static final DeferredBlock<RotatedPillarBlock> ECHO_LOG = BLOCKS.register("echo_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.COLOR_PURPLE)));
    public static final DeferredBlock<RotatedPillarBlock> ECHO_WOOD = BLOCKS.register("echo_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_PURPLE)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_ECHO_LOG = BLOCKS.register("stripped_echo_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_PURPLE)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_ECHO_WOOD = BLOCKS.register("stripped_echo_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_PURPLE)));
    public static final DeferredBlock<Block> ECHO_PLANKS = BLOCKS.registerSimpleBlock("echo_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY));
    public static final DeferredBlock<StairBlock> ECHO_STAIRS = BLOCKS.register("echo_stairs", () -> new StairBlock(() -> ECHO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<SlabBlock> ECHO_SLAB = BLOCKS.register("echo_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<FenceBlock> ECHO_FENCE = BLOCKS.register("echo_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<FenceGateBlock> ECHO_FENCE_GATE = BLOCKS.register("echo_fence_gate", () -> new FenceGateBlock(ECHO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<DoorBlock> ECHO_DOOR = BLOCKS.register("echo_door", () -> new DoorBlock(ECHO_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<TrapDoorBlock> ECHO_TRAPDOOR = BLOCKS.register("echo_trapdoor", () -> new TrapDoorBlock(ECHO_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<PressurePlateBlock> ECHO_PRESSURE_PLATE = BLOCKS.register("echo_pressure_plate", () -> new PressurePlateBlock(ECHO_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<ButtonBlock> ECHO_BUTTON = BLOCKS.register("echo_button", () -> new ButtonBlock(ECHO_SET, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<LeavesBlock> ECHO_LEAVES = BLOCKS.register("echo_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.COLOR_PURPLE)));
    // TODO: Echo Sapling
    public static final DeferredBlock<StandingSignBlock> ECHO_SIGN = BLOCKS.register("echo_sign", () -> new StandingSignBlock(ECHO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<WallSignBlock> ECHO_WALL_SIGN = BLOCKS.register("echo_wall_sign", () -> new WallSignBlock(ECHO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).lootFrom(ECHO_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY)));

    // Bloom wood set
    private static final BlockSetType BLOOM_SET = BlockSetType.register(new BlockSetType("bloom"));
    public static final WoodType BLOOM = WoodType.register(new WoodType("bloom", BLOOM_SET));
    // TODO: Blooming Stem
    // TODO: Stripped Blooming Stem
    public static final DeferredBlock<Block> BLOOM_PLANKS = BLOCKS.registerSimpleBlock("bloom_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<StairBlock> BLOOM_STAIRS = BLOCKS.register("bloom_stairs", () -> new StairBlock(() -> BLOOM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<SlabBlock> BLOOM_SLAB = BLOCKS.register("bloom_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<FenceBlock> BLOOM_FENCE = BLOCKS.register("bloom_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<FenceGateBlock> BLOOM_FENCE_GATE = BLOCKS.register("bloom_fence_gate", () -> new FenceGateBlock(BLOOM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<DoorBlock> BLOOM_DOOR = BLOCKS.register("bloom_door", () -> new DoorBlock(BLOOM_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<TrapDoorBlock> BLOOM_TRAPDOOR = BLOCKS.register("bloom_trapdoor", () -> new TrapDoorBlock(BLOOM_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<PressurePlateBlock> BLOOM_PRESSURE_PLATE = BLOCKS.register("bloom_pressure_plate", () -> new PressurePlateBlock(BLOOM_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<ButtonBlock> BLOOM_BUTTON = BLOCKS.register("bloom_button", () -> new ButtonBlock(BLOOM_SET, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<StandingSignBlock> BLOOM_SIGN = BLOCKS.register("bloom_sign", () -> new StandingSignBlock(BLOOM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.GLOW_LICHEN)));
    public static final DeferredBlock<WallSignBlock> BLOOM_WALL_SIGN = BLOCKS.register("bloom_wall_sign", () -> new WallSignBlock(BLOOM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).lootFrom(BLOOM_SIGN).mapColor(MapColor.GLOW_LICHEN)));

    // TODO: Sculk Stone, Ores

    // TODO: Sculk Tendrils, Plant, Vines, Plant

    // TODO: Sculk Gleam, Echo Soil, Sculk Grime, Bricks

    // TODO: Gloomslate, Ores

    // TODO: Gloomy Sculk, Geyser, Grass, Cactus, Crystallized Amber

    // TODO: Glowing Flowers, Grass, Roots, Plant, Vines, Plant

    // TODO: Infested Sculk, Sculk Jaw

    // TODO: Ancient Vase

    // TODO: Otherside Portal
}
