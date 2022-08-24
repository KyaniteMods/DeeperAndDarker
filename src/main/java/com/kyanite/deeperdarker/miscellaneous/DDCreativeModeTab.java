package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DDCreativeModeTab {
    public static final CreativeModeTab DD_TAB = new CreativeModeTab("deeperdarker") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDItems.HEART_OF_THE_DEEP.get());
        }
    };
}
