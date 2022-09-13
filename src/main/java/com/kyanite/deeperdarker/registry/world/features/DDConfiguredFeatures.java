package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DDConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), Blocks.SCULK.defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ECHO_SAND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.ECHO_SOIL.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> INFESTED_SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.INFESTED_SCULK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_JAW_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.SCULK_JAW.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COAL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_IRON_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COPPER_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_GOLD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_REDSTONE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_EMERALD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_LAPIS_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_DIAMOND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK = CONFIGURED_FEATURES.register("ore_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SCULK_TARGET_LIST.get(), 64)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_ECHO_SAND = CONFIGURED_FEATURES.register("ore_echo_sand", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ECHO_SAND_TARGET_LIST.get(), 32)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_INFESTED_SCULK = CONFIGURED_FEATURES.register("ore_infested_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INFESTED_SCULK_TARGET_LIST.get(), 3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_JAW = CONFIGURED_FEATURES.register("ore_sculk_jaw", () -> new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(SCULK_JAW_TARGET_LIST.get(), 8)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COAL_SCULK = CONFIGURED_FEATURES.register("ore_coal_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COAL_TARGET_LIST.get(), 8, 0.1f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_IRON_SCULK = CONFIGURED_FEATURES.register("ore_iron_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_IRON_TARGET_LIST.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COPPER_SCULK = CONFIGURED_FEATURES.register("ore_copper_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COPPER_TARGET_LIST.get(), 6, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GOLD_SCULK = CONFIGURED_FEATURES.register("ore_gold_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_GOLD_TARGET_LIST.get(), 6, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_REDSTONE_SCULK = CONFIGURED_FEATURES.register("ore_redstone_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_REDSTONE_TARGET_LIST.get(), 6, 0.1f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_EMERALD_SCULK = CONFIGURED_FEATURES.register("ore_emerald_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_EMERALD_TARGET_LIST.get(), 6, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LAPIS_SCULK = CONFIGURED_FEATURES.register("ore_lapis_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_LAPIS_TARGET_LIST.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DIAMOND_SCULK = CONFIGURED_FEATURES.register("ore_diamond_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_DIAMOND_TARGET_LIST.get(), 5, 0.7f)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = register("extra_sculk_gleam", DDFeatures.SCULK_GLEAM_BLOB);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_VINES = register("sculk_vines", DDFeatures.SCULK_VINES);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_TENDRILS = register("sculk_tendrils", DDFeatures.SCULK_TENDRILS);

    public static final RegistryObject<ConfiguredFeature<?, ?>> OTHERSIDE_PILLAR = register("otherside_pillar", DDFeatures.OTHERSIDE_PILLAR);

    public static final RegistryObject<ConfiguredFeature<?, ?>> ECHO_TREE = register("echo_tree", DDFeatures.ECHO_TREE);
    public static final Holder<PlacedFeature> ECHO_TREE_CHECKED = PlacementUtils.register("echo_tree_checked", ECHO_TREE.getHolder().get());
    public static final RegistryObject<ConfiguredFeature<?, ?>> ECHO_TREE_SPAWN = CONFIGURED_FEATURES.register("echo_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ECHO_TREE_CHECKED, 0.5f)), ECHO_TREE_CHECKED)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOOM_SCULK_VEGETATION = CONFIGURED_FEATURES.register("gloom_sculk_vegetation", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 4).add(DDBlocks.GLOOM_CACTUS.get().defaultBlockState(), 1).add(DDBlocks.SCULK_TENDRILS.get().defaultBlockState(), 1)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOOM_SCULK_BONEMEAL = CONFIGURED_FEATURES.register("gloom_sculk_bonemeal", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOM_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.GLOOM_SCULK.get()), PlacementUtils.inlinePlaced(GLOOM_SCULK_VEGETATION.getHolder().get()), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.3f, UniformInt.of(1, 2), 0.7f)));

    public static <F extends Feature<NoneFeatureConfiguration>> RegistryObject<ConfiguredFeature<?, ?>> register(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }
}
