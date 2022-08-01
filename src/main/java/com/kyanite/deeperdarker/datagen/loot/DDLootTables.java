package com.kyanite.deeperdarker.datagen.loot;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class DDLootTables extends BlockLoot {
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

        this.dropSelf(DDBlocks.SCULK_STONE.get());
        this.add(DDBlocks.SCULK_STONE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(DDBlocks.SCULK_STONE_STAIRS.get());
        this.dropSelf(DDBlocks.SCULK_STONE_WALL.get());
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
        this.add(DDBlocks.SCULK_VINES.get(), BlockLoot::createShearsOnlyDrop);
        this.add(DDBlocks.SCULK_VINES_PLANT.get(), BlockLoot::createShearsOnlyDrop);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
