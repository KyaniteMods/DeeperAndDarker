package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DDSkullBlockEntity extends SkullBlockEntity {
    public DDSkullBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return DDBlockEntities.SKULL;
    }

    @Override
    public @Nullable ResourceLocation getNoteBlockSound() {
        return this.getBlockState().getBlock() == DDBlocks.SHATTERED_HEAD ? DDSounds.NOTE_BLOCK_IMITATE_SHATTERED.value().getLocation() : super.getNoteBlockSound();
    }
}
