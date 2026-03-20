package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.compat.create.DDCreateCompat;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselUseItemPhase;
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.util.AncientPaintings;
import com.kyanite.deeperdarker.util.DDConfig;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DDLootItemFunctions;
import com.kyanite.deeperdarker.util.recipes.DDRecipeSerializers;
import com.kyanite.deeperdarker.world.DDCarvers;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.otherside.gen.OthersideGeneration;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructurePieceTypes;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructureTypes;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.MazeGenerator;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.MazeResult;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Tile;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.WilsonMazeGenerator;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomTypeRegistry;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import dev.kyanitemods.kyaniteportals.api.SimplePortalBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.commands.Commands;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.LevelStem;
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

	public static boolean SHOW_ME_YOUR_SKIN = false;

	public static final DDConfig CONFIG = DDConfig.createAndLoad();

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
		AncientPaintings.init();
		DDLootItemFunctions.init();
		DDRecipeSerializers.init();
		DDStructurePieceTypes.init();
		DDStructureTypes.init();
		RoomTypeRegistry.init();
		DDCarvers.init();
		if (FabricLoader.getInstance().isModLoaded("create") && CONFIG.server.createCompatibility()) {
			DDCreateCompat.init();
			DDCreateCompat.REGISTRATE.register();
		}

		if (FabricLoader.getInstance().isModLoaded("showmeyourskin") && CONFIG.server.showMeYourSkinCompatibility()) {
			SHOW_ME_YOUR_SKIN = true;
		}

		SimplePortalBuilder.create()
				.frame(Blocks.REINFORCED_DEEPSLATE)
				.ignition(DDItems.HEART_OF_THE_DEEP)
				.fromDimension(LevelStem.OVERWORLD)
				.toDimension(OthersideGeneration.OTHERSIDE_STEM)
				.color((5 << 16) | (98 << 8) | 93)
				.replaceable(Blocks.AIR, Blocks.CAVE_AIR, Blocks.VOID_AIR, Blocks.SCULK_VEIN)
				.ambientSound(Holder.direct(DDSounds.PORTAL_GROAN))
				.generatedSize(10, 6)
				.register(new ResourceLocation(MOD_ID, "otherside"));

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (EntityType.WARDEN.getDefaultLootTable().equals(id) && CONFIG.server.addWardenDrops()) {
				LootPool.Builder carapacePoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))));
				LootPool.Builder heartPoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP));

				tableBuilder.withPool(carapacePoolBuilder);
				tableBuilder.withPool(heartPoolBuilder);
			}
			if (BuiltInLootTables.ANCIENT_CITY.equals(id) && CONFIG.server.addAncientCityLoot()) {
				LootPool.Builder carapacePoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE)
								.when(LootItemRandomChanceCondition.randomChance(0.2f)));
				LootPool.Builder wardenUpgradePoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE))
						.when(LootItemRandomChanceCondition.randomChance(0.2f));

				tableBuilder.withPool(carapacePoolBuilder);
				tableBuilder.withPool(wardenUpgradePoolBuilder);
			}
		});

		Messages.registerReceivers();
	}
}