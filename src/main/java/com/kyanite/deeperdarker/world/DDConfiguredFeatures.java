package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class DDConfiguredFeatures {
    public static final RuleTest SCULK_STONE_REPLACEABLES = new TagMatchTest(DDTags.Blocks.SCULK_STONE_REPLACEABLES);

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = registerKey("gloomy_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_BONEMEAL = registerKey("gloomy_sculk_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_COAL = registerKey("ore_sculk_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_IRON = registerKey("ore_sculk_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_COPPER = registerKey("ore_sculk_copper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_GOLD = registerKey("ore_sculk_gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_REDSTONE = registerKey("ore_sculk_redstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_EMERALD = registerKey("ore_sculk_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_LAPIS = registerKey("ore_sculk_lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SCULK_DIAMOND = registerKey("ore_sculk_diamond");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> feature = context.lookup(Registries.CONFIGURED_FEATURE);
        List<OreConfiguration.TargetBlockState> COAL_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> IRON_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> COPPER_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> GOLD_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> EMERALD_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> LAPIS_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(SCULK_STONE_REPLACEABLES, DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState()));

        FeatureUtils.register(context, GLOOMY_SCULK_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 9).add(DDBlocks.GLOOMY_CACTUS.get().defaultBlockState(), 1))));
        FeatureUtils.register(context, GLOOMY_SCULK_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.GLOOMY_SCULK.get()), PlacementUtils.inlinePlaced(feature.getOrThrow(GLOOMY_SCULK_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(1, 2), 0.7f));

        FeatureUtils.register(context, ORE_SCULK_COAL, Feature.ORE, new OreConfiguration(COAL_TARGET_LIST, 14));
        FeatureUtils.register(context, ORE_SCULK_IRON, Feature.ORE, new OreConfiguration(IRON_TARGET_LIST, 13));
        FeatureUtils.register(context, ORE_SCULK_COPPER, Feature.ORE, new OreConfiguration(COPPER_TARGET_LIST, 15));
        FeatureUtils.register(context, ORE_SCULK_GOLD, Feature.ORE, new OreConfiguration(GOLD_TARGET_LIST, 13));
        FeatureUtils.register(context, ORE_SCULK_REDSTONE, Feature.ORE, new OreConfiguration(REDSTONE_TARGET_LIST, 8));
        FeatureUtils.register(context, ORE_SCULK_EMERALD, Feature.ORE, new OreConfiguration(EMERALD_TARGET_LIST, 3, 0.4f));
        FeatureUtils.register(context, ORE_SCULK_LAPIS, Feature.ORE, new OreConfiguration(LAPIS_TARGET_LIST, 10));
        FeatureUtils.register(context, ORE_SCULK_DIAMOND, Feature.ORE, new OreConfiguration(DIAMOND_TARGET_LIST, 7, 0.1f));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
