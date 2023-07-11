package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AlternativeLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class DeeperDarkerBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected DeeperDarkerBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        this.addDrop(DeeperDarkerBlocks.ECHO_LOG);
        this.addDrop(DeeperDarkerBlocks.ECHO_WOOD);
        this.addDrop(DeeperDarkerBlocks.STRIPPED_ECHO_LOG);
        this.addDrop(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);
        this.addDrop(DeeperDarkerBlocks.ECHO_BUTTON);
        this.addDrop(DeeperDarkerBlocks.ECHO_DOOR, LootTable.builder().pool(LootPool.builder().conditionally(
                SurvivesExplosionLootCondition.builder()).with(ItemEntry.builder(DeeperDarkerItems.ECHO_DOOR).conditionally(
                BlockStatePropertyLootCondition.builder(DeeperDarkerBlocks.ECHO_DOOR).properties(StatePredicate.Builder.create().exactMatch(
                        Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER))))).randomSequenceId(new Identifier(
                DeeperDarker.MOD_ID, "blocks/echo_door")));
        this.addDrop(DeeperDarkerBlocks.ECHO_FENCE_GATE);
        this.addDrop(DeeperDarkerBlocks.ECHO_FENCE);
        this.addDrop(DeeperDarkerBlocks.ECHO_HANGING_SIGN);
        this.leavesDrops(DeeperDarkerBlocks.ECHO_LEAVES, DeeperDarkerBlocks.ECHO_SAPLING);
        this.addDrop(DeeperDarkerBlocks.ECHO_PLANKS);
        this.addDrop(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE);
        this.addDrop(DeeperDarkerBlocks.ECHO_SAPLING);
        this.addDrop(DeeperDarkerBlocks.ECHO_SIGN);
        this.addDrop(DeeperDarkerBlocks.ECHO_WALL_SIGN);
        this.addDrop(DeeperDarkerBlocks.ECHO_SLAB);
        this.addDrop(DeeperDarkerBlocks.ECHO_STAIRS);
        this.addDrop(DeeperDarkerBlocks.ECHO_TRAPDOOR);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.SCULK_STONE).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH).with(ItemEntry.builder(DeeperDarkerItems.COBBLED_SCULK_STONE))));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_SLAB);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICKS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILES);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILE_WALL);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.CHISELED_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.SCULK_GRIME).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH).with(ItemEntry.builder(DeeperDarkerItems.GRIME_BALL).apply(
                SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
        )));
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICKS);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICK_WALL);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.GLOOMSLATE).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH).with(ItemEntry.builder(DeeperDarkerItems.COBBLED_GLOOMSLATE)
        )));
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_SLAB);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICKS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICK_WALL);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILES);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILE_WALL);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.CHISELED_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.ECHO_SOIL);
        this.addDropWithSilkTouch(DeeperDarkerBlocks.SCULK_GLEAM);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_COAL_ORE, this.oreDrops(DeeperDarkerBlocks.SCULK_STONE_COAL_ORE, Items.COAL));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_IRON_ORE, this.oreDrops(DeeperDarkerBlocks.SCULK_STONE_IRON_ORE, Items.RAW_IRON));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE, this.copperOreDrops(DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE, this.oreDrops(DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE, Items.RAW_GOLD));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE, this.redstoneOreDrops(DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE, this.oreDrops(DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE, Items.EMERALD));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE, this.lapisOreDrops(DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE, this.oreDrops(DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE, Items.DIAMOND));
        this.addVinePlantDrop(DeeperDarkerBlocks.SCULK_TENDRILS, DeeperDarkerBlocks.SCULK_TENDRILS_PLANT);
        this.addVinePlantDrop(DeeperDarkerBlocks.SCULK_VINES, DeeperDarkerBlocks.SCULK_VINES_PLANT);
        this.addDrop(DeeperDarkerBlocks.GLOOMY_CACTUS);
        this.addDrop(DeeperDarkerBlocks.GLOOMY_GRASS, BlockLootTableGenerator.dropsWithShears(DeeperDarkerBlocks.GLOOMY_GRASS));
        this.addDropWithSilkTouch(DeeperDarkerBlocks.GLOOMY_SCULK);
        this.addDrop(DeeperDarkerBlocks.GLOOMY_GEYSER);
    }
}