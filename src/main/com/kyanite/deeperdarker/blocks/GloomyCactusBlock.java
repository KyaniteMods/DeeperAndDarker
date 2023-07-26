package com.kyanite.deeperdarker.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class GloomyCactusBlock extends CactusBlock {
    private static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(1, 0, 1, 15, 13, 15);
    private static final VoxelShape OUTLINE_SHAPE = Block.createCuboidShape(1, 0, 1, 15, 14, 15);

    public GloomyCactusBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getCollisionShape();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape();
    }

    public static VoxelShape getCollisionShape() {
        return COLLISION_SHAPE;
    }

    public static VoxelShape getOutlineShape() {
        return OUTLINE_SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(DeeperDarkerBlocks.GLOOMY_SCULK);
    }
}
