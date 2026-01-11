package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SculkTubersBlock extends BushBlock {
    private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);

    public SculkTubersBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(BlockStateProperties.SNOWY, false));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return setSnowyState(context.getLevel(), context.getClickedPos(), defaultBlockState());
    }

    private BlockState setSnowyState(LevelAccessor level, BlockPos pos, BlockState state) {
        if (!state.is(this)) return state;
        if (level.getBlockState(pos.below()).is(Blocks.SNOW_BLOCK) || level.getBlockState(pos.below()).is(DDBlocks.SNOWY_SCULK_STONE)) {
            return state.setValue(BlockStateProperties.SNOWY, true);
        }
        return state.setValue(BlockStateProperties.SNOWY, false);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        BlockState result = super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        if (direction == Direction.DOWN) {
            return setSnowyState(levelAccessor, blockPos, result);
        }
        return result;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(DDBlocks.SNOWY_SCULK_STONE) || blockState.is(DDBlocks.SCULK_STONE) || blockState.is(Blocks.SNOW_BLOCK);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.SNOWY);
    }
}
