package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.datagen.assets.DDBlockStateProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import com.kyanite.deeperdarker.datagen.assets.DDSoundDefinitions;
import com.kyanite.deeperdarker.datagen.assets.ENLanguageProvider;
import com.kyanite.deeperdarker.datagen.data.*;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootModifierProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootTableProvider;
import com.kyanite.deeperdarker.network.SoulElytraBoostPacket;
import com.kyanite.deeperdarker.network.SoulElytraClientPacket;
import com.kyanite.deeperdarker.network.UseTransmitterPacket;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DeeperDarker(IEventBus eventBus, ModContainer container) {
        DDSounds.SOUND_EVENTS.register(eventBus);
        DDDataComponents.COMPONENTS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);
        DDEffects.EFFECTS.register(eventBus);
        DDPotions.POTIONS.register(eventBus);
        DDEnchantments.ENCHANTMENT_EFFECTS.register(eventBus);
        DDArmorMaterials.ARMOR_MATERIALS.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        OthersideDimension.POI.register(eventBus);
        DDLootModifiers.LOOT_MODIFIERS.register(eventBus);

        eventBus.addListener(DDCreativeTab::buildCreativeTab);
        eventBus.addListener(DeeperDarkerConfig::loadConfigs);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerPayloads);
        eventBus.addListener(this::registerAttributes);
        eventBus.addListener(this::registerSpawnPlacements);

        container.registerConfig(ModConfig.Type.COMMON, DeeperDarkerConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.ECHO_SAPLING.getId(), DDBlocks.POTTED_ECHO_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.BLOOMING_STEM.getId(), DDBlocks.POTTED_BLOOMING_STEM);
        });
    }

    private void generateData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new DDBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDSoundDefinitions(packOutput, fileHelper));

        // data
        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(packOutput, lookupProvider, blockTags, fileHelper));

        CompletableFuture<HolderLookup.Provider> newLookup = generator.addProvider(event.includeServer(), new DDRegistriesGenerator(packOutput, lookupProvider)).getRegistryProvider();
        generator.addProvider(event.includeServer(), new AdvancementProvider(packOutput, newLookup, fileHelper, List.of(new DDAdvancements())));
        generator.addProvider(event.includeServer(), new DDLootTableProvider(packOutput, newLookup));
        generator.addProvider(event.includeServer(), new DDLootModifierProvider(packOutput, newLookup));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(packOutput, newLookup));
    }

    private void registerPayloads(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1.0");

        registrar.playToServer(SoulElytraBoostPacket.TYPE, SoulElytraBoostPacket.STREAM_CODEC, SoulElytraBoostPacket::handle);
        registrar.playToClient(SoulElytraClientPacket.TYPE, SoulElytraClientPacket.STREAM_CODEC, SoulElytraClientPacket::handle);
        registrar.playToServer(UseTransmitterPacket.TYPE, UseTransmitterPacket.STREAM_CODEC, UseTransmitterPacket::handle);
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        event.put(DDEntities.ANGLER_FISH.get(), AnglerFish.createAttributesSupplier());
        event.put(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipede.createAttributes());
        event.put(DDEntities.SCULK_LEECH.get(), SculkLeech.createAttributes());
        event.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapper.createAttributes());
        event.put(DDEntities.SHATTERED.get(), Shattered.createAttributes());
        event.put(DDEntities.SHRIEK_WORM.get(), ShriekWorm.createAttributes());
        event.put(DDEntities.SLUDGE.get(), Sludge.createAttributes());
        event.put(DDEntities.STALKER.get(), Stalker.createAttributes());
    }

    private void registerSpawnPlacements(final RegisterSpawnPlacementsEvent event) {
        event.register(DDEntities.ANGLER_FISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnglerFish::checkSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(DDEntities.SCULK_CENTIPEDE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(DDEntities.SHATTERED.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(DDEntities.SLUDGE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
