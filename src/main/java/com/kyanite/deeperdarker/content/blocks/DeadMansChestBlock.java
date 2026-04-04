package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.entities.blocks.DeadMansChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;

public class DeadMansChestBlock extends ChestBlock {
    private static final DoubleBlockCombiner.Combiner<DeadMansChestBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<>() {

        @Override
        public Optional<MenuProvider> acceptDouble(final DeadMansChestBlockEntity chestBlockEntity, final DeadMansChestBlockEntity chestBlockEntity2) {
            final CompoundContainer container = new CompoundContainer(chestBlockEntity, chestBlockEntity2);
            return Optional.of(new MenuProvider() {

                @Override
                @Nullable
                public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
                    if (chestBlockEntity.canOpen(player) && chestBlockEntity2.canOpen(player)) {
                        chestBlockEntity.unpackLootTable(inventory.player);
                        chestBlockEntity2.unpackLootTable(inventory.player);
                        return ChestMenu.sixRows(i, inventory, container);
                    }
                    return null;
                }

                @Override
                public Component getDisplayName() {
                    if (chestBlockEntity.hasCustomName()) {
                        return chestBlockEntity.getDisplayName();
                    }
                    if (chestBlockEntity2.hasCustomName()) {
                        return chestBlockEntity2.getDisplayName();
                    }
                    return Component.translatable(DeeperDarker.MOD_ID + ".container.double_dead_mans_chest");
                }
            });
        }

        @Override
        public Optional<MenuProvider> acceptSingle(DeadMansChestBlockEntity chestBlockEntity) {
            return Optional.of(chestBlockEntity);
        }

        @Override
        public Optional<MenuProvider> acceptNone() {
            return Optional.empty();
        }
    };

    public DeadMansChestBlock(Properties properties) {
        super(properties, () -> DDBlockEntities.DEAD_MANS_CHEST);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DeadMansChestBlockEntity(blockPos, blockState);
    }

    @Override
    @Nullable
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return combine(blockState, level, blockPos, false).apply(MENU_PROVIDER_COMBINER).orElse(null);
    }

    @Override
    public DoubleBlockCombiner.NeighborCombineResult<DeadMansChestBlockEntity> combine(BlockState blockState, Level level, BlockPos blockPos2, boolean bl) {
        BiPredicate<LevelAccessor, BlockPos> biPredicate = bl ? (levelAccessor, blockPos) -> false : ChestBlock::isChestBlockedAt;
        return DoubleBlockCombiner.combineWithNeigbour((BlockEntityType<DeadMansChestBlockEntity>)this.blockEntityType.get(), ChestBlock::getBlockType, ChestBlock::getConnectedDirection, FACING, blockState, level, blockPos2, biPredicate);
    }
}