package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
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
            if (stack.is(DDBlocks.CRYSTALLIZED_AMBER.asItem())) {
                return !stack.hasTag() || !stack.getTag().contains("item") || !ItemStack.of(stack.getTag().getCompound("item")).isEmpty();
            }
            return false;
        };
    }

    @Override
    public Predicate<ItemStack> getSecond() {
        return stack -> !stack.isEmpty();
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second) {
        ItemStack stack = first.copyWithCount(1);
        CompoundTag tag = stack.getOrCreateTag();
        CompoundTag blockEntityTag;
        if (!tag.contains(BlockItem.BLOCK_ENTITY_TAG)) {
            blockEntityTag = new CompoundTag();
            tag.put(BlockItem.BLOCK_ENTITY_TAG, blockEntityTag);
        } else {
            blockEntityTag = tag.getCompound(BlockItem.BLOCK_ENTITY_TAG);
        }
        blockEntityTag.put("item", second.save(new CompoundTag()));
        return stack;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.ADD_CRYSTALLIZED_AMBER_ITEM;
    }
}
