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
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class SculkPillarFeature extends Feature<NoneFeatureConfiguration> {
    private final WeightedStateProvider placementBlock;

    public SculkPillarFeature(Codec<NoneFeatureConfiguration> pCodec, WeightedStateProvider placementBlock) {
        super(pCodec);
        this.placementBlock = placementBlock;
    }

    public boolean noSpace(WorldGenLevel getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int y = pContext.origin().getY();
        int pillarHeight = pContext.random().nextInt(13, 35);

        BlockState down = pContext.level().getBlockState(pContext.origin().below());

        boolean hasValidBelowBlock = down.is(Blocks.SCULK) || down.is(DDBlocks.GLOOM_SCULK.get());

        if(noSpace(pContext.level(), pContext.origin(), pillarHeight)) return false;
        if(!hasValidBelowBlock)
            return false;

        for(int i = 0; i < pillarHeight; i++) {
            int newY = y + i;
            placeSingle(pContext.level(), new BlockPos(pContext.origin().getX(), newY, pContext.origin().getZ()), i, pillarHeight);
        }

        return true;
    }

    public void placeSingle(WorldGenLevel level, BlockPos pos, int i, int height) {
        level.setBlock(pos, placementBlock.getState(level.getRandom(), pos), 3);

        if(i < height / 1.8f) {
            level.setBlock(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), placementBlock.getState(level.getRandom(), pos), 3);

            level.setBlock(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1), placementBlock.getState(level.getRandom(), pos), 3);
        } else if(i < height / 1.3f) {
            level.setBlock(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), placementBlock.getState(level.getRandom(), pos), 3);
            level.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), placementBlock.getState(level.getRandom(), pos), 3);
        } else {
            level.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), placementBlock.getState(level.getRandom(), pos), 3);
        }
    }
}
