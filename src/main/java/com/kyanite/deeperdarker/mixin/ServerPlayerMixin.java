package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/AbstractContainerMenu;stillValid(Lnet/minecraft/world/entity/player/Player;)Z"))
    private boolean stillValid(AbstractContainerMenu menu, Player player) {
        if(SculkTransmitterItem.stillValid(player)) return true;
        return menu.stillValid(player);
    }
}
