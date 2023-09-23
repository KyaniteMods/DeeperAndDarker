package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public DDRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        addCraftingRecipes(consumer);
        addCookingRecipes(consumer);
        addStonecuttingRecipes(consumer);
        addSmithingRecipes(consumer);
    }

    private void addCraftingRecipes(Consumer<FinishedRecipe> writer) {
        woodenRecipes(writer, DDTags.Items.ECHO_LOGS, DDBlocks.ECHO_PLANKS, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_DOOR, DDBlocks.ECHO_TRAPDOOR, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_BUTTON, DDItems.ECHO_SIGN, DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);

        stairBuilder(DDBlocks.SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(writer);
        slab(writer, DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE.get());
        wall(writer, DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE.get());

        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(writer);
        slab(writer, DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE.get());
        wall(writer, DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE.get());

        polished(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE.get());
        stairBuilder(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(writer);
        slab(writer, DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        wall(writer, DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE.get());

        polished(writer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stairBuilder(DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(writer);
        slab(writer, DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_BRICKS.get());
        wall(writer, DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_BRICKS.get());

        polished(writer, DDBlocks.SCULK_STONE_TILES.get(), DDBlocks.SCULK_STONE_BRICKS.get());
        stairBuilder(DDBlocks.SCULK_STONE_TILE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE_TILES.get())).unlockedBy("has_sculk_stone_tiles", has(DDBlocks.SCULK_STONE_TILES.get())).save(writer);
        slab(writer, DDBlocks.SCULK_STONE_TILE_SLAB.get(), DDBlocks.SCULK_STONE_TILES.get());
        wall(writer, DDBlocks.SCULK_STONE_TILE_WALL.get(), DDBlocks.SCULK_STONE_TILES.get());

        stairBuilder(DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE.get())).unlockedBy("has_smooth_sculk_stone", has(DDBlocks.SMOOTH_SCULK_STONE.get())).save(writer);
        slab(writer, DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), DDBlocks.SMOOTH_SCULK_STONE.get());
        wall(writer, DDBlocks.SMOOTH_SCULK_STONE_WALL.get(), DDBlocks.SMOOTH_SCULK_STONE.get());

        polished(writer, DDBlocks.CUT_SCULK_STONE.get(), DDBlocks.SMOOTH_SCULK_STONE.get());
        stairBuilder(DDBlocks.CUT_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.CUT_SCULK_STONE.get())).unlockedBy("has_cut_sculk_stone", has(DDBlocks.CUT_SCULK_STONE.get())).save(writer);
        slab(writer, DDBlocks.CUT_SCULK_STONE_SLAB.get(), DDBlocks.CUT_SCULK_STONE.get());
        wall(writer, DDBlocks.CUT_SCULK_STONE_WALL.get(), DDBlocks.CUT_SCULK_STONE.get());

        chiseledBuilder(DDBlocks.CHISELED_SCULK_STONE.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICK_SLAB.get())).unlockedBy("has_sculk_stone_slab", has(DDBlocks.SCULK_STONE_BRICK_SLAB.get())).save(writer);

        stairBuilder(DDBlocks.GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.GLOOMSLATE.get())).unlockedBy("has_gloomslate", has(DDBlocks.GLOOMSLATE.get())).save(writer);
        slab(writer, DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE.get());
        wall(writer, DDBlocks.GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE.get());

        stairBuilder(DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE.get())).unlockedBy("has_cobbled_gloomslate", has(DDBlocks.COBBLED_GLOOMSLATE.get())).save(writer);
        slab(writer, DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), DDBlocks.COBBLED_GLOOMSLATE.get());
        wall(writer, DDBlocks.COBBLED_GLOOMSLATE_WALL.get(), DDBlocks.COBBLED_GLOOMSLATE.get());

        polished(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.COBBLED_GLOOMSLATE.get());
        stairBuilder(DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.POLISHED_GLOOMSLATE.get())).unlockedBy("has_polished_gloomslate", has(DDBlocks.POLISHED_GLOOMSLATE.get())).save(writer);
        slab(writer, DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        wall(writer, DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE.get());

        polished(writer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stairBuilder(DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), Ingredient.of(DDBlocks.GLOOMSLATE_BRICKS.get())).unlockedBy("has_gloomslate_bricks", has(DDBlocks.GLOOMSLATE_BRICKS.get())).save(writer);
        slab(writer, DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        wall(writer, DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE_BRICKS.get());

        polished(writer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stairBuilder(DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), Ingredient.of(DDBlocks.GLOOMSLATE_TILES.get())).unlockedBy("has_gloomslate_tiles", has(DDBlocks.GLOOMSLATE_TILES.get())).save(writer);
        slab(writer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE_TILES.get());
        wall(writer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.GLOOMSLATE_TILES.get());

        stairBuilder(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE.get())).unlockedBy("has_smooth_gloomslate", has(DDBlocks.SMOOTH_GLOOMSLATE.get())).save(writer);
        slab(writer, DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), DDBlocks.SMOOTH_GLOOMSLATE.get());
        wall(writer, DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(), DDBlocks.SMOOTH_GLOOMSLATE.get());

        polished(writer, DDBlocks.CUT_GLOOMSLATE.get(), DDBlocks.SMOOTH_GLOOMSLATE.get());
        stairBuilder(DDBlocks.CUT_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.CUT_GLOOMSLATE.get())).unlockedBy("has_cut_gloomslate", has(DDBlocks.CUT_GLOOMSLATE.get())).save(writer);
        slab(writer, DDBlocks.CUT_GLOOMSLATE_SLAB.get(), DDBlocks.CUT_GLOOMSLATE.get());
        wall(writer, DDBlocks.CUT_GLOOMSLATE_WALL.get(), DDBlocks.CUT_GLOOMSLATE.get());

        chiseledBuilder(DDBlocks.CHISELED_GLOOMSLATE.get(), Ingredient.of(DDBlocks.GLOOMSLATE_BRICK_SLAB.get())).unlockedBy("has_gloomslate_slab", has(DDBlocks.GLOOMSLATE_BRICK_SLAB.get())).save(writer);

        ShapedRecipeBuilder.shaped(DDBlocks.SCULK_GRIME.get()).define('G', DDItems.GRIME_BALL.get()).pattern("GG").pattern("GG").unlockedBy("has_grime_ball", has(DDItems.GRIME_BALL.get())).save(writer);
        ShapedRecipeBuilder.shaped(DDBlocks.SCULK_GRIME_BRICKS.get()).define('G', DDItems.GRIME_BRICK.get()).pattern("GG").pattern("GG").unlockedBy("has_grime_brick", has(DDItems.GRIME_BRICK.get())).save(writer);
        stairBuilder(DDBlocks.SCULK_GRIME_BRICK_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_GRIME_BRICKS.get())).unlockedBy("has_sculk_grime_bricks", has(DDBlocks.SCULK_GRIME_BRICKS.get())).save(writer);
        slab(writer, DDBlocks.SCULK_GRIME_BRICK_SLAB.get(), DDBlocks.SCULK_GRIME_BRICKS.get());
        wall(writer, DDBlocks.SCULK_GRIME_BRICK_WALL.get(), DDBlocks.SCULK_GRIME_BRICKS.get());

        ShapedRecipeBuilder.shaped(DDItems.SOUL_ELYTRA.get())
                .define('S', DDItems.SOUL_CRYSTAL.get()).define('D', DDItems.SOUL_DUST.get()).define('B', DDItems.SCULK_BONE.get()).define('E', Items.ELYTRA)
                .pattern("BDB").pattern("DED").pattern("BSB")
                .unlockedBy("has_elytra", has(Items.ELYTRA)).save(writer);
        ShapedRecipeBuilder.shaped(DDItems.REINFORCED_ECHO_SHARD.get())
                .define('P', Items.PHANTOM_MEMBRANE).define('C', DDItems.WARDEN_CARAPACE.get()).define('E', Items.ECHO_SHARD)
                .pattern("PCP").pattern("CEC").pattern("PCP")
                .unlockedBy("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get())).save(writer);
    }

    private void addCookingRecipes(Consumer<FinishedRecipe> writer) {
        smelting(DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE.get(), 0.1f, writer);
        smelting(DDBlocks.SCULK_STONE.get(), DDBlocks.SMOOTH_SCULK_STONE.get(), 0.1f, writer);
        smelting(DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE.get(), 0.1f, writer);
        smelting(DDBlocks.GLOOMSLATE.get(), DDBlocks.SMOOTH_GLOOMSLATE.get(), 0.1f, writer);

        smelting(DDBlocks.GLOOMY_CACTUS.get(), Items.ORANGE_DYE, 1f, writer);
        smelting(DDItems.GRIME_BALL.get(), DDItems.GRIME_BRICK.get(), 0.2f, writer);

        oreSmelting(DDBlocks.SCULK_STONE_COAL_ORE.get(), Items.COAL, 0.1f, "coal", writer);
        oreSmelting(DDBlocks.SCULK_STONE_IRON_ORE.get(), Items.RAW_IRON, 0.7f, "iron_ingot", writer);
        oreSmelting(DDBlocks.SCULK_STONE_COPPER_ORE.get(), Items.RAW_COPPER, 0.7f, "copper_ingot", writer);
        oreSmelting(DDBlocks.SCULK_STONE_GOLD_ORE.get(), Items.RAW_GOLD, 1, "gold_ingot", writer);
        oreSmelting(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), Items.REDSTONE, 0.7f, "redstone", writer);
        oreSmelting(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), Items.EMERALD, 1, "emerald", writer);
        oreSmelting(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", writer);
        oreSmelting(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), Items.DIAMOND, 1, "diamond", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_COAL_ORE.get(), Items.COAL, 0.1f, "coal", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_IRON_ORE.get(), Items.RAW_IRON, 0.7f, "iron_ingot", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_COPPER_ORE.get(), Items.RAW_COPPER, 0.7f, "copper_ingot", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_GOLD_ORE.get(), Items.RAW_GOLD, 1, "gold_ingot", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_REDSTONE_ORE.get(), Items.REDSTONE, 0.7f, "redstone", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_EMERALD_ORE.get(), Items.EMERALD, 1, "emerald", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", writer);
        oreSmelting(DDBlocks.GLOOMSLATE_DIAMOND_ORE.get(), Items.DIAMOND, 1, "diamond", writer);

        oreBlasting(DDBlocks.SCULK_STONE_COAL_ORE.get(), Items.COAL, 0.1f, "coal", writer);
        oreBlasting(DDBlocks.SCULK_STONE_IRON_ORE.get(), Items.RAW_IRON, 0.7f, "iron_ingot", writer);
        oreBlasting(DDBlocks.SCULK_STONE_COPPER_ORE.get(), Items.RAW_COPPER, 0.7f, "copper_ingot", writer);
        oreBlasting(DDBlocks.SCULK_STONE_GOLD_ORE.get(), Items.RAW_GOLD, 1, "gold_ingot", writer);
        oreBlasting(DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), Items.REDSTONE, 0.7f, "redstone", writer);
        oreBlasting(DDBlocks.SCULK_STONE_EMERALD_ORE.get(), Items.EMERALD, 1, "emerald", writer);
        oreBlasting(DDBlocks.SCULK_STONE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", writer);
        oreBlasting(DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), Items.DIAMOND, 1, "diamond", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_COAL_ORE.get(), Items.COAL, 0.1f, "coal", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_IRON_ORE.get(), Items.RAW_IRON, 0.7f, "iron_ingot", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_COPPER_ORE.get(), Items.RAW_COPPER, 0.7f, "copper_ingot", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_GOLD_ORE.get(), Items.RAW_GOLD, 1, "gold_ingot", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_REDSTONE_ORE.get(), Items.REDSTONE, 0.7f, "redstone", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_EMERALD_ORE.get(), Items.EMERALD, 1, "emerald", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 0.2f, "lapis_lazuli", writer);
        oreBlasting(DDBlocks.GLOOMSLATE_DIAMOND_ORE.get(), Items.DIAMOND, 1, "diamond", writer);
    }

    private void addStonecuttingRecipes(Consumer<FinishedRecipe> writer) {
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_STONE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICKS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_BRICKS.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILES.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE_TILES.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_TILES.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_TILES.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_TILES.get(), DDBlocks.SCULK_STONE_TILE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.SMOOTH_SCULK_STONE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.CUT_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.CUT_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.CUT_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.CHISELED_SCULK_STONE.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.CHISELED_SCULK_STONE.get());

        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.COBBLED_GLOOMSLATE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILES.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_TILES.get());
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.SMOOTH_GLOOMSLATE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_WALL.get());
        stonecuttingRecipe(writer, DDBlocks.CUT_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.CUT_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.CUT_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_WALL.get());

        stonecuttingRecipe(writer, DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.CHISELED_GLOOMSLATE.get());
        stonecuttingRecipe(writer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.CHISELED_GLOOMSLATE.get());

        stonecuttingRecipe(writer, DDBlocks.SCULK_GRIME_BRICKS.get(), DDBlocks.SCULK_GRIME_BRICK_STAIRS.get());
        stonecuttingRecipe(writer, DDBlocks.SCULK_GRIME_BRICKS.get(), DDBlocks.SCULK_GRIME_BRICK_SLAB.get(), 2);
        stonecuttingRecipe(writer, DDBlocks.SCULK_GRIME_BRICKS.get(), DDBlocks.SCULK_GRIME_BRICK_WALL.get());
    }

    private void addSmithingRecipes(Consumer<FinishedRecipe> writer) {
        wardenSmithing(writer, Items.NETHERITE_SHOVEL, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_SHOVEL.get());
        wardenSmithing(writer, Items.NETHERITE_PICKAXE, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_PICKAXE.get());
        wardenSmithing(writer, Items.NETHERITE_AXE, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_AXE.get());
        wardenSmithing(writer, Items.NETHERITE_HOE, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_HOE.get());
        wardenSmithing(writer, Items.NETHERITE_SWORD, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_SWORD.get());
        wardenSmithing(writer, Items.NETHERITE_HELMET, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_HELMET.get());
        wardenSmithing(writer, Items.NETHERITE_CHESTPLATE, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_CHESTPLATE.get());
        wardenSmithing(writer, Items.NETHERITE_LEGGINGS, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_LEGGINGS.get());
        wardenSmithing(writer, Items.NETHERITE_BOOTS, DDItems.REINFORCED_ECHO_SHARD.get(), DDItems.WARDEN_BOOTS.get());
    }

    private void wardenSmithing(Consumer<FinishedRecipe> writer, ItemLike base, ItemLike addition, Item result) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(addition), result).unlocks(getHasName(addition), has(addition)).save(writer, new ResourceLocation(DeeperDarker.MOD_ID, getItemName(result) + "_smithing"));
    }

    private void woodenRecipes(Consumer<FinishedRecipe> writer, TagKey<Item> logs, RegistryObject<Block> planks, RegistryObject<StairBlock> stairs, RegistryObject<SlabBlock> slabs, RegistryObject<FenceBlock> fence, RegistryObject<FenceGateBlock> fenceGate, RegistryObject<DoorBlock> door, RegistryObject<TrapDoorBlock> trapDoor, RegistryObject<PressurePlateBlock> pressurePlate, RegistryObject<ButtonBlock> button, RegistryObject<Item> sign, RegistryObject<Item> boat, RegistryObject<Item> chestBoat) {
        planksFromLogs(writer, planks.get(), logs);
        stairBuilder(stairs.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        slab(writer, slabs.get(), planks.get());
        fenceBuilder(fence.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        fenceGateBuilder(fenceGate.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        doorBuilder(door.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        trapdoorBuilder(trapDoor.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        pressurePlate(writer, pressurePlate.get(), planks.get());
        buttonBuilder(button.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        signBuilder(sign.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        woodenBoat(writer, boat.get(), planks.get());
    }

    private void smelting(ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer);
    }

    private void oreSmelting(ItemLike ingredient, ItemLike result, float experience, String group, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer, new ResourceLocation(DeeperDarker.MOD_ID, getSmeltingRecipeName(result)  + "_" + getItemName(ingredient)));
    }

    private void oreBlasting(ItemLike ingredient, ItemLike result, float experience, String group, Consumer<FinishedRecipe> writer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, experience, 100).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer, new ResourceLocation(DeeperDarker.MOD_ID, getBlastingRecipeName(result) + "_" + getItemName(ingredient)));
    }

    private void stonecuttingRecipe(Consumer<FinishedRecipe> writer, ItemLike ingredient, ItemLike result) {
        stonecuttingRecipe(writer, ingredient, result, 1);
    }

    private void stonecuttingRecipe(Consumer<FinishedRecipe> writer, ItemLike ingredient, ItemLike result, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, count).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer, new ResourceLocation(DeeperDarker.MOD_ID,getConversionRecipeName(result, ingredient) + "_stonecutting"));
    }
}
