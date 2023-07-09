package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
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
        this.addDrop(DeeperDarkerBlocks.ECHO_LEAVES);
        this.addDrop(DeeperDarkerBlocks.ECHO_PLANKS);
        this.addDrop(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE);
        this.addDrop(DeeperDarkerBlocks.ECHO_SAPLING);
        this.addDrop(DeeperDarkerBlocks.ECHO_SIGN);
        this.addDrop(DeeperDarkerBlocks.ECHO_WALL_SIGN);
        this.addDrop(DeeperDarkerBlocks.ECHO_SLAB);
        this.addDrop(DeeperDarkerBlocks.ECHO_STAIRS);
        this.addDrop(DeeperDarkerBlocks.ECHO_TRAPDOOR);
        this.addDrop(DeeperDarkerBlocks.SCULK_STONE);
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
    }
}