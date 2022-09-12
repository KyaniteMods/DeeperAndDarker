package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.rendering.armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.client.rendering.entity.*;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.entity.DDBlockEntityTypes;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import com.kyanite.deeperdarker.registry.enchantments.DDEnchantments;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.*;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.kyanite.deeperdarker.registry.world.biomes.DDBiomeModifiers;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.deeperdarker.registry.world.dimension.DDPoiTypes;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.Heightmap;
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
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DeeperAndDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDSounds.SOUND_EVENTS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDEffects.MOB_EFFECTS.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        DDEntities.ENTITY_TYPES.register(eventBus);
        DDConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        DDPlacedFeatures.PLACED_FEATURES.register(eventBus);
        OthersideBiomes.BIOMES.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDEnchantments.ENCHANTMENTS.register(eventBus);
        DDPotions.POTIONS.register(eventBus);
        DDBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        DDPoiTypes.POI.register(eventBus);
        DDBiomeModifiers.BIOME_MODIFIERS.register(eventBus);

        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            WoodType.register(DDTypes.ECHO);
            BlockEntityRenderers.register(DDBlockEntityTypes.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);

            EntityRenderers.register(DDEntities.CENTIPEDE.get(), CentipedeRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SHRIEK_WORM.get(), SculkWormRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(DDEntities.BOAT.get(), context -> new DDBoatRenderer<>(context, false));
            event.registerEntityRenderer(DDEntities.CHEST_BOAT.get(), context -> new DDBoatRenderer<>(context, true));
        }

        @SubscribeEvent
        public static void entityRenderers(final EntityRenderersEvent.AddLayers event) {
            GeoArmorRenderer.registerArmorRenderer(WardenArmorItem.class, WardenArmorRenderer::new);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class DeeperDarkerCommon {
        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDTypes.ECHO);

                SpawnPlacements.register(DDEntities.CENTIPEDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
                SpawnPlacements.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
                SpawnPlacements.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            });

            ComposterBlock.COMPOSTABLES.put(DDBlocks.ECHO_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_GLEAM.get().asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_VINES.get().asItem(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_TENDRILS.get().asItem(), 0.5f);

            PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        }

        @SubscribeEvent
        public static void entityAttributes(final EntityAttributeCreationEvent event) {
            event.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapperEntity.attributes());
            event.put(DDEntities.SHRIEK_WORM.get(), SculkWormEntity.attributes());
            event.put(DDEntities.SCULK_LEECH.get(), SculkLeechEntity.attributes());
            event.put(DDEntities.SHATTERED.get(), ShatteredEntity.attributes());
            event.put(DDEntities.CENTIPEDE.get(), SculkCentipedeEntity.attributes());
            event.put(DDEntities.STALKER.get(), StalkerEntity.attributes());
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
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
