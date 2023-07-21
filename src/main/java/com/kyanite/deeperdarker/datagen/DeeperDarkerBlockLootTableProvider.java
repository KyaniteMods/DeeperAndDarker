package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
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
        this.addDrop(DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN);
        this.leavesDrops(DeeperDarkerBlocks.ECHO_LEAVES, DeeperDarkerBlocks.ECHO_SAPLING);
        this.addDrop(DeeperDarkerBlocks.ECHO_PLANKS);
        this.addDrop(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE);
        this.addDrop(DeeperDarkerBlocks.ECHO_SAPLING);
        this.addDrop(DeeperDarkerBlocks.ECHO_SIGN);
        this.addDrop(DeeperDarkerBlocks.ECHO_WALL_SIGN);
        this.addDrop(DeeperDarkerBlocks.ECHO_SLAB, slabDrops(DeeperDarkerBlocks.ECHO_SLAB));
        this.addDrop(DeeperDarkerBlocks.ECHO_STAIRS);
        this.addDrop(DeeperDarkerBlocks.ECHO_TRAPDOOR);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.SCULK_STONE).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH).with(ItemEntry.builder(DeeperDarkerItems.COBBLED_SCULK_STONE))));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_SLAB, slabDrops(DeeperDarkerBlocks.SCULK_STONE_SLAB));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB, slabDrops(DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB));
        this.addDrop(DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB, slabDrops(DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB));
        this.addDrop(DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICKS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB, slabDrops(DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILES);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB, slabDrops(DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB));
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE_TILE_WALL);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB, slabDrops(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB));
        this.addDrop(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB, slabDrops(DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB));
        this.addDrop(DeeperDarkerBlocks.CUT_SCULK_STONE_WALL);
        this.addDrop(DeeperDarkerBlocks.CHISELED_SCULK_STONE);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.SCULK_GRIME).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH).with(ItemEntry.builder(DeeperDarkerItems.GRIME_BALL).apply(
                SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
        )));
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICKS);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB, slabDrops(DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB));
        this.addDrop(DeeperDarkerBlocks.SCULK_GRIME_BRICK_WALL);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.GLOOMSLATE).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH).with(ItemEntry.builder(DeeperDarkerItems.COBBLED_GLOOMSLATE)
        )));
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_SLAB, slabDrops(DeeperDarkerBlocks.GLOOMSLATE_SLAB));
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB, slabDrops(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB));
        this.addDrop(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB, slabDrops(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB));
        this.addDrop(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICKS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB, slabDrops(DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB));
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_BRICK_WALL);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILES);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB, slabDrops(DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB));
        this.addDrop(DeeperDarkerBlocks.GLOOMSLATE_TILE_WALL);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB, slabDrops(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB));
        this.addDrop(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_WALL);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS);
        this.addDrop(DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB, slabDrops(DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB));
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
        this.addDropWithSilkTouch(DeeperDarkerBlocks.GLOOMY_GEYSER);
        this.addDrop(DeeperDarkerBlocks.ANCIENT_VASE, BlockLootTableGenerator.dropsWithSilkTouch(DeeperDarkerBlocks.ANCIENT_VASE).pool(LootPool.builder().rolls(
                ConstantLootNumberProvider.create(1.0f)).conditionally(WITHOUT_SILK_TOUCH)
                .rolls(UniformLootNumberProvider.create(1.0f, 3.0f))
                .with(EmptyEntry.builder().weight(20))
                .with(ItemEntry.builder(Blocks.SAND).weight(11)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6))))
                .with(ItemEntry.builder(Items.STRING).weight(10)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 9))))
                .with(ItemEntry.builder(Items.ROTTEN_FLESH).weight(9)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 8))))
                .with(ItemEntry.builder(Items.GOLD_INGOT).weight(6)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5))))
                .with(ItemEntry.builder(Items.IRON_INGOT).weight(5)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 8))))
                .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(4)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))))
                .with(ItemEntry.builder(Items.EMERALD).weight(3)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
                .with(ItemEntry.builder(Items.DIAMOND).weight(2)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))))
                .with(ItemEntry.builder(Items.BOOK).weight(2)
                        .apply(EnchantRandomlyLootFunction.create()))
                .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(1))
                .with(ItemEntry.builder(DeeperDarkerItems.WARDEN_CARAPACE).weight(1)))
                .pool(LootPool.builder().conditionally(WITHOUT_SILK_TOUCH)
                        .rolls(ConstantLootNumberProvider.create(2.0f))
                        .with(ItemEntry.builder(Blocks.COBWEB).weight(13)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))))
                        .with(ItemEntry.builder(Items.REDSTONE).weight(7)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 6))))
                        .with(ItemEntry.builder(Items.STICK).weight(7)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))))
                        .with(ItemEntry.builder(Items.ROTTEN_FLESH).weight(5)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(Items.STRING).weight(5)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4))))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI).weight(4)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 6))))
                        .with(ItemEntry.builder(Blocks.SAND).weight(3)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2))))));
        this.addDropWithSilkTouch(DeeperDarkerBlocks.CRYSTALLIZED_AMBER);
        this.addDropWithSilkTouch(DeeperDarkerBlocks.INFESTED_SCULK, Blocks.SCULK);
    }
}