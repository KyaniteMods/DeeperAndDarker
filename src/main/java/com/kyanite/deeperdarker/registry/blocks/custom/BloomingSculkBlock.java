package com.kyanite.deeperdarker.registry.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SculkBehaviour;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BloomingSculkBlock extends SculkBlock implements BonemealableBlock, SculkBehaviour {

    public BloomingSculkBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        CaveFeatures.MOSS_PATCH_BONEMEAL.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, pPos.above());
    }
}
