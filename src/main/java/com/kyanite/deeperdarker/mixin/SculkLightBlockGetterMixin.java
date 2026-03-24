package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockGetter.class)
public interface SculkLightBlockGetterMixin {
    @WrapOperation(method = "getLightEmission", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getLightEmission()I"))
    private int deeperdarker$sculkBlockGetterEmission(BlockState instance, Operation<Integer> original) {
        return DDUtil.getLightEmission(original.call(instance), instance, (BlockGetter) this);
    }
}
