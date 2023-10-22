package com.kyanite.deeperdarker.world;

import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class DDConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperDarker.MOD_ID);

    public static final RuleTest SCULK_STONE_REPLACEABLES = new TagMatchTest(DDTags.Blocks.SCULK_STONE_TARGET);
    public static final RuleTest GLOOMSLATE_REPLACEABLES = new TagMatchTest(DDTags.Blocks.GLOOMSLATE_TARGET);
    public static final RuleTest SCULK_GRIME_REPLACEABLES = new TagMatchTest(DDTags.Blocks.SCULK_GRIME_TARGET);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> INFESTED_SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.INFESTED_SCULK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_JAW_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_JAW.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ECHO_SOIL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_GRIME.get()), DDBlocks.ECHO_SOIL.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> COAL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_COAL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> IRON_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_IRON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> COPPER_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_COPPER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> GOLD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_GOLD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> REDSTONE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_REDSTONE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> EMERALD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_EMERALD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LAPIS_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_LAPIS_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> DIAMOND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState()), OreConfiguration.target(GLOOMSLATE_REPLACEABLES, DDBlocks.GLOOMSLATE_DIAMOND_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> GLOOMY_SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_GRIME_REPLACEABLES, DDBlocks.GLOOMY_SCULK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SOUL_SAND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_GRIME_REPLACEABLES, Blocks.SOUL_SAND.defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SOUL_SOIL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_GRIME_REPLACEABLES, Blocks.SOUL_SOIL.defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> MAGMA_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(SCULK_GRIME_REPLACEABLES, Blocks.MAGMA_BLOCK.defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_STONE_COLUMN = register("sculk_stone_column", DDFeatures.SCULK_STONE_COLUMN);
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOOMSLATE_COLUMN = register("gloomslate_column", DDFeatures.GLOOMSLATE_COLUMN);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_GLEAM_EXTRA = register("sculk_gleam_extra", DDFeatures.SCULK_GLEAM_BLOB);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_TENDRILS = register("sculk_tendrils", DDFeatures.SCULK_TENDRILS);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_VINES = register("sculk_vines", DDFeatures.SCULK_VINES);

    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_STONE_GENERATION = CONFIGURED_FEATURES.register("sculk_stone_generation", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDBlocks.SCULK_STONE.get()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SURFACE_SCULK_STONE = CONFIGURED_FEATURES.register("surface_sculk_stone", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.SCULK_REPLACEABLES, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SCULK.defaultBlockState(), 1).add(DDBlocks.SCULK_STONE.get().defaultBlockState(), 2)), PlacementUtils.inlinePlaced(SCULK_STONE_GENERATION.getHolder().get()), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0, UniformInt.of(1, 2), 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_DECORATION = CONFIGURED_FEATURES.register("sculk_decoration", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true), 47).add(Blocks.SCULK_SENSOR.defaultBlockState(), 16).add(Blocks.SCULK_CATALYST.defaultBlockState(), 2).add(Blocks.SCULK_SHRIEKER.defaultBlockState().setValue(BlockStateProperties.CAN_SUMMON, true), 1)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_PATCH = CONFIGURED_FEATURES.register("sculk_patch", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.SCULK_REPLACEABLES, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SCULK.defaultBlockState(), 6).add(DDBlocks.SCULK_STONE.get().defaultBlockState(), 2).add(DDBlocks.SCULK_GRIME.get().defaultBlockState(), 1)), PlacementUtils.inlinePlaced(SCULK_DECORATION.getHolder().get()), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(2, 3), 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOOMSLATE_GENERATION = CONFIGURED_FEATURES.register("gloomslate_generation", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDBlocks.GLOOMSLATE.get()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SURFACE_GLOOMSLATE = CONFIGURED_FEATURES.register("surface_gloomslate", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMSLATE_REPLACEABLE, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 4).add(DDBlocks.GLOOMSLATE.get().defaultBlockState(), 1)), PlacementUtils.inlinePlaced(GLOOMSLATE_GENERATION.getHolder().get()), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0, ConstantInt.of(2), 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = CONFIGURED_FEATURES.register("gloomy_sculk_vegetation", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 9).add(DDBlocks.GLOOMY_CACTUS.get().defaultBlockState(), 1)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOOMY_SCULK_PATCH = CONFIGURED_FEATURES.register("gloomy_sculk_patch", () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 99).add(DDBlocks.GLOOMY_GEYSER.get().defaultBlockState(), 1)), PlacementUtils.inlinePlaced(GLOOMY_SCULK_VEGETATION.getHolder().get()), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(1, 2), 0.7f)));

    public static final RegistryObject<ConfiguredFeature<?,?>> ORE_INFESTED_SCULK = CONFIGURED_FEATURES.register("ore_infested_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INFESTED_SCULK_TARGET_LIST.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?,?>> ORE_SCULK_JAW = CONFIGURED_FEATURES.register("ore_sculk_jaw", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SCULK_JAW_TARGET_LIST.get(), 6)));
    public static final RegistryObject<ConfiguredFeature<?,?>> ORE_ECHO_SOIL = CONFIGURED_FEATURES.register("ore_echo_soil", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ECHO_SOIL_TARGET_LIST.get(), 64)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_COAL = CONFIGURED_FEATURES.register("ore_sculk_coal", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INFESTED_SCULK_TARGET_LIST.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_IRON = CONFIGURED_FEATURES.register("ore_sculk_iron", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(IRON_TARGET_LIST.get(), 13, 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_COPPER = CONFIGURED_FEATURES.register("ore_sculk_copper", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COPPER_TARGET_LIST.get(), 15, 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_GOLD = CONFIGURED_FEATURES.register("ore_sculk_gold", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GOLD_TARGET_LIST.get(), 13, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_REDSTONE = CONFIGURED_FEATURES.register("ore_sculk_redstone", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(REDSTONE_TARGET_LIST.get(), 8, 0.5f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_EMERALD = CONFIGURED_FEATURES.register("ore_sculk_emerald", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EMERALD_TARGET_LIST.get(), 3, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_LAPIS = CONFIGURED_FEATURES.register("ore_sculk_lapis", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LAPIS_TARGET_LIST.get(), 10, 0.7f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK_DIAMOND = CONFIGURED_FEATURES.register("ore_sculk_diamond", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DIAMOND_TARGET_LIST.get(), 7, 0.4f)));

    public static final RegistryObject<ConfiguredFeature<?,?>> ORE_GLOOMY_SCULK = CONFIGURED_FEATURES.register("ore_gloomy_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GLOOMY_SCULK_TARGET_LIST.get(), 64)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_MAGMA = CONFIGURED_FEATURES.register("ore_magma", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(MAGMA_TARGET_LIST.get(), 64)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SOUL_SAND = CONFIGURED_FEATURES.register("ore_soul_sand", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SOUL_SAND_TARGET_LIST.get(), 48)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SOUL_SOIL = CONFIGURED_FEATURES.register("ore_soul_soil", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SOUL_SOIL_TARGET_LIST.get(), 48)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_COAL = CONFIGURED_FEATURES.register("ore_gloomslate_coal", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COAL_TARGET_LIST.get(), 14, 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_IRON = CONFIGURED_FEATURES.register("ore_gloomslate_iron", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(IRON_TARGET_LIST.get(), 13, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_COPPER = CONFIGURED_FEATURES.register("ore_gloomslate_copper", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COPPER_TARGET_LIST.get(), 15, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_GOLD = CONFIGURED_FEATURES.register("ore_gloomslate_gold", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GOLD_TARGET_LIST.get(), 13, 0.5f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_REDSTONE = CONFIGURED_FEATURES.register("ore_gloomslate_redstone", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(REDSTONE_TARGET_LIST.get(), 8, 0.6f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_EMERALD = CONFIGURED_FEATURES.register("ore_gloomslate_emerald", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EMERALD_TARGET_LIST.get(), 3, 0.6f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_LAPIS = CONFIGURED_FEATURES.register("ore_gloomslate_lapis", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LAPIS_TARGET_LIST.get(), 10, 0.7f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_DIAMOND = CONFIGURED_FEATURES.register("ore_gloomslate_diamond", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DIAMOND_TARGET_LIST.get(), 7, 0.6f)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TREE_ECHO = CONFIGURED_FEATURES.register("tree_echo", () -> new ConfiguredFeature<>(Feature.TREE, createEcho().build()));

    private static TreeConfiguration.TreeConfigurationBuilder createEcho() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DDBlocks.ECHO_LOG.get()), new FancyTrunkPlacer(7, 1, 2), BlockStateProvider.simple(DDBlocks.ECHO_LEAVES.get().defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(DDBlocks.ECHO_SOIL.get())).decorators(List.of(new AttachedToLeavesDecorator(0.2f, 1, 0, BlockStateProvider.simple(DDBlocks.SCULK_GLEAM.get().defaultBlockState()), 2, List.of(Direction.DOWN))));
    }

    public static <F extends Feature<NoneFeatureConfiguration>> RegistryObject<ConfiguredFeature<?, ?>> register(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }
}
