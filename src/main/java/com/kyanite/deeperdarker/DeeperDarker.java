package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.model.SculkSnapperModel;
import com.kyanite.deeperdarker.client.model.ShatteredModel;
import com.kyanite.deeperdarker.client.render.DDBoatRenderer;
import com.kyanite.deeperdarker.client.render.SculkSnapperRenderer;
import com.kyanite.deeperdarker.client.render.ShatteredRenderer;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.entities.SculkSnapper;
import com.kyanite.deeperdarker.content.entities.Shattered;
import com.kyanite.deeperdarker.datagen.assets.DDBlockStateProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import com.kyanite.deeperdarker.datagen.assets.DDSoundDefinitions;
import com.kyanite.deeperdarker.datagen.assets.ENLanguageProvider;
import com.kyanite.deeperdarker.datagen.data.DDBlockTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDItemTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDRecipeProvider;
import com.kyanite.deeperdarker.datagen.data.DDWorldGeneration;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootModifierProvider;
import com.kyanite.deeperdarker.datagen.data.loot.DDLootTableProvider;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.world.DDFeatures;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        DDEffects.EFFECTS.register(eventBus);
        DDPotions.POTIONS.register(eventBus);
        DDFeatures.FEATURES.register(eventBus);
        DDLootModifiers.LOOT_MODIFIERS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(DDCreativeTab::buildCreativeTab);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerAttributes);
        eventBus.addListener(this::registerLayers);
        eventBus.addListener(this::registerSpawnPlacements);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(DDBlocks.ECHO);
            ItemProperties.register(DDItems.SCULK_TRANSMITTER.get(), new ResourceLocation(MOD_ID, "linked"), (pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f);
        });

        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
        EntityRenderers.register(DDEntities.BOAT.get(), (context) -> new DDBoatRenderer(context, false));
        EntityRenderers.register(DDEntities.CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
        EntityRenderers.register(DDEntities.SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
        EntityRenderers.register(DDEntities.SHATTERED.get(), ShatteredRenderer::new);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
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
        generator.addProvider(event.includeServer(), new DDWorldGeneration(packOutput, event.getLookupProvider()));

        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new DDLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(packOutput));
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapper.createAttributes());
        event.put(DDEntities.SHATTERED.get(), Shattered.createAttributes());
    }

    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DDBoatRenderer.ECHO_BOAT_MODEL, BoatModel::createBodyModel);
        event.registerLayerDefinition(DDBoatRenderer.ECHO_CHEST_BOAT_MODEL, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(SculkSnapperRenderer.MODEL, SculkSnapperModel::createBodyModel);
        event.registerLayerDefinition(ShatteredRenderer.MODEL, ShatteredModel::createBodyModel);
    }

    private void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}
