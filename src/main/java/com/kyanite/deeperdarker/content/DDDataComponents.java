package com.kyanite.deeperdarker.content;

import com.mojang.serialization.Codec;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.datacomponents.Transmitter;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

public class DDDataComponents {
    public static final DataComponentType<Boolean> HAS_FLOWER = register("has_flower", DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding().build());
    public static final DataComponentType<Transmitter> TRANSMITTER = register("transmitter", DataComponentType.<Transmitter>builder().persistent(Transmitter.CODEC).networkSynchronized(Transmitter.STREAM_CODEC).build());

    public static <T> DataComponentType<T> register(String id, DataComponentType<T> componentType) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, DeeperDarker.rl(id), componentType);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering data component types");
    }
}
