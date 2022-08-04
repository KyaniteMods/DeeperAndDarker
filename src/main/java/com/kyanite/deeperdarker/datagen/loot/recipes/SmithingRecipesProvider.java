package com.kyanite.deeperdarker.datagen.loot.recipes;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class SmithingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public SmithingRecipesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HELMET), Ingredient.of(DDItems.WARDEN_CARAPACE.get()), DDItems.WARDEN_HELMET.get()).unlocks("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_helmet_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_CHESTPLATE), Ingredient.of(DDItems.WARDEN_CARAPACE.get()), DDItems.WARDEN_CHESTPLATE.get()).unlocks("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_chestplate_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_LEGGINGS), Ingredient.of(DDItems.WARDEN_CARAPACE.get()), DDItems.WARDEN_LEGGINGS.get()).unlocks("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_leggings_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_BOOTS), Ingredient.of(DDItems.WARDEN_CARAPACE.get()), DDItems.WARDEN_BOOTS.get()).unlocks("has_warden_carapace", has(DDItems.WARDEN_CARAPACE.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_boots_smithing"));
    }

    @NotNull
    @Override
    public String getName() {
        return "Smithing Recipes";
    }
}