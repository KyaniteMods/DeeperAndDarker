package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public interface CrystallizedAmberContent<T extends CrystallizedAmberContent<T>> {
    Codec<CrystallizedAmberContent<?>> CODEC = CrystallizedAmberContentType.REGISTRY.byNameCodec().dispatch(CrystallizedAmberContent::getType, CrystallizedAmberContentType::codec);

    Codec<T> getCodec();
    CrystallizedAmberContentType<T> getType();
    Optional<Component> getDisplayName();
}
