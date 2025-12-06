package com.kyanite.deeperdarker.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class FragileBlock extends Block {
    public FragileBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        super.onRemove(blockState, level, blockPos, blockState2, bl);
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = blockPos.offset(direction.getNormal());
            if (level.getBlockState(neighborPos).is(this) && level.getRandom().nextFloat() < 0.9f) level.destroyBlock(neighborPos, true);
        }
    }
}
