package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DDPlacedFeatures {
    public static final ResourceKey<PlacedFeature> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> feature = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context, GLOOMY_SCULK_VEGETATION, feature.getOrThrow(DDConfiguredFeatures.GLOOMY_SCULK_VEGETATION), PlacementUtils.isEmpty());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
