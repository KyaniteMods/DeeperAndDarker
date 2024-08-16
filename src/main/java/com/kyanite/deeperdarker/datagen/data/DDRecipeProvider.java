package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public DDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        addCraftingRecipes(recipeOutput);
        addCookingRecipes(recipeOutput);
        addStonecuttingRecipes(recipeOutput);
        addSmithingRecipes(recipeOutput);
    }

    private void addCraftingRecipes(RecipeOutput output) {
        woodenRecipes(output, DDTags.Items.ECHO_LOGS, DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.ECHO_PLANKS, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_DOOR, DDBlocks.ECHO_TRAPDOOR, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_BUTTON, DDItems.ECHO_SIGN, DDItems.ECHO_HANGING_SIGN, DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);
        woodFromLogs(output, DDBlocks.ECHO_WOOD, DDBlocks.ECHO_LOG);
        woodFromLogs(output, DDBlocks.STRIPPED_ECHO_WOOD, DDBlocks.STRIPPED_ECHO_LOG);
        woodenRecipes(output, DDTags.Items.BLOOM_STEMS, DDBlocks.STRIPPED_BLOOMING_STEM, DDBlocks.BLOOM_PLANKS, DDBlocks.BLOOM_STAIRS, DDBlocks.BLOOM_SLAB, DDBlocks.BLOOM_FENCE, DDBlocks.BLOOM_FENCE_GATE, DDBlocks.BLOOM_DOOR, DDBlocks.BLOOM_TRAPDOOR, DDBlocks.BLOOM_PRESSURE_PLATE, DDBlocks.BLOOM_BUTTON, DDItems.BLOOM_SIGN, DDItems.BLOOM_HANGING_SIGN, DDItems.BLOOM_BOAT, DDItems.BLOOM_CHEST_BOAT);

        stairBuilder(DDBlocks.SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE)).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);

        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.COBBLED_SCULK_STONE)).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE);
        stairBuilder(DDBlocks.POLISHED_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.POLISHED_SCULK_STONE)).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.POLISHED_SCULK_STONE);
        stairBuilder(DDBlocks.SCULK_STONE_BRICK_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE_BRICKS)).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICKS);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_BRICKS);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_BRICKS);
        stairBuilder(DDBlocks.SCULK_STONE_TILE_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE_TILES)).unlockedBy("has_sculk_stone_tiles", has(DDBlocks.SCULK_STONE_TILES)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SCULK_STONE_TILES);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_TILE_WALL, DDBlocks.SCULK_STONE_TILES);

        stairBuilder(DDBlocks.SMOOTH_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE)).unlockedBy("has_smooth_sculk_stone", has(DDBlocks.SMOOTH_SCULK_STONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE);
        stairBuilder(DDBlocks.CUT_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.CUT_SCULK_STONE)).unlockedBy("has_cut_sculk_stone", has(DDBlocks.CUT_SCULK_STONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_SCULK_STONE_WALL, DDBlocks.CUT_SCULK_STONE);

        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, DDBlocks.CHISELED_SCULK_STONE, Ingredient.of(DDBlocks.SCULK_STONE_BRICK_SLAB)).unlockedBy("has_sculk_stone_slab", has(DDBlocks.SCULK_STONE_BRICK_SLAB)).save(output);

        stairBuilder(DDBlocks.GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.GLOOMSLATE)).unlockedBy("has_gloomslate", has(DDBlocks.GLOOMSLATE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);

        stairBuilder(DDBlocks.COBBLED_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE)).unlockedBy("has_cobbled_gloomslate", has(DDBlocks.COBBLED_GLOOMSLATE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE);
        stairBuilder(DDBlocks.POLISHED_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.POLISHED_GLOOMSLATE)).unlockedBy("has_polished_gloomslate", has(DDBlocks.POLISHED_GLOOMSLATE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_GLOOMSLATE_WALL, DDBlocks.POLISHED_GLOOMSLATE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.POLISHED_GLOOMSLATE);
        stairBuilder(DDBlocks.GLOOMSLATE_BRICK_STAIRS, Ingredient.of(DDBlocks.GLOOMSLATE_BRICKS)).unlockedBy("has_gloomslate_bricks", has(DDBlocks.GLOOMSLATE_BRICKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICKS);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICK_WALL, DDBlocks.GLOOMSLATE_BRICKS);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_BRICKS);
        stairBuilder(DDBlocks.GLOOMSLATE_TILE_STAIRS, Ingredient.of(DDBlocks.GLOOMSLATE_TILES)).unlockedBy("has_gloomslate_tiles", has(DDBlocks.GLOOMSLATE_TILES)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.GLOOMSLATE_TILES);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_TILE_WALL, DDBlocks.GLOOMSLATE_TILES);

        stairBuilder(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE)).unlockedBy("has_smooth_gloomslate", has(DDBlocks.SMOOTH_GLOOMSLATE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);

        polished(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE);
        stairBuilder(DDBlocks.CUT_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.CUT_GLOOMSLATE)).unlockedBy("has_cut_gloomslate", has(DDBlocks.CUT_GLOOMSLATE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_GLOOMSLATE_WALL, DDBlocks.CUT_GLOOMSLATE);

        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, DDBlocks.CHISELED_GLOOMSLATE, Ingredient.of(DDBlocks.GLOOMSLATE_BRICK_SLAB)).unlockedBy("has_gloomslate_slab", has(DDBlocks.GLOOMSLATE_BRICK_SLAB)).save(output);

        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME, DDItems.GRIME_BALL);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICKS)
                .define('G', DDItems.GRIME_BRICK)
                .pattern("GG").pattern("GG")
                .unlockedBy("has_grime_brick", has(DDItems.GRIME_BRICK)).save(output);
        stairBuilder(DDBlocks.SCULK_GRIME_BRICK_STAIRS, Ingredient.of(DDBlocks.SCULK_GRIME_BRICKS)).unlockedBy("has_sculk_grime_bricks", has(DDBlocks.SCULK_GRIME_BRICKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS);
        wall(output, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.SOUNDPROOF_GLASS, 2)
                .define('S', DDItems.SOUL_DUST).define('G', Items.GLASS)
                .pattern(" S ").pattern("SGS").pattern(" S ")
                .unlockedBy(getHasName(DDItems.SOUL_DUST), has(DDItems.SOUL_DUST)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, DDItems.SOUL_ELYTRA)
                .define('B', DDItems.SCULK_BONE).define('C', DDItems.SOUL_CRYSTAL).define('D', DDItems.SOUL_DUST).define('E', Items.ELYTRA)
                .pattern("BCB").pattern("DED").pattern("B B")
                .unlockedBy("has_elytra", has(Items.ELYTRA)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDItems.RESONARIUM_PLATE)
                .requires(DDItems.RESONARIUM, 4).requires(Items.ARMADILLO_SCUTE, 4)
                .unlockedBy(getHasName(DDItems.RESONARIUM), has(DDItems.RESONARIUM)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.REINFORCED_ECHO_SHARD)
                .define('P', Items.PHANTOM_MEMBRANE).define('C', DDItems.WARDEN_CARAPACE).define('E', Items.ECHO_SHARD)
                .pattern("PCP").pattern("CEC").pattern("PCP")
                .unlockedBy(getHasName(DDItems.WARDEN_CARAPACE), has(DDItems.WARDEN_CARAPACE)).save(output);
        copySmithingTemplate(output, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, Blocks.SCULK);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DDItems.SONOROUS_STAFF)
                .define('B', DDItems.SCULK_BONE).define('C', DDItems.SOUL_CRYSTAL).define('H', DDItems.HEART_OF_THE_DEEP)
                .pattern(" CH").pattern(" BC").pattern("B  ")
                .unlockedBy(getHasName(DDItems.SCULK_BONE), has(DDItems.SCULK_BONE))
                .unlockedBy(getHasName(DDItems.SOUL_CRYSTAL), has(DDItems.SOUL_CRYSTAL))
                .unlockedBy(getHasName(DDItems.HEART_OF_THE_DEEP), has(DDItems.HEART_OF_THE_DEEP)).save(output);
    }

    private void addCookingRecipes(RecipeOutput output) {
        smelting(DDBlocks.COBBLED_SCULK_STONE, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE, 0.1f, output);
        smelting(DDBlocks.SCULK_STONE, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE, 0.1f, output);
        smelting(DDBlocks.COBBLED_GLOOMSLATE, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE, 0.1f, output);
        smelting(DDBlocks.GLOOMSLATE, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE, 0.1f, output);

        smelting(DDBlocks.GLOOMY_CACTUS, RecipeCategory.MISC, Items.ORANGE_DYE, 1f, output);
        smelting(DDItems.GRIME_BALL, RecipeCategory.MISC, DDItems.GRIME_BRICK, 0.2f, output);

        oreSmelting(DDBlocks.SCULK_STONE_COAL_ORE, RecipeCategory.MISC, Items.COAL, 0.1f, "coal", output);
        oreSmelting(DDBlocks.SCULK_STONE_IRON_ORE, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, "iron_ingot", output);
        oreSmelting(DDBlocks.SCULK_STONE_COPPER_ORE, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, "copper_ingot", output);
        oreSmelting(DDBlocks.SCULK_STONE_GOLD_ORE, RecipeCategory.MISC, Items.GOLD_INGOT, 1, "gold_ingot", output);
        oreSmelting(DDBlocks.SCULK_STONE_REDSTONE_ORE, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7f, "redstone", output);
        oreSmelting(DDBlocks.SCULK_STONE_EMERALD_ORE, RecipeCategory.MISC, Items.EMERALD, 1, "emerald", output);
        oreSmelting(DDBlocks.SCULK_STONE_LAPIS_ORE, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", output);
        oreSmelting(DDBlocks.SCULK_STONE_DIAMOND_ORE, RecipeCategory.MISC, Items.DIAMOND, 1, "diamond", output);
        oreSmelting(DDBlocks.GLOOMSLATE_COAL_ORE, RecipeCategory.MISC, Items.COAL, 0.1f, "coal", output);
        oreSmelting(DDBlocks.GLOOMSLATE_IRON_ORE, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, "iron_ingot", output);
        oreSmelting(DDBlocks.GLOOMSLATE_COPPER_ORE, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, "copper_ingot", output);
        oreSmelting(DDBlocks.GLOOMSLATE_GOLD_ORE, RecipeCategory.MISC, Items.GOLD_INGOT, 1, "gold_ingot", output);
        oreSmelting(DDBlocks.GLOOMSLATE_REDSTONE_ORE, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7f, "redstone", output);
        oreSmelting(DDBlocks.GLOOMSLATE_EMERALD_ORE, RecipeCategory.MISC, Items.EMERALD, 1, "emerald", output);
        oreSmelting(DDBlocks.GLOOMSLATE_LAPIS_ORE, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", output);
        oreSmelting(DDBlocks.GLOOMSLATE_DIAMOND_ORE, RecipeCategory.MISC, Items.DIAMOND, 1, "diamond", output);

        oreBlasting(DDBlocks.SCULK_STONE_COAL_ORE, RecipeCategory.MISC, Items.COAL, 0.1f, "coal", output);
        oreBlasting(DDBlocks.SCULK_STONE_IRON_ORE, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, "iron_ingot", output);
        oreBlasting(DDBlocks.SCULK_STONE_COPPER_ORE, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, "copper_ingot", output);
        oreBlasting(DDBlocks.SCULK_STONE_GOLD_ORE, RecipeCategory.MISC, Items.GOLD_INGOT, 1, "gold_ingot", output);
        oreBlasting(DDBlocks.SCULK_STONE_REDSTONE_ORE, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7f, "redstone", output);
        oreBlasting(DDBlocks.SCULK_STONE_EMERALD_ORE, RecipeCategory.MISC, Items.EMERALD, 1, "emerald", output);
        oreBlasting(DDBlocks.SCULK_STONE_LAPIS_ORE, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", output);
        oreBlasting(DDBlocks.SCULK_STONE_DIAMOND_ORE, RecipeCategory.MISC, Items.DIAMOND, 1, "diamond", output);
        oreBlasting(DDBlocks.GLOOMSLATE_COAL_ORE, RecipeCategory.MISC, Items.COAL, 0.1f, "coal", output);
        oreBlasting(DDBlocks.GLOOMSLATE_IRON_ORE, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, "iron_ingot", output);
        oreBlasting(DDBlocks.GLOOMSLATE_COPPER_ORE, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, "copper_ingot", output);
        oreBlasting(DDBlocks.GLOOMSLATE_GOLD_ORE, RecipeCategory.MISC, Items.GOLD_INGOT, 1, "gold_ingot", output);
        oreBlasting(DDBlocks.GLOOMSLATE_REDSTONE_ORE, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7f, "redstone", output);
        oreBlasting(DDBlocks.GLOOMSLATE_EMERALD_ORE, RecipeCategory.MISC, Items.EMERALD, 1, "emerald", output);
        oreBlasting(DDBlocks.GLOOMSLATE_LAPIS_ORE, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", output);
        oreBlasting(DDBlocks.GLOOMSLATE_DIAMOND_ORE, RecipeCategory.MISC, Items.DIAMOND, 1, "diamond", output);
    }

    private void addStonecuttingRecipes(RecipeOutput output) {
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_WALL);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_WALL);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_WALL);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_TILE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_TILE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_TILE_WALL);
        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_TILES);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_TILE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_TILE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_TILE_WALL);
        stonecuttingRecipe(output, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE_TILES);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_TILE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_TILE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_TILE_WALL);

        stonecuttingRecipe(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE_WALL);

        stonecuttingRecipe(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_WALL);
        stonecuttingRecipe(output, DDBlocks.CUT_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.CUT_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.CUT_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.CHISELED_SCULK_STONE);
        stonecuttingRecipe(output, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.CHISELED_SCULK_STONE);

        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE, DDBlocks.GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE, DDBlocks.GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE, DDBlocks.GLOOMSLATE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_WALL);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_WALL);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_WALL);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_BRICK_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILE_WALL);
        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILES);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILE_WALL);
        stonecuttingRecipe(output, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILES);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_TILE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_TILE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_TILE_WALL);

        stonecuttingRecipe(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE_WALL);

        stonecuttingRecipe(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_WALL);
        stonecuttingRecipe(output, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_STAIRS);
        stonecuttingRecipe(output, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_WALL);

        stonecuttingRecipe(output, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.CHISELED_GLOOMSLATE);
        stonecuttingRecipe(output, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.CHISELED_GLOOMSLATE);

        stonecuttingRecipe(output, DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME_BRICK_STAIRS);
        stonecuttingRecipe(output, DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME_BRICK_SLAB, 2);
        stonecuttingRecipe(output, DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME_BRICK_WALL);
    }

    private void addSmithingRecipes(RecipeOutput output) {
        resonariumSmithing(output, Items.IRON_SHOVEL, RecipeCategory.TOOLS, DDItems.RESONARIUM_SHOVEL.get());
        resonariumSmithing(output, Items.IRON_PICKAXE, RecipeCategory.TOOLS, DDItems.RESONARIUM_PICKAXE.get());
        resonariumSmithing(output, Items.IRON_AXE, RecipeCategory.TOOLS, DDItems.RESONARIUM_AXE.get());
        resonariumSmithing(output, Items.IRON_HOE, RecipeCategory.TOOLS, DDItems.RESONARIUM_HOE.get());
        resonariumSmithing(output, Items.IRON_SWORD, RecipeCategory.COMBAT, DDItems.RESONARIUM_SWORD.get());
        resonariumSmithing(output, Items.IRON_HELMET, RecipeCategory.COMBAT, DDItems.RESONARIUM_HELMET.get());
        resonariumSmithing(output, Items.IRON_CHESTPLATE, RecipeCategory.COMBAT, DDItems.RESONARIUM_CHESTPLATE.get());
        resonariumSmithing(output, Items.IRON_LEGGINGS, RecipeCategory.COMBAT, DDItems.RESONARIUM_LEGGINGS.get());
        resonariumSmithing(output, Items.IRON_BOOTS, RecipeCategory.COMBAT, DDItems.RESONARIUM_BOOTS.get());

        wardenSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, DDItems.WARDEN_SHOVEL.get());
        wardenSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, DDItems.WARDEN_PICKAXE.get());
        wardenSmithing(output, Items.NETHERITE_AXE, RecipeCategory.TOOLS, DDItems.WARDEN_AXE.get());
        wardenSmithing(output, Items.NETHERITE_HOE, RecipeCategory.TOOLS, DDItems.WARDEN_HOE.get());
        wardenSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, DDItems.WARDEN_SWORD.get());
        wardenSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, DDItems.WARDEN_HELMET.get());
        wardenSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, DDItems.WARDEN_CHESTPLATE.get());
        wardenSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, DDItems.WARDEN_LEGGINGS.get());
        wardenSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, DDItems.WARDEN_BOOTS.get());
    }

    private void resonariumSmithing(RecipeOutput output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(), Ingredient.of(ingredient), Ingredient.of(DDItems.RESONARIUM_PLATE), category, result).unlocks(getHasName(DDItems.RESONARIUM_PLATE), has(DDItems.RESONARIUM_PLATE)).save(output, DeeperDarker.rl(getItemName(result) + "_smithing"));
    }

    private void wardenSmithing(RecipeOutput output, ItemLike ingredient, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredient), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), category, result).unlocks(getHasName(DDItems.REINFORCED_ECHO_SHARD), has(DDItems.REINFORCED_ECHO_SHARD)).save(output, DeeperDarker.rl(getItemName(result) + "_smithing"));
    }

    private void woodenRecipes(RecipeOutput output, TagKey<Item> logs, DeferredBlock<? extends Block> strippedLog, DeferredBlock<Block> planks, DeferredBlock<StairBlock> stairs, DeferredBlock<SlabBlock> slabs, DeferredBlock<FenceBlock> fence, DeferredBlock<FenceGateBlock> fenceGate, DeferredBlock<DoorBlock> door, DeferredBlock<TrapDoorBlock> trapDoor, DeferredBlock<PressurePlateBlock> pressurePlate, DeferredBlock<ButtonBlock> button, DeferredItem<Item> sign, DeferredItem<Item> hangingSign, DeferredItem<Item> boat, DeferredItem<Item> chestBoat) {
        planksFromLogs(output, planks, logs, 4);
        stairBuilder(stairs, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, slabs, planks);
        fenceBuilder(fence, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        fenceGateBuilder(fenceGate, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        doorBuilder(door, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        trapdoorBuilder(trapDoor, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        pressurePlate(output, pressurePlate, planks);
        buttonBuilder(button, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        signBuilder(sign, Ingredient.of(planks)).unlockedBy("has_planks", has(planks)).save(output);
        hangingSign(output, hangingSign, strippedLog);
        woodenBoat(output, boat, planks);
        chestBoat(output, chestBoat, boat);
    }

    private void smelting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, RecipeOutput output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, experience, 200).unlockedBy(getHasName(ingredient), has(ingredient)).save(output);
    }

    private void oreSmelting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, String group, RecipeOutput output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, experience, 200).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(output, DeeperDarker.rl(getSmeltingRecipeName(result)  + "_" + getItemName(ingredient)));
    }

    private void oreBlasting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, String group, RecipeOutput output) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), category, result, experience, 100).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(output, DeeperDarker.rl(getBlastingRecipeName(result) + "_" + getItemName(ingredient)));
    }

    private void stonecuttingRecipe(RecipeOutput output, ItemLike ingredient, ItemLike result) {
        stonecuttingRecipe(output, ingredient, result, 1);
    }

    private void stonecuttingRecipe(RecipeOutput output, ItemLike ingredient, ItemLike result, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.BUILDING_BLOCKS, result, count).unlockedBy(getHasName(ingredient), has(ingredient)).save(output, ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID,getConversionRecipeName(result, ingredient) + "_stonecutting"));
    }
}
