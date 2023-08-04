package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DDPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SCULK_STONE_COLUMN = createKey("sculk_stone_column");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_COLUMN = createKey("gloomslate_column");
    public static final ResourceKey<PlacedFeature> SCULK_GLEAM = createKey("sculk_gleam");
    public static final ResourceKey<PlacedFeature> SCULK_GLEAM_FOREST = createKey("sculk_gleam_forest");
    public static final ResourceKey<PlacedFeature> SCULK_TENDRILS = createKey("sculk_tendrils");
    public static final ResourceKey<PlacedFeature> SCULK_VINES = createKey("sculk_vines");

    public static final ResourceKey<PlacedFeature> SURFACE_SCULK_STONE = createKey("surface_sculk_stone");
    public static final ResourceKey<PlacedFeature> SURFACE_GLOOMSLATE = createKey("surface_gloomslate");
    public static final ResourceKey<PlacedFeature> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");

    public static final ResourceKey<PlacedFeature> SCULK = createKey("sculk");
    public static final ResourceKey<PlacedFeature> INFESTED_SCULK = createKey("infested_sculk");
    public static final ResourceKey<PlacedFeature> SCULK_JAW = createKey("sculk_jaw");
    public static final ResourceKey<PlacedFeature> ECHO_SOIL = createKey("echo_soil");
    public static final ResourceKey<PlacedFeature> SCULK_COAL = createKey("sculk_coal");
    public static final ResourceKey<PlacedFeature> SCULK_IRON = createKey("sculk_iron");
    public static final ResourceKey<PlacedFeature> SCULK_COPPER = createKey("sculk_copper");
    public static final ResourceKey<PlacedFeature> SCULK_GOLD = createKey("sculk_gold");
    public static final ResourceKey<PlacedFeature> SCULK_REDSTONE = createKey("sculk_redstone");
    public static final ResourceKey<PlacedFeature> SCULK_EMERALD = createKey("sculk_emerald");
    public static final ResourceKey<PlacedFeature> SCULK_LAPIS = createKey("sculk_lapis");
    public static final ResourceKey<PlacedFeature> SCULK_DIAMOND = createKey("sculk_diamond");

    public static final ResourceKey<PlacedFeature> GLOOMY_SCULK = createKey("gloomy_sculk");
    public static final ResourceKey<PlacedFeature> MAGMA = createKey("magma");
    public static final ResourceKey<PlacedFeature> SOUL_SAND = createKey("soul_sand");
    public static final ResourceKey<PlacedFeature> SOUL_SOIL = createKey("soul_soil");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_COAL = createKey("gloomslate_coal");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_IRON = createKey("gloomslate_iron");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_COPPER = createKey("gloomslate_copper");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_GOLD = createKey("gloomslate_gold");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_REDSTONE = createKey("gloomslate_redstone");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_EMERALD = createKey("gloomslate_emerald");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_LAPIS = createKey("gloomslate_lapis");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_DIAMOND = createKey("gloomslate_diamond");

    public static final ResourceKey<PlacedFeature> ECHO_TREE = createKey("echo_tree");

    public static void init(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, SCULK_STONE_COLUMN, features.getOrThrow(DDConfiguredFeatures.SCULK_STONE_COLUMN), countPlacement(14, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, GLOOMSLATE_COLUMN, features.getOrThrow(DDConfiguredFeatures.GLOOMSLATE_COLUMN), countPlacement(24, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_GLEAM, features.getOrThrow(DDConfiguredFeatures.SCULK_GLEAM_EXTRA), countPlacement(16, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_GLEAM_FOREST, features.getOrThrow(DDConfiguredFeatures.SCULK_GLEAM_EXTRA), countPlacement(28, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_TENDRILS, features.getOrThrow(DDConfiguredFeatures.SCULK_TENDRILS), countPlacement(36, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_VINES, features.getOrThrow(DDConfiguredFeatures.SCULK_VINES), countPlacement(28, PlacementUtils.FULL_RANGE));

        PlacementUtils.register(context, SURFACE_SCULK_STONE, features.getOrThrow(DDConfiguredFeatures.SURFACE_SCULK_STONE), countPlacement(55, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT));
        PlacementUtils.register(context, SURFACE_GLOOMSLATE, features.getOrThrow(DDConfiguredFeatures.SURFACE_GLOOMSLATE), countPlacement(32, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT));
        PlacementUtils.register(context, GLOOMY_SCULK_VEGETATION, features.getOrThrow(DDConfiguredFeatures.GLOOMY_SCULK_PATCH), countPlacement(256, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT));

        PlacementUtils.register(context, SCULK, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK), countPlacement(14, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, INFESTED_SCULK, features.getOrThrow(DDConfiguredFeatures.ORE_INFESTED_SCULK), countPlacement(14, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(86))));
        PlacementUtils.register(context, SCULK_JAW, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_JAW), countPlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-96), VerticalAnchor.top())));
        PlacementUtils.register(context, ECHO_SOIL, features.getOrThrow(DDConfiguredFeatures.ORE_ECHO_SOIL), countPlacement(25, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_COAL, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_COAL), countPlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.top())));
        PlacementUtils.register(context, SCULK_IRON, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_IRON), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128))));
        PlacementUtils.register(context, SCULK_COPPER, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_COPPER), countPlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256))));
        PlacementUtils.register(context, SCULK_GOLD, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_GOLD), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70))));
        PlacementUtils.register(context, SCULK_REDSTONE, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_REDSTONE), countPlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))));
        PlacementUtils.register(context, SCULK_EMERALD, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_EMERALD), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30))));
        PlacementUtils.register(context, SCULK_LAPIS, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_LAPIS), countPlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25))));
        PlacementUtils.register(context, SCULK_DIAMOND, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_DIAMOND), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50))));

        PlacementUtils.register(context, GLOOMY_SCULK, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMY_SCULK), countPlacement(96, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(32))));
        PlacementUtils.register(context, MAGMA, features.getOrThrow(DDConfiguredFeatures.ORE_MAGMA), countPlacement(128, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SOUL_SAND, features.getOrThrow(DDConfiguredFeatures.ORE_SOUL_SAND), countPlacement(192, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SOUL_SOIL, features.getOrThrow(DDConfiguredFeatures.ORE_SOUL_SOIL), countPlacement(256, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, GLOOMSLATE_COAL, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_COAL), countPlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.top())));
        PlacementUtils.register(context, GLOOMSLATE_IRON, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_IRON), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128))));
        PlacementUtils.register(context, GLOOMSLATE_COPPER, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_COPPER), countPlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256))));
        PlacementUtils.register(context, GLOOMSLATE_GOLD, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_GOLD), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70))));
        PlacementUtils.register(context, GLOOMSLATE_REDSTONE, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_REDSTONE), countPlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))));
        PlacementUtils.register(context, GLOOMSLATE_EMERALD, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_EMERALD), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30))));
        PlacementUtils.register(context, GLOOMSLATE_LAPIS, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_LAPIS), countPlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25))));
        PlacementUtils.register(context, GLOOMSLATE_DIAMOND, features.getOrThrow(DDConfiguredFeatures.ORE_GLOOMSLATE_DIAMOND), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50))));

        PlacementUtils.register(context, ECHO_TREE, features.getOrThrow(DDConfiguredFeatures.TREE_ECHO), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome());
    }

    private static List<PlacementModifier> countPlacement(int attempts, PlacementModifier heightRange) {
        return modifiedPlacement(CountPlacement.of(attempts), heightRange);
    }

    private static List<PlacementModifier> modifiedPlacement(PlacementModifier count, PlacementModifier heightRange) {
        return List.of(count, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
