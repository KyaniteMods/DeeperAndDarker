package com.kyanite.deeperdarker.registry.blocks.custom.vegetation;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GloomCactusBlock extends CactusBlock {
    protected static final VoxelShape COLLISION_SHAPE = Block.box(1, 0, 1, 15, 13, 15);
    protected static final VoxelShape OUTLINE_SHAPE = Block.box(1, 0, 1, 15, 14, 15);

    public GloomCactusBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState stateBelow = pLevel.getBlockState(pPos.below());
        return stateBelow.is(DDBlocks.GLOOM_SCULK.get());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return OUTLINE_SHAPE;
    }
}
