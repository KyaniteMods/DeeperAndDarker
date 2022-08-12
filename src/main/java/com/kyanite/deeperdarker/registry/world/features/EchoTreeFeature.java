package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.List;

public class EchoTreeFeature extends Feature<NoneFeatureConfiguration> {
    public EchoTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    public boolean noSpaceBelow(WorldGenLevel getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.below(i)).is(Blocks.AIR)) return true;
        }
        return false;
    }

    // Place the little dangling bits
    public void placeHanging(BlockPos origin, WorldGenLevel level, RandomSource randomSource) {
        int rand = randomSource.nextInt(1, 4);
        level.setBlock(origin, DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);
        for (int hangingThings = 0; hangingThings < rand; hangingThings++) {
            level.setBlock(new BlockPos(origin.getX(), origin.getY() - (1 + hangingThings), origin.getZ()), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        // Generate a random height so it doesnt all look the same
        int height = pContext.random().nextInt(4, 7);

        // Some checks so generation isnt cursed
        if(noSpaceBelow(pContext.level(), pContext.origin(), (int) (height + 4))) return false;
        if(pContext.level().getBlockState(pContext.origin().above()).is(Blocks.AIR)) return false;

        int logs;

        // Log placement
        for (logs = 0; logs < height; logs++) {
            BlockPos logPos = new BlockPos(pContext.origin().getX(), pContext.origin().below(logs).getY(), pContext.origin().getZ());
            pContext.level().setBlock(logPos, DDBlocks.ECHO_LOG.get().defaultBlockState(), Block.UPDATE_ALL);
        }

        // Corner pieces

        pContext.level().setBlock(new BlockPos(pContext.origin().getX() + 1, pContext.origin().getY() - height - 1, pContext.origin().getZ() + 1), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);
        pContext.level().setBlock(new BlockPos(pContext.origin().getX() - 1, pContext.origin().getY() - height - 1, pContext.origin().getZ() - 1), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);

        pContext.level().setBlock(new BlockPos(pContext.origin().getX() + 1, pContext.origin().getY() - height - 1, pContext.origin().getZ() - 1), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);
        pContext.level().setBlock(new BlockPos(pContext.origin().getX() - 1, pContext.origin().getY() - height - 1, pContext.origin().getZ() + 1), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);

        // Placing on each direction

        int x1, x2;
        int z1, z2;

        for (x1 = 0; x1 < 2; x1++) {pContext.level().setBlock(new BlockPos(pContext.origin().getX() - x1, pContext.origin().getY() - height, pContext.origin().getZ()), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);}
        placeHanging(new BlockPos(pContext.origin().getX() - x1, pContext.origin().getY() - height - 1, pContext.origin().getZ()), pContext.level(), pContext.random());

        for (x2 = 0; x2 < 2; x2++) {pContext.level().setBlock(new BlockPos(pContext.origin().getX() + x2, pContext.origin().getY() - height, pContext.origin().getZ()), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);}
        placeHanging(new BlockPos(pContext.origin().getX() + x2, pContext.origin().getY() - height - 1, pContext.origin().getZ()), pContext.level(), pContext.random());

        for (z1 = 0; z1 < 2; z1++) {pContext.level().setBlock(new BlockPos(pContext.origin().getX(), pContext.origin().getY() - height, pContext.origin().getZ() + z1), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);}
        placeHanging(new BlockPos(pContext.origin().getX(), pContext.origin().getY() - height - 1, pContext.origin().getZ() - z1), pContext.level(), pContext.random());

        for (z2 = 0; z2 < 2; z2++) {pContext.level().setBlock(new BlockPos(pContext.origin().getX(), pContext.origin().getY() - height, pContext.origin().getZ() - z2), DDBlocks.SCULK_GLEAM.get().defaultBlockState(), Block.UPDATE_ALL);}
        placeHanging(new BlockPos(pContext.origin().getX(), pContext.origin().getY() - height - 1, pContext.origin().getZ() + z2), pContext.level(), pContext.random());

        return true;
    }
}
