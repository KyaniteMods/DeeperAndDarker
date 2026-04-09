package com.kyanite.deeperdarker.content.fluids;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDFluids;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class AcidFluid extends FlowingFluid {
    @Override
    public Fluid getFlowing() {
        return DDFluids.FLOWING_ACID;
    }

    @Override
    public Fluid getSource() {
        return DDFluids.ACID;
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {

    }

    @Override
    protected int getSlopeFindDistance(LevelReader levelReader) {
        return 2;
    }

    @Override
    protected int getDropOff(LevelReader levelReader) {
        return 2;
    }

    @Override
    public Item getBucket() {
        return DDItems.ACID_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Fluid fluid, Direction direction) {
        return fluidState.getHeight(blockGetter, blockPos) >= 4.0f/9.0f && fluid.is(FluidTags.WATER);
    }

    @Override
    protected void spreadTo(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState adjacentFluid = levelAccessor.getFluidState(blockPos);
            if (this.is(DDTags.Fluids.ACID) && blockState.getBlock() instanceof LiquidBlock) {
                if (adjacentFluid.is(FluidTags.WATER)) {
                    levelAccessor.setBlock(blockPos, DDBlocks.SCULK_STONE.defaultBlockState(), Block.UPDATE_ALL);
                    return;
                } else if (adjacentFluid.is(FluidTags.LAVA)) {
                    levelAccessor.setBlock(blockPos, DDBlocks.SCULK_BASALT.defaultBlockState(), Block.UPDATE_ALL);
                    return;
                } else {
                    System.out.println("Third branch!");
                }
            }
        }
        super.spreadTo(levelAccessor, blockPos, blockState, direction, fluidState);
    }

    @Override
    public int getTickDelay(LevelReader levelReader) {
        return 10;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0f;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return DDBlocks.ACID.defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == DDFluids.ACID || fluid == DDFluids.FLOWING_ACID;
    }

    public static class Flowing
            extends AcidFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }

    public static class Source
            extends AcidFluid {
        @Override
        public int getAmount(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}
