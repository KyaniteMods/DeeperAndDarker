package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperAndDarker;
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
    public static final ResourceKey<PlacedFeature> SCULK = registerKey("sculk");
    public static final ResourceKey<PlacedFeature> ECHO_SAND = registerKey("echo_sand");
    public static final ResourceKey<PlacedFeature> INFESTED_SCULK = registerKey("infested_sculk");
    public static final ResourceKey<PlacedFeature> GEYSER = registerKey("geyser");
    public static final ResourceKey<PlacedFeature> SCULK_JAW = registerKey("sculk_jaw");

    public static final ResourceKey<PlacedFeature> SCULK_COAL_ORE = registerKey("sculk_coal_ore");
    public static final ResourceKey<PlacedFeature> SCULK_IRON_ORE = registerKey("sculk_iron_ore");
    public static final ResourceKey<PlacedFeature> SCULK_COPPER_ORE = registerKey("sculk_copper_ore");
    public static final ResourceKey<PlacedFeature> SCULK_GOLD_ORE = registerKey("sculk_gold_ore");
    public static final ResourceKey<PlacedFeature> SCULK_REDSTONE_ORE = registerKey("sculk_redstone_ore");
    public static final ResourceKey<PlacedFeature> SCULK_EMERALD_ORE = registerKey("sculk_emerald_ore");
    public static final ResourceKey<PlacedFeature> SCULK_LAPIS_ORE = registerKey("sculk_lapis_ore");
    public static final ResourceKey<PlacedFeature> SCULK_DIAMOND_ORE = registerKey("sculk_diamond_ore");

    public static final ResourceKey<PlacedFeature> SCULK_GLEAM = registerKey("sculk_gleam");
    public static final ResourceKey<PlacedFeature> SCULK_VINES = registerKey("sculk_vines");
    public static final ResourceKey<PlacedFeature> SCULK_TENDRILS = registerKey("sculk_tendrils");
    public static final ResourceKey<PlacedFeature> OTHERSIDE_PILLAR = registerKey("otherside_pillar");
    public static final ResourceKey<PlacedFeature> ECHO_TREE_SPAWN = registerKey("echo_tree_placed");
    public static final ResourceKey<PlacedFeature> GLOOM_SCULK_VEGETATION = registerKey("gloom_sculk_vegetation");
    public static final ResourceKey<PlacedFeature> GLOOMSTONE_PILLAR = registerKey("gloom_otherside_pillar");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE = registerKey("gloomslate");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(SCULK, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_SCULK), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        context.register(ECHO_SAND, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_ECHO_SAND), commonOrePlacement(200, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        context.register(INFESTED_SCULK, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_INFESTED_SCULK), commonOrePlacement(35, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        context.register(GEYSER, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_GEYSER), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        context.register(SCULK_JAW, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_JAW), commonOrePlacement(250, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

        context.register(SCULK_COAL_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_COAL_SCULK), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.belowTop(64), VerticalAnchor.top()))));
        context.register(SCULK_IRON_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_IRON_SCULK), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
        context.register(SCULK_COPPER_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_COPPER_SCULK), commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
        context.register(SCULK_GOLD_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_COPPER_SCULK), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
        context.register(SCULK_REDSTONE_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_REDSTONE_SCULK), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
        context.register(SCULK_EMERALD_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_EMERALD_SCULK), rareOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30)))));
        context.register(SCULK_LAPIS_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_LAPIS_SCULK), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25)))));
        context.register(SCULK_DIAMOND_ORE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ORE_DIAMOND_SCULK), rareOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50)))));

        context.register(SCULK_GLEAM, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.EXTRA_SCULK_GLEAM), commonOrePlacement(26, PlacementUtils.FULL_RANGE)));
        context.register(SCULK_VINES, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.SCULK_VINES), commonOrePlacement(32, PlacementUtils.FULL_RANGE)));
        context.register(SCULK_TENDRILS, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.SCULK_TENDRILS), commonOrePlacement(55, PlacementUtils.FULL_RANGE)));
        context.register(OTHERSIDE_PILLAR, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.SCULKSTONE_PILLAR), commonOrePlacement(60, PlacementUtils.FULL_RANGE)));
        context.register(ECHO_TREE_SPAWN, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ECHO_TREE), echoTreePlacement()));
        context.register(GLOOM_SCULK_VEGETATION, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ECHO_TREE), vegetationPlacement()));
        context.register(GLOOMSTONE_PILLAR, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ECHO_TREE), gloomPillarPlacement()));
        context.register(GLOOMSLATE, new PlacedFeature(features.getOrThrow(DDConfiguredFeatures.ECHO_TREE), gloomSlatePlacement()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier range) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(InSquarePlacement.spread());
        builder.add(placementModifier);
        builder.add(range);
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static List<PlacementModifier> commonOrePlacement(int attempts, PlacementModifier range) {
        return orePlacement(CountPlacement.of(attempts), range);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier range) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), range);
    }

    public static List<PlacementModifier> gloomPillarPlacement() {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(CountOnEveryLayerPlacement.of(7));
        builder.add(InSquarePlacement.spread());
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static List<PlacementModifier> gloomSlatePlacement() {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(CountOnEveryLayerPlacement.of(10));
        builder.add(InSquarePlacement.spread());
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static List<PlacementModifier> vegetationPlacement() {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(CountOnEveryLayerPlacement.of(25));
        builder.add(InSquarePlacement.spread());
        builder.add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE);
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static List<PlacementModifier> echoTreePlacement() {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(InSquarePlacement.spread());
        builder.add(CountOnEveryLayerPlacement.of(8));
        builder.add(BiomeFilter.biome());
        return builder.build();
    }
}
