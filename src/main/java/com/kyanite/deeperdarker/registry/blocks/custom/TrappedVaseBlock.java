package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TrappedVaseBlock extends AncientVaseBlock {
    public TrappedVaseBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        StalkerEntity stalkerEntity = DDEntities.STALKER.get().create(pLevel);
        stalkerEntity.moveTo(pPos.getX(), pPos.getY(), pPos.getZ(), 0, 0);
        pLevel.addFreshEntity(stalkerEntity);
    }
}
