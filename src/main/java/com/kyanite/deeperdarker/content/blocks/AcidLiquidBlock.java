package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class AcidLiquidBlock extends LiquidBlock {
    public AcidLiquidBlock(FlowingFluid flowingFluid, Properties properties) {
        super(flowingFluid, properties);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (shouldSpreadLiquid(level, blockPos, blockState)) {
            level.scheduleTick(blockPos, blockState.getFluidState().getType(), fluid.getTickDelay(level));
        }
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (shouldSpreadLiquid(level, blockPos, blockState)) {
            level.scheduleTick(blockPos, blockState.getFluidState().getType(), fluid.getTickDelay(level));
        }
    }

    private boolean shouldSpreadLiquid(Level level, BlockPos blockPos, BlockState blockState) {
        for (Direction direction : POSSIBLE_FLOW_DIRECTIONS) {
            BlockPos adjacentPos = blockPos.relative(direction.getOpposite());
            if (level.getFluidState(adjacentPos).is(FluidTags.WATER)) {
                Block block = level.getFluidState(blockPos).isSource() ? DDBlocks.SCULK_STONE : Blocks.SCULK;
                level.setBlockAndUpdate(blockPos, block.defaultBlockState());
                return false;
            } else if (level.getFluidState(adjacentPos).is(FluidTags.LAVA)) {
                Block block = level.getFluidState(blockPos).isSource() ? DDBlocks.SCULK_BASALT : DDBlocks.SCULK_STONE;
                level.setBlockAndUpdate(blockPos, block.defaultBlockState());
                return false;
            }
        }
        return true;
    }
}
