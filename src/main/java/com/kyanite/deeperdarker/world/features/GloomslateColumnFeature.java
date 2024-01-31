package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GloomslateColumnFeature extends Feature<NoneFeatureConfiguration> {
    public GloomslateColumnFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();

        int columnHeight = 0;
        BlockPos.MutableBlockPos blockPos = origin.mutable();
        while(level.getBlockState(blockPos).isAir()) {
            columnHeight++;
            blockPos.move(0, 1, 0);
        }

        if(anyObstruction(level, origin, columnHeight)) return false;
        if(!level.getBlockState(origin.below()).is(DDBlocks.GLOOMY_SCULK.get())) return false;
        level.setBlock(origin.below(), DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
        level.setBlock(origin.above(columnHeight), DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);

        int amberLength = (int) (columnHeight * 0.35f);
        int gapSize = 0;
        boolean incomplete = random.nextFloat() < 0.3f;
        if(amberLength > 9) gapSize = BiasedToBottomInt.of(2, amberLength - 7).sample(random);
        int gapStart = (amberLength - gapSize) / 2;
        int gapPlacement = 0;

        blockPos = origin.mutable();
        for(int i = 1; i < columnHeight + 1; i++) {
            float percentageToTop = i / ((float) columnHeight + 1);

            if(percentageToTop >= 0.325f && percentageToTop <= 0.675f) {
                if(amberLength < 7) level.setBlock(blockPos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
                else if(amberLength > 9 && incomplete) {
                    if(gapPlacement < gapStart || gapPlacement > gapStart + gapSize) level.setBlock(blockPos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
                    gapPlacement++;
                }
                else level.setBlock(blockPos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), 3);
            } else if(amberLength > 6 && !incomplete && percentageToTop >= 0.3f && percentageToTop <= 0.7f) {
                level.setBlock(blockPos, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            } else {
                level.setBlock(blockPos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
            }

            blockPos.move(0, 1, 0);
        }

        double multiplier = amberLength < 7 ? 1.2 : amberLength > 9 && incomplete ? 0.92 : 1;
        columnBase(level, random, origin, columnHeight, multiplier, true);
        columnBase(level, random, origin.above(columnHeight - 1), columnHeight, multiplier, false);

        return true;
    }

    private boolean anyObstruction(WorldGenLevel level, BlockPos pos, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!level.getBlockState(pos.above(i)).is(Blocks.AIR)) return true;
        }

        return false;
    }

    private void columnBase(WorldGenLevel level, RandomSource random, BlockPos origin, int columnHeight, double multiplier, boolean bottom) {
        for(int i = 0; i < 4; i++) {
            int baseHeight = random.nextInt((int) (0.36 * columnHeight * multiplier), (int) (0.41 * columnHeight * multiplier) + 1);
            placeSection(level, random, origin, baseHeight, i, 1, multiplier, bottom);
            stretchToFloor(level, origin, i, 1, bottom);
        }

        for(int i = 0; i < 8; i++) {
            double baseHeight = random.nextInt((int) (0.22 * columnHeight), (int) (0.26 * columnHeight) + 1);
            if(i > 3) baseHeight *= 0.67;
            placeSection(level, random, origin, baseHeight, i, 2, multiplier, bottom);
            stretchToFloor(level, origin, i, 2, bottom);
        }

        if(multiplier > 1) return;
        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextInt((int) (0.04 * columnHeight), (int) (0.08 * columnHeight) + 1);
            placeSection(level, random, origin, baseHeight, i, 3, multiplier, bottom);
            stretchToFloor(level, origin, i, 3, bottom);
        }
    }

    private void placeSection(WorldGenLevel level, RandomSource random, BlockPos pos, double baseHeight, int iteration, int loop, double multiplier, boolean bottom) {
        float p = random.nextFloat();
        for(int j = 0; j < baseHeight; j++) {
            BlockPos location = spread(bottom ? pos.above(j) : pos.below(j), iteration, loop);

            if(iteration > 3 && multiplier > 1) return;
            if(j == baseHeight - 2 && j != 0  && p < 0.1f) level.setBlock(location, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            else if(j == baseHeight - 1 && j != 0  && p < 0.22f) level.setBlock(location, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            else level.setBlock(location, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
        }
    }

    private BlockPos spread(BlockPos pos, int index, int loop) {
        BlockPos basePos = pos;
        for(int i = 0; i < loop; i++) {
            int j = i % 2;
            if(index > 3 && loop == 2 && i == 0) j++;
            else if(index > 3 && i != 1) j += 2;
            switch ((index + j) % 4) {
                default -> basePos = basePos.north();
                case 1 -> basePos = basePos.east();
                case 2 -> basePos = basePos.south();
                case 3 -> basePos = basePos.west();
            }
        }

        return basePos;
    }

    private void stretchToFloor(WorldGenLevel level, BlockPos pos, int i, int loop, boolean bottom) {
        BlockPos blockPos = spread(bottom ? pos.below() : pos.above(), i, loop);

        if(bottom) {
            while(!level.getBlockState(blockPos).is(DDBlocks.SCULK_STONE.get()) && !level.getBlockState(blockPos).is(DDBlocks.GLOOMSLATE.get()) && !level.getBlockState(blockPos).is(Blocks.DEEPSLATE) && !level.isOutsideBuildHeight(blockPos)) {
                level.setBlock(blockPos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
                blockPos = blockPos.below();
            }
            return;
        }

        while(!level.getBlockState(blockPos).is(DDBlocks.SCULK_STONE.get()) && !level.getBlockState(blockPos).is(DDBlocks.GLOOMY_SCULK.get()) && !level.getBlockState(blockPos).is(DDBlocks.GLOOMSLATE.get()) && !level.getBlockState(blockPos).is(Blocks.DEEPSLATE) && !level.isOutsideBuildHeight(blockPos)) {
            level.setBlock(blockPos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
            blockPos = blockPos.above();
        }
    }
}
