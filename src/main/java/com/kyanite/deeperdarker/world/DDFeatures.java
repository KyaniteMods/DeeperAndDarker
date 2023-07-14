package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.features.SculkGleamFeature;
import com.kyanite.deeperdarker.world.features.SculkTendrilsFeature;
import com.kyanite.deeperdarker.world.features.SculkVinesFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeeperDarker.MOD_ID);

    public static final RegistryObject<SculkGleamFeature> SCULK_GLEAM_BLOB = FEATURES.register("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<SculkVinesFeature> SCULK_VINES = FEATURES.register("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<SculkTendrilsFeature> SCULK_TENDRILS = FEATURES.register("sculk_tendrils", () -> new SculkTendrilsFeature(NoneFeatureConfiguration.CODEC));
}
