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

public class GloomyPillarFeature extends Feature<NoneFeatureConfiguration> {
    public GloomyPillarFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean noSpace(WorldGenLevel getter, BlockPos origin, int distance) {
        for (int i = 0; i < distance; i++) {
            if (!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int y = pContext.origin().getY();
        int pillarHeight = pContext.random().nextInt(6, 14);

        BlockState down = pContext.level().getBlockState(pContext.origin().below());

        if (noSpace(pContext.level(), pContext.origin(), pillarHeight)) return false;
        if (!down.is(DDBlocks.GLOOM_SCULK.get()))
            return false;

        for (int i = 0; i < pillarHeight; i++) {
            int newY = y + i;
            float percentageToTop = ((float)pillarHeight) / i;
            BlockPos pos = new BlockPos(pContext.origin().getX(), newY, pContext.origin().getZ());

            if(percentageToTop >= 0.5f && percentageToTop <= 0.7f) {
                pContext.level().setBlock(pos, DDBlocks.CRYSTALLIZED_AMBER.get().defaultBlockState(), i);
            } else {
                pContext.level().setBlock(pos, DDBlocks.GLOOMSLATE.get().defaultBlockState(), i);
            }
        }

        return true;
    }
}
