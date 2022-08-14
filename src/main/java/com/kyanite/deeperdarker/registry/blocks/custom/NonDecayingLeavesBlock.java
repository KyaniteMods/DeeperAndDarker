package com.kyanite.deeperdarker.registry.blocks.custom;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class NonDecayingLeavesBlock extends LeavesBlock {
    public int distance;

    public NonDecayingLeavesBlock(Properties pProperties, int distance) {
        super(pProperties);
        this.distance = distance;
    }

    @Override
    protected boolean decaying(BlockState state) {
        return state.getValue(DISTANCE) == distance;
    }
}
