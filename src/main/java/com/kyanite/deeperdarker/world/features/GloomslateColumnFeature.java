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

        for(int i = 1; i < columnHeight + 1; i++) {
            int newY = origin.getY() + i - 1;
            float percentageToTop = i / ((float) columnHeight + 1);
            BlockPos pos = new BlockPos(origin.getX(), newY, origin.getZ());

            if(percentageToTop >= 0.45f && percentageToTop <= 0.6f) {
                pContext.level().setBlock(pos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), 3);
            } else if(percentageToTop >= 0.39f && percentageToTop <= 0.66f) {
                pContext.level().setBlock(pos, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            } else {
                pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
            }
        }

        base(pContext.level(), pContext.random(), origin, columnHeight);

        return true;
    }

    private boolean anyObstruction(WorldGenLevel level, BlockPos pos, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!level.getBlockState(pos.above(i)).is(Blocks.AIR)) return true;
        }

        return false;
    }

    private void base(WorldGenLevel level, RandomSource random, BlockPos origin, int columnHeight) {
        for(int i = 0; i < 4; i++) {
            int baseHeight = random.nextInt((int) (0.36 * columnHeight), (int) (0.4 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                level.setBlock(direction(origin.above(j), i, 1), Blocks.CYAN_WOOL.defaultBlockState(), 3);
            }
        }

        for(int i = 0; i < 4; i++) {
            int baseHeight = random.nextInt((int) (0.26 * columnHeight), (int) (0.3 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                level.setBlock(direction(origin.above(j), i, 2), Blocks.PURPLE_WOOL.defaultBlockState(), 3);
            }
        }

        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextInt((int) (0.15 * columnHeight), (int) (0.22 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                level.setBlock(direction(origin.above(j), i, 3), Blocks.LIME_WOOL.defaultBlockState(), 3);
            }
        }
    }

    private BlockPos direction(BlockPos pos, int index, int loop) {
        BlockPos basePos = pos;
        for(int i = 0; i < loop; i++) {
            int j = i % 2;
            if(index > 3 && i != 1) j += 2;
            switch ((index + j) % 4) {
                default -> basePos = basePos.north();
                case 1 -> basePos = basePos.east();
                case 2 -> basePos = basePos.south();
                case 3 -> basePos = basePos.west();
            }
            // debug for loop = 3
            //     i =    0  1  2
            //     j =    0  1  0
            // index = 0: n, e, n
            // index = 1: e, s, e
            // index = 2: s, w, s
            // index = 3: w, n, w
            //     j =    2  3  2
            // index = 4: s, e, s
            // index = 5: w, s, w
            // index = 6: n, w, n
            // index = 7: e, n, e
        }

        return basePos;
    }
}
