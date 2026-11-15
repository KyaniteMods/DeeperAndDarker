package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseFireBlock;

public class PuritySoulFireBlock extends DDSoulFireBlock {
    public static final MapCodec<PuritySoulFireBlock> CODEC = simpleCodec(PuritySoulFireBlock::new);
    public PuritySoulFireBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getSoulStack() {
        return DDBlockItems.PURITY_SOUL.getDefaultInstance();
    }

    @Override
    protected MapCodec<? extends BaseFireBlock> codec() {
        return CODEC;
    }
}
