package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.blocks.entity.DeeperDarkerBlockEntityTypes;
import com.kyanite.deeperdarker.client.entity.feature.SoulElytraFeatureRenderer;
import com.kyanite.deeperdarker.client.entity.feature.WardenHelmetHornsFeatureRenderer;
import com.kyanite.deeperdarker.client.entity.model.*;
import com.kyanite.deeperdarker.client.entity.render.*;
import com.kyanite.deeperdarker.entities.DeeperDarkerEntityTypes;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.kyanite.deeperdarker.items.SoulElytraItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.minecraft.util.Identifier;

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
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperDarkerBlocks.CRYSTALLIZED_AMBER, RenderLayer.getTranslucent());

        BlockEntityRendererFactories.register(DeeperDarkerBlockEntityTypes.HANGING_SIGN, HangingSignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(DeeperDarkerBlockEntityTypes.SIGN, SignBlockEntityRenderer::new);

        EntityRendererRegistry.register(DeeperDarkerEntityTypes.BOAT, (ctx) -> new DeeperDarkerBoatEntityRenderer(ctx, false));
        EntityRendererRegistry.register(DeeperDarkerEntityTypes.CHEST_BOAT, (ctx) -> new DeeperDarkerBoatEntityRenderer(ctx, true));
        EntityRendererRegistry.register(DeeperDarkerEntityTypes.SCULK_SNAPPER, SculkSnapperEntityRenderer::new);
        EntityRendererRegistry.register(DeeperDarkerEntityTypes.SHATTERED, ShatteredEntityRenderer::new);
        EntityRendererRegistry.register(DeeperDarkerEntityTypes.SCULK_LEECH, SculkLeechEntityRenderer::new);
        EntityRendererRegistry.register(DeeperDarkerEntityTypes.SHRIEK_WORM, ShriekWormEntityRenderer::new);
        EntityRendererRegistry.register(DeeperDarkerEntityTypes.STALKER, StalkerEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.WARDEN_HELMET, WardenHelmetHornsModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.ECHO_BOAT, BoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.ECHO_CHEST_BOAT, ChestBoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.SCULK_SNAPPER, SculkSnapperEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.SHATTERED, ShatteredEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.SCULK_LEECH, SculkLeechEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.SHRIEK_WORM, ShriekWormEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DeeperDarkerModelLayers.STALKER, StalkerEntityModel::getTexturedModelData);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer.getModel() instanceof BipedEntityModel) {
                registrationHelper.register(new WardenHelmetHornsFeatureRenderer(entityRenderer, context.getModelLoader()));
                registrationHelper.register(new SoulElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
            }
        });

        ModelPredicateProviderRegistry.register(DeeperDarkerItems.SCULK_TRANSMITTER, new Identifier(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
            itemStack.hasNbt() && itemStack.getNbt().getBoolean("linked") ? 1 : 0
        );

        ModelPredicateProviderRegistry.register(DeeperDarkerItems.SOUL_ELYTRA, new Identifier("broken"), (itemStack, worldClient, livingEntity, i) ->
            SoulElytraItem.isUsable(itemStack) ? 0 : 1
        );
    }
}