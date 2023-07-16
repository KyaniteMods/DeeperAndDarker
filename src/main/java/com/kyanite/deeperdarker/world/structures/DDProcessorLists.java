package com.kyanite.deeperdarker.world.structures;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class DDProcessorLists {
    public static final ResourceKey<StructureProcessorList> ANCIENT_TEMPLE_DEGRADATION = createKey("ancient_temple_degradation");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ProcessorRule rule1 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.1f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState());
        ProcessorRule rule2 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.05f), AlwaysTrueTest.INSTANCE, Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        ProcessorRule rule3 = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.07f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_DEEPSLATE.defaultBlockState());
        ProcessorRule rule4 = new ProcessorRule(new RandomBlockMatchTest(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), 0.7f), AlwaysTrueTest.INSTANCE, DDBlocks.SCULK_STONE.get().defaultBlockState());

        context.register(ANCIENT_TEMPLE_DEGRADATION, new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.of(rule1, rule2, rule3, rule4)))));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
