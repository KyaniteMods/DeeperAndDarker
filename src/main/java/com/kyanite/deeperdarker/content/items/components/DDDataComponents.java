package com.kyanite.deeperdarker.content.items.components;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ItemStack;

public class DDDataComponents {
    public static final DataComponentType<Unit> NO_FLOWER = register("no_flower", DataComponentType.<Unit>builder().persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).build());
    public static final DataComponentType<Unit> SONOROUS_STAFF_CHARGED = register("sonorous_staff_charged", DataComponentType.<Unit>builder().persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).build());
    public static final DataComponentType<TransmitterData> TRANSMITTER_DATA = register("transmitter_data", DataComponentType.<TransmitterData>builder().persistent(TransmitterData.CODEC).networkSynchronized(TransmitterData.STREAM_CODEC).build());
    public static final DataComponentType<CrystallizedAmberContent<?>> CRYSTALLIZED_AMBER_CONTENT = register("crystallized_amber_content", DataComponentType.<CrystallizedAmberContent<?>>builder().persistent(CrystallizedAmberContent.CODEC).networkSynchronized(CrystallizedAmberContent.STREAM_CODEC).build());
    public static final DataComponentType<Unit> REINVOKED = register("reinvoked", DataComponentType.<Unit>builder().persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).build());
    public static final DataComponentType<Unit> NO_HORNS = register("no_horns", DataComponentType.<Unit>builder().persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).build());
    public static final DataComponentType<Unit> ACID_RESISTANT = register("acid_resistant", DataComponentType.<Unit>builder().persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).build());
    public static final DataComponentType<ItemStack> AUGMENT = register("augment", DataComponentType.<ItemStack>builder().persistent(ItemStack.CODEC).networkSynchronized(ItemStack.STREAM_CODEC).build());

    public static <T> DataComponentType<T> register(String id, DataComponentType<T> componentType) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, DeeperDarker.id(id), componentType);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering data component types");
        CrystallizedAmberContentType.init();
    }
}