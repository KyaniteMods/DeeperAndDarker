package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ModelBlockRenderer.class, priority = 800)
public abstract class SculkModelBlockRendererMixin {
    @WrapOperation(method = "tesselateBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getLightEmission()I"))
    private int deeperdarker$sculkModelBlockRendererEmission(BlockState instance, Operation<Integer> original, @Local(argsOnly = true) BlockAndTintGetter blockAndTintGetter) {
        return DDUtil.getLightEmission(original.call(instance), instance, blockAndTintGetter);
    }
}
