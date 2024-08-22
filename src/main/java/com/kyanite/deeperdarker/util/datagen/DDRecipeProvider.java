package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {
        addSmithingRecipes(output);
        
        // Wood stuff
            // Echo
        woodRecipes(output, DDBlocks.ECHO_PLANKS, DDTags.Items.ECHO_LOGS, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_DOOR, DDBlocks.ECHO_TRAPDOOR, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_BUTTON, DDItems.ECHO_SIGN, DDItems.ECHO_HANGING_SIGN, DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.ECHO_WOOD, 3).define('L', DDBlocks.ECHO_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.ECHO_LOG), FabricRecipeProvider.has(DDBlocks.ECHO_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.STRIPPED_ECHO_WOOD, 3).define('L', DDBlocks.STRIPPED_ECHO_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.ECHO_LOG), FabricRecipeProvider.has(DDBlocks.ECHO_LOG)).save(output);
            // Bloom
        woodRecipes(output, DDBlocks.BLOOM_PLANKS, DDTags.Items.BLOOMING_STEMS, DDBlocks.BLOOM_STAIRS, DDBlocks.BLOOM_SLAB, DDBlocks.BLOOM_FENCE, DDBlocks.BLOOM_FENCE_GATE, DDBlocks.BLOOM_DOOR, DDBlocks.BLOOM_TRAPDOOR, DDBlocks.BLOOM_PRESSURE_PLATE, DDBlocks.BLOOM_BUTTON, DDItems.BLOOM_SIGN, DDItems.BLOOM_HANGING_SIGN, DDItems.BLOOM_BOAT, DDItems.BLOOM_CHEST_BOAT);
        
        // Sculk Stone
        stairBuilder(DDBlocks.SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE));
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);

        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.COBBLED_SCULK_STONE));
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_WALL);

        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.COBBLED_SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.COBBLED_SCULK_STONE);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICK_WALL);

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SCULK_STONE_TILE_WALL);

        oreSmelting(output, Collections.singletonList(DDBlocks.SCULK_STONE), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE, 0.1f, 200, "sculk_stone");
        stairBuilder(DDBlocks.SMOOTH_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE));
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE);
        registerStairsSlabsAndWalls(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_WALL);

        chiseled(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CHISELED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_SLAB);

        // Sculk Grime
        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME, DDItems.GRIME_BALL);
        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICKS, DDItems.GRIME_BRICK);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME);
        stairBuilder(DDBlocks.SCULK_GRIME_BRICK_STAIRS, Ingredient.of(DDBlocks.SCULK_GRIME_BRICKS));
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICKS);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);

        // Gloomslate
        stairBuilder(DDBlocks.GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.GLOOMSLATE));
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);

        stairBuilder(DDBlocks.COBBLED_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE)).unlockedBy(getHasName(DDBlocks.COBBLED_GLOOMSLATE), has(DDBlocks.COBBLED_GLOOMSLATE)).save(output);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_WALL);

        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.COBBLED_GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICK_WALL);

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_TILES, DDBlocks.COBBLED_GLOOMSLATE);
        registerStairsSlabsAndWalls(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.GLOOMSLATE_TILE_WALL);

        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMSLATE), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE, 0.1f, 200, "sculk_stone");
        stairBuilder(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE));
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE, 2);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE);
        registerStairsSlabsAndWalls(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_WALL);

        chiseled(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CHISELED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_SLAB);

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

        oreSmelting(output, Collections.singletonList(DDItems.GRIME_BALL), RecipeCategory.MISC, DDItems.GRIME_BRICK, 0.3f, 200, "grime_brick");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, 2).define('D', Items.DIAMOND).define('U', DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE).define('S', Items.SCULK).pattern("DUD").pattern("DSD").pattern("DDD").unlockedBy(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.REINFORCED_ECHO_SHARD).define('P', Items.PHANTOM_MEMBRANE).define('C', DDItems.WARDEN_CARAPACE).define('E', Items.ECHO_SHARD).pattern("PCP").pattern("CEC").pattern("PCP").unlockedBy(FabricRecipeProvider.getHasName(Items.ECHO_SHARD), FabricRecipeProvider.has(Items.ECHO_SHARD)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, DDItems.SOUL_ELYTRA).define('B', DDItems.SCULK_BONE).define('D', DDItems.SOUL_DUST).define('E', Items.ELYTRA).define('S', DDItems.SOUL_CRYSTAL).pattern("BDB").pattern("DED").pattern("BSB").unlockedBy(FabricRecipeProvider.getHasName(Items.ELYTRA), FabricRecipeProvider.has(Items.ELYTRA)).save(output);

        oreSmelting(output, Collections.singletonList(DDBlocks.GLOOMY_CACTUS), RecipeCategory.MISC, DDBlocks.GLOOMY_CACTUS, 1.0f, 200, "orange_dye");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDBlocks.SOUNDPROOF_GLASS, 16).define('S', DDItems.SOUL_DUST).define('C', DDItems.SOUL_CRYSTAL).define('G', Blocks.GLASS).pattern("SCS").pattern("CGC").pattern("SCS").unlockedBy(FabricRecipeProvider.getHasName(DDItems.SOUL_CRYSTAL), FabricRecipeProvider.has(DDItems.SOUL_CRYSTAL)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDItems.RESONARIUM_PLATE)
                .requires(DDItems.RESONARIUM, 4).requires(Ingredient.of(DDTags.Items.SCUTES), 4)
                .unlockedBy(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DDItems.SONOROUS_STAFF)
                .define('B', DDItems.SCULK_BONE).define('C', DDItems.SOUL_CRYSTAL).define('H', DDItems.HEART_OF_THE_DEEP)
                .pattern(" CH").pattern(" BC").pattern("B  ")
                .unlockedBy(getHasName(DDItems.SCULK_BONE), has(DDItems.SCULK_BONE))
                .unlockedBy(getHasName(DDItems.SOUL_CRYSTAL), has(DDItems.SOUL_CRYSTAL))
                .unlockedBy(getHasName(DDItems.HEART_OF_THE_DEEP), has(DDItems.HEART_OF_THE_DEEP)).save(output);
    }

    private void addSmithingRecipes(RecipeOutput output) {
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
    }

    private void resonariumSmithing(RecipeOutput output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(), Ingredient.of(ingredient), Ingredient.of(DDItems.RESONARIUM_PLATE), category, result).unlocks(getHasName(DDItems.RESONARIUM_PLATE), has(DDItems.RESONARIUM_PLATE)).save(output, DeeperDarker.rl(getItemName(result) + "_smithing"));
    }

    private void wardenSmithing(RecipeOutput output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredient), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), category, result).unlocks(getHasName(DDItems.REINFORCED_ECHO_SHARD), has(DDItems.REINFORCED_ECHO_SHARD)).save(output, DeeperDarker.rl(getItemName(result) + "_smithing"));
    }

    private static void woodRecipes(RecipeOutput exporter, ItemLike planks, TagKey<Item> logs, ItemLike stairs, ItemLike slab, ItemLike fence, ItemLike fenceGate, ItemLike door, ItemLike trapdoor, ItemLike pressurePlate, ItemLike button, ItemLike sign, ItemLike hangingSign, ItemLike boat, ItemLike chestBoat) {
        planksFromLogs(exporter, planks, logs, 4);
        stairBuilder(stairs, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, slab, planks);
        fenceBuilder(fence, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        fenceGateBuilder(fenceGate, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        doorBuilder(door, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        trapdoorBuilder(trapdoor, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        pressurePlate(exporter, pressurePlate, planks);
        oneToOneConversionRecipe(exporter, button, planks, "wooden_button");
        signBuilder(sign, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks));
        hangingSign(exporter, hangingSign, planks);
        woodenBoat(exporter, boat, planks);
        chestBoat(exporter, chestBoat, planks);
    }

    private static void registerStairsSlabsAndWalls(RecipeOutput exporter, ItemLike originalStone, ItemLike stone, ItemLike stairs, ItemLike slab, ItemLike wall) {
        stairBuilder(stairs, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(exporter);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, stairs, stone);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, stairs, originalStone);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(exporter, getConversionRecipeName(slab, stone));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(originalStone)).unlockedBy(getHasName(originalStone), has(originalStone)).save(exporter, getConversionRecipeName(slab, originalStone));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, slab, stone, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, slab, originalStone, 2);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(exporter, getConversionRecipeName(wall, stone));
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(originalStone)).unlockedBy(getHasName(originalStone), has(originalStone)).save(exporter, getConversionRecipeName(wall, originalStone));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, wall, stone);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, wall, originalStone);
    }
}