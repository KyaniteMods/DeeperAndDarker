package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

public record UseTransmitterPacket(boolean bool) implements CustomPacketPayload {
    public static final StreamCodec<ByteBuf, UseTransmitterPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, UseTransmitterPacket::bool,
            UseTransmitterPacket::new
    );

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, "use_transmitter");
    public static final CustomPacketPayload.Type<UseTransmitterPacket> TYPE = new CustomPacketPayload.Type<>(ID);

    @Override
    public @NotNull CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            for(ItemStack stack : player.getInventory().items) {
                if(stack.is(DDItems.SCULK_TRANSMITTER.get()) && SculkTransmitterItem.isLinked(stack)) {
                    SculkTransmitterItem.transmit(player.level(), player, stack, null);
                    break;
                }
            }
        });
    }
}
