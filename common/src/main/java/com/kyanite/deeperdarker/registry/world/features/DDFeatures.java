package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.world.features.custom.*;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.function.Supplier;

public class DDFeatures {
    public static final Supplier<SculkGleamFeature> SCULK_GLEAM_BLOB = RegistryHelper.registerFeature("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<SculkVinesFeature> SCULK_VINES = RegistryHelper.registerFeature("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<SculkPillarFeature> SCULK_PILLAR = RegistryHelper.registerFeature("otherside_pillar", () -> new SculkPillarFeature(NoneFeatureConfiguration.CODEC, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(DDBlocks.SCULK_STONE.get().defaultBlockState(), 100))));
    public static final Supplier<GloomPillarFeature> GLOOM_SCULK_PILLAR = RegistryHelper.registerFeature("gloom_otherside_pillar", () -> new GloomPillarFeature(NoneFeatureConfiguration.CODEC));

    public static final Supplier<EchoTreeFeature> ECHO_TREE = RegistryHelper.registerFeature("echo_tree", () -> new EchoTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<SculkTendrilFeature> SCULK_TENDRILS = RegistryHelper.registerFeature("sculk_tendrils", () -> new SculkTendrilFeature(NoneFeatureConfiguration.CODEC));

    public static final Supplier<GloomslateFeature> GLOOMSLATE = RegistryHelper.registerFeature("gloomslate", () -> new GloomslateFeature(NoneFeatureConfiguration.CODEC));

    public static void registerFeatures() {}
}
