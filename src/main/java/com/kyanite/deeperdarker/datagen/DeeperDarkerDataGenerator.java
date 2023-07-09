package com.kyanite.deeperdarker.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DeeperDarkerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DeeperDarkerRecipeProvider::new);
		pack.addProvider(DeeperDarkerModelProvider::new);
		pack.addProvider(DeeperDarkerBlockLootTableProvider::new);
		pack.addProvider(DeeperDarkerBlockTagProvider::new);
		pack.addProvider(DeeperDarkerItemTagProvider::new);
		pack.addProvider(DeeperDarkerENLanguageProvider::new);
//		String[] armorTypes = new String[]{"helmet","chestplate","leggings","boots"};
//		String[] values = new String[]{"amethyst","copper","diamond","emerald","gold","iron","lapis","netherite","quartz","redstone"};
	}
}