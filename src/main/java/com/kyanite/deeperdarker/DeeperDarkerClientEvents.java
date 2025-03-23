package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.OthersideReceivingLevelScreen;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.UseTransmitterPacket;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.network.PacketDistributor;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = DeeperDarker.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeeperDarkerClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(DDBlocks.ECHO);
            Sheets.addWoodType(DDBlocks.BLOOM);
            ItemProperties.register(DDItems.SOUL_ELYTRA.get(), ResourceLocation.withDefaultNamespace("broken"), (pStack, pLevel, pEntity, pSeed) -> SoulElytraItem.isFlyEnabled(pStack) ? 0 : 1);
            ItemProperties.register(DDItems.SCULK_TRANSMITTER.get(), DeeperDarker.rl("linked"), (pStack, pLevel, pEntity, pSeed) -> SculkTransmitterItem.isLinked(pStack) ? 1 : 0);
            ItemProperties.register(DDItems.SONOROUS_STAFF.get(), DeeperDarker.rl("charge"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getUseItem() == pStack ? (pStack.getUseDuration(pEntity) - pEntity.getUseItemRemainingTicks()) / 128f : 0);
        });

        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
        EntityRenderers.register(DDEntities.BOAT.get(), (context) -> new DDBoatRenderer(context, false));
        EntityRenderers.register(DDEntities.CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
        EntityRenderers.register(DDEntities.ANGLER_FISH.get(), AnglerFishRenderer::new);
        EntityRenderers.register(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipedeRenderer::new);
        EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
        EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
        EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
        EntityRenderers.register(DDEntities.SHRIEK_WORM.get(), ShriekWormRenderer::new);
        EntityRenderers.register(DDEntities.SLUDGE.get(), SludgeRenderer::new);
        EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);
    }

    @SubscribeEvent
    public static void registerDimensionEffects(final RegisterDimensionSpecialEffectsEvent event) {
        event.register(OthersideDimension.OTHERSIDE_EFFECTS, new DimensionSpecialEffects.NetherEffects());
    }

    @SubscribeEvent
    public static void registerTransitionScreen(final RegisterDimensionTransitionScreenEvent event) {
        event.registerIncomingEffect(OthersideDimension.OTHERSIDE_LEVEL, OthersideReceivingLevelScreen::new);
        event.registerOutgoingEffect(OthersideDimension.OTHERSIDE_LEVEL, OthersideReceivingLevelScreen::new);
    }

    @SubscribeEvent
    public static void registerKeybinds(final RegisterKeyMappingsEvent event) {
        event.register(Keybinds.BOOST);
        event.register(Keybinds.TRANSMIT);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(DDBlockEntities.CRYSTALLIZED_AMBER.get(), CrystallizedAmberBlockRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DDBoatRenderer.ECHO_BOAT_MODEL, BoatModel::createBodyModel);
        event.registerLayerDefinition(DDBoatRenderer.ECHO_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(DDBoatRenderer.BLOOM_BOAT_MODEL, BoatModel::createBodyModel);
        event.registerLayerDefinition(DDBoatRenderer.BLOOM_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(AnglerFishRenderer.MODEL, AnglerFishModel::createBodyModel);
        event.registerLayerDefinition(SculkCentipedeRenderer.MODEL, SculkCentipedeModel::createBodyModel);
        event.registerLayerDefinition(SculkLeechRenderer.MODEL, SculkLeechModel::createBodyModel);
        event.registerLayerDefinition(SculkSnapperRenderer.MODEL, SculkSnapperModel::createBodyModel);
        event.registerLayerDefinition(ShatteredRenderer.MODEL, ShatteredModel::createBodyModel);
        event.registerLayerDefinition(ShriekWormRenderer.MODEL, ShriekWormModel::createBodyModel);
        event.registerLayerDefinition(SludgeRenderer.MODEL, SludgeModel::createInnerBodyModel);
        event.registerLayerDefinition(SludgeOuterLayer.OUTER_MODEL, SludgeModel::createOuterBodyModel);
        event.registerLayerDefinition(StalkerRenderer.MODEL, StalkerModel::createBodyModel);
        event.registerLayerDefinition(WardenHelmetRenderer.MODEL, WardenHelmetModel::createBodyModel);
    }

    @SubscribeEvent
    public static void addLayers(final EntityRenderersEvent.AddLayers event) {
        event.getSkins().forEach(name -> {
            if(event.getSkin(name) instanceof PlayerRenderer renderer) {
                renderer.addLayer(new SoulElytraRenderer<>(renderer, event.getEntityModels()));
                renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
            }
        });
        if(event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
            renderer.addLayer(new SoulElytraRenderer<>(renderer, event.getEntityModels()));
            renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
        }
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
    static class GameBus {
        @SubscribeEvent
        public static void keyInput(final InputEvent.Key event) {
            if(Keybinds.BOOST.consumeClick()) PacketDistributor.sendToServer(new SoulElytraBoostPacket(true));
            else if(Keybinds.TRANSMIT.consumeClick()) PacketDistributor.sendToServer(new UseTransmitterPacket(true));
        }
    }
}
