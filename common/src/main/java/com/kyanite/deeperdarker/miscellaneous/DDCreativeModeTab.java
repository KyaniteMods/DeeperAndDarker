package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.platform.PlatformHelper;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class DDCreativeModeTab {
    public static final Supplier<CreativeModeTab> DD_TAB = PlatformHelper.registerCreativeModeTab("deeperdarker", () -> new ItemStack(DDItems.WARDEN_HELMET.get()));
}
