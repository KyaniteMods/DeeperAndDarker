package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record LinkTransmitterPayload(int slot, BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<LinkTransmitterPayload> TYPE = new CustomPacketPayload.Type<>(DeeperDarker.rl( "link_transmitter"));
    public static final StreamCodec<RegistryFriendlyByteBuf, LinkTransmitterPayload> CODEC = StreamCodec.composite(ByteBufCodecs.INT, LinkTransmitterPayload::slot, BlockPos.STREAM_CODEC, LinkTransmitterPayload::blockPos, LinkTransmitterPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
