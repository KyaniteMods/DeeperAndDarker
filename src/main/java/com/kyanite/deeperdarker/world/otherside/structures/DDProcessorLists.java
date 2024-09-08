package com.kyanite.deeperdarker.world.otherside.structures;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class DDProcessorLists {
    public static final ResourceKey<StructureProcessorList> ANCIENT_TEMPLE_DEGRADATION = createKey("ancient_temple_degradation");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ProcessorRule rule1 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.12f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState());
        ProcessorRule rule2 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE.defaultBlockState());
        ProcessorRule rule3 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        ProcessorRule rule4 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH));
        ProcessorRule rule5 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST));
        ProcessorRule rule6 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH));
        ProcessorRule rule7 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST));
        ProcessorRule rule8 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule9 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule10 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule11 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule12 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH));
        ProcessorRule rule13 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST));
        ProcessorRule rule14 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH));
        ProcessorRule rule15 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST));
        ProcessorRule rule16 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule17 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule18 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule19 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule rule20 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_TILES, 0.25f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState());
        ProcessorRule rule21 = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLED_DEEPSLATE, 0.05f), AlwaysTrueTest.INSTANCE, Blocks.SMOOTH_BASALT.defaultBlockState());
        ProcessorRule rule22 = new ProcessorRule(new RandomBlockStateMatchTest(DDBlocks.ANCIENT_VASE.defaultBlockState(), 0.25f), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState());
        ProcessorRule rule23 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.SCULK_SENSOR.defaultBlockState(), 0.1f), AlwaysTrueTest.INSTANCE, Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true));
        ProcessorRule rule24 = new ProcessorRule(new RandomBlockMatchTest(Blocks.SCULK_SHRIEKER, 0.09f), AlwaysTrueTest.INSTANCE, Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true));
        ProcessorRule rule25 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_IRON_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_IRON_ORE.defaultBlockState());
        ProcessorRule rule26 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_COPPER_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_COPPER_ORE.defaultBlockState());
        ProcessorRule rule27 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_GOLD_ORE.defaultBlockState());
        ProcessorRule rule28 = new ProcessorRule(new RandomBlockMatchTest(DDBlocks.SCULK_STONE_DIAMOND_ORE, 0.7f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE.defaultBlockState());
        ProcessorRule rule29 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DIAMOND_BLOCK, 0.5f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_DIAMOND_ORE.defaultBlockState());

        context.register(ANCIENT_TEMPLE_DEGRADATION, new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.of(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9, rule10, rule11, rule12, rule13, rule14, rule15, rule16, rule17, rule18, rule19, rule20, rule21, rule22, rule23, rule24, rule25, rule26, rule27, rule28, rule29)))));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}