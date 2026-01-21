package com.kyanite.deeperdarker.world.otherside.gen;

import com.kyanite.deeperdarker.mixin.NoiseRouterDataAccessor;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class OthersideNoiseRouter {
    public static NoiseRouter otherside(HolderGetter<DensityFunction> density, HolderGetter<NormalNoise.NoiseParameters> noise) {
        DensityFunction shiftX = new DensityFunctions.HolderHolder(density.getOrThrow(NoiseRouterDataAccessor.shiftX()));
        DensityFunction shiftZ = new DensityFunctions.HolderHolder(density.getOrThrow(NoiseRouterDataAccessor.shiftZ()));
        DensityFunction temperature = DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.TEMPERATURE)));
        DensityFunction vegetation = DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.VEGETATION)));
        DensityFunction continents = DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.CONTINENTALNESS)));
        DensityFunction erosion = DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.EROSION)));
        DensityFunction ridges = DensityFunctions.flatCache(DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noise.getOrThrow(Noises.RIDGE)));
        DensityFunction cheese = DensityFunctions.noise(noise.getOrThrow(Noises.CAVE_CHEESE), 0.6666666666666666);

        DensityFunction nether3D = new DensityFunctions.HolderHolder(density.getOrThrow(NoiseRouterDataAccessor.base3dNoiseOverworld()));
        DensityFunction finalDensity = DensityFunctions.mul(
                DensityFunctions.constant(0.64),
                DensityFunctions.interpolated(DensityFunctions.blendDensity(DensityFunctions.add(
                        DensityFunctions.constant(2.5),
                        DensityFunctions.mul(
                                DensityFunctions.yClampedGradient(-8, 42, 0, 1),
                                DensityFunctions.add(
                                        DensityFunctions.constant(-2.5),
                                        DensityFunctions.add(
                                                DensityFunctions.constant(1.1),
                                                DensityFunctions.mul(
                                                        DensityFunctions.yClampedGradient(104, 128, 1, 0),
                                                        DensityFunctions.add(
                                                                DensityFunctions.add(
                                                                        DensityFunctions.constant(-0.9),
                                                                        nether3D
                                                                ), cheese.halfNegative()
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
                continents,
                erosion,
                DensityFunctions.zero(),
                ridges,
                DensityFunctions.zero(),
                finalDensity,
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );
    }
}