package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.vegetation.GlowingVinesPlantBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DDBlockLoot extends BlockLootSubProvider {
    protected DDBlockLoot(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(DDBlocks.ECHO_LOG.get());
        dropSelf(DDBlocks.ECHO_WOOD.get());
        dropSelf(DDBlocks.STRIPPED_ECHO_LOG.get());
        dropSelf(DDBlocks.STRIPPED_ECHO_WOOD.get());
        dropSelf(DDBlocks.ECHO_PLANKS.get());
        dropSelf(DDBlocks.ECHO_STAIRS.get());
        add(DDBlocks.ECHO_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.ECHO_FENCE.get());
        dropSelf(DDBlocks.ECHO_FENCE_GATE.get());
        add(DDBlocks.ECHO_DOOR.get(), this::createDoorTable);
        dropSelf(DDBlocks.ECHO_TRAPDOOR.get());
        dropSelf(DDBlocks.ECHO_PRESSURE_PLATE.get());
        dropSelf(DDBlocks.ECHO_BUTTON.get());
        add(DDBlocks.ECHO_LEAVES.get(), (block) -> this.createLeavesDrops(block, DDBlocks.ECHO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(DDBlocks.ECHO_SAPLING.get());
        dropSelf(DDBlocks.ECHO_SIGN.get());
        dropSelf(DDBlocks.ECHO_HANGING_SIGN.get());
        dropPottedContents(DDBlocks.POTTED_ECHO_SAPLING.get());

        dropSelf(DDBlocks.BLOOMING_STEM.get());
        dropSelf(DDBlocks.STRIPPED_BLOOMING_STEM.get());
        dropSelf(DDBlocks.BLOOM_PLANKS.get());
        dropSelf(DDBlocks.BLOOM_STAIRS.get());
        add(DDBlocks.BLOOM_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.BLOOM_FENCE.get());
        dropSelf(DDBlocks.BLOOM_FENCE_GATE.get());
        add(DDBlocks.BLOOM_DOOR.get(), this::createDoorTable);
        dropSelf(DDBlocks.BLOOM_TRAPDOOR.get());
        dropSelf(DDBlocks.BLOOM_PRESSURE_PLATE.get());
        dropSelf(DDBlocks.BLOOM_BUTTON.get());
        dropSelf(DDBlocks.BLOOM_SIGN.get());
        dropSelf(DDBlocks.BLOOM_HANGING_SIGN.get());
        dropPottedContents(DDBlocks.POTTED_BLOOMING_STEM.get());

        add(DDBlocks.SCULK_STONE.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_SCULK_STONE.get()));
        dropSelf(DDBlocks.SCULK_STONE_STAIRS.get());
        add(DDBlocks.SCULK_STONE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_STONE_WALL.get());
        dropSelf(DDBlocks.COBBLED_SCULK_STONE.get());
        dropSelf(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get());
        add(DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.COBBLED_SCULK_STONE_WALL.get());
        dropSelf(DDBlocks.POLISHED_SCULK_STONE.get());
        dropSelf(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get());
        add(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.POLISHED_SCULK_STONE_WALL.get());
        dropSelf(DDBlocks.SCULK_STONE_BRICKS.get());
        dropSelf(DDBlocks.SCULK_STONE_BRICK_STAIRS.get());
        add(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_STONE_BRICK_WALL.get());
        dropSelf(DDBlocks.SCULK_STONE_TILES.get());
        dropSelf(DDBlocks.SCULK_STONE_TILE_STAIRS.get());
        add(DDBlocks.SCULK_STONE_TILE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_STONE_TILE_WALL.get());
        dropSelf(DDBlocks.SMOOTH_SCULK_STONE.get());
        dropSelf(DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get());
        add(DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.SMOOTH_SCULK_STONE_WALL.get());
        dropSelf(DDBlocks.CUT_SCULK_STONE.get());
        dropSelf(DDBlocks.CUT_SCULK_STONE_STAIRS.get());
        add(DDBlocks.CUT_SCULK_STONE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.CUT_SCULK_STONE_WALL.get());
        dropSelf(DDBlocks.CHISELED_SCULK_STONE.get());

        add(DDBlocks.BLOOMING_SCULK_STONE.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_SCULK_STONE.get()));
        dropSelf(DDBlocks.BLOOMING_MOSS_BLOCK.get());

        add(DDBlocks.GLOOMSLATE.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, DDBlocks.COBBLED_GLOOMSLATE.get()));
        dropSelf(DDBlocks.GLOOMSLATE_STAIRS.get());
        add(DDBlocks.GLOOMSLATE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.GLOOMSLATE_WALL.get());
        dropSelf(DDBlocks.COBBLED_GLOOMSLATE.get());
        dropSelf(DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get());
        add(DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.COBBLED_GLOOMSLATE_WALL.get());
        dropSelf(DDBlocks.POLISHED_GLOOMSLATE.get());
        dropSelf(DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get());
        add(DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.POLISHED_GLOOMSLATE_WALL.get());
        dropSelf(DDBlocks.GLOOMSLATE_BRICKS.get());
        dropSelf(DDBlocks.GLOOMSLATE_BRICK_STAIRS.get());
        add(DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.GLOOMSLATE_BRICK_WALL.get());
        dropSelf(DDBlocks.GLOOMSLATE_TILES.get());
        dropSelf(DDBlocks.GLOOMSLATE_TILE_STAIRS.get());
        add(DDBlocks.GLOOMSLATE_TILE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.GLOOMSLATE_TILE_WALL.get());
        dropSelf(DDBlocks.SMOOTH_GLOOMSLATE.get());
        dropSelf(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get());
        add(DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.SMOOTH_GLOOMSLATE_WALL.get());
        dropSelf(DDBlocks.CUT_GLOOMSLATE.get());
        dropSelf(DDBlocks.CUT_GLOOMSLATE_STAIRS.get());
        add(DDBlocks.CUT_GLOOMSLATE_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.CUT_GLOOMSLATE_WALL.get());
        dropSelf(DDBlocks.CHISELED_GLOOMSLATE.get());

        add(DDBlocks.SCULK_GRIME.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, DDItems.GRIME_BALL.get(), UniformGenerator.between(2, 4)));
        dropSelf(DDBlocks.SCULK_GRIME_BRICKS.get());
        dropSelf(DDBlocks.SCULK_GRIME_BRICK_STAIRS.get());
        add(DDBlocks.SCULK_GRIME_BRICK_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.SCULK_GRIME_BRICK_WALL.get());

        dropSelf(DDBlocks.ECHO_SOIL.get());
        dropWhenSilkTouch(DDBlocks.GLOOMY_SCULK.get());
        dropWhenSilkTouch(DDBlocks.GLOOMY_GEYSER.get());
        dropWhenSilkTouch(DDBlocks.CRYSTALLIZED_AMBER.get());
        dropSelf(DDBlocks.SCULK_GLEAM.get());
        dropSelf(DDBlocks.SOUNDPROOF_GLASS.get());

        add(DDBlocks.SCULK_STONE_COAL_ORE.get(), (block) -> this.createOreDrop(block, Items.COAL));
        add(DDBlocks.SCULK_STONE_IRON_ORE.get(), (block) -> this.createOreDrop(block, Items.RAW_IRON));
        add(DDBlocks.SCULK_STONE_COPPER_ORE.get(), this::createCopperOreDrops);
        add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), (block) -> this.createOreDrop(block, Items.RAW_GOLD));
        add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), this::createRedstoneOreDrops);
        add(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), (block) -> this.createOreDrop(block, Items.EMERALD));
        add(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), this::createLapisOreDrops);
        add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), (block) -> this.createOreDrop(block, Items.DIAMOND));
        add(DDBlocks.GLOOMSLATE_COAL_ORE.get(), (block) -> this.createOreDrop(block, Items.COAL));
        add(DDBlocks.GLOOMSLATE_IRON_ORE.get(), (block) -> this.createOreDrop(block, Items.RAW_IRON));
        add(DDBlocks.GLOOMSLATE_COPPER_ORE.get(), this::createCopperOreDrops);
        add(DDBlocks.GLOOMSLATE_GOLD_ORE.get(), (block) -> this.createOreDrop(block, Items.RAW_GOLD));
        add(DDBlocks.GLOOMSLATE_REDSTONE_ORE.get(), this::createRedstoneOreDrops);
        add(DDBlocks.GLOOMSLATE_EMERALD_ORE.get(), (block) -> this.createOreDrop(block, Items.EMERALD));
        add(DDBlocks.GLOOMSLATE_LAPIS_ORE.get(), this::createLapisOreDrops);
        add(DDBlocks.GLOOMSLATE_DIAMOND_ORE.get(), (block) -> this.createOreDrop(block, Items.DIAMOND));

        dropSelf(DDBlocks.GLOWING_FLOWERS.get());
        add(DDBlocks.GLOWING_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(DDBlocks.GLOOMY_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
        dropSelf(DDBlocks.GLOOMY_CACTUS.get());
        addNetherVinesDropTable(DDBlocks.SCULK_TENDRILS.get(), DDBlocks.SCULK_TENDRILS_PLANT.get());
        addNetherVinesDropTable(DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get());
        addNetherVinesDropTable(DDBlocks.GLOWING_ROOTS.get(), DDBlocks.GLOWING_ROOTS_PLANT.get());
        add(DDBlocks.GLOWING_VINES_PLANT.get(), this::glowingVinesDrop);
        dropSelf(DDBlocks.ICE_LILY.get());
        dropSelf(DDBlocks.LILY_FLOWER.get());

        ancientVaseDrop(DDBlocks.ANCIENT_VASE.get());
        otherWhenSilkTouch(DDBlocks.INFESTED_SCULK.get(), Blocks.SCULK);
        dropWhenSilkTouch(DDBlocks.SCULK_JAW.get());
    }

    private LootTable.Builder glowingVinesDrop(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(DDItems.BLOOM_BERRIES.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlowingVinesPlantBlock.BERRIES, true))));
    }

    private void ancientVaseDrop(Block block) {
        add(block, LootTable.lootTable().withPool(LootPool.lootPool().when(hasSilkTouch()).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block))).withPool(LootPool.lootPool().when(doesNotHaveSilkTouch()).setRolls(UniformGenerator.between(1, 2)).add(EmptyLootItem.emptyItem().setWeight(20)).add(LootItem.lootTableItem(Blocks.SAND).setWeight(11).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))).add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 9)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(9).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 8)))).add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(6).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))).add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 8)))).add(LootItem.lootTableItem(Items.GOLDEN_APPLE).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.EMERALD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))).add(LootItem.lootTableItem(Items.DIAMOND).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.BOOK).setWeight(2).apply(EnchantRandomlyFunction.randomApplicableEnchantment(this.registries))).add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1)).add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE.get()).setWeight(1))).withPool(LootPool.lootPool().when(hasSilkTouch()).setRolls(ConstantValue.exactly(2)).add(LootItem.lootTableItem(Blocks.COBWEB).setWeight(13).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.REDSTONE).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6)))).add(LootItem.lootTableItem(Items.STICK).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.STRING).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 6)))).add(LootItem.lootTableItem(Blocks.SAND).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(holder -> holder.getDelegate().value())::iterator;
    }
}
