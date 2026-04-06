package com.kyanite.deeperdarker.content.entities.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDCriteriaTriggers;
import com.kyanite.deeperdarker.content.DeadMansChestSavedData;
import com.kyanite.deeperdarker.content.blocks.Reinvokable;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DeadMansChestBlockEntity extends ChestBlockEntity {
    private boolean hasBeenOpened = true;

    public DeadMansChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public DeadMansChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(DDBlockEntities.DEAD_MANS_CHEST, blockPos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(DeeperDarker.MOD_ID + ".container.dead_mans_chest");
    }

    public boolean addDespawnedItems(@Nullable Player player) {
        if (!hasBeenOpened && getLevel().getServer() != null) {
            hasBeenOpened = true;

            DeadMansChestSavedData data = getLevel().getServer().overworld().getDataStorage().get(DeadMansChestSavedData::load, DeadMansChestSavedData.ID);
            if (data == null) return true;
            List<ItemStack> list = data.getList();
            list.removeIf(ItemStack::isEmpty);
            if (list.isEmpty()) {
                data.setDirty();
                return true;
            }

            if (player instanceof ServerPlayer) {
                DDCriteriaTriggers.OPEN_DEAD_MANS_CHEST.trigger((ServerPlayer)player);
            }

            ObjectArrayList<ItemStack> objectList = new ObjectArrayList<>(list);
            Util.shuffle(objectList, getLevel().getRandom());
            int items = Math.min(getReinvokedItemAmount(getLevel().getRandom()), list.size());
            List<Integer> availableSlots = getAvailableSlots(this, getLevel().getRandom());
            for (int i = 0; i < items; i++) {
                ItemStack stack = objectList.get(i);
                ((Reinvokable) (Object) stack).deeperdarker$setReinvoked(true);
                setItem(availableSlots.get(i), stack);
                list.remove(stack);
            }
            data.setDirty();
            return true;
        }
        return false;
    }

    protected int getReinvokedItemAmount(RandomSource random) {
        int min = getContainerSize() / 2;
        int max = Mth.ceil(getContainerSize() * (5.0f / 6.0f));
        return random.nextIntBetweenInclusive(min, max);
    }

    private List<Integer> getAvailableSlots(Container container, RandomSource randomSource) {
        ObjectArrayList<Integer> objectArrayList = new ObjectArrayList<>();
        for (int i = 0; i < container.getContainerSize(); ++i) {
            if (!container.getItem(i).isEmpty()) continue;
            objectArrayList.add(i);
        }
        Util.shuffle(objectArrayList, randomSource);
        return objectArrayList;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putBoolean("has_been_opened", hasBeenOpened);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        hasBeenOpened = compoundTag.getBoolean("has_been_opened");
    }

    @Override
    public void unpackLootTable(@Nullable Player player) {
        addDespawnedItems(player);
        super.unpackLootTable(player);
    }
}
