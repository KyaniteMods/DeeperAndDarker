package com.nitro.deeperdarker.datagen;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.datagen.advancements.DDAdvancementsProvider;
import com.nitro.deeperdarker.datagen.lang.ENLanguageProvider;
import com.nitro.deeperdarker.datagen.loot.DDLootTableProvider;
import com.nitro.deeperdarker.datagen.models.DDBlockStateProvider;
import com.nitro.deeperdarker.datagen.models.DDItemModelProvider;
import com.nitro.deeperdarker.datagen.recipes.CraftingRecipesProvider;
import com.nitro.deeperdarker.datagen.recipes.SmithingRecipesProvider;
import com.nitro.deeperdarker.datagen.recipes.StonecuttingRecipesProvider;
import com.nitro.deeperdarker.datagen.tags.DDBlockTagsProvider;
import com.nitro.deeperdarker.datagen.tags.DDItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new DDAdvancementsProvider(generator, fileHelper));

        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator));

        generator.addProvider(event.includeServer(), new DDLootTableProvider(generator));

        generator.addProvider(event.includeClient(), new DDBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(generator, fileHelper));

        generator.addProvider(event.includeServer(), new CraftingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new SmithingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new StonecuttingRecipesProvider(generator));

        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(generator, blockTags, fileHelper));
    }
}
