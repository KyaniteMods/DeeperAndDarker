package com.nitro.deeperdarker.datagen.loot;

import com.nitro.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.loot.BlockLoot;
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
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
