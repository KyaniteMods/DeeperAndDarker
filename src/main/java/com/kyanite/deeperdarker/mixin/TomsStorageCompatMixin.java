package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.llamalad7.mixinextras.sugar.Local;
import com.tom.storagemod.block.entity.StorageTerminalBlockEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(StorageTerminalBlockEntity.class)
public class TomsStorageCompatMixin {
    @Inject(method = "canInteractWith", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$tomsStorageCompat(CallbackInfoReturnable<Boolean> cir, @Local(argsOnly = true) Player player) {
        if (((StorageTerminalBlockEntity) (Object) this).getLevel() instanceof ServerLevel serverLevel && SculkTransmitterItem.stillValid(player, serverLevel, ((StorageTerminalBlockEntity) (Object) this).getBlockPos())) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
