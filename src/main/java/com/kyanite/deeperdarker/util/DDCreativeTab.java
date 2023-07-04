package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.registries.DDBlocks;
import com.kyanite.deeperdarker.registries.DDItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeeperDarker.MOD_ID);
    public static final RegistryObject<CreativeModeTab> DEEPER_DARKER = CREATIVE_MODE_TABS.register("deeper_darker", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + DeeperDarker.MOD_ID)).icon(() -> new ItemStack(DDBlocks.ECHO_LOG.get())).build());

    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == DEEPER_DARKER.get()) {
            event.accept(DDBlocks.ECHO_LOG);
            event.accept(DDBlocks.ECHO_WOOD);
            event.accept(DDBlocks.STRIPPED_ECHO_LOG);
            event.accept(DDBlocks.STRIPPED_ECHO_WOOD);
            event.accept(DDBlocks.ECHO_PLANKS);
            event.accept(DDBlocks.ECHO_STAIRS);
            event.accept(DDBlocks.ECHO_SLAB);
            event.accept(DDBlocks.ECHO_FENCE);
            event.accept(DDBlocks.ECHO_FENCE_GATE);
            event.accept(DDBlocks.ECHO_DOOR);
            event.accept(DDBlocks.ECHO_TRAPDOOR);
            event.accept(DDBlocks.ECHO_PRESSURE_PLATE);
            event.accept(DDBlocks.ECHO_BUTTON);
            event.accept(DDBlocks.ECHO_LEAVES);
            event.accept(DDItems.ECHO_SIGN);
            event.accept(DDItems.ECHO_HANGING_SIGN);
            event.accept(DDItems.ECHO_BOAT);
            event.accept(DDItems.ECHO_CHEST_BOAT);
        }
    }
}
