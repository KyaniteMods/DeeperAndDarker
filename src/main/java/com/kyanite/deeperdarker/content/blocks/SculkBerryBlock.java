package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkBerryBlock extends CropBlock {
    public static final int MAX_AGE = 2;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(6.0, -1.0, 6.0, 10.0, 3.0, 10.0),
            Block.box(4.0, -1.0, 4.0, 12.0, 5.0, 12.0),
            Block.box(2.0, -1.0, 2.0, 14.0, 10.0, 14.0)
    };

    public SculkBerryBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(DDBlocks.ECHO_FARMLAND);
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return DDItems.SCULK_BERRY_SPROUT;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(3) == 0) return;
        int age = getAge(blockState);
        if (age < this.getMaxAge() && randomSource.nextInt((int)(25.0f / getGrowthSpeed(this, serverLevel, blockPos)) + 1) == 0) {
            serverLevel.setBlock(blockPos, this.getStateForAge(age + 1), 2);
        }
    }

    protected static float getGrowthSpeed(Block block, BlockGetter blockGetter, BlockPos blockPos) {
        float f = 1.0f;
        BlockPos blockPos2 = blockPos.below();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float g = 0.0f;
                BlockState blockState = blockGetter.getBlockState(blockPos2.offset(i, 0, j));
                if (blockState.is(DDBlocks.ECHO_FARMLAND)) {
                    g = 1.0f;
                }
                if (i != 0 || j != 0) {
                    g /= 4.0f;
                }
                f += g;
            }
        }
        BlockPos blockPos3 = blockPos.north();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockPos blockPos6 = blockPos.east();
        boolean bl = blockGetter.getBlockState(blockPos5).is(block) || blockGetter.getBlockState(blockPos6).is(block);
        boolean bl2 = blockGetter.getBlockState(blockPos3).is(block) || blockGetter.getBlockState(blockPos4).is(block);
        if (bl && bl2) {
            f /= 2.0f;
        } else {
            boolean bl4 = blockGetter.getBlockState(blockPos5.north()).is(block) || blockGetter.getBlockState(blockPos6.north()).is(block) || blockGetter.getBlockState(blockPos6.south()).is(block) || blockGetter.getBlockState(blockPos5.south()).is(block);
            if (bl4) {
                f /= 2.0f;
            }
        }
        return f;
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos below = blockPos.below();
        return mayPlaceOn(levelReader.getBlockState(below), levelReader, below);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 3;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_BY_AGE[this.getAge(blockState)];
    }
}
