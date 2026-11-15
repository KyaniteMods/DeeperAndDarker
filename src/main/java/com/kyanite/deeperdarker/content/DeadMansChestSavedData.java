package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

import java.util.ArrayList;

public class DeadMansChestSavedData extends SavedData {
    public static final String ID = "deeperdarker_dead_mans_chest";
    private ArrayList<ItemStack> list = new ArrayList<>();

    public DeadMansChestSavedData() {
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag, HolderLookup.Provider provider) {
        ItemStack.CODEC.listOf().encodeStart(NbtOps.INSTANCE, list).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("stacks", tag));
        return compoundTag;
    }

    public static DeadMansChestSavedData load(CompoundTag compoundTag, HolderLookup.Provider provider) {
        DeadMansChestSavedData data = new DeadMansChestSavedData();
        data.list = ItemStack.CODEC.listOf().xmap(ArrayList::new, list -> list).parse(NbtOps.INSTANCE, compoundTag.get("stacks")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(new ArrayList<>());
        return data;
    }

    public static SavedData.Factory<DeadMansChestSavedData> factory() {
        return new SavedData.Factory<>(() -> {
            throw new IllegalStateException("Should never create an empty map saved data");
        }, DeadMansChestSavedData::load, null);
    }

    public ArrayList<ItemStack> getList() {
        return list;
    }

    public void add(ItemStack stack) {
        if (!stack.isStackable()) {
            list.add(stack);
            return;
        }
        for (ItemStack stack1 : list) {
            if (!stack1.isEmpty() && ItemStack.isSameItemSameComponents(stack, stack1)) {
                stack = ItemEntity.merge(stack, stack1, 64);
                if (stack.isEmpty()) return;
            }
        }
        if (!stack.isEmpty()) list.add(stack);
    }
}
