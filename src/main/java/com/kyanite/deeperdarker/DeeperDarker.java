package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
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
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        DDSounds.SOUND_EVENTS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::generateData);
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
}
