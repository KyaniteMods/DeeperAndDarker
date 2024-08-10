package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalFrameTester;
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.util.DDConfig;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.content.AncientPaintings;
import com.kyanite.deeperdarker.world.DDFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.event.CPASoundEventData;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeeperDarker implements ModInitializer {
	public static final String MOD_ID = "deeperdarker";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceLocation OTHERSIDE_FRAME_TESTER = rl("otherside");

	public static final boolean SHOW_ME_YOUR_SKIN = FabricLoader.getInstance().isModLoaded("showmeyourskin");

	public static final DDConfig CONFIG = DDConfig.createAndLoad();

	@Override
	public void onInitialize() {
		DDCreativeTab.init();
		DDItems.init();
		DDBlocks.init();
		DDFeatures.init();
		DDSounds.init();
		DDPotions.init();
		DDEntities.init();
		DDBlockEntities.init();
		DDEffects.init();
		DDDataComponents.init();

		CustomPortalBuilder.beginPortal()
				.customFrameTester(OTHERSIDE_FRAME_TESTER)
				.frameBlock(Blocks.REINFORCED_DEEPSLATE)
				.customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP))
				.destDimID(rl("otherside"))
				.tintColor(5, 98, 93)
				.customPortalBlock((CustomPortalBlock) DDBlocks.OTHERSIDE_PORTAL)
				.forcedSize(8, 4)
				.registerInPortalAmbienceSound((player) -> new CPASoundEventData(DDSounds.PORTAL_GROAN, 1.0f, 1.0f))
				.registerPortal();

		CustomPortalApiRegistry.registerPortalFrameTester(OTHERSIDE_FRAME_TESTER, OthersidePortalFrameTester::new);

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getDefaultLootTable() == key) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))));

				tableBuilder.withPool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getDefaultLootTable() == key) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP));

				tableBuilder.withPool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY == key) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE)
								.when(LootItemRandomChanceCondition.randomChance(0.2f)));

				tableBuilder.withPool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY == key) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE))
							.when(LootItemRandomChanceCondition.randomChance(0.2f));

				tableBuilder.withPool(poolBuilder);
			}
		});

		Messages.registerMessages();
	}

	public static ResourceLocation rl(String path) {
		return ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, path);
	}
}