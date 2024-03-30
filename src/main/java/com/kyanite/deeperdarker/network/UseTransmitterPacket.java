package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UseTransmitterPacket {
    public UseTransmitterPacket() {
    }

    public UseTransmitterPacket(ByteBuf buf) {
    }

    public void toBytes(ByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            for(ItemStack stack : player.getInventory().items) {
                if(stack.is(DDItems.SCULK_TRANSMITTER.get()) && SculkTransmitterItem.isLinked(stack)) {
                    SculkTransmitterItem.transmit(player.level(), player, stack, null);
                    break;
                }
            }
        });

        context.get().setPacketHandled(true);
    }
}
