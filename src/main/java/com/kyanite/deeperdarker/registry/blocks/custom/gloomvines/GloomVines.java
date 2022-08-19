package com.kyanite.deeperdarker.registry.blocks.custom.gloomvines;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.ToIntFunction;

public interface GloomVines {
    VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    BooleanProperty BERRIES = BlockStateProperties.BERRIES;

    static InteractionResult use(BlockState state, Level level, BlockPos pPos) {
        if(state.getValue(BERRIES)) {
            float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound(null, pPos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            level.setBlock(pPos, state.setValue(BERRIES, Boolean.FALSE), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    static boolean hasGloomBerries(BlockState pState) {
        return pState.hasProperty(BERRIES) && pState.getValue(BERRIES);
    }

    static ToIntFunction<BlockState> emission(int emit) {
        return (state) -> state.getValue(BlockStateProperties.BERRIES) ? emit : 0;
    }
}
