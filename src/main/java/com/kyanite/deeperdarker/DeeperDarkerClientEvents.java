package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.Keybinds;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.OthersidePortalOverlay;
import com.kyanite.deeperdarker.client.OthersideReceivingLevelScreen;
import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.data.TempleTracker;
import com.kyanite.deeperdarker.content.data.Transmitter;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.UseTransmitterPacket;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.item.CompassItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.sprite.AtlasManager;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.registries.DeferredItem;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = DeeperDarker.MOD_ID, value = Dist.CLIENT)
public class DeeperDarkerClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(DDBlocks.ECHO);
            Sheets.addWoodType(DDBlocks.BLOOM);

            ItemProperties.register(DDItems.ANCIENT_COMPASS.get(), ResourceLocation.withDefaultNamespace("angle"), new CompassItemPropertyFunction((level, stack, entity) -> {
                TempleTracker tracker = stack.get(DDDataComponents.TEMPLE_TRACKER);
                return tracker != null ? tracker.linkedPos().orElse(null) : null;
            }));
            ItemProperties.register(DDItems.SOUL_ELYTRA.get(), ResourceLocation.withDefaultNamespace("broken"), (stack, pLevel, pEntity, seed) -> SoulElytraItem.isFlyEnabled(stack) ? 0 : 1);
            registerTransmitterProperties(DDItems.SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.WHITE_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.ORANGE_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.MAGENTA_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.LIGHT_BLUE_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.YELLOW_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.LIME_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.PINK_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.GRAY_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.LIGHT_GRAY_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.CYAN_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.PURPLE_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.BLUE_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.BROWN_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.GREEN_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.RED_SCULK_TRANSMITTER);
            registerTransmitterProperties(DDItems.BLACK_SCULK_TRANSMITTER);
            ItemProperties.register(DDItems.SONOROUS_STAFF.get(), DeeperDarker.rl("charge"), (stack, level, entity, seed) -> entity != null && entity.getUseItem() == stack ? (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 128f : 0);
        });
    }

    private static void registerTransmitterProperties(DeferredItem<Item> item) {
        ItemProperties.register(item.get(), DeeperDarker.rl("linked"), (stack, level, entity, seed) -> SculkTransmitterItem.isLinked(stack) ? 1 : 0);
    }

    @SubscribeEvent
    public static void registerTextureAtlases(final RegisterTextureAtlasesEvent event) {
        event.register(new AtlasManager.AtlasConfig(GloomslatePotRenderer.GLOOMSLATE_POT_ATLAS, DeeperDarker.rl("gloomslate_pot"), false));
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
    public static void registerGuiLayers(final RegisterGuiLayersEvent event) {
        event.registerAboveAll(DeeperDarker.rl("otherside_portal"), new OthersidePortalOverlay());
    }

    @SubscribeEvent
    public static void registerKeybinds(final RegisterKeyMappingsEvent event) {
        event.register(Keybinds.BOOST);
        event.register(Keybinds.TRANSMIT);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), StandingSignRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntities.CRYSTALLIZED_AMBER.get(), CrystallizedAmberBlockRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntities.GLOOMSLATE_POT.get(), GloomslatePotRenderer::new);

        event.registerEntityRenderer(DDEntities.ECHO_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.ECHO_BOAT));
        event.registerEntityRenderer(DDEntities.ECHO_CHEST_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.ECHO_CHEST_BOAT));
        event.registerEntityRenderer(DDEntities.BLOOM_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.BLOOM_BOAT));
        event.registerEntityRenderer(DDEntities.BLOOM_CHEST_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.BLOOM_CHEST_BOAT));
        event.registerEntityRenderer(DDEntities.ANGLER_FISH.get(), AnglerFishRenderer::new);
        event.registerEntityRenderer(DDEntities.ANGER_POT.get(), AngerPotRenderer::new);
        event.registerEntityRenderer(DDEntities.FEAR_POT.get(), FearPotRenderer::new);
        event.registerEntityRenderer(DDEntities.SORROW_POT.get(), SorrowPotRenderer::new);
        event.registerEntityRenderer(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipedeRenderer::new);
        event.registerEntityRenderer(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
        event.registerEntityRenderer(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
        event.registerEntityRenderer(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
        event.registerEntityRenderer(DDEntities.SHRIEK_WORM.get(), ShriekWormRenderer::new);
        event.registerEntityRenderer(DDEntities.SLUDGE.get(), SludgeRenderer::new);
        event.registerEntityRenderer(DDEntities.STALKER.get(), StalkerRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.GLOOMSLATE_POT_BASE, GloomslatePotModel::createBaseLayer);
        event.registerLayerDefinition(ModModelLayers.GLOOMSLATE_POT_SIDES, GloomslatePotModel::createSidesLayer);

        event.registerLayerDefinition(ModModelLayers.ECHO_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.ECHO_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayers.BLOOM_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.BLOOM_CHEST_BOAT, BoatModel::createChestBoatModel);

        event.registerLayerDefinition(AnglerFishRenderer.MODEL, AnglerFishModel::createModel);
        event.registerLayerDefinition(ModModelLayers.ANGER_POT, AngerPotModel::createModel);
        event.registerLayerDefinition(ModModelLayers.FEAR_POT, FearPotModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SORROW_POT, SorrowPotModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SCULK_CENTIPEDE, SculkCentipedeModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SCULK_LEECH, SculkLeechModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SCULK_SNAPPER, SculkSnapperModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SHATTERED, ShatteredModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SHRIEK_WORM, ShriekWormModel::createModel);
        event.registerLayerDefinition(ModModelLayers.SLUDGE, SludgeModel::createInnerModel);
        event.registerLayerDefinition(ModModelLayers.SLUDGE_OUTER, SludgeModel::createOuterModel);
        event.registerLayerDefinition(ModModelLayers.STALKER, StalkerModel::createModel);
        event.registerLayerDefinition(ModModelLayers.WARDEN_HELMET, WardenHelmetModel::createModel);
    }

    @SubscribeEvent
    public static void addLayers(final EntityRenderersEvent.AddLayers event) {
        EntityRendererProvider.Context context = event.getContext();
        event.getSkins().forEach(name -> {
            if(event.getPlayerRenderer(name) instanceof AvatarRenderer<AbstractClientPlayer> renderer) {
                renderer.addLayer(new SoulElytraRenderer<>(renderer, context.getModelSet(), context.getEquipmentRenderer()));
                renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
            }
        });
        if(event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
            renderer.addLayer(new SoulElytraRenderer<>(renderer, context.getModelSet(), context.getEquipmentRenderer()));
            renderer.addLayer(new WardenHelmetRenderer<>(renderer, event.getEntityModels()));
        }
    }

    @SubscribeEvent
    public static void itemTooltipEvent(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if(stack.is(DDBlocks.CRYSTALLIZED_AMBER.asItem())) {
            if(stack.has(DataComponents.BLOCK_ENTITY_DATA)) {
                CompoundTag tag = stack.getOrDefault(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY);
                if(tag.contains("BlockEntityTag")) {
                    tag = tag.getCompoundOrEmpty("BlockEntityTag");
                }
                if(tag.contains("leech") && tag.getBoolean("leech")) {
                    event.getToolTip().add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.leech").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
                }
                else if(tag.contains("item")) {
                    event.getToolTip().add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.item", ItemStack.parseOptional(context.registries(), tag.getCompound("item")).getHoverName()).withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
                }
            }
        }

        if(SculkTransmitterItem.isLinked(stack)) {
            Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
            assert transmitter != null;
            transmitter.addToTooltip(event.getContext(), event.getToolTip()::add, event.getFlags(), stack.getComponents());
        }
    }

    @SubscribeEvent
    public static void keyInput(final InputEvent.Key event) {
        if(Keybinds.BOOST.consumeClick()) ClientPacketDistributor.sendToServer(new SoulElytraBoostPacket(true));
        else if(Keybinds.TRANSMIT.consumeClick()) ClientPacketDistributor.sendToServer(new UseTransmitterPacket(true));
    }
}
