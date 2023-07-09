package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class DeeperDarkerRecipeProvider extends FabricRecipeProvider {
    public DeeperDarkerRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        SmithingTransformRecipeJsonBuilder NETHERITE_HELMET_TO_WARDEN_HELMET_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_HELMET)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_HELMET);
        SmithingTransformRecipeJsonBuilder NETHERITE_CHESTPLATE_TO_WARDEN_CHESTPLATE_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_CHESTPLATE)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_CHESTPLATE);
        SmithingTransformRecipeJsonBuilder NETHERITE_LEGGINGS_TO_WARDEN_LEGGINGS_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_LEGGINGS)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_LEGGINGS);
        SmithingTransformRecipeJsonBuilder NETHERITE_BOOTS_TO_WARDEN_BOOTS_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_BOOTS)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_BOOTS);
        SmithingTransformRecipeJsonBuilder NETHERITE_SWORD_TO_WARDEN_SWORD_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_SWORD)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_SWORD);
        SmithingTransformRecipeJsonBuilder NETHERITE_PICKAXE_TO_WARDEN_PICKAXE_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_PICKAXE)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_PICKAXE);
        SmithingTransformRecipeJsonBuilder NETHERITE_AXE_TO_WARDEN_AXE_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_AXE)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_AXE);
        SmithingTransformRecipeJsonBuilder NETHERITE_SHOVEL_TO_WARDEN_SHOVEL_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_SHOVEL)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_SHOVEL);
        SmithingTransformRecipeJsonBuilder NETHERITE_HOE_TO_WARDEN_HOE_UPGRADE = SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.ofStacks(new ItemStack(Items.NETHERITE_HOE)),
                Ingredient.ofStacks(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DeeperDarkerItems.WARDEN_HOE);
        NETHERITE_HELMET_TO_WARDEN_HELMET_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_CHESTPLATE_TO_WARDEN_CHESTPLATE_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_LEGGINGS_TO_WARDEN_LEGGINGS_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_BOOTS_TO_WARDEN_BOOTS_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_SWORD_TO_WARDEN_SWORD_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_SHOVEL_TO_WARDEN_SHOVEL_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_PICKAXE_TO_WARDEN_PICKAXE_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_AXE_TO_WARDEN_AXE_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_HOE_TO_WARDEN_HOE_UPGRADE.criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_HELMET_TO_WARDEN_HELMET_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_helmet_to_warden_helmet_upgrade"));
        NETHERITE_CHESTPLATE_TO_WARDEN_CHESTPLATE_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_chestplate_to_warden_chestplate_upgrade"));
        NETHERITE_LEGGINGS_TO_WARDEN_LEGGINGS_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_leggings_to_warden_leggings_upgrade"));
        NETHERITE_BOOTS_TO_WARDEN_BOOTS_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_boots_to_warden_boots_upgrade"));
        NETHERITE_SWORD_TO_WARDEN_SWORD_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_sword_to_warden_sword_upgrade"));
        NETHERITE_PICKAXE_TO_WARDEN_PICKAXE_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_pickaxe_to_warden_pickaxe_upgrade"));
        NETHERITE_AXE_TO_WARDEN_AXE_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_axe_to_warden_axe_upgrade"));
        NETHERITE_SHOVEL_TO_WARDEN_SHOVEL_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_shovel_to_warden_shovel_upgrade"));
        NETHERITE_HOE_TO_WARDEN_HOE_UPGRADE.offerTo(exporter, new Identifier(DeeperDarker.MOD_ID, "netherite_hoe_to_warden_hoe_upgrade"));
    }
}