package com.kyanite.deeperdarker.plugins;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(RecipeTypes.CRAFTING, Arrays.stream(DyeColor.values()).map(this::createTransmitterRecipe).toList());
        registration.addRecipes(RecipeTypes.CRAFTING, List.of(createGloomslatePotRecipe(registration.getVanillaRecipeFactory())));
    }

    private RecipeHolder<CraftingRecipe> createTransmitterRecipe(DyeColor color) {
        Ingredient dye = Ingredient.of(DyeItem.byColor(color).asItem());
        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, Ingredient.of(DDItems.SCULK_TRANSMITTER), dye);
        ItemStack output = new ItemStack(SculkTransmitterItem.getItemByColor(color));
        ResourceLocation location = DeeperDarker.rl("/crafting/sculk_transmitter_coloring/" + color.getName());
        CraftingRecipe recipe = new ShapelessRecipe("transmitter_coloring", CraftingBookCategory.MISC, output, inputs);
        return new RecipeHolder<>(location, recipe);
    }

    private RecipeHolder<CraftingRecipe> createGloomslatePotRecipe(IVanillaRecipeFactory vanillaRecipeFactory) {
        ItemStack output = new ItemStack(DDBlocks.GLOOMSLATE_POT);
        ResourceLocation location = DeeperDarker.rl("/crafting/gloomslate_pot");
        CraftingRecipe recipe = vanillaRecipeFactory.createShapedRecipeBuilder(CraftingBookCategory.MISC, List.of(output))
                .define('S', Ingredient.of(DDItems.GLOOMSHERD))
                .pattern(" S ").pattern("S S").pattern(" S ")
                .build();
        return new RecipeHolder<>(location, recipe);
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return DeeperDarker.rl("jei_plugin");
    }
}
