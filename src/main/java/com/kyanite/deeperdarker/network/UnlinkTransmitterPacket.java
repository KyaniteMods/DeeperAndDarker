package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record UnlinkTransmitterPacket(int slot) implements FabricPacket {
    public static final PacketType<UnlinkTransmitterPacket> TYPE = PacketType.create(new ResourceLocation(DeeperDarker.MOD_ID, "unlink_transmitter"), UnlinkTransmitterPacket::new);

    public UnlinkTransmitterPacket(ByteBuf buf) {
        this(buf.readInt());
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(slot);
    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
