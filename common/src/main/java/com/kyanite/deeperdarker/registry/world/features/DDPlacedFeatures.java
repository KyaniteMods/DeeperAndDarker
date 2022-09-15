package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DDPlacedFeatures {
    // Ores
    public static final PlacedFeature SCULK_COAL_ORE = registerPlacedFeature("sculk_coal_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_COAL_SCULK), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.belowTop(64), VerticalAnchor.top()))));
    public static final PlacedFeature SCULK_IRON_ORE = registerPlacedFeature("sculk_iron_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_IRON_SCULK), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
    public static final PlacedFeature SCULK_COPPER_ORE = registerPlacedFeature("sculk_copper_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_COPPER_SCULK), commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
    public static final PlacedFeature SCULK_GOLD_ORE = registerPlacedFeature("sculk_gold_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_GOLD_SCULK), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
    public static final PlacedFeature SCULK_REDSTONE_ORE = registerPlacedFeature("sculk_redstone_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_REDSTONE_SCULK), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
    public static final PlacedFeature SCULK_EMERALD_ORE = registerPlacedFeature("sculk_emerald_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_EMERALD_SCULK), rareOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30)))));
    public static final PlacedFeature SCULK_LAPIS_ORE = registerPlacedFeature("sculk_lapis_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_LAPIS_SCULK), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25)))));
    public static final PlacedFeature SCULK_DIAMOND_ORE = registerPlacedFeature("sculk_diamond_ore", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_DIAMOND_SCULK), rareOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50)))));

    public static PlacedFeature ECHO_TREE_SPAWN = registerPlacedFeature("echo_tree_placed", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ECHO_TREE), echoTreePlacement()));

    public static PlacedFeature SCULK_GLEAM = registerPlacedFeature("sculk_gleam", new PlacedFeature(Holder.direct(DDConfiguredFeatures.EXTRA_SCULK_GLEAM), commonOrePlacement(26, PlacementUtils.FULL_RANGE)));

    public static PlacedFeature SCULK_VINES = registerPlacedFeature("sculk_vines", new PlacedFeature(Holder.direct(DDConfiguredFeatures.SCULK_VINES), commonOrePlacement(32, PlacementUtils.FULL_RANGE)));

    public static PlacedFeature OTHERSIDE_PILLAR = registerPlacedFeature("otherside_pillar", new PlacedFeature(Holder.direct(DDConfiguredFeatures.OTHERSIDE_PILLAR), commonOrePlacement(60, PlacementUtils.FULL_RANGE)));
    public static PlacedFeature SCULK = registerPlacedFeature("sculk",  new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_SCULK), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static PlacedFeature SCULK_JAW = registerPlacedFeature("sculk_jaw", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_SCULK_JAW),commonOrePlacement(250, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static PlacedFeature INFESTED_SCULK = registerPlacedFeature("infested_sculk", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_INFESTED_SCULK), commonOrePlacement(35, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static PlacedFeature ECHO_SAND = registerPlacedFeature("echo_sand", new PlacedFeature(Holder.direct(DDConfiguredFeatures.ORE_ECHO_SAND), commonOrePlacement(200, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier range) {
        return List.of(placementModifier, InSquarePlacement.spread(), range, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int attempts, PlacementModifier range) {
        return orePlacement(CountPlacement.of(attempts), range);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier range) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), range);
    }

    public static List<PlacementModifier> echoTreePlacement() {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(InSquarePlacement.spread());
        builder.add(CountOnEveryLayerPlacement.of(8));
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static PlacedFeature registerPlacedFeature(String id, PlacedFeature placedFeature) {
        return PlatformHelper.registerPlacedFeature(id, placedFeature);
    }

    public static void registerPlacedFeatures() {

    }
}
