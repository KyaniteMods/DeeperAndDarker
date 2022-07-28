package com.nitro.deeperdarker.datagen.tags;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.registry.blocks.DDBlocks;
import com.nitro.deeperdarker.util.DDTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DDBlockTagsProvider extends BlockTagsProvider {
    public DDBlockTagsProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE).addTag(DDTags.Blocks.BONE_WOOD);
        tag(BlockTags.MINEABLE_WITH_HOE).addTag(DDTags.Blocks.SCULK_BONE_WOOD);
        tag(BlockTags.FENCE_GATES).add(DDBlocks.BONE_FENCE_GATE.get(), DDBlocks.SCULK_BONE_FENCE_GATE.get());
        tag(BlockTags.NON_FLAMMABLE_WOOD).addTags(DDTags.Blocks.BONE_WOOD, DDTags.Blocks.SCULK_BONE_WOOD);
        tag(BlockTags.PLANKS).add(DDBlocks.BONE_PLANKS.get(), DDBlocks.SCULK_BONE_PLANKS.get());
        tag(BlockTags.PRESSURE_PLATES).add(DDBlocks.BONE_PRESSURE_PLATE.get(), DDBlocks.SCULK_BONE_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(DDBlocks.BONE_BUTTON.get(), DDBlocks.SCULK_BONE_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS).add(DDBlocks.BONE_DOOR.get(), DDBlocks.SCULK_BONE_DOOR.get());
        tag(BlockTags.WOODEN_FENCES).add(DDBlocks.BONE_FENCE.get(), DDBlocks.SCULK_BONE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(DDBlocks.BONE_FENCE_GATE.get(), DDBlocks.SCULK_BONE_FENCE_GATE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.BONE_PRESSURE_PLATE.get(), DDBlocks.SCULK_BONE_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_SLABS).add(DDBlocks.BONE_SLAB.get(), DDBlocks.SCULK_BONE_SLAB.get());
        tag(BlockTags.WOODEN_STAIRS).add(DDBlocks.BONE_STAIRS.get(), DDBlocks.SCULK_BONE_STAIRS.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.BONE_TRAPDOOR.get(), DDBlocks.SCULK_BONE_TRAPDOOR.get());

        tag(DDTags.Blocks.BONE_WOOD).add(DDBlocks.BONE_PLANKS.get(), DDBlocks.BONE_SLAB.get(), DDBlocks.BONE_STAIRS.get(), DDBlocks.BONE_FENCE.get(), DDBlocks.BONE_BUTTON.get(), DDBlocks.BONE_PRESSURE_PLATE.get(), DDBlocks.BONE_DOOR.get(), DDBlocks.BONE_TRAPDOOR.get(), DDBlocks.BONE_FENCE_GATE.get());
        tag(DDTags.Blocks.SCULK_BONE_WOOD).add(DDBlocks.SCULK_BONE_BLOCK.get(), DDBlocks.SCULK_BONE_PLANKS.get(), DDBlocks.SCULK_BONE_SLAB.get(), DDBlocks.SCULK_BONE_STAIRS.get(), DDBlocks.SCULK_BONE_FENCE.get(), DDBlocks.SCULK_BONE_BUTTON.get(), DDBlocks.SCULK_BONE_PRESSURE_PLATE.get(), DDBlocks.SCULK_BONE_DOOR.get(), DDBlocks.SCULK_BONE_TRAPDOOR.get(), DDBlocks.SCULK_BONE_FENCE_GATE.get());
        tag(DDTags.Blocks.SCULK_BLOCKS).add(Blocks.SCULK, Blocks.SCULK_CATALYST, Blocks.SCULK_SENSOR, Blocks.SCULK_SHRIEKER, Blocks.SCULK_VEIN).addTag(DDTags.Blocks.SCULK_BONE_WOOD);
    }
}
