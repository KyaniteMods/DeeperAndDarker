package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class GloomslateColumnFeature extends Feature<DefaultFeatureConfig> {
    public GloomslateColumnFeature(Codec configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos origin = context.getOrigin();
        int columnHeight = 0;
        while(true) {
            BlockPos pos = new BlockPos(origin.getX(), origin.getY() + columnHeight + 1, origin.getZ());
            if(context.getWorld().getBlockState(pos.down()).isAir()) columnHeight++;
            else break;
        }

        BlockState state = context.getWorld().getBlockState(origin.down());

        if(anyObstruction(context.getWorld(), origin, columnHeight)) return false;
        if(!state.isOf(DeeperDarkerBlocks.GLOOMY_SCULK)) return false;
        context.getWorld().setBlockState(origin.down(), Blocks.RED_WOOL.getDefaultState(), 3);
        context.getWorld().setBlockState(origin.up(columnHeight), Blocks.RED_WOOL.getDefaultState(), 3);

        for(int i = 1; i < columnHeight + 1; i++) {
            int newY = origin.getY() + i - 1;
            float percentageToTop = i / ((float) columnHeight + 1);
            BlockPos pos = new BlockPos(origin.getX(), newY, origin.getZ());

            if(percentageToTop >= 0.325f && percentageToTop <= 0.675f) {
                context.getWorld().setBlockState(pos, DeeperDarkerBlocks.CRYSTALLIZED_AMBER.getDefaultState(), 3);
            } else if(percentageToTop >= 0.3f && percentageToTop <= 0.7f) {
                context.getWorld().setBlockState(pos, DeeperDarkerBlocks.GLOOMY_SCULK.getDefaultState(), 3);
            } else {
                context.getWorld().setBlockState(pos, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
            }
        }

        columnBase(context.getWorld(), context.getRandom(), origin, columnHeight, true);
        columnBase(context.getWorld(), context.getRandom(), origin.up(columnHeight - 1), columnHeight, false);

        return true;
    }

    private boolean anyObstruction(StructureWorldAccess world, BlockPos pos, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!world.getBlockState(pos.up(i)).isOf(Blocks.AIR)) return true;
        }

        return false;
    }

    private void columnBase(StructureWorldAccess world, Random random, BlockPos origin, int columnHeight, boolean bottom) {
        for(int i = 0; i < 4; i++) {
            int baseHeight = random.nextBetween((int) (0.36 * columnHeight), (int) (0.41 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                if(j == baseHeight - 1 && random.nextFloat() < 0.25f) world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 1), Blocks.WHITE_WOOL.getDefaultState(), 3);
                else world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 1), Blocks.CYAN_WOOL.getDefaultState(), 3);
            }
        }

        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextBetween((int) (0.22 * columnHeight), (int) (0.26 * columnHeight) + 1);
            if(i > 3) baseHeight *= 0.67;
            for(int j = 0; j < baseHeight; j++) {
                if(i < 4) {
                    if(j == baseHeight - 1 && random.nextFloat() < 0.25f) world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 2), Blocks.WHITE_WOOL.getDefaultState(), 3);
                    else world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 2), Blocks.PURPLE_WOOL.getDefaultState(), 3);
                } else if(columnHeight > 18) {
                    if(j == baseHeight - 1 && random.nextFloat() < 0.25f) world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 2), Blocks.WHITE_WOOL.getDefaultState(), 3);
                    else world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 2), Blocks.PINK_WOOL.getDefaultState(), 3);
                }
            }
        }

        if(columnHeight < 19) return;
        for(int i = 0; i < 8; i++) {
            int baseHeight = random.nextBetween((int) (0.04 * columnHeight), (int) (0.08 * columnHeight) + 1);
            for(int j = 0; j < baseHeight; j++) {
                if(j == baseHeight - 1 && random.nextFloat() < 0.25f) world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 3), Blocks.WHITE_WOOL.getDefaultState(), 3);
                else world.setBlockState(spread(bottom ? origin.up(j) : origin.down(j), i, 3), Blocks.LIME_WOOL.getDefaultState(), 3);
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
