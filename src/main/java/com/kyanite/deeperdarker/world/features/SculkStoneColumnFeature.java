package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Optional;

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
        Optional<Column> scan = Column.scan(level, origin, 64, BlockBehaviour.BlockStateBase::isAir, blockState -> !blockState.isAir());
        if(scan.isEmpty() || !(scan.get() instanceof Column.Range column)) return false;
        if(column.height() < 7) return false;
        if(!level.getBlockState(origin.atY(column.floor())).is(DDTags.Blocks.DEEPLANDS_COLUMN_BASE) || !level.getBlockState(origin.atY(column.ceiling())).is(DDTags.Blocks.DEEPLANDS_COLUMN_BASE)) return false;

        for(int x = -2; x <= 2; x++) {
            for(int z = -2; z <= 2; z++) {
                if(x == 0 && z == 0) continue;

                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(origin.getX() + x, column.floor(), origin.getZ() + z);
                boolean air = level.getBlockState(pos).isAir();
                if(checkUnevenBase(level, pos, air, air ? Direction.DOWN : Direction.UP)) return false;

                pos.setY(column.ceiling());
                air = level.getBlockState(pos).isAir();
                if(checkUnevenBase(level, pos, air, air ? Direction.UP : Direction.DOWN)) return false;
            }
        }

        int middle = column.floor() + column.height() / 2;
        for(int i = column.floor() + 1; i < column.ceiling(); i++) {
            if(i > middle) level.setBlock(origin.atY(i), Blocks.BLUE_STAINED_GLASS.defaultBlockState(), 3);
            else level.setBlock(origin.atY(i), Blocks.RED_STAINED_GLASS.defaultBlockState(), 3);
        }

        level.setBlock(origin.atY(column.floor()), Blocks.BLUE_WOOL.defaultBlockState(), 3);
        level.setBlock(origin.atY(column.ceiling()), Blocks.LIGHT_BLUE_WOOL.defaultBlockState(), 3);
        level.setBlock(origin.atY(middle), Blocks.LIME_WOOL.defaultBlockState(), 3);

        return true;
    }

    public static boolean checkUnevenBase(WorldGenLevel level, BlockPos.MutableBlockPos pos, boolean air, Direction direction) {
        int heightDiff = 0;
        BlockPos comparePos = air ? pos : pos.relative(direction);

        while(level.getBlockState(comparePos).isAir() == air) {
            pos.move(direction);
            comparePos = air ? pos : pos.relative(direction);
            heightDiff++;
            if(heightDiff > 4) return true;
        }

        return !level.getBlockState(pos).is(DDTags.Blocks.DEEPLANDS_COLUMN_BASE);
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
