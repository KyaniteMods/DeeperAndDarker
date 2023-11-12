package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GlowingVinesBlock extends GrowingPlantHeadBlock {
    private static final VoxelShape SHAPE = Block.box(1, 9, 1, 15, 16, 15);

    public GlowingVinesBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false, 0.14);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource pRandom) {
        return pRandom.nextIntBetweenInclusive(1, 3);
    }

    @Override
    protected @NotNull Block getBodyBlock() {
        return DDBlocks.GLOWING_VINES_PLANT.get();
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }
}
