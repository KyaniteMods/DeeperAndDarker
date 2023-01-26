package com.kyanite.deeperdarker.registry.blocks.custom.vegetation.tendrils;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkTendrilsBlock extends GrowingPlantHeadBlock {
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 15, 12);

    public SculkTendrilsBlock(Properties properties) {
        super(properties, Direction.UP, SHAPE, false, 0.1);
    }


    /*public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel != 0 ? 0 : 1;
    }*/

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
        return randomSource.nextIntBetweenInclusive(1, 2);
    }

    @Override
    protected Block getBodyBlock() {
        return DDBlocks.SCULK_TENDRILS_PLANT.get();
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }
}
