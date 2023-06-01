package com.kyanite.deeperdarker.forge.datagen.recipes;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class SmithingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public SmithingRecipesProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        /*UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HELMET), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_HELMET.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_helmet_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_CHESTPLATE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_CHESTPLATE.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_chestplate_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_LEGGINGS), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_LEGGINGS.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_leggings_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_BOOTS), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_BOOTS.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_boots_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_SWORD), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_SWORD.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_sword_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_SHOVEL), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_SHOVEL.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_shovel_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_PICKAXE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_PICKAXE.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_pickaxe_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_AXE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_AXE.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_axe_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_HOE), Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), DDItems.WARDEN_HOE.get()).unlocks("has_reinforced_echo_shard", has(DDItems.REINFORCED_ECHO_SHARD.get())).save(consumer, new ResourceLocation(DeeperAndDarker.MOD_ID, "warden_hoe_smithing"));*/
    }
}
