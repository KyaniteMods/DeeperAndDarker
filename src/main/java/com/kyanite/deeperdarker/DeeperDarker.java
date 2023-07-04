package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.registries.DDBlockEntities;
import com.kyanite.deeperdarker.registries.DDBlocks;
import com.kyanite.deeperdarker.registries.DDEntities;
import com.kyanite.deeperdarker.registries.DDItems;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.render.DDBoatRenderer;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(DDCreativeTab::buildCreativeTab);
        eventBus.addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> Sheets.addWoodType(DDBlocks.ECHO));

        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
        EntityRenderers.register(DDEntities.DEEPER_DARKER_BOAT.get(), (context) -> new DDBoatRenderer(context, false));
        EntityRenderers.register(DDEntities.DEEPER_DARKER_CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
    }
}
