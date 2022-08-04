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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

public class GloomVinesPlantBlock extends GrowingPlantBodyBlock implements GloomVines {

    public GloomVinesPlantBlock(BlockBehaviour.Properties p_153000_) {
        super(p_153000_, Direction.DOWN, SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(BERRIES, Boolean.FALSE));
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return DDBlocks.GLOOM_VINES.get();
    }

    protected BlockState updateHeadAfterConvertedFromBody(BlockState p_153028_, BlockState p_153029_) {
        return p_153029_.setValue(BERRIES, p_153028_.getValue(BERRIES));
    }

    public ItemStack getCloneItemStack(BlockGetter p_153007_, BlockPos p_153008_, BlockState p_153009_) {
        return new ItemStack(DDItems.GLOOM_BERRIES.get());
    }

    public InteractionResult use(BlockState p_153021_, Level p_153022_, BlockPos p_153023_, Player p_153024_, InteractionHand p_153025_, BlockHitResult p_153026_) {
        return CaveVines.use(p_153021_, p_153022_, p_153023_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153031_) {
        p_153031_.add(BERRIES);
    }

    public boolean isValidBonemealTarget(BlockGetter p_153011_, BlockPos p_153012_, BlockState p_153013_, boolean p_153014_) {
        return false;
    }
}