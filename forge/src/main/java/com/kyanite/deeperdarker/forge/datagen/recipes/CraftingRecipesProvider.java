package com.kyanite.deeperdarker.forge.datagen.recipes;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        woodFromLogs(consumer, DDBlocks.ECHO_WOOD.get(), DDBlocks.ECHO_LOG.get());
        woodFromLogs(consumer, DDBlocks.STRIPPED_ECHO_WOOD.get(), DDBlocks.STRIPPED_ECHO_LOG.get());
        planksFromLogs(consumer, DDBlocks.ECHO_PLANKS.get(), DDTags.Items.ECHO_LOGS);
        slabBuilder(DDBlocks.ECHO_SLAB.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        stairBuilder(DDBlocks.ECHO_STAIRS.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        fenceBuilder(DDBlocks.ECHO_FENCE.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        buttonBuilder(DDBlocks.ECHO_BUTTON.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        pressurePlateBuilder(DDBlocks.ECHO_PRESSURE_PLATE.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        doorBuilder(DDBlocks.ECHO_DOOR.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        trapdoorBuilder(DDBlocks.ECHO_TRAPDOOR.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        fenceGateBuilder(DDBlocks.ECHO_FENCE_GATE.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        signBuilder(DDBlocks.ECHO_SIGN.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        woodenBoat(consumer, DDItems.ECHO_BOAT.get(), DDBlocks.ECHO_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(DDItems.ECHO_CHEST_BOAT.get()).requires(Blocks.CHEST).requires(DDItems.ECHO_BOAT.get()).group("chest_boat").unlockedBy("has_boat", has(ItemTags.BOATS)).save(consumer);

        slabBuilder(DDBlocks.SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);

        slabBuilder(DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.COBBLED_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(consumer);

        polishedBuilder(DDBlocks.POLISHED_SCULK_STONE.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        slabBuilder(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.POLISHED_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);

        polishedBuilder(DDBlocks.SCULK_STONE_BRICKS.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        slabBuilder(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_BRICK_WALL.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);

        polishedBuilder(DDBlocks.SCULK_STONE_TILES.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);
        slabBuilder(DDBlocks.SCULK_STONE_TILE_SLAB.get(), Ingredient.of(DDBlocks.SCULK_STONE_TILES.get())).unlockedBy("has_sculk_stone_tiles", has(DDBlocks.SCULK_STONE_TILES.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_TILE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE_TILES.get())).unlockedBy("has_sculk_stone_tiles", has(DDBlocks.SCULK_STONE_TILES.get())).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_TILE_WALL.get(), Ingredient.of(DDBlocks.SCULK_STONE_TILES.get())).unlockedBy("has_sculk_stone_tiles", has(DDBlocks.SCULK_STONE_TILES.get())).save(consumer);

        slabBuilder(DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE.get())).unlockedBy("has_smooth_sculk_stone", has(DDBlocks.SMOOTH_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE.get())).unlockedBy("has_smooth_sculk_stone", has(DDBlocks.SMOOTH_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.SMOOTH_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE.get())).unlockedBy("has_smooth_sculk_stone", has(DDBlocks.SMOOTH_SCULK_STONE.get())).save(consumer);

        polishedBuilder(DDBlocks.CUT_SCULK_STONE.get(), Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE.get())).unlockedBy("has_smooth_sculk_stone", has(DDBlocks.SMOOTH_SCULK_STONE.get())).save(consumer);
        slabBuilder(DDBlocks.CUT_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.CUT_SCULK_STONE.get())).unlockedBy("has_cut_sculk_stone", has(DDBlocks.CUT_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.CUT_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.CUT_SCULK_STONE.get())).unlockedBy("has_cut_sculk_stone", has(DDBlocks.CUT_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.CUT_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.CUT_SCULK_STONE.get())).unlockedBy("has_cut_sculk_stone", has(DDBlocks.CUT_SCULK_STONE.get())).save(consumer);

        chiseledBuilder(DDBlocks.CHISELED_SCULK_STONE.get(), Ingredient.of(DDBlocks.SCULK_STONE_SLAB.get())).unlockedBy("has_sculk_stone_slab", has(DDBlocks.SCULK_STONE_SLAB.get())).save(consumer);

        slabBuilder(DDBlocks.GLOOMSLATE_SLAB.get(), Ingredient.of(DDBlocks.GLOOMSLATE.get())).unlockedBy("has_gloomslate", has(DDBlocks.GLOOMSLATE.get())).save(consumer);
        stairBuilder(DDBlocks.GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.GLOOMSLATE.get())).unlockedBy("has_gloomslate", has(DDBlocks.GLOOMSLATE.get())).save(consumer);
        wallBuilder(DDBlocks.GLOOMSLATE_WALL.get(), Ingredient.of(DDBlocks.GLOOMSLATE.get())).unlockedBy("has_gloomslate", has(DDBlocks.GLOOMSLATE.get())).save(consumer);

        slabBuilder(DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE.get())).unlockedBy("has_cobbled_gloomslate", has(DDBlocks.COBBLED_GLOOMSLATE.get())).save(consumer);
        stairBuilder(DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE.get())).unlockedBy("has_cobbled_gloomslate", has(DDBlocks.COBBLED_GLOOMSLATE.get())).save(consumer);
        wallBuilder(DDBlocks.COBBLED_GLOOMSLATE_WALL.get(), Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE.get())).unlockedBy("has_cobbled_gloomslate", has(DDBlocks.COBBLED_GLOOMSLATE.get())).save(consumer);

        polishedBuilder(DDBlocks.POLISHED_GLOOMSLATE.get(), Ingredient.of(DDBlocks.GLOOMSLATE.get())).unlockedBy("has_gloomslate", has(DDBlocks.GLOOMSLATE.get())).save(consumer);
        slabBuilder(DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), Ingredient.of(DDBlocks.POLISHED_GLOOMSLATE.get())).unlockedBy("has_polished_gloomslate", has(DDBlocks.POLISHED_GLOOMSLATE.get())).save(consumer);
        stairBuilder(DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.POLISHED_GLOOMSLATE.get())).unlockedBy("has_polished_gloomslate", has(DDBlocks.POLISHED_GLOOMSLATE.get())).save(consumer);
        wallBuilder(DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), Ingredient.of(DDBlocks.POLISHED_GLOOMSLATE.get())).unlockedBy("has_polished_gloomslate", has(DDBlocks.POLISHED_GLOOMSLATE.get())).save(consumer);

        polishedBuilder(DDBlocks.GLOOMSLATE_BRICKS.get(), Ingredient.of(DDBlocks.POLISHED_GLOOMSLATE.get())).unlockedBy("has_polished_gloomslate", has(DDBlocks.POLISHED_GLOOMSLATE.get())).save(consumer);
        slabBuilder(DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), Ingredient.of(DDBlocks.GLOOMSLATE_BRICKS.get())).unlockedBy("has_gloomslate_bricks", has(DDBlocks.GLOOMSLATE_BRICKS.get())).save(consumer);
        stairBuilder(DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), Ingredient.of(DDBlocks.GLOOMSLATE_BRICKS.get())).unlockedBy("has_gloomslate_bricks", has(DDBlocks.GLOOMSLATE_BRICKS.get())).save(consumer);
        wallBuilder(DDBlocks.GLOOMSLATE_BRICK_WALL.get(), Ingredient.of(DDBlocks.GLOOMSLATE_BRICKS.get())).unlockedBy("has_gloomslate_bricks", has(DDBlocks.GLOOMSLATE_BRICKS.get())).save(consumer);

        polishedBuilder(DDBlocks.GLOOMSLATE_TILES.get(), Ingredient.of(DDBlocks.GLOOMSLATE_BRICKS.get())).unlockedBy("has_gloomslate_bricks", has(DDBlocks.GLOOMSLATE_BRICKS.get())).save(consumer);
        slabBuilder(DDBlocks.GLOOMSLATE_TILE_SLAB.get(), Ingredient.of(DDBlocks.GLOOMSLATE_TILES.get())).unlockedBy("has_gloomslate_tiles", has(DDBlocks.GLOOMSLATE_TILES.get())).save(consumer);
        stairBuilder(DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), Ingredient.of(DDBlocks.GLOOMSLATE_TILES.get())).unlockedBy("has_gloomslate_tiles", has(DDBlocks.GLOOMSLATE_TILES.get())).save(consumer);
        wallBuilder(DDBlocks.GLOOMSLATE_TILE_WALL.get(), Ingredient.of(DDBlocks.GLOOMSLATE_TILES.get())).unlockedBy("has_gloomslate_tiles", has(DDBlocks.GLOOMSLATE_TILES.get())).save(consumer);

        slabBuilder(DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE.get())).unlockedBy("has_smooth_gloomslate", has(DDBlocks.SMOOTH_GLOOMSLATE.get())).save(consumer);
        stairBuilder(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE.get())).unlockedBy("has_smooth_gloomslate", has(DDBlocks.SMOOTH_GLOOMSLATE.get())).save(consumer);
        wallBuilder(DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(), Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE.get())).unlockedBy("has_smooth_gloomslate", has(DDBlocks.SMOOTH_GLOOMSLATE.get())).save(consumer);

        polishedBuilder(DDBlocks.CUT_GLOOMSLATE.get(), Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE.get())).unlockedBy("has_smooth_gloomslate", has(DDBlocks.SMOOTH_GLOOMSLATE.get())).save(consumer);
        slabBuilder(DDBlocks.CUT_GLOOMSLATE_SLAB.get(), Ingredient.of(DDBlocks.CUT_GLOOMSLATE.get())).unlockedBy("has_cut_gloomslate", has(DDBlocks.CUT_GLOOMSLATE.get())).save(consumer);
        stairBuilder(DDBlocks.CUT_GLOOMSLATE_STAIRS.get(), Ingredient.of(DDBlocks.CUT_GLOOMSLATE.get())).unlockedBy("has_cut_gloomslate", has(DDBlocks.CUT_GLOOMSLATE.get())).save(consumer);
        wallBuilder(DDBlocks.CUT_GLOOMSLATE_WALL.get(), Ingredient.of(DDBlocks.CUT_GLOOMSLATE.get())).unlockedBy("has_cut_gloomslate", has(DDBlocks.CUT_GLOOMSLATE.get())).save(consumer);

        chiseledBuilder(DDBlocks.CHISELED_GLOOMSLATE.get(), Ingredient.of(DDBlocks.GLOOMSLATE_SLAB.get())).unlockedBy("has_gloomslate_slab", has(DDBlocks.GLOOMSLATE_SLAB.get())).save(consumer);

        ShapedRecipeBuilder.shaped(DDItems.REINFORCED_ECHO_SHARD.get(), 1)
                .define('P', Items.PHANTOM_MEMBRANE)
                .define('E', Items.ECHO_SHARD)
                .define('C', DDItems.WARDEN_CARAPACE.get())
                .pattern("PEP")
                .pattern("ECE")
                .pattern("PEP")
                .unlockedBy("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get())).save(consumer);

        ShapedRecipeBuilder.shaped(DDItems.SOUL_ELYTRA.get(), 1)
                .define('S', DDItems.SOUL_CRYSTAL.get())
                .define('D', DDItems.SOUL_DUST.get())
                .define('B', DDItems.SCULK_BONE.get())
                .define('E', Items.ELYTRA)
                .pattern("BDB")
                .pattern("DED")
                .pattern("BSB")
                .unlockedBy("has_soul_elytra", has(DDItems.SOUL_ELYTRA.get())).save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crafting Recipes";
    }
}
