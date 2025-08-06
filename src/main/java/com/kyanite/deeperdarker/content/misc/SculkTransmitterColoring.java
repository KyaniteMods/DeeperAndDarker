package com.kyanite.deeperdarker.content.misc;

import com.kyanite.deeperdarker.content.DDRecipes;
import com.kyanite.deeperdarker.content.items.SculkTransmitterItem;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;

@SuppressWarnings("NullableProblems")
public class SculkTransmitterColoring extends CustomRecipe {
    public SculkTransmitterColoring(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        int t = 0;
        int d = 0;

        for(int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if(stack.is(DDTags.Items.TRANSMITTER)) t++;
            else if(stack.is(Tags.Items.DYES)) d++;
            else return false;

            if(t > 1 || d > 1) return false;
        }

        return t == 1 && d == 1;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack transmitter = ItemStack.EMPTY;
        DyeColor dyeColor = DyeColor.WHITE;

        for(int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if(stack.is(DDTags.Items.TRANSMITTER)) {
                transmitter = stack;
            } else {
                DyeColor dye = DyeColor.getColor(stack);
                if(dye != null) dyeColor = dye;
            }
        }

        ItemLike item = SculkTransmitterItem.getItemByColor(dyeColor);
        return transmitter.transmuteCopy(item, 1);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DDRecipes.SCULK_TRANSMITTER_COLORING.get();
    }
}
