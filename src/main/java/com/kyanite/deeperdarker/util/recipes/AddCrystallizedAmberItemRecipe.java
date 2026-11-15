package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberEntity;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberItemStack;
import com.kyanite.deeperdarker.content.items.components.DDDataComponents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Predicate;

public class AddCrystallizedAmberItemRecipe extends ItemCombinerCustomRecipe {
    public AddCrystallizedAmberItemRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public Predicate<ItemStack> getFirst(HolderLookup.Provider provider) {
        return stack -> {
            if (!stack.is(DDBlocks.CRYSTALLIZED_AMBER.asItem())) return false;
            return !stack.has(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT);
        };
    }

    @Override
    public Predicate<ItemStack> getSecond(HolderLookup.Provider provider) {
        return stack -> !stack.isEmpty();
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second, HolderLookup.Provider lookupProvider) {
        ItemStack stack = first.copyWithCount(1);
        if (second.getItem() instanceof SpawnEggItem spawnEgg) {
            stack.set(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT, new CrystallizedAmberEntity(spawnEgg.getType(second), 0.0f));
        } else {
            stack.set(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT, new CrystallizedAmberItemStack(second.copy(), 0.0f));
        }
        return stack;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.ADD_CRYSTALLIZED_AMBER_ITEM;
    }
}
