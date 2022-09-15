package com.kyanite.deeperdarker.forge.datagen.models;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockStateProvider extends BlockStateProvider {
    public DDBlockStateProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DDBlocks.ECHO_PLANKS);
        axisBlock((RotatedPillarBlock) DDBlocks.ECHO_LOG, blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG, "top"));
        axisBlock((RotatedPillarBlock) DDBlocks.STRIPPED_ECHO_LOG, blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG, "top"));
        axisBlock((RotatedPillarBlock) DDBlocks.STRIPPED_ECHO_WOOD, models().cubeColumn(DDBlocks.STRIPPED_ECHO_WOOD.getDescriptionId(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)), models().cubeColumn(DDBlocks.STRIPPED_ECHO_WOOD.getDescriptionId(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        axisBlock((RotatedPillarBlock) DDBlocks.ECHO_WOOD, models().cubeColumn(DDBlocks.ECHO_WOOD.getDescriptionId(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)), models().cubeColumn(DDBlocks.ECHO_WOOD.getDescriptionId(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)));
        simpleBlock(DDBlocks.ECHO_LEAVES);
        slabBlock((SlabBlock) DDBlocks.ECHO_SLAB, blockLoc(DDBlocks.ECHO_PLANKS), blockLoc(DDBlocks.ECHO_PLANKS));
        fenceBlock((FenceBlock) DDBlocks.ECHO_FENCE, blockLoc(DDBlocks.ECHO_PLANKS));
        stairsBlock((StairBlock) DDBlocks.ECHO_STAIRS, blockLoc(DDBlocks.ECHO_PLANKS));
        buttonBlock((ButtonBlock) DDBlocks.ECHO_BUTTON, blockLoc(DDBlocks.ECHO_PLANKS));
        pressurePlateBlock((PressurePlateBlock) DDBlocks.ECHO_PRESSURE_PLATE, blockLoc(DDBlocks.ECHO_PLANKS));
        doorBlockWithRenderType((DoorBlock) DDBlocks.ECHO_DOOR, blockLoc(DDBlocks.ECHO_DOOR, "bottom"), blockLoc(DDBlocks.ECHO_DOOR, "top"), "translucent");
        trapdoorBlockWithRenderType((TrapDoorBlock) DDBlocks.ECHO_TRAPDOOR, blockLoc(DDBlocks.ECHO_TRAPDOOR), true, "translucent");
        fenceGateBlock((FenceGateBlock) DDBlocks.ECHO_FENCE_GATE, blockLoc(DDBlocks.ECHO_PLANKS));
        signBlock((StandingSignBlock) DDBlocks.ECHO_SIGN, (WallSignBlock) DDBlocks.ECHO_WALL_SIGN, blockLoc(DDBlocks.ECHO_PLANKS));

        simpleBlock(DDBlocks.SCULK_STONE);
        slabBlock((SlabBlock) DDBlocks.SCULK_STONE_SLAB, blockLoc(DDBlocks.SCULK_STONE), blockLoc(DDBlocks.SCULK_STONE));
        stairsBlock((StairBlock) DDBlocks.SCULK_STONE_STAIRS, blockLoc(DDBlocks.SCULK_STONE));
        wallBlock((WallBlock) DDBlocks.SCULK_STONE_WALL, blockLoc(DDBlocks.SCULK_STONE));

        simpleBlock(DDBlocks.COBBLED_SCULK_STONE);
        slabBlock((SlabBlock) DDBlocks.COBBLED_SCULK_STONE_SLAB, blockLoc(DDBlocks.COBBLED_SCULK_STONE), blockLoc(DDBlocks.COBBLED_SCULK_STONE));
        stairsBlock((StairBlock) DDBlocks.COBBLED_SCULK_STONE_STAIRS, blockLoc(DDBlocks.COBBLED_SCULK_STONE));
        wallBlock((WallBlock) DDBlocks.COBBLED_SCULK_STONE_WALL, blockLoc(DDBlocks.COBBLED_SCULK_STONE));

        simpleBlock(DDBlocks.POLISHED_SCULK_STONE);
        slabBlock((SlabBlock) DDBlocks.POLISHED_SCULK_STONE_SLAB, blockLoc(DDBlocks.POLISHED_SCULK_STONE), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        stairsBlock((StairBlock) DDBlocks.POLISHED_SCULK_STONE_STAIRS, blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        wallBlock((WallBlock) DDBlocks.POLISHED_SCULK_STONE_WALL, blockLoc(DDBlocks.POLISHED_SCULK_STONE));

        simpleBlock(DDBlocks.SCULK_STONE_BRICKS);
        slabBlock((SlabBlock) DDBlocks.SCULK_STONE_BRICK_SLAB, blockLoc(DDBlocks.SCULK_STONE_BRICKS), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        stairsBlock((StairBlock) DDBlocks.SCULK_STONE_BRICK_STAIRS, blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        wallBlock((WallBlock) DDBlocks.SCULK_STONE_BRICK_WALL, blockLoc(DDBlocks.SCULK_STONE_BRICKS));

        simpleBlock(DDBlocks.SCULK_STONE_COAL_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_IRON_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_COPPER_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_GOLD_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_EMERALD_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_LAPIS_ORE);
        simpleBlock(DDBlocks.SCULK_STONE_DIAMOND_ORE);
        simpleBlock(DDBlocks.INFESTED_SCULK);

        simpleBlock(DDBlocks.SCULK_VINES, models().cross(DDBlocks.SCULK_VINES.getDescriptionId(), blockLoc(DDBlocks.SCULK_VINES)).renderType("translucent"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT, models().cross(DDBlocks.SCULK_VINES_PLANT.getDescriptionId(), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("translucent"));
        //this.createGloomVines();

        simpleBlock(DDBlocks.ECHO_SOIL);
        simpleBlock(DDBlocks.SCULK_GLEAM);
    }

    public void fenceBlock(FenceBlock block, ResourceLocation texture) {
        super.fenceBlock(block, texture);
        models().fenceInventory(block.getDescriptionId().toString() + "_inventory", texture);
    }

    public void buttonBlock(ButtonBlock block, ResourceLocation texture) {
        super.buttonBlock(block, texture);
        models().buttonInventory(block.getDescriptionId().toString() + "_inventory", texture);
    }

    public void wallBlock(WallBlock block, ResourceLocation texture) {
        super.wallBlock(block, texture);
        models().wallInventory(block.getDescriptionId().toString() + "_inventory", texture);
    }

    public ResourceLocation blockLoc(Block block) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + block.getDescriptionId());
    }

    public ResourceLocation blockLoc(Block block, String suffix) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + block.getDescriptionId() + "_" + suffix);
    }
}
