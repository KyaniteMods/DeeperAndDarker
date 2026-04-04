package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.ArrayList;

public class DeadMansChestSavedData extends SavedData {
    public static final String ID = "deeperdarker_dead_mans_chest";
    private ArrayList<ItemStack> list = new ArrayList<>();

    public DeadMansChestSavedData() {
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        ItemStack.CODEC.listOf().encodeStart(NbtOps.INSTANCE, list).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(tag -> compoundTag.put("stacks", tag));
        return compoundTag;
    }

    public static DeadMansChestSavedData load(CompoundTag compoundTag) {
        DeadMansChestSavedData data = new DeadMansChestSavedData();
        data.list = ItemStack.CODEC.listOf().xmap(ArrayList::new, list -> list).parse(NbtOps.INSTANCE, compoundTag.get("stacks")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(new ArrayList<>());
        return data;
    }

    public ArrayList<ItemStack> getList() {
        return list;
    }

    public void add(ItemStack stack) {
        list.add(stack);
    }
}
