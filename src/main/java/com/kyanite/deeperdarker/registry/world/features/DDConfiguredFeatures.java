package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DDConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_STONE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.SCULK_STONE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> INFESTED_SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.INFESTED_SCULK.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_STONE = CONFIGURED_FEATURES.register("ore_sculk_stone", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SCULK_STONE_TARGET_LIST.get(), 64)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_INFESTED_SCULK = CONFIGURED_FEATURES.register("ore_infested_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INFESTED_SCULK_TARGET_LIST.get(), 1)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = feature("extra_sculk_gleam", DDFeatures.SCULK_GLEAM_BLOB);

    public static <F extends Feature<NoneFeatureConfiguration>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }
}
