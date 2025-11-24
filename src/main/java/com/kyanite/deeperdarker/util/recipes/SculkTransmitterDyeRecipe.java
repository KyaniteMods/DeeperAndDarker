package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SculkTransmitterDyeRecipe extends CustomRecipe {
    public SculkTransmitterDyeRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        ItemStack transmitterStack = null;
        ItemStack dyeStack = null;
        for (int i = 0; i < recipeInput.size(); ++i) {
            ItemStack stack = recipeInput.getItem(i);
            if (stack.is(DDTags.Items.SCULK_TRANSMITTERS)) {
                if (transmitterStack != null) return false;
                transmitterStack = stack;
            } else if (stack.getItem() instanceof DyeItem) {
                if (dyeStack != null) return false;
                dyeStack = stack;
            }
        }
        return transmitterStack != null && dyeStack != null && SculkTransmitterItem.fromColor(((DyeItem) dyeStack.getItem()).getDyeColor()) != transmitterStack.getItem();
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput recipeInput, HolderLookup.Provider provider) {
        ItemStack transmitterStack = null;
        Item result = null;
        for (int i = 0; i < recipeInput.size(); ++i) {
            ItemStack stack = recipeInput.getItem(i);
            if (stack.is(DDTags.Items.SCULK_TRANSMITTERS)) {
                transmitterStack = stack;
            } else if (stack.getItem() instanceof DyeItem dye) {
                result = SculkTransmitterItem.fromColor(dye.getDyeColor());
            }
        }
        return transmitterStack.transmuteCopy(result, 1);
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipeSerializers.SCULK_TRANSMITTER_DYE;
    }
}
