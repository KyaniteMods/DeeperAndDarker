package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseFireBlock;

public class FortitudeSoulFireBlock extends DDSoulFireBlock {
    public static final MapCodec<FortitudeSoulFireBlock> CODEC = simpleCodec(FortitudeSoulFireBlock::new);
    public FortitudeSoulFireBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getSoulStack() {
        return DDBlockItems.FORTITUDE_SOUL.getDefaultInstance();
    }

    @Override
    protected MapCodec<? extends BaseFireBlock> codec() {
        return CODEC;
    }
}
