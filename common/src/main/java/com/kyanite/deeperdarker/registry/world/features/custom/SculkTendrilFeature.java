package com.kyanite.deeperdarker.registry.world.features.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SculkTendrilFeature extends Feature<NoneFeatureConfiguration> {
    public SculkTendrilFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos pos = pContext.origin();
        if(isInvalidPlacementLocation(level, pos)) {
            return false;
        } else {
            RandomSource randomsource = pContext.random();
            int i = 8;
            int j = 4;
            int k = 8;
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for(int l = 0; l < i * i; l++) {
                blockPos.set(pos).move(Mth.nextInt(randomsource, -i, i), Mth.nextInt(randomsource, -j, j), Mth.nextInt(randomsource, -i, i));
                if(findFirstAirBlockAboveGround(level, blockPos) && !isInvalidPlacementLocation(level, blockPos)) {
                    int i1 = Mth.nextInt(randomsource, 1, k);
                    if(randomsource.nextInt(6) == 0) {
                        i1 *= 2;
                    }

                    if(randomsource.nextInt(5) == 0) {
                        i1 = 1;
                    }

                    placeWeepingVinesColumn(level, randomsource, blockPos, i1, 17, 25);
                }
            }

            return true;
        }
    }

    private static boolean findFirstAirBlockAboveGround(LevelAccessor pLevel, BlockPos.MutableBlockPos pPos) {
        do {
            pPos.move(0, -1, 0);
            if(pLevel.isOutsideBuildHeight(pPos)) {
                return false;
            }
        } while (pLevel.getBlockState(pPos).isAir());

        pPos.move(0, 1, 0);
        return true;
    }

    public static void placeWeepingVinesColumn(LevelAccessor pLevel, RandomSource pRandom, BlockPos.MutableBlockPos pPos, int pLength, int pMinAge, int pMaxAge) {
        for(int i = 1; i <= pLength; i++) {
            if(pLevel.isEmptyBlock(pPos)) {
                if(i == pLength || !pLevel.isEmptyBlock(pPos.above())) {
                    pLevel.setBlock(pPos, DDBlocks.SCULK_TENDRILS.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(pRandom, pMinAge, pMaxAge)), 2);
                    break;
                }

                pLevel.setBlock(pPos, DDBlocks.SCULK_TENDRILS_PLANT.get().defaultBlockState(), 2);
            }

            pPos.move(Direction.UP);
        }

    }

    private static boolean isInvalidPlacementLocation(LevelAccessor pLevel, BlockPos pPos) {
        if(!pLevel.isEmptyBlock(pPos)) {
            return true;
        } else {
            BlockState blockstate = pLevel.getBlockState(pPos.below());
            return !blockstate.is(Blocks.SCULK);
        }
    }
}
