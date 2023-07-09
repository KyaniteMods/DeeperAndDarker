package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class DeeperDarkerModelProvider extends FabricModelProvider {
    public DeeperDarkerModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(DeeperDarkerBlocks.ECHO_LOG).log(DeeperDarkerBlocks.ECHO_LOG).wood(DeeperDarkerBlocks.ECHO_WOOD);
        blockStateModelGenerator.registerLog(DeeperDarkerBlocks.STRIPPED_ECHO_LOG).log(DeeperDarkerBlocks.STRIPPED_ECHO_LOG).wood(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);
        registerButton(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_BUTTON, DeeperDarkerBlocks.ECHO_PLANKS);
        blockStateModelGenerator.registerDoor(DeeperDarkerBlocks.ECHO_DOOR);
        registerFenceGate(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_FENCE_GATE, DeeperDarkerBlocks.ECHO_PLANKS);
        registerFence(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_FENCE, DeeperDarkerBlocks.ECHO_PLANKS);
        blockStateModelGenerator.registerHangingSign(DeeperDarkerBlocks.STRIPPED_ECHO_LOG, DeeperDarkerBlocks.ECHO_HANGING_SIGN, DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.ECHO_LEAVES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.ECHO_PLANKS);
        registerPressurePlate(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_PRESSURE_PLATE, DeeperDarkerBlocks.ECHO_PLANKS);
        blockStateModelGenerator.registerTintableCross(DeeperDarkerBlocks.ECHO_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerHangingSign(DeeperDarkerBlocks.ECHO_PLANKS, DeeperDarkerBlocks.ECHO_SIGN, DeeperDarkerBlocks.ECHO_WALL_SIGN);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_SLAB, DeeperDarkerBlocks.ECHO_PLANKS);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_STAIRS, DeeperDarkerBlocks.ECHO_PLANKS);
        blockStateModelGenerator.registerOrientableTrapdoor(DeeperDarkerBlocks.ECHO_TRAPDOOR);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_STAIRS, DeeperDarkerBlocks.SCULK_STONE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_SLAB, DeeperDarkerBlocks.SCULK_STONE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_WALL, DeeperDarkerBlocks.SCULK_STONE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.COBBLED_SCULK_STONE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS, DeeperDarkerBlocks.COBBLED_SCULK_STONE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB, DeeperDarkerBlocks.COBBLED_SCULK_STONE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL, DeeperDarkerBlocks.COBBLED_SCULK_STONE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.POLISHED_SCULK_STONE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS, DeeperDarkerBlocks.POLISHED_SCULK_STONE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB, DeeperDarkerBlocks.POLISHED_SCULK_STONE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL, DeeperDarkerBlocks.POLISHED_SCULK_STONE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_BRICKS);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS, DeeperDarkerBlocks.SCULK_STONE_BRICKS);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB, DeeperDarkerBlocks.SCULK_STONE_BRICKS);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL, DeeperDarkerBlocks.SCULK_STONE_BRICKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_TILES);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS, DeeperDarkerBlocks.SCULK_STONE_TILES);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB, DeeperDarkerBlocks.SCULK_STONE_TILES);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_STONE_TILE_WALL, DeeperDarkerBlocks.SCULK_STONE_TILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SMOOTH_SCULK_STONE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS, DeeperDarkerBlocks.SMOOTH_SCULK_STONE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB, DeeperDarkerBlocks.SMOOTH_SCULK_STONE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL, DeeperDarkerBlocks.SMOOTH_SCULK_STONE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.CUT_SCULK_STONE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS, DeeperDarkerBlocks.CUT_SCULK_STONE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB, DeeperDarkerBlocks.CUT_SCULK_STONE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.CUT_SCULK_STONE_WALL, DeeperDarkerBlocks.CUT_SCULK_STONE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.CHISELED_SCULK_STONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_HOE, Models.HANDHELD);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.REINFORCED_ECHO_SHARD, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.WARDEN_CARAPACE, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.HEART_OF_THE_DEEP, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.SOUL_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.SOUL_DUST, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.SCULK_BONE, Models.GENERATED);
        Models.BUTTON_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.ECHO_BUTTON), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.ECHO_PLANKS).getTextures(), itemModelGenerator.writer);
        Models.FENCE_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.ECHO_FENCE), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.ECHO_PLANKS).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_STONE_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.SCULK_STONE).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.COBBLED_SCULK_STONE_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.COBBLED_SCULK_STONE).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.POLISHED_SCULK_STONE_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.POLISHED_SCULK_STONE).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_STONE_BRICK_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.SCULK_STONE_BRICKS).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_STONE_TILE_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.SCULK_STONE_TILES).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SMOOTH_SCULK_STONE_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.SMOOTH_SCULK_STONE).getTextures(), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.CUT_SCULK_STONE_WALL), TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.CUT_SCULK_STONE).getTextures(), itemModelGenerator.writer);
    }

    private static void registerButton(BlockStateModelGenerator blockStateModelGenerator, Block block, Block planks) {
        Identifier buttonModel = Models.BUTTON.upload(block, TexturedModel.CUBE_ALL.get(planks).getTextures(),
                blockStateModelGenerator.modelCollector);
        Identifier buttonPressedModel = Models.BUTTON_PRESSED.upload(block, TexturedModel.CUBE_ALL.get(planks).getTextures(),
                blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(block, buttonModel, buttonPressedModel));
    }

    private static void registerFenceGate(BlockStateModelGenerator blockStateModelGenerator, Block block, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        Identifier fenceGateOpenModel = Models.TEMPLATE_FENCE_GATE_OPEN.upload(block, textureMap,
                blockStateModelGenerator.modelCollector);
        Identifier fenceGateModel = Models.TEMPLATE_FENCE_GATE.upload(block, textureMap,
                blockStateModelGenerator.modelCollector);
        Identifier wallFenceGateOpenModel = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(block, textureMap,
                blockStateModelGenerator.modelCollector);
        Identifier wallFenceGateModel = Models.TEMPLATE_FENCE_GATE_WALL.upload(block, textureMap,
                blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(block, fenceGateOpenModel, fenceGateModel, wallFenceGateOpenModel, wallFenceGateModel, true));
    }

    private static void registerFence(BlockStateModelGenerator blockStateModelGenerator, Block block, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        Identifier fencePost = Models.FENCE_POST.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier fenceSide = Models.FENCE_SIDE.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(block, fencePost, fenceSide));
    }

    private static void registerPressurePlate(BlockStateModelGenerator blockStateModelGenerator, Block pressurePlate, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        Identifier upModel = Models.PRESSURE_PLATE_UP.upload(pressurePlate, textureMap, blockStateModelGenerator.modelCollector);
        Identifier downModel = Models.PRESSURE_PLATE_DOWN.upload(pressurePlate, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlate, upModel, downModel));
    }

    private static void registerSlabWithCubeAll(BlockStateModelGenerator blockStateModelGenerator, Block slab, Block textureSource) {
        Identifier identifier = ModelIds.getBlockModelId(textureSource);
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        Identifier identifier2 = Models.SLAB.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.SLAB_TOP.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slab, identifier2, identifier3, identifier));
    }

    private static void registerStairs(BlockStateModelGenerator blockStateModelGenerator, Block stairs, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        TextureMap textureMap = texturedModel.getTextures();
        Identifier innerModel = Models.INNER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
        Identifier regularModel = Models.STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
        Identifier outerModel = Models.OUTER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, innerModel, regularModel, outerModel));
    }

    private static void registerWall(BlockStateModelGenerator blockStateModelGenerator, Block wall, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        TextureMap textureMap = texturedModel.getTextures();
        Identifier postModel = Models.TEMPLATE_WALL_POST.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
        Identifier sideModel = Models.TEMPLATE_WALL_SIDE.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
        Identifier sideTallModel = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postModel, sideModel, sideTallModel));
    }
}