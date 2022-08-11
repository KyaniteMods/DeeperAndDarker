package com.kyanite.deeperdarker.datagen.recipes;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        woodFromLogs(consumer, DDBlocks.ECHO_WOOD.get(), DDBlocks.ECHO_LOG.get());
        woodFromLogs(consumer, DDBlocks.STRIPPED_ECHO_WOOD.get(), DDBlocks.STRIPPED_ECHO_LOG.get());
        planksFromLogs(consumer, DDBlocks.ECHO_PLANKS.get(), DDTags.Items.ECHO_LOGS);
        slabBuilder(DDBlocks.ECHO_SLAB.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        stairBuilder(DDBlocks.ECHO_STAIRS.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        fenceBuilder(DDBlocks.ECHO_FENCE.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        buttonBuilder(DDBlocks.ECHO_BUTTON.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        pressurePlateBuilder(DDBlocks.ECHO_PRESSURE_PLATE.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        doorBuilder(DDBlocks.ECHO_DOOR.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        trapdoorBuilder(DDBlocks.ECHO_TRAPDOOR.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        fenceGateBuilder(DDBlocks.ECHO_FENCE_GATE.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);
        signBuilder(DDItems.ECHO_SIGN.get(), Ingredient.of(DDBlocks.ECHO_PLANKS.get())).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS.get())).save(consumer);

        slabBuilder(DDBlocks.SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);

        slabBuilder(DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.COBBLED_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.COBBLED_SCULK_STONE.get())).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE.get())).save(consumer);

        polishedBuilder(DDBlocks.POLISHED_SCULK_STONE.get(), Ingredient.of(DDBlocks.SCULK_STONE.get())).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE.get())).save(consumer);
        slabBuilder(DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        stairBuilder(DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        wallBuilder(DDBlocks.POLISHED_SCULK_STONE_WALL.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);

        polishedBuilder(DDBlocks.SCULK_STONE_BRICKS.get(), Ingredient.of(DDBlocks.POLISHED_SCULK_STONE.get())).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE.get())).save(consumer);
        slabBuilder(DDBlocks.SCULK_STONE_BRICK_SLAB.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_BRICK_WALL.get(), Ingredient.of(DDBlocks.SCULK_STONE_BRICKS.get())).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(DDItems.REINFORCED_ECHO_SHARD.get(), 1)
                .define('P', Items.PHANTOM_MEMBRANE)
                .define('E', Items.ECHO_SHARD)
                .define('C', DDItems.WARDEN_CARAPACE.get())
                .pattern("PEP")
                .pattern("ECE")
                .pattern("PEP")
                .unlockedBy("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get()))
                .save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crafting Recipes";
    }
}
