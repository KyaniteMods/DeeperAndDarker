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
    public BloomingStemFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();

        if(!level.getBlockState(origin.below()).is(DDBlocks.BLOOMING_SCULK_STONE.get())) return false;

        int branches = random.nextIntBetweenInclusive(1, 2);
        int length = random.nextIntBetweenInclusive(6, 20);
        double probability = (double) branches / length;

        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos(origin.getX(), origin.getY(), origin.getZ());
        Direction direction = Direction.UP;
        Direction nextDirection = Direction.values()[biasedInt(random)];

        for(int i = 0; i < length; i++) {
            if(!level.getBlockState(blockPos).isAir()) break;

            Direction branchDirection = null;
            if(direction == Direction.UP && random.nextDouble() < probability) {
                BlockPos.MutableBlockPos branchBlockPos = new BlockPos.MutableBlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                branchDirection = Direction.values()[random.nextIntBetweenInclusive(2, 5)];
                branchBlockPos.move(branchDirection);

                level.setBlock(branchBlockPos, stemPlacement(branchDirection, branchDirection.getOpposite(), branchDirection), 3);
                probability /= 2;
            }

            level.setBlock(blockPos, stemPlacement(direction, nextDirection, branchDirection), 3);

            direction = nextDirection;
            if(nextDirection.getAxis().isHorizontal()) nextDirection = Direction.UP;
            else nextDirection = Direction.values()[biasedInt(random)];
            blockPos.move(direction);
        }

        level.setBlock(blockPos, stemPlacement(direction, direction.getOpposite(), null), 3);

        return true;
    }

    private int biasedInt(RandomSource random) {
        float dir = random.nextFloat();
        if(dir < 0.5f) return 1;
        if(dir < 0.625f) return 2;
        if(dir < 0.75f) return 3;
        if(dir < 0.875f) return 4;
        return 5;
    }

    private BlockState stemPlacement(Direction direction, Direction nextDirection, Direction branchDirection) {
        BlockState stem = DDBlocks.BLOOMING_STEM.get().defaultBlockState().setValue(BloomingStemBlock.DOWN, false).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(nextDirection), true);
        if(branchDirection == null) return stem;
        else return stem.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(branchDirection), true);
    }
}
