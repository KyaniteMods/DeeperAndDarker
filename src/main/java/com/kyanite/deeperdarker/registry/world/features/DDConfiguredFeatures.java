package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DDConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_GLEAM = feature("sculk_gleam", DDFeatures.SCULK_GLEAM_FEATURE);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_STONES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.SCULK_STONE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_STONE = CONFIGURED_FEATURES.register("sculk_stone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SCULK_STONES.get(), 64)));



    public static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, F feature, Supplier<C> config) {
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature, config.get()));
    }

    public static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, Supplier<F> feature, Supplier<C> config) {
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature.get(), config.get()));
    }

    public static <F extends Feature<NoneFeatureConfiguration>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, Supplier<F> feature) {
        return feature(id, feature, () -> NoneFeatureConfiguration.INSTANCE);
    }
}
