package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.world.features.*;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DDFeatures {
    public static final Feature SCULK_STONE_COLUMN = register("sculk_stone_column", new SculkStoneColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature GLOOMSLATE_COLUMN = register("gloomslate_column", new GloomslateColumnFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature SCULK_GLEAM_BLOB = register("sculk_gleam_blob", new SculkGleamFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature SCULK_TENDRILS = register("sculk_tendrils", new SculkTendrilsFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature SCULK_VINES = register("sculk_vines", new SculkVinesFeature(NoneFeatureConfiguration.CODEC));
    public static final Feature GLOWING_VINES = register("glowing_vines", new GlowingVinesFeature(NoneFeatureConfiguration.CODEC));

    public static final Feature BLOOMING_STEM = register("blooming_stem", new BloomingStemFeature(NoneFeatureConfiguration.CODEC));

    private static Feature<?> register(String id, Feature feature) {
        return Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, id), feature);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering world gen");
        DDConfiguredFeatures.init();
    }
}
