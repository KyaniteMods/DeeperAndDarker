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
    private static final Direction[] DIRECTIONS = Direction.values();

    public SculkVinesFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource randomsource = pContext.random();
        if (!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
            if (!blockstate.is(Blocks.SCULK) && !blockstate.is(DDBlocks.SCULK_STONE.get())) {
                return false;
            } else {
                this.placeVines(worldgenlevel, randomsource, blockpos);
                return true;
            }
        }
    }

    private void placeVines(LevelAccessor p_225364_, RandomSource p_225365_, BlockPos p_225366_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 100; ++i) {
            blockpos$mutableblockpos.setWithOffset(p_225366_, p_225365_.nextInt(8) - p_225365_.nextInt(8), p_225365_.nextInt(2) - p_225365_.nextInt(7), p_225365_.nextInt(8) - p_225365_.nextInt(8));
            if (p_225364_.isEmptyBlock(blockpos$mutableblockpos)) {
                BlockState blockstate = p_225364_.getBlockState(blockpos$mutableblockpos.above());
                if (blockstate.is(Blocks.SCULK)) {
                    int j = Mth.nextInt(p_225365_, 1, 8);
                    if (p_225365_.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (p_225365_.nextInt(5) == 0) {
                        j = 1;
                    }

                    int k = 17;
                    int l = 25;
                    placeVinesColumn(p_225364_, p_225365_, blockpos$mutableblockpos, j, 17, 25);
                }
            }
        }

    }

    public static void placeVinesColumn(LevelAccessor p_225353_, RandomSource p_225354_, BlockPos.MutableBlockPos p_225355_, int p_225356_, int p_225357_, int p_225358_) {
        for(int i = 0; i <= p_225356_; ++i) {
            if (p_225353_.isEmptyBlock(p_225355_)) {
                if (i == p_225356_ || !p_225353_.isEmptyBlock(p_225355_.below())) {
                    p_225353_.setBlock(p_225355_, DDBlocks.SCULK_VINES.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Integer.valueOf(Mth.nextInt(p_225354_, p_225357_, p_225358_))), 2);
                    break;
                }

                p_225353_.setBlock(p_225355_, DDBlocks.SCULK_VINES_PLANT.get().defaultBlockState(), 2);
            }

            p_225355_.move(Direction.DOWN);
        }

    }
}