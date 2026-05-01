package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.entities.SyncedOwnedEntity;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class Messages {
    public static void registerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(SoulElytraBoostPacket.TYPE, (packet, player, responseSender) -> {
            ServerLevel level = player.serverLevel();
            if (DeeperDarker.CONFIG.server.soulElytraCooldown() == -1) {
                player.displayClientMessage(Component.translatable(DDItems.SOUL_ELYTRA.getDescriptionId() + ".boost_disabled").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)), true);
                return;
            }
            if(player.isFallFlying() && player.getInventory().armor.get(2).is(DDItems.SOUL_ELYTRA) && !player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA) && DeeperDarker.CONFIG.server.soulElytraCooldown() != -1) {
                Vec3 lookAngle = player.getLookAngle();
                player.addDeltaMovement(lookAngle.multiply(1.5f, 1.5f, 1.5f));
                responseSender.sendPacket(new ClientboundSetEntityMotionPacket(player));
                lookAngle = lookAngle.reverse();
                for (int i = 0; i < 5; i++) {
                    level.sendParticles(ParticleTypes.SONIC_BOOM, player.getX() + lookAngle.x() * i, player.getY() + lookAngle.y() * i, player.getZ() + lookAngle.z() * i, 1, 0, 0, 0, 0);
                }
                player.getCooldowns().addCooldown(DDItems.SOUL_ELYTRA, DeeperDarker.CONFIG.server.soulElytraCooldown());
            }
        });
        ServerPlayNetworking.registerGlobalReceiver(UseTransmitterPacket.TYPE, (packet, player, responseSender) -> {
            for(ItemStack stack : player.getInventory().items) {
                if(stack.getItem() instanceof SculkTransmitterItem && SculkTransmitterItem.isLinked(stack)) {
                    SculkTransmitterItem.transmit(player.level(), player, stack, null, null);
                    break;
                }
            }
        });
        ServerPlayNetworking.registerGlobalReceiver(UnlinkTransmitterPacket.TYPE, (packet, player, responseSender) -> {
            ItemStack stack = player.getInventory().getItem(packet.slot());
            if (stack.getItem() instanceof SculkTransmitterItem) {
                SculkTransmitterItem.actionBarMessage(player.level(), player, "unlinked", DDSounds.TRANSMITTER_UNLINK);
                SculkTransmitterItem.formConnection(player.level(), stack, null);
            }
        });
        ServerPlayNetworking.registerGlobalReceiver(LinkTransmitterPacket.TYPE, (packet, player, responseSender) -> {
            ItemStack stack = player.getInventory().getItem(packet.slot());
            if (stack.getItem() instanceof SculkTransmitterItem) {
                SculkTransmitterItem.actionBarMessage(player.level(), player, "linked", DDSounds.TRANSMITTER_LINK);
                SculkTransmitterItem.formConnection(player.level(), stack, packet.blockPos());
            }
        });
    }

    @Environment(EnvType.CLIENT)
    public static void registerClientReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(LinkOwnedEntityPacket.TYPE, (packet, player, responseSender) -> {
            if (packet.ownedEntityId() == 0) return;
            Entity entity = player.level().getEntity(packet.ownedEntityId());
            if (entity instanceof SyncedOwnedEntity ownedEntity) {
                ownedEntity.setDelayedOwnerId(packet.ownerId());
            }
        });
    }
}
