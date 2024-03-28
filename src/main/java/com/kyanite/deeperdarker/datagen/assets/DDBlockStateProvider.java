package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.DDBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DDBlockStateProvider extends BlockStateProvider {

    public DDBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeeperDarker.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(DDBlocks.ECHO_LOG.value());
        axisBlock(DDBlocks.ECHO_WOOD.get(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG));
        logBlock(DDBlocks.STRIPPED_ECHO_LOG.value());
        axisBlock(DDBlocks.STRIPPED_ECHO_WOOD.get(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG));
        simpleBlock(DDBlocks.ECHO_PLANKS.value());
        stairsBlock(DDBlocks.ECHO_STAIRS.value(), blockLoc(DDBlocks.ECHO_PLANKS));
        slabBlock(DDBlocks.ECHO_SLAB.value(), blockLoc(DDBlocks.ECHO_PLANKS), blockLoc(DDBlocks.ECHO_PLANKS));
        fenceBlock(DDBlocks.ECHO_FENCE.value(), blockLoc(DDBlocks.ECHO_PLANKS));
        fenceGateBlock(DDBlocks.ECHO_FENCE_GATE.value(), blockLoc(DDBlocks.ECHO_PLANKS));
        doorBlockWithRenderType(DDBlocks.ECHO_DOOR.value(), blockLocWithSuffix(DDBlocks.ECHO_DOOR, "bottom"), blockLocWithSuffix(DDBlocks.ECHO_DOOR, "top"), "cutout");
        trapdoorBlockWithRenderType(DDBlocks.ECHO_TRAPDOOR.value(), blockLoc(DDBlocks.ECHO_TRAPDOOR), true, "cutout");
        pressurePlateBlock(DDBlocks.ECHO_PRESSURE_PLATE.value(), blockLoc(DDBlocks.ECHO_PLANKS));
        buttonBlock(DDBlocks.ECHO_BUTTON.value(), blockLoc(DDBlocks.ECHO_PLANKS));
        simpleBlock(DDBlocks.ECHO_LEAVES.value(), models().cubeAll(DDBlocks.ECHO_LEAVES.getId().getPath(), blockLoc(DDBlocks.ECHO_LEAVES)).renderType("cutout"));

    }

    private ResourceLocation blockLoc(DeferredBlock<? extends Block> block) {
        return super.modLoc("block/" + block.getId().getPath());
    }

    private ResourceLocation blockLocWithSuffix(DeferredBlock<? extends Block> block, String suffix) {
        return super.modLoc("block/" + block.getId().getPath() + "_" + suffix);
    }
}
