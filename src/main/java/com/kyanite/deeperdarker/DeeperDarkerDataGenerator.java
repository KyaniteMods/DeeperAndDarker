package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.datagen.DeeperDarkerModelProvider;
import com.kyanite.deeperdarker.datagen.DeeperDarkerRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DeeperDarkerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DeeperDarkerRecipeProvider::new);
		pack.addProvider(DeeperDarkerModelProvider::new);
//		String[] armorTypes = new String[]{"helmet","chestplate","leggings","boots"};
//		String[] values = new String[]{"amethyst","copper","diamond","emerald","gold","iron","lapis","netherite","quartz","redstone"};
	}
}
