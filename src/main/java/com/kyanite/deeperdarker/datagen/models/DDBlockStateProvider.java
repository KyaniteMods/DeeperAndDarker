package com.kyanite.deeperdarker.datagen.models;

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
        simpleBlock(DDBlocks.BONE_PLANKS.get());
        slabBlock(DDBlocks.BONE_SLAB.get(), blockLoc(DDBlocks.BONE_PLANKS), blockLoc(DDBlocks.BONE_PLANKS));
        stairsBlock(DDBlocks.BONE_STAIRS.get(), blockLoc(DDBlocks.BONE_PLANKS));
        fenceBlock(DDBlocks.BONE_FENCE, blockLoc(DDBlocks.BONE_PLANKS));
        buttonBlock(DDBlocks.BONE_BUTTON, blockLoc(DDBlocks.BONE_PLANKS));
        pressurePlateBlock(DDBlocks.BONE_PRESSURE_PLATE.get(), blockLoc(DDBlocks.BONE_PLANKS));
        doorBlockWithRenderType(DDBlocks.BONE_DOOR.get(), blockLoc(DDBlocks.BONE_DOOR, "bottom"), blockLoc(DDBlocks.BONE_DOOR, "top"), "translucent");
        trapdoorBlockWithRenderType(DDBlocks.BONE_TRAPDOOR.get(), blockLoc(DDBlocks.BONE_TRAPDOOR), true, "translucent");
        fenceGateBlock(DDBlocks.BONE_FENCE_GATE.get(), blockLoc(DDBlocks.BONE_PLANKS));
        signBlock((StandingSignBlock) DDBlocks.BONE_SIGN.get(), (WallSignBlock) DDBlocks.BONE_WALL_SIGN.get(), blockLoc(DDBlocks.BONE_PLANKS));

        axisBlock(DDBlocks.SCULK_BONE_BLOCK.get(), blockLoc(DDBlocks.SCULK_BONE_BLOCK, "side"), blockLoc(DDBlocks.SCULK_BONE_BLOCK, "top"));
        simpleBlock(DDBlocks.SCULK_BONE_PLANKS.get());
        slabBlock(DDBlocks.SCULK_BONE_SLAB.get(), blockLoc(DDBlocks.SCULK_BONE_PLANKS), blockLoc(DDBlocks.SCULK_BONE_PLANKS));
        stairsBlock(DDBlocks.SCULK_BONE_STAIRS.get(), blockLoc(DDBlocks.SCULK_BONE_PLANKS));
        fenceBlock(DDBlocks.SCULK_BONE_FENCE, blockLoc(DDBlocks.SCULK_BONE_PLANKS));
        buttonBlock(DDBlocks.SCULK_BONE_BUTTON, blockLoc(DDBlocks.SCULK_BONE_PLANKS));
        pressurePlateBlock(DDBlocks.SCULK_BONE_PRESSURE_PLATE.get(), blockLoc(DDBlocks.SCULK_BONE_PLANKS));
        doorBlockWithRenderType(DDBlocks.SCULK_BONE_DOOR.get(), blockLoc(DDBlocks.SCULK_BONE_DOOR, "bottom"), blockLoc(DDBlocks.SCULK_BONE_DOOR, "top"), "translucent");
        trapdoorBlockWithRenderType(DDBlocks.SCULK_BONE_TRAPDOOR.get(), blockLoc(DDBlocks.SCULK_BONE_TRAPDOOR), true, "translucent");
        fenceGateBlock(DDBlocks.SCULK_BONE_FENCE_GATE.get(), blockLoc(DDBlocks.SCULK_BONE_PLANKS));
        signBlock((StandingSignBlock) DDBlocks.SCULK_BONE_SIGN.get(), (WallSignBlock) DDBlocks.SCULK_BONE_WALL_SIGN.get(), blockLoc(DDBlocks.SCULK_BONE_PLANKS));

        simpleBlock(DDBlocks.SCULK_STONE.get());
        slabBlock(DDBlocks.SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE), blockLoc(DDBlocks.SCULK_STONE));
        stairsBlock(DDBlocks.SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE));
        wallBlock(DDBlocks.SCULK_STONE_WALL, blockLoc(DDBlocks.SCULK_STONE));
        simpleBlock(DDBlocks.POLISHED_SCULK_STONE.get());
        slabBlock(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.POLISHED_SCULK_STONE), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        stairsBlock(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        wallBlock(DDBlocks.POLISHED_SCULK_STONE_WALL, blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        simpleBlock(DDBlocks.SCULK_STONE_BRICKS.get());
        slabBlock(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE_BRICKS), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        stairsBlock(DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        wallBlock(DDBlocks.SCULK_STONE_BRICK_WALL, blockLoc(DDBlocks.SCULK_STONE_BRICKS));

        simpleBlock(DDBlocks.SCULK_STONE_COAL_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_IRON_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        simpleBlock(DDBlocks.SCULK_GLEAM.get());
        simpleBlock(DDBlocks.INFESTED_SCULK.get());
        simpleBlock(DDBlocks.SCULK_VINES.get(), models().cross(DDBlocks.SCULK_VINES.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES)).renderType("translucent"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT.get(), models().cross(DDBlocks.SCULK_VINES_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("translucent"));
    }

    public void fenceBlock(RegistryObject<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(block.getId().toString() + "_inventory", texture);
    }

    public void buttonBlock(RegistryObject<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(block.getId().toString() + "_inventory", texture);
    }

    public void wallBlock(RegistryObject<WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(block.getId().toString() + "_inventory", texture);
    }

    public ResourceLocation blockLoc(RegistryObject<? extends Block> block) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + block.getId().getPath());
    }

    public ResourceLocation blockLoc(RegistryObject<? extends Block> block, String suffix) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + block.getId().getPath() + "_" + suffix);
    }
}