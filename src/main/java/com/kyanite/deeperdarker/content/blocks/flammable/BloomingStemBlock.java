package com.kyanite.deeperdarker.content.blocks.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation, NullableProblems")
public class BloomingStemBlock extends RotatedFlammableBlock {
    private static final VoxelShape Y_AXIS = Block.box(5, 0, 5, 11, 16, 11);
    private static final VoxelShape X_AXIS = Block.box(0, 5, 5, 16, 11, 11);
    private static final VoxelShape Z_AXIS = Block.box(5, 5, 0, 11, 11, 16);

    public BloomingStemBlock(Properties pProperties, int flammability, int spread) {
        super(pProperties, flammability, spread);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(AXIS)) {
            default -> Y_AXIS;
            case X -> X_AXIS;
            case Z -> Z_AXIS;
        };
    }
}
