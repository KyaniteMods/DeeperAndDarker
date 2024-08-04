package com.kyanite.deeperdarker.content.blocks.entity;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DDSignBlockEntity extends SignBlockEntity {
    public DDSignBlockEntity(BlockPos pos, BlockState blockState) {
        super(pos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return DDBlockEntities.DEEPER_DARKER_SIGNS.get();
    }
}
