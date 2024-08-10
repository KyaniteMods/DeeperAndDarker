package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class DDCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> CAVE = createKey("cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> LOW_CAVE = createKey("low_cave");

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        context.register(CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(
                0.22f,
                UniformHeight.of(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10)),
                UniformFloat.of(0.1f, 0.9f),
                VerticalAnchor.bottom(),
                CarverDebugSettings.of(false, DDBlocks.BLOOM_BUTTON.defaultBlockState()),
                blocks.getOrThrow(DDTags.Blocks.OTHERSIDE_CARVER_REPLACEABLES),
                UniformFloat.of(0.7f, 1.4f),
                UniformFloat.of(0.8f, 1.3f),
                UniformFloat.of(-1, -0.4f)
        )));
        context.register(LOW_CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(
                0.3f,
                UniformHeight.of(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(32)),
                UniformFloat.of(0.1f, 0.9f),
                VerticalAnchor.aboveBottom(15),
                CarverDebugSettings.of(false, DDBlocks.ECHO_BUTTON.defaultBlockState()),
                blocks.getOrThrow(DDTags.Blocks.OTHERSIDE_CARVER_REPLACEABLES),
                UniformFloat.of(0.6f, 1.1f),
                UniformFloat.of(0.8f, 1.1f),
                UniformFloat.of(-1, -0.4f)
        )));
    }

    private static ResourceKey<ConfiguredWorldCarver<?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}