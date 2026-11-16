package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.world.entity.EntityType;

import java.util.Optional;

public record CrystallizedAmberEntity(EntityType<?> type, float rotation) implements CrystallizedAmberContent<CrystallizedAmberEntity> {
    public static final Codec<CrystallizedAmberEntity> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity_type").forGetter(CrystallizedAmberEntity::type),
            Codec.FLOAT.fieldOf("rotation").forGetter(CrystallizedAmberEntity::rotation)
    ).apply(instance, CrystallizedAmberEntity::new));

    @Override
    public Codec<CrystallizedAmberEntity> getCodec() {
        return CODEC;
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
