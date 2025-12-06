package com.kyanite.deeperdarker.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class FragileBlock extends Block {
    public FragileBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void destroy(LevelAccessor level, BlockPos blockPos, BlockState blockState) {
        super.destroy(level, blockPos, blockState);

        // BFS. could use recursion instead but causes stack overflow for too many blocks
        Queue<BlockPos> stack = new ArrayDeque<>();
        Set<BlockPos> explored = new HashSet<>();
        explored.add(blockPos);
        stack.add(blockPos);

        while (!stack.isEmpty()) {
            BlockPos pos = stack.remove();
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.offset(direction.getNormal());
                if (level.getBlockState(neighborPos).is(this) && !explored.contains(neighborPos)) {
                    explored.add(neighborPos);
                    stack.add(neighborPos);
                    level.destroyBlock(neighborPos, true);
                }
            }
        }
    }
}
