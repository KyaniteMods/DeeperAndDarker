package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.model.*;
import com.kyanite.deeperdarker.client.render.*;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.content.items.SoulElytraItem;
import com.kyanite.deeperdarker.datagen.assets.DDBlockStateProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import com.kyanite.deeperdarker.datagen.assets.DDSoundDefinitions;
import com.kyanite.deeperdarker.datagen.assets.ENLanguageProvider;
import com.kyanite.deeperdarker.datagen.data.DDAdvancements;
import com.kyanite.deeperdarker.datagen.data.DDBlockTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDItemTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDRecipeProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootModifierProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootTableProvider;
import com.kyanite.deeperdarker.world.DDConfiguredFeatures;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.DDPlacedFeatures;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.structures.DDPools;
import com.kyanite.deeperdarker.world.structures.DDProcessorLists;
import com.kyanite.deeperdarker.world.structures.DDStructureSets;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDItems.ITEMS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEnchantments.ENCHANTMENTS.register(eventBus);
        DDLootModifiers.LOOT_MODIFIERS.register(eventBus);
        DDEffects.EFFECTS.register(eventBus);
        DDPotions.POTIONS.register(eventBus);
        DDSounds.SOUND_EVENTS.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        DDConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        DDPlacedFeatures.PLACED_FEATURES.register(eventBus);
        OthersideDimension.POI.register(eventBus);
        OthersideBiomes.BIOMES.register(eventBus);
        DDProcessorLists.PROCESSOR_LISTS.register(eventBus);
        DDPools.POOLS.register(eventBus);
        DDStructures.STRUCTURES.register(eventBus);
        DDStructureSets.STRUCTURE_SETS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerAttributes);
        eventBus.addListener(this::registerSpawnPlacements);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.ECHO_SAPLING.getId(), DDBlocks.POTTED_ECHO_SAPLING));

        PotionBrewing.addMix(Potions.AWKWARD, DDItems.SOUL_CRYSTAL.get(), DDPotions.SCULK_AFFINITY.get());
        PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        PotionBrewing.addMix(DDPotions.SCULK_AFFINITY.get(), Items.REDSTONE, DDPotions.LONG_SCULK_AFFINITY.get());
        PotionBrewing.addMix(Potions.LONG_INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.LONG_SCULK_AFFINITY.get());
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator));
        generator.addProvider(event.includeClient(), new DDBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDSoundDefinitions(generator, fileHelper));

        // data
        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(generator, blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new DDAdvancements(generator, fileHelper));
        generator.addProvider(event.includeServer(), new DDLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new DDLootModifierProvider(generator));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(generator));
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipede.createAttributes());
        event.put(DDEntities.SCULK_LEECH.get(), SculkLeech.createAttributes());
        event.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapper.createAttributes());
        event.put(DDEntities.SHATTERED.get(), Shattered.createAttributes());
        event.put(DDEntities.SHRIEK_WORM.get(), ShriekWorm.createAttributes());
        event.put(DDEntities.STALKER.get(), Stalker.createAttributes());
    }

    private void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(DDEntities.SCULK_CENTIPEDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class DeeperDarkerEvents {
        @SubscribeEvent
        public static void breakEvent(final BlockEvent.BreakEvent event) {
            if(!event.getState().is(DDBlocks.ANCIENT_VASE.get())) return;
            if(event.getPlayer().getMainHandItem().getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0) return;

            if(event.getLevel() instanceof ServerLevel level) {
                RandomSource random = level.getRandom();
                if(random.nextFloat() < 0.1f) {
                    if(random.nextFloat() < 0.953f) {
                        for(int i = 0; i < random.nextInt(1, 4); i++) {
                            DDEntities.SCULK_LEECH.get().spawn(level, null, null, null, event.getPos(), MobSpawnType.TRIGGERED, false, false);
                        }
                    } else {
                        DDEntities.STALKER.get().spawn(level, null, null, null, event.getPos(), MobSpawnType.TRIGGERED, false, false);
                    }
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class DeeperDarkerClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(DDBlocks.ECHO);
                ItemProperties.register(DDItems.SOUL_ELYTRA.get(), new ResourceLocation("broken"), (pStack, pLevel, pEntity, pSeed) -> SoulElytraItem.isFlyEnabled(pStack) ? 0 : 1);
                ItemProperties.register(DDItems.SCULK_TRANSMITTER.get(), new ResourceLocation(MOD_ID, "linked"), (pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1 : 0);
            });

            BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
            EntityRenderers.register(DDEntities.BOAT.get(), (context) -> new DDBoatRenderer(context, false));
            EntityRenderers.register(DDEntities.CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
            EntityRenderers.register(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipedeRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_LEECH.get(), SculkLeechRenderer::new);
            EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
            EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
            EntityRenderers.register(DDEntities.SHRIEK_WORM.get(), ShriekWormRenderer::new);
            EntityRenderers.register(DDEntities.STALKER.get(), StalkerRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(DDBoatRenderer.ECHO_BOAT_MODEL, () -> BoatModel.createBodyModel(false));
            event.registerLayerDefinition(DDBoatRenderer.ECHO_CHEST_BOAT_MODEL, () -> BoatModel.createBodyModel(true));
            event.registerLayerDefinition(SculkCentipedeRenderer.MODEL, SculkCentipedeModel::createBodyModel);
            event.registerLayerDefinition(SculkLeechRenderer.MODEL, SculkLeechModel::createBodyModel);
            event.registerLayerDefinition(SculkSnapperRenderer.MODEL, SculkSnapperModel::createBodyModel);
            event.registerLayerDefinition(ShatteredRenderer.MODEL, ShatteredModel::createBodyModel);
            event.registerLayerDefinition(ShriekWormRenderer.MODEL, ShriekWormModel::createBodyModel);
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
    }
}
