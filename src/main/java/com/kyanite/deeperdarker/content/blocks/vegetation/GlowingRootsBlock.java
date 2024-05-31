package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GlowingRootsBlock extends GrowingPlantHeadBlock {
    public static final MapCodec<GlowingRootsBlock> CODEC = simpleCodec(GlowingRootsBlock::new);
    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 5, 13);

    public GlowingRootsBlock(Properties properties) {
        super(properties, Direction.UP, SHAPE, false, 0.05);
    }

    @Override
    protected @NotNull MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(@NotNull RandomSource pRandom) {
        return 1;
    }

    @Override
    protected @NotNull Block getBodyBlock() {
        return DDBlocks.GLOWING_ROOTS_PLANT.get();
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }
}
