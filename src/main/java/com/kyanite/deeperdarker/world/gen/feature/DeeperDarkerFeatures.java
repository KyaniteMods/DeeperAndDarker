package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class DeeperDarkerFeatures {
    public static final RegistryKey<Feature<?>> GLOOMSLATE_COLUMN = RegistryKey.of(RegistryKeys.FEATURE, new Identifier(
            DeeperDarker.MOD_ID, "gloomslate_column"));
    public static final RegistryKey<Feature<?>> SCULK_GLEAM_BLOB = RegistryKey.of(RegistryKeys.FEATURE, new Identifier(DeeperDarker.MOD_ID, "sculk_gleam_blob"));
    public static final RegistryKey<Feature<?>> SCULK_TENDRILS = RegistryKey.of(RegistryKeys.FEATURE, new Identifier(DeeperDarker.MOD_ID, "sculk_tendrils"));
    public static final RegistryKey<Feature<?>> SCULK_VINES = RegistryKey.of(RegistryKeys.FEATURE, new Identifier(DeeperDarker.MOD_ID, "sculk_vines"));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker features");
        Registry.register(Registries.FEATURE, new Identifier(DeeperDarker.MOD_ID, "gloomslate_column"), new GloomslateColumnFeature(
                DefaultFeatureConfig.CODEC));
        Registry.register(Registries.FEATURE, new Identifier(DeeperDarker.MOD_ID, "sculk_gleam_blob"), new SculkGleamBlobFeature(
                DefaultFeatureConfig.CODEC));
        Registry.register(Registries.FEATURE, new Identifier(DeeperDarker.MOD_ID, "sculk_tendrils"), new SculkTendrilsFeature(
                DefaultFeatureConfig.CODEC));
        Registry.register(Registries.FEATURE, new Identifier(DeeperDarker.MOD_ID, "sculk_vines"), new SculkVinesFeature(
                DefaultFeatureConfig.CODEC));
    }
}
