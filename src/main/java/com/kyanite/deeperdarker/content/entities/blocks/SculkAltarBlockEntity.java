package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SculkAltarBlockEntity extends BlockEntity {
    public SculkAltarBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DDBlockEntities.SCULK_ALTAR, blockPos, blockState);
    }

    public static void itemAnimationTick(Level level, BlockPos blockPos, BlockState blockState, SculkAltarBlockEntity blockEntity) {

    }
}
