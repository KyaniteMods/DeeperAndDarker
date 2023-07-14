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
    public static final ResourceKey<PlacedFeature> SCULK_GLEAM = createKey("sculk_gleam");
    public static final ResourceKey<PlacedFeature> SCULK_TENDRILS = createKey("sculk_tendrils");
    public static final ResourceKey<PlacedFeature> SCULK_VINES = createKey("sculk_vines");

    public static final ResourceKey<PlacedFeature> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");

    public static final ResourceKey<PlacedFeature> SCULK = createKey("sculk");
    public static final ResourceKey<PlacedFeature> SCULK_COAL = createKey("sculk_coal");
    public static final ResourceKey<PlacedFeature> SCULK_IRON = createKey("sculk_iron");
    public static final ResourceKey<PlacedFeature> SCULK_COPPER = createKey("sculk_copper");
    public static final ResourceKey<PlacedFeature> SCULK_GOLD = createKey("sculk_gold");
    public static final ResourceKey<PlacedFeature> SCULK_REDSTONE = createKey("sculk_redstone");
    public static final ResourceKey<PlacedFeature> SCULK_EMERALD = createKey("sculk_emerald");
    public static final ResourceKey<PlacedFeature> SCULK_LAPIS = createKey("sculk_lapis");
    public static final ResourceKey<PlacedFeature> SCULK_DIAMOND = createKey("sculk_diamond");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, SCULK_GLEAM, features.getOrThrow(DDConfiguredFeatures.SCULK_GLEAM_EXTRA), commonOrePlacement(16, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_TENDRILS, features.getOrThrow(DDConfiguredFeatures.SCULK_TENDRILS), commonOrePlacement(42, PlacementUtils.FULL_RANGE));
        PlacementUtils.register(context, SCULK_VINES, features.getOrThrow(DDConfiguredFeatures.SCULK_VINES), commonOrePlacement(36, PlacementUtils.FULL_RANGE));

        PlacementUtils.register(context, GLOOMY_SCULK_VEGETATION, features.getOrThrow(DDConfiguredFeatures.GLOOMY_SCULK_VEGETATION), PlacementUtils.isEmpty());

        PlacementUtils.register(context, SCULK, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top())));
        PlacementUtils.register(context, SCULK_COAL, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_COAL), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.top())));
        PlacementUtils.register(context, SCULK_IRON, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_IRON), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128))));
        PlacementUtils.register(context, SCULK_COPPER, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_COPPER), commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256))));
        PlacementUtils.register(context, SCULK_GOLD, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_GOLD), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70))));
        PlacementUtils.register(context, SCULK_REDSTONE, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_REDSTONE), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))));
        PlacementUtils.register(context, SCULK_EMERALD, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_EMERALD), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30))));
        PlacementUtils.register(context, SCULK_LAPIS, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_LAPIS), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25))));
        PlacementUtils.register(context, SCULK_DIAMOND, features.getOrThrow(DDConfiguredFeatures.ORE_SCULK_DIAMOND), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50))));
    }

    public static List<PlacementModifier> commonOrePlacement(int pAttempts, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pAttempts), pHeightRange);
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier pModifier, PlacementModifier pHeightRange) {
        return List.of(pModifier, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
