package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Container.class)
public interface ContainerMixin {
    @Inject(method = "stillValidBlockEntity(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/player/Player;F)Z", at = @At("HEAD"), cancellable = true)
    private static void deeperdarker$stillValidBlockEntity(BlockEntity blockEntity, Player player, float i, CallbackInfoReturnable<Boolean> cir) {
        if (blockEntity.getLevel() instanceof ServerLevel serverLevel && SculkTransmitterItem.stillValid(player, serverLevel, blockEntity.getBlockPos())) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
