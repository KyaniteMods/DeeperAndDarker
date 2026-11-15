package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LockBlock extends Block {
    private final KeyType keyType;

    public LockBlock(KeyType keyType, Properties properties) {
        super(properties);
        this.keyType = keyType;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        return use(level, blockPos, player, itemStack);
    }

    public ItemInteractionResult use(Level level, BlockPos pos, @Nullable Player player, ItemStack stack) {
        ItemInteractionResult useKey = keyType.use(player, stack);
        if (useKey != ItemInteractionResult.SUCCESS) return useKey;
        if (level.isClientSide()) return ItemInteractionResult.SUCCESS;
        level.destroyBlock(pos, true);

        Queue<BlockPos> posStack = new ArrayDeque<>();
        Set<BlockPos> explored = new HashSet<>();
        explored.add(pos);
        posStack.add(pos);

        while (!posStack.isEmpty()) {
            BlockPos blockPos = posStack.remove();
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = blockPos.offset(direction.getNormal());
                if (level.getBlockState(neighborPos).is(this) && !explored.contains(neighborPos)) {
                    explored.add(neighborPos);
                    posStack.add(neighborPos);
                    level.destroyBlock(neighborPos, true);
                }
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

    public enum KeyType {
        SMALL(DDTags.Items.UNLOCKS_SMALL_LOCK, DDTags.Items.UNLOCKS_LARGE_LOCK, Component.translatable(DeeperDarker.MOD_ID + ".key_type.too_large")),
        LARGE(DDTags.Items.UNLOCKS_LARGE_LOCK, DDTags.Items.UNLOCKS_SMALL_LOCK, Component.translatable(DeeperDarker.MOD_ID + ".key_type.too_small"));

        private final TagKey<Item> unlockItems;
        private final TagKey<Item> errorItems;
        private final Component errorMessage;

        KeyType(TagKey<Item> unlockItems, TagKey<Item> errorItems, Component errorMessage) {
            this.unlockItems = unlockItems;
            this.errorItems = errorItems;
            this.errorMessage = errorMessage;
        }

        public ItemInteractionResult use(@Nullable Player player, ItemStack stack) {
            if (stack.is(unlockItems)) return ItemInteractionResult.SUCCESS;
            if (stack.is(errorItems)) {
                if (player != null) player.displayClientMessage(errorMessage, true);
                return ItemInteractionResult.CONSUME;
            }
            return ItemInteractionResult.FAIL;
        }
    }
}
