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
    public static final ResourceKey<StructureProcessorList> SCULK_RUINS_DEGRADATION = createKey("sculk_ruins_degradation");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ProcessorRule ancientTempleRule1 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.12f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState());
        ProcessorRule ancientTempleRule2 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE.defaultBlockState());
        ProcessorRule ancientTempleRule3 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        ProcessorRule ancientTempleRule4 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH));
        ProcessorRule ancientTempleRule5 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST));
        ProcessorRule ancientTempleRule6 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH));
        ProcessorRule ancientTempleRule7 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST));
        ProcessorRule ancientTempleRule8 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule9 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule10 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule11 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP), 0.09f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule12 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH));
        ProcessorRule ancientTempleRule13 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST));
        ProcessorRule ancientTempleRule14 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH));
        ProcessorRule ancientTempleRule15 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST));
        ProcessorRule ancientTempleRule16 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.NORTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule17 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.EAST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule18 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.SOUTH).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule19 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.DEEPSLATE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP), 0.07f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, Direction.WEST).setValue(StairBlock.HALF, Half.TOP));
        ProcessorRule ancientTempleRule20 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_TILES, 0.25f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState());
        ProcessorRule ancientTempleRule21 = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLED_DEEPSLATE, 0.05f), AlwaysTrueTest.INSTANCE, Blocks.SMOOTH_BASALT.defaultBlockState());
        ProcessorRule ancientTempleRule22 = new ProcessorRule(new RandomBlockStateMatchTest(DDBlocks.ANCIENT_VASE.defaultBlockState(), 0.25f), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState());
        ProcessorRule ancientTempleRule23 = new ProcessorRule(new RandomBlockStateMatchTest(Blocks.SCULK_SENSOR.defaultBlockState(), 0.1f), AlwaysTrueTest.INSTANCE, Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true));
        ProcessorRule ancientTempleRule24 = new ProcessorRule(new RandomBlockMatchTest(Blocks.SCULK_SHRIEKER, 0.09f), AlwaysTrueTest.INSTANCE, Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true));
        ProcessorRule ancientTempleRule25 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_IRON_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_IRON_ORE.defaultBlockState());
        ProcessorRule ancientTempleRule26 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_COPPER_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_COPPER_ORE.defaultBlockState());
        ProcessorRule ancientTempleRule27 = new ProcessorRule(new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.16f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_GOLD_ORE.defaultBlockState());
        ProcessorRule ancientTempleRule28 = new ProcessorRule(new RandomBlockMatchTest(DDBlocks.SCULK_STONE_DIAMOND_ORE, 0.7f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE.defaultBlockState());
        ProcessorRule ancientTempleRule29 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DIAMOND_BLOCK, 0.5f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE_DIAMOND_ORE.defaultBlockState());

        context.register(ANCIENT_TEMPLE_DEGRADATION, new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.of(ancientTempleRule1, ancientTempleRule2, ancientTempleRule3, ancientTempleRule4, ancientTempleRule5, ancientTempleRule6, ancientTempleRule7, ancientTempleRule8, ancientTempleRule9, ancientTempleRule10, ancientTempleRule11, ancientTempleRule12, ancientTempleRule13, ancientTempleRule14, ancientTempleRule15, ancientTempleRule16, ancientTempleRule17, ancientTempleRule18, ancientTempleRule19, ancientTempleRule20, ancientTempleRule21, ancientTempleRule22, ancientTempleRule23, ancientTempleRule24, ancientTempleRule25, ancientTempleRule26, ancientTempleRule27, ancientTempleRule28, ancientTempleRule29)))));

        ProcessorRule sculkRuinsRule1 = new ProcessorRule(new RandomBlockMatchTest(DDBlocks.BLOOM_PLANKS, 0.66f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_TISSUE_BRICKS.defaultBlockState());
        ProcessorRule sculkRuinsRule2 = new ProcessorRule(new BlockMatchTest(DDBlocks.BLOOM_PLANKS), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState());

        context.register(SCULK_RUINS_DEGRADATION, new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.of(sculkRuinsRule1, sculkRuinsRule2)))));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, DeeperDarker.id(name));
    }
}