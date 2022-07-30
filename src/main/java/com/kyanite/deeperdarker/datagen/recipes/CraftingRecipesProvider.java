package com.kyanite.deeperdarker.datagen.recipes;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
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
        ShapelessRecipeBuilder.shapeless(DDBlocks.BONE_PLANKS.get(), 4).requires(Blocks.BONE_BLOCK).unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK)).save(consumer);
        slabBuilder(DDBlocks.BONE_SLAB.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        stairBuilder(DDBlocks.BONE_STAIRS.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        fenceBuilder(DDBlocks.BONE_FENCE.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        buttonBuilder(DDBlocks.BONE_BUTTON.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        pressurePlateBuilder(DDBlocks.BONE_PRESSURE_PLATE.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        doorBuilder(DDBlocks.BONE_DOOR.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        trapdoorBuilder(DDBlocks.BONE_TRAPDOOR.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);
        fenceGateBuilder(DDBlocks.BONE_FENCE_GATE.get(), Ingredient.of(DDBlocks.BONE_PLANKS.get())).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(DDBlocks.SCULK_BONE_BLOCK.get(), 2).define('B', Blocks.BONE_BLOCK).define('S', Blocks.SCULK).pattern("BS").pattern("SB").unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK)).unlockedBy("has_sculk", has(Blocks.SCULK)).save(consumer);
        ShapelessRecipeBuilder.shapeless(DDBlocks.SCULK_BONE_PLANKS.get(), 4).requires(DDBlocks.SCULK_BONE_BLOCK.get()).unlockedBy("has_sculk_bone_block", has(DDBlocks.SCULK_BONE_BLOCK.get())).save(consumer);
        slabBuilder(DDBlocks.SCULK_BONE_SLAB.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_BONE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        fenceBuilder(DDBlocks.SCULK_BONE_FENCE.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        buttonBuilder(DDBlocks.SCULK_BONE_BUTTON.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        pressurePlateBuilder(DDBlocks.SCULK_BONE_PRESSURE_PLATE.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        doorBuilder(DDBlocks.SCULK_BONE_DOOR.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        trapdoorBuilder(DDBlocks.SCULK_BONE_TRAPDOOR.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);
        fenceGateBuilder(DDBlocks.SCULK_BONE_FENCE_GATE.get(), Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get())).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer);

        slabBuilder(DDBlocks.SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        polishedBuilder(DDBlocks.POLISHED_SCULK_STONE.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        slabBuilder(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.POLISHED_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crafting Recipes";
    }
}