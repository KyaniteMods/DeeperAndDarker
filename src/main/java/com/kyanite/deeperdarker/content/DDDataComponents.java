package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.data.TempleTracker;
import com.kyanite.deeperdarker.content.data.Transmitter;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDDataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, DeeperDarker.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TempleTracker>> TEMPLE_TRACKER = COMPONENTS.register("temple_tracker", () -> DataComponentType.<TempleTracker>builder().persistent(TempleTracker.CODEC).networkSynchronized(TempleTracker.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Transmitter>> TRANSMITTER = COMPONENTS.register("transmitter", () -> DataComponentType.<Transmitter>builder().persistent(Transmitter.CODEC).networkSynchronized(Transmitter.STREAM_CODEC).build());
}
