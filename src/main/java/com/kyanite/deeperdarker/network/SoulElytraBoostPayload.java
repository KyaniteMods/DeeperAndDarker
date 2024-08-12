package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public class SoulElytraBoostPayload implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SoulElytraBoostPayload> TYPE = new CustomPacketPayload.Type<>(DeeperDarker.rl("soul_elytra_boost"));
    public static final SoulElytraBoostPayload INSTANCE = new SoulElytraBoostPayload();
    public static final StreamCodec<RegistryFriendlyByteBuf, SoulElytraBoostPayload> CODEC = StreamCodec.unit(INSTANCE);

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
