package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.Keybinds;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

public record SoulElytraClientPacket(boolean bool) implements CustomPacketPayload {
    public static final StreamCodec<ByteBuf, SoulElytraClientPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, SoulElytraClientPacket::bool,
            SoulElytraClientPacket::new
    );

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, "soul_elytra_client");
    public static final CustomPacketPayload.Type<SoulElytraClientPacket> TYPE = new CustomPacketPayload.Type<>(ID);

    @Override
    public @NotNull CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> Minecraft.getInstance().player.displayClientMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.equipped", Keybinds.BOOST.getTranslatedKeyMessage()), true));
    }
}
