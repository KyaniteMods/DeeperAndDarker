package com.kyanite.deeperdarker.datagen.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class NameUtility {
    public static String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(DeeperDarker.MODID + ":", "");
    }
}
