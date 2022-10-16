package com.kyanite.deeperdarker.forge;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.entity.*;
import com.kyanite.deeperdarker.forge.client.SoulElytraItem;
import com.kyanite.deeperdarker.forge.client.elytra.SoulElytraArmorStandLayer;
import com.kyanite.deeperdarker.forge.client.elytra.SoulElytraLayer;
import com.kyanite.deeperdarker.forge.client.warden_armor.WardenArmorItem;
import com.kyanite.deeperdarker.forge.client.warden_armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.forge.world.DDPoiTypes;
import com.kyanite.deeperdarker.forge.world.biomes.DDBiomeModifiers;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.platform.forge.RegistryHelperImpl;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.HashMap;
import java.util.Map;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarkerForge {
    public DeeperAndDarkerForge() {
        DeeperAndDarker.init(() -> {
            GeckoLibMod.DISABLE_IN_DEV = true;
            GeckoLib.initialize();
        });

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistryHelperImpl.SOUND_EVENTS.register(bus);
        RegistryHelperImpl.ITEMS.register(bus);
        RegistryHelperImpl.BLOCKS.register(bus);
        RegistryHelperImpl.ENCHANTMENTS.register(bus);
        RegistryHelperImpl.MOB_EFFECTS.register(bus);
        RegistryHelperImpl.POTIONS.register(bus);
        RegistryHelperImpl.ENTITY_TYPES.register(bus);
        RegistryHelperImpl.FEATURES.register(bus);
        RegistryHelperImpl.CONFIGURED_FEATURES.register(bus);
        RegistryHelperImpl.PLACED_FEATURES.register(bus);
        RegistryHelperImpl.BIOMES.register(bus);
        DDBiomeModifiers.BIOME_MODIFIERS.register(bus);
        DDPoiTypes.POI.register(bus);

        bus.addListener(this::attributes);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void attributes(EntityAttributeCreationEvent event) {
        Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes = new HashMap<>();
        DeeperAndDarker.attributes(attributes);
        attributes.forEach((entity, builder) -> event.put(entity, builder.build()));
    }

    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class DeeperDarkerCommon {
        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDWoodTypes.ECHO);
                DeeperAndDarker.spawnPlacements();
            });

            ComposterBlock.COMPOSTABLES.put(DDBlocks.ECHO_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_GLEAM.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_VINES.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_TENDRILS.get().asItem(), 0.5f);

            PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        }
    }

    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            WoodType.register(DDWoodTypes.ECHO);
            EntityRenderers.register(DDEntities.SCULK_CENTIPEDE.get(), CentipedeRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_WORM.get(), SculkWormRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);

            ItemProperties.register(DDItems.SOUL_ELYTRA.get(), new ResourceLocation(DeeperAndDarker.MOD_ID, "broken"),
                    (stack, arg1, arg2, arg3) -> SoulElytraItem.isUseable(stack) ? 0 : 1);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(DDEntities.BOAT.get(), context -> new DDBoatRenderer<>(context, false));
            event.registerEntityRenderer(DDEntities.CHEST_BOAT.get(), context -> new DDBoatRenderer<>(context, true));
        }

        @SubscribeEvent
        public static void entityRenderers(final EntityRenderersEvent.AddLayers event) {
            GeoArmorRenderer.registerArmorRenderer(WardenArmorItem.class, WardenArmorRenderer::new);

            EntityModelSet entityModels = event.getEntityModels();
            event.getSkins().forEach(s -> {
                LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = event.getSkin(s);
                if(livingEntityRenderer instanceof PlayerRenderer playerRenderer){
                    playerRenderer.addLayer(new SoulElytraLayer(playerRenderer, entityModels));
                }
            });
            LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> livingEntityRenderer = event.getRenderer(EntityType.ARMOR_STAND);
            if(livingEntityRenderer instanceof ArmorStandRenderer armorStandRenderer){
                armorStandRenderer.addLayer(new SoulElytraArmorStandLayer(armorStandRenderer, entityModels));
            }

        }
    }


    @Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID)
    public static class DeeperDarkerEvents {
        @SubscribeEvent
        public static void playerTick(final TickEvent.PlayerTickEvent event) {
            if(!event.player.level.isClientSide()) {
                if(event.player.getLevel().dimension() == DDDimensions.OTHERSIDE_LEVEL) {
                    if(!event.player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get()) && !event.player.isCreative() && !event.player.isSpectator()) {
                        event.player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 25, 0));
                    }
                }
            }
        }
    }
}