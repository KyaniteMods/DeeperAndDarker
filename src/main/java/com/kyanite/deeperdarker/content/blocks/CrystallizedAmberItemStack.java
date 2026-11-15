package com.kyanite.deeperdarker.content.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;

public record CrystallizedAmberItemStack(ItemStack stack, float rotation) implements CrystallizedAmberContent<CrystallizedAmberItemStack> {
    public static final Codec<CrystallizedAmberItemStack> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ItemStack.CODEC.fieldOf("stack").forGetter(CrystallizedAmberItemStack::stack),
            Codec.FLOAT.fieldOf("rotation").forGetter(CrystallizedAmberItemStack::rotation)
    ).apply(instance, CrystallizedAmberItemStack::new));

    @Override
    public Codec<CrystallizedAmberItemStack> getCodec() {
        return CODEC;
    }

    @Override
    public CrystallizedAmberContentType<CrystallizedAmberItemStack> getType() {
        return CrystallizedAmberContentType.ITEM_STACK;
    }
}
