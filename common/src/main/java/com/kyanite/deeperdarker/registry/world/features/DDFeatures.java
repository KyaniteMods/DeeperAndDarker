package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DDFeatures {
    public static SculkGleamFeature SCULK_GLEAM_BLOB = new SculkGleamFeature(NoneFeatureConfiguration.CODEC);
    public static SculkVinesFeature SCULK_VINES = new SculkVinesFeature(NoneFeatureConfiguration.CODEC);
    public static OthersidePillarFeature OTHERSIDE_PILLAR = new OthersidePillarFeature(NoneFeatureConfiguration.CODEC);
    public static EchoTreeFeature ECHO_TREE = new EchoTreeFeature(NoneFeatureConfiguration.CODEC);

    public static void registerFeatures() {
        PlatformHelper.registerFeature("sculk_gleam_blob", SCULK_GLEAM_BLOB);
        PlatformHelper.registerFeature("sculk_vines", SCULK_VINES);
        PlatformHelper.registerFeature("otherside_pillar", OTHERSIDE_PILLAR);
        PlatformHelper.registerFeature("echo_tree", ECHO_TREE);
    }
}
