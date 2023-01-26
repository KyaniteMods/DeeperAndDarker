package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import java.util.function.Supplier;

public class DDConfiguredFeatures {
    // Features
    public static final Supplier<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = register("extra_sculk_gleam", DDFeatures.SCULK_GLEAM_BLOB);
    public static final Supplier<ConfiguredFeature<?, ?>> SCULKSTONE_PILLAR = register("otherside_pillar", DDFeatures.SCULK_PILLAR);
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_PILLAR = register("gloom_otherside_pillar", DDFeatures.GLOOM_SCULK_PILLAR);
    public static final Supplier<ConfiguredFeature<?, ?>> ECHO_TREE = register("echo_tree", DDFeatures.ECHO_TREE);
    public static final Supplier<ConfiguredFeature<?, ?>> SCULK_VINES = register("sculk_vines", DDFeatures.SCULK_VINES);
    public static final Supplier<ConfiguredFeature<?, ?>> SCULK_TENDRILS = register("sculk_tendrils", DDFeatures.SCULK_TENDRILS);
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOMSLATE = register("gloomslate", DDFeatures.GLOOMSLATE);


    // Decoration Gen
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_SCULK = RegistryHelper.registerConfiguredFeature("ore_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.SCULK_TARGET_LIST.get(), 64)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_ECHO_SAND = RegistryHelper.registerConfiguredFeature("ore_echo_sand", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ECHO_SAND_TARGET_LIST.get(), 32)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_INFESTED_SCULK = RegistryHelper.registerConfiguredFeature("ore_infested_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.INFESTED_SCULK_TARGET_LIST.get(), 3)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_GEYSER = RegistryHelper.registerConfiguredFeature("ore_geyser", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.GEYSER_TARGET_LIST.get(), 5)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_SCULK_JAW = RegistryHelper.registerConfiguredFeature("ore_sculk_jaw", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.SCULK_JAW_TARGET_LIST.get(), 8)));

    // Otherside Ores
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_COAL_SCULK = RegistryHelper.registerConfiguredFeature("ore_coal_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_COAL_TARGET_LIST.get(), 8, 0.1f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_IRON_SCULK = RegistryHelper.registerConfiguredFeature("ore_iron_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_IRON_TARGET_LIST.get(), 7)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_COPPER_SCULK = RegistryHelper.registerConfiguredFeature("ore_copper_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_COPPER_TARGET_LIST.get(), 6, 0.2f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_GOLD_SCULK = RegistryHelper.registerConfiguredFeature("ore_gold_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_GOLD_TARGET_LIST.get(), 7)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_REDSTONE_SCULK = RegistryHelper.registerConfiguredFeature("ore_redstone_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_REDSTONE_TARGET_LIST.get(), 6, 0.1f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_EMERALD_SCULK = RegistryHelper.registerConfiguredFeature("ore_emerald_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_EMERALD_TARGET_LIST.get(), 6, 0.4f)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_LAPIS_SCULK = RegistryHelper.registerConfiguredFeature("ore_lapis_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_LAPIS_TARGET_LIST.get(), 7)));
    public static final Supplier<ConfiguredFeature<?, ?>> ORE_DIAMOND_SCULK = RegistryHelper.registerConfiguredFeature("ore_diamond_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DDTargetLists.ORE_DIAMOND_TARGET_LIST.get(), 5, 0.7f)));
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_SCULK_VEGETATION_BASE = RegistryHelper.registerConfiguredFeature("gloom_sculk_vegetation", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 50).add(DDBlocks.GLOOM_CACTUS.get().defaultBlockState(), 35).add(DDBlocks.SCULK_TENDRILS.get().defaultBlockState(), 16)))));
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_SCULK_VEGETATION_COLLECTION = RegistryHelper.registerConfiguredFeature("gloom_sculk_bonemeal", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOM_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.GLOOM_SCULK.get()), PlacementUtils.inlinePlaced(Holder.direct(GLOOM_SCULK_VEGETATION_BASE.get())), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.3f, UniformInt.of(1, 2), 0.7f)));

    public static <F extends Feature<NoneFeatureConfiguration>> Supplier<ConfiguredFeature<?, ?>> register(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return RegistryHelper.registerConfiguredFeature(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Supplier<ConfiguredFeature<FC, ?>> register(String string, F feature, FC featureConfiguration) {
        return RegistryHelper.registerConfiguredFeature(string, () -> new ConfiguredFeature<>(feature, featureConfiguration));
    }

    public static void registerConfiguredFeatures() {

    }
}
