package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record LinkOwnedEntityPayload(int ownerId, int ownedEntityId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<LinkOwnedEntityPayload> TYPE = new CustomPacketPayload.Type<>(DeeperDarker.id("link_owned_entity"));
    public static final StreamCodec<RegistryFriendlyByteBuf, LinkOwnedEntityPayload> CODEC = StreamCodec.composite(ByteBufCodecs.INT, LinkOwnedEntityPayload::ownerId, ByteBufCodecs.INT, LinkOwnedEntityPayload::ownedEntityId, LinkOwnedEntityPayload::new);

    public LinkOwnedEntityPayload(Entity owner, @Nullable Entity ownedEntity) {
        this(owner.getId(), ownedEntity == null ? 0 : ownedEntity.getId());
    }

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
