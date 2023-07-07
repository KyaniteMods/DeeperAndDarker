package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
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

        simpleBlock(DDBlocks.SCULK_GRIME.get());
        simpleBlock(DDBlocks.SCULK_GRIME_BRICKS.get());
        stairsBlock(DDBlocks.SCULK_GRIME_BRICK_STAIRS.get(), blockLoc(DDBlocks.SCULK_GRIME_BRICKS));
        slabBlock(DDBlocks.SCULK_GRIME_BRICK_SLAB.get(), blockLoc(DDBlocks.SCULK_GRIME_BRICKS), blockLoc(DDBlocks.SCULK_GRIME_BRICKS));
        wallBlock(DDBlocks.SCULK_GRIME_BRICK_WALL, blockLoc(DDBlocks.SCULK_GRIME_BRICKS));

        simpleBlock(DDBlocks.GLOOMSLATE.get());
        stairsBlock(DDBlocks.GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.GLOOMSLATE));
        slabBlock(DDBlocks.GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.GLOOMSLATE), blockLoc(DDBlocks.GLOOMSLATE));
        wallBlock(DDBlocks.GLOOMSLATE_WALL, blockLoc(DDBlocks.GLOOMSLATE));
        simpleBlock(DDBlocks.COBBLED_GLOOMSLATE.get());
        stairsBlock(DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.COBBLED_GLOOMSLATE));
        slabBlock(DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.COBBLED_GLOOMSLATE), blockLoc(DDBlocks.COBBLED_GLOOMSLATE));
        wallBlock(DDBlocks.COBBLED_GLOOMSLATE_WALL, blockLoc(DDBlocks.COBBLED_GLOOMSLATE));
        simpleBlock(DDBlocks.POLISHED_GLOOMSLATE.get());
        stairsBlock(DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.POLISHED_GLOOMSLATE));
        slabBlock(DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.POLISHED_GLOOMSLATE), blockLoc(DDBlocks.POLISHED_GLOOMSLATE));
        wallBlock(DDBlocks.POLISHED_GLOOMSLATE_WALL, blockLoc(DDBlocks.POLISHED_GLOOMSLATE));
        simpleBlock(DDBlocks.GLOOMSLATE_BRICKS.get());
        stairsBlock(DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), blockLoc(DDBlocks.GLOOMSLATE_BRICKS));
        slabBlock(DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), blockLoc(DDBlocks.GLOOMSLATE_BRICKS), blockLoc(DDBlocks.GLOOMSLATE_BRICKS));
        wallBlock(DDBlocks.GLOOMSLATE_BRICK_WALL, blockLoc(DDBlocks.GLOOMSLATE_BRICKS));
        simpleBlock(DDBlocks.GLOOMSLATE_TILES.get());
        stairsBlock(DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), blockLoc(DDBlocks.GLOOMSLATE_TILES));
        slabBlock(DDBlocks.GLOOMSLATE_TILE_SLAB.get(), blockLoc(DDBlocks.GLOOMSLATE_TILES), blockLoc(DDBlocks.GLOOMSLATE_TILES));
        wallBlock(DDBlocks.GLOOMSLATE_TILE_WALL, blockLoc(DDBlocks.GLOOMSLATE_TILES));
        simpleBlock(DDBlocks.SMOOTH_GLOOMSLATE.get());
        stairsBlock(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.SMOOTH_GLOOMSLATE));
        slabBlock(DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.SMOOTH_GLOOMSLATE), blockLoc(DDBlocks.SMOOTH_GLOOMSLATE));
        wallBlock(DDBlocks.SMOOTH_GLOOMSLATE_WALL, blockLoc(DDBlocks.SMOOTH_GLOOMSLATE));
        simpleBlock(DDBlocks.CUT_GLOOMSLATE.get());
        stairsBlock(DDBlocks.CUT_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.CUT_GLOOMSLATE));
        slabBlock(DDBlocks.CUT_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.CUT_GLOOMSLATE), blockLoc(DDBlocks.CUT_GLOOMSLATE));
        wallBlock(DDBlocks.CUT_GLOOMSLATE_WALL, blockLoc(DDBlocks.CUT_GLOOMSLATE));
        simpleBlock(DDBlocks.CHISELED_GLOOMSLATE.get());

        simpleBlock(DDBlocks.ECHO_SOIL.get());
        simpleBlock(DDBlocks.GLOOMY_SCULK.get());
        simpleBlock(DDBlocks.GLOOMY_GEYSER.get(), models().cubeTop(DDBlocks.GLOOMY_GEYSER.getId().getPath(), blockLoc(DDBlocks.GLOOMY_SCULK), blockLoc(DDBlocks.GLOOMY_GEYSER)));
        simpleBlock(DDBlocks.SCULK_GLEAM.get());

        simpleBlock(DDBlocks.SCULK_STONE_COAL_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_IRON_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        simpleBlock(DDBlocks.GLOOMY_GRASS.get(), models().cross(DDBlocks.GLOOMY_GRASS.getId().getPath(), blockLoc(DDBlocks.GLOOMY_GRASS)).renderType("cutout"));
        simpleBlock(DDBlocks.GLOOMY_CACTUS.get(), models().withExistingParent(DDBlocks.GLOOMY_CACTUS.getId().getPath(), modLoc("block/cube_cactus")).texture("side", blockLoc(DDBlocks.GLOOMY_CACTUS, "side")).texture("top", blockLoc(DDBlocks.GLOOMY_CACTUS, "top")));
        simpleBlock(DDBlocks.SCULK_VINES.get(), models().cross(DDBlocks.SCULK_VINES.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT.get(), models().cross(DDBlocks.SCULK_VINES_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS.get(), models().cross(DDBlocks.SCULK_TENDRILS.getId().getPath(), blockLoc(DDBlocks.SCULK_TENDRILS)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), models().cross(DDBlocks.SCULK_TENDRILS_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_TENDRILS_PLANT)).renderType("cutout"));
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
