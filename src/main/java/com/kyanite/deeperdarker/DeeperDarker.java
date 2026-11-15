package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.*;
import com.kyanite.deeperdarker.content.blocks.LockBlock;
import com.kyanite.deeperdarker.content.blocks.SculkFireBlock;
import com.kyanite.deeperdarker.content.items.components.DDDataComponents;
import com.kyanite.deeperdarker.network.Messages;
import com.kyanite.deeperdarker.util.DDConfig;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DDLootItemFunctions;
import com.kyanite.deeperdarker.util.recipes.DDRecipeSerializers;
import com.kyanite.deeperdarker.world.DDCarvers;
import com.kyanite.deeperdarker.world.DDFeatures;
import com.kyanite.deeperdarker.world.otherside.gen.OthersideGeneration;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructurePieceTypes;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructureTypes;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomTypeRegistry;
import dev.kyanitemods.kyaniteportals.api.SimplePortalBuilder;
import dev.kyanitemods.kyaniteportals.content.Portal;
import dev.kyanitemods.kyaniteportals.content.registry.PortalTriggers;
import dev.kyanitemods.kyaniteportals.content.triggers.TriggerResult;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.gameevent.GameEvent;
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

	public static final DDConfig CONFIG = DDConfig.createAndLoad();

	public static ResourceKey<Portal> OTHERSIDE_PORTAL;

	@Override
	public void onInitialize() {
		DDCreativeTab.init();
		DDDataComponents.init();
		DDItems.init();
		DDBlocks.init();
		DDBlockItems.init();
		DDFeatures.init();
		DDSounds.init();
		DDPotions.init();
		DDEnchantments.init();
		DDEntities.init();
		DDBlockEntities.init();
		DDEffects.init();
		DDLootItemFunctions.init();
		DDRecipeSerializers.init();
		DDStructurePieceTypes.init();
		DDStructureTypes.init();
		RoomTypeRegistry.init();
		DDCarvers.init();
		DDParticleTypes.init();
		DDFluids.init();
		DDCriteriaTriggers.init();

		OTHERSIDE_PORTAL = SimplePortalBuilder.create()
				.frame(Blocks.REINFORCED_DEEPSLATE)
				.ignition(DDItems.HEART_OF_THE_DEEP)
				.ignition(DDBlocks.SCULK_FIRE)
				.fromDimension(LevelStem.OVERWORLD)
				.toDimension(OthersideGeneration.OTHERSIDE_STEM)
				.color((5 << 16) | (98 << 8) | 93)
				.addReplaceable(Blocks.SCULK_VEIN)
				.ambientSound(Holder.direct(DDSounds.PORTAL_GROAN))
				.generatedSize(10, 6)
				.register(id("otherside"));

		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (EntityType.WARDEN.getDefaultLootTable().equals(key) && CONFIG.server.addWardenDrops()) {
				LootPool.Builder carapacePoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).apply(SetItemCountFunction.setCount(
								UniformGenerator.between(1.0f, 3.0f))));
				LootPool.Builder heartPoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(DDItems.HEART_OF_THE_DEEP));

				tableBuilder.withPool(carapacePoolBuilder);
				tableBuilder.withPool(heartPoolBuilder);
			}
			if (BuiltInLootTables.ANCIENT_CITY.equals(key) && CONFIG.server.addAncientCityLoot()) {
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
		DispenserBlock.registerBehavior(DDItems.OTHERSIDE_FIRE_STRIKER, new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				ServerLevel level = blockSource.level();
				setSuccess(true);
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				BlockPos blockPos = blockSource.pos().relative(direction);
				BlockState blockState = level.getBlockState(blockPos);
				if (SculkFireBlock.canBePlacedAt(level, blockPos, direction)) {
					level.setBlockAndUpdate(blockPos, DDBlocks.SCULK_FIRE.defaultBlockState());
					level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
				} else if (CampfireBlock.canLight(blockState) || CandleBlock.canLight(blockState) || CandleCakeBlock.canLight(blockState)) {
					level.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.LIT, true));
					level.gameEvent(null, GameEvent.BLOCK_CHANGE, blockPos);
				} else if (blockState.getBlock() instanceof TntBlock) {
					TntBlock.explode(level, blockPos);
					level.removeBlock(blockPos, false);
				} else {
					setSuccess(false);
				}

				if (isSuccess()) {
					itemStack.hurtAndBreak(1, level, null, item -> {});
				}

				return itemStack;
			}
		});
		DispenserBlock.registerBehavior(DDBlockItems.SHATTERED_HEAD, new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				this.setSuccess(ArmorItem.dispenseArmor(blockSource, itemStack));
				return itemStack;
			}
		});

		DispenseItemBehavior keyBehavior = new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
				setSuccess(false);
				Level level = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				BlockPos blockPos = blockSource.pos().relative(direction);
				BlockState blockState = level.getBlockState(blockPos);
				if (blockState.getBlock() instanceof LockBlock lockBlock && lockBlock.use(level, blockPos, null, stack) == ItemInteractionResult.SUCCESS) {
					setSuccess(true);
				}
				return stack;
			}
		};

		DispenserBlock.registerBehavior(DDItems.DAINTY_KEY, keyBehavior);
		DispenserBlock.registerBehavior(DDItems.KEYBRAND, keyBehavior);

		DispenserBlock.registerBehavior(DDItems.HEART_OF_THE_DEEP, new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
				Level level = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				BlockPos pos = blockSource.pos().relative(direction);
				BlockState blockState = level.getBlockState(pos);

				setSuccess(blockState.isAir() && PortalTriggers.USE_ITEM.trigger(level, pos, null, stack) == TriggerResult.PASS);

				return stack;
			}
		});

		DispenserBlock.registerBehavior(DDItems.ACID_BUCKET, new DefaultDispenseItemBehavior() {
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			@Override
			public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem)itemStack.getItem();
				BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
				Level level = blockSource.level();
				if (dispensibleContainerItem.emptyContents(null, level, blockPos, null)) {
					dispensibleContainerItem.checkExtraContent(null, level, itemStack, blockPos);
					return new ItemStack(Items.BUCKET);
				} else {
					return this.defaultDispenseItemBehavior.dispense(blockSource, itemStack);
				}
			}
		});

		Messages.registerPayloadTypes();
		Messages.registerReceivers();
	}

	public static ResourceLocation id(String key) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, key);
	}
}