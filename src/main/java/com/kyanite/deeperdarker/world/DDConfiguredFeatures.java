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
    public static final RuleTest GLOOMSLATE_REPLACEABLES = new BlockMatchTest(DDBlocks.GLOOMSLATE);

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_STONE_COLUMN = createKey("sculk_stone_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMSLATE_COLUMN = createKey("gloomslate_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_GLEAM_EXTRA = createKey("sculk_gleam_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_TENDRILS = createKey("sculk_tendrils");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_VINES = createKey("sculk_vines");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_BONEMEAL = createKey("gloomy_sculk_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_SCULK = createKey("ore_sculk");
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_COAL = createKey("ore_gloomslate_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_IRON = createKey("ore_gloomslate_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_COPPER = createKey("ore_gloomslate_copper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_GOLD = createKey("ore_gloomslate_gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_REDSTONE = createKey("ore_gloomslate_redstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_EMERALD = createKey("ore_gloomslate_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_LAPIS = createKey("ore_gloomslate_lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GLOOMSLATE_DIAMOND = createKey("ore_gloomslate_diamond");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_ECHO = createKey("tree_echo");

    public static void init() {

    }

    private static TreeConfiguration.TreeConfigurationBuilder createEcho() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DDBlocks.ECHO_LOG), new CherryTrunkPlacer(7, 1, 2, UniformInt.of(2, 3), UniformInt.of(2, 3), UniformInt.of(-5, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(DDBlocks.ECHO_LEAVES.defaultBlockState()), new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), UniformInt.of(5, 6), 0.25f, 0.4f, 0.65f, 0.4f), new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(DDBlocks.ECHO_SOIL)).decorators(List.of(new AttachedToLeavesDecorator(0.2f, 1, 0, BlockStateProvider.simple(DDBlocks.SCULK_GLEAM.defaultBlockState()), 2, List.of(Direction.DOWN))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
