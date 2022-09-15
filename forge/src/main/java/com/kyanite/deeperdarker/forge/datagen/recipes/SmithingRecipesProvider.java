package com.kyanite.deeperdarker.forge.datagen.recipes;

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
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HELMET), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_HELMET).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_helmet_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_CHESTPLATE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_CHESTPLATE).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_chestplate_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_LEGGINGS), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_LEGGINGS).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_leggings_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_BOOTS), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_BOOTS).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_boots_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_SWORD), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_SWORD).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_sword_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_SHOVEL), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_SHOVEL).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_shovel_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_PICKAXE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_PICKAXE).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_pickaxe_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_AXE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_AXE).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_axe_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HOE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), DDItems.WARDEN_HOE).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD)).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_hoe_smithing"));
    }

    @NotNull
    @Override
    public String getName() {
        return "Smithing Recipes";
    }
}
