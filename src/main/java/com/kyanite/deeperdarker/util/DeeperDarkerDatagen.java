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
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(DDRecipeProvider::new);
        pack.addProvider(DDModelProvider::new);
        pack.addProvider(DDBlockLootTableProvider::new);
        pack.addProvider(DDBlockTagProvider::new);
        pack.addProvider(DDItemTagProvider::new);
        pack.addProvider(DDENLanguageProvider::new);
        pack.addProvider(DDEntityLootTableProvider::new);
        pack.addProvider(DDAdvancementProvider::new);
        pack.addProvider(DDChestLootTableProvider::new);
    }
}
