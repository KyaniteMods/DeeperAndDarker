package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.world.features.config.BoulderFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class BoulderFeature extends Feature<BoulderFeatureConfiguration> {
    public BoulderFeature(Codec<BoulderFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BoulderFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel level = featurePlaceContext.level();
        RandomSource random = featurePlaceContext.random();
        BlockPos origin = featurePlaceContext.origin();
        BoulderFeatureConfiguration config = featurePlaceContext.config();
        int diameter = config.diameter.sample(featurePlaceContext.random());
        float radius = diameter / 2.0f;
        int radiusInt = Mth.ceil(radius);

        if (level.isEmptyBlock(origin.below())) return false;

        boolean placed = false;
        BlockPos.MutableBlockPos pos = origin.mutable();
        for (int offsetZ = -radiusInt; offsetZ <= radiusInt; offsetZ++) {
            for (int offsetY = -radiusInt; offsetY <= radiusInt; offsetY++) {
                for (int offsetX = -radiusInt; offsetX <= radiusInt; offsetX++) {
                    if (Mth.abs(offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ) <= radius * radius && level.getBlockState(pos.setWithOffset(origin, offsetX, offsetY, offsetZ)).canBeReplaced()) {
                        placed = true;
                        level.setBlock(pos, config.stateProvider.getState(random, pos), Block.UPDATE_CLIENTS);
                    }
                }
            }
        }
        return placed;
    }
}
