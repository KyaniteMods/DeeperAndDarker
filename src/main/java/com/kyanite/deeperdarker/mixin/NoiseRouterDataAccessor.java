package com.kyanite.deeperdarker.mixin;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NoiseRouterData.class)
public interface NoiseRouterDataAccessor {
    @Accessor("SHIFT_X")
    static ResourceKey<DensityFunction> shiftX() {
        throw new IllegalStateException("Replaced by mixin");
    }

    @Accessor("SHIFT_Z")
    static ResourceKey<DensityFunction> shiftZ() {
        throw new IllegalStateException("Replaced by mixin");
    }

    @Accessor("BASE_3D_NOISE_NETHER")
    static ResourceKey<DensityFunction> base3dNoiseNether() {
        throw new IllegalStateException("Replaced by mixin");
    }
}
