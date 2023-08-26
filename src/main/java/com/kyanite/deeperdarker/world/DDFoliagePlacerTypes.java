package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.trees.EchoFoliagePlacer;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class DDFoliagePlacerTypes {
    public static final FoliagePlacerType<EchoFoliagePlacer> ECHO_FOLIAGE_PLACER = register("echo_foliage_placer", EchoFoliagePlacer.CODEC);

    private static <P extends FoliagePlacer> FoliagePlacerType<P> register(String string, Codec<P> codec) {
        return Registry.register(Registry.FOLIAGE_PLACER_TYPES, new ResourceLocation(DeeperDarker.MOD_ID, string), new FoliagePlacerType<P>(codec));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering foliage placers");
    }
}
