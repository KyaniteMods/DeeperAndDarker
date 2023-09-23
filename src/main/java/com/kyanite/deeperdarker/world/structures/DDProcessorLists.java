package com.kyanite.deeperdarker.world.structures;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDProcessorLists {
    public static final DeferredRegister<StructureProcessorList> PROCESSOR_LISTS = DeferredRegister.create(Registry.PROCESSOR_LIST_REGISTRY, DeeperDarker.MOD_ID);

    public static final ProcessorRule RULE_1 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.12f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState());
    public static final ProcessorRule RULE_2 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE.defaultBlockState());
    public static final ProcessorRule RULE_3 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE.defaultBlockState());
    public static final ProcessorRule RULE_4 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH));
    public static final ProcessorRule RULE_5 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST));
    public static final ProcessorRule RULE_6 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH));
    public static final ProcessorRule RULE_7 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST));
    public static final ProcessorRule RULE_8 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_9 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_10 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_11 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_12 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH));
    public static final ProcessorRule RULE_13 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST));
    public static final ProcessorRule RULE_14 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH));
    public static final ProcessorRule RULE_15 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST));
    public static final ProcessorRule RULE_16 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_17 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_18 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_19 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP));
    public static final ProcessorRule RULE_20 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_TILES, 0.25f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState());
    public static final ProcessorRule RULE_21 = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLED_DEEPSLATE, 0.05f), AlwaysTrueTest.INSTANCE, Blocks.SMOOTH_BASALT.defaultBlockState());
    public static final ProcessorRule RULE_22 = new ProcessorRule(new RandomBlockStateMatchTest(DDBlocks.ANCIENT_VASE.get().defaultBlockState(), 0.25f), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState());
    public static final ProcessorRule RULE_23 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.SCULK_SENSOR.defaultBlockState(), 0.1f), AlwaysTrueTest.INSTANCE, Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true));
    public static final ProcessorRule RULE_24 = new ProcessorRule(new RandomBlockMatchTest(Blocks.SCULK_SHRIEKER, 0.09f), AlwaysTrueTest.INSTANCE, Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true));
    public static final ProcessorRule RULE_25 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_IRON_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState());
    public static final ProcessorRule RULE_26 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_COPPER_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState());
    public static final ProcessorRule RULE_27 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState());
    public static final ProcessorRule RULE_28 = new ProcessorRule(new RandomBlockMatchTest(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), 0.7f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE.get().defaultBlockState());
    public static final ProcessorRule RULE_29 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DIAMOND_BLOCK, 0.5f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState());

    public static final RegistryObject<StructureProcessorList> ANCIENT_TEMPLE_DEGRADATION = PROCESSOR_LISTS.register("ancient_temple_degradation", () -> new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.of(RULE_1, RULE_2, RULE_3, RULE_4, RULE_5, RULE_6, RULE_7, RULE_8, RULE_9, RULE_10, RULE_11, RULE_12, RULE_13, RULE_14, RULE_15, RULE_16, RULE_17, RULE_18, RULE_19, RULE_20, RULE_21, RULE_22, RULE_23, RULE_24, RULE_25, RULE_26, RULE_27, RULE_28, RULE_29)))));
}
