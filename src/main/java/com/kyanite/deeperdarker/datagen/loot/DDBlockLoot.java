package com.kyanite.deeperdarker.datagen.loot;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.gloomvines.GloomVines;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockLoot extends BlockLoot {
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
        this.dropWhenSilkTouch(DDBlocks.ANCIENT_VASE.get());
        this.add(DDBlocks.SCULK_VINES.get(), BlockLoot::createShearsOnlyDrop);
        this.add(DDBlocks.SCULK_VINES_PLANT.get(), BlockLoot::createShearsOnlyDrop);
        this.add(DDBlocks.GLOOM_VINES.get(), DDBlockLoot::createGloomVinesDrop);
        this.add(DDBlocks.GLOOM_VINES_PLANT.get(), DDBlockLoot::createGloomVinesDrop);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected static LootTable.Builder createGloomVinesDrop(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(DDItems.GLOOM_BERRIES.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GloomVines.BERRIES, true))));
    }
}
