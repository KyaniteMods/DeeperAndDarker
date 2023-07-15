package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.BlockState;
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

public class SculkVinesFeature extends Feature<DefaultFeatureConfig> {
    public SculkVinesFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess level = context.getWorld();
        BlockPos origin = context.getOrigin();
        if(level.isAir(origin)) {
            BlockState state = level.getBlockState(origin.up());
            if(state.isOf(Blocks.SCULK) || state.isOf(DeeperDarkerBlocks.SCULK_STONE) || state.isOf(DeeperDarkerBlocks.ECHO_LEAVES)) {
                this.placeVines(level, context.getRandom(), origin);
                return true;
            }
        }

        return false;
    }

    private void placeVines(WorldAccess level, Random random, BlockPos pos) {
        BlockPos.Mutable blockPos = new BlockPos.Mutable();

        for(int i = 0; i < 100; i++) {
            blockPos.set(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if(level.isAir(blockPos)) {
                BlockState state = level.getBlockState(blockPos.up());
                if(state.isOf(Blocks.SCULK) || state.isOf(DeeperDarkerBlocks.SCULK_STONE) || state.isOf(DeeperDarkerBlocks.ECHO_LEAVES)) {
                    int length = MathHelper.nextInt(random, 1, 8);
                    if(random.nextInt(6) == 0) length *= 2;
                    if(random.nextInt(5) == 0) length = 1;

                    placeVinesColumn(level, random, blockPos, length);
                }
            }
        }
    }

    private void placeVinesColumn(WorldAccess level, Random random, BlockPos.Mutable pos, int length) {
        for(int i = 0; i <= length; i++) {
            if(level.isAir(pos)) {
                if(i == length || !level.isAir(pos.down())) {
                    level.setBlockState(pos, DeeperDarkerBlocks.SCULK_VINES.getDefaultState().with(
                            AbstractPlantStemBlock.AGE, MathHelper.nextInt(random, 17, 25)), 3);
                    break;
                }

                level.setBlockState(pos, DeeperDarkerBlocks.SCULK_VINES_PLANT.getDefaultState(), 3);
            }

            pos.move(Direction.DOWN);
        }
    }
}
