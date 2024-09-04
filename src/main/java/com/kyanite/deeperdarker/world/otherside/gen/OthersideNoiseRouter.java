package com.kyanite.deeperdarker.world.otherside.gen;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class OthersideNoiseRouter {
    public static NoiseRouter otherside(HolderGetter<DensityFunction> density, HolderGetter<NormalNoise.NoiseParameters> noise) {
        DensityFunction shiftX = new DensityFunctions.HolderHolder(density.getOrThrow(NoiseRouterData.SHIFT_X));
        DensityFunction shiftZ = new DensityFunctions.HolderHolder(density.getOrThrow(NoiseRouterData.SHIFT_Z));
        DensityFunction temperature = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 2.5, noise.getOrThrow(Noises.TEMPERATURE));
        DensityFunction vegetation = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.6, noise.getOrThrow(Noises.VEGETATION));

        DensityFunction nether3D = new DensityFunctions.HolderHolder(density.getOrThrow(NoiseRouterData.BASE_3D_NOISE_NETHER));
        DensityFunction finalDensity = DensityFunctions.mul(
                DensityFunctions.constant(0.64),
                DensityFunctions.interpolated(DensityFunctions.blendDensity(DensityFunctions.add(
                        DensityFunctions.constant(2.5),
                        DensityFunctions.mul(
                                DensityFunctions.yClampedGradient(-8, 15, 0, 1),
                                DensityFunctions.add(
                                        DensityFunctions.constant(-2.5),
                                        DensityFunctions.add(
                                                DensityFunctions.constant(1.1),
                                                DensityFunctions.mul(
                                                        DensityFunctions.yClampedGradient(104, 128, 1, 0),
                                                        DensityFunctions.add(
                                                                DensityFunctions.constant(-0.85),
                                                                DensityFunctions.noise(noise.getOrThrow(Noises.GRAVEL), 5, 5)
                                                        )
                                                )
                                        )
                                )
                        )
                )))
        ).squeeze();

        return new NoiseRouter(
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                temperature,
                vegetation,
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                finalDensity,
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );
    }
}
