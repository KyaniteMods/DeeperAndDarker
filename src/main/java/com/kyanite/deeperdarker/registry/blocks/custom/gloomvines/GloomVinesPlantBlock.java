package com.kyanite.deeperdarker.registry.blocks.custom.gloomvines;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

public class GloomVinesPlantBlock extends GrowingPlantBodyBlock implements GloomVines {

    public GloomVinesPlantBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(BERRIES, Boolean.FALSE));
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return DDBlocks.GLOOM_VINES.get();
    }

    @Override
    protected BlockState updateHeadAfterConvertedFromBody(BlockState pState, BlockState pNewState) {
        return pNewState.setValue(BERRIES, pState.getValue(BERRIES));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(DDItems.GLOOM_BERRIES.get());
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return CaveVines.use(pState, pLevel, pPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BERRIES);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return false;
    }
}
