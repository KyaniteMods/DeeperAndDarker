package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SculkFernBlock extends TallGrassBlock {
    public SculkFernBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        DoublePlantBlock doublePlantBlock = (DoublePlantBlock) DDBlocks.LARGE_SCULK_FERN;
        if (doublePlantBlock.defaultBlockState().canSurvive(serverLevel, blockPos) && serverLevel.isEmptyBlock(blockPos.above())) {
            DoublePlantBlock.placeAt(serverLevel, doublePlantBlock.defaultBlockState(), blockPos, 2);
        }
    }

    @Override
    public boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.SCULK) || blockState.is(DDBlocks.SCULK_STONE);
    }
}
