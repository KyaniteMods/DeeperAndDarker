package com.kyanite.deeperdarker.util.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ibm.icu.impl.Pair;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.SculkJawBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.*;

// TODO: FINISH BLOCK MODEL GEN AND DO ITEM MODEL GEN
public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
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
        ModelTemplates.CUBE_BOTTOM_TOP.create(DDBlocks.GLOOMY_GEYSER, TextureMapping.singleSlot(TextureSlot.TOP, new ResourceLocation(DeeperDarker.MOD_ID, "block/gloomy_geyser")).put(TextureSlot.SIDE, TexturedModel.CUBE.get(DDBlocks.GLOOMY_SCULK).getMapping().get(TextureSlot.ALL)).put(TextureSlot.BOTTOM, TexturedModel.CUBE.get(DDBlocks.GLOOMY_SCULK).getMapping().get(TextureSlot.ALL)),
                BlockModelGenerators.modelOutput);

        BlockModelGenerators.createNonTemplateModelBlock(DDBlocks.ANCIENT_VASE);
        BlockModelGenerators.delegateItemModel(DDBlocks.ANCIENT_VASE, ModelLocationUtils.getModelLocation(DDBlocks.ANCIENT_VASE));
        BlockModelGenerators.copyModel(Blocks.SCULK, DDBlocks.INFESTED_SCULK);

        BlockModelGenerators.createNonTemplateModelBlock(DDBlocks.CRYSTALLIZED_AMBER);
        registerParented(BlockModelGenerators, Blocks.HONEY_BLOCK, DDBlocks.CRYSTALLIZED_AMBER,
                new Pair<>(TextureSlot.UP, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Pair<>(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Pair<>(TextureSlot.PARTICLE, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Pair<>(TextureSlot.DOWN, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_outer")));

        BlockModelGenerators.delegateItemModel(DDBlocks.CRYSTALLIZED_AMBER, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER));

        BlockModelGenerators.modelOutput.accept(MultiVariantGenerator.multiVariant(DDBlocks.OTHERSIDE_PORTAL).with(PropertyDispatch.properties(
                        BlockStateProperties.AXIS).register(Direction.Axis.X, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(DDBlocks.OTHERSIDE_PORTAL, "_ns")))
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
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        ResourceLocation fenceGateOpenModel = ModelTemplates.FENCE_GATE_OPEN.create(block, textureMap,
                BlockModelGenerators.modelOutput);
        ResourceLocation fenceGateModel = ModelTemplates.FENCE_GATE_CLOSED.create(block, textureMap,
                BlockModelGenerators.modelOutput);
        ResourceLocation wallFenceGateOpenModel = ModelTemplates.FENCE_GATE_WALL_OPEN.create(block, textureMap,
                BlockModelGenerators.modelOutput);
        ResourceLocation wallFenceGateModel = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(block, textureMap,
                BlockModelGenerators.modelOutput);
        BlockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createFenceGate(block, fenceGateOpenModel, fenceGateModel, wallFenceGateOpenModel, wallFenceGateModel, true));
    }

    private static void registerFence(BlockModelGenerators BlockModelGenerators, Block block, Block textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        ResourceLocation fencePost = ModelTemplates.FENCE_POST.create(block, textureMap, BlockModelGenerators.modelOutput);
        ResourceLocation fenceSide = ModelTemplates.FENCE_SIDE.create(block, textureMap, BlockModelGenerators.modelOutput);
        BlockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createFence(block, fencePost, fenceSide));
    }

    private static void registerPressurePlate(BlockModelGenerators BlockModelGenerators, Block pressurePlate, Block textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        ResourceLocation upModel = ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlate, textureMap, BlockModelGenerators.modelOutput);
        ResourceLocation downModel = ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlate, textureMap, BlockModelGenerators.modelOutput);
        BlockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createPressurePlate(pressurePlate, upModel, downModel));
    }

    private static void registerSlabWithCubeAll(BlockModelGenerators BlockModelGenerators, Block slab, Block textureSource) {
        ResourceLocation ResourceLocation = ModelLocationUtils.getModelLocation(textureSource);
        TexturedModel texturedModel = TexturedModel.CUBE.get(textureSource);
        ResourceLocation ResourceLocation2 = ModelTemplates.SLAB_BOTTOM.create(slab, texturedModel.getMapping(), BlockModelGenerators.modelOutput);
        ResourceLocation ResourceLocation3 = ModelTemplates.SLAB_TOP.create(slab, texturedModel.getMapping(), BlockModelGenerators.modelOutput);
        BlockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(slab, ResourceLocation2, ResourceLocation3, ResourceLocation));
    }

    private static void registerStairs(BlockModelGenerators BlockModelGenerators, Block stairs, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE.get(textureSource);
        TextureMapping textureMap = texturedModel.getMapping();
        ResourceLocation innerModel = ModelTemplates.STAIRS_INNER.create(stairs, textureMap, BlockModelGenerators.modelOutput);
        ResourceLocation regularModel = ModelTemplates.STAIRS_STRAIGHT.create(stairs, textureMap, BlockModelGenerators.modelOutput);
        ResourceLocation outerModel = ModelTemplates.STAIRS_OUTER.create(stairs, textureMap, BlockModelGenerators.modelOutput);
        BlockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs, innerModel, regularModel, outerModel));
    }

    private static void registerWall(BlockModelGenerators BlockModelGenerators, Block wall, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE.get(textureSource);
        TextureMapping textureMap = texturedModel.getMapping();
        ResourceLocation postModel = ModelTemplates.WALL_POST.create(wall, textureMap, BlockModelGenerators.modelOutput);
        ResourceLocation sideModel = ModelTemplates.WALL_LOW_SIDE.create(wall, textureMap, BlockModelGenerators.modelOutput);
        ResourceLocation sideTallModel = ModelTemplates.WALL_TALL_SIDE.create(wall, textureMap, BlockModelGenerators.modelOutput);
        BlockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createWall(wall, postModel, sideModel, sideTallModel));
    }

    private static void registerSculkJaw(BlockModelGenerators BlockModelGenerators, Block sculkJaw) {
        ResourceLocation sculkJawModel = ModelTemplates.CUBE_TOP.create(sculkJaw, TextureMapping.singleSlot(TextureSlot.TOP, TextureMapping.getBlockTexture(sculkJaw)).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(sculkJaw, "_side")), BlockModelGenerators.modelOutput);
        ResourceLocation sculkJawBitingModel = ModelTemplates.CUBE_TOP.create(ModelLocationUtils.getModelLocation(sculkJaw, "_biting"), TextureMapping.singleSlot(TextureSlot.TOP, TextureMapping.getBlockTexture(sculkJaw, "_biting")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(sculkJaw, "_side")), BlockModelGenerators.modelOutput);

        BlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(DDBlocks.SCULK_JAW).with(BlockModelGenerators.createBooleanModelDispatch(
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