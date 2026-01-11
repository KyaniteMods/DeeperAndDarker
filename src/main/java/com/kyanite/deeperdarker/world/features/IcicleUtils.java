package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.blocks.IcicleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;

import java.util.function.Consumer;

public class IcicleUtils {
    protected static double getIcicleHeight(double d, double e, double f, double g) {
        if (d < g) {
            d = g;
        }
        double h = 0.384;
        double i = d / e * 0.384;
        double j = 0.75 * Math.pow(i, 1.3333333333333333);
        double k = Math.pow(i, 0.6666666666666666);
        double l = 0.3333333333333333 * Math.log(i);
        double m = f * (j - k - l);
        m = Math.max(m, 0.0);
        return m / 0.384 * e;
    }

    protected static boolean isCircleMostlyEmbeddedInStone(WorldGenLevel worldGenLevel, BlockPos blockPos, int i) {
        if (IcicleUtils.isEmptyOrWaterOrLava(worldGenLevel, blockPos)) {
            return false;
        }
        float g = 6.0f / (float)i;
        for (float h = 0.0f; h < (float)Math.PI * 2; h += g) {
            int j = (int)(Mth.cos(h) * (float)i);
            if (!IcicleUtils.isEmptyOrWaterOrLava(worldGenLevel, blockPos.offset(j, 0, (int)(Mth.sin(h) * (float)i)))) continue;
            return false;
        }
        return true;
    }

    protected static boolean isEmptyOrWater(LevelAccessor levelAccessor, BlockPos blockPos) {
        return levelAccessor.isStateAtPosition(blockPos, IcicleUtils::isEmptyOrWater);
    }

    protected static boolean isEmptyOrWaterOrLava(LevelAccessor levelAccessor, BlockPos blockPos) {
        return levelAccessor.isStateAtPosition(blockPos, IcicleUtils::isEmptyOrWaterOrLava);
    }

    protected static void buildBaseToTipColumn(BlockState icicle, Direction direction, int i, boolean bl, Consumer<BlockState> consumer) {
        if (i >= 3) {
            consumer.accept(createIcicle(icicle, direction, DripstoneThickness.BASE));
            for (int j = 0; j < i - 3; ++j) {
                consumer.accept(createIcicle(icicle, direction, DripstoneThickness.MIDDLE));
            }
        }
        if (i >= 2) {
            consumer.accept(createIcicle(icicle, direction, DripstoneThickness.FRUSTUM));
        }
        if (i >= 1) {
            consumer.accept(createIcicle(icicle, direction, bl ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
        }
    }

    protected static void growIcicle(BlockState icicle, TagKey<Block> base, TagKey<Block> replaceable, LevelAccessor levelAccessor, BlockPos blockPos, Direction direction, int i, boolean bl) {
        if (!isIceBase(base, replaceable, levelAccessor.getBlockState(blockPos.relative(direction.getOpposite())))) {
            return;
        }
        BlockPos.MutableBlockPos mutableBlockPos = blockPos.mutable();
        buildBaseToTipColumn(icicle, direction, i, bl, blockState -> {
            if (blockState.is(icicle.getBlock())) {
                blockState = blockState.setValue(IcicleBlock.WATERLOGGED, levelAccessor.isWaterAt(mutableBlockPos));
            }
            levelAccessor.setBlock(mutableBlockPos, blockState, 2);
            mutableBlockPos.move(direction);
        });
    }

    protected static boolean placeIceBlockIfPossible(BlockState ice, TagKey<Block> replaceable, LevelAccessor levelAccessor, BlockPos blockPos) {
        BlockState blockState = levelAccessor.getBlockState(blockPos);
        if (blockState.is(replaceable)) {
            levelAccessor.setBlock(blockPos, ice, 2);
            return true;
        }
        return false;
    }

    private static BlockState createIcicle(BlockState icicle, Direction direction, DripstoneThickness dripstoneThickness) {
        return icicle.setValue(IcicleBlock.TIP_DIRECTION, direction).setValue(IcicleBlock.THICKNESS, dripstoneThickness);
    }

    public static boolean isIceBase(TagKey<Block> base, TagKey<Block> replaceable, BlockState blockState) {
        return blockState.is(base) || blockState.is(replaceable);
    }

    public static boolean isEmptyOrWater(BlockState blockState) {
        return blockState.isAir() || blockState.is(Blocks.WATER);
    }

    public static boolean isNeitherEmptyNorWater(BlockState blockState) {
        return !blockState.isAir() && !blockState.is(Blocks.WATER);
    }

    public static boolean isEmptyOrWaterOrLava(BlockState blockState) {
        return blockState.isAir() || blockState.is(Blocks.WATER) || blockState.is(Blocks.LAVA);
    }
}
