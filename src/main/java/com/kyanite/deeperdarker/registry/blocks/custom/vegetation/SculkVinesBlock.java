package com.kyanite.deeperdarker.registry.blocks.custom.vegetation;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkVinesBlock extends GrowingPlantHeadBlock {
    public static final VoxelShape SHAPE = Block.box(4, 9, 4, 12, 16, 12);

    public SculkVinesBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false, 0.1);
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel != 0 ? 0 : 1;
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
        return randomSource.nextIntBetweenInclusive(1, 2);
    }

    @Override
    protected Block getBodyBlock() {
        return DDBlocks.SCULK_VINES_PLANT.get();
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }
}
