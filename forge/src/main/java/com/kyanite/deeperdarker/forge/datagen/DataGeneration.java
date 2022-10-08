package com.kyanite.deeperdarker.forge.datagen;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.forge.datagen.advancements.DDAdvancementsProvider;
import com.kyanite.deeperdarker.forge.datagen.lang.ENLanguageProvider;
import com.kyanite.deeperdarker.forge.datagen.loot.DDLootTableProvider;
import com.kyanite.deeperdarker.forge.datagen.models.DDBlockStateProvider;
import com.kyanite.deeperdarker.forge.datagen.models.DDItemModelProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.CraftingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.SmeltingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.SmithingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.recipes.StonecuttingRecipesProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDBlockTagsProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDItemTagsProvider;
import com.kyanite.deeperdarker.forge.datagen.tags.DDStructureTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new DDAdvancementsProvider(generator, fileHelper));

        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator, "en_us", false));
        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator, "en_ud", true));

        generator.addProvider(event.includeServer(), new DDLootTableProvider(generator));

        generator.addProvider(event.includeClient(), new DDBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(generator, fileHelper));

        generator.addProvider(event.includeServer(), new CraftingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new SmeltingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new SmithingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new StonecuttingRecipesProvider(generator));

        DDBlockTagsProvider blockTags = new DDBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DDItemTagsProvider(generator, blockTags, fileHelper));
        generator.addProvider(event.includeServer(), new DDStructureTagsProvider(generator, fileHelper));
    }
}
