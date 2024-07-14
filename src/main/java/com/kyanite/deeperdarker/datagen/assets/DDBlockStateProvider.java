package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import com.kyanite.deeperdarker.content.blocks.SculkJawBlock;
import com.kyanite.deeperdarker.content.blocks.vegetation.GlowingVinesPlantBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
        simpleBlock(DDBlocks.ECHO_SAPLING.get(), models().cross(DDBlocks.ECHO_SAPLING.getId().getPath(), blockLoc(DDBlocks.ECHO_SAPLING)).renderType("cutout"));
        signBlock(DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get(), blockLoc(DDBlocks.ECHO_PLANKS));
        simpleBlock(DDBlocks.ECHO_HANGING_SIGN.get(), models().sign(DDBlocks.ECHO_HANGING_SIGN.getId().getPath(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        simpleBlock(DDBlocks.ECHO_WALL_HANGING_SIGN.get(), models().sign(DDBlocks.ECHO_HANGING_SIGN.getId().getPath(), blockLoc(DDBlocks.STRIPPED_ECHO_LOG)));
        simpleBlock(DDBlocks.POTTED_ECHO_SAPLING.get(), models().withExistingParent(DDBlocks.POTTED_ECHO_SAPLING.getId().getPath(), mcLoc("flower_pot_cross")).texture("plant", blockLoc(DDBlocks.ECHO_SAPLING)).renderType("cutout"));

        stemBlock(DDBlocks.BLOOMING_STEM);
        stemBlock(DDBlocks.STRIPPED_BLOOMING_STEM);
        simpleBlock(DDBlocks.BLOOM_PLANKS.get());
        stairsBlock(DDBlocks.BLOOM_STAIRS.get(), blockLoc(DDBlocks.BLOOM_PLANKS));
        slabBlock(DDBlocks.BLOOM_SLAB.get(), blockLoc(DDBlocks.BLOOM_PLANKS), blockLoc(DDBlocks.BLOOM_PLANKS));
        fenceBlock(DDBlocks.BLOOM_FENCE, blockLoc(DDBlocks.BLOOM_PLANKS));
        fenceGateBlock(DDBlocks.BLOOM_FENCE_GATE.get(), blockLoc(DDBlocks.BLOOM_PLANKS));
        doorBlockWithRenderType(DDBlocks.BLOOM_DOOR.get(), blockLoc(DDBlocks.BLOOM_DOOR, "bottom"), blockLoc(DDBlocks.BLOOM_DOOR, "top"), "cutout");
        trapdoorBlockWithRenderType(DDBlocks.BLOOM_TRAPDOOR.get(), blockLoc(DDBlocks.BLOOM_TRAPDOOR), true, "cutout");
        pressurePlateBlock(DDBlocks.BLOOM_PRESSURE_PLATE.get(), blockLoc(DDBlocks.BLOOM_PLANKS));
        buttonBlock(DDBlocks.BLOOM_BUTTON, blockLoc(DDBlocks.BLOOM_PLANKS));
        signBlock(DDBlocks.BLOOM_SIGN.get(), DDBlocks.BLOOM_WALL_SIGN.get(), blockLoc(DDBlocks.BLOOM_PLANKS));
        simpleBlock(DDBlocks.BLOOM_HANGING_SIGN.get(), models().sign(DDBlocks.BLOOM_HANGING_SIGN.getId().getPath(), blockLoc(DDBlocks.STRIPPED_BLOOMING_STEM)));
        simpleBlock(DDBlocks.BLOOM_WALL_HANGING_SIGN.get(), models().sign(DDBlocks.BLOOM_HANGING_SIGN.getId().getPath(), blockLoc(DDBlocks.STRIPPED_BLOOMING_STEM)));
        simpleBlock(DDBlocks.POTTED_BLOOMING_STEM.get(), models().getExistingFile(blockLoc(DDBlocks.POTTED_BLOOMING_STEM)));

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

        simpleBlock(DDBlocks.BLOOMING_SCULK_STONE.get(), models().cubeBottomTop(DDBlocks.BLOOMING_SCULK_STONE.getId().getPath(), blockLoc(DDBlocks.BLOOMING_SCULK_STONE), blockLoc(DDBlocks.SCULK_STONE), blockLoc(DDBlocks.BLOOMING_SCULK_STONE, "top")));
        simpleBlock(DDBlocks.BLOOMING_MOSS_BLOCK.get());

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

        simpleBlock(DDBlocks.SCULK_GRIME.get());
        simpleBlock(DDBlocks.SCULK_GRIME_BRICKS.get());
        stairsBlock(DDBlocks.SCULK_GRIME_BRICK_STAIRS.get(), blockLoc(DDBlocks.SCULK_GRIME_BRICKS));
        slabBlock(DDBlocks.SCULK_GRIME_BRICK_SLAB.get(), blockLoc(DDBlocks.SCULK_GRIME_BRICKS), blockLoc(DDBlocks.SCULK_GRIME_BRICKS));
        wallBlock(DDBlocks.SCULK_GRIME_BRICK_WALL, blockLoc(DDBlocks.SCULK_GRIME_BRICKS));

        simpleBlock(DDBlocks.ECHO_SOIL.get());
        simpleBlock(DDBlocks.GLOOMY_SCULK.get());
        simpleBlock(DDBlocks.GLOOMY_GEYSER.get(), models().cubeTop(DDBlocks.GLOOMY_GEYSER.getId().getPath(), blockLoc(DDBlocks.GLOOMY_SCULK), blockLoc(DDBlocks.GLOOMY_GEYSER)));
        simpleBlock(DDBlocks.CRYSTALLIZED_AMBER.get(), models().withExistingParent(DDBlocks.CRYSTALLIZED_AMBER.getId().getPath(), mcLoc("block/honey_block")).texture("particle", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).texture("down", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "outer")).texture("up", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).texture("side", blockLoc(DDBlocks.CRYSTALLIZED_AMBER, "inner")).renderType("translucent"));
        simpleBlock(DDBlocks.SCULK_GLEAM.get());

        simpleBlock(DDBlocks.SCULK_STONE_COAL_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_IRON_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        simpleBlock(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_COAL_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_IRON_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_COPPER_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_GOLD_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_REDSTONE_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_EMERALD_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_LAPIS_ORE.get());
        simpleBlock(DDBlocks.GLOOMSLATE_DIAMOND_ORE.get());

        horizontalBlock(DDBlocks.GLOWING_FLOWERS.get(), models().getExistingFile(blockLoc(DDBlocks.GLOWING_FLOWERS)));
        simpleBlock(DDBlocks.GLOWING_GRASS.get(), models().cross(DDBlocks.GLOWING_GRASS.getId().getPath(), blockLoc(DDBlocks.GLOWING_GRASS)).renderType("cutout"));
        simpleBlock(DDBlocks.GLOOMY_GRASS.get(), models().cross(DDBlocks.GLOOMY_GRASS.getId().getPath(), blockLoc(DDBlocks.GLOOMY_GRASS)).renderType("cutout"));
        simpleBlock(DDBlocks.GLOOMY_CACTUS.get(), models().getExistingFile(blockLoc(DDBlocks.GLOOMY_CACTUS)));
        simpleBlock(DDBlocks.SCULK_TENDRILS.get(), models().cross(DDBlocks.SCULK_TENDRILS.getId().getPath(), blockLoc(DDBlocks.SCULK_TENDRILS)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_TENDRILS_PLANT.get(), models().cross(DDBlocks.SCULK_TENDRILS_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_TENDRILS_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_VINES.get(), models().cross(DDBlocks.SCULK_VINES.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES)).renderType("cutout"));
        simpleBlock(DDBlocks.SCULK_VINES_PLANT.get(), models().cross(DDBlocks.SCULK_VINES_PLANT.getId().getPath(), blockLoc(DDBlocks.SCULK_VINES_PLANT)).renderType("cutout"));
        simpleBlock(DDBlocks.GLOWING_VINES.get(), models().cross(DDBlocks.GLOWING_VINES.getId().getPath(), blockLoc(DDBlocks.GLOWING_VINES)).renderType("cutout"));
        simpleBlock(DDBlocks.GLOWING_ROOTS.get(), models().cross(DDBlocks.GLOWING_ROOTS.getId().getPath(), blockLoc(DDBlocks.GLOWING_ROOTS)).renderType("cutout"));
        simpleBlock(DDBlocks.GLOWING_ROOTS_PLANT.get(), models().cross(DDBlocks.GLOWING_ROOTS_PLANT.getId().getPath(), blockLoc(DDBlocks.GLOWING_ROOTS_PLANT)).renderType("cutout"));
        ModelFile noBerries = models().cross(DDBlocks.GLOWING_VINES_PLANT.getId().getPath(), blockLoc(DDBlocks.GLOWING_VINES_PLANT)).renderType("cutout");
        ModelFile berries = models().cross(DDBlocks.GLOWING_VINES_PLANT.getId().getPath() + "_berries", blockLoc(DDBlocks.GLOWING_VINES_PLANT, "berries")).renderType("cutout");
        getVariantBuilder(DDBlocks.GLOWING_VINES_PLANT.get()).partialState().with(GlowingVinesPlantBlock.BERRIES, false).modelForState().modelFile(noBerries).addModel().partialState().with(GlowingVinesPlantBlock.BERRIES, true).modelForState().modelFile(berries).addModel();
        simpleBlock(DDBlocks.ICE_LILY.get(), models().getExistingFile(blockLoc(DDBlocks.ICE_LILY)));

        simpleBlock(DDBlocks.INFESTED_SCULK.get(), cubeAll(Blocks.SCULK));
        ModelFile jaw = models().cubeTop(DDBlocks.SCULK_JAW.getId().getPath(), blockLoc(DDBlocks.SCULK_JAW, "side"), blockLoc(DDBlocks.SCULK_JAW));
        ModelFile jawBiting = models().cubeTop(DDBlocks.SCULK_JAW.getId().getPath() + "_biting", blockLoc(DDBlocks.SCULK_JAW, "side"), blockLoc(DDBlocks.SCULK_JAW, "biting"));
        getVariantBuilder(DDBlocks.SCULK_JAW.get())
                .partialState().with(SculkJawBlock.BITING, false).modelForState().modelFile(jaw).addModel()
                .partialState().with(SculkJawBlock.BITING, true).modelForState().modelFile(jawBiting).addModel();

        simpleBlock(DDBlocks.ANCIENT_VASE.get(), models().getExistingFile(blockLoc(DDBlocks.ANCIENT_VASE)));
        getVariantBuilder(DDBlocks.OTHERSIDE_PORTAL.get())
                .partialState().with(OthersidePortalBlock.AXIS, Direction.Axis.X).modelForState().modelFile(models().getExistingFile(blockLoc(DDBlocks.OTHERSIDE_PORTAL, "ns"))).addModel()
                .partialState().with(OthersidePortalBlock.AXIS, Direction.Axis.Z).modelForState().modelFile(models().getExistingFile(blockLoc(DDBlocks.OTHERSIDE_PORTAL, "ew"))).addModel();
    }

    private void stemBlock(DeferredBlock<Block> block) {
        ModelFile stem = models().withExistingParent(block.getId().getPath(), modLoc("stem")).texture("stem", blockLoc(block));
        ModelFile horizontal = models().withExistingParent(block.getId().getPath() + "_horizontal", modLoc("stem_horizontal")).texture("stem", blockLoc(block));
        ModelFile vertical = models().withExistingParent(block.getId().getPath() + "_vertical", modLoc("stem_vertical")).texture("stem", blockLoc(block));
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block.get()).part().modelFile(stem).addModel().end();
        PipeBlock.PROPERTY_BY_DIRECTION.forEach((direction, value) -> {
            if(direction.getAxis().isHorizontal()) builder.part().modelFile(horizontal).rotationY((((int) direction.toYRot()) + 270) % 360).uvLock(true).addModel().condition(value, true);
            if(direction == Direction.UP) builder.part().modelFile(vertical).rotationX(0).uvLock(true).addModel().condition(value, true);
            if(direction == Direction.DOWN) builder.part().modelFile(vertical).rotationX(180).uvLock(true).addModel().condition(value, true);
        });
        models().singleTexture(block.getId().getPath() + "_inventory", modLoc("stem_inventory"), "stem", blockLoc(block));
    }

    private void fenceBlock(DeferredBlock<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void buttonBlock(DeferredBlock<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void wallBlock(DeferredBlock<WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(block.getId().getPath() + "_inventory", texture);
    }

    private ResourceLocation blockLoc(DeferredBlock<? extends Block> block) {
        return modLoc("block/" + block.getId().getPath());
    }

    public ResourceLocation blockLoc(DeferredBlock<? extends Block> block, String suffix) {
        return modLoc("block/" + block.getId().getPath() + "_" + suffix);
    }
}
