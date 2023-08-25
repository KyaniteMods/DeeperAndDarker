package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class DeeperDarkerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DDModelLayers.init();
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                DDBlocks.ECHO_DOOR,
                DDBlocks.ECHO_TRAPDOOR,
                DDBlocks.ECHO_SAPLING,
                DDBlocks.SCULK_TENDRILS_PLANT,
                DDBlocks.SCULK_TENDRILS,
                DDBlocks.SCULK_VINES_PLANT,
                DDBlocks.SCULK_VINES,
                DDBlocks.GLOOMY_CACTUS,
                DDBlocks.GLOOMY_GRASS,
                DDBlocks.POTTED_ECHO_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlock(DDBlocks.CRYSTALLIZED_AMBER, RenderType.translucent());

        BlockEntityRenderers.register(DDBlockEntities.SIGN, SignRenderer::new);

        DeeperDarker.LOGGER.info("Registering models");
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.WARDEN_HELMET, HelmetHornsModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_BOAT, () -> BoatModel.createBodyModel(false));
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_CHEST_BOAT, () -> BoatModel.createBodyModel(true));
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_SNAPPER, SculkSnapperModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHATTERED, ShatteredModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_LEECH, SculkLeechModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHRIEK_WORM, ShriekWormModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.STALKER, StalkerModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_CENTIPEDE, SculkCentipedeModel::createBodyModel);

        EntityRendererRegistry.register(DDEntities.BOAT, (ctx) -> new DDBoatRenderer(ctx, false));
        EntityRendererRegistry.register(DDEntities.CHEST_BOAT, (ctx) -> new DDBoatRenderer(ctx, true));
        EntityRendererRegistry.register(DDEntities.SCULK_SNAPPER, SculkSnapperRenderer::new);
        EntityRendererRegistry.register(DDEntities.SHATTERED, ShatteredRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_LEECH, SculkLeechRenderer::new);
        EntityRendererRegistry.register(DDEntities.SHRIEK_WORM, ShriekWormRenderer::new);
        EntityRendererRegistry.register(DDEntities.STALKER, StalkerRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_CENTIPEDE, SculkCentipedeRenderer::new);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer.getModel() instanceof HumanoidModel) {
                registrationHelper.register(new HelmetHornRenderer<>(entityRenderer, context.getModelSet()));
                registrationHelper.register(new SoulElytraRenderer<>(entityRenderer, context.getModelSet()));
            }
        });

        ItemProperties.register(DDItems.SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
            itemStack.hasTag() && itemStack.getTag().getBoolean("linked") ? 1 : 0
        );

        ItemProperties.register(DDItems.SOUL_ELYTRA, new ResourceLocation("broken"), (itemStack, worldClient, livingEntity, i) ->
            SoulElytraItem.isFlyEnabled(itemStack) ? 0 : 1
        );
    }
}