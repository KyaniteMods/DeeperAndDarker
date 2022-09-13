package com.kyanite.deeperdarker.datagen.models;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.BloomBerryBushBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.SculkJawBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DDBlockStateProvider extends BlockStateProvider {
    public DDBlockStateProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DDBlocks.ECHO_PLANKS.get());

        axisBlock(DDBlocks.ECHO_LOG.get(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG, "top"));
        axisBlock(DDBlocks.STRIPPED_ECHO_LOG.get(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG, "top"));
        axisBlock(DDBlocks.STRIPPED_ECHO_WOOD.get(), models().cubeColumn(DDBlocks.STRIPPED_ECHO_WOOD.getId().getPath(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)), models().cubeColumn(DDBlocks.STRIPPED_ECHO_WOOD.getId().getPath(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        axisBlock(DDBlocks.ECHO_WOOD.get(), models().cubeColumn(DDBlocks.ECHO_WOOD.getId().getPath(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)), models().cubeColumn(DDBlocks.ECHO_WOOD.getId().getPath(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)));
        simpleBlock(DDBlocks.ECHO_LEAVES.get());
        slabBlock(DDBlocks.ECHO_SLAB.get(), blockLoc(DDBlocks.ECHO_PLANKS), blockLoc(DDBlocks.ECHO_PLANKS));
        fenceBlock(DDBlocks.ECHO_FENCE, blockLoc(DDBlocks.ECHO_PLANKS));
        stairsBlock(DDBlocks.ECHO_STAIRS.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        buttonBlock(DDBlocks.ECHO_BUTTON, blockLoc(DDBlocks.ECHO_PLANKS));
        pressurePlateBlock(DDBlocks.ECHO_PRESSURE_PLATE.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        doorBlockWithRenderType(DDBlocks.ECHO_DOOR.get(), blockLoc(DDBlocks.ECHO_DOOR, "bottom"), blockLoc(DDBlocks.ECHO_DOOR, "top"), "cutout");
        trapdoorBlockWithRenderType(DDBlocks.ECHO_TRAPDOOR.get(), blockLoc(DDBlocks.ECHO_TRAPDOOR), true, "cutout");
        fenceGateBlock(DDBlocks.ECHO_FENCE_GATE.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        signBlock(DDBlocks.ECHO_SIGN.get(), (WallSignBlock) DDBlocks.ECHO_WALL_SIGN.get(), blockLoc(DDBlocks.ECHO_PLANKS));

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

        simpleBlock(DDBlocks.SCULK_STONE_COAL_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_IRON_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        simpleBlock(DDBlocks.SCULK_VINES.get(), models().cross(DDBlocks.SCULK_VINES.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT.get(), models().cross(DDBlocks.SCULK_VINES_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS.get(), models().cross(DDBlocks.SCULK_TENDRILS.getId().getPath(), blockLoc(DDBlocks.SCULK_TENDRILS)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), models().cross(DDBlocks.SCULK_TENDRILS_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_TENDRILS_PLANT)).renderType("cutout"));

        simpleBlock(DDBlocks.ECHO_SOIL.get());
        simpleBlock(DDBlocks.SCULK_GLEAM.get());
        simpleBlock(DDBlocks.INFESTED_SCULK.get());

        simpleBlock(DDBlocks.BLOOMING_GRASS_BLOCK.get(), models().cubeBottomTop(DDBlocks.BLOOMING_GRASS_BLOCK.getId().getPath(), blockLoc(DDBlocks.BLOOMING_GRASS_BLOCK, "side"), blockLoc(DDBlocks.SCULK_STONE), blockLoc(DDBlocks.BLOOMING_GRASS_BLOCK)));
        simpleBlock(DDBlocks.BLOOMING_GRASS.get(), models().cross(DDBlocks.BLOOMING_GRASS.getId().getPath(), blockLoc(DDBlocks.BLOOMING_GRASS)).renderType("cutout"));
        ConfiguredModel[] bloomGrassModels = { new ConfiguredModel(models().cross(DDBlocks.BLOOMING_GRASS.getId().getPath() + "_bottom", blockLoc(DDBlocks.BLOOMING_GRASS, "bottom")).renderType("cutout")), new ConfiguredModel(models().cross(DDBlocks.BLOOMING_GRASS.getId().getPath() + "_top", blockLoc(DDBlocks.BLOOMING_GRASS, "top")).renderType("cutout")) };
        getVariantBuilder(DDBlocks.TALL_BLOOMING_GRASS.get()).partialState().with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setModels(bloomGrassModels[0]).partialState().with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setModels(bloomGrassModels[1]);
        ConfiguredModel[] berryBushModels = { new ConfiguredModel(models().cross(DDBlocks.BLOOM_BERRY_BUSH.getId().getPath() + "_stage0", blockLoc(DDBlocks.BLOOM_BERRY_BUSH, "stage0")).renderType("cutout")), new ConfiguredModel(models().cross(DDBlocks.BLOOM_BERRY_BUSH.getId().getPath() + "_stage1", blockLoc(DDBlocks.BLOOM_BERRY_BUSH, "stage1")).renderType("cutout")), new ConfiguredModel(models().cross(DDBlocks.BLOOM_BERRY_BUSH.getId().getPath() + "_stage2", blockLoc(DDBlocks.BLOOM_BERRY_BUSH, "stage2")).renderType("cutout")), new ConfiguredModel(models().cross(DDBlocks.BLOOM_BERRY_BUSH.getId().getPath() + "_stage3", blockLoc(DDBlocks.BLOOM_BERRY_BUSH, "stage3")).renderType("cutout")) };
        getVariantBuilder(DDBlocks.BLOOM_BERRY_BUSH.get()).partialState().with(BloomBerryBushBlock.AGE, 0).setModels(berryBushModels[0]).partialState().with(BloomBerryBushBlock.AGE, 1).setModels(berryBushModels[1]).partialState().with(BloomBerryBushBlock.AGE, 2).setModels(berryBushModels[2]).partialState().with(BloomBerryBushBlock.AGE, 3).setModels(berryBushModels[3]);

        simpleBlock(DDBlocks.GLOOM_SCULK.get());
        simpleBlock(DDBlocks.GLOOM_STONE.get());
        simpleBlock(DDBlocks.GEYSER.get(), models().cubeTop(DDBlocks.GEYSER.getId().getPath(), blockLoc(DDBlocks.GLOOM_SCULK), blockLoc(DDBlocks.GEYSER)));
        simpleBlock(DDBlocks.CRYSTALLIZED_AMBER.get(), models().withExistingParent(DDBlocks.CRYSTALLIZED_AMBER.getId().getPath(), mcLoc("block/honey_block")).texture("particle", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).texture("down", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "outer")).texture("up", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).texture("side", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).renderType("transparent"));
        simpleBlock(DDBlocks.GLOOM_CACTUS.get(), models().withExistingParent(DDBlocks.GLOOM_CACTUS.getId().getPath(), mcLoc("block/cactus")).texture("particle", blockLoc(DDBlocks.GLOOM_CACTUS, "side")).texture("bottom", blockLoc(DDBlocks.GLOOM_CACTUS, "bottom")).texture("top", blockLoc(DDBlocks.GLOOM_CACTUS, "top")).texture("side", blockLoc(DDBlocks.GLOOM_CACTUS, "side")).renderType("cutout"));
        simpleBlock(DDBlocks.GLOOMY_GRASS.get(), models().cross(DDBlocks.GLOOMY_GRASS.getId().getPath(), blockLoc(DDBlocks.GLOOMY_GRASS)).renderType("cutout"));

        ConfiguredModel[] sculkJawModels = { new ConfiguredModel(models().cubeAll(DDBlocks.SCULK_JAW.getId().getPath() + "_activated", blockLoc(DDBlocks.SCULK_JAW, "activated"))), new ConfiguredModel(models().cubeAll(DDBlocks.SCULK_JAW.getId().getPath(), blockLoc(DDBlocks.SCULK_JAW))) };
        getVariantBuilder(DDBlocks.SCULK_JAW.get()).partialState().with(SculkJawBlock.ACTIVATED, true).setModels(sculkJawModels[0]).partialState().with(SculkJawBlock.ACTIVATED, false).setModels(sculkJawModels[1]);

        simpleBlock(DDBlocks.ANCIENT_VASE.get(), models().withExistingParent(DDBlocks.ANCIENT_VASE.getId().getPath(), modLoc("block/vase")).texture("vase", blockLoc(DDBlocks.ANCIENT_VASE)));
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
