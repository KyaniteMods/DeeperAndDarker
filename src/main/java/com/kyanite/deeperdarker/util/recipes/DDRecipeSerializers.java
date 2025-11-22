package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class DDRecipeSerializers {
    public static final RecipeSerializer<SculkTransmitterDyeRecipe> SCULK_TRANSMITTER_DYE = register("crafting_special_sculktransmitterdye", new SimpleCraftingRecipeSerializer<>(SculkTransmitterDyeRecipe::new));

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String string, S recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, DeeperDarker.rl(string), recipeSerializer);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering items");
    }
}
