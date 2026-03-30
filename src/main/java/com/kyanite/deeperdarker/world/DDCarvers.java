package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.*;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class DDCarvers {
    public static final WorldCarver<CaveCarverConfiguration> NOODLES = register("noodles", new DDNoodleCarver(CaveCarverConfiguration.CODEC));

    public static final ResourceKey<ConfiguredWorldCarver<?>> CONFIGURED_LARGE_CAVE = createKey("large_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> CONFIGURED_CAVE = createKey("cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> CONFIGURED_LOW_CAVE = createKey("low_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> CONFIGURED_NOODLES = createKey("noodles");

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        context.register(CONFIGURED_LARGE_CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(
                0.65f,
                UniformHeight.of(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10)),
                UniformFloat.of(0.4f, 0.9f),
                VerticalAnchor.bottom(),
                CarverDebugSettings.of(false, DDBlocks.BLOOM_BUTTON.defaultBlockState()),
                blocks.getOrThrow(DDTags.Blocks.OTHERSIDE_CARVER_REPLACEABLES),
                UniformFloat.of(0.9f, 1.5f),
                UniformFloat.of(1.1f, 1.3f),
                UniformFloat.of(-1, -0.4f)
        )));
        context.register(CONFIGURED_CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(
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
        context.register(CONFIGURED_LOW_CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(
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
        context.register(CONFIGURED_NOODLES, NOODLES.configured(new CaveCarverConfiguration(
                0.22f,
                UniformHeight.of(VerticalAnchor.aboveBottom(1), VerticalAnchor.belowTop(1)),
                UniformFloat.of(0.1f, 0.9f),
                VerticalAnchor.bottom(),
                CarverDebugSettings.of(false, DDBlocks.BLOOM_BUTTON.defaultBlockState()),
                blocks.getOrThrow(DDTags.Blocks.OTHERSIDE_CARVER_REPLACEABLES),
                UniformFloat.of(0.7f, 1.4f),
                UniformFloat.of(0.8f, 1.3f),
                UniformFloat.of(-1, -0.4f)
        )));
    }

    private static <T extends CarverConfiguration> WorldCarver<T> register(String id, WorldCarver<T> carver) {
        return Registry.register(BuiltInRegistries.CARVER, new ResourceLocation(DeeperDarker.MOD_ID, id), carver);
    }

    private static ResourceKey<ConfiguredWorldCarver<?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering carvers");
    }
}