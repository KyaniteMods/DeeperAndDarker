package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<OthersidePillarFeature> OTHERSIDE_PILLAR = FEATURES.register("otherside_pillar", () -> new OthersidePillarFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<SculkVinesFeature> SCULK_VINES = FEATURES.register("sculk_vines", () -> new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<SculkGleamFeature> SCULK_GLEAM_BLOB = FEATURES.register("sculk_gleam_blob", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
}
