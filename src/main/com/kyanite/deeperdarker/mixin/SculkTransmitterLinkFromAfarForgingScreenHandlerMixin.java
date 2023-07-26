package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ForgingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ForgingScreenHandler.class)
public class SculkTransmitterLinkFromAfarForgingScreenHandlerMixin {
    @Inject(method = "canUse(Lnet/minecraft/entity/player/PlayerEntity;)Z", at = @At("TAIL"), cancellable = true)
    private void canUse(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (player.getMainHandStack().isOf(DeeperDarkerItems.SCULK_TRANSMITTER)) {
            cir.setReturnValue(true);
        }
    }
}
