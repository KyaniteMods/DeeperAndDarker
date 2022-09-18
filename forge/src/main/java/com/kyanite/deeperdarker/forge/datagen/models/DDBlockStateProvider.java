package com.kyanite.deeperdarker.forge.datagen.models;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.SculkJawBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class DDBlockStateProvider extends BlockStateProvider {
    public DDBlockStateProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DDBlocks.ECHO_PLANKS.get());

        axisBlock(DDBlocks.ECHO_LOG.get(), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG, "top"));
        axisBlock(DDBlocks.STRIPPED_ECHO_LOG.get(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG, "top"));
        axisBlock(DDBlocks.STRIPPED_ECHO_WOOD.get(), models().cubeColumn(getName(DDBlocks.STRIPPED_ECHO_WOOD.get()), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)), models().cubeColumn(getName(DDBlocks.STRIPPED_ECHO_WOOD.get()), blockLoc(DDBlocks.STRIPPED_ECHO_LOG), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        axisBlock(DDBlocks.ECHO_WOOD.get(), models().cubeColumn(getName(DDBlocks.ECHO_WOOD.get()), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)), models().cubeColumn(getName(DDBlocks.ECHO_WOOD.get()), blockLoc(DDBlocks.ECHO_LOG), blockLoc(DDBlocks.ECHO_LOG)));
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

        simpleBlock(DDBlocks.SCULK_VINES.get(), models().cross(getName(DDBlocks.SCULK_VINES.get()), blockLoc(DDBlocks.SCULK_VINES)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT.get(), models().cross(getName(DDBlocks.SCULK_VINES_PLANT.get()), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS.get(), models().cross(getName(DDBlocks.SCULK_TENDRILS.get()), blockLoc(DDBlocks.SCULK_TENDRILS)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), models().cross(getName(DDBlocks.SCULK_TENDRILS_PLANT.get()), blockLoc(DDBlocks.SCULK_TENDRILS_PLANT)).renderType("cutout"));

        simpleBlock(DDBlocks.ECHO_SOIL.get());
        simpleBlock(DDBlocks.SCULK_GLEAM.get());
        simpleBlock(DDBlocks.INFESTED_SCULK.get());

        ConfiguredModel[] sculkJawModels = { new ConfiguredModel(models().cubeAll(getName(DDBlocks.SCULK_JAW.get()) + "_activated", blockLoc(DDBlocks.SCULK_JAW, "activated"))), new ConfiguredModel(models().cubeAll(getName(DDBlocks.SCULK_JAW.get()), blockLoc(DDBlocks.SCULK_JAW))) };
        getVariantBuilder(DDBlocks.SCULK_JAW.get()).partialState().with(SculkJawBlock.ACTIVATED, true).setModels(sculkJawModels[0]).partialState().with(SculkJawBlock.ACTIVATED, false).setModels(sculkJawModels[1]);

        simpleBlock(DDBlocks.ANCIENT_VASE.get(), models().withExistingParent(getName(DDBlocks.ANCIENT_VASE.get()), modLoc("block/ancient_vase")).texture("vase", blockLoc(DDBlocks.ANCIENT_VASE)));
    }

    public void fenceBlock(Supplier<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(getName(block.get()) + "_inventory", texture);
    }

    public void buttonBlock(Supplier<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(getName(block.get()) + "_inventory", texture);
    }

    public void wallBlock(Supplier<WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(getName(block.get()) + "_inventory", texture);
    }

    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + getName(block.get()));
    }

    public String getName(Block block) {
        return block.builtInRegistryHolder().key().location().getPath();
    }

    public ResourceLocation blockLoc(Supplier<? extends Block> block, String suffix) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "block/" + getName(block.get()) + "_" + suffix);
    }
}
