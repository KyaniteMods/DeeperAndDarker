package com.kyanite.deeperdarker.datagen.recipes;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class SmeltingBlastingCookingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public SmeltingBlastingCookingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_COAL_ORE.get(), Items.COAL, 0.2F, 200, "coal");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_IRON_ORE.get(), Items.IRON_INGOT, 1.4F, 200, "iron_ingot");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_COPPER_ORE.get(), Items.COPPER_INGOT, 1.4F, 200, "copper_ingot");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_GOLD_ORE.get(), Items.GOLD_INGOT, 2.0F, 200, "gold_ingot");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), Items.REDSTONE, 1.4F, 200, "redstone");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_EMERALD_ORE.get(), Items.EMERALD, 2.0F, 200, "emerald");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 0.4F, 200, "lapis_lazuli");
        oreSmelting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), Items.DIAMOND, 2.0F, 200, "diamond");

        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_COAL_ORE.get(), Items.COAL, 0.2F, 100, "coal");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_IRON_ORE.get(), Items.IRON_INGOT, 1.4F, 100, "iron_ingot");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_COPPER_ORE.get(), Items.COPPER_INGOT, 1.4F, 100, "copper_ingot");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_GOLD_ORE.get(), Items.GOLD_INGOT, 2.0F, 100, "gold_ingot");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), Items.REDSTONE, 1.4F, 100, "redstone");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_EMERALD_ORE.get(), Items.EMERALD, 2.0F, 100, "emerald");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 0.4F, 100, "lapis_lazuli");
        oreBlasting(consumer, (List<ItemLike>) DDBlocks.SCULK_STONE_DIAMOND_ORE.get(), Items.DIAMOND, 2.0F, 100, "diamond");
    }
}
