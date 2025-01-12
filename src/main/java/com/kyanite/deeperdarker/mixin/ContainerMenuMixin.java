package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.ChunkPos;
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
            GlobalPos pos = SculkTransmitterItem.readGlobalPosition(stack.getOrCreateTag()).get();

            if (!player.level().isClientSide() && player.getServer().getLevel(pos.dimension()).getBlockState(pos.pos()).getBlock().getDescriptionId().equals(block)) {
                ChunkPos chunkPos = new ChunkPos(pos.pos());
                player.getServer().getLevel(pos.dimension()).getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
                return true;
            }
            return false;
        })) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
