package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;

import java.util.Optional;

public record CrystallizedAmberContentType<T extends CrystallizedAmberContent<T>>(MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec, CrystallizedAmberContentRandomFactory<T> factory) {
    public static final ResourceKey<Registry<CrystallizedAmberContentType<?>>> RESOURCE_KEY = ResourceKey.createRegistryKey(DeeperDarker.id("crystallized_amber_content"));
    public static final Registry<CrystallizedAmberContentType<?>> REGISTRY = FabricRegistryBuilder.createSimple(RESOURCE_KEY).buildAndRegister();

    public static final CrystallizedAmberContentType<CrystallizedAmberEntity> ENTITY = register("entity", new CrystallizedAmberContentType<>(CrystallizedAmberEntity.CODEC, CrystallizedAmberEntity.STREAM_CODEC, (level, pos) -> CrystallizedAmberEntity.createRandom(pos)));
    public static final CrystallizedAmberContentType<CrystallizedAmberItemStack> ITEM_STACK = register("item_stack", new CrystallizedAmberContentType<>(CrystallizedAmberItemStack.CODEC, CrystallizedAmberItemStack.STREAM_CODEC, CrystallizedAmberItemStack::createRandom));

    public static <U extends CrystallizedAmberContent<U>> CrystallizedAmberContentType<U> register(ResourceLocation id, CrystallizedAmberContentType<U> type) {
        return Registry.register(REGISTRY, id, type);
    }

    private static <U extends CrystallizedAmberContent<U>> CrystallizedAmberContentType<U> register(String id, CrystallizedAmberContentType<U> type) {
        return register(DeeperDarker.id(id), type);
    }

    public Optional<T> createRandom(ServerLevel level, BlockPos pos) {
        return factory.createRandom(level, pos);
    }

    @FunctionalInterface
    public interface CrystallizedAmberContentRandomFactory<T extends CrystallizedAmberContent<T>> {
        Optional<T> createRandom(ServerLevel level, BlockPos pos);
    }

    public static void init() {
    }
}
