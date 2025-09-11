package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.recipes.GloomslatePotRecipe;
import com.kyanite.deeperdarker.content.recipes.SculkTransmitterColoring;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE = DeferredRegister.create(Registries.RECIPE_SERIALIZER, DeeperDarker.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GloomslatePotRecipe>> GLOOMSLATE_POT_RECIPE = RECIPE.register("gloomslate_pot_recipe", () -> new SimpleCraftingRecipeSerializer<>(GloomslatePotRecipe::new));
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SculkTransmitterColoring>> SCULK_TRANSMITTER_COLORING = RECIPE.register("sculk_transmitter_coloring", () -> new SimpleCraftingRecipeSerializer<>(SculkTransmitterColoring::new));
}
