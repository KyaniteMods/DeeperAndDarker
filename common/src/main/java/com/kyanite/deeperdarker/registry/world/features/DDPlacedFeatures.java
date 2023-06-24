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
    public static final ResourceKey<PlacedFeature> SCULK = key("sculk");
    public static final ResourceKey<PlacedFeature> ECHO_SAND = key("echo_sand");
    public static final ResourceKey<PlacedFeature> INFESTED_SCULK = key("infested_sculk");
    public static final ResourceKey<PlacedFeature> GEYSER = key("geyser");
    public static final ResourceKey<PlacedFeature> SCULK_JAW = key("sculk_jaw");

    public static final ResourceKey<PlacedFeature> SCULK_COAL_ORE = key("sculk_coal_ore");
    public static final ResourceKey<PlacedFeature> SCULK_IRON_ORE = key("sculk_iron_ore");
    public static final ResourceKey<PlacedFeature> SCULK_COPPER_ORE = key("sculk_copper_ore");
    public static final ResourceKey<PlacedFeature> SCULK_GOLD_ORE = key("sculk_gold_ore");
    public static final ResourceKey<PlacedFeature> SCULK_REDSTONE_ORE = key("sculk_redstone_ore");
    public static final ResourceKey<PlacedFeature> SCULK_EMERALD_ORE = key("sculk_emerald_ore");
    public static final ResourceKey<PlacedFeature> SCULK_LAPIS_ORE = key("sculk_lapis_ore");
    public static final ResourceKey<PlacedFeature> SCULK_DIAMOND_ORE = key("sculk_diamond_ore");

    public static final ResourceKey<PlacedFeature> SCULK_GLEAM = key("sculk_gleam");
    public static final ResourceKey<PlacedFeature> SCULK_VINES = key("sculk_vines");
    public static final ResourceKey<PlacedFeature> SCULK_TENDRILS = key("sculk_tendrils");
    public static final ResourceKey<PlacedFeature> OTHERSIDE_PILLAR = key("otherside_pillar");
    public static final ResourceKey<PlacedFeature> ECHO_TREE_SPAWN = key("echo_tree_placed");
    public static final ResourceKey<PlacedFeature> GLOOM_SCULK_VEGETATION = key("gloom_sculk_vegetation");
    public static final ResourceKey<PlacedFeature> GLOOMSTONE_PILLAR = key("gloom_otherside_pillar");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE = key("gloomslate");

    public static void featureRegistry(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SCULK, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_SCULK),
                        commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        register(context, ECHO_SAND, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_ECHO_SAND),
                        commonOrePlacement(200, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        register(context, INFESTED_SCULK, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_INFESTED_SCULK),
                        commonOrePlacement(35, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        register(context, GEYSER, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_GEYSER),
                commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        register(context, SCULK_JAW, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_SCULK_JAW),
                commonOrePlacement(250, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
        register(context, SCULK_COAL_ORE, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_COAL_SCULK),
                commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.belowTop(64), VerticalAnchor.top()))));
        register(context, SCULK_IRON_ORE, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_IRON_SCULK),
                commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
        register(context, SCULK_COPPER_ORE, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_COPPER_SCULK),
                commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
        register(context, SCULK_GOLD_ORE, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_COPPER_SCULK),
                commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
        register(context, SCULK_REDSTONE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(DDConfiguredFeatures.ORE_REDSTONE_SCULK),
                commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
    }

    private static ResourceKey<PlacedFeature> key(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, PlacedFeature feature) {
        context.register(key, feature);
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
