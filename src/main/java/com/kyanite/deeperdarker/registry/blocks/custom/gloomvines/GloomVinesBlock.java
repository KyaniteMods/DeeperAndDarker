package com.kyanite.deeperdarker.registry.blocks.custom.gloomvines;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

public class GloomVinesBlock extends GrowingPlantHeadBlock implements GloomVines {
    private static final float CHANCE_OF_BERRIES_ON_GROWTH = 0.11F;

    public GloomVinesBlock(BlockBehaviour.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(BERRIES, Boolean.FALSE));
    }

    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    protected Block getBodyBlock() {
        return DDBlocks.GLOOM_VINES_PLANT.get();
    }

    protected BlockState updateBodyAfterConvertedFromHead(BlockState state1, BlockState state2) {
        return state2.setValue(BERRIES, state1.getValue(BERRIES));
    }

    protected BlockState getGrowIntoState(BlockState p_220935_, RandomSource p_220936_) {
        return super.getGrowIntoState(p_220935_, p_220936_).setValue(BERRIES, p_220936_.nextFloat() < 0.11F);
    }

    public ItemStack getCloneItemStack(BlockGetter p_152966_, BlockPos p_152967_, BlockState p_152968_) {
        return new ItemStack(DDItems.GLOOM_BERRIES.get());
    }

    public InteractionResult use(BlockState p_152980_, Level p_152981_, BlockPos p_152982_, Player p_152983_, InteractionHand p_152984_, BlockHitResult p_152985_) {
        return CaveVines.use(p_152980_, p_152981_, p_152982_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_152993_) {
        super.createBlockStateDefinition(p_152993_);
        p_152993_.add(BERRIES);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_221341_) {
        return 0;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return false;
    }
}
