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
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Supplier;

public class SculkGleamFeature extends Feature<NoneFeatureConfiguration> {
    public SculkGleamFeature(Codec<NoneFeatureConfiguration> pFeature) {
        super(pFeature);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos pos = pContext.origin();
        RandomSource random = pContext.random();
        if(!level.isEmptyBlock(pos)) {
            return false;
        } else {
            BlockState blockState = level.getBlockState(pos.above());
            if(!blockState.is(Blocks.SCULK)) {
                return false;
            } else {
                level.setBlock(pos, DDBlocks.SCULK_GLEAM.defaultBlockState(), 2);

                for(int i = 0; i < 1500; i++) {
                    BlockPos offset = pos.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
                    if(level.getBlockState(offset).isAir()) {
                        int j = 0;

                        for(Direction direction : Direction.values()) {
                            if(level.getBlockState(offset.relative(direction)).is(DDBlocks.SCULK_GLEAM)) j++;
                            if(j > 1) break;
                        }

                        if(j == 1) level.setBlock(offset, DDBlocks.SCULK_GLEAM.defaultBlockState(), 2);
                    }
                }

                return true;
            }
        }
    }
}