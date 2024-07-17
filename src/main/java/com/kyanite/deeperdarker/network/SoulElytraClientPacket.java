package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.client.Keybinds;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SoulElytraClientPacket {
    public SoulElytraClientPacket() {
    }

    public SoulElytraClientPacket(ByteBuf buf) {
    }

    public void toBytes(ByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            if (DeeperDarkerConfig.soulElytraCooldown == -1) return;
            Minecraft.getInstance().player.displayClientMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.equipped", Keybinds.BOOST.getTranslatedKeyMessage()), true);
        });
        context.get().setPacketHandled(true);
    }
}
