package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LightEngine.class)
public abstract class SculkLightEngineMixin {
    @WrapOperation(method = "hasDifferentLightProperties", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getLightEmission()I"))
    private static int deeperdarker$sculkLightEngineEmission(BlockState instance, Operation<Integer> original, @Local(argsOnly = true) BlockGetter blockGetter) {
        return DDUtil.getLightEmission(original.call(instance), instance, blockGetter);
    }
}
