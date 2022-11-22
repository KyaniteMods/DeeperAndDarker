package com.kyanite.deeperdarker.mixin.containers;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = {RandomizableContainerBlockEntity.class, AbstractFurnaceBlockEntity.class})
public class ContainerMixin {
    @Inject(method = "stillValid", at = @At("HEAD"), cancellable = true)
    public void stillValid(Player pPlayer, CallbackInfoReturnable<Boolean> cir) {
        if(pPlayer.getMainHandItem().is(DDItems.SCULK_TRANSMITTER.get())) {
            cir.cancel();
            cir.setReturnValue(true);
        }
    }
}
