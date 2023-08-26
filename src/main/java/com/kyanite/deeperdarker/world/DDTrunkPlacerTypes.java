package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.trees.EchoTrunkPlacer;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class DDTrunkPlacerTypes {
    public static final TrunkPlacerType<EchoTrunkPlacer> ECHO_TRUNK_PLACER = register("echo_trunk_placer", EchoTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String string, Codec<P> codec) {
        return Registry.register(Registry.TRUNK_PLACER_TYPES, new ResourceLocation(DeeperDarker.MOD_ID, string), new TrunkPlacerType<P>(codec));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering trunk placers");
    }
}
