package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.features.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeeperDarker.MOD_ID);

    public static final RegistryObject<SculkStoneColumnFeature> SCULK_STONE_COLUMN = FEATURES.register("sculk_stone_column", () -> new SculkStoneColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<GloomslateColumnFeature> GLOOMSLATE_COLUMN = FEATURES.register("gloomslate_column", () -> new GloomslateColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<SculkGleamFeature> SCULK_GLEAM_BLOB = FEATURES.register("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<SculkTendrilsFeature> SCULK_TENDRILS = FEATURES.register("sculk_tendrils", () -> new SculkTendrilsFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<SculkVinesFeature> SCULK_VINES = FEATURES.register("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<GlowingRootsFeature> GLOWING_ROOTS = FEATURES.register("glowing_roots", () -> new GlowingRootsFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<GlowingVinesFeature> GLOWING_VINES = FEATURES.register("glowing_vines", () -> new GlowingVinesFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<BloomingStemFeature> BLOOMING_STEM = FEATURES.register("blooming_stem", () -> new BloomingStemFeature(NoneFeatureConfiguration.CODEC));
}
