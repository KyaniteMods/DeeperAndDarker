package com.kyanite.deeperdarker.util.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.BloomingStemBlock;
import com.kyanite.deeperdarker.content.blocks.SculkJawBlock;
import com.kyanite.deeperdarker.content.blocks.vegetation.GlowingVinesPlantBlock;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.apache.commons.lang3.tuple.Triple;

import java.util.*;

public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        createGildedLog(blockModelGenerators, DDBlocks.ENRICHED_ECHO_LOG, DDBlocks.ECHO_LOG);
        blockModelGenerators.woodProvider(DDBlocks.ECHO_LOG).log(DDBlocks.ECHO_LOG).wood(DDBlocks.ECHO_WOOD);
        blockModelGenerators.woodProvider(DDBlocks.STRIPPED_ECHO_LOG).log(DDBlocks.STRIPPED_ECHO_LOG).wood(DDBlocks.STRIPPED_ECHO_WOOD);
        blockModelGenerators.family(DDBlocks.ECHO_LEAVES);
        blockModelGenerators.family(DDBlocks.ECHO_PLANKS);
        registerStairs(blockModelGenerators, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_PLANKS);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_PLANKS);
        registerFence(blockModelGenerators, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_PLANKS);
        registerFenceGate(blockModelGenerators, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_PLANKS);
        blockModelGenerators.createDoor(DDBlocks.ECHO_DOOR);
        blockModelGenerators.createOrientableTrapdoor(DDBlocks.ECHO_TRAPDOOR);
        registerPressurePlate(blockModelGenerators, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_PLANKS);
        registerButton(blockModelGenerators, DDBlocks.ECHO_BUTTON, DDBlocks.ECHO_PLANKS);
        blockModelGenerators.createCrossBlockWithDefaultItem(DDBlocks.ECHO_SAPLING, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createHangingSign(DDBlocks.ECHO_PLANKS, DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN);
        blockModelGenerators.createHangingSign(DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN);

        blockModelGenerators.family(DDBlocks.SCULK_STONE);
        registerStairs(blockModelGenerators, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE);
        registerWall(blockModelGenerators, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);
        blockModelGenerators.family(DDBlocks.COBBLED_SCULK_STONE);
        registerStairs(blockModelGenerators, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE);
        registerWall(blockModelGenerators, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);
        blockModelGenerators.family(DDBlocks.POLISHED_SCULK_STONE);
        registerStairs(blockModelGenerators, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE);
        registerWall(blockModelGenerators, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_BRICKS);
        registerStairs(blockModelGenerators, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_BRICKS);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICKS);
        registerWall(blockModelGenerators, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_BRICKS);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_TILES);
        registerStairs(blockModelGenerators, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SCULK_STONE_TILES);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SCULK_STONE_TILES);
        registerWall(blockModelGenerators, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SCULK_STONE_TILES);
        blockModelGenerators.family(DDBlocks.SMOOTH_SCULK_STONE);
        registerStairs(blockModelGenerators, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE);
        registerWall(blockModelGenerators, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);
        blockModelGenerators.family(DDBlocks.CUT_SCULK_STONE);
        registerStairs(blockModelGenerators, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE);
        registerWall(blockModelGenerators, DDBlocks.CUT_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE);
        blockModelGenerators.family(DDBlocks.CHISELED_SCULK_STONE);

        blockModelGenerators.family(DDBlocks.SCULK_GRIME);
        blockModelGenerators.family(DDBlocks.SCULK_GRIME_BRICKS);
        registerStairs(blockModelGenerators, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICKS);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS);
        registerWall(blockModelGenerators, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);

        blockModelGenerators.family(DDBlocks.GLOOMSLATE);
        registerStairs(blockModelGenerators, DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE);
        registerWall(blockModelGenerators, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);
        blockModelGenerators.family(DDBlocks.COBBLED_GLOOMSLATE);
        registerStairs(blockModelGenerators, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE);
        registerWall(blockModelGenerators, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);
        blockModelGenerators.family(DDBlocks.POLISHED_GLOOMSLATE);
        registerStairs(blockModelGenerators, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE);
        registerWall(blockModelGenerators, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_BRICKS);
        registerStairs(blockModelGenerators, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_BRICKS);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICKS);
        registerWall(blockModelGenerators, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_BRICKS);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_TILES);
        registerStairs(blockModelGenerators, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.GLOOMSLATE_TILES);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.GLOOMSLATE_TILES);
        registerWall(blockModelGenerators, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.GLOOMSLATE_TILES);
        blockModelGenerators.family(DDBlocks.SMOOTH_GLOOMSLATE);
        registerStairs(blockModelGenerators, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE);
        registerWall(blockModelGenerators, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);
        blockModelGenerators.family(DDBlocks.CUT_GLOOMSLATE);
        registerStairs(blockModelGenerators, DDBlocks.CUT_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.CUT_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE);
        registerWall(blockModelGenerators, DDBlocks.CUT_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE);
        blockModelGenerators.family(DDBlocks.CHISELED_GLOOMSLATE);

        blockModelGenerators.family(DDBlocks.ECHO_SOIL);
        blockModelGenerators.family(DDBlocks.SCULK_GLEAM);

        blockModelGenerators.family(DDBlocks.SCULK_STONE_COAL_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_IRON_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_COPPER_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_GOLD_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_EMERALD_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_LAPIS_ORE);
        blockModelGenerators.family(DDBlocks.SCULK_STONE_DIAMOND_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_COAL_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_IRON_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_COPPER_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_GOLD_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_REDSTONE_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_EMERALD_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_LAPIS_ORE);
        blockModelGenerators.family(DDBlocks.GLOOMSLATE_DIAMOND_ORE);
        blockModelGenerators.createCrossBlock(DDBlocks.SCULK_TENDRILS_PLANT, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createCrossBlock(DDBlocks.SCULK_TENDRILS, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createCrossBlock(DDBlocks.SCULK_VINES_PLANT, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createCrossBlock(DDBlocks.SCULK_VINES, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createCrossBlock(DDBlocks.GLOWING_ROOTS_PLANT, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createCrossBlock(DDBlocks.GLOWING_ROOTS, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.createCrossBlock(DDBlocks.GLOWING_VINES, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);

        ModelTemplates.CROSS.create(ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_VINES_PLANT), TextureMapping.cross(TextureMapping.getBlockTexture(DDBlocks.GLOWING_VINES_PLANT)), blockModelGenerators.modelOutput);
        ModelTemplates.CROSS.create(ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_VINES_PLANT, "_berries"), TextureMapping.cross(TextureMapping.getBlockTexture(DDBlocks.GLOWING_VINES_PLANT).withSuffix("_berries")), blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(DDBlocks.GLOWING_VINES_PLANT)
                        .with(PropertyDispatch.property(GlowingVinesPlantBlock.BERRIES)
                                .select(false, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_VINES_PLANT)))
                                .select(true, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_VINES_PLANT, "_berries")))
                        )
        );

        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.GLOOMY_CACTUS);
        blockModelGenerators.delegateItemModel(DDBlocks.GLOOMY_CACTUS, ModelLocationUtils.getModelLocation(DDBlocks.GLOOMY_CACTUS));
        blockModelGenerators.createCrossBlockWithDefaultItem(DDBlocks.GLOOMY_GRASS, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
        blockModelGenerators.family(DDBlocks.GLOOMY_SCULK);
        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.GLOOMY_GEYSER);
        ModelTemplates.CUBE_BOTTOM_TOP.create(DDBlocks.GLOOMY_GEYSER, TextureMapping.singleSlot(TextureSlot.TOP, new ResourceLocation(DeeperDarker.MOD_ID, "block/gloomy_geyser")).put(TextureSlot.SIDE, TexturedModel.CUBE.get(DDBlocks.GLOOMY_SCULK).getMapping().get(TextureSlot.ALL)).put(TextureSlot.BOTTOM, TexturedModel.CUBE.get(DDBlocks.GLOOMY_SCULK).getMapping().get(TextureSlot.ALL)),
                blockModelGenerators.modelOutput);

        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.ANCIENT_VASE);
        blockModelGenerators.delegateItemModel(DDBlocks.ANCIENT_VASE, ModelLocationUtils.getModelLocation(DDBlocks.ANCIENT_VASE));

        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.CRYSTALLIZED_AMBER);
        registerParented(blockModelGenerators, Blocks.HONEY_BLOCK, DDBlocks.CRYSTALLIZED_AMBER,
                new Tuple<>(TextureSlot.UP, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Tuple<>(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Tuple<>(TextureSlot.PARTICLE, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_inner")),
                new Tuple<>(TextureSlot.DOWN, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER, "_outer")));

        blockModelGenerators.delegateItemModel(DDBlocks.CRYSTALLIZED_AMBER, ModelLocationUtils.getModelLocation(DDBlocks.CRYSTALLIZED_AMBER));

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(DDBlocks.OTHERSIDE_PORTAL).with(PropertyDispatch.property(
                        BlockStateProperties.AXIS).select(Direction.Axis.X, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(DDBlocks.OTHERSIDE_PORTAL, "_ns")))
                .select(Direction.Axis.Y, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(DDBlocks.OTHERSIDE_PORTAL, "_ns")).with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
                .select(Direction.Axis.Z, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(DDBlocks.OTHERSIDE_PORTAL, "_ew")))));
        registerParented(blockModelGenerators, ModelLocationUtils.getModelLocation(Blocks.NETHER_PORTAL, "_ew"), ModelLocationUtils.getModelLocation(DDBlocks.OTHERSIDE_PORTAL, "_ew"),
                new Tuple<>(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(DDBlocks.OTHERSIDE_PORTAL)),
                new Tuple<>(TextureSlot.create("portal"), TextureMapping.getBlockTexture(DDBlocks.OTHERSIDE_PORTAL)));
        registerParented(blockModelGenerators, ModelLocationUtils.getModelLocation(Blocks.NETHER_PORTAL, "_ns"), ModelLocationUtils.getModelLocation(DDBlocks.OTHERSIDE_PORTAL, "_ns"),
                new Tuple<>(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(DDBlocks.OTHERSIDE_PORTAL)),
                new Tuple<>(TextureSlot.create("portal"), TextureMapping.getBlockTexture(DDBlocks.OTHERSIDE_PORTAL)));

        blockModelGenerators.copyModel(Blocks.SCULK, DDBlocks.INFESTED_SCULK);
        registerSculkJaw(blockModelGenerators, DDBlocks.SCULK_JAW);
        blockModelGenerators.delegateItemModel(DDBlocks.SCULK_JAW, ModelLocationUtils.getModelLocation(DDBlocks.SCULK_JAW));
        ModelTemplates.FLOWER_POT_CROSS.create(DDBlocks.POTTED_ECHO_SAPLING, TextureMapping.plant(DDBlocks.ECHO_SAPLING), blockModelGenerators.modelOutput);
        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.POTTED_ECHO_SAPLING);
        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.POTTED_BLOOMING_STEM);

        registerParented(blockModelGenerators, new ResourceLocation(DeeperDarker.MOD_ID, "block/flowers"), ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_FLOWERS),
                new Tuple<>(TextureSlot.create("flowers"), TextureMapping.getBlockTexture(DDBlocks.GLOWING_FLOWERS)),
                new Tuple<>(TextureSlot.STEM, TextureMapping.getBlockTexture(DDBlocks.GLOWING_FLOWERS).withSuffix("_stem")));
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(DDBlocks.GLOWING_FLOWERS, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_FLOWERS))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        blockModelGenerators.createCrossBlockWithDefaultItem(DDBlocks.GLOWING_GRASS, BlockModelGenerators.TintState.NOT_TINTED);
        registerBloomingSculkStone(blockModelGenerators);
        blockModelGenerators.family(DDBlocks.BLOOMING_MOSS_BLOCK);
        registerBloomingStem(blockModelGenerators, (BloomingStemBlock) DDBlocks.BLOOMING_STEM);
        registerBloomingStem(blockModelGenerators, (BloomingStemBlock) DDBlocks.STRIPPED_BLOOMING_STEM);

        registerParented(blockModelGenerators, new ResourceLocation(DeeperDarker.MOD_ID, "stem_inventory").withPrefix("block/"), ModelLocationUtils.getModelLocation(DDBlocks.BLOOMING_STEM).withSuffix("_inventory"),
                new Tuple<>(TextureSlot.STEM, TextureMapping.getBlockTexture(DDBlocks.BLOOMING_STEM)));
        registerParented(blockModelGenerators, new ResourceLocation(DeeperDarker.MOD_ID, "stem_inventory").withPrefix("block/"), ModelLocationUtils.getModelLocation(DDBlocks.STRIPPED_BLOOMING_STEM).withSuffix("_inventory"),
                new Tuple<>(TextureSlot.STEM, TextureMapping.getBlockTexture(DDBlocks.STRIPPED_BLOOMING_STEM)));
        blockModelGenerators.family(DDBlocks.BLOOM_PLANKS);
        registerStairs(blockModelGenerators, DDBlocks.BLOOM_STAIRS, DDBlocks.BLOOM_PLANKS);
        registerSlabWithCubeAll(blockModelGenerators, DDBlocks.BLOOM_SLAB, DDBlocks.BLOOM_PLANKS);
        registerFence(blockModelGenerators, DDBlocks.BLOOM_FENCE, DDBlocks.BLOOM_PLANKS);
        registerFenceGate(blockModelGenerators, DDBlocks.BLOOM_FENCE_GATE, DDBlocks.BLOOM_PLANKS);
        blockModelGenerators.createDoor(DDBlocks.BLOOM_DOOR);
        blockModelGenerators.createOrientableTrapdoor(DDBlocks.BLOOM_TRAPDOOR);
        registerPressurePlate(blockModelGenerators, DDBlocks.BLOOM_PRESSURE_PLATE, DDBlocks.BLOOM_PLANKS);
        registerButton(blockModelGenerators, DDBlocks.BLOOM_BUTTON, DDBlocks.BLOOM_PLANKS);
        blockModelGenerators.createHangingSign(DDBlocks.BLOOM_PLANKS, DDBlocks.BLOOM_SIGN, DDBlocks.BLOOM_WALL_SIGN);
        blockModelGenerators.createHangingSign(DDBlocks.STRIPPED_BLOOMING_STEM, DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN);
        blockModelGenerators.createNonTemplateModelBlock(DDBlocks.ICE_LILY);
        registerParented(blockModelGenerators, new ResourceLocation(DeeperDarker.MOD_ID, "block/ice_waterlily"), ModelLocationUtils.getModelLocation(DDBlocks.ICE_LILY),
                new Tuple<>(TextureSlot.create("flower"), new ResourceLocation(DeeperDarker.MOD_ID, "block/lily_flower")),
                new Tuple<>(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(DDBlocks.ICE_LILY)));

        blockModelGenerators.family(DDBlocks.SOUNDPROOF_GLASS);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        registerWardenHelmet(itemModelGenerator, (ArmorItem) DDItems.WARDEN_HELMET);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.WARDEN_CHESTPLATE);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.WARDEN_LEGGINGS);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.WARDEN_BOOTS);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.RESONARIUM_HELMET);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.RESONARIUM_CHESTPLATE);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.RESONARIUM_LEGGINGS);
        itemModelGenerator.generateArmorTrims((ArmorItem) DDItems.RESONARIUM_BOOTS);
        itemModelGenerator.generateFlatItem(DDItems.RESONARIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.RESONARIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.RESONARIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.RESONARIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.RESONARIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.RESONARIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.REINFORCED_ECHO_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.WARDEN_CARAPACE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.HEART_OF_THE_DEEP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.SOUL_CRYSTAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.SOUL_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.SCULK_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.GRIME_BALL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.GRIME_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.BLOOM_BERRIES, ModelTemplates.FLAT_ITEM);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(DDBlocks.SCULK_TENDRILS.asItem()), TextureMapping.layer0(DDBlocks.SCULK_TENDRILS_PLANT), itemModelGenerator.output);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(DDBlocks.SCULK_VINES.asItem()), TextureMapping.layer0(DDBlocks.SCULK_VINES_PLANT), itemModelGenerator.output);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(DDBlocks.GLOWING_ROOTS.asItem()), TextureMapping.layer0(DDBlocks.GLOWING_ROOTS_PLANT), itemModelGenerator.output);
        ModelTemplates.BUTTON_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.ECHO_BUTTON.asItem()), TextureMapping.cube(DDBlocks.ECHO_PLANKS), itemModelGenerator.output);
        ModelTemplates.FENCE_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.ECHO_FENCE.asItem()), TextureMapping.cube(DDBlocks.ECHO_PLANKS), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.SCULK_STONE_WALL.asItem()), TextureMapping.cube(DDBlocks.SCULK_STONE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.COBBLED_SCULK_STONE_WALL.asItem()), TextureMapping.cube(DDBlocks.COBBLED_SCULK_STONE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.POLISHED_SCULK_STONE_WALL.asItem()), TextureMapping.cube(DDBlocks.POLISHED_SCULK_STONE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.SCULK_STONE_BRICK_WALL.asItem()), TextureMapping.cube(DDBlocks.SCULK_STONE_BRICKS), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.SCULK_STONE_TILE_WALL.asItem()), TextureMapping.cube(DDBlocks.SCULK_STONE_TILES), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.SMOOTH_SCULK_STONE_WALL.asItem()), TextureMapping.cube(DDBlocks.SMOOTH_SCULK_STONE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.CUT_SCULK_STONE_WALL.asItem()), TextureMapping.cube(DDBlocks.CUT_SCULK_STONE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.SCULK_GRIME_BRICK_WALL.asItem()), TextureMapping.cube(DDBlocks.SCULK_GRIME), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.GLOOMSLATE_WALL.asItem()), TextureMapping.cube(DDBlocks.GLOOMSLATE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.COBBLED_GLOOMSLATE_WALL.asItem()), TextureMapping.cube(DDBlocks.COBBLED_GLOOMSLATE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.POLISHED_GLOOMSLATE_WALL.asItem()), TextureMapping.cube(DDBlocks.POLISHED_GLOOMSLATE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.GLOOMSLATE_BRICK_WALL.asItem()), TextureMapping.cube(DDBlocks.GLOOMSLATE_BRICKS), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.GLOOMSLATE_TILE_WALL.asItem()), TextureMapping.cube(DDBlocks.GLOOMSLATE_TILES), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.SMOOTH_GLOOMSLATE_WALL.asItem()), TextureMapping.cube(DDBlocks.SMOOTH_GLOOMSLATE), itemModelGenerator.output);
        ModelTemplates.WALL_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.CUT_GLOOMSLATE_WALL.asItem()), TextureMapping.cube(DDBlocks.CUT_GLOOMSLATE), itemModelGenerator.output);
        itemModelGenerator.generateFlatItem(DDItems.ECHO_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.ECHO_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDBlocks.GLOWING_FLOWERS.asItem(), ModelTemplates.FLAT_ITEM);
        registerSculkTransmitter(itemModelGenerator, (SculkTransmitterItem)DDItems.SCULK_TRANSMITTER);
        registerGeneratedWithPredicate(itemModelGenerator, DDItems.SOUL_ELYTRA, List.of(Triple.of(ResourceLocation.DEFAULT_NAMESPACE + ":broken", 1, BuiltInRegistries.ITEM.getKey(DDItems.SOUL_ELYTRA).withSuffix("_broken").withPrefix("item/"))));
        registerGeneratedWithPredicate(itemModelGenerator, DDItems.SONOROUS_STAFF, List.of(
                Triple.of(DeeperDarker.MOD_ID + ":charge", 0.001, BuiltInRegistries.ITEM.getKey(DDItems.SONOROUS_STAFF).withSuffix("_charging").withPrefix("item/")),
                Triple.of(DeeperDarker.MOD_ID + ":charge", 1, BuiltInRegistries.ITEM.getKey(DDItems.SONOROUS_STAFF).withSuffix("_charged").withPrefix("item/"))));
        registerParented(itemModelGenerator, ModelLocationUtils.getModelLocation(DDBlocks.BLOOMING_STEM).withSuffix("_inventory"), ModelLocationUtils.getModelLocation(DDBlocks.BLOOMING_STEM.asItem()));
        registerParented(itemModelGenerator, ModelLocationUtils.getModelLocation(DDBlocks.STRIPPED_BLOOMING_STEM).withSuffix("_inventory"), ModelLocationUtils.getModelLocation(DDBlocks.STRIPPED_BLOOMING_STEM.asItem()));
        ModelTemplates.BUTTON_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.BLOOM_BUTTON.asItem()), TextureMapping.cube(DDBlocks.BLOOM_PLANKS), itemModelGenerator.output);
        ModelTemplates.FENCE_INVENTORY.create(ModelLocationUtils.getModelLocation(DDBlocks.BLOOM_FENCE.asItem()), TextureMapping.cube(DDBlocks.BLOOM_PLANKS), itemModelGenerator.output);
        itemModelGenerator.generateFlatItem(DDItems.BLOOM_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DDItems.BLOOM_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(DDItems.ICE_LILY), TextureMapping.layer0(DDBlocks.ICE_LILY), itemModelGenerator.output);
        registerSpawnEgg(itemModelGenerator, DDItems.ANGLER_FISH_SPAWN_EGG);
        registerSpawnEgg(itemModelGenerator, DDItems.SCULK_SNAPPER_SPAWN_EGG);
        registerSpawnEgg(itemModelGenerator, DDItems.SHATTERED_SPAWN_EGG);
        registerSpawnEgg(itemModelGenerator, DDItems.SCULK_LEECH_SPAWN_EGG);
        registerSpawnEgg(itemModelGenerator, DDItems.SHRIEK_WORM_SPAWN_EGG);
        registerSpawnEgg(itemModelGenerator, DDItems.STALKER_SPAWN_EGG);
        registerSpawnEgg(itemModelGenerator, DDItems.SCULK_CENTIPEDE_SPAWN_EGG);
    }

    private static void createGildedLog(BlockModelGenerators blockModelGenerators, Block gildedLog, Block normalLog) {
        ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(gildedLog, TextureMapping.column(TextureMapping.getBlockTexture(gildedLog), TextureMapping.getBlockTexture(normalLog).withSuffix("_top")), blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(gildedLog, resourceLocation));
    }

    private static void registerButton(BlockModelGenerators blockModelGenerators, Block block, Block planks) {
        ResourceLocation buttonModel = ModelTemplates.BUTTON.create(block, TexturedModel.CUBE.get(planks).getMapping(),
                blockModelGenerators.modelOutput);
        ResourceLocation buttonPressedModel = ModelTemplates.BUTTON_PRESSED.create(block, TexturedModel.CUBE.get(planks).getMapping(),
                blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createButton(block, buttonModel, buttonPressedModel));
    }

    private static void registerFenceGate(BlockModelGenerators blockModelGenerators, Block block, Block textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        ResourceLocation fenceGateOpenModel = ModelTemplates.FENCE_GATE_OPEN.create(block, textureMap,
                blockModelGenerators.modelOutput);
        ResourceLocation fenceGateModel = ModelTemplates.FENCE_GATE_CLOSED.create(block, textureMap,
                blockModelGenerators.modelOutput);
        ResourceLocation wallFenceGateOpenModel = ModelTemplates.FENCE_GATE_WALL_OPEN.create(block, textureMap,
                blockModelGenerators.modelOutput);
        ResourceLocation wallFenceGateModel = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(block, textureMap,
                blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createFenceGate(block, fenceGateOpenModel, fenceGateModel, wallFenceGateOpenModel, wallFenceGateModel, true));
    }

    private static void registerFence(BlockModelGenerators blockModelGenerators, Block block, Block textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        ResourceLocation fencePost = ModelTemplates.FENCE_POST.create(block, textureMap, blockModelGenerators.modelOutput);
        ResourceLocation fenceSide = ModelTemplates.FENCE_SIDE.create(block, textureMap, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createFence(block, fencePost, fenceSide));
    }

    private static void registerPressurePlate(BlockModelGenerators blockModelGenerators, Block pressurePlate, Block textureSource) {
        TextureMapping textureMap = TextureMapping.defaultTexture(textureSource);
        ResourceLocation upModel = ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlate, textureMap, blockModelGenerators.modelOutput);
        ResourceLocation downModel = ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlate, textureMap, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createPressurePlate(pressurePlate, upModel, downModel));
    }

    private static void registerSlabWithCubeAll(BlockModelGenerators blockModelGenerators, Block slab, Block textureSource) {
        ResourceLocation ResourceLocation = ModelLocationUtils.getModelLocation(textureSource);
        TexturedModel texturedModel = TexturedModel.CUBE.get(textureSource);
        ResourceLocation ResourceLocation2 = ModelTemplates.SLAB_BOTTOM.create(slab, texturedModel.getMapping(), blockModelGenerators.modelOutput);
        ResourceLocation ResourceLocation3 = ModelTemplates.SLAB_TOP.create(slab, texturedModel.getMapping(), blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(slab, ResourceLocation2, ResourceLocation3, ResourceLocation));
    }

    private static void registerStairs(BlockModelGenerators blockModelGenerators, Block stairs, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE.get(textureSource);
        TextureMapping textureMap = texturedModel.getMapping();
        ResourceLocation innerModel = ModelTemplates.STAIRS_INNER.create(stairs, textureMap, blockModelGenerators.modelOutput);
        ResourceLocation regularModel = ModelTemplates.STAIRS_STRAIGHT.create(stairs, textureMap, blockModelGenerators.modelOutput);
        ResourceLocation outerModel = ModelTemplates.STAIRS_OUTER.create(stairs, textureMap, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs, innerModel, regularModel, outerModel));
    }

    private static void registerWall(BlockModelGenerators blockModelGenerators, Block wall, Block textureSource) {
        TexturedModel texturedModel = TexturedModel.CUBE.get(textureSource);
        TextureMapping textureMap = texturedModel.getMapping();
        ResourceLocation postModel = ModelTemplates.WALL_POST.create(wall, textureMap, blockModelGenerators.modelOutput);
        ResourceLocation sideModel = ModelTemplates.WALL_LOW_SIDE.create(wall, textureMap, blockModelGenerators.modelOutput);
        ResourceLocation sideTallModel = ModelTemplates.WALL_TALL_SIDE.create(wall, textureMap, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createWall(wall, postModel, sideModel, sideTallModel));
    }

    private static void registerSculkJaw(BlockModelGenerators blockModelGenerators, Block sculkJaw) {
        ResourceLocation sculkJawModel = ModelTemplates.CUBE_TOP.create(sculkJaw, TextureMapping.singleSlot(TextureSlot.TOP, TextureMapping.getBlockTexture(sculkJaw)).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(sculkJaw, "_side")), blockModelGenerators.modelOutput);
        ResourceLocation sculkJawBitingModel = ModelTemplates.CUBE_TOP.create(ModelLocationUtils.getModelLocation(sculkJaw, "_biting"), TextureMapping.singleSlot(TextureSlot.TOP, TextureMapping.getBlockTexture(sculkJaw, "_biting")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(sculkJaw, "_side")), blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(DDBlocks.SCULK_JAW).with(BlockModelGenerators.createBooleanModelDispatch(
                SculkJawBlock.BITING, sculkJawBitingModel, sculkJawModel)));
    }

    private static void registerGeneratedWithPredicate(ItemModelGenerators itemModelGenerator, Item item, List<Triple<String, Number, ResourceLocation>> predicates) {
        JsonObject withoutPredicateJsonObject = ModelTemplates.FLAT_ITEM.createBaseTemplate(BuiltInRegistries.ITEM.getKey(item).withPrefix("item/"),
                Map.of(TextureSlot.LAYER0, BuiltInRegistries.ITEM.getKey(item).withPrefix("item/")));
        JsonArray overrides = new JsonArray();
        for (Triple<String, Number, ResourceLocation> predicateTriple : predicates) {
            ModelTemplates.FLAT_ITEM.create(predicateTriple.getRight(), TextureMapping.layer0(predicateTriple.getRight()), itemModelGenerator.output);
            JsonObject predicateJson = new JsonObject();
            JsonObject override = new JsonObject();
            predicateJson.addProperty(predicateTriple.getLeft(), predicateTriple.getMiddle());
            override.add("predicate", predicateJson);
            override.addProperty("model", predicateTriple.getRight().toString());
            overrides.add(override);
        }
        withoutPredicateJsonObject.add("overrides", overrides);
        itemModelGenerator.output.accept(BuiltInRegistries.ITEM.getKey(item).withPrefix("item/"), () -> withoutPredicateJsonObject);
    }

    private static void registerSculkTransmitter(ItemModelGenerators itemModelGenerator, SculkTransmitterItem item) {
        registerGeneratedWithPredicate(itemModelGenerator, item, List.of(Triple.of(DeeperDarker.MOD_ID + ":linked", 1, BuiltInRegistries.ITEM.getKey(item).withSuffix("_on").withPrefix("item/"))));
    }

    private static void registerSpawnEgg(ItemModelGenerators itemModelGenerator, Item item) {
        JsonObject model = new JsonObject();
        model.addProperty("parent", new ResourceLocation("template_spawn_egg").withPrefix("item/").toString());
        itemModelGenerator.output.accept(BuiltInRegistries.ITEM.getKey(item).withPrefix("item/"), () -> model);
    }

    private static void registerWardenHelmet(ItemModelGenerators itemModelGenerators, ArmorItem armor) {
        ResourceLocation armorModelIdentifier = ModelLocationUtils.getModelLocation(armor);
        ResourceLocation armorTextureIdentifier = TextureMapping.getItemTexture(armor);
        ModelTemplates.FLAT_ITEM.create(armorModelIdentifier, TextureMapping.layer0(armorTextureIdentifier), itemModelGenerators.output, (id, textures) -> itemModelGenerators.generateBaseArmorTrimTemplate(id, textures, armor.getMaterial()));
        for (ItemModelGenerators.TrimModelData trimMaterial : ItemModelGenerators.GENERATED_TRIM_MODELS) {
            String string = trimMaterial.name(armor.getMaterial());
            ResourceLocation identifier4 = itemModelGenerators.getItemModelForTrimMaterial(armorModelIdentifier, string);
            String string2 = "warden_" + armor.getType().getName() + "_trim_" + string;
            ResourceLocation trimOverlayIdentifier = new ResourceLocation(DeeperDarker.MOD_ID, string2).withPrefix("trims/items/");
            itemModelGenerators.generateLayeredItem(identifier4, armorTextureIdentifier, trimOverlayIdentifier);
        }
    }

    @SafeVarargs
    private static void registerParented(BlockModelGenerators blockModelGenerators, Block parent, Block child, Tuple<TextureSlot, ResourceLocation> ... textures) {
        List<TextureSlot> textureKeys = new ArrayList<>();
        TextureMapping textureMap = new TextureMapping();
        for (Tuple<TextureSlot, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getA());
            textureMap.put(pair.getA(), pair.getB());
        }
        ModelTemplate parentModel = new ModelTemplate(Optional.of(ModelLocationUtils.getModelLocation(parent)), Optional.empty(), textureKeys.toArray(new TextureSlot[0]));

        parentModel.create(child, textureMap, blockModelGenerators.modelOutput);
    }

    @SafeVarargs
    private static void registerParented(BlockModelGenerators blockModelGenerators, ResourceLocation parent, ResourceLocation child, Tuple<TextureSlot, ResourceLocation> ... textures) {
        List<TextureSlot> textureKeys = new ArrayList<>();
        TextureMapping textureMap = new TextureMapping();
        for (Tuple<TextureSlot, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getA());
            textureMap.put(pair.getA(), pair.getB());
        }
        ModelTemplate parentModel = new ModelTemplate(Optional.of(parent), Optional.empty(), textureKeys.toArray(new TextureSlot[0]));

        parentModel.create(child, textureMap, blockModelGenerators.modelOutput);
    }

    @SafeVarargs
    private static void registerParented(ItemModelGenerators itemModelGenerators, ResourceLocation parent, ResourceLocation child, Tuple<TextureSlot, ResourceLocation> ... textures) {
        List<TextureSlot> textureKeys = new ArrayList<>();
        TextureMapping textureMap = new TextureMapping();
        for (Tuple<TextureSlot, ResourceLocation> pair : textures) {
            textureKeys.add(pair.getA());
            textureMap.put(pair.getA(), pair.getB());
        }
        ModelTemplate parentModel = new ModelTemplate(Optional.of(parent), Optional.empty(), textureKeys.toArray(new TextureSlot[0]));

        parentModel.create(child, textureMap, itemModelGenerators.output);
    }

    private void registerBloomingSculkStone(BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(DDBlocks.SCULK_STONE)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(DDBlocks.BLOOMING_SCULK_STONE, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(DDBlocks.BLOOMING_SCULK_STONE));
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(DDBlocks.BLOOMING_SCULK_STONE, ModelTemplates.CUBE_BOTTOM_TOP.create(DDBlocks.BLOOMING_SCULK_STONE, textureMapping, blockModelGenerators.modelOutput)));
    }

    private void registerBloomingStem(BlockModelGenerators blockModelGenerators, BloomingStemBlock block) {
        ResourceLocation stemModel = new ResourceLocation(DeeperDarker.MOD_ID, "block/stem");
        ResourceLocation stemHorizontalModel = new ResourceLocation(DeeperDarker.MOD_ID, "block/stem_horizontal");
        ResourceLocation stemVerticalModel = new ResourceLocation(DeeperDarker.MOD_ID, "block/stem_vertical");

        ResourceLocation bloomingStemModel = ModelLocationUtils.getModelLocation(block);
        ResourceLocation bloomingStemHorizontalModel = ModelLocationUtils.getModelLocation(block).withSuffix("_horizontal");
        ResourceLocation bloomingStemVerticalModel = ModelLocationUtils.getModelLocation(block).withSuffix("_vertical");

        registerParented(blockModelGenerators, stemModel, bloomingStemModel,
                new Tuple<>(TextureSlot.STEM, TextureMapping.getBlockTexture(block)));
        registerParented(blockModelGenerators, stemHorizontalModel, bloomingStemHorizontalModel,
                new Tuple<>(TextureSlot.STEM, TextureMapping.getBlockTexture(block)));
        registerParented(blockModelGenerators, stemVerticalModel, bloomingStemVerticalModel,
                new Tuple<>(TextureSlot.STEM, TextureMapping.getBlockTexture(block)));
        MultiPartGenerator builder = MultiPartGenerator.multiPart(block)
                .with(Variant.variant().with(VariantProperties.MODEL, bloomingStemModel))
                .with(Condition.condition().term(BloomingStemBlock.DOWN, true), Variant.variant().with(VariantProperties.MODEL, bloomingStemVerticalModel)
                        .with(VariantProperties.UV_LOCK, true)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180))
                .with(Condition.condition().term(BloomingStemBlock.UP, true), Variant.variant().with(VariantProperties.MODEL, bloomingStemVerticalModel)
                        .with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BloomingStemBlock.NORTH, true), Variant.variant().with(VariantProperties.MODEL, bloomingStemHorizontalModel)
                        .with(VariantProperties.UV_LOCK, true)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .with(Condition.condition().term(BloomingStemBlock.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, bloomingStemHorizontalModel)
                        .with(VariantProperties.UV_LOCK, true)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .with(Condition.condition().term(BloomingStemBlock.WEST, true), Variant.variant().with(VariantProperties.MODEL, bloomingStemHorizontalModel)
                        .with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BloomingStemBlock.EAST, true), Variant.variant().with(VariantProperties.MODEL, bloomingStemHorizontalModel)
                        .with(VariantProperties.UV_LOCK, true)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180));
        blockModelGenerators.blockStateOutput.accept(builder);
    }
}