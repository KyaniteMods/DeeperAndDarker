package com.kyanite.deeperdarker.registry.blocks.entity.custom;

import com.kyanite.deeperdarker.registry.blocks.entity.DDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DDSignBlockEntity extends SignBlockEntity {
    public DDSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return DDBlockEntityTypes.SIGN_BLOCK_ENTITIES.get();
    }
}