package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.registries.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagsProvider extends BlockTagsProvider {
    public DDBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_AXE).addTag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_PLANKS.get(), DDBlocks.ECHO_STAIRS.get(), DDBlocks.ECHO_SLAB.get(), DDBlocks.ECHO_FENCE.get(), DDBlocks.ECHO_FENCE_GATE.get(), DDBlocks.ECHO_DOOR.get(), DDBlocks.ECHO_TRAPDOOR.get(), DDBlocks.ECHO_PRESSURE_PLATE.get(), DDBlocks.ECHO_BUTTON.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.ECHO_LEAVES.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS);
        tag(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(DDBlocks.ECHO_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(DDBlocks.ECHO_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(DDBlocks.ECHO_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(DDBlocks.ECHO_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.ECHO_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.ECHO_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(DDBlocks.ECHO_BUTTON.get());
        tag(BlockTags.LEAVES).add(DDBlocks.ECHO_LEAVES.get());
        tag(BlockTags.STANDING_SIGNS).add(DDBlocks.ECHO_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DDBlocks.ECHO_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(DDBlocks.ECHO_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(DDBlocks.ECHO_WALL_HANGING_SIGN.get());

        tag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG.get(), DDBlocks.ECHO_WOOD.get(), DDBlocks.STRIPPED_ECHO_LOG.get(), DDBlocks.STRIPPED_ECHO_WOOD.get());
    }
}
