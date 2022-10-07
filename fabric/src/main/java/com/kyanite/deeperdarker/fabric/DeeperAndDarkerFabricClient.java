package com.kyanite.deeperdarker.fabric;

import com.kyanite.deeperdarker.client.rendering.entity.*;
import com.kyanite.deeperdarker.fabric.client.ArmorRenderer;
import com.kyanite.deeperdarker.fabric.client.FabricBoatModels;
import com.kyanite.deeperdarker.fabric.client.WardenArmorRenderer;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class DeeperAndDarkerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.ECHO_DOOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.ECHO_TRAPDOOR.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_VINES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_VINES_PLANT.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_TENDRILS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.CRYSTALLIZED_AMBER.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.GLOOMY_GRASS.get(), RenderType.cutout());

        EntityRendererRegistry.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_WORM.get(), SculkWormRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_CENTIPEDE.get(), CentipedeRenderer::new);
        EntityRendererRegistry.register(DDEntities.STALKER.get(), StalkerRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCAVENGER.get(), ScavengerRenderer::new);

        FabricBoatModels.registerLayers();

        EntityRendererRegistry.register(DDEntities.BOAT.get(), context -> new DDBoatRenderer<>(context, false));
        EntityRendererRegistry.register(DDEntities.CHEST_BOAT.get(), context -> new DDBoatRenderer<>(context, true));

        ArmorRenderer.registerArmorRenderer(new WardenArmorRenderer(), DDItems.WARDEN_HELMET.get(),
                DDItems.WARDEN_CHESTPLATE.get(), DDItems.WARDEN_LEGGINGS.get(), DDItems.WARDEN_BOOTS.get());
    }
}