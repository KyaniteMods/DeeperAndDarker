package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public interface CrystallizedAmberContent<T extends CrystallizedAmberContent<T>> {
    Codec<CrystallizedAmberContent<?>> CODEC = CrystallizedAmberContentType.REGISTRY.byNameCodec().dispatch(CrystallizedAmberContent::getType, CrystallizedAmberContentType::codec);
    SimpleWeightedRandomList<Supplier<CrystallizedAmberContentType<?>>> RANDOM_LIST = SimpleWeightedRandomList.<Supplier<CrystallizedAmberContentType<?>>>builder()
            .add(() -> CrystallizedAmberContentType.ENTITY, 1)
            .add(() -> CrystallizedAmberContentType.ITEM_STACK, 6)
            .build();

    Codec<T> getCodec();
    CrystallizedAmberContentType<T> getType();
    Optional<Component> getDisplayName();
    default void onDestroy(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {}

    static Optional<CrystallizedAmberContent<?>> getRandom(ServerLevel level, @Nullable BlockPos pos) {
        return RANDOM_LIST.getRandom(level.getRandom())
                .flatMap(wrapper -> wrapper.getData().get().createRandom(level, pos));
    }
}
