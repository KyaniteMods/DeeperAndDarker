package com.kyanite.deeperdarker.datagen.loot;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.gloomvines.GloomVines;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockLoot extends BlockLoot {
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));

    @Override
    protected void addTables() {
        this.dropSelf(DDBlocks.BONE_PLANKS.get());
        this.add(DDBlocks.BONE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.BONE_STAIRS.get());
        this.dropSelf(DDBlocks.BONE_FENCE.get());
        this.dropSelf(DDBlocks.BONE_BUTTON.get());
        this.dropSelf(DDBlocks.BONE_PRESSURE_PLATE.get());
        this.add(DDBlocks.BONE_DOOR.get(), BlockLoot::createDoorTable);
        this.dropSelf(DDBlocks.BONE_TRAPDOOR.get());
        this.dropSelf(DDBlocks.BONE_FENCE_GATE.get());
        this.dropSelf(DDBlocks.BONE_WALL_SIGN.get());
        this.dropSelf(DDBlocks.BONE_SIGN.get());
        this.dropWhenSilkTouch(DDBlocks.GLOOM_GRASS.get());

        this.dropSelf(DDBlocks.SCULK_BONE_BLOCK.get());
        this.dropSelf(DDBlocks.SCULK_BONE_PLANKS.get());
        this.add(DDBlocks.SCULK_BONE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.SCULK_BONE_STAIRS.get());
        this.dropSelf(DDBlocks.SCULK_BONE_FENCE.get());
        this.dropSelf(DDBlocks.SCULK_BONE_BUTTON.get());
        this.dropSelf(DDBlocks.SCULK_BONE_PRESSURE_PLATE.get());
        this.add(DDBlocks.SCULK_BONE_DOOR.get(), BlockLoot::createDoorTable);
        this.dropSelf(DDBlocks.SCULK_BONE_TRAPDOOR.get());
        this.dropSelf(DDBlocks.SCULK_BONE_FENCE_GATE.get());
        this.dropSelf(DDBlocks.SCULK_BONE_WALL_SIGN.get());
        this.dropSelf(DDBlocks.SCULK_BONE_SIGN.get());

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

        this.add(DDBlocks.SCULK_STONE_COAL_ORE.get(), (block) -> createOreDrop(block, Items.COAL));
        this.add(DDBlocks.SCULK_STONE_IRON_ORE.get(), (block) -> createOreDrop(block, Items.RAW_IRON));
        this.add(DDBlocks.SCULK_STONE_COPPER_ORE.get(), (block) -> createCopperOreDrops(DDBlocks.SCULK_STONE_COPPER_ORE.get()));
        this.add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), (block) -> createOreDrop(block, Items.RAW_GOLD));
        this.add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), (block) -> createRedstoneOreDrops(DDBlocks.SCULK_STONE_REDSTONE_ORE.get()));
        this.add(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), (block) -> createOreDrop(block, Items.EMERALD));
        this.add(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), (block) -> createLapisOreDrops(DDBlocks.SCULK_STONE_LAPIS_ORE.get()));
        this.add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), (block) -> createOreDrop(block, Items.DIAMOND));

        this.dropWhenSilkTouch(DDBlocks.SCULK_GLEAM.get());
        this.dropWhenSilkTouch(DDBlocks.INFESTED_SCULK.get());
        this.addSculkVinesDropTable(DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get());
        this.add(DDBlocks.GLOOM_VINES.get(), DDBlockLoot::createGloomVinesDropTable);
        this.add(DDBlocks.GLOOM_VINES_PLANT.get(), DDBlockLoot::createGloomVinesDropTable);

        this.dropSelf(DDBlocks.SCULK_TRANSMITTER.get());

        this.add(DDBlocks.ANCIENT_VASE.get(), DDBlockLoot::addAncientVaseDropTable);
    }

    private static LootTable.Builder createGloomVinesDropTable(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(DDItems.GLOOM_BERRIES.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GloomVines.BERRIES, true))));
    }

    private void addSculkVinesDropTable(Block vines, Block plant) {
        LootTable.Builder builder = createSilkTouchOrShearsDispatchTable(vines, LootItem.lootTableItem(vines).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F)));
        this.add(vines, builder);
        this.add(plant, builder);
    }

    private static LootTable.Builder addAncientVaseDropTable(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 4.0F)).add(LootItem.lootTableItem(Items.DIAMOND).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))).add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 7.0F)))).add(LootItem.lootTableItem(Items.EMERALD).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.BONE).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 6.0F)))).add(LootItem.lootTableItem(Items.SPIDER_EYE).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))).add(LootItem.lootTableItem(Items.SADDLE).setWeight(20)).add(LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(15)).add(LootItem.lootTableItem(Items.GOLDEN_HORSE_ARMOR).setWeight(10)).add(LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR).setWeight(5)).add(LootItem.lootTableItem(Items.BOOK).setWeight(20).apply(EnchantRandomlyFunction.randomApplicableEnchantment())).add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(20)).add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(2)).add(EmptyLootItem.emptyItem().setWeight(15))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).add(LootItem.lootTableItem(Items.BONE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F)))).add(LootItem.lootTableItem(Items.GUNPOWDER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F)))).add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F)))).add(LootItem.lootTableItem(Blocks.SAND).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
