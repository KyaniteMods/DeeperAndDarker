package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

public record LinkOverseerCrystalPacket(int overseerId, int crystalId) implements FabricPacket {
    public static final PacketType<LinkOverseerCrystalPacket> TYPE = PacketType.create(new ResourceLocation(DeeperDarker.MOD_ID, "link_overseer_crystal"), LinkOverseerCrystalPacket::new);

    public LinkOverseerCrystalPacket(Entity overseer, @Nullable Entity crystal) {
        this(overseer.getId(), crystal == null ? 0 : crystal.getId());
    }

    public LinkOverseerCrystalPacket(ByteBuf buf) {
        this(buf.readInt(), buf.readInt());
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(overseerId);
        buf.writeInt(crystalId);
    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
