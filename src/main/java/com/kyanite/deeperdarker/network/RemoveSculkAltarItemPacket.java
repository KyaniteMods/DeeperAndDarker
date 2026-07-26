package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record RemoveSculkAltarItemPacket(int item, BlockPos blockPos) implements FabricPacket {
    public static final PacketType<RemoveSculkAltarItemPacket> TYPE = PacketType.create(DeeperDarker.id("remove_sculk_altar_item"), RemoveSculkAltarItemPacket::new);

    public RemoveSculkAltarItemPacket(ByteBuf buf) {
        this(buf.readInt(), BlockPos.of(buf.readLong()));
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(item);
        buf.writeLong(blockPos.asLong());
    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
