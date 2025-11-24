package com.kyanite.deeperdarker.util.recipes;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SculkTransmitterDyeRecipe extends CustomRecipe {
    public SculkTransmitterDyeRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack transmitterStack = null;
        ItemStack dyeStack = null;
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
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
    public @NotNull ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack transmitterStack = null;
        ItemStack result = null;
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (stack.is(DDTags.Items.SCULK_TRANSMITTERS)) {
                transmitterStack = stack;
            } else if (stack.getItem() instanceof DyeItem dye) {
                result = new ItemStack(SculkTransmitterItem.fromColor(dye.getDyeColor()));
            }
        }
        result.setTag(transmitterStack.getTag().copy());
        return result;
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
