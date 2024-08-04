package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("NullableProblems")
public class GloomyCactusBlock extends CactusBlock {
    private static final VoxelShape COLLISION_SHAPE = Block.box(1, 0, 1, 15, 13, 15);
    private static final VoxelShape OUTLINE_SHAPE = Block.box(1, 0, 1, 15, 14, 15);

    public GloomyCactusBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState stateBelow = level.getBlockState(pos.below());
        return stateBelow.is(DDBlocks.GLOOMY_SCULK.get());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return OUTLINE_SHAPE;
    }
}
