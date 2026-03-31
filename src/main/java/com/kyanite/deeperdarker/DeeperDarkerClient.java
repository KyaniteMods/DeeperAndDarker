package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.compat.create.DDCreateCompatClient;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.UseTransmitterPacket;
import com.kyanite.deeperdarker.world.otherside.OthersideEffects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.particle.DripParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.SoulParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;

public class DeeperDarkerClient implements ClientModInitializer {
    public static final ModelResourceLocation KEYBRAND_MODEL = new ModelResourceLocation(DeeperDarker.MOD_ID, "keybrand", "inventory");
    public static final ModelResourceLocation KEYBRAND_IN_HAND_MODEL = new ModelResourceLocation(DeeperDarker.MOD_ID, "keybrand_in_hand", "inventory");
    public static final ResourceLocation ACID_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "block/acid_still");
    public static final ResourceLocation FLOWING_ACID_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "block/acid_flow");

    @Override
    public void onInitializeClient() {
        DDModelLayers.init();
        Keybinds.init();
        FluidRenderHandlerRegistry.INSTANCE.register(DDFluids.ACID, DDFluids.FLOWING_ACID, new SimpleFluidRenderHandler(ACID_TEXTURE, FLOWING_ACID_TEXTURE));

        DimensionRenderingRegistry.registerDimensionEffects(new ResourceLocation(DeeperDarker.MOD_ID, "otherside_effects"), new OthersideEffects());

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                DDBlocks.ECHO_DOOR,
                DDBlocks.ECHO_TRAPDOOR,
                DDBlocks.ECHO_SAPLING,
                DDBlocks.SCULK_SPRUCE_DOOR,
                DDBlocks.SCULK_SPRUCE_TRAPDOOR,
                DDBlocks.SCULK_SPRUCE_SAPLING,
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
                DDBlocks.ICE_LILY,
                DDBlocks.LILY_FLOWER,
                DDBlocks.SCULK_TUBERS,
                DDBlocks.ICICLE,
                DDBlocks.SCULK_FIRE,
                DDBlocks.SCULK_TORCH,
                DDBlocks.SCULK_WALL_TORCH,
                DDBlocks.SCULK_CAMPFIRE,
                DDBlocks.SCULK_LANTERN,
                DDBlocks.PATIENCE_SOUL_FIRE,
                DDBlocks.FORTITUDE_SOUL_FIRE);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                DDBlocks.CRYSTALLIZED_AMBER,
                DDBlocks.SOUNDPROOF_GLASS,
                DDBlocks.GLOOMSLATE_BARRIER,
                DDBlocks.PROTECTED_SCULK_GRIME_GLASS,
                DDBlocks.SCULK_GRIME_GLASS,
                DDBlocks.SCULK_GRIME_GLASS_PANE);

        BlockEntityRenderers.register(DDBlockEntities.HANGING_SIGN, HangingSignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.SIGN, SignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.CRYSTALLIZED_AMBER, CrystallizedAmberBlockRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.SKULL, SkullBlockRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.DARK_FOUNTAIN, DarkFountainBlockRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.CAMPFIRE, CampfireRenderer::new);

        if (FabricLoader.getInstance().isModLoaded("create") && DeeperDarker.CONFIG.server.createCompatibility()) {
            DDCreateCompatClient.init();
        }

        DeeperDarker.LOGGER.info("Registering models");
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.WARDEN_HELMET, HelmetHornsModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ECHO_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BLOOM_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BLOOM_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_SPRUCE_BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_SPRUCE_CHEST_BOAT, ChestBoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ANGLER_FISH, AnglerFishModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_SNAPPER, SculkSnapperModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHATTERED, ShatteredModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_LEECH, SculkLeechModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHRIEK_WORM, ShriekWormModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.STALKER, StalkerModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SLUDGE, SludgeModel::createInnerBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SLUDGE_OUTER, SludgeModel::createOuterBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SCULK_CENTIPEDE, SculkCentipedeModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.BLOOMING_GOLEM, BloomingGolemModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.POTTY, PottyModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.POT, PotModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.POTTER, PotterModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.OVERCAST_VESSEL, OvercastVesselModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.ACID_SPRITE, AcidSpriteModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SHATTERED_HEAD, ShatteredHeadModel::createHeadModel);
        EntityModelLayerRegistry.registerModelLayer(DDModelLayers.SUNGLASSES, SunglassesModel::createModel);

        EntityRendererRegistry.register(DDEntities.BOAT, (ctx) -> new DDBoatRenderer<>(ctx, false));
        EntityRendererRegistry.register(DDEntities.CHEST_BOAT, (ctx) -> new DDBoatRenderer<>(ctx, true));
        EntityRendererRegistry.register(DDEntities.ICICLE_SHARD, IcicleShardRenderer::new);
        EntityRendererRegistry.register(DDEntities.OVERCAST_VESSEL_ITEM, OvercastVesselItemRenderer::new);
        EntityRendererRegistry.register(DDEntities.ANGLER_FISH, AnglerFishRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_SNAPPER, SculkSnapperRenderer::new);
        EntityRendererRegistry.register(DDEntities.SHATTERED, ShatteredRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_LEECH, SculkLeechRenderer::new);
        EntityRendererRegistry.register(DDEntities.SHRIEK_WORM, ShriekWormRenderer::new);
        EntityRendererRegistry.register(DDEntities.STALKER, StalkerRenderer::new);
        EntityRendererRegistry.register(DDEntities.SLUDGE, SludgeRenderer::new);
        EntityRendererRegistry.register(DDEntities.SCULK_CENTIPEDE, SculkCentipedeRenderer::new);
        EntityRendererRegistry.register(DDEntities.BLOOMING_GOLEM, BloomingGolemRenderer::new);
        EntityRendererRegistry.register(DDEntities.POTTY, PottyRenderer::new);
        EntityRendererRegistry.register(DDEntities.POT, PotRenderer::new);
        EntityRendererRegistry.register(DDEntities.POTTER, PotterRenderer::new);
        EntityRendererRegistry.register(DDEntities.OVERCAST_VESSEL, OvercastVesselRenderer::new);
        EntityRendererRegistry.register(DDEntities.ACID_SPRITE, AcidSpriteRenderer::new);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer.getModel() instanceof HumanoidModel) {
                registrationHelper.register(new HelmetHornRenderer<>(entityRenderer, context.getModelSet()));
                registrationHelper.register(new SoulElytraRenderer<>(entityRenderer, context.getModelSet()));
                registrationHelper.register(new SunglassesRenderer<>(entityRenderer, context.getModelSet()));
            }
        });

        ItemProperties.register(DDItems.SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
            SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.WHITE_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.ORANGE_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.MAGENTA_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.LIGHT_BLUE_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.YELLOW_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.LIME_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.PINK_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.GRAY_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.LIGHT_GRAY_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.CYAN_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.PURPLE_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.BLUE_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.BROWN_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.GREEN_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.RED_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.BLACK_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );
        ItemProperties.register(DDItems.SUPER_SCULK_TRANSMITTER, new ResourceLocation(DeeperDarker.MOD_ID, "linked"), (itemStack, worldClient, livingEntity, i) ->
                SculkTransmitterItem.isLinked(itemStack) ? 1 : 0
        );

        ItemProperties.register(DDItems.SOUL_ELYTRA, new ResourceLocation("broken"), (itemStack, worldClient, livingEntity, i) ->
            SoulElytraItem.isFlyEnabled(itemStack) ? 0 : 1
        );

        ItemProperties.register(DDItems.SONOROUS_STAFF, new ResourceLocation(DeeperDarker.MOD_ID, "charge"), (itemStack, worldClient, livingEntity, i) ->
            livingEntity != null && livingEntity.getUseItem() == itemStack ? (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 128.0f : 0
        );

        ClientTickEvents.START_WORLD_TICK.register(world -> {
            Minecraft client = Minecraft.getInstance();
            if (client.player == null) return;
            ItemStack itemStack = client.player.getItemBySlot(EquipmentSlot.CHEST);
            if (itemStack.is(DDItems.SOUL_ELYTRA) && client.player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA, 0.0f) == 0 && client.player.isFallFlying() && Keybinds.BOOST.isDown()) {
                ClientPlayNetworking.send(new SoulElytraBoostPacket(PacketByteBufs.empty()));
            }
        });

        ClientTickEvents.START_WORLD_TICK.register(world -> {
            Minecraft client = Minecraft.getInstance();
            if (client.player == null) return;
            if (client.player.getInventory().hasAnyMatching(stack -> stack.getItem() instanceof SculkTransmitterItem) && Keybinds.TRANSMIT.isDown()) {
                ClientPlayNetworking.send(new UseTransmitterPacket(PacketByteBufs.empty()));
            }
        });

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            Minecraft client = Minecraft.getInstance();
            if (client.player == null || DeeperDarker.CONFIG.server.soulElytraCooldown() == -1) return;
            if (client.options.hideGui || client.gameMode == null || client.gameMode.getPlayerMode() == GameType.SPECTATOR) {
                return;
            }

            ResourceLocation texture = new ResourceLocation(DeeperDarker.MOD_ID, "textures/gui/soul_elytra_overlay_large.png");

            ItemStack chest = client.player.getItemBySlot(EquipmentSlot.CHEST);
            if (chest.is(DDItems.SOUL_ELYTRA)) {
                float f = client.player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA, Minecraft.getInstance().getFrameTime());
                drawContext.blit(texture, 5, client.getWindow().getGuiScaledHeight() - 37, 0, 0, 0, 12, Mth.floor(32 * f), 32, 32);
                drawContext.blit(texture, 5, client.getWindow().getGuiScaledHeight() - 37 + Mth.floor(32 * f), 0, 12, Mth.floor(32 * f), 12, Mth.ceil(32 * (1.0f - f)), 32, 32);
                if (f == 0.0f && client.player.isFallFlying()) {
                    for (BlockPos blockPos : BlockPos.betweenClosed(client.player.getOnPos(), client.player.getOnPos().below(5))) {
                        if (client.player.level().getBlockState(blockPos).isAir()) continue;
                        drawContext.drawString(client.font, Component.translatable(DDItems.SOUL_ELYTRA.getDescriptionId() + ".boost", Keybinds.BOOST.getTranslatedKeyMessage()).setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)), 20, client.getWindow().getGuiScaledHeight() - 37, 0);
                    }
                }
            }
        });
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(entity -> !entity.getItemBySlot(EquipmentSlot.CHEST).is(DDItems.SOUL_ELYTRA));

        ParticleFactoryRegistry.getInstance().register(DDParticleTypes.SCULK_FIRE_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(DDParticleTypes.PATIENCE_SOUL, SoulParticle.EmissiveProvider::new);
        ParticleFactoryRegistry.getInstance().register(DDParticleTypes.FORTITUDE_SOUL, SoulParticle.EmissiveProvider::new);
        ParticleFactoryRegistry.getInstance().register(DDParticleTypes.DRIPPING_ACID, (particleOptions, clientLevel, x, y, z, g, h, i) -> {
            DripParticle.DripHangParticle dripParticle = new DripParticle.DripHangParticle(clientLevel, x, y, z, DDFluids.ACID, DDParticleTypes.FALLING_ACID);
            dripParticle.setColor(0.2f, 1.0f, 0.3f);
            return dripParticle;
        });
        ParticleFactoryRegistry.getInstance().register(DDParticleTypes.FALLING_ACID, (particleOptions, clientLevel, x, y, z, g, h, i) -> {
            DripParticle.FallAndLandParticle dripParticle = new DripParticle.FallAndLandParticle(clientLevel, x, y, z, DDFluids.ACID, DDParticleTypes.LANDING_ACID);
            dripParticle.setColor(0.2f, 0.3f, 1.0f);
            return dripParticle;
        });
        ParticleFactoryRegistry.getInstance().register(DDParticleTypes.LANDING_ACID, (particleOptions, clientLevel, x, y, z, g, h, i) -> {
            DripParticle dripParticle = new DripParticle.DripLandParticle(clientLevel, x, y, z, DDFluids.ACID);
            dripParticle.setColor(0.2f, 0.3f, 1.0f);
            return dripParticle;
        });
    }
}