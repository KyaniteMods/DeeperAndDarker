package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.function.Supplier;

public class DDConfiguredFeatures {
    // Features
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = key("extra_sculk_gleam");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULKSTONE_PILLAR = key("otherside_pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOM_PILLAR = key("gloom_otherside_pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ECHO_TREE = key("echo_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_VINES = key("sculk_vines");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCULK_TENDRILS = key("sculk_tendrils");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMSLATE = key("gloomslate");


    // Decoration Gen
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_SCULK = key("ore_sculk");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_ECHO_SAND = key("ore_echo_sand");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_INFESTED_SCULK = key("ore_infested_sculk");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_GEYSER = key("ore_geyser");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_SCULK_JAW = key("ore_sculk_jaw");

    // Otherside Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COAL_SCULK = key("ore_coal_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON_SCULK = key("ore_iron_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COPPER_SCULK = key("ore_copper_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD_SCULK = key("ore_gold_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_REDSTONE_SCULK = key("ore_redstone_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EMERALD_SCULK = key("ore_emerald_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LAPIS_SCULK = key("ore_lapis_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_SCULK = key("ore_diamond_sculk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOM_SCULK_VEGETATION_BASE = key("gloom_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOM_SCULK_VEGETATION_COLLECTION = key("gloom_sculk_bonemeal");

    public static void featureRegistry(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // Environmental stuff (trees/pillars/etc)
        register(context, EXTRA_SCULK_GLEAM, DDFeatures.SCULK_GLEAM_BLOB.get());
        register(context, SCULKSTONE_PILLAR, DDFeatures.SCULK_PILLAR.get());
        register(context, GLOOM_PILLAR, DDFeatures.GLOOM_SCULK_PILLAR.get());
        register(context, ECHO_TREE, DDFeatures.ECHO_TREE.get());
        register(context, SCULK_VINES, DDFeatures.SCULK_VINES.get());
        register(context, SCULK_TENDRILS, DDFeatures.SCULK_TENDRILS.get());
        register(context, GLOOMSLATE, DDFeatures.GLOOMSLATE.get());

        // Blocks/ores
        register(context, ORE_SCULK, Feature.ORE, new OreConfiguration(DDTargetLists.SCULK_TARGET_LIST.get(), 64));
        register(context, ORE_ECHO_SAND, Feature.ORE, new OreConfiguration(DDTargetLists.ECHO_SAND_TARGET_LIST.get(), 32));
        register(context, ORE_INFESTED_SCULK, Feature.ORE, new OreConfiguration(DDTargetLists.INFESTED_SCULK_TARGET_LIST.get(), 3));
        register(context, ORE_GEYSER, Feature.ORE, new OreConfiguration(DDTargetLists.GEYSER_TARGET_LIST.get(), 5));
        register(context, ORE_SCULK_JAW, Feature.ORE, new OreConfiguration(DDTargetLists.SCULK_JAW_TARGET_LIST.get(), 8));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        context.register(key, new ConfiguredFeature<>(feature, (FC)configuration));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
    }

    public static void registerConfiguredFeatures() {

    }
}
