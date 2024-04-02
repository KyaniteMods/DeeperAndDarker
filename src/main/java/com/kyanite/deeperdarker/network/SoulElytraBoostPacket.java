package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public class SoulElytraBoostPacket implements FabricPacket {
    public static final PacketType<SoulElytraBoostPacket> TYPE = PacketType.create(new ResourceLocation(DeeperDarker.MOD_ID, "soul_elytra_boost"), SoulElytraBoostPacket::new);

    public SoulElytraBoostPacket(ByteBuf buf) {
    }

    @Override
    public void write(FriendlyByteBuf buf) {

    }

    @Override
    public PacketType<?> getType() {
        return TYPE;
    }
}
