package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = { AbstractFurnaceMenu.class, BeaconMenu.class, BrewingStandMenu.class, CartographyTableMenu.class, ChestMenu.class, CraftingMenu.class, DispenserMenu.class, EnchantmentMenu.class, GrindstoneMenu.class, HopperMenu.class, ItemCombinerMenu.class, LoomMenu.class, ShulkerBoxMenu.class, StonecutterMenu.class })
public class ContainerMenuMixin {
    @Inject(method = "stillValid", at = @At("HEAD"), cancellable = true)
    public void stillValid(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (player.getInventory().hasAnyMatching(stack -> {
            if (stack.isEmpty() || !stack.is(DDItems.SCULK_TRANSMITTER) || !SculkTransmitterItem.isLinked(stack)) return false;
            String block = stack.getTag().getString("block");
            int[] pos = stack.getTag().getIntArray("blockPos");
            BlockPos linkedPos = new BlockPos(pos[0], pos[1], pos[2]);

            return player.level().getBlockState(linkedPos).getBlock().getDescriptionId().equals(block);
        })) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
