package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItemGroups;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeeperDarker implements ModInitializer {
	public static final String MOD_ID = "deeperdarker";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		DeeperDarkerItemGroups.init();
		DeeperDarkerBlocks.init();
		DeeperDarkerItems.init();
	}
}