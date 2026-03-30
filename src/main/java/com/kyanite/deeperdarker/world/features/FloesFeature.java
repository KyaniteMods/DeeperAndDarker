package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.util.SimpleWorleyNoise;
import com.kyanite.deeperdarker.world.features.config.FloesFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class FloesFeature extends Feature<FloesFeatureConfiguration> {
    public FloesFeature(Codec<FloesFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FloesFeatureConfiguration> featurePlaceContext) {
        FloesFeatureConfiguration config = featurePlaceContext.config();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        RandomSource random = featurePlaceContext.random();
        BlockPos blockPos = featurePlaceContext.origin();
        SimpleWorleyNoise noise = SimpleWorleyNoise.create(random);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int dz = 0; dz < 16; dz++) {
            for (int dx = 0; dx < 16; dx++) {
                int x = blockPos.getX() + dx;
                int z = blockPos.getZ() + dz;
                float value = noise.get(x, z);
                boolean floe = value < config.threshold();
                for (int y = worldGenLevel.getMinBuildHeight(); y < (floe ? config.maxFloeHeight() : config.maxSeamHeight()); y++) {
                    mutableBlockPos.set(x, y, z);
                    if (worldGenLevel.getBlockState(mutableBlockPos).isAir()) {
                        if (floe) {
                            worldGenLevel.setBlock(mutableBlockPos, config.floeBlockState().getState(worldGenLevel, random, mutableBlockPos), Block.UPDATE_CLIENTS);
                        } else if (config.seamBlockState().isPresent()) {
                            worldGenLevel.setBlock(mutableBlockPos, config.seamBlockState().get().getState(worldGenLevel, random, mutableBlockPos), Block.UPDATE_CLIENTS);
                        }
                    }
                }
            }
        }
        return true;
    }
}
