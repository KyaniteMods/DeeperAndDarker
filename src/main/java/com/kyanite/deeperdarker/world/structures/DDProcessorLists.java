package com.kyanite.deeperdarker.world.structures;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class DDProcessorLists {
    public static final ResourceKey<StructureProcessorList> ANCIENT_TEMPLE_DEGRADATION = createKey("ancient_temple_degradation");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        ProcessorRule rule = new ProcessorRule(new RandomBlockMatchTest(Blocks.DEEPSLATE_BRICKS, 0.15f), AlwaysTrueTest.INSTANCE, Blocks.LIME_WOOL.defaultBlockState());

        context.register(ANCIENT_TEMPLE_DEGRADATION, new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.of(rule)))));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
