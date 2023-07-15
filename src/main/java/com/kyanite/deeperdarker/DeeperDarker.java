package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.entities.DeeperDarkerEntityTypes;
import com.kyanite.deeperdarker.entities.SculkSnapperEntity;
import com.kyanite.deeperdarker.items.DeeperDarkerItemGroups;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import com.kyanite.deeperdarker.world.gen.feature.DeeperDarkerFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.mixin.object.builder.DefaultAttributeRegistryAccessor;
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
		DeeperDarkerEntityTypes.init();
		DeeperDarkerFeatures.init();
		DeeperDarkerSounds.init();
	}
}