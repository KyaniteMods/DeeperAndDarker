package com.kyanite.deeperdarker.network;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {
    public static SimpleChannel INSTANCE;
    private static int ID;
    private static int nextID() {
        return ID++;
    }

    public static void registerMessages(String channel) {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(DeeperDarker.MOD_ID, channel), () -> "1.0", s -> true, s -> true);
        INSTANCE.registerMessage(nextID(), SoulElytraBoostPacket.class, SoulElytraBoostPacket::toBytes, SoulElytraBoostPacket::new, SoulElytraBoostPacket::handle);
        INSTANCE.registerMessage(nextID(), SoulElytraClientPacket.class, SoulElytraClientPacket::toBytes, SoulElytraClientPacket::new, SoulElytraClientPacket::handle);
        INSTANCE.registerMessage(nextID(), UseTransmitterPacket.class, UseTransmitterPacket::toBytes, UseTransmitterPacket::new, UseTransmitterPacket::handle);
    }
}
