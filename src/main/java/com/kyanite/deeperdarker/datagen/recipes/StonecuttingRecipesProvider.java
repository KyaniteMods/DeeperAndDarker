package com.kyanite.deeperdarker.datagen.recipes;

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

        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE.get(), 2);
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE.get());
        stonecutterResultFromBase(consumer, DDBlocks.GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Stonecutting Recipes";
    }
}
