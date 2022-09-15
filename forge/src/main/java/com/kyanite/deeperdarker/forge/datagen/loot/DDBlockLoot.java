package com.kyanite.deeperdarker.forge.datagen.loot;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class DDBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(DDBlocks.ECHO_PLANKS);
        this.dropSelf(DDBlocks.ECHO_LOG);
        this.dropSelf(DDBlocks.STRIPPED_ECHO_LOG);
        this.dropSelf(DDBlocks.STRIPPED_ECHO_WOOD);
        this.dropSelf(DDBlocks.ECHO_WOOD);
        this.dropSelf(DDBlocks.ECHO_LEAVES);
        this.add(DDBlocks.ECHO_SLAB, BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.ECHO_FENCE);
        this.dropSelf(DDBlocks.ECHO_STAIRS);
        this.dropSelf(DDBlocks.ECHO_BUTTON);
        this.dropSelf(DDBlocks.ECHO_PRESSURE_PLATE);
        this.add(DDBlocks.ECHO_DOOR, BlockLoot::createDoorTable);
        this.dropSelf(DDBlocks.ECHO_TRAPDOOR);
        this.dropSelf(DDBlocks.ECHO_FENCE_GATE);
        this.dropSelf(DDBlocks.ECHO_SIGN);
        this.dropSelf(DDBlocks.ECHO_WALL_SIGN);

        this.add(DDBlocks.SCULK_STONE, (block) -> createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_SCULK_STONE));
        this.add(DDBlocks.SCULK_STONE_SLAB, BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.SCULK_STONE_STAIRS);
        this.dropSelf(DDBlocks.SCULK_STONE_WALL);

        this.dropSelf(DDBlocks.COBBLED_SCULK_STONE);
        this.add(DDBlocks.COBBLED_SCULK_STONE_SLAB, BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        this.dropSelf(DDBlocks.COBBLED_SCULK_STONE_WALL);

        this.dropSelf(DDBlocks.POLISHED_SCULK_STONE);
        this.add(DDBlocks.POLISHED_SCULK_STONE_SLAB, BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        this.dropSelf(DDBlocks.POLISHED_SCULK_STONE_WALL);

        this.dropSelf(DDBlocks.SCULK_STONE_BRICKS);
        this.add(DDBlocks.SCULK_STONE_BRICK_SLAB, BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.SCULK_STONE_BRICK_STAIRS);
        this.dropSelf(DDBlocks.SCULK_STONE_BRICK_WALL);

        this.add(DDBlocks.SCULK_STONE_COAL_ORE, (block) -> sculkOreDrop(block, Items.COAL));
        this.add(DDBlocks.SCULK_STONE_IRON_ORE, (block) -> sculkOreDrop(block, Items.RAW_IRON));
        this.add(DDBlocks.SCULK_STONE_COPPER_ORE, (block) -> sculkOreDrop(block, Items.RAW_COPPER));
        this.add(DDBlocks.SCULK_STONE_GOLD_ORE, (block) -> sculkOreDrop(block, Items.RAW_GOLD));
        this.add(DDBlocks.SCULK_STONE_REDSTONE_ORE, (block) -> sculkOreDrop(block, Items.REDSTONE));
        this.add(DDBlocks.SCULK_STONE_EMERALD_ORE, (block) -> sculkOreDrop(block, Items.EMERALD));
        this.add(DDBlocks.SCULK_STONE_LAPIS_ORE, (block) -> sculkOreDrop(block, Items.LAPIS_LAZULI));
        this.add(DDBlocks.SCULK_STONE_DIAMOND_ORE, (block) -> sculkOreDrop(block, Items.DIAMOND));
        this.dropWhenSilkTouch(DDBlocks.INFESTED_SCULK);

        this.addSculkVinesDropTable(DDBlocks.SCULK_VINES, DDBlocks.SCULK_VINES_PLANT);

        this.dropWhenSilkTouch(DDBlocks.SCULK_GLEAM);
        this.dropSelf(DDBlocks.ECHO_SOIL);

        this.dropWhenSilkTouch(DDBlocks.SCULK_JAW);
        this.add(DDBlocks.ANCIENT_VASE, DDBlockLoot::addAncientVaseDropTable);
    }

    private static LootTable.Builder sculkOreDrop(Block block, Item item) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    private void addSculkVinesDropTable(Block vines, Block plant) {
        LootTable.Builder builder = createSilkTouchOrShearsDispatchTable(vines, LootItem.lootTableItem(vines).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F)));
        this.add(vines, builder);
        this.add(plant, builder);
    }

    private static LootTable.Builder addAncientVaseDropTable(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 3)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.DIAMOND).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.EMERALD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Blocks.SAND).setWeight(6)).add(LootItem.lootTableItem(Items.BOOK).setWeight(2).apply(EnchantRandomlyFunction.randomApplicableEnchantment())).add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1)).add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).setWeight(1)).add(EmptyLootItem.emptyItem().setWeight(18))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2)).add(LootItem.lootTableItem(Blocks.SAND).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.STRING).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))));
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.values().stream()::iterator;
    }
}
