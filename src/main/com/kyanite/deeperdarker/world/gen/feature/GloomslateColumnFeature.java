package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
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
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        int columnHeight = 0;
        while (true) {
            BlockPos pos = new BlockPos(origin.getX(), origin.getY() + columnHeight + 1, origin.getZ());
            if (world.getBlockState(pos.down()).isAir()) columnHeight++;
            else break;
        }

        if (anyObstruction(world, origin, columnHeight)) return false;
        if (!world.getBlockState(origin.down()).isOf(DeeperDarkerBlocks.GLOOMY_SCULK)) return false;
        world.setBlockState(origin.down(), DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
        world.setBlockState(origin.up(columnHeight), DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);

        int amberLength = (int) (columnHeight * 0.35f);
        int gapSize = 0;
        boolean incomplete = random.nextFloat() < 0.3f;
        if (amberLength > 9) gapSize = BiasedToBottomIntProvider.create(2, amberLength - 7).get(random);
        int gapStart = (amberLength - gapSize) / 2;
        int gapPlacement = 0;

        for (int i = 1; i < columnHeight + 1; i++) {
            int newY = origin.getY() + i - 1;
            float percentageToTop = i / ((float) columnHeight + 1);
            BlockPos pos = new BlockPos(origin.getX(), newY, origin.getZ());

            if (percentageToTop >= 0.325f && percentageToTop <= 0.675f) {
                if (amberLength < 7) world.setBlockState(pos, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
                else if (amberLength > 9 && incomplete) {
                    if (gapPlacement < gapStart || gapPlacement > gapStart + gapSize) world.setBlockState(pos, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
                    gapPlacement++;
                }
                else world.setBlockState(pos, DeeperDarkerBlocks.CRYSTALLIZED_AMBER.getDefaultState(), 3);
            } else if (amberLength > 6 && !incomplete && percentageToTop >= 0.3f && percentageToTop <= 0.7f) {
                world.setBlockState(pos, DeeperDarkerBlocks.GLOOMY_SCULK.getDefaultState(), 3);
            } else {
                world.setBlockState(pos, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
            }
        }

        double multiplier = amberLength < 7 ? 1.2 : amberLength > 9 && incomplete ? 0.92 : 1;
        columnBase(world, random, origin, columnHeight, multiplier, true);
        columnBase(world, random, origin.up(columnHeight - 1), columnHeight, multiplier, false);

        return true;
    }

    private boolean anyObstruction(StructureWorldAccess world, BlockPos pos, int distance) {
        for (int i = 0; i < distance; i++) {
            if (!world.getBlockState(pos.up(i)).isOf(Blocks.AIR)) return true;
        }

        return false;
    }

    private void columnBase(StructureWorldAccess world, Random random, BlockPos origin, int columnHeight, double multiplier, boolean bottom) {
        for (int i = 0; i < 4; i++) {
            int baseHeight = random.nextBetween((int) (0.36 * columnHeight * multiplier), (int) (0.41 * columnHeight * multiplier) + 1);
            placeSection(world, random, origin, baseHeight, i, 1, multiplier, bottom);
            stretchToFloor(world, origin, i, 1, bottom);
        }

        for (int i = 0; i < 8; i++) {
            int baseHeight = random.nextBetween((int) (0.22 * columnHeight), (int) (0.26 * columnHeight) + 1);
            if (i > 3) baseHeight *= 0.67;
            placeSection(world, random, origin, baseHeight, i, 2, multiplier, bottom);
            stretchToFloor(world, origin, i, 2, bottom);
        }

        if (multiplier > 1) return;
        for (int i = 0; i < 8; i++) {
            int baseHeight = random.nextBetween((int) (0.04 * columnHeight), (int) (0.08 * columnHeight) + 1);
            placeSection(world, random, origin, baseHeight, i, 3, multiplier, bottom);
            stretchToFloor(world, origin, i, 3, bottom);
        }
    }

    private void placeSection(StructureWorldAccess world, Random random, BlockPos pos, int baseHeight, int iteration, int loop, double multiplier, boolean bottom) {
        float p = random.nextFloat();
        for (int j = 0; j < baseHeight; j++) {
            BlockPos location = spread(bottom ? pos.up(j) : pos.down(j), iteration, loop);

            if (iteration > 3 && multiplier > 1) return;
            if (j == baseHeight - 2 && j != 0  && p < 0.1f) world.setBlockState(location, DeeperDarkerBlocks.GLOOMY_SCULK.getDefaultState(), 3);
            else if (j == baseHeight - 1 && j != 0  && p < 0.22f) world.setBlockState(location, DeeperDarkerBlocks.GLOOMY_SCULK.getDefaultState(), 3);
            else world.setBlockState(location, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
        }
    }

    private BlockPos spread(BlockPos pos, int index, int loop) {
        BlockPos basePos = pos;
        for (int i = 0; i < loop; i++) {
            int j = i % 2;
            if (index > 3 && loop == 2 && i == 0) j++;
            else if (index > 3 && i != 1) j += 2;
            switch ((index + j) % 4) {
                default -> basePos = basePos.north();
                case 1 -> basePos = basePos.east();
                case 2 -> basePos = basePos.south();
                case 3 -> basePos = basePos.west();
            }
        }

        return basePos;
    }

    private void stretchToFloor(StructureWorldAccess world, BlockPos pos, int i, int loop, boolean bottom) {
        BlockPos blockPos = spread(bottom ? pos.down() : pos.up(), i, loop);

        if (bottom) {
            while (!world.getBlockState(blockPos).isOf(DeeperDarkerBlocks.GLOOMSLATE) && !world.getBlockState(blockPos).isOf(Blocks.DEEPSLATE)) {
                world.setBlockState(blockPos, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
                blockPos = blockPos.down();
            }
            return;
        }

        while (!world.getBlockState(blockPos).isOf(DeeperDarkerBlocks.GLOOMY_SCULK) && !world.getBlockState(blockPos).isOf(DeeperDarkerBlocks.GLOOMSLATE) && !world.getBlockState(blockPos).isOf(Blocks.DEEPSLATE)) {
            world.setBlockState(blockPos, DeeperDarkerBlocks.GLOOMSLATE.getDefaultState(), 3);
            blockPos = blockPos.up();
        }
    }
}
