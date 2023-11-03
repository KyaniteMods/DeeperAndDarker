package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalFrameTester;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.DDFoliagePlacerTypes;
import com.kyanite.deeperdarker.world.DDTreeFeatures;
import com.kyanite.deeperdarker.world.DDTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.event.CPASoundEventData;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.kyrptonaught.customportalapi.util.PortalLink;
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
	public static final ResourceLocation OTHERSIDE_FRAME_TESTER = new ResourceLocation(MOD_ID, "otherside");

	public static final boolean SHOW_ME_YOUR_SKIN = FabricLoader.getInstance().isModLoaded("showmeyourskin");

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
		DDTrunkPlacerTypes.init();
		DDFoliagePlacerTypes.init();
		DDTreeFeatures.init();

		CustomPortalApiRegistry.registerPortalFrameTester(OTHERSIDE_FRAME_TESTER, OthersidePortalFrameTester::new);

		PortalLink portalLink = CustomPortalBuilder.beginPortal()
				.customFrameTester(OTHERSIDE_FRAME_TESTER)
				.frameBlock(Blocks.REINFORCED_DEEPSLATE)
				.customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP))
				.destDimID(new ResourceLocation(DeeperDarker.MOD_ID, "otherside"))
				.tintColor(5, 98, 93)
				.customPortalBlock((CustomPortalBlock) DDBlocks.OTHERSIDE_PORTAL)
				.forcedSize(8, 4)
				.registerInPortalAmbienceSound((player) -> new CPASoundEventData(DDSounds.PORTAL_GROAN, 1.0f, 1.0f))
				.setPortalSearchYRange(0, 115)
				.registerPortal();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getDefaultLootTable().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))));

				tableBuilder.withPool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && EntityType.WARDEN.getDefaultLootTable().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP));

				tableBuilder.withPool(poolBuilder);
			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && BuiltInLootTables.ANCIENT_CITY.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE)
								.when(LootItemRandomChanceCondition.randomChance(0.2f)));

				tableBuilder.withPool(poolBuilder);
			}
		});
	}
}