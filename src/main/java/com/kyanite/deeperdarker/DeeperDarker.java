package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDItems.ITEMS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
