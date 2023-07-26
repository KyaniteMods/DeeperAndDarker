package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScreenHandler.class)
public class SculkTransmitterLinkFromAfarScreenHandlerMixin {
    @Inject(method = "canUse(Lnet/minecraft/screen/ScreenHandlerContext;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/Block;)Z", at = @At("TAIL"), cancellable = true)
    private static void canUse(ScreenHandlerContext context, PlayerEntity player, Block block,
                        CallbackInfoReturnable<Boolean> cir) {
        if (player.getMainHandStack().isOf(DeeperDarkerItems.SCULK_TRANSMITTER)) {
            cir.setReturnValue(true);
        }
    }
}
