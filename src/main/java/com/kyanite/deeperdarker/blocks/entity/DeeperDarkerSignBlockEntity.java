package com.kyanite.deeperdarker.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class DeeperDarkerSignBlockEntity extends SignBlockEntity {
    public DeeperDarkerSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DeeperDarkerBlockEntityTypes.SIGN, blockPos, blockState);
    }
}
