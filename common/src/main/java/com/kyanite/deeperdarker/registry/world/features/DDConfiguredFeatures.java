package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.BlockColumnFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DDConfiguredFeatures {
    // Features
    public static final Supplier<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = register("extra_sculk_gleam", DDFeatures.SCULK_GLEAM_BLOB);
    public static final Supplier<ConfiguredFeature<?, ?>> OTHERSIDE_PILLAR = register("otherside_pillar", DDFeatures.OTHERSIDE_PILLAR);
    public static final Supplier<ConfiguredFeature<?, ?>> ECHO_TREE = register("echo_tree", DDFeatures.ECHO_TREE);
    public static final Supplier<ConfiguredFeature<?, ?>> SCULK_VINES = register("sculk_vines", DDFeatures.SCULK_VINES);
    public static final Supplier<ConfiguredFeature<?, ?>> SCULK_TENDRILS = register("sculk_tendrils", DDFeatures.SCULK_TENDRILS);


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

    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_SCULK_VEGETATION = RegistryHelper.registerConfiguredFeature("gloom_sculk_vegetation", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 4).add(DDBlocks.GLOOM_CACTUS.get().defaultBlockState(), 1).add(DDBlocks.SCULK_TENDRILS.get().defaultBlockState(), 1)))));
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_SCULK_BONEMEAL = RegistryHelper.registerConfiguredFeature("gloom_sculk_bonemeal", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOM_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.GLOOM_SCULK.get()), PlacementUtils.inlinePlaced(Holder.direct(GLOOM_SCULK_VEGETATION.get())), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.3f, UniformInt.of(1, 2), 0.7f)));
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_CACTUS_SINGULAR = RegistryHelper.registerConfiguredFeature("gloom_cactus_lone", () -> new ConfiguredFeature<>(DDFeatures.GLOOM_CACTUS_FEATURE.get(), NoneFeatureConfiguration.INSTANCE));
    public static final Supplier<ConfiguredFeature<?, ?>> GLOOM_CACTUS_PATCH = RegistryHelper.registerConfiguredFeature("gloom_cactus_patch", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, Holder.direct(DDPlacedFeatures.GLOOM_CACTUS.get()))));

    public static <F extends Feature<NoneFeatureConfiguration>> Supplier<ConfiguredFeature<?, ?>> register(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return RegistryHelper.registerConfiguredFeature(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }

    public static void registerConfiguredFeatures() {

    }
}
