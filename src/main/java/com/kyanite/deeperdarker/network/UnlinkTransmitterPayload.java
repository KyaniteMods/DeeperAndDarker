package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record UnlinkTransmitterPayload(int slot) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<UnlinkTransmitterPayload> TYPE = new CustomPacketPayload.Type<>(DeeperDarker.rl("unlink_transmitter"));
    public static final StreamCodec<RegistryFriendlyByteBuf, UnlinkTransmitterPayload> CODEC = StreamCodec.composite(ByteBufCodecs.INT, UnlinkTransmitterPayload::slot, UnlinkTransmitterPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
