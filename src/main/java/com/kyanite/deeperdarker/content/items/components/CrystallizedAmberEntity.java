package com.kyanite.deeperdarker.content.items.components;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.EntityType;

public record CrystallizedAmberEntity(EntityType<?> type) implements CrystallizedAmberContent<CrystallizedAmberEntity> {
    public static final MapCodec<CrystallizedAmberEntity> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity_type").forGetter(CrystallizedAmberEntity::type)
    ).apply(instance, CrystallizedAmberEntity::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, CrystallizedAmberEntity> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.registry(Registries.ENTITY_TYPE), CrystallizedAmberEntity::type, CrystallizedAmberEntity::new);

    @Override
    public MapCodec<CrystallizedAmberEntity> getCodec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CrystallizedAmberEntity> getStreamCodec() {
        return STREAM_CODEC;
    }

    @Override
    public CrystallizedAmberContentType<CrystallizedAmberEntity> getType() {
        return CrystallizedAmberContentType.ENTITY;
    }
}
