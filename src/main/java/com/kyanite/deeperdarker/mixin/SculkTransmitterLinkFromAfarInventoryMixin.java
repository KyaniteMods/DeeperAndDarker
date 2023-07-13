package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Inventory.class)
public interface SculkTransmitterLinkFromAfarInventoryMixin extends Inventory {
    @Inject(method = "canPlayerUse(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/player/PlayerEntity;I)Z", at = @At("TAIL"), cancellable = true)
    private static void canPlayerUse(BlockEntity blockEntity, PlayerEntity player, int range,
                              CallbackInfoReturnable<Boolean> cir) {
        if (player.getMainHandStack().isOf(DeeperDarkerItems.SCULK_TRANSMITTER)) {
            cir.setReturnValue(true);
        }
    }
}
