package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.misc.GloomslatePotRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE = DeferredRegister.create(Registries.RECIPE_SERIALIZER, DeeperDarker.MOD_ID);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GloomslatePotRecipe>> GLOOMSLATE_POT_RECIPE = RECIPE.register("crafting_gloomslate_pot", () -> GloomslatePotRecipe.SERIALIZER);
}
