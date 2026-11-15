package com.kyanite.deeperdarker.content.items.components;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public record CrystallizedAmberContentType<T extends CrystallizedAmberContent<T>>(MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec) {
    public static final ResourceKey<Registry<CrystallizedAmberContentType<?>>> RESOURCE_KEY = ResourceKey.createRegistryKey(DeeperDarker.id("crystallized_amber_content"));
    public static final Registry<CrystallizedAmberContentType<?>> REGISTRY = FabricRegistryBuilder.createSimple(RESOURCE_KEY).buildAndRegister();

    public static final CrystallizedAmberContentType<CrystallizedAmberEntity> ENTITY = register("entity", new CrystallizedAmberContentType<>(CrystallizedAmberEntity.CODEC, CrystallizedAmberEntity.STREAM_CODEC));
    public static final CrystallizedAmberContentType<CrystallizedAmberItemStack> ITEM_STACK = register("item_stack", new CrystallizedAmberContentType<>(CrystallizedAmberItemStack.CODEC, CrystallizedAmberItemStack.STREAM_CODEC));

    public static <U extends CrystallizedAmberContent<U>> CrystallizedAmberContentType<U> register(ResourceLocation id, CrystallizedAmberContentType<U> type) {
        return Registry.register(REGISTRY, id, type);
    }

    private static <U extends CrystallizedAmberContent<U>> CrystallizedAmberContentType<U> register(String id, CrystallizedAmberContentType<U> type) {
        return register(DeeperDarker.id(id), type);
    }

    public static void init() {
    }
}
