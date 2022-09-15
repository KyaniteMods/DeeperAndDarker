package com.kyanite.deeperdarker.forge.datagen.recipes;

import com.google.common.collect.ImmutableList;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class SmeltingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public SmeltingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, ImmutableList.of(DDBlocks.COBBLED_SCULK_STONE), DDBlocks.SCULK_STONE, 0.1F, 200, "sculk_stone");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.COBBLED_SCULK_STONE_SLAB), DDBlocks.SCULK_STONE_SLAB, 0.1F, 200, "sculk_stone_slab");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.COBBLED_SCULK_STONE_STAIRS), DDBlocks.SCULK_STONE_STAIRS, 0.1F, 200, "sculk_stone_stairs");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.COBBLED_SCULK_STONE_WALL), DDBlocks.SCULK_STONE_WALL, 0.1F, 200, "sculk_stone_wall");

        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_COAL_ORE), Items.COAL, 0.2F, 200, "coal");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_IRON_ORE), Items.IRON_INGOT, 1.4F, 200, "iron_ingot");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_COPPER_ORE), Items.COPPER_INGOT, 1.4F, 200, "copper_ingot");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_GOLD_ORE), Items.GOLD_INGOT, 2.0F, 200, "gold_ingot");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_REDSTONE_ORE), Items.REDSTONE, 1.4F, 200, "redstone");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_EMERALD_ORE), Items.EMERALD, 2.0F, 200, "emerald");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_LAPIS_ORE), Items.LAPIS_LAZULI, 0.4F, 200, "lapis_lazuli");
        oreSmelting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_DIAMOND_ORE), Items.DIAMOND, 2.0F, 200, "diamond");

        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_COAL_ORE), Items.COAL, 0.2F, 100, "coal");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_IRON_ORE), Items.IRON_INGOT, 1.4F, 100, "iron_ingot");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_COPPER_ORE), Items.COPPER_INGOT, 1.4F, 100, "copper_ingot");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_GOLD_ORE), Items.GOLD_INGOT, 2.0F, 100, "gold_ingot");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_REDSTONE_ORE), Items.REDSTONE, 1.4F, 100, "redstone");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_EMERALD_ORE), Items.EMERALD, 2.0F, 100, "emerald");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_LAPIS_ORE), Items.LAPIS_LAZULI, 0.4F, 100, "lapis_lazuli");
        oreBlasting(consumer, ImmutableList.of(DDBlocks.SCULK_STONE_DIAMOND_ORE), Items.DIAMOND, 2.0F, 100, "diamond");
    }

    @NotNull
    @Override
    public String getName() {
        return "Smelting Recipes";
    }
}
