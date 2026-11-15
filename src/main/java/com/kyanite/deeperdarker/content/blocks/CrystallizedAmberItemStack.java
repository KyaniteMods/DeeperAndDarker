package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

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
}
