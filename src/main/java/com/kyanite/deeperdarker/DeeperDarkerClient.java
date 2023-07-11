package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerBlockEntityTypes;
import com.kyanite.deeperdarker.client.entity.feature.WardenHelmetHornsFeatureRenderer;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.WardenHelmetHornsModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class DeeperDarkerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                DeeperDarkerBlocks.ECHO_DOOR,
                DeeperDarkerBlocks.ECHO_TRAPDOOR,
                DeeperDarkerBlocks.ECHO_SAPLING,
                DeeperDarkerBlocks.SCULK_TENDRILS_PLANT,
                DeeperDarkerBlocks.SCULK_TENDRILS,
                DeeperDarkerBlocks.SCULK_VINES_PLANT,
                DeeperDarkerBlocks.SCULK_VINES,
                DeeperDarkerBlocks.GLOOMY_CACTUS,
                DeeperDarkerBlocks.GLOOMY_GRASS);
        BlockEntityRendererFactories.register(DeeperDarkerBlockEntityTypes.HANGING_SIGN, HangingSignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(DeeperDarkerBlockEntityTypes.SIGN, SignBlockEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.WARDEN_HELMET, WardenHelmetHornsModel::getTexturedModelData);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer.getModel() instanceof BipedEntityModel) {
                registrationHelper.register(new WardenHelmetHornsFeatureRenderer(entityRenderer, context.getModelLoader()));
            }
        });
    }
}