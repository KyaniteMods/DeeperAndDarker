package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.world.features.config.GleamHiveFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.ArrayList;
import java.util.List;

public class GleamHiveFeature extends Feature<GleamHiveFeatureConfiguration> {
    public GleamHiveFeature(Codec<GleamHiveFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<GleamHiveFeatureConfiguration> context) {
        RandomSource random = context.random();

        int mainRadius = context.config().mainRadiusProvider().sample(random);
        int secondaryRadius = context.config().secondaryRadiusProvider().sample(random);
        if (mainRadius < secondaryRadius) {
            int temp = mainRadius;
            mainRadius = secondaryRadius;
            secondaryRadius = temp;
        }
        BlockPos origin = context.origin().mutable().offset(0, mainRadius, 0);
        generateBlob(context, origin, mainRadius);
        generateBlob(context, origin.mutable().offset(context.random().nextInt(mainRadius), context.random().nextInt(mainRadius), context.random().nextInt(mainRadius)), secondaryRadius);
        return true;
    }

    private List<BlockPos> generateBlob(FeaturePlaceContext<GleamHiveFeatureConfiguration> context, BlockPos pos, int radius) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();

        List<BlockPos> list = new ArrayList<>();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos newPos = pos.mutable().offset(x, y, z);
                    if (newPos.distSqr(pos) > radius * radius) continue;
                    if (canReplaceBlock(level.getBlockState(newPos))) level.setBlock(newPos, context.config().fillingProvider().getState(random, newPos), 2);
                    list.add(newPos);
                }
            }
        }
        return list;
    }

    private boolean canReplaceBlock(BlockState state) {
        return !state.is(BlockTags.FEATURES_CANNOT_REPLACE);
    }
}
