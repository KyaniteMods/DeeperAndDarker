package com.kyanite.deeperdarker.mixin.containers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ContainerOpenersCounter.class)
public abstract class ChestEntityMixin {
    @Inject(method = "recheckOpeners", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/ContainerOpenersCounter;openerCountChanged(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)V"), cancellable = true)
    public void beforeOpenerCountChanged(Level pLevel, BlockPos pPos, BlockState pState, CallbackInfo ci) {
        ci.cancel();
    }
}
