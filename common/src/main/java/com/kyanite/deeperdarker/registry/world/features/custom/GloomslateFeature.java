package com.kyanite.deeperdarker.registry.world.features.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GloomslateFeature extends Feature<NoneFeatureConfiguration> {
    public static Block fromBlock = DDBlocks.SCULK_STONE.get(); // change this to suit your need
    public static Block toBlock = DDBlocks.GLOOMSLATE.get(); // change this to suit your need

    public GloomslateFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        ChunkAccess currentChunk = featurePlaceContext.level().getChunk(featurePlaceContext.origin()); // get Chunk
        int startX = currentChunk.getPos().getMinBlockX(); // get starting X of chunk
        int startZ = currentChunk.getPos().getMinBlockZ(); // get starting Z of chunk
        int endX = currentChunk.getPos().getMaxBlockX(); // get ending X of chunk
        int endZ = currentChunk.getPos().getMaxBlockZ(); // get ending Z of chunk
        int startY = 0; // get starting X of chunk (In this case 0)
        int endY = featurePlaceContext.level().getHeight();  // get ending X of chunk (only replacing up to sea level to reduce amount of scaninng. )

        for(int x = startX; x <= endX; ++x) {
            for(int z = startZ; z <= endZ; ++z) {
                for(int y = startY; y <= endY; ++y) {
                    BlockState state = featurePlaceContext.level().getBlockState(new BlockPos(x, y, z));
                    Block block = state.getBlock();
                    if(block == fromBlock) {
                        featurePlaceContext.level().setBlock(new BlockPos(x, y, z), toBlock.defaultBlockState(), 2);
                    }
                }
            }
        }
        return false;
    }
}
