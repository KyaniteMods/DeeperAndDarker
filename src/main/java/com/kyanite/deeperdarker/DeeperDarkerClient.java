package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class DeeperDarkerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DDModelLayers.init();
        Keybinds.init();
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                DDBlocks.ECHO_DOOR,
                DDBlocks.ECHO_TRAPDOOR,
                DDBlocks.ECHO_SAPLING,
                DDBlocks.SCULK_TENDRILS_PLANT,
                DDBlocks.SCULK_TENDRILS,
                DDBlocks.SCULK_VINES_PLANT,
                DDBlocks.SCULK_VINES,
                DDBlocks.GLOWING_ROOTS_PLANT,
                DDBlocks.GLOWING_ROOTS,
                DDBlocks.GLOWING_VINES_PLANT,
                DDBlocks.GLOWING_VINES,
                DDBlocks.GLOOMY_CACTUS,
                DDBlocks.GLOOMY_GRASS,
                DDBlocks.POTTED_ECHO_SAPLING,
                DDBlocks.GLOWING_FLOWERS,
                DDBlocks.GLOWING_GRASS,
                DDBlocks.ICE_LILY);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                DDBlocks.CRYSTALLIZED_AMBER,
                DDBlocks.SOUNDPROOF_GLASS);

        BlockEntityRenderers.register(DDBlockEntities.HANGING_SIGN, HangingSignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.SIGN, SignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.CRYSTALLIZED_AMBER, CrystallizedAmberBlockRenderer::new);

        DeeperDarker.LOGGER.info("Registering models");
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.WARDEN_HELMET, HelmetHornsModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BLOOM_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BLOOM_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ANGLER_FISH, AnglerFishModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_SNAPPER, SculkSnapperModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHATTERED, ShatteredModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_LEECH, SculkLeechModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHRIEK_WORM, ShriekWormModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.STALKER, StalkerModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_CENTIPEDE, SculkCentipedeModel::createBodyModel);

        EntityRendererRegistry.register(DDEntities.BOAT, (ctx) -> new DDBoatRenderer(ctx, false));
        EntityRendererRegistry.register(DDEntities.CHEST_BOAT, (ctx) -> new DDBoatRenderer(ctx, true));
        EntityRendererRegistry.register(DDEntities.ANGLER_FISH, AnglerFishRenderer::new);
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

        ItemProperties.register(DDItems.SCULK_TRANSMITTER, DeeperDarker.id("linked"), (itemStack, worldClient, livingEntity, i) ->
            SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );

        ItemProperties.register(DDItems.SOUL_ELYTRA, ResourceLocation.withDefaultNamespace("broken"), (itemStack, worldClient, livingEntity, i) ->
            SoulElytraItem.isFlyEnabled(itemStack) ? 0 : 1
        );

        ItemProperties.register(DDItems.SONOROUS_STAFF, DeeperDarker.id("charge"), (itemStack, worldClient, livingEntity, i) ->
            livingEntity != null && livingEntity.getUseItem() == itemStack ? (itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 123.0f : 0
        );

        // TODO: fix packets
//        ClientTickEvents.START_WORLD_TICK.register(world -> {
//            Minecraft client = Minecraft.getInstance();
//            if (client.player == null) return;
//            ItemStack itemStack = client.player.getItemBySlot(EquipmentSlot.CHEST);
//            if (itemStack.is(DDItems.SOUL_ELYTRA) && client.player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA, Minecraft.getInstance().getFrameTime()) == 0 && client.player.isFallFlying() && Keybinds.BOOST.isDown()) {
//                ClientPlayNetworking.send(new SoulElytraBoostPacket(PacketByteBufs.empty()));
//            }
//        });
//
//        ClientTickEvents.START_WORLD_TICK.register(world -> {
//            Minecraft client = Minecraft.getInstance();
//            if (client.player == null) return;
//            if (client.player.getInventory().hasAnyMatching(stack -> stack.is(DDItems.SCULK_TRANSMITTER)) && Keybinds.TRANSMIT.isDown()) {
//                ClientPlayNetworking.send(new UseTransmitterPacket(PacketByteBufs.empty()));
//            }
//        });
//
//        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
//            ResourceLocation texture = DeeperDarker.id("textures/gui/soul_elytra_overlay_large.png");
//
//            Minecraft client = Minecraft.getInstance();
//            if (client.player == null) return;
//            ItemStack itemStack = client.player.getItemBySlot(EquipmentSlot.CHEST);
//            if (itemStack.is(DDItems.SOUL_ELYTRA)) {
//                float f = client.player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA, Minecraft.getInstance().getFrameTime());
//                drawContext.blit(texture, 5, client.getWindow().getGuiScaledHeight() - 37, 0, 0, 0, 12, Mth.floor(32 * f), 32, 32);
//                drawContext.blit(texture, 5, client.getWindow().getGuiScaledHeight() - 37 + Mth.floor(32 * f), 0, 12, Mth.floor(32 * f), 12, Mth.ceil(32 * (1.0f - f)), 32, 32);
//                if (f == 0.0f && client.player.isFallFlying()) {
//                    for (BlockPos blockPos : BlockPos.betweenClosed(client.player.getOnPos(), client.player.getOnPos().below(5))) {
//                        if (client.player.level().getBlockState(blockPos).isAir()) continue;
//                        drawContext.drawString(client.font, Component.translatable(DDItems.SOUL_ELYTRA.getDescriptionId() + ".boost", Keybinds.BOOST.getTranslatedKeyMessage()).setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)), 20, client.getWindow().getGuiScaledHeight() - 37, 0);
//                    }
//                }
//            }
//        });
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(entity -> !entity.getItemBySlot(EquipmentSlot.CHEST).is(DDItems.SOUL_ELYTRA));
    }
}