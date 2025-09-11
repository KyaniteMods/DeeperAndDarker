package com.kyanite.deeperdarker.content.recipes;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDRecipes;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.PotDecorations;

@SuppressWarnings("NullableProblems")
public class GloomslatePotRecipe extends CustomRecipe {
    public GloomslatePotRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        if(!this.canCraftInDimensions(input.width(), input.height())) return false;

        for(int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            switch(i) {
                case 1, 3, 5, 7:
                    if(!stack.is(DDTags.Items.GLOOMSLATE_SHERDS)) return false;
                    break;
                default:
                    if(!stack.is(Items.AIR)) return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        PotDecorations decorations = new PotDecorations(input.getItem(1).getItem(), input.getItem(3).getItem(), input.getItem(5).getItem(), input.getItem(7).getItem());
        ItemStack stack = DDBlocks.GLOOMSLATE_POT.toStack();
        stack.set(DataComponents.POT_DECORATIONS, decorations);
        return stack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width == 3 && height == 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipes.GLOOMSLATE_POT_RECIPE.get();
    }
}
