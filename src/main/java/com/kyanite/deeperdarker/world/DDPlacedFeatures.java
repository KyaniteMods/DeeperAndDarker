package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

public class DDPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SCULK_STONE_COLUMN = createKey("sculk_stone_column");
    public static final ResourceKey<PlacedFeature> GLOOMSLATE_COLUMN = createKey("gloomslate_column");
    public static final ResourceKey<PlacedFeature> SCULK_GLEAM = createKey("sculk_gleam");
    public static final ResourceKey<PlacedFeature> SCULK_GLEAM_FOREST = createKey("sculk_gleam_forest");
    public static final ResourceKey<PlacedFeature> SCULK_TENDRILS = createKey("sculk_tendrils");
    public static final ResourceKey<PlacedFeature> SCULK_VINES = createKey("sculk_vines");

    public static final ResourceKey<PlacedFeature> SURFACE_SCULK_STONE = createKey("surface_sculk_stone");
    public static final ResourceKey<PlacedFeature> SCULK_DECORATION = createKey("sculk_decoration");
    public static final ResourceKey<PlacedFeature> SURFACE_GLOOMSLATE = createKey("surface_gloomslate");
    public static final ResourceKey<PlacedFeature> GLOOMY_SCULK_VEGETATION = createKey("gloomy_sculk_vegetation");

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

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
