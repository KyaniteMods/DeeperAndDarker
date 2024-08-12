package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public class UseTransmitterPayload implements CustomPacketPayload {
    public static final Type<UseTransmitterPayload> TYPE = new Type<>(DeeperDarker.rl("use_transmitter"));
    public static final UseTransmitterPayload INSTANCE = new UseTransmitterPayload();
    public static final StreamCodec<RegistryFriendlyByteBuf, UseTransmitterPayload> CODEC = StreamCodec.unit(INSTANCE);

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
