package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.world.DDFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.kyrptonaught.customportalapi.util.PortalLink;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
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

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.REINFORCED_DEEPSLATE)
				.customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP))
				.destDimID(new ResourceLocation(DeeperDarker.MOD_ID, "otherside"))
				.tintColor(5, 98, 93)
				.customPortalBlock((CustomPortalBlock) DDBlocks.OTHERSIDE_PORTAL)
				.forcedSize(20, 6)
				.registerPortal();


		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getDefaultLootTable().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.with(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))).build())
						.with(LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP).build());

				tableBuilder.pool(poolBuilder.build());
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.with(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).build())
						.conditionally(LootItemRandomChanceCondition.randomChance(0.2f).build());

				tableBuilder.pool(poolBuilder.build());
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.with(LootItem.lootTableItem(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE).build());

				tableBuilder.pool(poolBuilder.build());
			}
		});
	}
}