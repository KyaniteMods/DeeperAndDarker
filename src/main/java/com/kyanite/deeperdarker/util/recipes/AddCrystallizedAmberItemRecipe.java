package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberEntity;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberItemStack;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Predicate;

public class AddCrystallizedAmberItemRecipe extends ItemCombinerCustomRecipe {
    public AddCrystallizedAmberItemRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    @Override
    public Predicate<ItemStack> getFirst() {
        return stack -> {
            if (!stack.is(DDTags.Items.CRYSTALLIZED_AMBER)) return false;
            return !DDUtil.hasCrystallizedAmberContent(stack);
        };
    }

    @Override
    public Predicate<ItemStack> getSecond() {
        return stack -> !stack.isEmpty();
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second) {
        ItemStack stack = first.copyWithCount(1);
        if (second.getItem() instanceof SpawnEggItem spawnEgg) {
            DDUtil.setCrystallizedAmberContent(stack, new CrystallizedAmberEntity(spawnEgg.getType(second.getTag()), 0.0f));
        } else {
            DDUtil.setCrystallizedAmberContent(stack, new CrystallizedAmberItemStack(second.copy(), 0.0f));
        }
        return stack;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.ADD_CRYSTALLIZED_AMBER_ITEM;
    }
}
