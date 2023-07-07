package com.kyanite.deeperdarker;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;

public class DeeperDarkerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		String[] armorTypes = new String[]{"helmet","chestplate","leggings","boots"};
		String[] values = new String[]{"amethyst","copper","diamond","emerald","gold","iron","lapis","netherite","quartz","redstone"};
	}
}
