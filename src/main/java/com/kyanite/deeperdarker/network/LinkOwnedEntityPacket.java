package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

public record LinkOwnedEntityPacket(int ownerId, int ownedEntityId) implements FabricPacket {
    public static final PacketType<LinkOwnedEntityPacket> TYPE = PacketType.create(new ResourceLocation(DeeperDarker.MOD_ID, "link_owned_entity"), LinkOwnedEntityPacket::new);

    public LinkOwnedEntityPacket(Entity owner, @Nullable Entity ownedEntity) {
        this(owner.getId(), ownedEntity == null ? 0 : ownedEntity.getId());
    }

    public LinkOwnedEntityPacket(ByteBuf buf) {
        this(buf.readInt(), buf.readInt());
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(ownerId);
        buf.writeInt(ownedEntityId);
    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
