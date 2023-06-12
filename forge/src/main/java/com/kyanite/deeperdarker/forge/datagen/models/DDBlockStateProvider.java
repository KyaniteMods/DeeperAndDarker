package com.kyanite.deeperdarker.forge.datagen.models;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.SculkJawBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class DDBlockStateProvider extends BlockStateProvider {
    public DDBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeeperAndDarker.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DDBlocks.ECHO_PLANKS.get());
        axisBlock(DDBlocks.ECHO_LOG.get(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG, "top"));
        axisBlock(DDBlocks.STRIPPED_ECHO_LOG.get(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG, "top"));
        axisBlock(DDBlocks.STRIPPED_ECHO_WOOD.get(), models().cubeColumn(getName(DDBlocks.STRIPPED_ECHO_WOOD), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)), models().cubeColumn(getName(DDBlocks.STRIPPED_ECHO_WOOD), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        axisBlock(DDBlocks.ECHO_WOOD.get(), models().cubeColumn(getName(DDBlocks.ECHO_WOOD), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)), models().cubeColumn(getName(DDBlocks.ECHO_WOOD), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)));
        simpleBlock(DDBlocks.ECHO_LEAVES.get());
        slabBlock(DDBlocks.ECHO_SLAB.get(), blockLoc(DDBlocks.ECHO_PLANKS), blockLoc(DDBlocks.ECHO_PLANKS));
        fenceBlock(DDBlocks.ECHO_FENCE, blockLoc(DDBlocks.ECHO_PLANKS));
        stairsBlock(DDBlocks.ECHO_STAIRS.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        buttonBlock(DDBlocks.ECHO_BUTTON, blockLoc(DDBlocks.ECHO_PLANKS));
        pressurePlateBlock(DDBlocks.ECHO_PRESSURE_PLATE.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        doorBlockWithRenderType(DDBlocks.ECHO_DOOR.get(), blockLoc(DDBlocks.ECHO_DOOR, "bottom"), blockLoc(DDBlocks.ECHO_DOOR, "top"), "cutout");
        trapdoorBlockWithRenderType(DDBlocks.ECHO_TRAPDOOR.get(), blockLoc(DDBlocks.ECHO_TRAPDOOR), true, "cutout");
        fenceGateBlock(DDBlocks.ECHO_FENCE_GATE.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        signBlock(DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get(), blockLoc(DDBlocks.ECHO_PLANKS));

        simpleBlock(DDBlocks.ECHO_SOIL.get());
        simpleBlock(DDBlocks.SCULK_GRIME.get());
        simpleBlock(DDBlocks.GRIME_BRICKS.get());
            slabBlock(DDBlocks.GRIME_BRICK_SLAB.get(), blockLoc(DDBlocks.GRIME_BRICKS), blockLoc(DDBlocks.GRIME_BRICKS));
        stairsBlock(DDBlocks.GRIME_BRICK_STAIRS.get(), blockLoc(DDBlocks.GRIME_BRICKS));
        wallBlock(DDBlocks.GRIME_BRICK_WALL, blockLoc(DDBlocks.GRIME_BRICKS));

        simpleBlock(DDBlocks.SCULK_STONE.get());
        slabBlock(DDBlocks.SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE), blockLoc(DDBlocks.SCULK_STONE));
        stairsBlock(DDBlocks.SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE));
        wallBlock(DDBlocks.SCULK_STONE_WALL, blockLoc(DDBlocks.SCULK_STONE));

        simpleBlock(DDBlocks.COBBLED_SCULK_STONE.get());
        slabBlock(DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.COBBLED_SCULK_STONE), blockLoc(DDBlocks.COBBLED_SCULK_STONE));
        stairsBlock(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.COBBLED_SCULK_STONE));
        wallBlock(DDBlocks.COBBLED_SCULK_STONE_WALL, blockLoc(DDBlocks.COBBLED_SCULK_STONE));

        simpleBlock(DDBlocks.POLISHED_SCULK_STONE.get());
        slabBlock(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.POLISHED_SCULK_STONE), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        stairsBlock(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.POLISHED_SCULK_STONE));
        wallBlock(DDBlocks.POLISHED_SCULK_STONE_WALL, blockLoc(DDBlocks.POLISHED_SCULK_STONE));

        simpleBlock(DDBlocks.SCULK_STONE_BRICKS.get());
        slabBlock(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE_BRICKS), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        stairsBlock(DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE_BRICKS));
        wallBlock(DDBlocks.SCULK_STONE_BRICK_WALL, blockLoc(DDBlocks.SCULK_STONE_BRICKS));

        simpleBlock(DDBlocks.SCULK_STONE_TILES.get());
        slabBlock(DDBlocks.SCULK_STONE_TILE_SLAB.get(), blockLoc(DDBlocks.SCULK_STONE_TILES), blockLoc(DDBlocks.SCULK_STONE_TILES));
        stairsBlock(DDBlocks.SCULK_STONE_TILE_STAIRS.get(), blockLoc(DDBlocks.SCULK_STONE_TILES));
        wallBlock(DDBlocks.SCULK_STONE_TILE_WALL, blockLoc(DDBlocks.SCULK_STONE_TILES));

        simpleBlock(DDBlocks.SMOOTH_SCULK_STONE.get());
        slabBlock(DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.SMOOTH_SCULK_STONE), blockLoc(DDBlocks.SMOOTH_SCULK_STONE));
        stairsBlock(DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.SMOOTH_SCULK_STONE));
        wallBlock(DDBlocks.SMOOTH_SCULK_STONE_WALL, blockLoc(DDBlocks.SMOOTH_SCULK_STONE));

        simpleBlock(DDBlocks.CUT_SCULK_STONE.get());
        slabBlock(DDBlocks.CUT_SCULK_STONE_SLAB.get(), blockLoc(DDBlocks.CUT_SCULK_STONE), blockLoc(DDBlocks.CUT_SCULK_STONE));
        stairsBlock(DDBlocks.CUT_SCULK_STONE_STAIRS.get(), blockLoc(DDBlocks.CUT_SCULK_STONE));
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
        simpleBlock(DDBlocks.INFESTED_SCULK.get());

        simpleBlock(DDBlocks.SCULK_VINES.get(), models().cross(getName(DDBlocks.SCULK_VINES), blockLoc(DDBlocks.SCULK_VINES)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT.get(), models().cross(getName(DDBlocks.SCULK_VINES_PLANT), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS.get(), models().cross(getName(DDBlocks.SCULK_TENDRILS), blockLoc(DDBlocks.SCULK_TENDRILS)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), models().cross(getName(DDBlocks.SCULK_TENDRILS_PLANT), blockLoc(DDBlocks.SCULK_TENDRILS_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_GLEAM.get());

        simpleBlock(DDBlocks.GLOOM_SCULK.get());
        simpleBlock(DDBlocks.GEYSER.get(), models().cubeTop(getName(DDBlocks.GEYSER), blockLoc(DDBlocks.GLOOM_SCULK), blockLoc(DDBlocks.GEYSER)));
        simpleBlock(DDBlocks.CRYSTALLIZED_AMBER.get(), models().withExistingParent(getName(DDBlocks.CRYSTALLIZED_AMBER), mcLoc("block/honey_block")).texture("particle", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).texture("down", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "outer")).texture("up", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).texture("side", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")));
        simpleBlock(DDBlocks.GLOOM_CACTUS.get(), models().withExistingParent(getName(DDBlocks.GLOOM_CACTUS), modLoc("block/cube_cactus")).texture("side", blockLoc(DDBlocks.GLOOM_CACTUS, "side")).texture("top", blockLoc(DDBlocks.GLOOM_CACTUS, "top")));
        simpleBlock(DDBlocks.GLOOMY_GRASS.get(), models().cross(getName(DDBlocks.GLOOMY_GRASS), blockLoc(DDBlocks.GLOOMY_GRASS)).renderType("cutout"));

        simpleBlock(DDBlocks.GLOOMSLATE.get());
        slabBlock(DDBlocks.GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.GLOOMSLATE), blockLoc(DDBlocks.GLOOMSLATE));
        stairsBlock(DDBlocks.GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.GLOOMSLATE));
        wallBlock(DDBlocks.GLOOMSLATE_WALL, blockLoc(DDBlocks.GLOOMSLATE));

        simpleBlock(DDBlocks.COBBLED_GLOOMSLATE.get());
        slabBlock(DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.COBBLED_GLOOMSLATE), blockLoc(DDBlocks.COBBLED_GLOOMSLATE));
        stairsBlock(DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.COBBLED_GLOOMSLATE));
        wallBlock(DDBlocks.COBBLED_GLOOMSLATE_WALL, blockLoc(DDBlocks.COBBLED_GLOOMSLATE));

        simpleBlock(DDBlocks.POLISHED_GLOOMSLATE.get());
        slabBlock(DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.POLISHED_GLOOMSLATE), blockLoc(DDBlocks.POLISHED_GLOOMSLATE));
        stairsBlock(DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.POLISHED_GLOOMSLATE));
        wallBlock(DDBlocks.POLISHED_GLOOMSLATE_WALL, blockLoc(DDBlocks.POLISHED_GLOOMSLATE));

        simpleBlock(DDBlocks.GLOOMSLATE_BRICKS.get());
        slabBlock(DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), blockLoc(DDBlocks.GLOOMSLATE_BRICKS), blockLoc(DDBlocks.GLOOMSLATE_BRICKS));
        stairsBlock(DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), blockLoc(DDBlocks.GLOOMSLATE_BRICKS));
        wallBlock(DDBlocks.GLOOMSLATE_BRICK_WALL, blockLoc(DDBlocks.GLOOMSLATE_BRICKS));

        simpleBlock(DDBlocks.GLOOMSLATE_TILES.get());
        slabBlock(DDBlocks.GLOOMSLATE_TILE_SLAB.get(), blockLoc(DDBlocks.GLOOMSLATE_TILES), blockLoc(DDBlocks.GLOOMSLATE_TILES));
        stairsBlock(DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), blockLoc(DDBlocks.GLOOMSLATE_TILES));
        wallBlock(DDBlocks.GLOOMSLATE_TILE_WALL, blockLoc(DDBlocks.GLOOMSLATE_TILES));

        simpleBlock(DDBlocks.SMOOTH_GLOOMSLATE.get());
        slabBlock(DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.SMOOTH_GLOOMSLATE), blockLoc(DDBlocks.SMOOTH_GLOOMSLATE));
        stairsBlock(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.SMOOTH_GLOOMSLATE));
        wallBlock(DDBlocks.SMOOTH_GLOOMSLATE_WALL, blockLoc(DDBlocks.SMOOTH_GLOOMSLATE));

        simpleBlock(DDBlocks.CUT_GLOOMSLATE.get());
        slabBlock(DDBlocks.CUT_GLOOMSLATE_SLAB.get(), blockLoc(DDBlocks.CUT_GLOOMSLATE), blockLoc(DDBlocks.CUT_GLOOMSLATE));
        stairsBlock(DDBlocks.CUT_GLOOMSLATE_STAIRS.get(), blockLoc(DDBlocks.CUT_GLOOMSLATE));
        wallBlock(DDBlocks.CUT_GLOOMSLATE_WALL, blockLoc(DDBlocks.CUT_GLOOMSLATE));

        simpleBlock(DDBlocks.CHISELED_GLOOMSLATE.get());

        ConfiguredModel[] sjm = { new ConfiguredModel(models().cubeAll(getName(DDBlocks.SCULK_JAW) + "_activated", blockLoc(DDBlocks.SCULK_JAW, "activated"))), new ConfiguredModel(models().cubeAll(getName(DDBlocks.SCULK_JAW), blockLoc(DDBlocks.SCULK_JAW))) };
        getVariantBuilder(DDBlocks.SCULK_JAW.get()).partialState().with(SculkJawBlock.ACTIVATED, true).setModels(sjm[0]).partialState().with(SculkJawBlock.ACTIVATED, false).setModels(sjm[1]);
        simpleBlock(DDBlocks.ANCIENT_VASE.get(), models().withExistingParent(getName(DDBlocks.ANCIENT_VASE), modLoc("block/vase")).texture("vase", blockLoc(DDBlocks.ANCIENT_VASE)));
    }

    public void fenceBlock(Supplier<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(getName(block) + "_inventory", texture);
    }

    public void buttonBlock(Supplier<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(getName(block) + "_inventory", texture);
    }

    public void wallBlock(Supplier<WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(getName(block) + "_inventory", texture);
    }

    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }

    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + getName(block));
    }

    public ResourceLocation blockLoc(Supplier<? extends Block> block, String suffix) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + getName(block) + "_" + suffix);
    }
}
