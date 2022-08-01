package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SculkGleamFeature extends Feature<NoneFeatureConfiguration> {
    public SculkGleamFeature(Codec<NoneFeatureConfiguration> pFeature) {
        super(pFeature);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel worldGenLevel = pContext.level();
        BlockPos blockPos = pContext.origin();
        RandomSource random = pContext.random();
        if (!worldGenLevel.isEmptyBlock(blockPos)) {
            return false;
        } else {
            BlockState blockstate = worldGenLevel.getBlockState(blockPos.above());
            if (!blockstate.is(Blocks.SCULK)) {
                return false;
            } else {
                worldGenLevel.setBlock(blockPos, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), 2);

                for (int i = 0; i < 1500; i++) {
                    BlockPos offset = blockPos.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
                    if (worldGenLevel.getBlockState(offset).isAir()) {
                        int j = 0;

                        for (Direction direction : Direction.values()) {
                            if (worldGenLevel.getBlockState(offset.relative(direction)).is(DDBlocks.SCULK_GLEAM.get())) j++;
                            if (j > 1) break;
                        }

                        if (j == 1) worldGenLevel.setBlock(offset, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), 2);
                    }
                }

                return true;
            }
        }
    }
}
