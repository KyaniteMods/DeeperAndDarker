package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SculkStoneColumnFeature extends Feature<NoneFeatureConfiguration> {
    public SculkStoneColumnFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if(!level.getBlockState(origin).isAir()) return false;

        int columnHeight = 0;
        BlockPos.MutableBlockPos pos = origin.below().mutable();

        // extend down until a block is hit
        while(level.getBlockState(pos).isAir() && pos.getY() > level.getMinBuildHeight()) {
            level.setBlock(pos, Blocks.RED_STAINED_GLASS.defaultBlockState(), 3);
            pos.move(Direction.DOWN);
            columnHeight++;
        }
        BlockPos bottom = pos.immutable();
        pos = origin.above().mutable();

        // extend up until a block is hit
        while(level.getBlockState(pos).isAir() && pos.getY() < level.getMaxBuildHeight()) {
            level.setBlock(pos, Blocks.BLUE_STAINED_GLASS.defaultBlockState(), 3);
            pos.move(Direction.UP);
            columnHeight++;
        }
        BlockPos top = pos.immutable();

        if(columnHeight < 5) return false;

        level.setBlock(bottom, Blocks.LIME_WOOL.defaultBlockState(), 3);
        level.setBlock(top, Blocks.LIME_WOOL.defaultBlockState(), 3);
        level.setBlock(origin, Blocks.YELLOW_WOOL.defaultBlockState(), 3);

        return true;
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
            if(j == baseHeight - 2 && j != 0  && p < 0.1f) level.setBlock(location, Blocks.SCULK.defaultBlockState(), 3);
            else if(j == baseHeight - 1 && j != 0  && p < 0.22f) level.setBlock(location, Blocks.SCULK.defaultBlockState(), 3);
            else level.setBlock(location, DDBlocks.SCULK_STONE.get().defaultBlockState(), 3);
        }
    }

    private BlockPos spread(BlockPos pos, int index, int loop) {
        BlockPos basePos = pos;
        for(int i = 0; i < loop; i++) {
            int j = i % 2;
            if(index > 3 && loop == 2 && i == 0) j++;
            else if(index > 3 && i != 1) j += 2;
            switch ((index + j) % 4) {
                case 1 -> basePos = basePos.east();
                case 2 -> basePos = basePos.south();
                case 3 -> basePos = basePos.west();
                default -> basePos = basePos.north();
            }
        }

        return basePos;
    }

    private void stretchToFloor(WorldGenLevel level, BlockPos pos, int i, int loop, boolean bottom) {
        BlockPos blockPos = spread(bottom ? pos.below() : pos.above(), i, loop);

        if(bottom) {
            while(!level.getBlockState(blockPos).is(DDBlocks.SCULK_STONE.get()) && !level.getBlockState(blockPos).is(Blocks.DEEPSLATE) && !level.isOutsideBuildHeight(blockPos)) {
                level.setBlock(blockPos, DDBlocks.SCULK_STONE.get().defaultBlockState(), 3);
                blockPos = blockPos.below();
            }
            return;
        }

        while(!level.getBlockState(blockPos).is(Blocks.SCULK) && !level.getBlockState(blockPos).is(DDBlocks.SCULK_STONE.get()) && !level.getBlockState(blockPos).is(Blocks.DEEPSLATE) && !level.isOutsideBuildHeight(blockPos)) {
            level.setBlock(blockPos, DDBlocks.SCULK_STONE.get().defaultBlockState(), 3);
            blockPos = blockPos.above();
        }
    }
}
