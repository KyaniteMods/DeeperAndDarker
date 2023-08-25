package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.util.datagen.DDAdvancementProvider;
import com.kyanite.deeperdarker.util.datagen.DDENLanguageProvider;
import com.kyanite.deeperdarker.util.datagen.DDModelProvider;
import com.kyanite.deeperdarker.util.datagen.DDRecipeProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDBlockLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDEntityLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.tags.DDBlockTagProvider;
import com.kyanite.deeperdarker.util.datagen.tags.DDItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DeeperDarkerDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(DDRecipeProvider::new);
        fabricDataGenerator.addProvider(DDModelProvider::new);
        fabricDataGenerator.addProvider(DDBlockLootTableProvider::new);
        fabricDataGenerator.addProvider(DDBlockTagProvider::new);
        fabricDataGenerator.addProvider(DDItemTagProvider::new);
        fabricDataGenerator.addProvider(DDENLanguageProvider::new);
        fabricDataGenerator.addProvider(DDEntityLootTableProvider::new);
        fabricDataGenerator.addProvider(DDAdvancementProvider::new);
        fabricDataGenerator.addProvider(DDChestLootTableProvider::new);
    }
}
