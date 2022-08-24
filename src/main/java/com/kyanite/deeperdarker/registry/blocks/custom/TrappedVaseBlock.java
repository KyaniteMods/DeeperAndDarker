package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TrappedVaseBlock extends AncientVaseBlock implements SimpleWaterloggedBlock {
    public TrappedVaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        StalkerEntity.emergeFromVase(pPos, pLevel);
    }
}
