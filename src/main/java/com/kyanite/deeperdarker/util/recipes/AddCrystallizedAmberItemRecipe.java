package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
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
            if (stack.has(DataComponents.BLOCK_ENTITY_DATA)) {
                CompoundTag blockEntityTag = stack.get(DataComponents.BLOCK_ENTITY_DATA).copyTag();
                if (blockEntityTag.contains(CrystallizedAmberBlockEntity.ITEM_TAG)) {
                    return ItemStack.parse(provider, blockEntityTag.getCompound(CrystallizedAmberBlockEntity.ITEM_TAG)).isEmpty();
                } else return !blockEntityTag.getBoolean(CrystallizedAmberBlockEntity.LEECH_TAG);
            }
            return true;
        };
    }

    @Override
    public Predicate<ItemStack> getSecond(HolderLookup.Provider provider) {
        return stack -> !stack.isEmpty();
    }

    @Override
    public ItemStack assemble(ItemStack first, ItemStack second, HolderLookup.Provider lookupProvider) {
        ItemStack stack = first.copyWithCount(1);
        CompoundTag blockEntityTag;
        if (!stack.has(DataComponents.BLOCK_ENTITY_DATA)) {
            blockEntityTag = new CompoundTag();
            stack.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(blockEntityTag));
        } else {
            blockEntityTag = stack.get(DataComponents.BLOCK_ENTITY_DATA).copyTag();
        }
        blockEntityTag.put(CrystallizedAmberBlockEntity.ITEM_TAG, second.save(lookupProvider, new CompoundTag()));
        stack.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(blockEntityTag));
        return stack;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.ADD_CRYSTALLIZED_AMBER_ITEM;
    }
}
