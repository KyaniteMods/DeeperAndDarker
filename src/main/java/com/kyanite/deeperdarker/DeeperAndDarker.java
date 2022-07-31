package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.rendering.entity.renderer.SculkWormRenderer;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.world.biomes.DDBiomes;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import com.kyanite.deeperdarker.util.DDPoiTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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

        GeckoLib.initialize();

        // Features
        DDConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        DDPlacedFeatures.PLACED_FEATURES.register(eventBus);

        DDEntities.ENTITY_TYPES.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDBiomes.BIOMES.register(eventBus);
        DDPoiTypes.POI.register(eventBus);

        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(DDEntities.SCULK_WORM.get(), SculkWormRenderer::new);
    }
}