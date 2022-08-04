package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DDPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<PlacedFeature> SCULK = PLACED_FEATURES.register("sculk", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK.getHolder().get(), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> INFESTED_SCULK = PLACED_FEATURES.register("infested_sculk", () -> new PlacedFeature(DDConfiguredFeatures.ORE_INFESTED_SCULK.getHolder().get(), commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

    public static final RegistryObject<PlacedFeature> SCULK_COAL_ORE = PLACED_FEATURES.register("sculk_coal_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_COAL_SCULK.getHolder().get(), commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.belowTop(64), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> SCULK_IRON_ORE = PLACED_FEATURES.register("sculk_iron_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_IRON_SCULK.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
    public static final RegistryObject<PlacedFeature> SCULK_COPPER_ORE = PLACED_FEATURES.register("sculk_copper_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_COPPER_SCULK.getHolder().get(), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
    public static final RegistryObject<PlacedFeature> SCULK_GOLD_ORE = PLACED_FEATURES.register("sculk_gold_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GOLD_SCULK.getHolder().get(), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
    public static final RegistryObject<PlacedFeature> SCULK_REDSTONE_ORE = PLACED_FEATURES.register("sculk_redstone_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_REDSTONE_SCULK.getHolder().get(), rareOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
    public static final RegistryObject<PlacedFeature> SCULK_EMERALD_ORE = PLACED_FEATURES.register("sculk_emerald_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_EMERALD_SCULK.getHolder().get(), rareOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(-16)))));
    public static final RegistryObject<PlacedFeature> SCULK_LAPIS_ORE = PLACED_FEATURES.register("sculk_lapis_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_LAPIS_SCULK.getHolder().get(), rareOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(20), VerticalAnchor.aboveBottom(52)))));
    public static final RegistryObject<PlacedFeature> SCULK_DIAMOND_ORE = PLACED_FEATURES.register("sculk_diamond_ore", () -> new PlacedFeature(DDConfiguredFeatures.ORE_DIAMOND_SCULK.getHolder().get(), rareOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));

    public static final RegistryObject<PlacedFeature> SCULK_GLEAM = PLACED_FEATURES.register("sculk_gleam", () -> new PlacedFeature(DDConfiguredFeatures.EXTRA_SCULK_GLEAM.getHolder().get(), commonOrePlacement(25, PlacementUtils.FULL_RANGE)));

    public static final RegistryObject<PlacedFeature> SCULK_VINES = PLACED_FEATURES.register("sculk_vines", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_VINES.getHolder().get(), commonOrePlacement(25, PlacementUtils.FULL_RANGE)));

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier range) {
        return List.of(placementModifier, InSquarePlacement.spread(), range, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int attempts, PlacementModifier range) {
        return orePlacement(CountPlacement.of(attempts), range);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier range) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), range);
    }
}