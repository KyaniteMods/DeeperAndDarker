package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.EntityType;

import java.util.Optional;

public record CrystallizedAmberEntity(EntityType<?> type, float rotation) implements CrystallizedAmberContent<CrystallizedAmberEntity> {
    public static final MapCodec<CrystallizedAmberEntity> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity_type").forGetter(CrystallizedAmberEntity::type),
            Codec.FLOAT.fieldOf("rotation").forGetter(CrystallizedAmberEntity::rotation)
    ).apply(instance, CrystallizedAmberEntity::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, CrystallizedAmberEntity> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.registry(Registries.ENTITY_TYPE), CrystallizedAmberEntity::type, ByteBufCodecs.FLOAT, CrystallizedAmberEntity::rotation, CrystallizedAmberEntity::new);

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

    @Override
    public Optional<Component> getDisplayName() {
        return Optional.of(ComponentUtils.wrapInSquareBrackets(type().getDescription().copy()));
    }
}
