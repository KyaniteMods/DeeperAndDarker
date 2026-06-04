package com.kyanite.deeperdarker.content.blocks.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("NullableProblems")
public class FlammableBlock extends Block {
    private final int FLAMMABILITY;
    private final int SPREAD;

    public FlammableBlock(Properties properties, int igniteOdds, int burnOdds) {
        super(properties);
        this.FLAMMABILITY = burnOdds;
        this.SPREAD = igniteOdds;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return FLAMMABILITY;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return SPREAD;
    }
}
