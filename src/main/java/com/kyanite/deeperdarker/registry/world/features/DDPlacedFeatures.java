package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.util.DDPlacementUtils;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DDPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<PlacedFeature> SCULK_STONE_PLACED = PLACED_FEATURES.register("sculk_stone_placed", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_STONE.getHolder().get(), DDPlacementUtils.commonOrePlacement(32, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(200)))));

    public static final RegistryObject<PlacedFeature> INFESTED_SCULK_PLACED = PLACED_FEATURES.register("infested_sculk_placed",
            () -> new PlacedFeature(DDConfiguredFeatures.INFESTED_SCULK.getHolder().get(),
                    DDPlacementUtils.commonOrePlacement(64,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(50)))));

    public static final RegistryObject<PlacedFeature> PLACE_SCULK_GLEAM = PLACED_FEATURES.register("sculk_gleam_placed",
            () -> new PlacedFeature(DDConfiguredFeatures.SCULK_GLEAM.getHolder().get(), List.of(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome())));
}
