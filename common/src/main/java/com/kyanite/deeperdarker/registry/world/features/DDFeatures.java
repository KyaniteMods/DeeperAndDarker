package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.base.Supplier;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DDFeatures {
    public static Supplier<SculkGleamFeature> SCULK_GLEAM_BLOB = PlatformHelper.registerFeature("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static Supplier<SculkVinesFeature> SCULK_VINES = PlatformHelper.registerFeature("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static Supplier<OthersidePillarFeature> OTHERSIDE_PILLAR = PlatformHelper.registerFeature("otherside_pillar", () -> new OthersidePillarFeature(NoneFeatureConfiguration.CODEC));
    public static Supplier<EchoTreeFeature> ECHO_TREE = PlatformHelper.registerFeature("echo_tree", () -> new EchoTreeFeature(NoneFeatureConfiguration.CODEC));

    public static void registerFeatures() {

    }
}
