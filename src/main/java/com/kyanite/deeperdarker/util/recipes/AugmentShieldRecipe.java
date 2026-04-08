package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Predicate;

public class AugmentShieldRecipe extends ItemCombinerCustomRecipe {
    public AugmentShieldRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    @Override
    public Predicate<ItemStack> getFirst() {
        return stack -> stack.is(Items.SHIELD);
    }

    @Override
    public Predicate<ItemStack> getSecond() {
        return stack -> stack.is(DDItems.SHIELD_AUGMENT);
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second) {
        ItemStack result = first.copyWithCount(1);
        DDUtil.setAugmented(result);
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.AUGMENT_SHIELD;
    }
}
