package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Supplier;

public class DDFeatures {
    public static final Supplier<SculkGleamFeature> SCULK_GLEAM_BLOB = RegistryHelper.registerFeature("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<SculkVinesFeature> SCULK_VINES = RegistryHelper.registerFeature("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<OthersidePillarFeature> OTHERSIDE_PILLAR = RegistryHelper.registerFeature("otherside_pillar", () -> new OthersidePillarFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<EchoTreeFeature> ECHO_TREE = RegistryHelper.registerFeature("echo_tree", () -> new EchoTreeFeature(NoneFeatureConfiguration.CODEC));

    public static final Supplier<SculkTendrilFeature> SCULK_TENDRILS = RegistryHelper.registerFeature("sculk_tendrils", () -> new SculkTendrilFeature(NoneFeatureConfiguration.CODEC));


    public static void registerFeatures() {}
}
