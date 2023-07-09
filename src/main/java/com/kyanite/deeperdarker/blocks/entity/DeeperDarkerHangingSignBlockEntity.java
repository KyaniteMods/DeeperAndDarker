package com.kyanite.deeperdarker.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class DeeperDarkerHangingSignBlockEntity extends SignBlockEntity {
    private static final int MAX_TEXT_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;

    public DeeperDarkerHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DeeperDarkerBlockEntityTypes.HANGING_SIGN, blockPos, blockState);
    }

    public int getTextLineHeight() {
        return TEXT_LINE_HEIGHT;
    }

    public int getMaxTextWidth() {
        return MAX_TEXT_WIDTH;
    }
}