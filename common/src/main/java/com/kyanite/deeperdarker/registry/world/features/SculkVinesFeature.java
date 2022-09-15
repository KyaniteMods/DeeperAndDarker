package com.kyanite.deeperdarker.registry.world.features;

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

public class SculkVinesFeature extends Feature<NoneFeatureConfiguration> {
    public SculkVinesFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource randomsource = pContext.random();
        if(!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
            if(!blockstate.is(Blocks.SCULK) && !blockstate.is(DDBlocks.ECHO_LEAVES) && !blockstate.is(DDBlocks.SCULK_STONE)) {
                return false;
            } else {
                this.placeVines(worldgenlevel, randomsource, blockpos);
                return true;
            }
        }
    }

    private void placeVines(LevelAccessor levelAccessor, RandomSource randomSource, BlockPos pos) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 100; i++) {
            mutableBlockPos.setWithOffset(pos, randomSource.nextInt(8) - randomSource.nextInt(8), randomSource.nextInt(2) - randomSource.nextInt(7), randomSource.nextInt(8) - randomSource.nextInt(8));
            if(levelAccessor.isEmptyBlock(mutableBlockPos)) {
                BlockState blockstate = levelAccessor.getBlockState(mutableBlockPos.above());
                if(blockstate.is(Blocks.SCULK) || blockstate.is(DDBlocks.ECHO_LEAVES)) {
                    int j = Mth.nextInt(randomSource, 1, 8);
                    if(randomSource.nextInt(6) == 0) j *= 2;
                    if(randomSource.nextInt(5) == 0) j = 1;

                    placeVinesColumn(levelAccessor, randomSource, mutableBlockPos, j, 17, 25);
                }
            }
        }

    }

    public static void placeVinesColumn(LevelAccessor levelAccessor, RandomSource randomSource, BlockPos.MutableBlockPos blockPos, int a, int b, int c) {
        for(int i = 0; i <= a; i++) {
            if(levelAccessor.isEmptyBlock(blockPos)) {
                if(i == a || !levelAccessor.isEmptyBlock(blockPos.below())) {
                    levelAccessor.setBlock(blockPos, DDBlocks.SCULK_VINES.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(randomSource, b, c)), 2);
                    break;
                }

                levelAccessor.setBlock(blockPos, DDBlocks.SCULK_VINES_PLANT.defaultBlockState(), 2);
            }

            blockPos.move(Direction.DOWN);
        }
    }
}