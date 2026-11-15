package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseFireBlock;

public class PatienceSoulFireBlock extends DDSoulFireBlock {
    public static final MapCodec<PatienceSoulFireBlock> CODEC = simpleCodec(PatienceSoulFireBlock::new);
    public PatienceSoulFireBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getSoulStack() {
        return DDBlockItems.PATIENCE_SOUL.getDefaultInstance();
    }

    @Override
    protected MapCodec<? extends BaseFireBlock> codec() {
        return CODEC;
    }
}
