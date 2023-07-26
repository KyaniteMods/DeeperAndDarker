package com.kyanite.deeperdarker.world.dimension;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class DeeperDarkerWorlds {
    public static final RegistryKey<World> OTHERSIDE = DeeperDarkerWorlds.of("otherside");

    private static RegistryKey<World> of(String id) {
        return RegistryKey.of(RegistryKeys.WORLD, new Identifier(DeeperDarker.MOD_ID, id));
    }
}
