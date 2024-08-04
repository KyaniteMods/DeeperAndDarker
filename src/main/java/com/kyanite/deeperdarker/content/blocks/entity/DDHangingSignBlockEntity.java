package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DDHangingSignBlockEntity extends HangingSignBlockEntity {
    public DDHangingSignBlockEntity(BlockPos pos, BlockState blockState) {
        super(pos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get();
    }
}
