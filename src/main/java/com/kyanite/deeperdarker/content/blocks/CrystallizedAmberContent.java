package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface CrystallizedAmberContent<T extends CrystallizedAmberContent<T>> {
    Codec<CrystallizedAmberContent<?>> CODEC = CrystallizedAmberContentType.REGISTRY.byNameCodec().dispatch(CrystallizedAmberContent::getType, CrystallizedAmberContentType::codec);

    Codec<T> getCodec();
    CrystallizedAmberContentType<T> getType();
    Optional<Component> getDisplayName();
    default void onDestroy(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {}

    static Optional<CrystallizedAmberContent<?>> getRandom(ServerLevel level, @Nullable BlockPos pos) {
        return CrystallizedAmberContentType.REGISTRY.getRandom(level.getRandom())
                .flatMap(reference -> reference.value().createRandom(level, pos));
    }
}
