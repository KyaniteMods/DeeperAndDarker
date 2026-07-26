package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record AddSculkAltarItemPacket(int slot, BlockPos blockPos) implements FabricPacket {
    public static final PacketType<AddSculkAltarItemPacket> TYPE = PacketType.create(DeeperDarker.id("add_sculk_altar_item"), AddSculkAltarItemPacket::new);

    public AddSculkAltarItemPacket(ByteBuf buf) {
        this(buf.readInt(), BlockPos.of(buf.readLong()));
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(slot);
        buf.writeLong(blockPos.asLong());
    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
