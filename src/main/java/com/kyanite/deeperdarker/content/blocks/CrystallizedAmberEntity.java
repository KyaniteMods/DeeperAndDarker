package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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

    @Override
    public void onDestroy(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (level instanceof ServerLevel serverLevel) {
            type().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
        }
    }

    public static Optional<CrystallizedAmberEntity> createRandom(BlockPos pos) {
        RandomSource random = RandomSource.create(pos.asLong());
        float rotation = random.nextFloat() * 180.0f;
        CrystallizedAmberEntity result = new CrystallizedAmberEntity(DDEntities.SCULK_LEECH, rotation);
        return Optional.of(result);
    }
}
