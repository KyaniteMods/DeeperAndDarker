package com.kyanite.deeperdarker.content.blocks.flammable;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class RotatedFlammableBlock extends RotatedPillarBlock {
    private final int FLAMMABILITY;
    private final int SPREAD;

    public RotatedFlammableBlock(Properties pProperties, int flammability, int spread) {
        super(pProperties);
        this.FLAMMABILITY = flammability;
        this.SPREAD = spread;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return FLAMMABILITY;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return SPREAD;
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(toolAction == ToolActions.AXE_STRIP) {
            if(state.is(DDBlocks.ECHO_LOG.get())) return DDBlocks.STRIPPED_ECHO_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if(state.is(DDBlocks.ECHO_WOOD.get())) return DDBlocks.STRIPPED_ECHO_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
