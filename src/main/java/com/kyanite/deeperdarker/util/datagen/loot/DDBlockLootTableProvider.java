package com.kyanite.deeperdarker.util.datagen.loot;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.vegetation.GlowingVinesPlantBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
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
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class DDBlockLootTableProvider extends FabricBlockLootTableProvider {
    public DDBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dropSelf(DDBlocks.ENRICHED_ECHO_LOG);
        dropSelf(DDBlocks.ECHO_LOG);
        dropSelf(DDBlocks.ECHO_WOOD);
        dropSelf(DDBlocks.STRIPPED_ECHO_LOG);
        dropSelf(DDBlocks.STRIPPED_ECHO_WOOD);
        dropSelf(DDBlocks.ECHO_PLANKS);
        dropSelf(DDBlocks.ECHO_STAIRS);
        add(DDBlocks.ECHO_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.ECHO_FENCE);
        dropSelf(DDBlocks.ECHO_FENCE_GATE);
        add(DDBlocks.ECHO_DOOR, this::createDoorTable);
        dropSelf(DDBlocks.ECHO_TRAPDOOR);
        dropSelf(DDBlocks.ECHO_PRESSURE_PLATE);
        dropSelf(DDBlocks.ECHO_BUTTON);
        add(DDBlocks.ECHO_LEAVES, (block) -> this.createLeavesDrops(block, DDBlocks.ECHO_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(DDBlocks.ECHO_SAPLING);
        dropSelf(DDBlocks.ECHO_SIGN);
        dropSelf(DDBlocks.ECHO_HANGING_SIGN);
        dropPottedContents(DDBlocks.POTTED_ECHO_SAPLING);
        dropPottedContents(DDBlocks.POTTED_BLOOMING_STEM);

        dropSelf(DDBlocks.BLOOMING_STEM);
        dropSelf(DDBlocks.STRIPPED_BLOOMING_STEM);
        dropSelf(DDBlocks.BLOOM_PLANKS);
        dropSelf(DDBlocks.BLOOM_STAIRS);
        dropSelf(DDBlocks.BLOOM_SLAB);
        dropSelf(DDBlocks.BLOOM_FENCE);
        dropSelf(DDBlocks.BLOOM_FENCE_GATE);
        add(DDBlocks.BLOOM_DOOR, this::createDoorTable);
        dropSelf(DDBlocks.BLOOM_TRAPDOOR);
        dropSelf(DDBlocks.BLOOM_PRESSURE_PLATE);
        dropSelf(DDBlocks.BLOOM_BUTTON);
        dropSelf(DDBlocks.BLOOM_SIGN);
        dropSelf(DDBlocks.BLOOM_HANGING_SIGN);

        add(DDBlocks.SCULK_STONE, (block) -> this.createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_SCULK_STONE));
        dropSelf(DDBlocks.SCULK_STONE_STAIRS);
        add(DDBlocks.SCULK_STONE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_STONE_WALL);
        dropSelf(DDBlocks.COBBLED_SCULK_STONE);
        dropSelf(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        add(DDBlocks.COBBLED_SCULK_STONE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.COBBLED_SCULK_STONE_WALL);
        dropSelf(DDBlocks.POLISHED_SCULK_STONE);
        dropSelf(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        add(DDBlocks.POLISHED_SCULK_STONE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.POLISHED_SCULK_STONE_WALL);
        dropSelf(DDBlocks.SCULK_STONE_BRICKS);
        dropSelf(DDBlocks.SCULK_STONE_BRICK_STAIRS);
        add(DDBlocks.SCULK_STONE_BRICK_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_STONE_BRICK_WALL);
        dropSelf(DDBlocks.SCULK_STONE_TILES);
        dropSelf(DDBlocks.SCULK_STONE_TILE_STAIRS);
        add(DDBlocks.SCULK_STONE_TILE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_STONE_TILE_WALL);
        dropSelf(DDBlocks.SMOOTH_SCULK_STONE);
        dropSelf(DDBlocks.SMOOTH_SCULK_STONE_STAIRS);
        add(DDBlocks.SMOOTH_SCULK_STONE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.SMOOTH_SCULK_STONE_WALL);
        dropSelf(DDBlocks.CUT_SCULK_STONE);
        dropSelf(DDBlocks.CUT_SCULK_STONE_STAIRS);
        add(DDBlocks.CUT_SCULK_STONE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.CUT_SCULK_STONE_WALL);
        dropSelf(DDBlocks.CHISELED_SCULK_STONE);

        add(DDBlocks.SCULK_GRIME, (block) -> this.createSingleItemTableWithSilkTouch(block, DDItems.GRIME_BALL, UniformGenerator.between(2, 4)));
        dropSelf(DDBlocks.SCULK_GRIME_BRICKS);
        dropSelf(DDBlocks.SCULK_GRIME_BRICK_STAIRS);
        add(DDBlocks.SCULK_GRIME_BRICK_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_GRIME_BRICK_WALL);

        add(DDBlocks.BLOOMING_SCULK_STONE, (block) -> this.createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_SCULK_STONE));
        dropSelf(DDBlocks.BLOOMING_MOSS_BLOCK);

        add(DDBlocks.GLOOMSLATE, (block) -> this.createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_GLOOMSLATE));
        dropSelf(DDBlocks.GLOOMSLATE_STAIRS);
        add(DDBlocks.GLOOMSLATE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.GLOOMSLATE_WALL);
        dropSelf(DDBlocks.COBBLED_GLOOMSLATE);
        dropSelf(DDBlocks.COBBLED_GLOOMSLATE_STAIRS);
        add(DDBlocks.COBBLED_GLOOMSLATE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.COBBLED_GLOOMSLATE_WALL);
        dropSelf(DDBlocks.POLISHED_GLOOMSLATE);
        dropSelf(DDBlocks.POLISHED_GLOOMSLATE_STAIRS);
        add(DDBlocks.POLISHED_GLOOMSLATE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.POLISHED_GLOOMSLATE_WALL);
        dropSelf(DDBlocks.GLOOMSLATE_BRICKS);
        dropSelf(DDBlocks.GLOOMSLATE_BRICK_STAIRS);
        add(DDBlocks.GLOOMSLATE_BRICK_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.GLOOMSLATE_BRICK_WALL);
        dropSelf(DDBlocks.GLOOMSLATE_TILES);
        dropSelf(DDBlocks.GLOOMSLATE_TILE_STAIRS);
        add(DDBlocks.GLOOMSLATE_TILE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.GLOOMSLATE_TILE_WALL);
        dropSelf(DDBlocks.SMOOTH_GLOOMSLATE);
        dropSelf(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS);
        add(DDBlocks.SMOOTH_GLOOMSLATE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.SMOOTH_GLOOMSLATE_WALL);
        dropSelf(DDBlocks.CUT_GLOOMSLATE);
        dropSelf(DDBlocks.CUT_GLOOMSLATE_STAIRS);
        add(DDBlocks.CUT_GLOOMSLATE_SLAB, this::createSlabItemTable);
        dropSelf(DDBlocks.CUT_GLOOMSLATE_WALL);
        dropSelf(DDBlocks.CHISELED_GLOOMSLATE);

        dropSelf(DDBlocks.ECHO_SOIL);
        dropWhenSilkTouch(DDBlocks.GLOOMY_SCULK);
        dropWhenSilkTouch(DDBlocks.CRYSTALLIZED_AMBER);
        dropSelf(DDBlocks.SCULK_GLEAM);
        dropWhenSilkTouch(DDBlocks.SCULK_JAW);

        add(DDBlocks.SCULK_STONE_COAL_ORE, (block) -> this.createOreDrop(block, Items.COAL));
        add(DDBlocks.SCULK_STONE_IRON_ORE, (block) -> this.createOreDrop(block, Items.RAW_IRON));
        add(DDBlocks.SCULK_STONE_COPPER_ORE, this::createCopperOreDrops);
        add(DDBlocks.SCULK_STONE_GOLD_ORE, (block) -> this.createOreDrop(block, Items.RAW_GOLD));
        add(DDBlocks.SCULK_STONE_REDSTONE_ORE, this::createRedstoneOreDrops);
        add(DDBlocks.SCULK_STONE_EMERALD_ORE, (block) -> this.createOreDrop(block, Items.EMERALD));
        add(DDBlocks.SCULK_STONE_LAPIS_ORE, this::createLapisOreDrops);
        add(DDBlocks.SCULK_STONE_DIAMOND_ORE, (block) -> this.createOreDrop(block, Items.DIAMOND));
        add(DDBlocks.GLOOMSLATE_COAL_ORE, (block) -> this.createOreDrop(block, Items.COAL));
        add(DDBlocks.GLOOMSLATE_IRON_ORE, (block) -> this.createOreDrop(block, Items.RAW_IRON));
        add(DDBlocks.GLOOMSLATE_COPPER_ORE, this::createCopperOreDrops);
        add(DDBlocks.GLOOMSLATE_GOLD_ORE, (block) -> this.createOreDrop(block, Items.RAW_GOLD));
        add(DDBlocks.GLOOMSLATE_REDSTONE_ORE, this::createRedstoneOreDrops);
        add(DDBlocks.GLOOMSLATE_EMERALD_ORE, (block) -> this.createOreDrop(block, Items.EMERALD));
        add(DDBlocks.GLOOMSLATE_LAPIS_ORE, this::createLapisOreDrops);
        add(DDBlocks.GLOOMSLATE_DIAMOND_ORE, (block) -> this.createOreDrop(block, Items.DIAMOND));

        add(DDBlocks.GLOOMY_GRASS, BlockLootSubProvider::createShearsOnlyDrop);
        dropSelf(DDBlocks.GLOOMY_CACTUS);
        addVineAndPlant(DDBlocks.SCULK_TENDRILS_PLANT, DDBlocks.SCULK_TENDRILS);
        addVineAndPlant(DDBlocks.SCULK_VINES_PLANT, DDBlocks.SCULK_VINES);
        addVineAndPlant(DDBlocks.GLOWING_ROOTS_PLANT, DDBlocks.GLOWING_ROOTS);
        add(DDBlocks.GLOWING_VINES_PLANT, this::glowingVinesDrop);
        dropSelf(DDBlocks.ICE_LILY);

        ancientVaseDrop();

        otherWhenSilkTouch(DDBlocks.INFESTED_SCULK, Blocks.SCULK);

        dropSelf(DDBlocks.SOUNDPROOF_GLASS);
    }

    private void addVineAndPlant(Block plant, Block vine) {
        LootTable.Builder builder = createSilkTouchOrShearsDispatchTable(vine, LootItem.lootTableItem(vine).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33f, 0.55f, 0.77f, 1.0f)));
        add(plant, builder);
        add(vine, builder);
    }

    private LootTable.Builder glowingVinesDrop(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(DDItems.BLOOM_BERRIES)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlowingVinesPlantBlock.BERRIES, true))));
    }

    private void ancientVaseDrop() {
        add(DDBlocks.ANCIENT_VASE, LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_SILK_TOUCH).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDBlocks.ANCIENT_VASE))).withPool(LootPool.lootPool().when(HAS_NO_SILK_TOUCH).setRolls(UniformGenerator.between(1, 3)).add(EmptyLootItem.emptyItem().setWeight(20)).add(LootItem.lootTableItem(Blocks.SAND).setWeight(11).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))).add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 9)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(9).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 8)))).add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(6).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))).add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 8)))).add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.EMERALD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.DIAMOND).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.BOOK).setWeight(2).apply(EnchantRandomlyFunction.randomApplicableEnchantment())).add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1)).add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).setWeight(1))).withPool(LootPool.lootPool().when(HAS_NO_SILK_TOUCH).setRolls(ConstantValue.exactly(2)).add(LootItem.lootTableItem(Blocks.COBWEB).setWeight(13).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.REDSTONE).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6)))).add(LootItem.lootTableItem(Items.STICK).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.STRING).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 6)))).add(LootItem.lootTableItem(Blocks.SAND).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));
    }
}