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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BloomingStemFeature extends Feature<NoneFeatureConfiguration> {
    private final List<Direction> DIRECTIONS = Arrays.stream(Direction.values()).filter(direction -> direction.get3DDataValue() > 0).toList();
    private final List<Direction> history = new ArrayList<>(Stream.generate(() -> Direction.UP).limit(5).toList());

    public BloomingStemFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();

        if(!level.getBlockState(origin.below()).is(DDBlocks.BLOOMING_SCULK_STONE.get())) return false;
        if(!level.getBlockState(origin.above()).isAir()) return false;

        int branches = random.nextIntBetweenInclusive(1, 2);
        int length = random.nextIntBetweenInclusive(6, 20);
        double probability = (double) branches / length;

        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos(origin.getX(), origin.getY(), origin.getZ());
        Direction direction = Direction.UP;
        Direction nextDirection = randomDirection(random);

        for(int i = 0; i < length; i++) {
            if(!level.getBlockState(blockPos).isAir()) break;
            if(!level.getBlockState(blockPos.relative(nextDirection)).isAir()) break;
            history.set(i % 5, direction);

            Direction branchDirection = null;
            if(i > 6 && direction == Direction.UP && random.nextDouble() < probability) {
                BlockPos.MutableBlockPos branchBlockPos = new BlockPos.MutableBlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                branchDirection = Direction.values()[random.nextIntBetweenInclusive(2, 5)];
                branchBlockPos.move(branchDirection);

                level.setBlock(branchBlockPos, stemPlacement(branchDirection, branchDirection.getOpposite(), null), 3);
                probability /= 2;
            }

            level.setBlock(blockPos, stemPlacement(direction, nextDirection, branchDirection), 3);

            direction = nextDirection;
            if(nextDirection.getAxis().isHorizontal()) nextDirection = Direction.UP;
            else nextDirection = randomDirection(random);
            blockPos.move(direction);
        }

        level.setBlock(blockPos, stemPlacement(direction, direction.getOpposite(), null), 3);
        return true;
    }

    private Direction randomDirection(RandomSource random) {
        List<Direction> list = new ArrayList<>(DIRECTIONS);
        for(Direction d : history) {
            list.remove(d);
            list.remove(d.getOpposite());
        }

        int dir = 0;
        float chance = 1 - 0.125f * list.size();
        float f = random.nextFloat();
        while(chance < f) {
            chance += 0.125f;
            dir++;
        }

        list.add(0, Direction.UP);
        return list.get(dir);
    }

    private BlockState stemPlacement(Direction direction, Direction nextDirection, Direction branchDirection) {
        BlockState stem = DDBlocks.BLOOMING_STEM.get().defaultBlockState().setValue(BloomingStemBlock.DOWN, false).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true).setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(nextDirection), true);
        if(branchDirection == null) return stem;
        else return stem.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(branchDirection), true);
    }
}
