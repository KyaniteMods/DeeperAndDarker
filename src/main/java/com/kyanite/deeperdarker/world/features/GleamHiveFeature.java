package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.world.features.config.GleamHiveFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        HashSet<BlockPos> set = generateBlob(context, origin, mainRadius);
        set.addAll(generateBlob(context, origin.mutable().offset(context.random().nextInt(mainRadius), context.random().nextInt(mainRadius), context.random().nextInt(mainRadius)), secondaryRadius));

        HashSet<BlockPos> exposed = new HashSet<>();
        for (BlockPos pos : set) {
            for (Direction direction : Direction.values()) {
                if (!set.contains(pos.relative(direction))) exposed.add(pos);
            }
        }
        for (BlockPos pos : exposed) {
            boolean alternate = random.nextDouble() < context.config().useAlternateBlockChance();
            if (alternate) {
                context.level().setBlock(pos, context.config().alternateOuterProvider().getState(random, pos), 2);
            } else {
                context.level().setBlock(pos, context.config().outerProvider().getState(random, pos), 2);
            }
        }

        return true;
    }

    private HashSet<BlockPos> generateBlob(FeaturePlaceContext<GleamHiveFeatureConfiguration> context, BlockPos pos, int radius) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();

        HashSet<BlockPos> set = new HashSet<>();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos newPos = pos.mutable().offset(x, y, z);
                    if (newPos.distSqr(pos) > radius * radius) continue;
                    if (canReplaceBlock(level.getBlockState(newPos))) level.setBlock(newPos, context.config().fillingProvider().getState(random, newPos), 2);
                    set.add(newPos);
                }
            }
        }
        return set;
    }

    private boolean canReplaceBlock(BlockState state) {
        return !state.is(BlockTags.FEATURES_CANNOT_REPLACE);
    }
}
