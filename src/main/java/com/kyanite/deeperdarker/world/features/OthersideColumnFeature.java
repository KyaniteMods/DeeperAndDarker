package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.world.features.config.ColumnFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

        boolean incomplete = random.nextFloat() < config.incompleteChance();
        boolean middle = !incomplete && random.nextFloat() < 0.5f;
        for(int i = column.floor() + 1; i < column.ceiling(); i++) {
            if(incomplete && i - column.floor() > column.height() * 2 / 5.0 + 2 && i - column.floor() < 3 * column.height() / 5.0 - 2) continue;

            BlockPos pos = origin.atY(i);
            if(middle && i - column.floor() >= column.height() / 3.0 && i - column.floor() <= 2 * column.height() / 3.0 + 1) {
                BlockState state = config.middleBlock();
                boolean fossil = state.is(DDBlocks.CRYSTALLIZED_AMBER) && random.nextFloat() < 0.4f;

                level.setBlock(pos, fossil ? state.setValue(CrystallizedAmberBlock.FOSSILIZED, true) : state, 3);
                if(fossil && level.getBlockEntity(pos) instanceof CrystallizedAmberBlockEntity blockEntity) blockEntity.generateFossil(level.getLevel(), pos);
            } else {
                level.setBlock(pos, config.block(), 3);
            }
        }

        double multiplier = column.height() < 20 ? 1.2 : 1;
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            int height1 = random.nextInt((int) (column.height() / 3.0 * multiplier), (int) (column.height() / 2.5 * multiplier) + 1);
            int height2 = random.nextInt((int) (0.62 * height1), (int) (0.69 * height1) + 1);
            int height3 = random.nextInt((int) (0.41 * height1), (int) (0.48 * height1) + 1);
            int height4 = random.nextInt((int) (0.1 * height1), (int) (0.22 * height1) + 1);

            for(int i = 1; i <= height1; i++) {
                BlockPos pos = origin.atY(column.floor() + i).relative(direction);
                placeSection(config, level, direction, height2, height3, height4, i, pos, Direction.DOWN);
            }

            height1 = random.nextInt((int) (column.height() / 3.0 * multiplier), (int) (column.height() / 2.5 * multiplier) + 1);
            height2 = random.nextInt((int) (0.62 * height1), (int) (0.69 * height1) + 1);
            height3 = random.nextInt((int) (0.41 * height1), (int) (0.48 * height1) + 1);
            height4 = random.nextInt((int) (0.1 * height1), (int) (0.22 * height1) + 1);

            for(int i = height1; i > 0; i--) {
                BlockPos pos = origin.atY(column.ceiling() - i).relative(direction);
                placeSection(config, level, direction, height2, height3, height4, i, pos, Direction.UP);
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

    private void placeSection(ColumnFeatureConfiguration config, WorldGenLevel level, Direction direction, int height2, int height3, int height4, int i, BlockPos pos, Direction stretchDirection) {
        level.setBlock(pos, config.block(), 3);
        if(i > height2) return;

        level.setBlock(pos.relative(direction.getClockWise()), config.block(), 3);
        if(i > height3) return;

        if(i == 1) {
            stretchToTerrain(config, level, pos, stretchDirection);
            stretchToTerrain(config, level, pos.relative(direction.getClockWise()), stretchDirection);
        }

        pos = pos.relative(direction);
        if(i == 1) {
            stretchToTerrain(config, level, pos, stretchDirection);
            stretchToTerrain(config, level, pos.relative(direction.getClockWise()), stretchDirection);
            stretchToTerrain(config, level, pos.relative(direction.getCounterClockWise()), stretchDirection);
        }

        level.setBlock(pos, config.block(), 3);
        if(i > height4) return;

        level.setBlock(pos.relative(direction.getClockWise()), config.block(), 3);
        level.setBlock(pos.relative(direction.getCounterClockWise()), config.block(), 3);
    }

    private void stretchToTerrain(ColumnFeatureConfiguration config, WorldGenLevel level, BlockPos pos, Direction direction) {
        BlockPos.MutableBlockPos pos2 = pos.relative(direction).mutable();
        while((level.getBlockState(pos2).isAir() || level.getBlockState(pos2).is(config.baseReplaceable())) && pos2.getY() > level.getMinBuildHeight() && pos2.getY() < level.getMaxBuildHeight()) {
            if(level.getBlockState(pos2).is(config.baseReplaceable())) {
                level.setBlock(pos2, config.block(), 3);
                break;
            }
            level.setBlock(pos2, config.block(), 3);
            pos2.move(direction);
        }
    }
}
