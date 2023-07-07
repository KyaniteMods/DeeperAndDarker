package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.datagen.assets.DDBlockStateProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import com.kyanite.deeperdarker.datagen.assets.ENLanguageProvider;
import com.kyanite.deeperdarker.datagen.data.DDBlockTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDItemTagsProvider;
import com.kyanite.deeperdarker.datagen.data.DDLootTableProvider;
import com.kyanite.deeperdarker.datagen.data.DDRecipeProvider;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.render.DDBoatRenderer;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeeperDarker.MOD_ID)
public class DeeperDarker {
    public static final String MOD_ID = "deeperdarker";

    public DeeperDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DDItems.ITEMS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDBlockEntities.BLOCK_ENTITIES.register(eventBus);
        DDEntities.ENTITIES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(DDCreativeTab::buildCreativeTab);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::generateData);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> Sheets.addWoodType(DDBlocks.ECHO));

        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_SIGNS.get(), SignRenderer::new);
        BlockEntityRenderers.register(DDBlockEntities.DEEPER_DARKER_HANGING_SIGNS.get(), HangingSignRenderer::new);
        EntityRenderers.register(DDEntities.DEEPER_DARKER_BOAT.get(), (context) -> new DDBoatRenderer(context, false));
        EntityRenderers.register(DDEntities.DEEPER_DARKER_CHEST_BOAT.get(), (context) -> new DDBoatRenderer(context, true));
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new DDBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(packOutput, fileHelper));

        // data
        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new DDLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new DDRecipeProvider(packOutput));
    }
}
