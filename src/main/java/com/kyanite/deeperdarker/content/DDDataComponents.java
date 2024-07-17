package com.kyanite.deeperdarker.content;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

public class DDDataComponents {
    public static final DataComponentType<Boolean> HAS_FLOWER = DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding().build();
}
