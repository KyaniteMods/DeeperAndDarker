package com.kyanite.deeperdarker.forge.datagen.recipes;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        woodFromLogs(consumer, DDBlocks.ECHO_WOOD, DDBlocks.ECHO_LOG);
        woodFromLogs(consumer, DDBlocks.STRIPPED_ECHO_WOOD, DDBlocks.STRIPPED_ECHO_LOG);
        planksFromLogs(consumer, DDBlocks.ECHO_PLANKS, DDTags.Items.ECHO_LOGS);
        slabBuilder(DDBlocks.ECHO_SLAB, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        stairBuilder(DDBlocks.ECHO_STAIRS, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        fenceBuilder(DDBlocks.ECHO_FENCE, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        buttonBuilder(DDBlocks.ECHO_BUTTON, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        pressurePlateBuilder(DDBlocks.ECHO_PRESSURE_PLATE, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        doorBuilder(DDBlocks.ECHO_DOOR, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        trapdoorBuilder(DDBlocks.ECHO_TRAPDOOR, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        fenceGateBuilder(DDBlocks.ECHO_FENCE_GATE, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        signBuilder(DDBlocks.ECHO_SIGN_ITEM, Ingredient.of(DDBlocks.ECHO_PLANKS)).unlockedBy("has_echo_planks", has(DDBlocks.ECHO_PLANKS)).save(consumer);
        woodenBoat(consumer, DDItems.ECHO_BOAT, DDBlocks.ECHO_PLANKS);
        ShapelessRecipeBuilder.shapeless(DDItems.ECHO_CHEST_BOAT).requires(Blocks.CHEST).requires(DDItems.ECHO_BOAT).group("chest_boat").unlockedBy("has_boat", has(ItemTags.BOATS)).save(consumer);

        slabBuilder(DDBlocks.SCULK_STONE_SLAB, Ingredient.of(DDBlocks.SCULK_STONE)).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE)).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE)).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE)).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_WALL, Ingredient.of(DDBlocks.SCULK_STONE)).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE)).save(consumer);

        slabBuilder(DDBlocks.COBBLED_SCULK_STONE_SLAB, Ingredient.of(DDBlocks.COBBLED_SCULK_STONE)).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE)).save(consumer);
        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.COBBLED_SCULK_STONE)).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE)).save(consumer);
        wallBuilder(DDBlocks.COBBLED_SCULK_STONE_WALL, Ingredient.of(DDBlocks.COBBLED_SCULK_STONE)).unlockedBy("has_cobbled_sculk_stone", has(DDBlocks.COBBLED_SCULK_STONE)).save(consumer);

        polishedBuilder(DDBlocks.POLISHED_SCULK_STONE, Ingredient.of(DDBlocks.SCULK_STONE)).unlockedBy("has_sculk_stone", has(DDBlocks.SCULK_STONE)).save(consumer);
        slabBuilder(DDBlocks.POLISHED_SCULK_STONE_SLAB, Ingredient.of(DDBlocks.POLISHED_SCULK_STONE)).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE)).save(consumer);
        stairBuilder(DDBlocks.POLISHED_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.POLISHED_SCULK_STONE)).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE)).save(consumer);
        wallBuilder(DDBlocks.POLISHED_SCULK_STONE_WALL, Ingredient.of(DDBlocks.POLISHED_SCULK_STONE)).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE)).save(consumer);

        polishedBuilder(DDBlocks.SCULK_STONE_BRICKS, Ingredient.of(DDBlocks.POLISHED_SCULK_STONE)).unlockedBy("has_polished_sculk_stone", has(DDBlocks.POLISHED_SCULK_STONE)).save(consumer);
        slabBuilder(DDBlocks.SCULK_STONE_BRICK_SLAB, Ingredient.of(DDBlocks.SCULK_STONE_BRICKS)).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS)).save(consumer);
        stairBuilder(DDBlocks.SCULK_STONE_BRICK_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE_BRICKS)).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS)).save(consumer);
        wallBuilder(DDBlocks.SCULK_STONE_BRICK_WALL, Ingredient.of(DDBlocks.SCULK_STONE_BRICKS)).unlockedBy("has_sculk_stone_bricks", has(DDBlocks.SCULK_STONE_BRICKS)).save(consumer);

        ShapedRecipeBuilder.shaped(DDItems.REINFORCED_ECHO_SHARD, 1)
                .define('P', Items.PHANTOM_MEMBRANE)
                .define('E', Items.ECHO_SHARD)
                .define('C', DDItems.WARDEN_CARAPACE)
                .pattern("PEP")
                .pattern("ECE")
                .pattern("PEP")
                .unlockedBy("has_warden_carapace", has(DDItems.WARDEN_CARAPACE)).save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crafting Recipes";
    }
}
