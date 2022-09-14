package com.kyanite.deeperdarker.datagen.loot;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.BloomBerryBushBlock;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
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
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class DDBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(DDBlocks.ECHO_PLANKS.get());
        this.dropSelf(DDBlocks.ECHO_LOG.get());
        this.dropSelf(DDBlocks.STRIPPED_ECHO_LOG.get());
        this.dropSelf(DDBlocks.STRIPPED_ECHO_WOOD.get());
        this.dropSelf(DDBlocks.ECHO_WOOD.get());
        this.add(DDBlocks.ECHO_LEAVES.get(), block -> createSilkTouchOrShearsDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK)).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.5f))));
        this.add(DDBlocks.ECHO_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.ECHO_FENCE.get());
        this.dropSelf(DDBlocks.ECHO_STAIRS.get());
        this.dropSelf(DDBlocks.ECHO_BUTTON.get());
        this.dropSelf(DDBlocks.ECHO_PRESSURE_PLATE.get());
        this.add(DDBlocks.ECHO_DOOR.get(), BlockLoot::createDoorTable);
        this.dropSelf(DDBlocks.ECHO_TRAPDOOR.get());
        this.dropSelf(DDBlocks.ECHO_FENCE_GATE.get());
        this.dropSelf(DDBlocks.ECHO_SIGN.get());
        this.dropSelf(DDBlocks.ECHO_WALL_SIGN.get());

        this.add(DDBlocks.SCULK_STONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_SCULK_STONE.get()));
        this.add(DDBlocks.SCULK_STONE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.SCULK_STONE_STAIRS.get());
        this.dropSelf(DDBlocks.SCULK_STONE_WALL.get());

        this.dropSelf(DDBlocks.COBBLED_SCULK_STONE.get());
        this.add(DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get());
        this.dropSelf(DDBlocks.COBBLED_SCULK_STONE_WALL.get());

        this.dropSelf(DDBlocks.POLISHED_SCULK_STONE.get());
        this.add(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get());
        this.dropSelf(DDBlocks.POLISHED_SCULK_STONE_WALL.get());

        this.dropSelf(DDBlocks.SCULK_STONE_BRICKS.get());
        this.add(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.SCULK_STONE_BRICK_STAIRS.get());
        this.dropSelf(DDBlocks.SCULK_STONE_BRICK_WALL.get());

        this.add(DDBlocks.SCULK_STONE_COAL_ORE.get(), (block) -> sculkOreDrop(block, Items.COAL));
        this.add(DDBlocks.SCULK_STONE_IRON_ORE.get(), (block) -> sculkOreDrop(block, Items.RAW_IRON));
        this.add(DDBlocks.SCULK_STONE_COPPER_ORE.get(), (block) -> sculkOreDrop(block, Items.RAW_COPPER));
        this.add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), (block) -> sculkOreDrop(block, Items.RAW_GOLD));
        this.add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), (block) -> sculkOreDrop(block, Items.REDSTONE));
        this.add(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), (block) -> sculkOreDrop(block, Items.EMERALD));
        this.add(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), (block) -> sculkOreDrop(block, Items.LAPIS_LAZULI));
        this.add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), (block) -> sculkOreDrop(block, Items.DIAMOND));
        this.dropWhenSilkTouch(DDBlocks.INFESTED_SCULK.get());

        this.addVineAndPlant(DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get());
        this.addVineAndPlant(DDBlocks.SCULK_TENDRILS.get(), DDBlocks.SCULK_TENDRILS_PLANT.get());

        this.dropWhenSilkTouch(DDBlocks.SCULK_GLEAM.get());
        this.dropSelf(DDBlocks.ECHO_SOIL.get());
        this.dropWhenSilkTouch(DDBlocks.SCULK_JAW.get());

        this.dropSelf(DDBlocks.BLOOMING_GRASS_BLOCK.get());
        this.add(DDBlocks.BLOOMING_SHRUB.get(), BlockLoot::createShearsOnlyDrop);
        this.add(DDBlocks.BLOOM_BERRY_BUSH.get(), block -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(DDBlocks.BLOOM_BERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BloomBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(DDItems.BLOOM_BERRIES.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(DDBlocks.BLOOM_BERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BloomBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(DDItems.BLOOM_BERRIES.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.dropWhenSilkTouch(DDBlocks.GLOOM_SCULK.get());
        this.dropSelf(DDBlocks.GLOOMSLATE.get());
        this.add(DDBlocks.GLOOMSLATE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.GLOOMSLATE_STAIRS.get());
        this.dropSelf(DDBlocks.GLOOMSLATE_WALL.get());
        this.dropWhenSilkTouch(DDBlocks.GEYSER.get());
        this.dropSelf(DDBlocks.CRYSTALLIZED_AMBER.get());
        this.dropSelf(DDBlocks.GLOOM_CACTUS.get());
        this.add(DDBlocks.GLOOMY_GRASS.get(), BlockLoot::createShearsOnlyDrop);

        this.add(DDBlocks.ANCIENT_VASE.get(), DDBlockLoot::ancientVaseDrop);
    }

    private static LootTable.Builder sculkOreDrop(Block block, Item item) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    private void addVineAndPlant(Block vines, Block plant) {
        LootTable.Builder builder = createSilkTouchOrShearsDispatchTable(vines, LootItem.lootTableItem(vines).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F)));
        this.add(vines, builder);
        this.add(plant, builder);
    }

    private static LootTable.Builder ancientVaseDrop(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 3)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.DIAMOND).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.EMERALD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Blocks.SAND).setWeight(6)).add(LootItem.lootTableItem(Items.BOOK).setWeight(2).apply(EnchantRandomlyFunction.randomApplicableEnchantment())).add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1)).add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE.get()).setWeight(1)).add(EmptyLootItem.emptyItem().setWeight(18))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2)).add(LootItem.lootTableItem(Blocks.SAND).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.STRING).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))));
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
