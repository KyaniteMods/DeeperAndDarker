package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.util.datagen.loot.DDBlockLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDEntityLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.tags.DDBlockTagProvider;
import com.kyanite.deeperdarker.util.datagen.tags.DeeperDarkerItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DeeperDarkerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DeeperDarkerRecipeProvider::new);
		pack.addProvider(DeeperDarkerModelProvider::new);
		pack.addProvider(DDBlockLootTableProvider::new);
		pack.addProvider(DDBlockTagProvider::new);
		pack.addProvider(DeeperDarkerItemTagProvider::new);
		pack.addProvider(DDENLanguageProvider::new);
		pack.addProvider(DDEntityLootTableProvider::new);
		pack.addProvider(DDAdvancementProvider::new);
		pack.addProvider(DDChestLootTableProvider::new);
//		String[] armorTypes = new String[]{"helmet","chestplate","leggings","boots"};
//		String[] values = new String[]{"amethyst","copper","diamond","emerald","gold","iron","lapis","netherite","quartz","redstone"};
	}
}