package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LevelRenderer.class)
public abstract class SculkLevelRendererMixin {
    @WrapOperation(method = "getLightColor(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;)I", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getLightEmission()I"))
    private static int deeperdarker$sculkLevelRendererEmission(BlockState instance, Operation<Integer> original, @Local(argsOnly = true) BlockAndTintGetter blockAndTintGetter) {
        return DDUtil.getLightEmission(original.call(instance), instance, blockAndTintGetter);
    }
}
