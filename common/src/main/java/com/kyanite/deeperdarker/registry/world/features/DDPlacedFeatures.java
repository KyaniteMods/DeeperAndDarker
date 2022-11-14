package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Supplier;

public class DDPlacedFeatures {

    public static final Supplier<PlacedFeature> SCULK = registerPlacedFeature("sculk", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_SCULK.get()), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static final Supplier<PlacedFeature> ECHO_SAND = registerPlacedFeature("echo_sand", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_ECHO_SAND.get()), commonOrePlacement(200, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static final Supplier<PlacedFeature> INFESTED_SCULK = registerPlacedFeature("infested_sculk", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_INFESTED_SCULK.get()), commonOrePlacement(35, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static final Supplier<PlacedFeature> GEYSER = registerPlacedFeature("geyser", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_GEYSER.get()), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

    public static final Supplier<PlacedFeature> SCULK_JAW = registerPlacedFeature("sculk_jaw", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_SCULK_JAW.get()), commonOrePlacement(250, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

    public static final Supplier<PlacedFeature> SCULK_COAL_ORE = registerPlacedFeature("sculk_coal_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_COAL_SCULK.get()), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.belowTop(64), VerticalAnchor.top()))));
    public static final Supplier<PlacedFeature> SCULK_IRON_ORE = registerPlacedFeature("sculk_iron_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_IRON_SCULK.get()), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
    public static final Supplier<PlacedFeature> SCULK_COPPER_ORE = registerPlacedFeature("sculk_copper_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_COPPER_SCULK.get()), commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
    public static final Supplier<PlacedFeature> SCULK_GOLD_ORE = registerPlacedFeature("sculk_gold_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_GOLD_SCULK.get()), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
    public static final Supplier<PlacedFeature> SCULK_REDSTONE_ORE = registerPlacedFeature("sculk_redstone_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_REDSTONE_SCULK.get()), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
    public static final Supplier<PlacedFeature> SCULK_EMERALD_ORE = registerPlacedFeature("sculk_emerald_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_EMERALD_SCULK.get()), rareOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30)))));
    public static final Supplier<PlacedFeature> SCULK_LAPIS_ORE = registerPlacedFeature("sculk_lapis_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_LAPIS_SCULK.get()), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25)))));
    public static final Supplier<PlacedFeature> SCULK_DIAMOND_ORE = registerPlacedFeature("sculk_diamond_ore", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_DIAMOND_SCULK.get()), rareOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50)))));

    public static final Supplier<PlacedFeature> SCULK_GLEAM = registerPlacedFeature("sculk_gleam", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.EXTRA_SCULK_GLEAM.get()), commonOrePlacement(26, PlacementUtils.FULL_RANGE)));
    public static final Supplier<PlacedFeature> SCULK_VINES = registerPlacedFeature("sculk_vines", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.SCULK_VINES.get()), commonOrePlacement(32, PlacementUtils.FULL_RANGE)));
    public static final Supplier<PlacedFeature> SCULK_TENDRILS = registerPlacedFeature("sculk_tendrils", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.SCULK_TENDRILS.get()), commonOrePlacement(55, PlacementUtils.FULL_RANGE)));

    public static final Supplier<PlacedFeature> OTHERSIDE_PILLAR = registerPlacedFeature("otherside_pillar", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.SCULKSTONE_PILLAR.get()), commonOrePlacement(60, PlacementUtils.FULL_RANGE)));
    public static final Supplier<PlacedFeature> ECHO_TREE_SPAWN = registerPlacedFeature("echo_tree_placed", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.ECHO_TREE.get()), echoTreePlacement()));

    public static final Supplier<PlacedFeature> GLOOM_SCULK_VEGETATION = registerPlacedFeature("gloom_sculk_vegetation", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.GLOOM_SCULK_VEGETATION_BASE.get()), vegetationPlacement()));
    public static final Supplier<PlacedFeature> GLOOMSTONE_PILLAR = registerPlacedFeature("gloom_otherside_pillar", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.GLOOM_PILLAR.get()), gloomPillarPlacement()));


    public static final Supplier<PlacedFeature> GLOOMSLATE = registerPlacedFeature("gloomslate", () -> new PlacedFeature(Holder.direct(DDConfiguredFeatures.GLOOMSLATE.get()), gloomSlatePlacement()));

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

    public static Supplier<PlacedFeature> registerPlacedFeature(String id, Supplier<PlacedFeature> placedFeature) {
        return RegistryHelper.registerPlacedFeature(id, placedFeature);
    }

    public static void registerPlacedFeatures() {}
}
