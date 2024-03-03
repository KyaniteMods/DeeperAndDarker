package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.TntMinecartRenderer;
import net.minecraft.client.renderer.entity.TntRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.ItemStack;

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
                DDBlocks.POTTED_ECHO_SAPLING,
                DDBlocks.BIOSCULK_DOOR,
                DDBlocks.BIOSCULK_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                DDBlocks.CRYSTALLIZED_AMBER,
                DDBlocks.AMBER_GLASS);

        BlockEntityRenderers.register(DDBlockEntities.HANGING_SIGN, HangingSignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.SIGN, SignRenderer::new);

        DeeperDarker.LOGGER.info("Registering models");
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.WARDEN_HELMET, HelmetHornsModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BIOSCULK_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BIOSCULK_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_SNAPPER, SculkSnapperModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHATTERED, ShatteredModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_LEECH, SculkLeechModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHRIEK_WORM, ShriekWormModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.STALKER, StalkerModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_CENTIPEDE, SculkCentipedeModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.HONEYBOUND_TOTEM, HoneyboundTotemModel::createBodyModel);

        EntityRendererRegistry.register(DDEntities.BOAT, (ctx) -> new DDBoatRenderer(ctx, false));
        EntityRendererRegistry.register(DDEntities.CHEST_BOAT, (ctx) -> new DDBoatRenderer(ctx, true));
        EntityRendererRegistry.register(DDEntities.SCULK_SNAPPER, SculkSnapperRenderer::new);
        EntityRendererRegistry.register(DDEntities.SHATTERED, ShatteredRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_LEECH, SculkLeechRenderer::new);
        EntityRendererRegistry.register(DDEntities.SHRIEK_WORM, ShriekWormRenderer::new);
        EntityRendererRegistry.register(DDEntities.STALKER, StalkerRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_CENTIPEDE, SculkCentipedeRenderer::new);
        EntityRendererRegistry.register(DDEntities.HONEYBOUND_TOTEM, HoneyboundTotemRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_TNT, (ctx) -> new TntRenderer(ctx) {
            @Override
            public void render(PrimedTnt primedTnt, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
                poseStack.pushPose();
                poseStack.translate(0.0f, 0.5f, 0.0f);
                int j = primedTnt.getFuse();
                if ((float)j - g + 1.0f < 10.0f) {
                    float h = 1.0f - ((float)j - g + 1.0f) / 10.0f;
                    h = Mth.clamp(h, 0.0f, 1.0f);
                    h *= h;
                    h *= h;
                    float k = 1.0f + h * 0.3f;
                    poseStack.scale(k, k, k);
                }
                poseStack.mulPose(Axis.YP.rotationDegrees(-90.0f));
                poseStack.translate(-0.5f, -0.5f, 0.5f);
                poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                TntMinecartRenderer.renderWhiteSolidBlock(this.blockRenderer, DDBlocks.SCULK_TNT.defaultBlockState(), poseStack, multiBufferSource, i, j / 5 % 2 == 0);
                poseStack.popPose();
            }
        });

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

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            ResourceLocation texture = new ResourceLocation(DeeperDarker.MOD_ID, "textures/gui/soul_elytra_overlay_large.png");

            Minecraft client = Minecraft.getInstance();
            if (client.player == null) return;
            ItemStack itemStack = client.player.getItemBySlot(EquipmentSlot.CHEST);
            if (itemStack.is(DDItems.SOUL_ELYTRA)) {
                float f = client.player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA, Minecraft.getInstance().getFrameTime());
                drawContext.blit(texture, 5, client.getWindow().getGuiScaledHeight() - 37, 0, 0, 0, 12, Mth.floor(32 * f), 32, 32);
                drawContext.blit(texture, 5, client.getWindow().getGuiScaledHeight() - 37 + Mth.floor(32 * f), 0, 12, Mth.floor(32 * f), 12, Mth.ceil(32 * (1.0f - f)), 32, 32);
                if (f == 0.0f && client.player.isFallFlying()) {
                    for (BlockPos blockPos : BlockPos.betweenClosed(client.player.getOnPos(), client.player.getOnPos().below(5))) {
                        if (client.player.level().getBlockState(blockPos).isAir()) continue;
                        drawContext.drawString(client.font, Component.translatable(DDItems.SOUL_ELYTRA.getDescriptionId() + ".boost", client.options.keyShift.getTranslatedKeyMessage()).setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)), 20, client.getWindow().getGuiScaledHeight() - 37, 0);
                    }
                }
            }
        });
    }
}