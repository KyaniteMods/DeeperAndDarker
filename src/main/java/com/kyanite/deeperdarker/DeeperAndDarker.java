package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.registry.world.biomes.DDBiomes;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.util.DDPoiTypes;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DeeperAndDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        DDFeatures.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDBiomes.BIOMES.register(eventBus);
        DDPoiTypes.POI.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}