package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.recipes.DDRecipeSerializers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;
import java.util.function.Consumer;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> output) {
        addSmithingRecipes(output);

        simpleGearRecipes(output, DDItems.LEAD_INGOT, DDItems.LEAD_HELMET, DDItems.LEAD_CHESTPLATE, DDItems.LEAD_LEGGINGS, DDItems.LEAD_BOOTS, DDItems.LEAD_SWORD, DDItems.LEAD_PICKAXE, DDItems.LEAD_AXE, DDItems.LEAD_SHOVEL, DDItems.LEAD_HOE);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.RADIOACTIVE_INGOT)
                .define('f', DDItems.FIZZ)
                .define('i', DDItems.LEAD_INGOT)
                .pattern(" f ")
                .pattern("fif")
                .pattern(" f ")
                .unlockedBy(getHasName(DDItems.FIZZ), has(DDItems.FIZZ)).save(output, BuiltInRegistries.ITEM.getKey(DDItems.RADIOACTIVE_INGOT).withSuffix("_from_" + BuiltInRegistries.ITEM.getKey(DDItems.LEAD_INGOT).getPath()));
        simpleGearRecipes(output, DDItems.RADIOACTIVE_INGOT, DDItems.RADIOACTIVE_HELMET, DDItems.RADIOACTIVE_CHESTPLATE, DDItems.RADIOACTIVE_LEGGINGS, DDItems.RADIOACTIVE_BOOTS, DDItems.RADIOACTIVE_SWORD, DDItems.RADIOACTIVE_PICKAXE, DDItems.RADIOACTIVE_AXE, DDItems.RADIOACTIVE_SHOVEL, DDItems.RADIOACTIVE_HOE);

        // Wood stuff
            // Echo
        woodRecipes(output, DDBlocks.ECHO_PLANKS, DDTags.Items.ECHO_LOGS, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_DOOR, DDBlocks.ECHO_TRAPDOOR, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_BUTTON, DDItems.ECHO_SIGN, DDItems.ECHO_HANGING_SIGN, DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.ECHO_WOOD, 3).define('L', DDBlocks.ECHO_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.ECHO_LOG), FabricRecipeProvider.has(DDBlocks.ECHO_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.STRIPPED_ECHO_WOOD, 3).define('L', DDBlocks.STRIPPED_ECHO_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.ECHO_LOG), FabricRecipeProvider.has(DDBlocks.ECHO_LOG)).save(output);
            // Bloom
        woodRecipes(output, DDBlocks.BLOOM_PLANKS, DDTags.Items.BLOOMING_STEMS, DDBlocks.BLOOM_STAIRS, DDBlocks.BLOOM_SLAB, DDBlocks.BLOOM_FENCE, DDBlocks.BLOOM_FENCE_GATE, DDBlocks.BLOOM_DOOR, DDBlocks.BLOOM_TRAPDOOR, DDBlocks.BLOOM_PRESSURE_PLATE, DDBlocks.BLOOM_BUTTON, DDItems.BLOOM_SIGN, DDItems.BLOOM_HANGING_SIGN, DDItems.BLOOM_BOAT, DDItems.BLOOM_CHEST_BOAT);
            // Sculk Spruce
        woodRecipes(output, DDBlocks.SCULK_SPRUCE_PLANKS, DDTags.Items.SCULK_SPRUCE_LOGS, DDBlocks.SCULK_SPRUCE_STAIRS, DDBlocks.SCULK_SPRUCE_SLAB, DDBlocks.SCULK_SPRUCE_FENCE, DDBlocks.SCULK_SPRUCE_FENCE_GATE, DDBlocks.SCULK_SPRUCE_DOOR, DDBlocks.SCULK_SPRUCE_TRAPDOOR, DDBlocks.SCULK_SPRUCE_PRESSURE_PLATE, DDBlocks.SCULK_SPRUCE_BUTTON, DDItems.SCULK_SPRUCE_SIGN, DDItems.SCULK_SPRUCE_HANGING_SIGN, DDItems.SCULK_SPRUCE_BOAT, DDItems.SCULK_SPRUCE_CHEST_BOAT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_SPRUCE_WOOD, 3).define('L', DDBlocks.SCULK_SPRUCE_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.SCULK_SPRUCE_LOG), FabricRecipeProvider.has(DDBlocks.SCULK_SPRUCE_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.STRIPPED_SCULK_SPRUCE_WOOD, 3).define('L', DDBlocks.STRIPPED_SCULK_SPRUCE_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.SCULK_SPRUCE_LOG), FabricRecipeProvider.has(DDBlocks.SCULK_SPRUCE_LOG)).save(output);
        
        // Sculk Stone
        registerStairsSlabsAndWalls(output, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_WALL);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_WALL);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE);
        registerChildStoneRecipes(output, DDBlocks.SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_WALL);

        registerChildStoneRecipes(output, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICK_WALL);

        registerChildStoneRecipes(output, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SCULK_STONE_TILE_WALL);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDBlocks.SCULK_STONE), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE, 0.1f, 200)
                .unlockedBy(getHasName(DDBlocks.SCULK_STONE), VanillaRecipeProvider.has(DDBlocks.SCULK_STONE)).save(output);
        registerStairsSlabsAndWalls(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE_WALL);

        registerChildStoneRecipes(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_WALL);

        registerChiseled(output, DDBlocks.CHISELED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE);

        // Sculk Grime
        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME, DDItems.GRIME_BALL);
        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICKS, DDItems.GRIME_BRICK);
        registerChildStoneRecipes(output, DDBlocks.SCULK_GRIME, DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICK_WALL);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDBlocks.SCULK_GRIME), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_GLASS, 0.1f, 200)
                .unlockedBy(getHasName(DDBlocks.SCULK_GRIME), has(DDBlocks.SCULK_GRIME)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, DDBlocks.SCULK_GRIME_GLASS_PANE, 16)
                .define('#', DDBlocks.SCULK_GRIME_GLASS)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_sculk_grime_glass", RecipeProvider.has(DDBlocks.SCULK_GRIME_GLASS))
                .save(output);

        // Gloomslate
        registerStairsSlabsAndWalls(output, DDBlocks.GLOOMSLATE, DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE_WALL);

        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE_WALL);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE);
        registerChildStoneRecipes(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_WALL);

        registerChildStoneRecipes(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICK_WALL);

        registerChildStoneRecipes(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.GLOOMSLATE_TILE_WALL);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDBlocks.GLOOMSLATE), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE, 0.1f, 200)
                .unlockedBy(getHasName(DDBlocks.GLOOMSLATE), VanillaRecipeProvider.has(DDBlocks.GLOOMSLATE)).save(output);
        registerStairsSlabsAndWalls(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE_WALL);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE);
        registerChildStoneRecipes(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_WALL);

        registerChiseled(output, DDBlocks.CHISELED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.COBBLED_GLOOMSLATE);

        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 200, "coal");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 100, "coal");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "gold_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "gold_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "lapis_lazuli");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");
        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE_LEAD_ORE), RecipeCategory.MISC, DDItems.LEAD_INGOT, 0.7f, 200, "lead_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.SCULK_STONE_LEAD_ORE), RecipeCategory.MISC, DDItems.LEAD_INGOT, 0.7f, 100, "lead_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 200, "coal");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 100, "coal");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "gold_ingot");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "gold_ingot");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "lapis_lazuli");
        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(output, Collections.singletonList(DDBlocks.GLOOMSLATE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");

        nineBlockStorageRecipes(output, RecipeCategory.MISC, DDItems.RAW_LEAD, RecipeCategory.BUILDING_BLOCKS, DDBlocks.RAW_LEAD_BLOCK);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, DDItems.LEAD_INGOT, RecipeCategory.BUILDING_BLOCKS, DDBlocks.LEAD_BLOCK);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, DDItems.RADIOACTIVE_INGOT, RecipeCategory.BUILDING_BLOCKS, DDBlocks.RADIOACTIVE_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ANVIL)
                .define('L', DDBlocks.LEAD_BLOCK)
                .define('l', DDItems.LEAD_INGOT)
                .pattern("LLL")
                .pattern(" l ")
                .pattern("lll")
                .unlockedBy(getHasName(DDBlocks.LEAD_BLOCK), has(DDBlocks.LEAD_BLOCK)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUCKET)
                .define('l', DDItems.LEAD_INGOT)
                .pattern("l l")
                .pattern(" l ")
                .unlockedBy(getHasName(DDItems.LEAD_INGOT), has(DDItems.LEAD_INGOT)).save(output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDItems.GRIME_BALL), RecipeCategory.MISC, DDItems.GRIME_BRICK, 0.3f, 200)
                .unlockedBy(getHasName(DDItems.GRIME_BALL), VanillaRecipeProvider.has(DDItems.GRIME_BALL)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, 2).define('D', Items.DIAMOND).define('U', DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE).define('S', Items.SCULK).pattern("DUD").pattern("DSD").pattern("DDD").unlockedBy(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.GUARDIAN_UPGRADE_SMITHING_TEMPLATE, 2).define('D', Items.DIAMOND).define('U', DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE).define('G', Items.GOLD_BLOCK).pattern("DUD").pattern("DGD").pattern("DDD").unlockedBy(FabricRecipeProvider.getHasName(DDItems.GUARDIAN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.GUARDIAN_UPGRADE_SMITHING_TEMPLATE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.REINFORCED_ECHO_SHARD).define('P', Items.PHANTOM_MEMBRANE).define('C', DDItems.WARDEN_CARAPACE).define('E', Items.ECHO_SHARD).pattern("PCP").pattern("CEC").pattern("PCP").unlockedBy(FabricRecipeProvider.getHasName(Items.ECHO_SHARD), FabricRecipeProvider.has(Items.ECHO_SHARD)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, DDItems.SOUL_ELYTRA).define('B', DDItems.SCULK_BONE).define('D', DDItems.SOUL_DUST).define('E', Items.ELYTRA).define('S', DDItems.SOUL_CRYSTAL).pattern("BDB").pattern("DED").pattern("BSB").unlockedBy(FabricRecipeProvider.getHasName(Items.ELYTRA), FabricRecipeProvider.has(Items.ELYTRA)).save(output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDBlocks.GLOOMY_CACTUS), RecipeCategory.MISC, Items.ORANGE_DYE, 1.0f, 200)
                .unlockedBy(getHasName(DDBlocks.GLOOMY_CACTUS), VanillaRecipeProvider.has(DDBlocks.GLOOMY_CACTUS)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDBlocks.SOUNDPROOF_GLASS, 16).define('S', DDItems.SOUL_DUST).define('C', DDItems.SOUL_CRYSTAL).define('G', Blocks.GLASS).pattern("SCS").pattern("CGC").pattern("SCS").unlockedBy(FabricRecipeProvider.getHasName(DDItems.SOUL_CRYSTAL), FabricRecipeProvider.has(DDItems.SOUL_CRYSTAL)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDItems.RESONARIUM_PLATE)
                .requires(DDItems.RESONARIUM, 4).requires(Ingredient.of(DDTags.Items.SCUTES), 4)
                .unlockedBy(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DDItems.SONOROUS_STAFF)
                .define('S', DDItems.ROYAL_SCEPTER).define('B', DDItems.SCULK_BONE).define('C', DDItems.SOUL_CRYSTAL).define('H', DDItems.HEART_OF_THE_DEEP)
                .pattern(" CH")
                .pattern(" SC")
                .pattern("B  ")
                .unlockedBy(getHasName(DDItems.ROYAL_SCEPTER), has(DDItems.ROYAL_SCEPTER))
                .unlockedBy(getHasName(DDItems.SCULK_BONE), has(DDItems.SCULK_BONE))
                .unlockedBy(getHasName(DDItems.SOUL_CRYSTAL), has(DDItems.SOUL_CRYSTAL))
                .unlockedBy(getHasName(DDItems.HEART_OF_THE_DEEP), has(DDItems.HEART_OF_THE_DEEP)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.SNOWY_SCULK_PERMAFROST)
                .define('L', Blocks.SNOW)
                .define('S', DDBlocks.SCULK_STONE)
                .pattern("L")
                .pattern("S")
                .unlockedBy(getHasName(DDBlocks.SCULK_STONE), has(DDBlocks.SCULK_STONE)).save(output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDBlocks.SCULK_TISSUE), RecipeCategory.MISC, DDItems.SCULK_TISSUE_BRICK, 0.3f, 200)
                .unlockedBy(getHasName(DDBlocks.SCULK_TISSUE), VanillaRecipeProvider.has(DDBlocks.SCULK_TISSUE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_TISSUE_BRICKS)
                .define('#', DDItems.SCULK_TISSUE_BRICK)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(DDItems.SCULK_TISSUE_BRICK), has(DDItems.SCULK_TISSUE_BRICK)).save(output);
        registerStairsSlabsAndWalls(output, DDBlocks.SCULK_TISSUE_BRICKS, DDBlocks.SCULK_TISSUE_BRICK_STAIRS, DDBlocks.SCULK_TISSUE_BRICK_SLAB, DDBlocks.SCULK_TISSUE_BRICK_WALL);

        threeByThreePacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SHADOW_CRYSTAL_BLOCK, DDItems.SHADOW_CRYSTAL);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.SUNGLASSES)
                .define('#', DDItems.SHADOW_CRYSTAL)
                .define('|', Items.STICK)
                .pattern("| |")
                .pattern("#|#")
                .unlockedBy(getHasName(DDItems.SHADOW_CRYSTAL), has(DDItems.SHADOW_CRYSTAL)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDItems.SCULK_BONE_SHARD, 2)
                .requires(DDItems.SCULK_BONE)
                .unlockedBy(FabricRecipeProvider.getHasName(DDItems.SCULK_BONE), FabricRecipeProvider.has(DDItems.SCULK_BONE)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, DDItems.OTHERSIDE_FIRE_STRIKER)
                .requires(DDItems.SCULK_BONE_SHARD).requires(Items.FLINT)
                .unlockedBy(FabricRecipeProvider.getHasName(DDItems.SCULK_BONE_SHARD), FabricRecipeProvider.has(DDItems.SCULK_BONE_SHARD)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.SCULK_TORCH, 4)
                .define('#', Items.STICK)
                .define('S', DDItems.SCULK_BONE_SHARD)
                .pattern("S")
                .pattern("#")
                .unlockedBy(getHasName(DDItems.SCULK_BONE_SHARD), has(DDItems.SCULK_BONE_SHARD)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDBlocks.SCULK_CAMPFIRE)
                .define('#', Items.STICK)
                .define('L', ItemTags.LOGS)
                .define('S', DDItems.SCULK_BONE_SHARD)
                .pattern(" # ")
                .pattern("#S#")
                .pattern("LLL")
                .unlockedBy(getHasName(DDItems.SCULK_BONE_SHARD), has(DDItems.SCULK_BONE_SHARD)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDBlocks.SCULK_LANTERN)
                .define('T', DDItems.SCULK_TORCH)
                .define('N', Items.IRON_NUGGET)
                .pattern("NNN")
                .pattern("NTN")
                .pattern("NNN")
                .unlockedBy(getHasName(DDItems.SCULK_BONE_SHARD), has(DDItems.SCULK_BONE_SHARD)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DDItems.SCULK_DRINK)
                .requires(Items.WATER_BUCKET)
                .requires(DDItems.FIZZ)
                .requires(DDItems.SCULK_BERRY)
                .requires(DDItems.SCULK_BERRY)
                .unlockedBy(getHasName(DDItems.FIZZ), has(DDItems.FIZZ)).save(output);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, DDItems.FIZZ, RecipeCategory.BUILDING_BLOCKS, DDBlocks.FIZZ_BLOCK);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDItems.VIRTUE_SOUL)
                .requires(DDItems.PATIENCE_SOUL)
                .requires(DDItems.FORTITUDE_SOUL)
                .requires(DDItems.PURITY_SOUL)
                .requires(Items.NETHER_STAR)
                .unlockedBy(getHasName(DDItems.PURITY_SOUL), has(DDItems.PURITY_SOUL)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDBlocks.SCULK_ALTAR)
                .define('S', DDItems.SHADOW_CRYSTAL)
                .define('L', DDItems.SOUL_CRYSTAL)
                .define('B', DDBlocks.SCULK_BASALT)
                .pattern("SSS")
                .pattern("LBL")
                .pattern("BBB")
                .unlockedBy(getHasName(DDItems.SCULK_BONE_SHARD), has(DDItems.SCULK_BONE_SHARD)).save(output);

        SpecialRecipeBuilder.special(DDRecipeSerializers.SCULK_TRANSMITTER_DYE).save(output, "sculk_transmitter_dye");
        SpecialRecipeBuilder.special(DDRecipeSerializers.ACID_RESISTANT_ITEM).save(output, "acid_resistant_item");
        SpecialRecipeBuilder.special(DDRecipeSerializers.AUGMENT_SHIELD).save(output, "augment_shield");
        SpecialRecipeBuilder.special(DDRecipeSerializers.REMOVE_HORNS).save(output, "remove_horns");
        SpecialRecipeBuilder.special(DDRecipeSerializers.ADD_HORNS).save(output, "add_horns");
        SpecialRecipeBuilder.special(DDRecipeSerializers.ADD_CRYSTALLIZED_AMBER_ITEM).save(output, "add_crystallized_amber_item");
    }

    private void addSmithingRecipes(Consumer<FinishedRecipe> output) {
        resonariumSmithing(output, Items.IRON_SHOVEL, RecipeCategory.TOOLS, DDItems.RESONARIUM_SHOVEL);
        resonariumSmithing(output, Items.IRON_PICKAXE, RecipeCategory.TOOLS, DDItems.RESONARIUM_PICKAXE);
        resonariumSmithing(output, Items.IRON_AXE, RecipeCategory.TOOLS, DDItems.RESONARIUM_AXE);
        resonariumSmithing(output, Items.IRON_HOE, RecipeCategory.TOOLS, DDItems.RESONARIUM_HOE);
        resonariumSmithing(output, Items.IRON_SWORD, RecipeCategory.COMBAT, DDItems.RESONARIUM_SWORD);
        resonariumSmithing(output, Items.IRON_HELMET, RecipeCategory.COMBAT, DDItems.RESONARIUM_HELMET);
        resonariumSmithing(output, Items.IRON_CHESTPLATE, RecipeCategory.COMBAT, DDItems.RESONARIUM_CHESTPLATE);
        resonariumSmithing(output, Items.IRON_LEGGINGS, RecipeCategory.COMBAT, DDItems.RESONARIUM_LEGGINGS);
        resonariumSmithing(output, Items.IRON_BOOTS, RecipeCategory.COMBAT, DDItems.RESONARIUM_BOOTS);

        wardenSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, DDItems.WARDEN_SHOVEL);
        wardenSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, DDItems.WARDEN_PICKAXE);
        wardenSmithing(output, Items.NETHERITE_AXE, RecipeCategory.TOOLS, DDItems.WARDEN_AXE);
        wardenSmithing(output, Items.NETHERITE_HOE, RecipeCategory.TOOLS, DDItems.WARDEN_HOE);
        wardenSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, DDItems.WARDEN_SWORD);
        wardenSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, DDItems.WARDEN_HELMET);
        wardenSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, DDItems.WARDEN_CHESTPLATE);
        wardenSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, DDItems.WARDEN_LEGGINGS);
        wardenSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, DDItems.WARDEN_BOOTS);

        // Create
//        wardenSmithing(output, AllItems.NETHERITE_DIVING_HELMET, RecipeCategory.COMBAT, DDCreateCompat.Items.WARDEN_DIVING_HELMET.get());
//        wardenSmithing(output, AllItems.NETHERITE_DIVING_BOOTS, RecipeCategory.COMBAT, DDCreateCompat.Items.WARDEN_DIVING_BOOTS.get());
//        wardenSmithing(output, AllItems.NETHERITE_BACKTANK, RecipeCategory.COMBAT, DDCreateCompat.Items.WARDEN_BACKTANK.get());

        guardianSmithing(output, DDItems.WARDEN_SHOVEL, RecipeCategory.TOOLS, DDItems.GUARDIAN_SHOVEL);
        guardianSmithing(output, DDItems.WARDEN_PICKAXE, RecipeCategory.TOOLS, DDItems.GUARDIAN_PICKAXE);
        guardianSmithing(output, DDItems.WARDEN_AXE, RecipeCategory.TOOLS, DDItems.GUARDIAN_AXE);
        guardianSmithing(output, DDItems.WARDEN_HOE, RecipeCategory.TOOLS, DDItems.GUARDIAN_HOE);
        guardianSmithing(output, DDItems.WARDEN_SWORD, RecipeCategory.COMBAT, DDItems.GUARDIAN_SWORD);
        guardianSmithing(output, DDItems.WARDEN_HELMET, RecipeCategory.COMBAT, DDItems.GUARDIAN_HELMET);
        guardianSmithing(output, DDItems.WARDEN_CHESTPLATE, RecipeCategory.COMBAT, DDItems.GUARDIAN_CHESTPLATE);
        guardianSmithing(output, DDItems.WARDEN_LEGGINGS, RecipeCategory.COMBAT, DDItems.GUARDIAN_LEGGINGS);
        guardianSmithing(output, DDItems.WARDEN_BOOTS, RecipeCategory.COMBAT, DDItems.GUARDIAN_BOOTS);
    }

    private void resonariumSmithing(Consumer<FinishedRecipe> output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(), Ingredient.of(ingredient), Ingredient.of(DDItems.RESONARIUM_PLATE), category, result).unlocks(getHasName(DDItems.RESONARIUM_PLATE), has(DDItems.RESONARIUM_PLATE)).save(output, new ResourceLocation(DeeperDarker.MOD_ID, getItemName(result) + "_smithing"));
    }

    private void wardenSmithing(Consumer<FinishedRecipe> output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredient), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), category, result).unlocks(getHasName(DDItems.REINFORCED_ECHO_SHARD), has(DDItems.REINFORCED_ECHO_SHARD)).save(output, new ResourceLocation(DeeperDarker.MOD_ID, getItemName(result) + "_smithing"));
    }

    private void guardianSmithing(Consumer<FinishedRecipe> output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(DDItems.GUARDIAN_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredient), Ingredient.of(DDItems.VIRTUE_SOUL), category, result).unlocks(getHasName(DDItems.VIRTUE_SOUL), has(DDItems.VIRTUE_SOUL)).save(output, new ResourceLocation(DeeperDarker.MOD_ID, getItemName(result) + "_smithing"));
    }

    private static void woodRecipes(Consumer<FinishedRecipe> exporter, ItemLike planks, TagKey<Item> logs, ItemLike stairs, ItemLike slab, ItemLike fence, ItemLike fenceGate, ItemLike door, ItemLike trapdoor, ItemLike pressurePlate, ItemLike button, ItemLike sign, ItemLike hangingSign, ItemLike boat, ItemLike chestBoat) {
        planksFromLogs(exporter, planks, logs, 4);
        stairBuilder(stairs, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, slab, planks);
        fenceBuilder(fence, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        fenceGateBuilder(fenceGate, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        doorBuilder(door, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        trapdoorBuilder(trapdoor, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        pressurePlate(exporter, pressurePlate, planks);
        oneToOneConversionRecipe(exporter, button, planks, "wooden_button");
        signBuilder(sign, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        hangingSign(exporter, hangingSign, planks);
        woodenBoat(exporter, boat, planks);
        chestBoat(exporter, chestBoat, planks);
    }

    private static void registerStairsSlabsAndWalls(Consumer<FinishedRecipe> output, ItemLike stone, ItemLike stairs, ItemLike slab, ItemLike wall) {
        stairBuilder(stairs, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, stairs, stone);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, slab, stone, 2);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, wall, stone);
    }

    private static void registerChildStoneRecipes(Consumer<FinishedRecipe> output, ItemLike parentStone, ItemLike childStone, ItemLike stairs, ItemLike slab, ItemLike wall) {
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, childStone, parentStone);
        stairBuilder(stairs, Ingredient.of(childStone)).unlockedBy(getHasName(childStone), has(childStone)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, stairs, childStone);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, stairs, parentStone);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(childStone)).unlockedBy(getHasName(childStone), has(childStone)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, slab, childStone, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, slab, parentStone, 2);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(childStone)).unlockedBy(getHasName(childStone), has(childStone)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, wall, childStone);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, wall, parentStone);
    }

    private static void registerChiseled(Consumer<FinishedRecipe> output, ItemLike chiseled, ItemLike slab, ItemLike... stones) {
        chiseled(output, RecipeCategory.BUILDING_BLOCKS, chiseled, slab);
        for (ItemLike stone : stones) {
            stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, chiseled, stone);
        }
    }

    private static void simpleGearRecipes(Consumer<FinishedRecipe> output, ItemLike ingot, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots, ItemLike sword, ItemLike pickaxe, ItemLike axe, ItemLike shovel, ItemLike hoe) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .define('l', ingot)
                .pattern("lll")
                .pattern("l l")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .define('l', ingot)
                .pattern("l l")
                .pattern("lll")
                .pattern("lll")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .define('l', ingot)
                .pattern("lll")
                .pattern("l l")
                .pattern("l l")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .define('l', ingot)
                .pattern("l l")
                .pattern("l l")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .define('l', ingot)
                .define('|', Items.STICK)
                .pattern("l")
                .pattern("l")
                .pattern("|")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .define('l', ingot)
                .define('|', Items.STICK)
                .pattern("lll")
                .pattern(" | ")
                .pattern(" | ")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .define('l', ingot)
                .define('|', Items.STICK)
                .pattern("ll")
                .pattern("l|")
                .pattern(" |")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .define('l', ingot)
                .define('|', Items.STICK)
                .pattern("l")
                .pattern("|")
                .pattern("|")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .define('l', ingot)
                .define('|', Items.STICK)
                .pattern("ll")
                .pattern(" |")
                .pattern(" |")
                .unlockedBy(getHasName(ingot), has(ingot)).save(output);
    }
}