package com.nitro.deeperdarker.util;

import com.nitro.deeperdarker.registry.items.DDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DDCreativeTab {
    public static final CreativeModeTab DEEPER_DARKER = new CreativeModeTab("deeperdarker") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDItems.WARDEN_CARAPACE.get());
        }
    };
}
