package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.world.features.config.ColumnFeatureConfiguration;
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

import java.util.Optional;

public class OthersideColumnFeature extends Feature<ColumnFeatureConfiguration> {
    public OthersideColumnFeature(Codec<ColumnFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ColumnFeatureConfiguration> context) {
        ColumnFeatureConfiguration config = context.config();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if(!level.getBlockState(origin).isAir()) return false;
        Optional<Column> scan = Column.scan(level, origin, 64, BlockBehaviour.BlockStateBase::isAir, blockState -> !blockState.isAir());
        if(scan.isEmpty() || !(scan.get() instanceof Column.Range column)) return false;
        if(column.height() < 7) return false;
        if(!level.getBlockState(origin.atY(column.floor())).is(config.columnBase()) || !level.getBlockState(origin.atY(column.ceiling())).is(config.columnBase())) return false;

        for(int x = -2; x <= 2; x++) {
            for(int z = -2; z <= 2; z++) {
                if(x == 0 && z == 0) continue;

                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(origin.getX() + x, column.floor(), origin.getZ() + z);
                boolean air = level.getBlockState(pos).isAir();
                if(checkUnevenBase(config, level, pos, air, air ? Direction.DOWN : Direction.UP)) return false;

                pos.setY(column.ceiling());
                air = level.getBlockState(pos).isAir();
                if(checkUnevenBase(config, level, pos, air, air ? Direction.UP : Direction.DOWN)) return false;
            }
        }

        for(int i = column.floor() + 1; i < column.ceiling(); i++) {
            level.setBlock(origin.atY(i), config.block(), 3);
        }

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            int height1 = random.nextInt((int) (column.height() / 3.33), (int) (column.height() / 2.7) + 1);
            int height2 = random.nextInt((int) (0.61 * height1), (int) (0.67 * height1) + 1);
            int height3 = random.nextInt((int) (0.41 * height1), (int) (0.47 * height1) + 1);
            int height4 = random.nextInt((int) (0.1 * height1), (int) (0.22 * height1) + 1);

            for(int i = 1; i <= height1; i++) {
                BlockPos pos = origin.atY(column.floor() + i).relative(direction);
                placeSection(level, direction, height2, height3, height4, i, pos);
            }

            height1 = random.nextInt((int) (column.height() / 3.33), (int) (column.height() / 2.5) + 1);
            height2 = random.nextInt((int) (0.61 * height1), (int) (0.69 * height1) + 1);
            height3 = random.nextInt((int) (0.41 * height1), (int) (0.48 * height1) + 1);
            height4 = random.nextInt((int) (0.1 * height1), (int) (0.22 * height1) + 1);

            for(int i = height1; i > 0; i--) {
                BlockPos pos = origin.atY(column.ceiling() - i).relative(direction);
                placeSection(level, direction, height2, height3, height4, i, pos);
            }
        }

        return true;
    }

    public static boolean checkUnevenBase(ColumnFeatureConfiguration config, WorldGenLevel level, BlockPos.MutableBlockPos pos, boolean air, Direction direction) {
        int heightDiff = 0;
        BlockPos comparePos = air ? pos : pos.relative(direction);

        while(level.getBlockState(comparePos).isAir() == air) {
            pos.move(direction);
            comparePos = air ? pos : pos.relative(direction);
            heightDiff++;
            if(heightDiff > 4) return true;
        }

        return !level.getBlockState(pos).is(config.columnBase());
    }

    private void placeSection(WorldGenLevel level, Direction direction, int height2, int height3, int height4, int i, BlockPos pos) {
        level.setBlock(pos, Blocks.RED_STAINED_GLASS.defaultBlockState(), 3);
        if(i > height2) return;

        level.setBlock(pos.relative(direction.getClockWise()), Blocks.ORANGE_STAINED_GLASS.defaultBlockState(), 3);
        if(i > height3) return;

        pos = pos.relative(direction);
        level.setBlock(pos, Blocks.YELLOW_STAINED_GLASS.defaultBlockState(), 3);
        if(i > height4) return;

        level.setBlock(pos.relative(direction.getClockWise()), Blocks.LIME_STAINED_GLASS.defaultBlockState(), 3);
        level.setBlock(pos.relative(direction.getCounterClockWise()), Blocks.CYAN_STAINED_GLASS.defaultBlockState(), 3);
    }
}
