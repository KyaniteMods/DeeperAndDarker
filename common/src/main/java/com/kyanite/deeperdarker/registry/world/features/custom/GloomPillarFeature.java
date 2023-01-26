package com.kyanite.deeperdarker.registry.world.features.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GloomPillarFeature extends Feature<NoneFeatureConfiguration> {
    public GloomPillarFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean noSpace(WorldGenLevel getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }

    public int getHeight(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int number = 0;
        while (true) {
            BlockPos pos = new BlockPos(pContext.origin().getX(), pContext.origin().getY() + number + 1, pContext.origin().getZ());
            if(pContext.level().getBlockState(pos.below()).isAir()) {
                number = number + 1;
            } else {
                return number;
            }
        }
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int y = pContext.origin().getY();
        int pillarHeight = getHeight(pContext);

        BlockState down = pContext.level().getBlockState(pContext.origin().below());

        if(noSpace(pContext.level(), pContext.origin(), pillarHeight)) return false;
        if(!down.is(DDBlocks.GLOOM_SCULK.get()))
            return false;

        for(int i = 1; i < pillarHeight + 1; i++) {
            int newY = y + i - 1;
            float percentageToTop = i / ((float) pillarHeight + 1);
            BlockPos pos = new BlockPos(pContext.origin().getX(), newY, pContext.origin().getZ());

            if(percentageToTop >= 0.5f && percentageToTop <= 0.7f) {
                pContext.level().setBlock(pos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), i);
            } else {
                if(pContext.random().nextInt(0, 3) == 0)
                    pContext.level().setBlock(pos, DDBlocks.GLOOM_SCULK.get().defaultBlockState(), i);
                else
                    pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), i);
            }
        }

        return true;
    }
}
