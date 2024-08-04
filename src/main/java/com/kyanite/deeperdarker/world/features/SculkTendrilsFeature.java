package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SculkTendrilsFeature extends Feature<NoneFeatureConfiguration> {
    public SculkTendrilsFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        if(isValidPlacementLocation(level, origin)) {
            RandomSource random = context.random();
            int width = 8;
            int height = 4;
            int maxHeight = 8;
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for(int i = 0; i < width * width; i++) {
                blockPos.set(origin).move(Mth.nextInt(random, -width, width), Mth.nextInt(random, -height, height), Mth.nextInt(random, -width, width));
                if(findAirAboveGround(level, blockPos) && isValidPlacementLocation(level, blockPos)) {
                    int length = Mth.nextInt(random, 1, maxHeight);
                    if(random.nextInt(6) == 0) length *= 2;
                    if(random.nextInt(5) == 0) length = 1;

                    placeColumn(level, random, blockPos, length);
                }
            }

            return true;
        }

        return false;
    }

    private boolean isValidPlacementLocation(LevelAccessor level, BlockPos pos) {
        return level.getBlockState(pos.below()).is(Blocks.SCULK);
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
                    level.setBlock(pos, DDBlocks.SCULK_TENDRILS.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(random, 17, 25)), 3);
                    break;
                }

                level.setBlock(pos, DDBlocks.SCULK_TENDRILS_PLANT.get().defaultBlockState(), 3);
            }

            pos.move(Direction.UP);
        }
    }
}
