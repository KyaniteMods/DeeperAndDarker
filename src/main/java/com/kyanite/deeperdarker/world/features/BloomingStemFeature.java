package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.BloomingStemBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BloomingStemFeature extends Feature<NoneFeatureConfiguration> {

    public BloomingStemFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if(!level.getBlockState(origin.below()).is(DDBlocks.BLOOMING_SCULK_STONE.get())) return false;
        if(!level.isEmptyBlock(origin) || !level.isEmptyBlock(origin.above())) return false;

        int length = random.nextInt(6, 25);

        BlockPos.MutableBlockPos pos = origin.mutable();
        Direction direction = Direction.UP;
        Direction nextDirection = Direction.UP;

        for(int i = 0; i < length; i++) {
            BlockPos nextPos = pos.relative(nextDirection);
            if(!level.isEmptyBlock(pos.above())) break;
            if(!level.isEmptyBlock(nextPos)) break;

            BlockState state = DDBlocks.BLOOMING_STEM.get().defaultBlockState().setValue(BloomingStemBlock.AGE, 25).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(nextDirection), true);
            Direction previous = direction;
            direction = nextDirection;

            if(previous == Direction.UP && random.nextFloat() < 0.3f) { // turn
                nextDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                /*if(random.nextFloat() < 0.4f) { // branch
                    Direction branchDir = Direction.getRandom(random);
                    if(random.nextFloat() < 0.5f) branchDir = Direction.UP;
                    else while(branchDir == Direction.DOWN || branchDir == nextDirection) branchDir = Direction.getRandom(random);

                    if(level.isEmptyBlock(nextPos.relative(branchDir))) {
                        *//*Direction d3 = Direction.DOWN;
                        if(branchDir == Direction.UP) {
                            while(d3 == Direction.DOWN) d3 = Direction.getRandom(random);
                        } else {
                            d3 = Direction.UP;
                        }*//*
                        level.setBlock(nextPos.relative(branchDir), DDBlocks.BLOOMING_STEM.get().defaultBlockState().setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(branchDir.getOpposite()), true), 3);
                        state = state.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(branchDir), true);
//                        branch(level, pos, branch, d3, length - growth, random);
                    }
                }*/
            } else {
                nextDirection = Direction.UP;
            }

            level.setBlock(pos, state, 3);
            pos.move(direction);
        }

        BlockState state = DDBlocks.BLOOMING_STEM.get().defaultBlockState().setValue(BloomingStemBlock.AGE, 25).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true);
        level.setBlock(pos, state, 3);

        return true;
    }
}
