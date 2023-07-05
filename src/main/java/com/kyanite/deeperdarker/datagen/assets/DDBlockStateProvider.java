package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.registries.DDBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockStateProvider extends BlockStateProvider {
    public DDBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeeperDarker.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(DDBlocks.ECHO_LOG.get());
        axisBlock(DDBlocks.ECHO_WOOD.get(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG));
        logBlock(DDBlocks.STRIPPED_ECHO_LOG.get());
        axisBlock(DDBlocks.STRIPPED_ECHO_WOOD.get(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG));
        simpleBlock(DDBlocks.ECHO_PLANKS.get());
        stairsBlock(DDBlocks.ECHO_STAIRS.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        slabBlock(DDBlocks.ECHO_SLAB.get(), blockLoc(DDBlocks.ECHO_PLANKS), blockLoc(DDBlocks.ECHO_PLANKS));
        fenceBlock(DDBlocks.ECHO_FENCE, blockLoc(DDBlocks.ECHO_PLANKS));
        fenceGateBlock(DDBlocks.ECHO_FENCE_GATE.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        doorBlockWithRenderType(DDBlocks.ECHO_DOOR.get(), blockLoc(DDBlocks.ECHO_DOOR, "bottom"), blockLoc(DDBlocks.ECHO_DOOR, "top"), "cutout");
        trapdoorBlockWithRenderType(DDBlocks.ECHO_TRAPDOOR.get(), blockLoc(DDBlocks.ECHO_TRAPDOOR), true, "cutout");
        pressurePlateBlock(DDBlocks.ECHO_PRESSURE_PLATE.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        buttonBlock(DDBlocks.ECHO_BUTTON, blockLoc(DDBlocks.ECHO_PLANKS));
        simpleBlock(DDBlocks.ECHO_LEAVES.get(), models().cubeAll(DDBlocks.ECHO_LEAVES.getId().getPath(), blockLoc(DDBlocks.ECHO_LEAVES)).renderType("cutout"));
        signBlock(DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        simpleBlock(DDBlocks.ECHO_HANGING_SIGN.get(), models().sign(DDBlocks.ECHO_HANGING_SIGN.getId().getPath(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        simpleBlock(DDBlocks.ECHO_WALL_HANGING_SIGN.get(), models().sign(DDBlocks.ECHO_HANGING_SIGN.getId().getPath(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));

        simpleBlock(DDBlocks.SCULK_STONE.get());
        stairsBlock(DDBlocks.SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE));
        slabBlock(DDBlocks.SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE), blockLoc(DDBlocks.SCULK_STONE));
        wallBlock(DDBlocks.SCULK_STONE_WALL, blockLoc(DDBlocks.SCULK_STONE));

        simpleBlock(DDBlocks.COBBLED_SCULK_STONE.get());
        stairsBlock(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.COBBLED_SCULK_STONE));
        slabBlock(DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.COBBLED_SCULK_STONE), blockLoc(DDBlocks.COBBLED_SCULK_STONE));
        wallBlock(DDBlocks.COBBLED_SCULK_STONE_WALL, blockLoc(DDBlocks.COBBLED_SCULK_STONE));

        simpleBlock(DDBlocks.POLISHED_SCULK_STONE.get());
        stairsBlock(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        slabBlock(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.POLISHED_SCULK_STONE), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        wallBlock(DDBlocks.POLISHED_SCULK_STONE_WALL, blockLoc(DDBlocks.POLISHED_SCULK_STONE));

        simpleBlock(DDBlocks.SCULK_STONE_BRICKS.get());
        stairsBlock(DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        slabBlock(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE_BRICKS), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        wallBlock(DDBlocks.SCULK_STONE_BRICK_WALL, blockLoc(DDBlocks.SCULK_STONE_BRICKS));

        simpleBlock(DDBlocks.SCULK_STONE_TILES.get());
        stairsBlock(DDBlocks.SCULK_STONE_TILE_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE_TILES));
        slabBlock(DDBlocks.SCULK_STONE_TILE_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE_TILES), blockLoc(DDBlocks.SCULK_STONE_TILES));
        wallBlock(DDBlocks.SCULK_STONE_TILE_WALL, blockLoc(DDBlocks.SCULK_STONE_TILES));

        simpleBlock(DDBlocks.SMOOTH_SCULK_STONE.get());
        stairsBlock(DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.SMOOTH_SCULK_STONE));
        slabBlock(DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.SMOOTH_SCULK_STONE), blockLoc(DDBlocks.SMOOTH_SCULK_STONE));
        wallBlock(DDBlocks.SMOOTH_SCULK_STONE_WALL, blockLoc(DDBlocks.SMOOTH_SCULK_STONE));

        simpleBlock(DDBlocks.CUT_SCULK_STONE.get());
        stairsBlock(DDBlocks.CUT_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.CUT_SCULK_STONE));
        slabBlock(DDBlocks.CUT_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.CUT_SCULK_STONE), blockLoc(DDBlocks.CUT_SCULK_STONE));
        wallBlock(DDBlocks.CUT_SCULK_STONE_WALL, blockLoc(DDBlocks.CUT_SCULK_STONE));

        simpleBlock(DDBlocks.CHISELED_SCULK_STONE.get());

        simpleBlock(DDBlocks.SCULK_STONE_COAL_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_IRON_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());
    }

    private void fenceBlock(RegistryObject<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void buttonBlock(RegistryObject<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void wallBlock(RegistryObject<WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(block.getId().getPath() + "_inventory", texture);
    }

    private ResourceLocation blockLoc(RegistryObject<? extends Block> block) {
        return super.modLoc("block/" + block.getId().getPath());
    }

    public ResourceLocation blockLoc(RegistryObject<? extends Block> block, String suffix) {
        return super.modLoc("block/" + block.getId().getPath() + "_" + suffix);
    }
}
