package com.kyanite.deeperdarker.world.gen;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class DeeperDarkerBiomes {
    public static RegistryKey<Biome> DEEPLANDS = RegistryKey.of(
            RegistryKeys.BIOME, new Identifier(DeeperDarker.MOD_ID, "deeplands"));
    public static RegistryKey<Biome> ECHOING_FOREST = RegistryKey.of(
            RegistryKeys.BIOME, new Identifier(DeeperDarker.MOD_ID, "echoing_forest"));
    public static RegistryKey<Biome> OVERCAST_COLUMNS = RegistryKey.of(
            RegistryKeys.BIOME, new Identifier(DeeperDarker.MOD_ID, "overcast_columns"));
}
