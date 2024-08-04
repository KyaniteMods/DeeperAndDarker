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

@SuppressWarnings("NullableProblems")
public class SculkTendrilsBlock extends GrowingPlantHeadBlock {
    public static final MapCodec<SculkTendrilsBlock> CODEC = simpleCodec(SculkTendrilsBlock::new);
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 15, 12);

    public SculkTendrilsBlock(Properties properties) {
        super(properties, Direction.UP, SHAPE, false, 0.1);
    }

    @Override
    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return random.nextIntBetweenInclusive(1, 2);
    }

    @Override
    protected @NotNull Block getBodyBlock() {
        return DDBlocks.SCULK_TENDRILS_PLANT.get();
    }

    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }
}
