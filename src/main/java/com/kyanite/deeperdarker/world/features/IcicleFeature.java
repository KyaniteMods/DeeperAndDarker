package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.world.features.config.IcicleFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Optional;

public class IcicleFeature
        extends Feature<IcicleFeatureConfiguration> {
    public IcicleFeature(Codec<IcicleFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<IcicleFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel levelAccessor = featurePlaceContext.level();
        BlockPos blockPos = featurePlaceContext.origin();
        RandomSource randomSource = featurePlaceContext.random();
        IcicleFeatureConfiguration config = featurePlaceContext.config();
        Optional<Direction> optional = getTipDirection(config.base, config.replaceable, levelAccessor, blockPos);
        if (optional.isEmpty()) {
            return false;
        }
        BlockPos blockPos2 = blockPos.relative(optional.get().getOpposite());
        createPatchOfIceBlocks(levelAccessor, randomSource, blockPos2, config);
        int size = 1;
        int maxSize = config.heightProvider.sample(randomSource);
        while (size < maxSize && IcicleUtils.isEmptyOrWater(levelAccessor.getBlockState(blockPos.relative(optional.get(), size)))) {
            size++;
        }
        IcicleUtils.growIcicle(config.icicleProvider.getState(randomSource, blockPos), config.base, config.replaceable, levelAccessor, blockPos, optional.get(), size, false);
        return true;
    }

    private static Optional<Direction> getTipDirection(TagKey<Block> base, TagKey<Block> replaceable, LevelAccessor levelAccessor, BlockPos blockPos) {
        Direction direction = levelAccessor.getRandom().nextBoolean() ? Direction.UP : Direction.DOWN;
        boolean isIceBase = IcicleUtils.isIceBase(base, replaceable, levelAccessor.getBlockState(blockPos.relative(direction.getOpposite())));
        return isIceBase && levelAccessor.getBlockState(blockPos).isAir() ? Optional.of(direction) : Optional.empty();
    }

    private static void createPatchOfIceBlocks(LevelAccessor levelAccessor, RandomSource randomSource, BlockPos blockPos, IcicleFeatureConfiguration config) {
        IcicleUtils.placeIceBlockIfPossible(config.iceProvider.getState(randomSource, blockPos), config.replaceable, levelAccessor, blockPos);
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (randomSource.nextFloat() > config.chanceOfDirectionalSpread) continue;
            BlockPos blockPos2 = blockPos.relative(direction);
            IcicleUtils.placeIceBlockIfPossible(config.iceProvider.getState(randomSource, blockPos), config.replaceable, levelAccessor, blockPos2);
            if (randomSource.nextFloat() > config.chanceOfSpreadRadius2) continue;
            BlockPos blockPos3 = blockPos2.relative(Direction.getRandom(randomSource));
            IcicleUtils.placeIceBlockIfPossible(config.iceProvider.getState(randomSource, blockPos), config.replaceable, levelAccessor, blockPos3);
            if (randomSource.nextFloat() > config.chanceOfSpreadRadius3) continue;
            BlockPos blockPos4 = blockPos3.relative(Direction.getRandom(randomSource));
            IcicleUtils.placeIceBlockIfPossible(config.iceProvider.getState(randomSource, blockPos), config.replaceable, levelAccessor, blockPos4);
        }
    }
}
