package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayer.class)
public abstract class BedTransmitterMixin {
    @Inject(method = "isReachableBedBlock", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$bedIsReachable(BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (SculkTransmitterItem.stillValid((ServerPlayer)(Object) this, ((ServerPlayer)(Object) this).serverLevel(), blockPos)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
