package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;

public interface CrystallizedAmberContent<T extends CrystallizedAmberContent<T>> {
    Codec<CrystallizedAmberContent<?>> CODEC = CrystallizedAmberContentType.REGISTRY.byNameCodec().dispatch(CrystallizedAmberContent::getType, CrystallizedAmberContentType::codec);

    Codec<T> getCodec();
    CrystallizedAmberContentType<T> getType();
}
