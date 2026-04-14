package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")
@Mixin({ AbstractFurnaceMenu.class, BeaconMenu.class, BrewingStandMenu.class, CartographyTableMenu.class, ChestMenu.class, CraftingMenu.class, DispenserMenu.class, EnchantmentMenu.class, GrindstoneMenu.class, HopperMenu.class, ItemCombinerMenu.class, LoomMenu.class, ShulkerBoxMenu.class, StonecutterMenu.class })
public class ContainerMenuMixin {
    @Inject(method = "stillValid", at = @At("HEAD"), cancellable = true)
    public void stillValid(Player player, CallbackInfoReturnable<Boolean> cir) {
        if(SculkTransmitterItem.stillValid(player)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
