package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.function.Supplier;

public class DDConfiguredFeatures {
    // Features
    public static final Supplier<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = register("extra_sculk_gleam", DDFeatures.SCULK_GLEAM_BLOB);
    public static final Supplier<ConfiguredFeature<?, ?>> OTHERSIDE_PILLAR = register("otherside_pillar", DDFeatures.OTHERSIDE_PILLAR);
    public static final Supplier<ConfiguredFeature<?, ?>> ECHO_TREE = register("echo_tree", DDFeatures.ECHO_TREE);
    public static final Supplier<ConfiguredFeature<?, ?>> SCULK_VINES = register("sculk_vines", DDFeatures.SCULK_VINES);

    // Decoration Gen
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_SCULK = RegistryHelper.registerConfiguredFeature("ore_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.SCULK_TARGET_LIST.get(), 64)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_ECHO_SAND = RegistryHelper.registerConfiguredFeature("ore_echo_sand", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ECHO_SAND_TARGET_LIST.get(), 32)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_INFESTED_SCULK = RegistryHelper.registerConfiguredFeature("ore_infested_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.INFESTED_SCULK_TARGET_LIST.get(), 3)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_SCULK_JAW = RegistryHelper.registerConfiguredFeature("ore_sculk_jaw", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.SCULK_JAW_TARGET_LIST.get(), 8)));

    // Otherside Ores
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_COAL_SCULK = RegistryHelper.registerConfiguredFeature("ore_coal_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_COAL_TARGET_LIST.get(), 8, 0.1f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_IRON_SCULK = RegistryHelper.registerConfiguredFeature("ore_iron_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_IRON_TARGET_LIST.get(), 7)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_COPPER_SCULK = RegistryHelper.registerConfiguredFeature("ore_copper_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_COPPER_TARGET_LIST.get(), 6, 0.2f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_GOLD_SCULK = RegistryHelper.registerConfiguredFeature("ore_gold_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_IRON_TARGET_LIST.get(), 7)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_REDSTONE_SCULK = RegistryHelper.registerConfiguredFeature("ore_redstone_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_REDSTONE_TARGET_LIST.get(), 6, 0.1f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_EMERALD_SCULK = RegistryHelper.registerConfiguredFeature("ore_emerald_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_EMERALD_TARGET_LIST.get(), 6, 0.4f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_LAPIS_SCULK = RegistryHelper.registerConfiguredFeature("ore_lapis_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_LAPIS_TARGET_LIST.get(), 7)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_DIAMOND_SCULK = RegistryHelper.registerConfiguredFeature("ore_diamond_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_DIAMOND_TARGET_LIST.get(), 5, 0.7f)));

    public static <F extends Feature<NoneFeatureConfiguration>> Supplier<ConfiguredFeature<?, ?>> register(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return RegistryHelper.registerConfiguredFeature(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }

    public static void registerConfiguredFeatures() {

    }
}
