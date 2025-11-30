package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.compat.create.DDCreateCompat;
import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalFrameTester;
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.util.AncientPaintings;
import com.kyanite.deeperdarker.util.DDConfig;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DDLootItemFunctions;
import com.kyanite.deeperdarker.util.recipes.DDRecipeSerializers;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.otherside.structures.gloomaze.BacktrackerMazeGenerator;
import com.kyanite.deeperdarker.world.otherside.structures.gloomaze.MazeGenerator;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.fabricmc.loader.api.FabricLoader;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.event.CPASoundEventData;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.commands.Commands;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
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
		if (FabricLoader.getInstance().isModLoaded("create") && CONFIG.server.createCompatibility()) {
			DDCreateCompat.init();
			DDCreateCompat.REGISTRATE.register();
		}

		if (FabricLoader.getInstance().isModLoaded("showmeyourskin") && CONFIG.server.showMeYourSkinCompatibility()) {
			SHOW_ME_YOUR_SKIN = true;
		}

		CustomPortalBuilder.beginPortal()
				.customFrameTester(OTHERSIDE_FRAME_TESTER)
				.frameBlock(Blocks.REINFORCED_DEEPSLATE)
				.customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP))
				.destDimID(new ResourceLocation(DeeperDarker.MOD_ID, "otherside"))
				.tintColor(5, 98, 93)
				.customPortalBlock((CustomPortalBlock) DDBlocks.OTHERSIDE_PORTAL)
				.forcedSize(8, 4)
				.registerInPortalAmbienceSound((player) -> new CPASoundEventData(DDSounds.PORTAL_GROAN, 1.0f, 1.0f))
				.registerPortal();

		CustomPortalApiRegistry.registerPortalFrameTester(OTHERSIDE_FRAME_TESTER, OthersidePortalFrameTester::new);

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source == LootTableSource.DATA_PACK) return;

			if (EntityType.WARDEN.getDefaultLootTable().equals(id)) {
				LootPool.Builder carapacePoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))));
				LootPool.Builder heartPoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP));

				tableBuilder.withPool(carapacePoolBuilder);
				tableBuilder.withPool(heartPoolBuilder);
			}
			if (BuiltInLootTables.ANCIENT_CITY.equals(id)) {
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

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("maze")
					.requires(c -> c.hasPermission(2))
					.then(Commands.argument("width", IntegerArgumentType.integer())
							.then(Commands.argument("height", IntegerArgumentType.integer())
									.then(Commands.argument("depth", IntegerArgumentType.integer())
											.then(Commands.argument("centerSide", IntegerArgumentType.integer())
											.executes(c -> {
												int width = c.getArgument("width", Integer.class);
												int height = c.getArgument("height", Integer.class);
												int depth = c.getArgument("depth", Integer.class);
												int centerSide = c.getArgument("centerSide", Integer.class);
												int wallSize = 3;

												try {
													BacktrackerMazeGenerator mazeGenerator = new BacktrackerMazeGenerator(width, height, depth, centerSide);

													MazeGenerator.TileType[][][] arr = mazeGenerator.generate(c.getSource().getLevel().getRandom());

													for (int x = 0; x < width; x++) {
														for (int y = 0; y < height; y++) {
															for (int z = 0; z < depth; z++) {
																MazeGenerator.TileType tileType = arr[x][y][z];
																BlockState blockState = switch (tileType) {
																	case PATH -> Blocks.AIR.defaultBlockState();
																	case WALL -> DDBlocks.GLOOMSLATE.defaultBlockState();
																	case ENDPOINT -> Blocks.AIR.defaultBlockState();
																	case DEBUG -> Blocks.RED_STAINED_GLASS.defaultBlockState();
																};

																for (int dx = x * wallSize; dx < x * wallSize + wallSize; dx++) {
																	for (int dy = y * wallSize; dy < y * wallSize + wallSize; dy++) {
																		for (int dz = z * wallSize; dz < z * wallSize + wallSize; dz++) {
																			if (tileType == MazeGenerator.TileType.WALL) {
																				if (((dx - x * wallSize) % 2 == 0 && (dy - y * wallSize) % 2 == 0 && (dz - z * wallSize) % 2 == 0) || dx == 0 || dy == 0 || dz == 0 || dx == (width * wallSize) - 1 || dy == (height * wallSize) - 1 || dz == (depth * wallSize) - 1)
																					c.getSource().getLevel().setBlock(c.getSource().getEntity().blockPosition().offset(dx, dy, dz), DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState(), 2);
																				else if ((dx - x * wallSize) == 1 && (dy - y * wallSize) == 1 && (dz - z * wallSize) == 1)
																					c.getSource().getLevel().setBlock(c.getSource().getEntity().blockPosition().offset(dx, dy, dz), DDBlocks.SCULK_GLEAM.defaultBlockState(), 2);
																				else if (((dx - x * wallSize) + (dy - y * wallSize) + (dz - z * wallSize)) % 2 == 1)
																					c.getSource().getLevel().setBlock(c.getSource().getEntity().blockPosition().offset(dx, dy, dz), DDBlocks.PROTECTED_SCULK_GRIME_GLASS.defaultBlockState(), 2);
																				else
																					c.getSource().getLevel().setBlock(c.getSource().getEntity().blockPosition().offset(dx, dy, dz), DDBlocks.PROTECTED_SCULK_GLEAM.defaultBlockState(), 2);
																			} else
																				c.getSource().getLevel().setBlock(c.getSource().getEntity().blockPosition().offset(dx, dy, dz), blockState, 2);
																		}
																	}
																}
															}
														}
													}
												} catch (Exception e) {
													System.out.println(e.getMessage());
												}

												return Command.SINGLE_SUCCESS;
											}))))));
		});
	}
}