package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

@SuppressWarnings("deprecation, NullableProblems")
public class CrystallizedAmberBlock extends BaseEntityBlock {
    public static final BooleanProperty FOSSILIZED = BooleanProperty.create("fossilized");

    public CrystallizedAmberBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FOSSILIZED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FOSSILIZED);
    }

    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pSide) {
        return pAdjacentBlockState.is(this);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if(pState.getValue(FOSSILIZED) && pState.getBlock() != pNewState.getBlock() && pLevel.getBlockEntity(pPos) instanceof CrystallizedAmberBlockEntity blockEntity) {
            if(blockEntity.fossilizedEntity && pLevel instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.spawn(serverLevel, pPos, MobSpawnType.TRIGGERED);
            else popResource(pLevel, pPos, blockEntity.getFossilizedLoot());
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrystallizedAmberBlockEntity(pPos, pState);
    }
}
