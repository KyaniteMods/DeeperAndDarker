package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public record CrystallizedAmberItemStack(ItemStack stack, float rotation) implements CrystallizedAmberContent<CrystallizedAmberItemStack> {
    public static final MapCodec<CrystallizedAmberItemStack> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ItemStack.CODEC.fieldOf("stack").forGetter(CrystallizedAmberItemStack::stack),
            Codec.FLOAT.fieldOf("rotation").forGetter(CrystallizedAmberItemStack::rotation)
    ).apply(instance, CrystallizedAmberItemStack::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, CrystallizedAmberItemStack> STREAM_CODEC = StreamCodec.composite(ItemStack.STREAM_CODEC, CrystallizedAmberItemStack::stack, ByteBufCodecs.FLOAT, CrystallizedAmberItemStack::rotation, CrystallizedAmberItemStack::new);

    @Override
    public MapCodec<CrystallizedAmberItemStack> getCodec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CrystallizedAmberItemStack> getStreamCodec() {
        return STREAM_CODEC;
    }

    @Override
    public CrystallizedAmberContentType<CrystallizedAmberItemStack> getType() {
        return CrystallizedAmberContentType.ITEM_STACK;
    }

    @Override
    public Optional<Component> getDisplayName() {
        return Optional.of(stack().getDisplayName());
    }

    @Override
    public void onDestroy(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        Block.popResource(level, pos, stack());
    }

    public static Optional<CrystallizedAmberItemStack> createRandom(ServerLevel level, BlockPos pos) {
        RandomSource random = RandomSource.create(pos.asLong());
        float rotation = random.nextFloat() * 180.0f;

        LootTable table = level.getServer().reloadableRegistries().getLootTable(DDChestLootTableProvider.CRYSTALLIZED_AMBER);
        List<ItemStack> list = table.getRandomItems(new LootParams.Builder(level).withParameter(LootContextParams.ORIGIN, pos.getCenter()).create(LootContextParamSets.CHEST), pos.asLong());
        if (!list.isEmpty()) {
            CrystallizedAmberItemStack result = new CrystallizedAmberItemStack(list.get(0), rotation);
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
