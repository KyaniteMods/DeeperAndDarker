package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public class SlotMixin {
    @Shadow @Final public Container container;

    @Inject(method = "mayPlace", at = @At("HEAD"), cancellable = true)
    private void mayPlace(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(DDItems.SCULK_TRANSMITTER) && !(container instanceof Inventory) && !(container instanceof PlayerEnderChestContainer)) {
            cir.setReturnValue(false);
        }
    }
}
