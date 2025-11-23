package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin {
    @Inject(method = "stillValid(Lnet/minecraft/world/inventory/ContainerLevelAccess;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/block/Block;)Z", at = @At("HEAD"), cancellable = true)
    private static void deeperdarker$abstractContainerStillValid(ContainerLevelAccess containerLevelAccess, Player player, Block block, CallbackInfoReturnable<Boolean> cir) {
        if (SculkTransmitterItem.stillValid(player, containerLevelAccess)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
