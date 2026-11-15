package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class AcidResistantItemRecipe extends ItemCombinerCustomRecipe {
    public AcidResistantItemRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public Predicate<ItemStack> getFirst(HolderLookup.Provider lookupProvider) {
        return stack -> !stack.isEmpty() && !DDUtil.isAcidResistant(stack);
    }

    @Override
    public Predicate<ItemStack> getSecond(HolderLookup.Provider lookupProvider) {
        return stack -> stack.is(DDItems.FIZZ);
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second, HolderLookup.Provider lookupProvider) {
        ItemStack result = first.copyWithCount(1);
        DDUtil.setAcidResistant(result);
        return result;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.ACID_RESISTANT_ITEM;
    }
}
