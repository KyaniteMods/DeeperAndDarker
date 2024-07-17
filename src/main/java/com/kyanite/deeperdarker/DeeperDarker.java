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
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DeeperDarkerConfig;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDSounds.SOUND_EVENTS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);
        AncientPaintingVariants.PAINTINGS.register(eventBus);
        DDEffects.EFFECTS.register(eventBus);
        DDPotions.POTIONS.register(eventBus);
        DDEnchantments.ENCHANTMENTS.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        OthersideDimension.POI.register(eventBus);
        DDLootModifiers.LOOT_MODIFIERS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(DDCreativeTab::buildCreativeTab);
        eventBus.addListener(DeeperDarkerConfig::loadConfigs);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerAttributes);
        eventBus.addListener(this::registerSpawnPlacements);

        Messages.registerMessages(MOD_ID + "_network");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeeperDarkerConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.ECHO_SAPLING.getId(), DDBlocks.POTTED_ECHO_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DDBlocks.BLOOMING_STEM.getId(), DDBlocks.POTTED_BLOOMING_STEM);
        });

        PotionBrewing.addMix(Potions.AWKWARD, DDItems.SOUL_CRYSTAL.get(), DDPotions.SCULK_AFFINITY.get());
        PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        PotionBrewing.addMix(DDPotions.SCULK_AFFINITY.get(), Items.REDSTONE, DDPotions.LONG_SCULK_AFFINITY.get());
        PotionBrewing.addMix(Potions.LONG_INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.LONG_SCULK_AFFINITY.get());
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new DDBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDSoundDefinitions(packOutput, fileHelper));

        // data
        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, event.getLookupProvider(), fileHelper, List.of(new DDAdvancements())));
        generator.addProvider(event.includeServer(), new DDRegistriesGenerator(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new DDLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(packOutput));
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(DDEntities.ANGLER_FISH.get(), AnglerFish.createAttributesSupplier());
        event.put(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipede.createAttributes());
        event.put(DDEntities.SCULK_LEECH.get(), SculkLeech.createAttributes());
        event.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapper.createAttributes());
        event.put(DDEntities.SHATTERED.get(), Shattered.createAttributes());
        event.put(DDEntities.SHRIEK_WORM.get(), ShriekWorm.createAttributes());
        event.put(DDEntities.STALKER.get(), Stalker.createAttributes());
    }

    private void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(DDEntities.ANGLER_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnglerFish::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SCULK_CENTIPEDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
