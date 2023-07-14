package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GloomslateColumnFeature extends Feature<NoneFeatureConfiguration> {
    public GloomslateColumnFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int y = pContext.origin().getY();
        int pillarHeight = getHeight(pContext);

        BlockState state = pContext.level().getBlockState(pContext.origin().below());

        if(noSpace(pContext.level(), pContext.origin(), pillarHeight)) return false;
        if(!state.is(DDBlocks.GLOOMY_SCULK.get())) return false;
        pContext.level().setBlock(pContext.origin().below(), DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);

        for(int i = 1; i < pillarHeight + 1; i++) {
            int newY = y + i - 1;
            float percentageToTop = i / ((float) pillarHeight + 1);
            BlockPos pos = new BlockPos(pContext.origin().getX(), newY, pContext.origin().getZ());

            if(percentageToTop >= 0.45f && percentageToTop <= 0.7f) {
                pContext.level().setBlock(pos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), 3);
            } else if(percentageToTop >= 0.39f && percentageToTop <= 0.76f) {
                pContext.level().setBlock(pos, DDBlocks.GLOOMY_SCULK.get().defaultBlockState(), 3);
            } else {
                pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), 3);
            }
        }

        return true;
    }

    private int getHeight(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        int height = 0;
        while (true) {
            BlockPos pos = new BlockPos(context.origin().getX(), context.origin().getY() + height + 1, context.origin().getZ());
            if(context.level().getBlockState(pos.below()).isAir()) height = height + 1;
            else return height;
        }
    }

    private boolean noSpace(WorldGenLevel level, BlockPos pos, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!level.getBlockState(pos.above(i)).is(Blocks.AIR)) return true;
        }

        return false;
    }
}
