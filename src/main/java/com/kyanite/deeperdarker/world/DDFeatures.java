package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.features.*;
import com.kyanite.deeperdarker.world.features.config.VineFeatureConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, DeeperDarker.MOD_ID);

    public static final DeferredHolder<Feature<?>, VineFeature> VINE = FEATURES.register("vine", () -> new VineFeature(VineFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, SculkStoneColumnFeature> SCULK_STONE_COLUMN = FEATURES.register("sculk_stone_column", () -> new SculkStoneColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, GloomslateColumnFeature> GLOOMSLATE_COLUMN = FEATURES.register("gloomslate_column", () -> new GloomslateColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, SculkGleamFeature> SCULK_GLEAM_BLOB = FEATURES.register("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, SculkTendrilsFeature> SCULK_TENDRILS = FEATURES.register("sculk_tendrils", () -> new SculkTendrilsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, GlowingRootsFeature> GLOWING_ROOTS = FEATURES.register("glowing_roots", () -> new GlowingRootsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, OthersidePoolFeature> POOL = FEATURES.register("pool", () -> new OthersidePoolFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, BloomingStemFeature> BLOOMING_STEM = FEATURES.register("blooming_stem", () -> new BloomingStemFeature(NoneFeatureConfiguration.CODEC));
}
