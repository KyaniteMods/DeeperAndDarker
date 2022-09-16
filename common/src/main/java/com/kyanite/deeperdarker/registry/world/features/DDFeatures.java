package com.kyanite.deeperdarker.registry.world.features;

import java.util.function.Supplier;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DDFeatures {
    public static Supplier<SculkGleamFeature> SCULK_GLEAM_BLOB = RegistryHelper.registerFeature("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static Supplier<SculkVinesFeature> SCULK_VINES = RegistryHelper.registerFeature("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static Supplier<OthersidePillarFeature> OTHERSIDE_PILLAR = RegistryHelper.registerFeature("otherside_pillar", () -> new OthersidePillarFeature(NoneFeatureConfiguration.CODEC));
    public static Supplier<EchoTreeFeature> ECHO_TREE = RegistryHelper.registerFeature("echo_tree", () -> new EchoTreeFeature(NoneFeatureConfiguration.CODEC));

    public static void registerFeatures() {

    }
}
