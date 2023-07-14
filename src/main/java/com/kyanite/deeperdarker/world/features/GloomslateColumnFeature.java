package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GloomslateColumnFeature extends Feature<NoneFeatureConfiguration> {
    public GloomslateColumnFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos origin = pContext.origin();
        int columnHeight = 0;
        while(true) {
            BlockPos pos = new BlockPos(origin.getX(), origin.getY() + columnHeight + 1, origin.getZ());
            if(pContext.level().getBlockState(pos.below()).isAir()) columnHeight++;
            else break;
        }

        BlockState state = pContext.level().getBlockState(origin.below());

        if(anyObstruction(pContext.level(), origin, columnHeight)) return false;
        if(!state.is(DDBlocks.GLOOMY_SCULK.get())) return false;
        pContext.level().setBlock(origin.below(), Blocks.RED_WOOL.defaultBlockState(), 3);
        pContext.level().setBlock(origin.above(columnHeight), Blocks.RED_WOOL.defaultBlockState(), 3);

        boolean solid = columnHeight * 0.675f - columnHeight * 0.325f < 7;
        for(int i = 1; i < columnHeight + 1; i++) {
            int newY = origin.getY() + i - 1;
            float percentageToTop = i / ((float) columnHeight + 1);
            BlockPos pos = new BlockPos(origin.getX(), newY, origin.getZ());

            if(percentageToTop >= 0.325f && percentageToTop <= 0.675f) {
                if(solid) pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
                else pContext.level().setBlock(pos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), 3);
            } else if(!solid && percentageToTop >= 0.3f && percentageToTop <= 0.7f) {
                pContext.level().setBlock(pos, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            } else {
                pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
            }
        }

        double multiplier = solid ? 1.2 : 1;
        columnBase(pContext.level(), pContext.random(), origin, columnHeight, multiplier, true);
        columnBase(pContext.level(), pContext.random(), origin.above(columnHeight - 1), columnHeight, multiplier, false);

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
        }

        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextInt((int) (0.22 * columnHeight), (int) (0.26 * columnHeight) + 1);
            if(i > 3) baseHeight *= 0.67;
            placeSection(level, random, origin, baseHeight, i, 2, multiplier, bottom);
        }

        if(multiplier > 1) return;
        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextInt((int) (0.04 * columnHeight), (int) (0.08 * columnHeight) + 1);
            placeSection(level, random, origin, baseHeight, i, 3, multiplier, bottom);
        }
    }

    private void placeSection(WorldGenLevel level, RandomSource random, BlockPos pos, int baseHeight, int iteration, int loop, double multiplier, boolean bottom) {
        float p = random.nextFloat();
        for(int j = 0; j < baseHeight; j++) {
            if(iteration > 3 && multiplier > 1) return;
            if(j == baseHeight - 2 && j != 0  && p < 0.1f) level.setBlock(spread(bottom ? pos.above(j) : pos.below(j), iteration, loop), DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            else if(j == baseHeight - 1 && j != 0  && p < 0.22f) level.setBlock(spread(bottom ? pos.above(j) : pos.below(j), iteration, loop), DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            else level.setBlock(spread(bottom ? pos.above(j) : pos.below(j), iteration, loop), DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
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
}
