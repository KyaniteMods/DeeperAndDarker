package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.world.features.config.ConeConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class ConeFeature
        extends Feature<ConeConfiguration> {
    public ConeFeature(Codec<ConeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ConeConfiguration> featurePlaceContext) {
        RandomSource random = featurePlaceContext.random();
        WorldGenLevel level = featurePlaceContext.level();
        ConeConfiguration config = featurePlaceContext.config();
        BlockPos origin = featurePlaceContext.origin();
        int width = config.widthProvider.sample(random);
        int depth = config.depthProvider.sample(random);
        int height = config.heightProvider.sample(random);
        int tipShiftX = config.tipXShiftProvider.sample(random);
        int shiftY = config.yShiftProvider.sample(random);
        int tipShiftZ = config.tipZShiftProvider.sample(random);

        int maxX = Math.max(Mth.positiveCeilDiv(width, 2), tipShiftX);
        int maxZ = Math.max(Mth.positiveCeilDiv(depth, 2), tipShiftZ);

        if (!(level.isEmptyBlock(origin) || level.getBlockState(origin).canBeReplaced()) || level.getBlockState(origin.below()).isAir()) return false;

        BlockPos.MutableBlockPos pos = origin.mutable();

        for (int offsetZ = -maxZ; offsetZ <= maxZ; offsetZ++) {
            for (int offsetY = 0; offsetY <= height; offsetY++) {
                float progress = (float) (offsetY) / height;
                for (int offsetX = -maxX; offsetX <= maxX; offsetX++) {
                    float shiftedX = offsetX - (tipShiftX * progress);
                    float shiftedZ = offsetZ - (tipShiftZ * progress);
                    if (Mth.abs(shiftedX * shiftedX / width + shiftedZ * shiftedZ / depth) <= 1.0f - progress) {
                        pos.move(offsetX, offsetY + shiftY, offsetZ);
                        BlockState state = level.getBlockState(pos);
                        if (state.is(config.replaceable) || level.isEmptyBlock(pos)) {
                            level.setBlock(pos, config.blockStateProvider.getState(random, pos), Block.UPDATE_CLIENTS);
                        }
                        pos.move(-offsetX, -(offsetY + shiftY), -offsetZ);
                    }
                }
            }
        }

        return true;
    }
}
