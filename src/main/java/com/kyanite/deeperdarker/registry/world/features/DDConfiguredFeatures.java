package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DDConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), Blocks.SCULK.defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> INFESTED_SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.INFESTED_SCULK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COAL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_IRON_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COPPER_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_GOLD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_REDSTONE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_EMERALD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_LAPIS_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_DIAMOND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SCULK = CONFIGURED_FEATURES.register("ore_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SCULK_TARGET_LIST.get(), 64)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_INFESTED_SCULK = CONFIGURED_FEATURES.register("ore_infested_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INFESTED_SCULK_TARGET_LIST.get(), 3)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COAL_SCULK = CONFIGURED_FEATURES.register("ore_coal_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COAL_TARGET_LIST.get(), 9, 0.1f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_IRON_SCULK = CONFIGURED_FEATURES.register("ore_iron_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_IRON_TARGET_LIST.get(), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COPPER_SCULK = CONFIGURED_FEATURES.register("ore_copper_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COPPER_TARGET_LIST.get(), 6, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GOLD_SCULK = CONFIGURED_FEATURES.register("ore_gold_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_GOLD_TARGET_LIST.get(), 6, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_REDSTONE_SCULK = CONFIGURED_FEATURES.register("ore_redstone_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_REDSTONE_TARGET_LIST.get(), 6, 0.1f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_EMERALD_SCULK = CONFIGURED_FEATURES.register("ore_emerald_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_EMERALD_TARGET_LIST.get(), 6, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LAPIS_SCULK = CONFIGURED_FEATURES.register("ore_lapis_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_LAPIS_TARGET_LIST.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DIAMOND_SCULK = CONFIGURED_FEATURES.register("ore_diamond_sculk", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_DIAMOND_TARGET_LIST.get(), 5, 0.7f)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXTRA_SCULK_GLEAM = feature("extra_sculk_gleam", DDFeatures.SCULK_GLEAM_BLOB);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCULK_VINES = feature("sculk_vines", DDFeatures.SCULK_VINES);

    public static <F extends Feature<NoneFeatureConfiguration>> RegistryObject<ConfiguredFeature<?, ?>> feature(String id, Supplier<F> feature) {
        Supplier<NoneFeatureConfiguration> configuration = () -> NoneFeatureConfiguration.INSTANCE;
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(feature.get(), configuration.get()));
    }
}
