package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.Nullable;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.Optional;

public interface CrystallizedAmberContent<T extends CrystallizedAmberContent<T>> {
    Codec<CrystallizedAmberContent<?>> CODEC = CrystallizedAmberContentType.REGISTRY.byNameCodec().dispatch(CrystallizedAmberContent::getType, CrystallizedAmberContentType::codec);
    StreamCodec<RegistryFriendlyByteBuf, CrystallizedAmberContent<?>> STREAM_CODEC = ByteBufCodecs.registry(CrystallizedAmberContentType.RESOURCE_KEY).dispatch(CrystallizedAmberContent::getType, CrystallizedAmberContentType::streamCodec);

    MapCodec<T> getCodec();
    StreamCodec<RegistryFriendlyByteBuf, T> getStreamCodec();
    CrystallizedAmberContentType<T> getType();
    Optional<Component> getDisplayName();

    static Optional<CrystallizedAmberContent<?>> getRandom(ServerLevel level, @Nullable BlockPos pos) {
        return CrystallizedAmberContentType.REGISTRY.getRandom(level.getRandom())
                .flatMap(reference -> reference.value().createRandom(level, pos));
    }
}
