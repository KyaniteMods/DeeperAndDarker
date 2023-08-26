package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.mixin.TrunkPlacerRegistryAccessor;
import com.kyanite.deeperdarker.world.trees.EchoTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class DDTrunkPlacerTypes {
    public static final TrunkPlacerType<EchoTrunkPlacer> ECHO_TRUNK_PLACER = TrunkPlacerRegistryAccessor.callRegister("echo_trunk_placer", EchoTrunkPlacer.CODEC);
}
