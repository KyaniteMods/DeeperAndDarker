package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public class UseTransmitterPacket implements FabricPacket {
    public static final PacketType<UseTransmitterPacket> TYPE = PacketType.create(new ResourceLocation(DeeperDarker.MOD_ID, "use_transmitter"), UseTransmitterPacket::new);

    public UseTransmitterPacket(ByteBuf buf) {
    }

    @Override
    public void write(FriendlyByteBuf buf) {

    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
