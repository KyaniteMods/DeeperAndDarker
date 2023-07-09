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
        registerWoodenSlab(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_SLAB, DeeperDarkerBlocks.ECHO_PLANKS);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.ECHO_STAIRS, DeeperDarkerBlocks.ECHO_PLANKS);
        blockStateModelGenerator.registerTrapdoor(DeeperDarkerBlocks.ECHO_TRAPDOOR);
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

    public final void registerPressurePlate(BlockStateModelGenerator blockStateModelGenerator, Block pressurePlate, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        Identifier upModel = Models.PRESSURE_PLATE_UP.upload(pressurePlate, textureMap, blockStateModelGenerator.modelCollector);
        Identifier downModel = Models.PRESSURE_PLATE_DOWN.upload(pressurePlate, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlate, upModel, downModel));
    }

    public final void registerWoodenSlab(BlockStateModelGenerator blockStateModelGenerator, Block slab, Block textureSource) {
        Identifier identifier = ModelIds.getBlockModelId(textureSource);
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        Identifier identifier2 = Models.SLAB.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.SLAB_TOP.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slab, identifier2, identifier3, identifier));
    }

    public final void registerStairs(BlockStateModelGenerator blockStateModelGenerator, Block stairs, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        TextureMap textureMap = texturedModel.getTextures();
        Identifier innerModel = Models.INNER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
        Identifier regularModel = Models.STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
        Identifier outerModel = Models.OUTER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, innerModel, regularModel, outerModel));
    }
}
