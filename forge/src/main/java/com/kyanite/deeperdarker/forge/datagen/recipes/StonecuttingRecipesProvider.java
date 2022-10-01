package com.kyanite.deeperdarker.forge.datagen.recipes;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class StonecuttingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public StonecuttingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE.get());

        stonecutterResultFromBase(consumer, DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE.get());

        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_WALL.get());

        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.POLISHED_SCULK_STONE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_WALL.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get());

        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE.get());

        stonecutterResultFromBase(consumer, DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), DDBlocks.COBBLED_GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), DDBlocks.COBBLED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.COBBLED_GLOOMSLATE_WALL.get(), DDBlocks.COBBLED_GLOOMSLATE.get());

        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE_WALL.get());

        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE_WALL.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get());

        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.GLOOMSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE_TILES.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.GLOOMSLATE_TILES.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.GLOOMSLATE_TILES.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.GLOOMSLATE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.GLOOMSLATE_WALL.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get());

        stonecutterResultFromBase(consumer, DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), DDBlocks.SMOOTH_GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), DDBlocks.SMOOTH_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(), DDBlocks.SMOOTH_GLOOMSLATE.get());

        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE.get(), DDBlocks.CHISELED_GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.CHISELED_GLOOMSLATE.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Stonecutting Recipes";
    }
}
