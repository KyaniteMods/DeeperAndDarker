package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.items.components.DDDataComponents;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class SmoothCrystallizedAmberRecipe extends CustomRecipe {
    public SmoothCrystallizedAmberRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput container, Level level) {
        boolean foundCrystallizedAmber = false;
        for (int i = 0; i < container.size(); i++) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty()) continue;
            if (!container.getItem(i).is(DDBlocks.CRYSTALLIZED_AMBER.asItem())) return false;
            if (foundCrystallizedAmber) return false;
            foundCrystallizedAmber = true;
        }
        return foundCrystallizedAmber;
    }

    @Override
    public ItemStack assemble(CraftingInput container, HolderLookup.Provider provider) {
        ItemStack crystallizedAmber = null;
        for (int i = 0; i < container.size(); i++) {
            crystallizedAmber = container.getItem(i);
            if (crystallizedAmber.is(DDBlocks.CRYSTALLIZED_AMBER.asItem())) break;
        }
        ItemStack stack = new ItemStack(DDBlocks.SMOOTH_CRYSTALLIZED_AMBER);
        stack.set(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT, crystallizedAmber.get(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT));
        return stack;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.SMOOTH_CRYSTALLIZED_AMBER;
    }
}
