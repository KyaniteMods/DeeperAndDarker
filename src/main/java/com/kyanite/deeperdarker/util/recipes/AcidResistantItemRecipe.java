package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class AcidResistantItemRecipe extends CustomRecipe {
    public AcidResistantItemRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack mainStack = null;
        ItemStack fizzStack = null;
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (stack.is(DDItems.FIZZ)) {
                if (fizzStack != null) return false;
                fizzStack = stack;
            } else if (!DDUtil.isAcidResistant(stack) && !stack.isEmpty()) {
                if (mainStack != null) return false;
                mainStack = stack;
            }
        }
        return mainStack != null && fizzStack != null;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack result = null;
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.is(DDItems.FIZZ) && !DDUtil.isAcidResistant(stack) && !stack.isEmpty()) {
                result = stack.copy();
                DDUtil.setAcidResistant(result);
            }
        }
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.ACID_RESISTANT_ITEM;
    }
}
