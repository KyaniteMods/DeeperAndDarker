package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.BloomingStemBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Optional;

public class BloomingStemFeature extends Feature<NoneFeatureConfiguration> {
    public BloomingStemFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource random = pContext.random();

        if(!level.getBlockState(origin.below()).is(DDBlocks.BLOOMING_SCULK_STONE)) return false;

        int branches = random.nextIntBetweenInclusive(1, 2);
        int length = random.nextIntBetweenInclusive(6, 20);
        double probability = (double) branches / length;

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(origin.getX(), origin.getY(), origin.getZ());
        BlockPos.MutableBlockPos branchPos = new BlockPos.MutableBlockPos();
        Direction direction = Direction.UP;

        Optional<BlockState> stem = placeStem(level, pos, direction, false);
        if (stem.isEmpty()) return false;

        for(int i = 0; i < length; i++) {
            pos.move(direction);
            if (!level.getBlockState(pos.relative(direction)).isAir()) return true;

            placeStem(level, pos, direction, false);

            Direction branchDirection;
            if (random.nextDouble() < probability && (branchDirection = Direction.values()[random.nextIntBetweenInclusive(2, 5)]) != direction) {
                branchPos.set(pos).move(branchDirection);
                Optional<BlockState> branchState = placeStem(level, branchPos, branchDirection, false);
                if (branchState.isPresent()) probability /= 2;
            }

            if (direction.getAxis().isHorizontal()) direction = Direction.UP;
            else direction = Direction.values()[biasedInt(random)];
        }

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

    private Optional<BlockState> placeStem(LevelAccessor level, BlockPos pos, Direction direction, boolean ignoreCheck) {
        if (!level.getBlockState(pos).isAir()) return Optional.empty();
        if (direction != Direction.UP && ((BloomingStemBlock) DDBlocks.BLOOMING_STEM).validBase(level.getBlockState(pos.below()))) return Optional.empty();
        BlockState state = stemPlacement(direction);
        if (ignoreCheck || state.canSurvive(level, pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
            BlockPos oppositePos = pos.relative(direction.getOpposite());
            BlockState oppositeState = level.getBlockState(oppositePos);
            if (oppositeState.is(state.getBlock())) {
                level.setBlock(oppositePos, oppositeState.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction), true), Block.UPDATE_ALL);
            }
            return Optional.of(state);
        }
        return Optional.empty();
    }

    private BlockState stemPlacement(Direction direction) {
        return DDBlocks.BLOOMING_STEM.defaultBlockState().setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true).setValue(BloomingStemBlock.AGE, 25);
    }
}