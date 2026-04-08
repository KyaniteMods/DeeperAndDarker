package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public abstract class ItemCombinerCustomRecipe extends CustomRecipe {
    public ItemCombinerCustomRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    public abstract Predicate<ItemStack> getFirst();
    public abstract Predicate<ItemStack> getSecond();
    public abstract ItemStack assemble(ItemStack first, ItemStack second);

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack firstStack = null;
        ItemStack secondStack = null;
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (getFirst().test(stack)) {
                if (firstStack != null) {
                    if (getSecond().test(stack) && secondStack == null) {
                        secondStack = stack;
                    } else {
                        return false;
                    }
                } else {
                    firstStack = stack;
                }
            } else if (getSecond().test(stack)) {
                if (secondStack != null) {
                    if (getFirst().test(stack) && firstStack == null) {
                        firstStack = stack;
                    } else {
                        return false;
                    }
                } else {
                    secondStack = stack;
                }
            } else if (!stack.isEmpty()) return false;
        }
        return firstStack != null && secondStack != null;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack firstStack = null;
        ItemStack secondStack = null;
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (getFirst().test(stack)) {
                if (firstStack != null) {
                    if (getSecond().test(stack) && secondStack == null) {
                        secondStack = stack;
                    }
                } else {
                    firstStack = stack;
                }
            } else if (getSecond().test(stack)) {
                if (secondStack != null) {
                    if (getFirst().test(stack) && firstStack == null) {
                        firstStack = stack;
                    }
                } else {
                    secondStack = stack;
                }
            }
            if (firstStack != null && secondStack != null) return assemble(firstStack, secondStack);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }
}
