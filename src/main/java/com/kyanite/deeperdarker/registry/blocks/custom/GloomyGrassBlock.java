package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;

public class GloomyGrassBlock extends BushBlock implements IForgeShearable {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 14.0D, 12.0D, 14.0D);

    public GloomyGrassBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(DDBlocks.GLOOM_SCULK.get());
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.below());
        return blockstate.is(DDBlocks.GLOOM_SCULK.get());
    }
}
