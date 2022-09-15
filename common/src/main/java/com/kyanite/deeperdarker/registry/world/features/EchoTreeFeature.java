package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class EchoTreeFeature extends Feature<NoneFeatureConfiguration> {
    public EchoTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int height = pContext.random().nextInt(6, 8);

        if(pContext.random().nextInt(0, 2) == 0) return false;
        if(!pContext.level().getBlockState(pContext.origin().below()).is(Blocks.SCULK)) return false;
        if(noSpace(pContext.level(), pContext.origin(), height + 3)) return false;

        int logs;
        for(logs = 0; logs < height; logs++) {
            BlockPos logPos = new BlockPos(pContext.origin().getX(), pContext.origin().above(logs).getY(), pContext.origin().getZ());
            if(TreeFeature.validTreePos(pContext.level(), logPos)) {
                pContext.level().setBlock(logPos, DDBlocks.ECHO_LOG.defaultBlockState(), 3);
            }
        }

        placeStems(pContext.level(), pContext.origin());
        placeLeaves(pContext.level(), new BlockPos(pContext.origin().getX(), pContext.origin().getY() + height, pContext.origin().getZ()), pContext.random());

        return true;
    }

    public boolean noSpace(WorldGenLevel getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }

    public void placeLeaves(WorldGenLevel level, BlockPos origin, RandomSource randomSources) {
        int x = origin.getX();
        int y = origin.getY();
        int z = origin.getZ();
        int x1;
        int z1 = 0;
        int topLengthX = randomSources.nextInt(3, 4);
        int topLengthZ = randomSources.nextInt(3, 4);

        for(x1 = 0; x1 < topLengthX; x1++) {
            tryPlaceLeaf(level, new BlockPos(x + x1, y, z));
            tryPlaceLeaf(level, new BlockPos(x - x1, y, z));
            if(x1 < topLengthX / 1.2f) {
                tryPlaceLeaf(level, new BlockPos(x + x1, y + 1, z));
                tryPlaceLeaf(level, new BlockPos(x - x1, y + 1, z));
            }
            for(z1 = 0; z1 < topLengthZ; z1++) {
                tryPlaceLeaf(level, new BlockPos(x, y, z + z1));
                tryPlaceLeaf(level, new BlockPos(x, y, z - z1));
                if(z1 < topLengthZ / 1.2f)
                {
                    tryPlaceLeaf(level, new BlockPos(x, y + 1, z + z1));
                    tryPlaceLeaf(level, new BlockPos(x, y + 1, z - z1));
                }
            }
        }

        int x2;
        int spiderTopLength = randomSources.nextInt(3, 4);

        for(x2 = 0; x2 < spiderTopLength; x2++) {
            tryPlaceLeaf(level, new BlockPos(x - x2, y, z - x2));
            tryPlaceLeaf(level, new BlockPos(x + x2, y, z + x2));
            tryPlaceLeaf(level, new BlockPos(x - x2, y, z + x2));
            tryPlaceLeaf(level, new BlockPos(x + x2, y, z - x2));

            if(x2 < spiderTopLength / 1.2f){
                tryPlaceLeaf(level, new BlockPos(x - x2, y + 1, z - x2));
                tryPlaceLeaf(level, new BlockPos(x + x2, y + 1, z + x2));
                tryPlaceLeaf(level, new BlockPos(x - x2, y + 1, z + x2));
                tryPlaceLeaf(level, new BlockPos(x + x2, y + 1, z - x2));
            }
        }

        placeHanging(randomSources, level, new BlockPos(x + x1, y, z));
        placeHanging(randomSources, level, new BlockPos(x - x1, y, z));
        placeHanging(randomSources, level, new BlockPos(x, y, z + z1));
        placeHanging(randomSources, level, new BlockPos(x, y, z - z1));

        placeHanging(randomSources, level, new BlockPos(x + x2, y, z - x2));
        placeHanging(randomSources, level, new BlockPos(x - x2, y, z + x2));
        placeHanging(randomSources, level, new BlockPos(x + x2, y, z + x2));
        placeHanging(randomSources, level, new BlockPos(x - x2, y, z - x2));

        tryPlaceLeaf(level, new BlockPos(origin.getX() - 1, origin.getY() - 1, origin.getZ()));
        tryPlaceLeaf(level, new BlockPos(origin.getX() + 1, origin.getY() - 1, origin.getZ()));
        tryPlaceLeaf(level, new BlockPos(origin.getX(), origin.getY() - 1, origin.getZ() - 1));
        tryPlaceLeaf(level, new BlockPos(origin.getX(), origin.getY() - 1, origin.getZ() + 1));
        tryPlaceLeaf(level, new BlockPos(origin.getX() - 1, origin.getY() - 1, origin.getZ() - 1));
        tryPlaceLeaf(level, new BlockPos(origin.getX() + 1, origin.getY() - 1, origin.getZ() + 1));
        tryPlaceLeaf(level, new BlockPos(origin.getX() + 1, origin.getY() - 1, origin.getZ() - 1));
        tryPlaceLeaf(level, new BlockPos(origin.getX() - 1, origin.getY() - 1, origin.getZ() + 1));
    }

    public void placeHanging(RandomSource source, WorldGenLevel level, BlockPos pos) {
        for(int dripAmount = 0; dripAmount < source.nextInt(2, 5); dripAmount++) {
            tryPlaceLeaf(level, new BlockPos(pos.getX(), pos.getY() - dripAmount, pos.getZ()));
        }
    }
    public void placeStems(WorldGenLevel level, BlockPos origin) {
        int x = origin.getX();
        int y = origin.getY();
        int z = origin.getZ();

        level.setBlock(new BlockPos(x - 1, y, z), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x - 1, y - 1, z), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x + 1, y, z), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x + 1, y - 1, z), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);

        level.setBlock(new BlockPos(x, y, z - 1), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x, y - 1, z - 1), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x, y + 1, z - 1), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);

        level.setBlock(new BlockPos(x, y, z + 1), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x, y - 1, z + 1), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
        level.setBlock(new BlockPos(x, y + 1, z + 1), DDBlocks.ECHO_WOOD.defaultBlockState(), 3);
    }

    public void tryPlaceLeaf(WorldGenLevel level, BlockPos pos) {
        if(TreeFeature.validTreePos(level, pos)) {
            if(level.getRandom().nextInt(0, 20) == 0) setBlock(level, pos, DDBlocks.SCULK_GLEAM.defaultBlockState());
            else setBlock(level, pos, DDBlocks.ECHO_LEAVES.defaultBlockState());
        }
    }
}