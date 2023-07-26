package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

public class DeeperDarkerConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(DeeperDarker.MOD_ID, "gloomy_sculk_vegetation"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_BONEMEAL = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(DeeperDarker.MOD_ID, "gloomy_sculk_bonemeal"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> ECHO_TREE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(DeeperDarker.MOD_ID, "echo_tree"));
}
