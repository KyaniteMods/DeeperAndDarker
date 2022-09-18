package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DDCreativeModeTab {
    public static final CreativeModeTab DD_TAB = RegistryHelper.registerCreativeModeTab(() -> new ItemStack(DDItems.WARDEN_HELMET.get()));
}
