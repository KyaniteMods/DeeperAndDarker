package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class DDConfiguredFeatures {
    public static final RuleTest SCULK_STONE_REPLACEABLES = new TagMatchTest(DDTags.Blocks.SCULK_STONE_REPLACEABLES);

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_STONE_COLUMN = createKey("sculk_stone_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMSLATE_COLUMN = createKey("gloomslate_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_GLEAM_EXTRA = createKey("sculk_gleam_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_TENDRILS = createKey("sculk_tendrils");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_VINES = createKey("sculk_vines");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_BONEMEAL = createKey("gloomy_sculk_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_SCULK = createKey("ore_sculk");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_ECHO_SOIL = createKey("ore_echo_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_COAL = createKey("ore_sculk_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_IRON = createKey("ore_sculk_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_COPPER = createKey("ore_sculk_copper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_GOLD = createKey("ore_sculk_gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_REDSTONE = createKey("ore_sculk_redstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_EMERALD = createKey("ore_sculk_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_LAPIS = createKey("ore_sculk_lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_DIAMOND = createKey("ore_sculk_diamond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_ECHO = createKey("tree_echo");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        List<OreConfiguration.TargetBlockState> SCULK_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, Blocks.SCULK.defaultBlockState()), OreConfiguration.target(new BlockMatchTest(DDBlocks.ECHO_SOIL.get()), Blocks.SCULK.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> ECHO_SOIL_TARGET_LIST = List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_GRIME.get()), DDBlocks.ECHO_SOIL.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> COAL_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> IRON_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> COPPER_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> GOLD_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> EMERALD_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> LAPIS_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState()));

        FeatureUtils.register(context, SCULK_STONE_COLUMN, DDFeatures.SCULK_STONE_COLUMN.get());
        FeatureUtils.register(context, GLOOMSLATE_COLUMN, DDFeatures.GLOOMSLATE_COLUMN.get());
        FeatureUtils.register(context, SCULK_GLEAM_EXTRA, DDFeatures.SCULK_GLEAM_BLOB.get());
        FeatureUtils.register(context, SCULK_TENDRILS, DDFeatures.SCULK_TENDRILS.get());
        FeatureUtils.register(context, SCULK_VINES, DDFeatures.SCULK_VINES.get());

        FeatureUtils.register(context, GLOOMY_SCULK_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 9).add(DDBlocks.GLOOMY_CACTUS.get().defaultBlockState(), 1))));
        FeatureUtils.register(context, GLOOMY_SCULK_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.GLOOMY_SCULK.get()), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(GLOOMY_SCULK_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(1, 2), 0.7f));

        FeatureUtils.register(context, ORE_SCULK, Feature.ORE, new OreConfiguration(SCULK_TARGET_LIST, 40));
        FeatureUtils.register(context, ORE_ECHO_SOIL, Feature.ORE, new OreConfiguration(ECHO_SOIL_TARGET_LIST, 64));
        FeatureUtils.register(context, ORE_SCULK_COAL, Feature.ORE, new OreConfiguration(COAL_TARGET_LIST, 14));
        FeatureUtils.register(context, ORE_SCULK_IRON, Feature.ORE, new OreConfiguration(IRON_TARGET_LIST, 13));
        FeatureUtils.register(context, ORE_SCULK_COPPER, Feature.ORE, new OreConfiguration(COPPER_TARGET_LIST, 15));
        FeatureUtils.register(context, ORE_SCULK_GOLD, Feature.ORE, new OreConfiguration(GOLD_TARGET_LIST, 13));
        FeatureUtils.register(context, ORE_SCULK_REDSTONE, Feature.ORE, new OreConfiguration(REDSTONE_TARGET_LIST, 8));
        FeatureUtils.register(context, ORE_SCULK_EMERALD, Feature.ORE, new OreConfiguration(EMERALD_TARGET_LIST, 3, 0.4f));
        FeatureUtils.register(context, ORE_SCULK_LAPIS, Feature.ORE, new OreConfiguration(LAPIS_TARGET_LIST, 10));
        FeatureUtils.register(context, ORE_SCULK_DIAMOND, Feature.ORE, new OreConfiguration(DIAMOND_TARGET_LIST, 7, 0.1f));

        FeatureUtils.register(context, TREE_ECHO, Feature.TREE, createEcho().build());
    }

    private static TreeConfiguration.TreeConfigurationBuilder createEcho() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DDBlocks.ECHO_LOG.get()), new CherryTrunkPlacer(7, 1, 2, UniformInt.of(2, 3), UniformInt.of(2, 3), UniformInt.of(-5, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(DDBlocks.ECHO_LEAVES.get().defaultBlockState()), new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), UniformInt.of(5, 6), 0.25f, 0.4f, 0.65f, 0.4f), new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(DDBlocks.ECHO_SOIL.get())).decorators(List.of(new AttachedToLeavesDecorator(0.2f, 1, 0, BlockStateProvider.simple(DDBlocks.SCULK_GLEAM.get().defaultBlockState()), 2, List.of(Direction.DOWN))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
