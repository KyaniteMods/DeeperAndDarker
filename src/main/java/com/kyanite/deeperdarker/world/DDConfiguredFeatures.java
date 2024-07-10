package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.features.config.VineFeatureConfiguration;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_STONE_COLUMN = createKey("sculk_stone_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMSLATE_COLUMN = createKey("gloomslate_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_GLEAM_EXTRA = createKey("sculk_gleam_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_TENDRILS = createKey("sculk_tendrils");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_VINES = createKey("sculk_vines");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_ROOTS = createKey("glowing_roots");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_VINES = createKey("glowing_vines");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_VINES_SHORT = createKey("glowing_vines_short");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_STONE_GENERATION = createKey("sculk_stone_generation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_SCULK_STONE = createKey("surface_sculk_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_DECORATION = createKey("sculk_decoration");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_PATCH = createKey("sculk_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOMING_SCULK_VEGETATION = createKey("blooming_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOMING_SCULK_PATCH = createKey("blooming_sculk_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ICE_LILY = createKey("patch_ice_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMSLATE_GENERATION = createKey("gloomslate_generation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_GLOOMSLATE = createKey("surface_gloomslate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_PATCH = createKey("gloomy_sculk_patch");

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_INFESTED_SCULK = createKey("ore_infested_sculk");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_SCULK_JAW = createKey("ore_sculk_jaw");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_ECHO_SOIL = createKey("ore_echo_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_COAL = createKey("ore_sculk_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_IRON = createKey("ore_sculk_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_COPPER = createKey("ore_sculk_copper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_GOLD = createKey("ore_sculk_gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_REDSTONE = createKey("ore_sculk_redstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_EMERALD = createKey("ore_sculk_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_LAPIS = createKey("ore_sculk_lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_DIAMOND = createKey("ore_sculk_diamond");

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_BLOOMING_MOSS = createKey("ore_blooming_moss");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_EDGE_BLOOMING = createKey("water_edge_blooming");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POOL_BLOOMING = createKey("pool_blooming");

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_GLOOMY_SCULK = createKey("ore_gloomy_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MAGMA = createKey("ore_magma");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SOUL_SAND = createKey("ore_soul_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SOUL_SOIL = createKey("ore_soul_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_COAL = createKey("ore_gloomslate_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_IRON = createKey("ore_gloomslate_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_COPPER = createKey("ore_gloomslate_copper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_GOLD = createKey("ore_gloomslate_gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_REDSTONE = createKey("ore_gloomslate_redstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_EMERALD = createKey("ore_gloomslate_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_LAPIS = createKey("ore_gloomslate_lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_DIAMOND = createKey("ore_gloomslate_diamond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_ECHO = createKey("tree_echo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLANT_BLOOMING = createKey("plant_blooming");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        RuleTest sculkStone = new TagMatchTest(DDTags.Blocks.SCULK_STONE_REPLACEABLES);
        RuleTest gloomslate = new BlockMatchTest(DDBlocks.GLOOMSLATE.get());
        RuleTest sculkGrime = new BlockMatchTest(DDBlocks.SCULK_GRIME.get());

        List<OreConfiguration.TargetBlockState> infestedSculkTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.INFESTED_SCULK.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> sculkJawTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_JAW.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> echoSoilTarget = List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_GRIME.get()), DDBlocks.ECHO_SOIL.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> coalTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_COAL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> ironTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_IRON_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> copperTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_COPPER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> goldTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_GOLD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> redstoneTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_REDSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> emeraldTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_EMERALD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> lapisTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_LAPIS_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> diamondTarget = List.of(OreConfiguration.target(sculkStone, DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState()), OreConfiguration.target(gloomslate, DDBlocks.GLOOMSLATE_DIAMOND_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> bloomingMossTarget = List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.BLOOMING_SCULK_STONE.get()), DDBlocks.BLOOMING_MOSS_BLOCK.get().defaultBlockState()), OreConfiguration.target(sculkGrime, DDBlocks.BLOOMING_MOSS_BLOCK.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> gloomySculkTarget = List.of(OreConfiguration.target(sculkGrime, DDBlocks.GLOOMY_SCULK.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> soulSandTarget = List.of(OreConfiguration.target(sculkGrime, Blocks.SOUL_SAND.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> soulSoilTarget = List.of(OreConfiguration.target(sculkGrime, Blocks.SOUL_SOIL.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> magmaTarget = List.of(OreConfiguration.target(sculkGrime, Blocks.MAGMA_BLOCK.defaultBlockState()));

        FeatureUtils.register(context, SCULK_STONE_COLUMN, DDFeatures.SCULK_STONE_COLUMN.get());
        FeatureUtils.register(context, GLOOMSLATE_COLUMN, DDFeatures.GLOOMSLATE_COLUMN.get());
        FeatureUtils.register(context, SCULK_GLEAM_EXTRA, DDFeatures.SCULK_GLEAM_BLOB.get());
        FeatureUtils.register(context, SCULK_TENDRILS, DDFeatures.SCULK_TENDRILS.get());
        FeatureUtils.register(context, SCULK_VINES, DDFeatures.VINE.get(), new VineFeatureConfiguration(DDBlocks.SCULK_VINES_PLANT.get().defaultBlockState(), DDBlocks.SCULK_VINES.get().defaultBlockState(), DDTags.Blocks.SCULK_VINE_PLACEABLE, UniformInt.of(1, 8), 0.2f, 0.25f));
        FeatureUtils.register(context, GLOWING_ROOTS, DDFeatures.GLOWING_ROOTS.get());
        FeatureUtils.register(context, GLOWING_VINES, DDFeatures.VINE.get(), new VineFeatureConfiguration(DDBlocks.GLOWING_VINES_PLANT.get().defaultBlockState(), DDBlocks.GLOWING_VINES.get().defaultBlockState(), DDTags.Blocks.GLOWING_VINE_PLACEABLE, UniformInt.of(6, 24), 0.12f, 0.125f));
        FeatureUtils.register(context, GLOWING_VINES_SHORT, DDFeatures.VINE.get(), new VineFeatureConfiguration(DDBlocks.GLOWING_VINES_PLANT.get().defaultBlockState(), DDBlocks.GLOWING_VINES.get().defaultBlockState(), DDTags.Blocks.GLOWING_VINE_PLACEABLE, UniformInt.of(1, 5), 0.1f, 0.1f));

        FeatureUtils.register(context, SCULK_STONE_GENERATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDBlocks.SCULK_STONE.get())));
        FeatureUtils.register(context, SURFACE_SCULK_STONE, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.SCULK_REPLACEABLES, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SCULK.defaultBlockState(), 1).add(DDBlocks.SCULK_STONE.get().defaultBlockState(), 2)), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(SCULK_STONE_GENERATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0, UniformInt.of(1, 2), 0.3f));
        FeatureUtils.register(context, SCULK_DECORATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SCULK_VEIN.defaultBlockState().setValue(PipeBlock.DOWN, true), 47).add(Blocks.SCULK_SENSOR.defaultBlockState(), 16).add(Blocks.SCULK_CATALYST.defaultBlockState(), 2).add(Blocks.SCULK_SHRIEKER.defaultBlockState().setValue(BlockStateProperties.CAN_SUMMON, true), 1))));
        FeatureUtils.register(context, SCULK_PATCH, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.SCULK_REPLACEABLES, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SCULK.defaultBlockState(), 6).add(DDBlocks.SCULK_STONE.get().defaultBlockState(), 2).add(DDBlocks.SCULK_GRIME.get().defaultBlockState(), 1)), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(SCULK_DECORATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(2, 3), 0.3f));
        FeatureUtils.register(context, BLOOMING_SCULK_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOWING_FLOWERS.get().defaultBlockState(), 1).add(DDBlocks.GLOWING_GRASS.get().defaultBlockState(), 1))));
        FeatureUtils.register(context, BLOOMING_SCULK_PATCH, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.BLOOMING_SCULK_STONE.get()), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(BLOOMING_SCULK_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.1f, UniformInt.of(1, 2), 0.5f));
        FeatureUtils.register(context, PATCH_ICE_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDBlocks.ICE_LILY.get())))));
        FeatureUtils.register(context, GLOOMSLATE_GENERATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDBlocks.GLOOMSLATE.get())));
        FeatureUtils.register(context, SURFACE_GLOOMSLATE, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMSLATE_REPLACEABLE, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 4).add(DDBlocks.GLOOMSLATE.get().defaultBlockState(), 1)), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(GLOOMSLATE_GENERATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0, ConstantInt.of(2), 0.3f));
        FeatureUtils.register(context, GLOOMY_SCULK_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 9).add(DDBlocks.GLOOMY_CACTUS.get().defaultBlockState(), 1))));
        FeatureUtils.register(context, GLOOMY_SCULK_PATCH, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 99).add(DDBlocks.GLOOMY_GEYSER.get().defaultBlockState(), 1)), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(GLOOMY_SCULK_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(1, 2), 0.7f));

        FeatureUtils.register(context, ORE_INFESTED_SCULK, Feature.ORE, new OreConfiguration(infestedSculkTarget, 9));
        FeatureUtils.register(context, ORE_SCULK_JAW, Feature.ORE, new OreConfiguration(sculkJawTarget, 6));
        FeatureUtils.register(context, ORE_ECHO_SOIL, Feature.ORE, new OreConfiguration(echoSoilTarget, 64));
        FeatureUtils.register(context, ORE_SCULK_COAL, Feature.ORE, new OreConfiguration(coalTarget, 14, 0.2f));
        FeatureUtils.register(context, ORE_SCULK_IRON, Feature.ORE, new OreConfiguration(ironTarget, 13, 0.3f));
        FeatureUtils.register(context, ORE_SCULK_COPPER, Feature.ORE, new OreConfiguration(copperTarget, 15, 0.3f));
        FeatureUtils.register(context, ORE_SCULK_GOLD, Feature.ORE, new OreConfiguration(goldTarget, 13, 0.4f));
        FeatureUtils.register(context, ORE_SCULK_REDSTONE, Feature.ORE, new OreConfiguration(redstoneTarget, 8, 0.5f));
        FeatureUtils.register(context, ORE_SCULK_EMERALD, Feature.ORE, new OreConfiguration(emeraldTarget, 3, 0.4f));
        FeatureUtils.register(context, ORE_SCULK_LAPIS, Feature.ORE, new OreConfiguration(lapisTarget, 10, 0.7f));
        FeatureUtils.register(context, ORE_SCULK_DIAMOND, Feature.ORE, new OreConfiguration(diamondTarget, 7, 0.4f));

        FeatureUtils.register(context, ORE_BLOOMING_MOSS, Feature.ORE, new OreConfiguration(bloomingMossTarget, 40));
        FeatureUtils.register(context, WATER_EDGE_BLOOMING, Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.BLOOMING_POOL_REPLACEABLE, BlockStateProvider.simple(DDBlocks.BLOOMING_SCULK_STONE.get()), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(BLOOMING_SCULK_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(4), 0.8f, 3, 0f, UniformInt.of(2, 5), 0.3f));
        FeatureUtils.register(context, POOL_BLOOMING, DDFeatures.POOL.get());

        FeatureUtils.register(context, ORE_GLOOMY_SCULK, Feature.ORE, new OreConfiguration(gloomySculkTarget, 64));
        FeatureUtils.register(context, ORE_MAGMA, Feature.ORE, new OreConfiguration(magmaTarget, 64));
        FeatureUtils.register(context, ORE_SOUL_SAND, Feature.ORE, new OreConfiguration(soulSandTarget, 48));
        FeatureUtils.register(context, ORE_SOUL_SOIL, Feature.ORE, new OreConfiguration(soulSoilTarget, 48));
        FeatureUtils.register(context, ORE_GLOOMSLATE_COAL, Feature.ORE, new OreConfiguration(coalTarget, 14, 0.3f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_IRON, Feature.ORE, new OreConfiguration(ironTarget, 13, 0.4f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_COPPER, Feature.ORE, new OreConfiguration(copperTarget, 15, 0.4f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_GOLD, Feature.ORE, new OreConfiguration(goldTarget, 13, 0.5f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_REDSTONE, Feature.ORE, new OreConfiguration(redstoneTarget, 8, 0.6f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_EMERALD, Feature.ORE, new OreConfiguration(emeraldTarget, 3, 0.6f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_LAPIS, Feature.ORE, new OreConfiguration(lapisTarget, 10, 0.7f));
        FeatureUtils.register(context, ORE_GLOOMSLATE_DIAMOND, Feature.ORE, new OreConfiguration(diamondTarget, 7, 0.6f));

        FeatureUtils.register(context, TREE_ECHO, Feature.TREE, createEcho().build());
        FeatureUtils.register(context, PLANT_BLOOMING, DDFeatures.BLOOMING_STEM.get());
    }

    private static TreeConfiguration.TreeConfigurationBuilder createEcho() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DDBlocks.ECHO_LOG.get()), new CherryTrunkPlacer(7, 1, 2, UniformInt.of(2, 3), UniformInt.of(2, 3), UniformInt.of(-5, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(DDBlocks.ECHO_LEAVES.get().defaultBlockState()), new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), UniformInt.of(5, 6), 0.25f, 0.4f, 0.65f, 0.4f), new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(DDBlocks.ECHO_SOIL.get())).decorators(List.of(new AttachedToLeavesDecorator(0.2f, 1, 0, BlockStateProvider.simple(DDBlocks.SCULK_GLEAM.get().defaultBlockState()), 2, List.of(Direction.DOWN))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, name));
    }
}
