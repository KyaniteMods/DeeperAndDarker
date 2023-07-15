package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.entities.DeeperDarkerEntityTypes;
import com.kyanite.deeperdarker.entities.SculkSnapperEntity;
import com.kyanite.deeperdarker.items.DeeperDarkerItemGroups;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.kyanite.deeperdarker.items.DeeperDarkerPotions;
import com.kyanite.deeperdarker.sound.DeeperDarkerSounds;
import com.kyanite.deeperdarker.world.gen.feature.DeeperDarkerFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.mixin.object.builder.DefaultAttributeRegistryAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
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
		DeeperDarkerPotions.init();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getLootTableId().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(DeeperDarkerItems.WARDEN_CARAPACE));

				tableBuilder.pool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && LootTables.ANCIENT_CITY_CHEST.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(DeeperDarkerItems.WARDEN_CARAPACE))
						.conditionally(RandomChanceLootCondition.builder(0.2f));

				tableBuilder.pool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && LootTables.ANCIENT_CITY_CHEST.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));

				tableBuilder.pool(poolBuilder);
			}
		});
	}
}