package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GlowingRootsFeature extends Feature<NoneFeatureConfiguration> {
    public GlowingRootsFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();

        if(!isValidPlacementLocation(level, origin)) return false;

        int width = 5;
        int height = 3;
        int maxHeight = 6;
        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();
        for(int i = 0; i < width * width; i++) {
            blockPos.set(origin).move(Mth.nextInt(random, -width, width), Mth.nextInt(random, -height, height), Mth.nextInt(random, -width, width));
            if(findAirAboveGround(level, blockPos) && isValidPlacementLocation(level, blockPos)) {
                int length = random.nextInt(1, maxHeight);
                if(random.nextInt(12) == 0) length *= 2;
                if(random.nextInt(6) == 0) length = 1;
                placeColumn(level, random, blockPos, length);
            }
        }

        return true;
    }

    private boolean isValidPlacementLocation(LevelAccessor level, BlockPos pos) {
        return level.getBlockState(pos.below()).is(DDBlocks.BLOOMING_SCULK_STONE);
    }

    private boolean findAirAboveGround(LevelAccessor level, BlockPos.MutableBlockPos pos) {
        do {
            pos.move(0, -1, 0);
            if(level.isOutsideBuildHeight(pos)) return false;
        } while(level.getBlockState(pos).isAir());

        pos.move(0, 1, 0);
        return true;
    }

    private void placeColumn(LevelAccessor level, RandomSource random, BlockPos.MutableBlockPos pos, int length) {
        for(int i = 1; i <= length; i++) {
            if(level.isEmptyBlock(pos)) {
                if(i == length || !level.isEmptyBlock(pos.above())) {
                    level.setBlock(pos, DDBlocks.GLOWING_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, random.nextIntBetweenInclusive(17, 25)), 3);
                    break;
                }

                level.setBlock(pos, DDBlocks.GLOWING_ROOTS_PLANT.defaultBlockState(), 3);
            }

            pos.move(Direction.UP);
        }
    }
}
