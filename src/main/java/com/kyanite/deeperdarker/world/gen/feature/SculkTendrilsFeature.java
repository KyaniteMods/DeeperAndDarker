package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SculkTendrilsFeature extends Feature<DefaultFeatureConfig> {
    public SculkTendrilsFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess level = context.getWorld();
        BlockPos origin = context.getOrigin();
        if (isValidPlacementLocation(level, origin)) {
            Random random = context.getRandom();
            int width = 8;
            int height = 4;
            int maxHeight = 8;
            BlockPos.Mutable blockPos = new BlockPos.Mutable();

            for(int i = 0; i < width * width; i++) {
                blockPos.set(origin).move(MathHelper.nextInt(random, -width, width), MathHelper.nextInt(random, -height, height), MathHelper.nextInt(random, -width, width));
                if (findAirAboveGround(level, blockPos) && isValidPlacementLocation(level, blockPos)) {
                    int length = MathHelper.nextInt(random, 1, maxHeight);
                    if(random.nextInt(6) == 0) length *= 2;
                    if(random.nextInt(5) == 0) length = 1;

                    placeColumn(level, random, blockPos, length);
                }
            }

            return true;
        }

        return false;
    }

    private boolean isValidPlacementLocation(WorldAccess world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(Blocks.SCULK);
    }

    private boolean findAirAboveGround(WorldAccess world, BlockPos.Mutable pos) {
        do {
            pos.move(0, -1, 0);
            if (world.isOutOfHeightLimit(pos)) return false;
        } while (world.getBlockState(pos).isAir());

        pos.move(0, 1, 0);
        return true;
    }

    private void placeColumn(WorldAccess world, Random random, BlockPos.Mutable pos, int length) {
        for(int i = 1; i <= length; i++) {
            if(world.isAir(pos)) {
                if(i == length || !world.isAir(pos.up())) {
                    world.setBlockState(pos, DeeperDarkerBlocks.SCULK_TENDRILS.getDefaultState().with(
                            AbstractPlantStemBlock.AGE, MathHelper.nextInt(random, 17, 25)), 3);
                    break;
                }

                world.setBlockState(pos, DeeperDarkerBlocks.SCULK_TENDRILS_PLANT.getDefaultState(), 3);
            }

            pos.move(Direction.UP);
        }
    }
}
