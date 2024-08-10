package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.features.*;
import com.kyanite.deeperdarker.world.features.config.VineFeatureConfiguration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DDFeatures {
    public static final Feature<VineFeatureConfiguration> VINE = register("vine", new VineFeature(VineFeatureConfiguration.CODEC));

    public static final Feature<NoneFeatureConfiguration> SCULK_STONE_COLUMN = register("sculk_stone_column", new SculkStoneColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> GLOOMSLATE_COLUMN = register("gloomslate_column", new GloomslateColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> SCULK_GLEAM_BLOB = register("sculk_gleam_blob", new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> SCULK_TENDRILS = register("sculk_tendrils", new SculkTendrilsFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> GLOWING_ROOTS = register("glowing_roots", new GlowingRootsFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> POOL = register("pool", new OthersidePoolFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature<NoneFeatureConfiguration> BLOOMING_STEM = register("blooming_stem", new BloomingStemFeature(NoneFeatureConfiguration.CODEC));

    private static <FC extends FeatureConfiguration> Feature<FC> register(String id, Feature<FC> feature) {
        return Registry.register(BuiltInRegistries.FEATURE, DeeperDarker.rl(id), feature);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering world gen");
    }
}
