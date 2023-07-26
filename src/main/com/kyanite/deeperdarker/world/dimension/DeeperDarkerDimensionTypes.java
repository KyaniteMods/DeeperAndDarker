package com.kyanite.deeperdarker.world.dimension;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class DeeperDarkerDimensionTypes {
    public static final RegistryKey<DimensionType> OTHERSIDE = DeeperDarkerDimensionTypes.of("otherside");

    private static RegistryKey<DimensionType> of(String id) {
        return RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(DeeperDarker.MOD_ID, id));
    }
}
