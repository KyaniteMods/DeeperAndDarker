package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record RemoveSculkAltarItemPayload(int item, BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RemoveSculkAltarItemPayload> TYPE = new CustomPacketPayload.Type<>(DeeperDarker.id("remove_sculk_altar_item"));
    public static final StreamCodec<RegistryFriendlyByteBuf, RemoveSculkAltarItemPayload> CODEC = StreamCodec.composite(ByteBufCodecs.INT, RemoveSculkAltarItemPayload::item, BlockPos.STREAM_CODEC, RemoveSculkAltarItemPayload::blockPos, RemoveSculkAltarItemPayload::new);

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
