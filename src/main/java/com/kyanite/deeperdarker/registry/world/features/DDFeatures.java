package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DDFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeeperAndDarker.MOD_ID);

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<SculkGleamFeature> SCULK_GLEAM_FEATURE = registerFeature("sculk_gleam_feature", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<ConfiguredFeature<?, ?>>  SCULK_GLEAM = feature("sculk_gleam", SCULK_GLEAM_FEATURE);

    public static final RegistryObject<PlacedFeature> PLACE_SCULK_GLEAM = PLACED_FEATURES.register("sculk_gleam_placed",
            () -> new PlacedFeature(SCULK_GLEAM.getHolder().get(), List.of(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome())));

    public static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, F feature, Supplier<C> config) {
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature, config.get()));
    }

    public static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, Supplier<F> feature, Supplier<C> config) {
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature.get(), config.get()));
    }

    public static <F extends Feature<NoneFeatureConfiguration>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, Supplier<F> feature) {
        return feature(id, feature, () -> NoneFeatureConfiguration.INSTANCE);
    }

    private static <T extends Feature<?>> RegistryObject<T> registerFeature(final String name, final Supplier<T> sup) {
        return FEATURES.register(name, sup);
    }

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
        FEATURES.register(eventBus);
        PLACED_FEATURES.register(eventBus);
    }
}
