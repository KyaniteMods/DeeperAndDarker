package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.util.DDConfig;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Messages {
    public static void registerMessages() {
        ServerPlayNetworking.registerGlobalReceiver(SoulElytraBoostPacket.TYPE, (packet, player, responseSender) -> {
            Level level = player.level();
            if(player.isFallFlying() && player.getInventory().armor.get(2).is(DDItems.SOUL_ELYTRA) && !player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA)) {
                FireworkRocketEntity rocket = new FireworkRocketEntity(level, new ItemStack(Items.FIREWORK_ROCKET), player);
                level.addFreshEntity(rocket);
                player.getCooldowns().addCooldown(DDItems.SOUL_ELYTRA, DDConfig.HANDLER.instance().soulElytraCooldown);
            }
        });
        ServerPlayNetworking.registerGlobalReceiver(UseTransmitterPacket.TYPE, (packet, player, responseSender) -> {
            for(ItemStack stack : player.getInventory().items) {
                if(stack.is(DDItems.SCULK_TRANSMITTER) && SculkTransmitterItem.isLinked(stack)) {
                    SculkTransmitterItem.transmit(player.level(), player, stack, null);
                    break;
                }
            }
        });
    }
}
