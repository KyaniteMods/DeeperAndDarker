package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DDCreativeTab {
    public static final CreativeModeTab DEEPER_DARKER = new CreativeModeTab(DeeperDarker.MOD_ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(DDBlocks.ECHO_LOG.get());
        }
    };
}
