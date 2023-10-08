package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
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
    public SculkGleamFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();
        if(level.isEmptyBlock(origin)) {
            BlockState state = level.getBlockState(origin.above());
            if(state.is(Blocks.SCULK) || state.is(DDBlocks.SCULK_STONE.get())) {
                level.setBlock(origin, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), 3);

                for(int i = 0; i < 1500; ++i) {
                    BlockPos pos = origin.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
                    if(level.getBlockState(pos).isAir()) {
                        int j = 0;

                        for(Direction direction : Direction.values()) {
                            if(level.getBlockState(pos.relative(direction)).is(DDBlocks.SCULK_GLEAM.get())) j++;
                            if(j > 1) break;
                        }

                        if(j == 1) level.setBlock(pos, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), 3);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
