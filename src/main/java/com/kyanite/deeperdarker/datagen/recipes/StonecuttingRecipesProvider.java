package com.kyanite.deeperdarker.datagen.recipes;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class StonecuttingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public StonecuttingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.BONE_BLOCK), DDBlocks.BONE_PLANKS.get(), 4).unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "bone_planks_from_bone_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DDBlocks.BONE_PLANKS.get()), DDBlocks.BONE_SLAB.get(), 2).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "bone_slab_from_bone_planks_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DDBlocks.BONE_PLANKS.get()), DDBlocks.BONE_STAIRS.get(), 1).unlockedBy("has_bone_planks", has(DDBlocks.BONE_PLANKS.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "bone_stairs_from_bone_planks_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DDBlocks.SCULK_BONE_BLOCK.get()), DDBlocks.SCULK_BONE_PLANKS.get(), 4).unlockedBy("has_sculk_bone_block", has(DDBlocks.SCULK_BONE_BLOCK.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_bone_planks_from_sculk_bone_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get()), DDBlocks.SCULK_BONE_SLAB.get(), 2).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_bone_slab_from_sculk_bone_planks_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DDBlocks.SCULK_BONE_PLANKS.get()), DDBlocks.SCULK_BONE_STAIRS.get(), 1).unlockedBy("has_sculk_bone_planks", has(DDBlocks.SCULK_BONE_PLANKS.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_bone_stairs_from_sculk_bone_planks_stonecutting"));
    }

    @NotNull
    @Override
    public String getName() {
        return "Stonecutting Recipes";
    }
}
