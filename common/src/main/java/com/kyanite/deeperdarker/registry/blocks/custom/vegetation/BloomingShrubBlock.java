package com.kyanite.deeperdarker.registry.blocks.custom.vegetation;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

// Todo, add shearable support.
public class BloomingShrubBlock extends BushBlock {
    public static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 12, 13);

    public BloomingShrubBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(DDBlocks.BLOOMING_GRASS_BLOCK.get());
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState state = pLevel.getBlockState(pPos.below());
        return state.is(DDBlocks.BLOOMING_GRASS_BLOCK.get());
    }
}
