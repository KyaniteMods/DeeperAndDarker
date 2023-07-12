package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
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

        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_GRIME);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_GRIME_BRICKS);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS, DeeperDarkerBlocks.SCULK_GRIME_BRICKS);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB, DeeperDarkerBlocks.SCULK_GRIME_BRICKS);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.SCULK_GRIME_BRICK_WALL, DeeperDarkerBlocks.SCULK_GRIME_BRICKS);

        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.GLOOMSLATE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_STAIRS, DeeperDarkerBlocks.GLOOMSLATE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_SLAB, DeeperDarkerBlocks.GLOOMSLATE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_WALL, DeeperDarkerBlocks.GLOOMSLATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.COBBLED_GLOOMSLATE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS, DeeperDarkerBlocks.COBBLED_GLOOMSLATE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB, DeeperDarkerBlocks.COBBLED_GLOOMSLATE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.COBBLED_GLOOMSLATE_WALL, DeeperDarkerBlocks.COBBLED_GLOOMSLATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.POLISHED_GLOOMSLATE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS, DeeperDarkerBlocks.POLISHED_GLOOMSLATE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB, DeeperDarkerBlocks.POLISHED_GLOOMSLATE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.POLISHED_GLOOMSLATE_WALL, DeeperDarkerBlocks.POLISHED_GLOOMSLATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.GLOOMSLATE_BRICKS);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS, DeeperDarkerBlocks.GLOOMSLATE_BRICKS);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB, DeeperDarkerBlocks.GLOOMSLATE_BRICKS);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_BRICK_WALL, DeeperDarkerBlocks.GLOOMSLATE_BRICKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.GLOOMSLATE_TILES);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS, DeeperDarkerBlocks.GLOOMSLATE_TILES);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB, DeeperDarkerBlocks.GLOOMSLATE_TILES);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.GLOOMSLATE_TILE_WALL, DeeperDarkerBlocks.GLOOMSLATE_TILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS, DeeperDarkerBlocks.SMOOTH_GLOOMSLATE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB, DeeperDarkerBlocks.SMOOTH_GLOOMSLATE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_WALL, DeeperDarkerBlocks.SMOOTH_GLOOMSLATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.CUT_GLOOMSLATE);
        registerStairs(blockStateModelGenerator, DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS, DeeperDarkerBlocks.CUT_GLOOMSLATE);
        registerSlabWithCubeAll(blockStateModelGenerator, DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB, DeeperDarkerBlocks.CUT_GLOOMSLATE);
        registerWall(blockStateModelGenerator, DeeperDarkerBlocks.CUT_GLOOMSLATE_WALL, DeeperDarkerBlocks.CUT_GLOOMSLATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.CHISELED_GLOOMSLATE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.ECHO_SOIL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_GLEAM);

        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_COAL_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_IRON_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE);
        blockStateModelGenerator.registerTintableCrossBlockState(DeeperDarkerBlocks.SCULK_TENDRILS_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(DeeperDarkerBlocks.SCULK_TENDRILS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(DeeperDarkerBlocks.SCULK_VINES_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(DeeperDarkerBlocks.SCULK_VINES, BlockStateModelGenerator.TintType.NOT_TINTED);

//        Model cactusModel = new Model(Optional.of(ModelIds.getBlockModelId(Blocks.CACTUS)), Optional.empty(),
//        TextureKey.TOP, TextureKey.SIDE, TextureKey.BOTTOM);

//        cactusModel.upload(DeeperDarkerBlocks.GLOOMY_CACTUS,
//        TextureMap.of(TextureKey.TOP, new Identifier(DeeperDarker.MOD_ID, "block/gloomy_cactus_top"))
//        .put(TextureKey.SIDE, new Identifier(DeeperDarker.MOD_ID, "block/gloomy_cactus_side"))
//        .put(TextureKey.BOTTOM, new Identifier(DeeperDarker.MOD_ID, "block/gloomy_cactus_bottom")),
//                blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.registerSimpleState(DeeperDarkerBlocks.GLOOMY_CACTUS);
        blockStateModelGenerator.registerParentedItemModel(DeeperDarkerItems.GLOOMY_CACTUS, ModelIds.getBlockModelId(DeeperDarkerBlocks.GLOOMY_CACTUS));
        blockStateModelGenerator.registerTintableCross(DeeperDarkerBlocks.GLOOMY_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(DeeperDarkerBlocks.GLOOMY_SCULK);
        blockStateModelGenerator.registerSimpleState(DeeperDarkerBlocks.GLOOMY_GEYSER);
        Models.CUBE_BOTTOM_TOP.upload(DeeperDarkerBlocks.GLOOMY_GEYSER, TextureMap.of(TextureKey.TOP, new Identifier(DeeperDarker.MOD_ID, "block/gloomy_geyser")).put(TextureKey.SIDE, TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.GLOOMY_SCULK).getTextures().getTexture(TextureKey.ALL)).put(TextureKey.BOTTOM, TexturedModel.CUBE_ALL.get(DeeperDarkerBlocks.GLOOMY_SCULK).getTextures().getTexture(TextureKey.ALL)),
                blockStateModelGenerator.modelCollector);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerWardenHelmet(itemModelGenerator, (ArmorItem) DeeperDarkerItems.WARDEN_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) DeeperDarkerItems.WARDEN_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) DeeperDarkerItems.WARDEN_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) DeeperDarkerItems.WARDEN_BOOTS);
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
        itemModelGenerator.register(DeeperDarkerItems.GRIME_BALL, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.GRIME_BRICK, Models.GENERATED);
        Models.GENERATED.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_TENDRILS), TextureMap.layer0(DeeperDarkerBlocks.SCULK_TENDRILS_PLANT), itemModelGenerator.writer);
        Models.GENERATED.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_VINES), TextureMap.layer0(DeeperDarkerBlocks.SCULK_VINES_PLANT), itemModelGenerator.writer);
        Models.BUTTON_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.ECHO_BUTTON), TextureMap.all(DeeperDarkerBlocks.ECHO_PLANKS), itemModelGenerator.writer);
        Models.FENCE_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.ECHO_FENCE), TextureMap.all(DeeperDarkerBlocks.ECHO_PLANKS), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_STONE_WALL), TextureMap.all(DeeperDarkerBlocks.SCULK_STONE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.COBBLED_SCULK_STONE_WALL), TextureMap.all(DeeperDarkerBlocks.COBBLED_SCULK_STONE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.POLISHED_SCULK_STONE_WALL), TextureMap.all(DeeperDarkerBlocks.POLISHED_SCULK_STONE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_STONE_BRICK_WALL), TextureMap.all(DeeperDarkerBlocks.SCULK_STONE_BRICKS), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_STONE_TILE_WALL), TextureMap.all(DeeperDarkerBlocks.SCULK_STONE_TILES), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SMOOTH_SCULK_STONE_WALL), TextureMap.all(DeeperDarkerBlocks.SMOOTH_SCULK_STONE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.CUT_SCULK_STONE_WALL), TextureMap.all(DeeperDarkerBlocks.CUT_SCULK_STONE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SCULK_GRIME_BRICK_WALL), TextureMap.all(DeeperDarkerBlocks.SCULK_GRIME), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.GLOOMSLATE_WALL), TextureMap.all(DeeperDarkerBlocks.GLOOMSLATE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.COBBLED_GLOOMSLATE_WALL), TextureMap.all(DeeperDarkerBlocks.COBBLED_GLOOMSLATE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.POLISHED_GLOOMSLATE_WALL), TextureMap.all(DeeperDarkerBlocks.POLISHED_GLOOMSLATE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.GLOOMSLATE_BRICK_WALL), TextureMap.all(DeeperDarkerBlocks.GLOOMSLATE_BRICKS), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.GLOOMSLATE_TILE_WALL), TextureMap.all(DeeperDarkerBlocks.GLOOMSLATE_TILES), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.SMOOTH_GLOOMSLATE_WALL), TextureMap.all(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE), itemModelGenerator.writer);
        Models.WALL_INVENTORY.upload(ModelIds.getItemModelId(DeeperDarkerItems.CUT_GLOOMSLATE_WALL), TextureMap.all(DeeperDarkerBlocks.CUT_GLOOMSLATE), itemModelGenerator.writer);
        itemModelGenerator.register(DeeperDarkerItems.ECHO_BOAT, Models.GENERATED);
        itemModelGenerator.register(DeeperDarkerItems.ECHO_CHEST_BOAT, Models.GENERATED);
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

    private static void registerWardenHelmet(ItemModelGenerator itemModelGenerator, ArmorItem armor) {
        Identifier armorModelIdentifier = ModelIds.getItemModelId(armor);
        Identifier armorTextureIdentifier = TextureMap.getId(armor);
        Models.GENERATED.upload(armorModelIdentifier, TextureMap.layer0(armorTextureIdentifier), itemModelGenerator.writer, (id, textures) -> itemModelGenerator.createArmorJson(id, textures, armor.getMaterial()));
        for (ItemModelGenerator.TrimMaterial trimMaterial : ItemModelGenerator.TRIM_MATERIALS) {
            String string = trimMaterial.getAppliedName(armor.getMaterial());
            Identifier identifier4 = itemModelGenerator.suffixTrim(armorModelIdentifier, string);
            String string2 = "warden_" + armor.getType().getName() + "_trim_" + string;
            Identifier trimOverlayIdentifier = new Identifier(DeeperDarker.MOD_ID, string2).withPrefixedPath("trims/items/");
            itemModelGenerator.uploadArmor(identifier4, armorTextureIdentifier, trimOverlayIdentifier);
        }
    }
}