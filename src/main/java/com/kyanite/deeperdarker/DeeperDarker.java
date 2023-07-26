package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.world.DDFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class DeeperDarker implements ModInitializer {
	public static final String MOD_ID = "deeperdarker";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		DDCreativeTab.init();
		DDItems.init();
		DDBlocks.init();
		DDFeatures.init();
		DDSounds.init();
		DDPotions.init();
		DDEnchantments.init();
		DDEntities.init();
		DDBlockEntities.init();
		DDEffects.init();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getDefaultLootTable().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.with((Collection<? extends LootPoolEntryContainer>) LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))))
						.with((Collection<? extends LootPoolEntryContainer>) LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP));

				tableBuilder.pool(poolBuilder.build());
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.with((Collection<? extends LootPoolEntryContainer>) LootItem.lootTableItem(DDItems.WARDEN_CARAPACE))
						.conditionally(LootItemRandomChanceCondition.randomChance(0.2f).build());

				tableBuilder.pool(poolBuilder.build());
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.with((Collection<? extends LootPoolEntryContainer>) LootItem.lootTableItem(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));

				tableBuilder.pool(poolBuilder.build());
			}
		});
	}
}