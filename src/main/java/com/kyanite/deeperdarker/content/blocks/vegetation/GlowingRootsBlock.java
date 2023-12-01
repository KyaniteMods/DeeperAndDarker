package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GlowingRootsBlock extends GrowingPlantHeadBlock {
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 15, 12);

    public GlowingRootsBlock(Properties properties) {
        super(properties, Direction.UP, SHAPE, false, 0.13);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(@NotNull RandomSource pRandom) {
        return 1;
    }

    @Override
    protected @NotNull Block getBodyBlock() {
        return DDBlocks.GLOWING_ROOTS_PLANT;
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }
}