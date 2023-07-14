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

        for(int i = 1; i < columnHeight + 1; i++) {
            int newY = origin.getY() + i - 1;
            float percentageToTop = i / ((float) columnHeight + 1);
            BlockPos pos = new BlockPos(origin.getX(), newY, origin.getZ());

            if(percentageToTop >= 0.325f && percentageToTop <= 0.675f) {
                pContext.level().setBlock(pos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), 3);
            } else if(percentageToTop >= 0.3f && percentageToTop <= 0.7f) {
                pContext.level().setBlock(pos, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            } else {
                pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
            }
        }

        columnBase(pContext.level(), pContext.random(), origin, columnHeight, true);
        columnBase(pContext.level(), pContext.random(), origin.above(columnHeight - 1), columnHeight, false);

        return true;
    }

    private boolean anyObstruction(WorldGenLevel level, BlockPos pos, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!level.getBlockState(pos.above(i)).is(Blocks.AIR)) return true;
        }

        return false;
    }

    private void columnBase(WorldGenLevel level, RandomSource random, BlockPos origin, int columnHeight, boolean bottom) {
        for(int i = 0; i < 4; i++) {
            int baseHeight = random.nextInt((int) (0.36 * columnHeight), (int) (0.41 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                if(j == baseHeight - 1 && random.nextFloat() < 0.25f) level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 1), Blocks.WHITE_WOOL.defaultBlockState(), 3);
                else level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 1), Blocks.CYAN_WOOL.defaultBlockState(), 3);
            }
        }

        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextInt((int) (0.22 * columnHeight), (int) (0.26 * columnHeight) + 1);
            if(i > 3) baseHeight *= 0.67;
            for(int j = 0; j < baseHeight; j++) {
                if(i < 4) {
                    if(j == baseHeight - 1 && random.nextFloat() < 0.25f) level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 2), Blocks.WHITE_WOOL.defaultBlockState(), 3);
                    else level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 2), Blocks.PURPLE_WOOL.defaultBlockState(), 3);
                } else if(columnHeight > 18) {
                    if(j == baseHeight - 1 && random.nextFloat() < 0.25f) level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 2), Blocks.WHITE_WOOL.defaultBlockState(), 3);
                    else level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 2), Blocks.PINK_WOOL.defaultBlockState(), 3);
                }
            }
        }

        if(columnHeight < 19) return;
        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextInt((int) (0.04 * columnHeight), (int) (0.08 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                if(j == baseHeight - 1 && random.nextFloat() < 0.25f) level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 3), Blocks.WHITE_WOOL.defaultBlockState(), 3);
                else level.setBlock(spread(bottom ? origin.above(j) : origin.below(j), i, 3), Blocks.LIME_WOOL.defaultBlockState(), 3);
            }
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
