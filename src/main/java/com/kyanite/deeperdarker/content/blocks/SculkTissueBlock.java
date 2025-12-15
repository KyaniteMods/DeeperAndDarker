package com.kyanite.deeperdarker.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SculkTissueBlock extends Block {
    public SculkTissueBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        entity.causeFallDamage(f, 0.2f, level.damageSources().fall());
    }
}
