package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class DDPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperDarker.MOD_ID);

    public static final RegistryObject<PlacedFeature> SCULK_STONE_COLUMN = PLACED_FEATURES.register("sculk_stone_column", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_STONE_COLUMN.getHolder().get(), countPlacement(14, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_COLUMN = PLACED_FEATURES.register("gloomslate_column", () -> new PlacedFeature(DDConfiguredFeatures.GLOOMSLATE_COLUMN.getHolder().get(), countPlacement(24, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SCULK_GLEAM = PLACED_FEATURES.register("sculk_gleam", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_GLEAM_EXTRA.getHolder().get(), countPlacement(16, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SCULK_GLEAM_FOREST = PLACED_FEATURES.register("sculk_gleam_forest", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_GLEAM_EXTRA.getHolder().get(), countPlacement(28, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SCULK_TENDRILS = PLACED_FEATURES.register("sculk_tendrils", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_TENDRILS.getHolder().get(), countPlacement(36, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SCULK_VINES = PLACED_FEATURES.register("sculk_vines", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_VINES.getHolder().get(), countPlacement(28, PlacementUtils.FULL_RANGE)));

    public static final RegistryObject<PlacedFeature> SURFACE_SCULK_STONE = PLACED_FEATURES.register("surface_sculk_stone", () -> new PlacedFeature(DDConfiguredFeatures.SURFACE_SCULK_STONE.getHolder().get(), countPlacement(55, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT)));
    public static final RegistryObject<PlacedFeature> SCULK_DECORATION = PLACED_FEATURES.register("sculk_decoration", () -> new PlacedFeature(DDConfiguredFeatures.SCULK_PATCH.getHolder().get(), countPlacement(86, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT)));
    public static final RegistryObject<PlacedFeature> SURFACE_GLOOMSLATE = PLACED_FEATURES.register("surface_gloomslate", () -> new PlacedFeature(DDConfiguredFeatures.SURFACE_GLOOMSLATE.getHolder().get(), countPlacement(32, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT)));
    public static final RegistryObject<PlacedFeature> GLOOMY_SCULK_VEGETATION = PLACED_FEATURES.register("gloomy_sculk_vegetation", () -> new PlacedFeature(DDConfiguredFeatures.GLOOMY_SCULK_PATCH.getHolder().get(), countPlacement(256, PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT)));

    public static final RegistryObject<PlacedFeature> INFESTED_SCULK = PLACED_FEATURES.register("infested_sculk", () -> new PlacedFeature(DDConfiguredFeatures.ORE_INFESTED_SCULK.getHolder().get(), countPlacement(8, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(86)))));
    public static final RegistryObject<PlacedFeature> SCULK_JAW = PLACED_FEATURES.register("sculk_jaw", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_JAW.getHolder().get(), countPlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-92), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> ECHO_SOIL = PLACED_FEATURES.register("echo_soil", () -> new PlacedFeature(DDConfiguredFeatures.ORE_ECHO_SOIL.getHolder().get(), countPlacement(25, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SCULK_COAL = PLACED_FEATURES.register("sculk_coal", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_COAL.getHolder().get(), countPlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> SCULK_IRON = PLACED_FEATURES.register("sculk_iron", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_IRON.getHolder().get(), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
    public static final RegistryObject<PlacedFeature> SCULK_COPPER = PLACED_FEATURES.register("sculk_copper", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_COPPER.getHolder().get(), countPlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
    public static final RegistryObject<PlacedFeature> SCULK_GOLD = PLACED_FEATURES.register("sculk_gold", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_GOLD.getHolder().get(), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
    public static final RegistryObject<PlacedFeature> SCULK_REDSTONE = PLACED_FEATURES.register("sculk_redstone", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_REDSTONE.getHolder().get(), countPlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
    public static final RegistryObject<PlacedFeature> SCULK_EMERALD = PLACED_FEATURES.register("sculk_emerald", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_EMERALD.getHolder().get(), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30)))));
    public static final RegistryObject<PlacedFeature> SCULK_LAPIS = PLACED_FEATURES.register("sculk_lapis", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_LAPIS.getHolder().get(), countPlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25)))));
    public static final RegistryObject<PlacedFeature> SCULK_DIAMOND = PLACED_FEATURES.register("sculk_diamond", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_DIAMOND.getHolder().get(), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50)))));

    public static final RegistryObject<PlacedFeature> GLOOMY_SCULK = PLACED_FEATURES.register("gloomy_sculk", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMY_SCULK.getHolder().get(), countPlacement(96, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(32)))));
    public static final RegistryObject<PlacedFeature> MAGMA = PLACED_FEATURES.register("magma", () -> new PlacedFeature(DDConfiguredFeatures.ORE_MAGMA.getHolder().get(), countPlacement(128, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SOUL_SAND = PLACED_FEATURES.register("soul_sand", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SOUL_SAND.getHolder().get(), countPlacement(192, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> SOUL_SOIL = PLACED_FEATURES.register("soul_soil", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SOUL_SOIL.getHolder().get(), countPlacement(256, PlacementUtils.FULL_RANGE)));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_COAL = PLACED_FEATURES.register("gloomslate_coal", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_COAL.getHolder().get(), countPlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_IRON = PLACED_FEATURES.register("gloomslate_iron", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_IRON.getHolder().get(), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(128)))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_COPPER = PLACED_FEATURES.register("gloomslate_copper", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_COPPER.getHolder().get(), countPlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(24), VerticalAnchor.aboveBottom(256)))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_GOLD = PLACED_FEATURES.register("gloomslate_gold", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_GOLD.getHolder().get(), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(70)))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_REDSTONE = PLACED_FEATURES.register("gloomslate_redstone", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_REDSTONE.getHolder().get(), countPlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_EMERALD = PLACED_FEATURES.register("gloomslate_emerald", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_EMERALD.getHolder().get(), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(30)))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_LAPIS = PLACED_FEATURES.register("gloomslate_lapis", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_LAPIS.getHolder().get(), countPlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(25)))));
    public static final RegistryObject<PlacedFeature> GLOOMSLATE_DIAMOND = PLACED_FEATURES.register("gloomslate_diamond", () -> new PlacedFeature(DDConfiguredFeatures.ORE_GLOOMSLATE_DIAMOND.getHolder().get(), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50)))));

    public static final RegistryObject<PlacedFeature> ECHO_TREE = PLACED_FEATURES.register("echo_tree", () -> new PlacedFeature(DDConfiguredFeatures.TREE_ECHO.getHolder().get(), List.of(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(DDBlocks.ECHO_SAPLING.get().defaultBlockState(), BlockPos.ZERO)))));

    private static List<PlacementModifier> countPlacement(int attempts, PlacementModifier heightRange) {
        return List.of(CountPlacement.of(attempts), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }
}
