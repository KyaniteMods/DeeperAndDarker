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
    public SculkGleamFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if(!level.isEmptyBlock(origin)) return false;

        BlockState aboveState = level.getBlockState(origin.above());
        if(!aboveState.is(Blocks.SCULK) && !aboveState.is(DDBlocks.SCULK_STONE.get())) return false;

        level.setBlock(origin, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), 3);

        for(int i = 0; i < 1500; ++i) {
            BlockPos pos = origin.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
            if(level.getBlockState(pos).isAir()) {
                int j = 0;

                for(Direction direction : Direction.values()) {
                    BlockState neighbor = level.getBlockState(pos.relative(direction));
                    if(neighbor.is(DDBlocks.SCULK_GLEAM.get()) || neighbor.is(DDBlocks.POROUS_SCULK_GLEAM)) {
                        if(level.getBlockState(pos.relative(direction).above()).is(DDBlocks.ECHO_LEAVES)) j++;
                        j++;
                    }
                    if(j > 1) break;
                }

                if(j == 1) {
                    if(random.nextFloat() < 0.14f) level.setBlock(pos, DDBlocks.POROUS_SCULK_GLEAM.get().defaultBlockState(), 3);
                    else level.setBlock(pos, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), 3);
                }
            }
        }

        return true;
    }
}
