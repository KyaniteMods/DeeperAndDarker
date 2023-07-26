package com.kyanite.deeperdarker.world.gen.feature;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class SculkGleamBlobFeature extends Feature<DefaultFeatureConfig> {
    public SculkGleamBlobFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        if(world.isAir(origin)) {
            BlockState state = world.getBlockState(origin.up());
            if(state.isOf(Blocks.SCULK) || state.isOf(DeeperDarkerBlocks.SCULK_STONE)) {
                world.setBlockState(origin, DeeperDarkerBlocks.SCULK_GLEAM.getDefaultState(), 3);

                for(int i = 0; i < 1500; ++i) {
                    BlockPos pos = origin.add(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
                    if(world.getBlockState(pos).isAir()) {
                        int j = 0;

                        for(Direction direction : Direction.values()) {
                            if(world.getBlockState(pos.offset(direction)).isOf(DeeperDarkerBlocks.SCULK_GLEAM)) j++;
                            if(j > 1) break;
                        }

                        if(j == 1) world.setBlockState(pos, DeeperDarkerBlocks.SCULK_GLEAM.getDefaultState(), 3);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
