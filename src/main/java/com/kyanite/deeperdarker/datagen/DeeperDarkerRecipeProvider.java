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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
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
        offerPlanksRecipe(exporter, DeeperDarkerItems.ECHO_PLANKS, TagKey.of(
                RegistryKeys.ITEM, new Identifier(DeeperDarker.MOD_ID, "echo_logs")), 4);
        offerSingleOutputShapelessRecipe(exporter, DeeperDarkerItems.ECHO_BUTTON, DeeperDarkerItems.ECHO_PLANKS, "wooden_button");
        createDoorRecipe(DeeperDarkerItems.ECHO_DOOR, Ingredient.ofItems(DeeperDarkerItems.ECHO_PLANKS)).criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.ECHO_PLANKS), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.ECHO_PLANKS)).offerTo(exporter);
        createFenceGateRecipe(DeeperDarkerItems.ECHO_FENCE_GATE, Ingredient.ofItems(DeeperDarkerItems.ECHO_PLANKS)).criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.ECHO_PLANKS), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.ECHO_PLANKS)).offerTo(exporter);
        createFenceRecipe(DeeperDarkerItems.ECHO_FENCE, Ingredient.ofItems(DeeperDarkerItems.ECHO_PLANKS)).criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.ECHO_PLANKS), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.ECHO_PLANKS)).offerTo(exporter);
        offerHangingSignRecipe(exporter, DeeperDarkerItems.ECHO_HANGING_SIGN, DeeperDarkerItems.ECHO_PLANKS);
        offerPressurePlateRecipe(exporter, DeeperDarkerItems.ECHO_PRESSURE_PLATE, DeeperDarkerItems.ECHO_PLANKS);
        createSignRecipe(DeeperDarkerItems.ECHO_SIGN, Ingredient.ofItems(DeeperDarkerItems.ECHO_PLANKS)).criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.ECHO_PLANKS), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.ECHO_PLANKS));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.ECHO_SLAB, DeeperDarkerItems.ECHO_PLANKS);
        createStairsRecipe(DeeperDarkerItems.ECHO_STAIRS, Ingredient.ofItems(DeeperDarkerItems.ECHO_PLANKS)).criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.ECHO_PLANKS), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.ECHO_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(DeeperDarkerItems.ECHO_TRAPDOOR, Ingredient.ofItems(DeeperDarkerItems.ECHO_PLANKS)).criterion(FabricRecipeProvider.hasItem(DeeperDarkerItems.ECHO_PLANKS), FabricRecipeProvider.conditionsFromItem(DeeperDarkerItems.ECHO_PLANKS)).offerTo(exporter);

        // Sculk Stone
        createStairsRecipe(DeeperDarkerItems.SCULK_STONE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.SCULK_STONE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_STAIRS, DeeperDarkerItems.SCULK_STONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_SLAB, DeeperDarkerItems.SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_SLAB, DeeperDarkerItems.SCULK_STONE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_WALL, DeeperDarkerItems.SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_WALL, DeeperDarkerItems.SCULK_STONE);

        createStairsRecipe(DeeperDarkerItems.COBBLED_SCULK_STONE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.COBBLED_SCULK_STONE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_SCULK_STONE_STAIRS, DeeperDarkerItems.COBBLED_SCULK_STONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_SCULK_STONE_SLAB, DeeperDarkerItems.COBBLED_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_SCULK_STONE_SLAB, DeeperDarkerItems.COBBLED_SCULK_STONE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_SCULK_STONE_WALL, DeeperDarkerItems.COBBLED_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_SCULK_STONE_WALL, DeeperDarkerItems.COBBLED_SCULK_STONE);
        
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE, DeeperDarkerItems.SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE, DeeperDarkerItems.SCULK_STONE);
        createStairsRecipe(DeeperDarkerItems.POLISHED_SCULK_STONE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.POLISHED_SCULK_STONE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE_STAIRS, DeeperDarkerItems.POLISHED_SCULK_STONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE_SLAB, DeeperDarkerItems.POLISHED_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE_SLAB, DeeperDarkerItems.POLISHED_SCULK_STONE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE_WALL, DeeperDarkerItems.POLISHED_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_SCULK_STONE_WALL, DeeperDarkerItems.POLISHED_SCULK_STONE);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICKS, DeeperDarkerItems.SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICKS, DeeperDarkerItems.SCULK_STONE);
        createStairsRecipe(DeeperDarkerItems.SCULK_STONE_BRICK_STAIRS, Ingredient.ofItems(DeeperDarkerItems.SCULK_STONE_BRICKS));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICK_STAIRS, DeeperDarkerItems.SCULK_STONE_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICK_SLAB, DeeperDarkerItems.SCULK_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICK_SLAB, DeeperDarkerItems.SCULK_STONE_BRICKS, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICK_WALL, DeeperDarkerItems.SCULK_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_BRICK_WALL, DeeperDarkerItems.SCULK_STONE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_TILES, DeeperDarkerItems.SCULK_STONE);
        createStairsRecipe(DeeperDarkerItems.SCULK_STONE_TILE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.SCULK_STONE_TILES));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_TILE_STAIRS, DeeperDarkerItems.SCULK_STONE_TILES);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_TILE_SLAB, DeeperDarkerItems.SCULK_STONE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_TILE_SLAB, DeeperDarkerItems.SCULK_STONE_TILES, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_TILE_WALL, DeeperDarkerItems.SCULK_STONE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_STONE_TILE_WALL, DeeperDarkerItems.SCULK_STONE_TILES);

        offerSmelting(exporter, List.of(DeeperDarkerItems.SCULK_STONE), RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_SCULK_STONE, 0.1f, 200, "sculk_stone");
        createStairsRecipe(DeeperDarkerItems.SMOOTH_SCULK_STONE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.SMOOTH_SCULK_STONE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_SCULK_STONE_STAIRS, DeeperDarkerItems.SMOOTH_SCULK_STONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_SCULK_STONE_SLAB, DeeperDarkerItems.SMOOTH_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_SCULK_STONE_SLAB, DeeperDarkerItems.SMOOTH_SCULK_STONE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_SCULK_STONE_WALL, DeeperDarkerItems.SMOOTH_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_SCULK_STONE_WALL, DeeperDarkerItems.SMOOTH_SCULK_STONE);
        
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_SCULK_STONE, DeeperDarkerItems.SMOOTH_SCULK_STONE);
        createStairsRecipe(DeeperDarkerItems.CUT_SCULK_STONE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.CUT_SCULK_STONE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_SCULK_STONE_STAIRS, DeeperDarkerItems.CUT_SCULK_STONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_SCULK_STONE_SLAB, DeeperDarkerItems.CUT_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_SCULK_STONE_SLAB, DeeperDarkerItems.CUT_SCULK_STONE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_SCULK_STONE_WALL, DeeperDarkerItems.CUT_SCULK_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_SCULK_STONE_WALL, DeeperDarkerItems.CUT_SCULK_STONE);

        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CHISELED_SCULK_STONE, DeeperDarkerItems.SCULK_STONE_BRICK_SLAB);

        // Sculk Grime
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICKS, DeeperDarkerItems.SCULK_GRIME);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICKS, DeeperDarkerItems.SCULK_GRIME);
        createStairsRecipe(DeeperDarkerItems.SCULK_GRIME_BRICK_STAIRS, Ingredient.ofItems(DeeperDarkerItems.SCULK_GRIME_BRICKS));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICK_STAIRS, DeeperDarkerItems.SCULK_GRIME_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICK_SLAB, DeeperDarkerItems.SCULK_GRIME_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICK_SLAB, DeeperDarkerItems.SCULK_GRIME_BRICKS, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICK_WALL, DeeperDarkerItems.SCULK_GRIME_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SCULK_GRIME_BRICK_WALL, DeeperDarkerItems.SCULK_GRIME_BRICKS);
    
        // Gloomslate
        createStairsRecipe(DeeperDarkerItems.GLOOMSLATE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.GLOOMSLATE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_STAIRS, DeeperDarkerItems.GLOOMSLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_SLAB, DeeperDarkerItems.GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_SLAB, DeeperDarkerItems.GLOOMSLATE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_WALL, DeeperDarkerItems.GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_WALL, DeeperDarkerItems.GLOOMSLATE);

        createStairsRecipe(DeeperDarkerItems.COBBLED_GLOOMSLATE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.COBBLED_GLOOMSLATE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_GLOOMSLATE_STAIRS, DeeperDarkerItems.COBBLED_GLOOMSLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_GLOOMSLATE_SLAB, DeeperDarkerItems.COBBLED_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_GLOOMSLATE_SLAB, DeeperDarkerItems.COBBLED_GLOOMSLATE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_GLOOMSLATE_WALL, DeeperDarkerItems.COBBLED_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.COBBLED_GLOOMSLATE_WALL, DeeperDarkerItems.COBBLED_GLOOMSLATE);

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE, DeeperDarkerItems.GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE, DeeperDarkerItems.GLOOMSLATE);
        createStairsRecipe(DeeperDarkerItems.POLISHED_GLOOMSLATE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.POLISHED_GLOOMSLATE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE_STAIRS, DeeperDarkerItems.POLISHED_GLOOMSLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE_SLAB, DeeperDarkerItems.POLISHED_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE_SLAB, DeeperDarkerItems.POLISHED_GLOOMSLATE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE_WALL, DeeperDarkerItems.POLISHED_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.POLISHED_GLOOMSLATE_WALL, DeeperDarkerItems.POLISHED_GLOOMSLATE);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICKS, DeeperDarkerItems.GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICKS, DeeperDarkerItems.GLOOMSLATE);
        createStairsRecipe(DeeperDarkerItems.GLOOMSLATE_BRICK_STAIRS, Ingredient.ofItems(DeeperDarkerItems.GLOOMSLATE_BRICKS));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICK_STAIRS, DeeperDarkerItems.GLOOMSLATE_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICK_SLAB, DeeperDarkerItems.GLOOMSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICK_SLAB, DeeperDarkerItems.GLOOMSLATE_BRICKS, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICK_WALL, DeeperDarkerItems.GLOOMSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_BRICK_WALL, DeeperDarkerItems.GLOOMSLATE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_TILES, DeeperDarkerItems.GLOOMSLATE);
        createStairsRecipe(DeeperDarkerItems.GLOOMSLATE_TILE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.GLOOMSLATE_TILES));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_TILE_STAIRS, DeeperDarkerItems.GLOOMSLATE_TILES);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_TILE_SLAB, DeeperDarkerItems.GLOOMSLATE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_TILE_SLAB, DeeperDarkerItems.GLOOMSLATE_TILES, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_TILE_WALL, DeeperDarkerItems.GLOOMSLATE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.GLOOMSLATE_TILE_WALL, DeeperDarkerItems.GLOOMSLATE_TILES);

        offerSmelting(exporter, List.of(DeeperDarkerItems.GLOOMSLATE), RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_GLOOMSLATE, 0.1f, 200, "sculk_stone");
        createStairsRecipe(DeeperDarkerItems.SMOOTH_GLOOMSLATE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.SMOOTH_GLOOMSLATE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_GLOOMSLATE_STAIRS, DeeperDarkerItems.SMOOTH_GLOOMSLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_GLOOMSLATE_SLAB, DeeperDarkerItems.SMOOTH_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_GLOOMSLATE_SLAB, DeeperDarkerItems.SMOOTH_GLOOMSLATE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_GLOOMSLATE_WALL, DeeperDarkerItems.SMOOTH_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.SMOOTH_GLOOMSLATE_WALL, DeeperDarkerItems.SMOOTH_GLOOMSLATE);

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_GLOOMSLATE, DeeperDarkerItems.SMOOTH_GLOOMSLATE);
        createStairsRecipe(DeeperDarkerItems.CUT_GLOOMSLATE_STAIRS, Ingredient.ofItems(DeeperDarkerItems.CUT_GLOOMSLATE));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_GLOOMSLATE_STAIRS, DeeperDarkerItems.CUT_GLOOMSLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_GLOOMSLATE_SLAB, DeeperDarkerItems.CUT_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_GLOOMSLATE_SLAB, DeeperDarkerItems.CUT_GLOOMSLATE, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_GLOOMSLATE_WALL, DeeperDarkerItems.CUT_GLOOMSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CUT_GLOOMSLATE_WALL, DeeperDarkerItems.CUT_GLOOMSLATE);

        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DeeperDarkerItems.CHISELED_GLOOMSLATE, DeeperDarkerItems.GLOOMSLATE_BRICK_SLAB);
    }
}