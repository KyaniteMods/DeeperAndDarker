package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDUtil;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Predicate;

public class RemoveHornsRecipe extends ItemCombinerCustomRecipe {
    public RemoveHornsRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    @Override
    public Predicate<ItemStack> getFirst() {
        return stack -> stack.is(DDItems.WARDEN_HELMET) || stack.is(DDItems.GUARDIAN_HELMET);
    }

    @Override
    public Predicate<ItemStack> getSecond() {
        return stack -> stack.is(ConventionalItemTags.SHEARS);
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second) {
        ItemStack result = first.copyWithCount(1);
        DDUtil.setHasHorns(result, false);
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.REMOVE_HORNS;
    }
}
