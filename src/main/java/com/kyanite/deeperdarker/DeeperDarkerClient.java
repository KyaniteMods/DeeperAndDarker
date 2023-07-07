package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.entity.feature.WardenHelmetHornsFeatureRenderer;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.WardenHelmetHornsModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class DeeperDarkerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.WARDEN_HELMET, WardenHelmetHornsModel::getTexturedModelData);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer.getModel() instanceof BipedEntityModel) {
                registrationHelper.register(new WardenHelmetHornsFeatureRenderer(entityRenderer, context.getModelLoader()));
            }
        });
    }
}
