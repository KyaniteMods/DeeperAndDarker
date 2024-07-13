package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.datacomponents.Transmitter;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = { AbstractFurnaceMenu.class, BeaconMenu.class, BrewingStandMenu.class, CartographyTableMenu.class, ChestMenu.class, CraftingMenu.class, DispenserMenu.class, EnchantmentMenu.class, GrindstoneMenu.class, HopperMenu.class, ItemCombinerMenu.class, LoomMenu.class, ShulkerBoxMenu.class, StonecutterMenu.class })
public class ContainerMenuMixin {
    @Inject(method = "stillValid", at = @At("HEAD"), cancellable = true)
    public void stillValid(Player player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = player.getMainHandItem();
        if(!SculkTransmitterItem.isLinked(stack)) {
            for(ItemStack item : player.getInventory().items) {
                if(SculkTransmitterItem.isLinked(item)) {
                    stack = item;
                    break;
                }
            }
        }

        if(!SculkTransmitterItem.isLinked(stack)) return;

        Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
        assert transmitter != null;
        BlockPos linkedPos = transmitter.linkedPos().get().pos();
        String blockName = transmitter.savedBlock();

        if(player.level().getBlockState(linkedPos).getBlock().getDescriptionId().equals(blockName)) {
            cir.setReturnValue(true);
            cir.cancel();
        } else {
            SculkTransmitterItem.tryConnect(transmitter, stack, player, null, "not_found", DDSounds.TRANSMITTER_ERROR);
        }
    }
}
