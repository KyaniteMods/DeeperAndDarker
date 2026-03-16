package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class GloomslateLockBlock extends Block {
    public GloomslateLockBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!player.getItemInHand(interactionHand).is(DDTags.Items.UNLOCKS_GLOOMSLATE_LOCK)) return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
        if (level.isClientSide()) return InteractionResult.SUCCESS;
        level.destroyBlock(blockPos, true);

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
        return InteractionResult.CONSUME;
    }
}
