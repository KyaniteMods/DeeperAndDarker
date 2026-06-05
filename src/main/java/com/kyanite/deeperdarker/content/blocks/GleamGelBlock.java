package com.kyanite.deeperdarker.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("NullableProblems")
public class GleamGelBlock extends HalfTransparentBlock {
    public GleamGelBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        entity.causeFallDamage(fallDistance, 0f, entity.damageSources().fall());
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        entity.makeStuckInBlock(state, new Vec3(0.5, 0.2, 0.5));
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return super.isStickyBlock(state) || state.is(this);
    }

    @Override
    public boolean canStickTo(BlockState state, BlockState other) {
        if(state.is(this) && other.getBlock() == Blocks.SLIME_BLOCK) return false;
        if(state.is(this) && other.getBlock() == Blocks.HONEY_BLOCK) return false;
        return super.canStickTo(state, other);
    }
}
