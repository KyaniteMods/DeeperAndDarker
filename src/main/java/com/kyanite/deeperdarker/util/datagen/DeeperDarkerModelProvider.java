package com.kyanite.deeperdarker.util.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.*;

public class DeeperDarkerModelProvider extends FabricModelProvider {
    public DeeperDarkerModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators BlockModelGenerators) {
        BlockModelGenerators.woodProvider(DDBlocks.ECHO_LOG).log(DDBlocks.ECHO_LOG).wood(DDBlocks.ECHO_WOOD);
        BlockModelGenerators.woodProvider(DDBlocks.STRIPPED_ECHO_LOG).log(DDBlocks.STRIPPED_ECHO_LOG).wood(DDBlocks.STRIPPED_ECHO_WOOD);
        registerButton(BlockModelGenerators, DDBlocks.ECHO_BUTTON, DDBlocks.ECHO_PLANKS);
        BlockModelGenerators.createDoor(DDBlocks.ECHO_DOOR);
        registerFenceGate(BlockModelGenerators, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_PLANKS);
        registerFence(BlockModelGenerators, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_PLANKS);
        BlockModelGenerators.createHangingSign(DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN);
        BlockModelGenerators.family(DDBlocks.ECHO_LEAVES);
        BlockModelGenerators.family(DDBlocks.ECHO_PLANKS);
        registerPressurePlate(BlockModelGenerators, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_PLANKS);
        BlockModelGenerators.createCrossBlockWithDefaultItem(DDBlocks.ECHO_SAPLING, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        BlockModelGenerators.createHangingSign(DDBlocks.ECHO_PLANKS, DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_PLANKS);
        registerStairs(BlockModelGenerators, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_PLANKS);
        BlockModelGenerators.createOrientableTrapdoor(DDBlocks.ECHO_TRAPDOOR);

        BlockModelGenerators.family(DDBlocks.SCULK_STONE);
        registerStairs(BlockModelGenerators, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE);
        registerWall(BlockModelGenerators, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);
        BlockModelGenerators.family(DDBlocks.COBBLED_SCULK_STONE);
        registerStairs(BlockModelGenerators, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE);
        registerWall(BlockModelGenerators, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);
        BlockModelGenerators.family(DDBlocks.POLISHED_SCULK_STONE);
        registerStairs(BlockModelGenerators, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE);
        registerWall(BlockModelGenerators, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_BRICKS);
        registerStairs(BlockModelGenerators, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_BRICKS);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICKS);
        registerWall(BlockModelGenerators, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_BRICKS);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_TILES);
        registerStairs(BlockModelGenerators, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SCULK_STONE_TILES);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SCULK_STONE_TILES);
        registerWall(BlockModelGenerators, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SCULK_STONE_TILES);
        BlockModelGenerators.family(DDBlocks.SMOOTH_SCULK_STONE);
        registerStairs(BlockModelGenerators, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE);
        registerWall(BlockModelGenerators, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);
        BlockModelGenerators.family(DDBlocks.CUT_SCULK_STONE);
        registerStairs(BlockModelGenerators, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE);
        registerWall(BlockModelGenerators, DDBlocks.CUT_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE);
        BlockModelGenerators.family(DDBlocks.CHISELED_SCULK_STONE);

        BlockModelGenerators.family(DDBlocks.SCULK_GRIME);
        BlockModelGenerators.family(DDBlocks.SCULK_GRIME_BRICKS);
        registerStairs(BlockModelGenerators, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICKS);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS);
        registerWall(BlockModelGenerators, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);

        BlockModelGenerators.family(DDBlocks.GLOOMSLATE);
        registerStairs(BlockModelGenerators, DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE);
        registerWall(BlockModelGenerators, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);
        BlockModelGenerators.family(DDBlocks.COBBLED_GLOOMSLATE);
        registerStairs(BlockModelGenerators, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE);
        registerWall(BlockModelGenerators, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);
        BlockModelGenerators.family(DDBlocks.POLISHED_GLOOMSLATE);
        registerStairs(BlockModelGenerators, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE);
        registerWall(BlockModelGenerators, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE);
        BlockModelGenerators.family(DDBlocks.GLOOMSLATE_BRICKS);
        registerStairs(BlockModelGenerators, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_BRICKS);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICKS);
        registerWall(BlockModelGenerators, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_BRICKS);
        BlockModelGenerators.family(DDBlocks.GLOOMSLATE_TILES);
        registerStairs(BlockModelGenerators, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.GLOOMSLATE_TILES);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.GLOOMSLATE_TILES);
        registerWall(BlockModelGenerators, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.GLOOMSLATE_TILES);
        BlockModelGenerators.family(DDBlocks.SMOOTH_GLOOMSLATE);
        registerStairs(BlockModelGenerators, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE);
        registerWall(BlockModelGenerators, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);
        BlockModelGenerators.family(DDBlocks.CUT_GLOOMSLATE);
        registerStairs(BlockModelGenerators, DDBlocks.CUT_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE);
        registerSlabWithCubeAll(BlockModelGenerators, DDBlocks.CUT_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE);
        registerWall(BlockModelGenerators, DDBlocks.CUT_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE);
        BlockModelGenerators.family(DDBlocks.CHISELED_GLOOMSLATE);

        BlockModelGenerators.family(DDBlocks.ECHO_SOIL);
        BlockModelGenerators.family(DDBlocks.SCULK_GLEAM);

        BlockModelGenerators.family(DDBlocks.SCULK_STONE_COAL_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_IRON_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_COPPER_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_GOLD_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_EMERALD_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_LAPIS_ORE);
        BlockModelGenerators.family(DDBlocks.SCULK_STONE_DIAMOND_ORE);
        BlockModelGenerators.createCrossBlock(DDBlocks.SCULK_TENDRILS_PLANT, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        BlockModelGenerators.createCrossBlock(DDBlocks.SCULK_TENDRILS, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        BlockModelGenerators.createCrossBlock(DDBlocks.SCULK_VINES_PLANT, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        BlockModelGenerators.createCrossBlock(DDBlocks.SCULK_VINES, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);

        BlockModelGenerators.createNonTemplateModelBlock(DDBlocks.GLOOMY_CACTUS);
        BlockModelGenerators.delegateItemModel(DDBlocks.GLOOMY_CACTUS, ModelLocationUtils.getModelLocation(DDBlocks.GLOOMY_CACTUS));
        BlockModelGenerators.createCrossBlockWithDefaultItem(DDBlocks.GLOOMY_GRASS, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        BlockModelGenerators.family(DDBlocks.GLOOMY_SCULK);
        BlockModelGenerators.createNonTemplateModelBlock(DDBlocks.GLOOMY_GEYSER);
        Models.CUBE_BOTTOM_TOP.upload(DDBlocks.GLOOMY_GEYSER, TextureMap.of(TextureKey.TOP, new ResourceLocation(DeeperDarker.MOD_ID, "block/gloomy_geyser")).put(TextureKey.SIDE, TexturedModel.CUBE_ALL.get(DDBlocks.GLOOMY_SCULK).getTextures().getTexture(TextureKey.ALL)).put(TextureKey.BOTTOM, TexturedModel.CUBE_ALL.get(DDBlocks.GLOOMY_SCULK).getTextures().getTexture(TextureKey.ALL)),
                BlockModelGenerators.modelCollector);

        BlockModelGenerators.createNonTemplateModelBlock(DDBlocks.ANCIENT_VASE);
        BlockModelGenerators.registerParentedItemModel(DeeperDarkerItems.ANCIENT_VASE, ModelIds.getBlockModelId(DDBlocks.ANCIENT_VASE));
        BlockModelGenerators.registerParented(Blocks.SCULK, DDBlocks.INFESTED_SCULK);

        BlockModelGenerators.createNonTemplateModelBlock(DDBlocks.CRYSTALLIZED_AMBER);
        registerParented(BlockModelGenerators, Blocks.HONEY_BLOCK, DDBlocks.CRYSTALLIZED_AMBER,
                new Pair<>(TextureKey.UP, ModelIds.getBlockSubModelId(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Pair<>(TextureKey.SIDE, ModelIds.getBlockSubModelId(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Pair<>(TextureKey.PARTICLE, ModelIds.getBlockSubModelId(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Pair<>(TextureKey.DOWN, ModelIds.getBlockSubModelId(DDBlocks.CRYSTALLIZED_AMBER, "_outer")));

        BlockModelGenerators.registerParentedItemModel(DeeperDarkerItems.CRYSTALLIZED_AMBER, ModelIds.getBlockModelId(DDBlocks.CRYSTALLIZED_AMBER));

        BlockModelGenerators.blockStateCollector.accept(VariantsBlockStateSupplier.create(DDBlocks.OTHERSIDE_PORTAL).coordinate(BlockStateVariantMap.create(
                        Properties.AXIS).register(Direction.Axis.X, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(DDBlocks.OTHERSIDE_PORTAL, "_ns")))
                .register(Direction.Axis.Y, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(DDBlocks.OTHERSIDE_PORTAL, "_ns")).put(VariantSettings.X, VariantSettings.Rotation.R90))
                .register(Direction.Axis.Z, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(DDBlocks.OTHERSIDE_PORTAL, "_ew")))));
        registerParented(BlockModelGenerators, ModelIds.getBlockSubModelId(Blocks.NETHER_PORTAL, "_ew"), ModelIds.getBlockSubModelId(DDBlocks.OTHERSIDE_PORTAL, "_ew"),
                new Pair<>(TextureKey.PARTICLE, TextureMap.getId(DDBlocks.OTHERSIDE_PORTAL)),
                new Pair<>(TextureKey.of("portal"), TextureMap.getId(DDBlocks.OTHERSIDE_PORTAL)));
        registerParented(BlockModelGenerators, ModelIds.getBlockSubModelId(Blocks.NETHER_PORTAL, "_ns"), ModelIds.getBlockSubModelId(DDBlocks.OTHERSIDE_PORTAL, "_ns"),
                new Pair<>(TextureKey.PARTICLE, TextureMap.getId(DDBlocks.OTHERSIDE_PORTAL)),
                new Pair<>(TextureKey.of("portal"), TextureMap.getId(DDBlocks.OTHERSIDE_PORTAL)));

        registerSculkJaw(BlockModelGenerators, DDBlocks.SCULK_JAW);
        BlockModelGenerators.registerParentedItemModel(DeeperDarkerItems.SCULK_JAW, ModelIds.getBlockModelId(DDBlocks.SCULK_JAW));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }

    private static void registerButton(BlockModelGenerators BlockModelGenerators, Block block, Block planks) {
        ResourceLocation buttonModel = ModelTemplates.BUTTON.create(block, TexturedModel.CUBE.get(planks).getMapping(),
                BlockModelGenerators.modelOutput);
        ResourceLocation buttonPressedModel = ModelTemplates.BUTTON_PRESSED.create(block, TexturedModel.CUBE.get(planks).getMapping(),
                BlockModelGenerators.modelOutput);

        BlockModelGenerators.createButton(block, buttonModel, buttonPressedModel);
    }

    private static void registerFenceGate(BlockModelGenerators BlockModelGenerators, Block block, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        ResourceLocation fenceGateOpenModel = Models.TEMPLATE_FENCE_GATE_OPEN.upload(block, textureMap,
                BlockModelGenerators.modelCollector);
        ResourceLocation fenceGateModel = Models.TEMPLATE_FENCE_GATE.upload(block, textureMap,
                BlockModelGenerators.modelCollector);
        ResourceLocation wallFenceGateOpenModel = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(block, textureMap,
                BlockModelGenerators.modelCollector);
        ResourceLocation wallFenceGateModel = Models.TEMPLATE_FENCE_GATE_WALL.upload(block, textureMap,
                BlockModelGenerators.modelCollector);
        BlockModelGenerators.blockStateCollector.accept(BlockModelGenerators.createFenceGateBlockState(block, fenceGateOpenModel, fenceGateModel, wallFenceGateOpenModel, wallFenceGateModel, true));
    }

    private static void registerFence(BlockModelGenerators BlockModelGenerators, Block block, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        ResourceLocation fencePost = Models.FENCE_POST.upload(block, textureMap, BlockModelGenerators.modelCollector);
        ResourceLocation fenceSide = Models.FENCE_SIDE.upload(block, textureMap, BlockModelGenerators.modelCollector);
        BlockModelGenerators.blockStateCollector.accept(BlockModelGenerators.createFenceBlockState(block, fencePost, fenceSide));
    }

    private static void registerPressurePlate(BlockModelGenerators BlockModelGenerators, Block pressurePlate, Block textureSource) {
        TextureMap textureMap = TextureMap.texture(textureSource);
        ResourceLocation upModel = Models.PRESSURE_PLATE_UP.upload(pressurePlate, textureMap, BlockModelGenerators.modelCollector);
        ResourceLocation downModel = Models.PRESSURE_PLATE_DOWN.upload(pressurePlate, textureMap, BlockModelGenerators.modelCollector);
        BlockModelGenerators.blockStateCollector.accept(BlockModelGenerators.createPressurePlateBlockState(pressurePlate, upModel, downModel));
    }

    private static void registerSlabWithCubeAll(BlockModelGenerators BlockModelGenerators, Block slab, Block textureSource) {
        ResourceLocation ResourceLocation = ModelIds.getBlockModelId(textureSource);
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        ResourceLocation ResourceLocation2 = Models.SLAB.upload(slab, texturedModel.getTextures(), BlockModelGenerators.modelCollector);
        ResourceLocation ResourceLocation3 = Models.SLAB_TOP.upload(slab, texturedModel.getTextures(), BlockModelGenerators.modelCollector);
        BlockModelGenerators.blockStateCollector.accept(BlockModelGenerators.createSlabBlockState(slab, net.minecraft.resources.ResourceLocation2, net.minecraft.resources.ResourceLocation3, net.minecraft.resources.ResourceLocation));
    }

    private static void registerStairs(BlockModelGenerators BlockModelGenerators, Block stairs, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        TextureMap textureMap = texturedModel.getTextures();
        ResourceLocation innerModel = Models.INNER_STAIRS.upload(stairs, textureMap, BlockModelGenerators.modelCollector);
        ResourceLocation regularModel = Models.STAIRS.upload(stairs, textureMap, BlockModelGenerators.modelCollector);
        ResourceLocation outerModel = Models.OUTER_STAIRS.upload(stairs, textureMap, BlockModelGenerators.modelCollector);
        BlockModelGenerators.blockStateCollector.accept(BlockModelGenerators.createStairsBlockState(stairs, innerModel, regularModel, outerModel));
    }

    private static void registerWall(BlockModelGenerators BlockModelGenerators, Block wall, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(textureSource);
        TextureMap textureMap = texturedModel.getTextures();
        ResourceLocation postModel = Models.TEMPLATE_WALL_POST.upload(wall, textureMap, BlockModelGenerators.modelCollector);
        ResourceLocation sideModel = Models.TEMPLATE_WALL_SIDE.upload(wall, textureMap, BlockModelGenerators.modelCollector);
        ResourceLocation sideTallModel = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, textureMap, BlockModelGenerators.modelCollector);
        BlockModelGenerators.blockStateCollector.accept(BlockModelGenerators.createWallBlockState(wall, postModel, sideModel, sideTallModel));
    }

    private static void registerSculkJaw(BlockModelGenerators BlockModelGenerators, Block sculkJaw) {
        ResourceLocation sculkJawModel = Models.CUBE_TOP.upload(sculkJaw, TextureMap.of(TextureKey.TOP, TextureMap.getId(sculkJaw)).put(TextureKey.SIDE, TextureMap.getSubId(sculkJaw, "_side")), BlockModelGenerators.modelCollector);
        ResourceLocation sculkJawBitingModel = Models.CUBE_TOP.upload(ModelIds.getBlockSubModelId(sculkJaw, "_biting"), TextureMap.of(TextureKey.TOP, TextureMap.getSubId(sculkJaw, "_biting")).put(TextureKey.SIDE, TextureMap.getSubId(sculkJaw, "_side")), BlockModelGenerators.modelCollector);

        BlockModelGenerators.blockStateCollector.accept(VariantsBlockStateSupplier.create(DDBlocks.SCULK_JAW).coordinate(BlockModelGenerators.createBooleanModelMap(
                SculkJawBlock.BITING, sculkJawBitingModel, sculkJawModel)));
    }

    private static void registerWardenHelmet(ItemModelGenerator itemModelGenerator, ArmorItem armor) {
        ResourceLocation armorModelResourceLocation = ModelIds.getItemModelId(armor);
        ResourceLocation armorTextureResourceLocation = TextureMap.getId(armor);
        Models.GENERATED.upload(ResourceLocation, TextureMap.layer0(ResourceLocation), itemModelGenerator.writer, (id, textures) -> itemModelGenerator.createArmorJson(id, textures, armor.getMaterial()));
        for (ItemModelGenerator.TrimMaterial trimMaterial : ItemModelGenerator.TRIM_MATERIALS) {
            String string = trimMaterial.getAppliedName(armor.getMaterial());
            ResourceLocation ResourceLocation4 = itemModelGenerator.suffixTrim(ResourceLocation, string);
            String string2 = "warden_" + armor.getType().getName() + "_trim_" + string;
            ResourceLocation trimOverlayResourceLocation = new ResourceLocation(DeeperDarker.MOD_ID, string2).withPrefixedPath("trims/items/");
            itemModelGenerator.uploadArmor(ResourceLocation4, ResourceLocation, ResourceLocation);
        }
    }

    private static void registerGeneratedWithPredicate(ItemModelGenerator itemModelGenerator, Item item, String predicate, String suffix) {
        ResourceLocation withPredicate = Models.GENERATED.upload(Registries.ITEM.getId(item).withSuffixedPath(suffix).withPrefixedPath("item/"), TextureMap.layer0(Registries.ITEM.getId(item).withSuffixedPath(suffix).withPrefixedPath("item/")), itemModelGenerator.writer);
        JsonObject withoutPredicateJsonObject = Models.GENERATED.createJson(Registries.ITEM.getId(item).withPrefixedPath("item/"),
                Map.of(TextureKey.LAYER0, Registries.ITEM.getId(item).withPrefixedPath("item/")));
        JsonArray overrides = new JsonArray();
        JsonObject override = new JsonObject();
        JsonObject predicateJson = new JsonObject();
        predicateJson.addProperty(predicate, 1);
        override.add("predicate", predicateJson);
        override.addProperty("model", Registries.ITEM.getId(item).withSuffixedPath(suffix).withPrefixedPath("item/").toString());
        overrides.add(override);
        withoutPredicateJsonObject.add("overrides", overrides);
        itemModelGenerator.writer.accept(Registries.ITEM.getId(item).withPrefixedPath("item/"), () -> withoutPredicateJsonObject);
    }

    private static void registerSculkTransmitter(ItemModelGenerator itemModelGenerator, SculkTransmitterItem item) {
        registerGeneratedWithPredicate(itemModelGenerator, item, DeeperDarker.MOD_ID + ":linked", "_on");
    }

    private static void registerSpawnEgg(ItemModelGenerator itemModelGenerator, Item item) {
        JsonObject model = new JsonObject();
        model.addProperty("parent", new ResourceLocation("template_spawn_egg").withPrefixedPath("item/").toString());
        itemModelGenerator.writer.accept(Registries.ITEM.getId(item).withPrefixedPath("item/"), () -> model);
    }

    @SafeVarargs
    private static void registerParented(BlockModelGenerators BlockModelGenerators, Block parent, Block child, Pair<TextureKey, ResourceLocation> ... textures) {
        List<TextureKey> textureKeys = new ArrayList<>();
        TextureMap textureMap = new TextureMap();
        for (Pair<TextureKey, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getLeft());
            textureMap.put(pair.getLeft(), pair.getRight());
        }
        Model parentModel = new Model(Optional.of(ModelIds.getBlockModelId(parent)), Optional.empty(), textureKeys.toArray(new TextureKey[0]));

        parentModel.upload(child, textureMap, BlockModelGenerators.modelCollector);
    }

    @SafeVarargs
    private static void registerParented(BlockModelGenerators BlockModelGenerators, ResourceLocation parent, Block child, Pair<TextureKey, ResourceLocation> ... textures) {
        List<TextureKey> textureKeys = new ArrayList<>();
        TextureMap textureMap = new TextureMap();
        for (Pair<TextureKey, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getLeft());
            textureMap.put(pair.getLeft(), pair.getRight());
        }
        Model parentModel = new Model(Optional.of(parent), Optional.empty(), textureKeys.toArray(new TextureKey[0]));

        parentModel.upload(child, textureMap, BlockModelGenerators.modelCollector);
    }

    @SafeVarargs
    private static void registerParented(BlockModelGenerators BlockModelGenerators, Block parent, ResourceLocation child, Pair<TextureKey, ResourceLocation> ... textures) {
        List<TextureKey> textureKeys = new ArrayList<>();
        TextureMap textureMap = new TextureMap();
        for (Pair<TextureKey, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getLeft());
            textureMap.put(pair.getLeft(), pair.getRight());
        }
        Model parentModel = new Model(Optional.of(ModelIds.getBlockModelId(parent)), Optional.empty(), textureKeys.toArray(new TextureKey[0]));

        parentModel.upload(child, textureMap, BlockModelGenerators.modelCollector);
    }

    @SafeVarargs
    private static void registerParented(BlockModelGenerators BlockModelGenerators, ResourceLocation parent, ResourceLocation child, Pair<TextureKey, ResourceLocation> ... textures) {
        List<TextureKey> textureKeys = new ArrayList<>();
        TextureMap textureMap = new TextureMap();
        for (Pair<TextureKey, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getLeft());
            textureMap.put(pair.getLeft(), pair.getRight());
        }
        Model parentModel = new Model(Optional.of(parent), Optional.empty(), textureKeys.toArray(new TextureKey[0]));

        parentModel.upload(child, textureMap, BlockModelGenerators.modelCollector);
    }
}