package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.datacomponents.Transmitter;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDDataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.createDataComponents(DeeperDarker.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Transmitter>> TRANSMITTER = COMPONENTS.register("transmitter", () -> DataComponentType.<Transmitter>builder().persistent(Transmitter.CODEC).networkSynchronized(Transmitter.STREAM_CODEC).build());
}
