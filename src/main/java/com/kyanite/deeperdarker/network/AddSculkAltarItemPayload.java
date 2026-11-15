package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record AddSculkAltarItemPayload(int slot, BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AddSculkAltarItemPayload> TYPE = new CustomPacketPayload.Type<>(DeeperDarker.id("add_sculk_altar_item"));
    public static final StreamCodec<RegistryFriendlyByteBuf, AddSculkAltarItemPayload> CODEC = StreamCodec.composite(ByteBufCodecs.INT, AddSculkAltarItemPayload::slot, BlockPos.STREAM_CODEC, AddSculkAltarItemPayload::blockPos, AddSculkAltarItemPayload::new);

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
