package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.compat.create.DDCreateCompat;
import com.kyanite.deeperdarker.content.*;
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

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("maze")
					.requires(c -> c.hasPermission(2))
					.then(Commands.argument("width", IntegerArgumentType.integer())
							.then(Commands.argument("height", IntegerArgumentType.integer())
									.then(Commands.argument("depth", IntegerArgumentType.integer())
											.then(Commands.argument("centerMinX", IntegerArgumentType.integer())
													.then(Commands.argument("centerMinY", IntegerArgumentType.integer())
															.then(Commands.argument("centerMinZ", IntegerArgumentType.integer())
																	.then(Commands.argument("centerMaxX", IntegerArgumentType.integer())
																			.then(Commands.argument("centerMaxY", IntegerArgumentType.integer())
																					.then(Commands.argument("centerMaxZ", IntegerArgumentType.integer())
																							.executes(c -> {
																								int width = c.getArgument("width", Integer.class);
																								int height = c.getArgument("height", Integer.class);
																								int depth = c.getArgument("depth", Integer.class);
																								int centerMinX = c.getArgument("centerMinX", Integer.class);
																								int centerMinY = c.getArgument("centerMinY", Integer.class);
																								int centerMinZ = c.getArgument("centerMinZ", Integer.class);
																								int centerMaxX = c.getArgument("centerMaxX", Integer.class);
																								int centerMaxY = c.getArgument("centerMaxY", Integer.class);
																								int centerMaxZ = c.getArgument("centerMaxZ", Integer.class);
																								int wallSize = 3;

																								try {
																									MazeGenerator mazeGenerator = new WilsonMazeGenerator(width, height, depth, false);

																									MazeResult result = mazeGenerator.generate(c.getSource().getLevel().getRandom());

																									for (int x = 0; x < width; x++) {
																										for (int y = 0; y < height; y++) {
																											for (int z = 0; z < depth; z++) {
																												Tile tile = result.get(x, y, z);
																												BlockState blockState = switch (tile.getType()) {
																													case PATH -> Blocks.AIR.defaultBlockState();
																													case ROOM -> Blocks.GREEN_STAINED_GLASS.defaultBlockState();
																													case ROOM_ENTRANCE -> Blocks.AIR.defaultBlockState();
																													case WALL -> DDBlocks.GLOOMSLATE.defaultBlockState();
																													case ENDPOINT -> Blocks.AIR.defaultBlockState();
																													case DEBUG -> Blocks.RED_STAINED_GLASS.defaultBlockState();
																												};

																												for (int dx = x * wallSize; dx < x * wallSize + wallSize; dx++) {
																													for (int dy = y * wallSize; dy < y * wallSize + wallSize; dy++) {
																														for (int dz = z * wallSize; dz < z * wallSize + wallSize; dz++) {
																															if (tile.getType() == Tile.Type.WALL) {
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
																									e.printStackTrace();
																								}

																								return Command.SINGLE_SUCCESS;
																							})))))))))));
		});
	}
}