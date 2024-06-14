package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
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
    public void deeperdarker_stillValid(Player player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack transmitter = ItemStack.EMPTY;
        if(player.getMainHandItem().is(DDItems.SCULK_TRANSMITTER.get()) && SculkTransmitterItem.isLinked(player.getMainHandItem())) {
            transmitter = player.getMainHandItem();
        } else {
            for(ItemStack stack : player.getInventory().items) {
                if(stack.is(DDItems.SCULK_TRANSMITTER.get()) && SculkTransmitterItem.isLinked(stack)) {
                    transmitter = stack;
                    break;
                }
            }
        }

        if(!transmitter.isEmpty()) {
            CompoundTag tag = transmitter.get(DataComponents.CUSTOM_DATA).copyTag();
            String block = tag.getString("block");
            int[] pos = tag.getIntArray("blockPos");
            BlockPos linkedPos = new BlockPos(pos[0], pos[1], pos[2]);

            if(player.level().getBlockState(linkedPos).getBlock().getDescriptionId().equals(block)) {
                cir.setReturnValue(true);
                cir.cancel();
            } else {
                SculkTransmitterItem.actionBarMessage(player, "not_found", DDSounds.TRANSMITTER_ERROR);
                SculkTransmitterItem.formConnection(player.level(), transmitter, null);
            }
        }
    }
}
