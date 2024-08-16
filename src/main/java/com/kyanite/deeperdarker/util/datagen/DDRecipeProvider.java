package com.kyanite.deeperdarker.util.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        SmithingTransformRecipeBuilder NETHERITE_HELMET_TO_WARDEN_HELMET_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_HELMET)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_HELMET);
        SmithingTransformRecipeBuilder NETHERITE_CHESTPLATE_TO_WARDEN_CHESTPLATE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_CHESTPLATE)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_CHESTPLATE);
        SmithingTransformRecipeBuilder NETHERITE_LEGGINGS_TO_WARDEN_LEGGINGS_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_LEGGINGS)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_LEGGINGS);
        SmithingTransformRecipeBuilder NETHERITE_BOOTS_TO_WARDEN_BOOTS_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_BOOTS)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_BOOTS);
        SmithingTransformRecipeBuilder NETHERITE_SWORD_TO_WARDEN_SWORD_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_SWORD)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_SWORD);
        SmithingTransformRecipeBuilder NETHERITE_PICKAXE_TO_WARDEN_PICKAXE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_PICKAXE)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_PICKAXE);
        SmithingTransformRecipeBuilder NETHERITE_AXE_TO_WARDEN_AXE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_AXE)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_AXE);
        SmithingTransformRecipeBuilder NETHERITE_SHOVEL_TO_WARDEN_SHOVEL_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_SHOVEL)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_SHOVEL);
        SmithingTransformRecipeBuilder NETHERITE_HOE_TO_WARDEN_HOE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)),
                Ingredient.of(new ItemStack(Items.NETHERITE_HOE)),
                Ingredient.of(new ItemStack(DDItems.REINFORCED_ECHO_SHARD)),
                RecipeCategory.COMBAT,
                DDItems.WARDEN_HOE);
        SmithingTransformRecipeBuilder IRON_HELMET_TO_RESONARIUM_HELMET_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_HELMET)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_HELMET);
        SmithingTransformRecipeBuilder IRON_CHESTPLATE_TO_RESONARIUM_CHESTPLATE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_CHESTPLATE)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_CHESTPLATE);
        SmithingTransformRecipeBuilder IRON_LEGGINGS_TO_RESONARIUM_LEGGINGS_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_LEGGINGS)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_LEGGINGS);
        SmithingTransformRecipeBuilder IRON_BOOTS_TO_RESONARIUM_BOOTS_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_BOOTS)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_BOOTS);
        SmithingTransformRecipeBuilder IRON_SWORD_TO_RESONARIUM_SWORD_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_SWORD)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_SWORD);
        SmithingTransformRecipeBuilder IRON_PICKAXE_TO_RESONARIUM_PICKAXE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_PICKAXE)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_PICKAXE);
        SmithingTransformRecipeBuilder IRON_AXE_TO_RESONARIUM_AXE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_AXE)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_AXE);
        SmithingTransformRecipeBuilder IRON_SHOVEL_TO_RESONARIUM_SHOVEL_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_SHOVEL)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_SHOVEL);
        SmithingTransformRecipeBuilder IRON_HOE_TO_RESONARIUM_HOE_UPGRADE = SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(new ItemStack(Items.AIR)),
                Ingredient.of(new ItemStack(Items.IRON_HOE)),
                Ingredient.of(new ItemStack(DDItems.RESONARIUM)),
                RecipeCategory.COMBAT,
                DDItems.RESONARIUM_HOE);

        NETHERITE_HELMET_TO_WARDEN_HELMET_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_CHESTPLATE_TO_WARDEN_CHESTPLATE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_LEGGINGS_TO_WARDEN_LEGGINGS_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_BOOTS_TO_WARDEN_BOOTS_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_SWORD_TO_WARDEN_SWORD_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_SHOVEL_TO_WARDEN_SHOVEL_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_PICKAXE_TO_WARDEN_PICKAXE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_AXE_TO_WARDEN_AXE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        NETHERITE_HOE_TO_WARDEN_HOE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
        IRON_HELMET_TO_RESONARIUM_HELMET_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_CHESTPLATE_TO_RESONARIUM_CHESTPLATE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_LEGGINGS_TO_RESONARIUM_LEGGINGS_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_BOOTS_TO_RESONARIUM_BOOTS_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_SWORD_TO_RESONARIUM_SWORD_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_PICKAXE_TO_RESONARIUM_PICKAXE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_AXE_TO_RESONARIUM_AXE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_SHOVEL_TO_RESONARIUM_SHOVEL_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        IRON_HOE_TO_RESONARIUM_HOE_UPGRADE.unlocks(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM));
        NETHERITE_HELMET_TO_WARDEN_HELMET_UPGRADE.save(exporter, DeeperDarker.rl("netherite_helmet_to_warden_helmet_upgrade"));
        NETHERITE_CHESTPLATE_TO_WARDEN_CHESTPLATE_UPGRADE.save(exporter, DeeperDarker.rl("netherite_chestplate_to_warden_chestplate_upgrade"));
        NETHERITE_LEGGINGS_TO_WARDEN_LEGGINGS_UPGRADE.save(exporter, DeeperDarker.rl("netherite_leggings_to_warden_leggings_upgrade"));
        NETHERITE_BOOTS_TO_WARDEN_BOOTS_UPGRADE.save(exporter, DeeperDarker.rl("netherite_boots_to_warden_boots_upgrade"));
        NETHERITE_SWORD_TO_WARDEN_SWORD_UPGRADE.save(exporter, DeeperDarker.rl("netherite_sword_to_warden_sword_upgrade"));
        NETHERITE_PICKAXE_TO_WARDEN_PICKAXE_UPGRADE.save(exporter, DeeperDarker.rl("netherite_pickaxe_to_warden_pickaxe_upgrade"));
        NETHERITE_AXE_TO_WARDEN_AXE_UPGRADE.save(exporter, DeeperDarker.rl("netherite_axe_to_warden_axe_upgrade"));
        NETHERITE_SHOVEL_TO_WARDEN_SHOVEL_UPGRADE.save(exporter, DeeperDarker.rl("netherite_shovel_to_warden_shovel_upgrade"));
        NETHERITE_HOE_TO_WARDEN_HOE_UPGRADE.save(exporter, DeeperDarker.rl("netherite_hoe_to_warden_hoe_upgrade"));
        IRON_HELMET_TO_RESONARIUM_HELMET_UPGRADE.save(exporter, DeeperDarker.rl("iron_helmet_to_resonarium_helmet_upgrade"));
        IRON_CHESTPLATE_TO_RESONARIUM_CHESTPLATE_UPGRADE.save(exporter, DeeperDarker.rl("iron_chestplate_to_resonarium_chestplate_upgrade"));
        IRON_LEGGINGS_TO_RESONARIUM_LEGGINGS_UPGRADE.save(exporter, DeeperDarker.rl("iron_leggings_to_resonarium_leggings_upgrade"));
        IRON_BOOTS_TO_RESONARIUM_BOOTS_UPGRADE.save(exporter, DeeperDarker.rl("iron_boots_to_resonarium_boots_upgrade"));
        IRON_SWORD_TO_RESONARIUM_SWORD_UPGRADE.save(exporter, DeeperDarker.rl("iron_sword_to_resonarium_sword_upgrade"));
        IRON_PICKAXE_TO_RESONARIUM_PICKAXE_UPGRADE.save(exporter, DeeperDarker.rl("iron_pickaxe_to_resonarium_pickaxe_upgrade"));
        IRON_AXE_TO_RESONARIUM_AXE_UPGRADE.save(exporter, DeeperDarker.rl("iron_axe_to_resonarium_axe_upgrade"));
        IRON_SHOVEL_TO_RESONARIUM_SHOVEL_UPGRADE.save(exporter, DeeperDarker.rl("iron_shovel_to_resonarium_shovel_upgrade"));
        IRON_HOE_TO_RESONARIUM_HOE_UPGRADE.save(exporter, DeeperDarker.rl("iron_hoe_to_resonarium_hoe_upgrade"));

        // Wood stuff
            // Echo
        woodRecipes(exporter, DDBlocks.ECHO_PLANKS, DDTags.Items.ECHO_LOGS, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_DOOR, DDBlocks.ECHO_TRAPDOOR, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_BUTTON, DDItems.ECHO_SIGN, DDItems.ECHO_HANGING_SIGN, DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.ECHO_WOOD, 3).define('L', DDBlocks.ECHO_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.ECHO_LOG), FabricRecipeProvider.has(DDBlocks.ECHO_LOG)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DDBlocks.STRIPPED_ECHO_WOOD, 3).define('L', DDBlocks.STRIPPED_ECHO_LOG).pattern("LL").pattern("LL").unlockedBy(FabricRecipeProvider.getHasName(DDBlocks.ECHO_LOG), FabricRecipeProvider.has(DDBlocks.ECHO_LOG)).save(exporter);
            // Bloom
        woodRecipes(exporter, DDBlocks.BLOOM_PLANKS, DDTags.Items.BLOOMING_STEMS, DDBlocks.BLOOM_STAIRS, DDBlocks.BLOOM_SLAB, DDBlocks.BLOOM_FENCE, DDBlocks.BLOOM_FENCE_GATE, DDBlocks.BLOOM_DOOR, DDBlocks.BLOOM_TRAPDOOR, DDBlocks.BLOOM_PRESSURE_PLATE, DDBlocks.BLOOM_BUTTON, DDItems.BLOOM_SIGN, DDItems.BLOOM_HANGING_SIGN, DDItems.BLOOM_BOAT, DDItems.BLOOM_CHEST_BOAT);
        
        // Sculk Stone
        stairBuilder(DDBlocks.SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SCULK_STONE));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_WALL, DDBlocks.SCULK_STONE);

        stairBuilder(DDBlocks.COBBLED_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.COBBLED_SCULK_STONE));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE);

        polished(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.SCULK_STONE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_WALL);

        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.COBBLED_SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.COBBLED_SCULK_STONE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICK_WALL);

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.SCULK_STONE_TILES, DDBlocks.SCULK_STONE_TILE_STAIRS, DDBlocks.SCULK_STONE_TILE_SLAB, DDBlocks.SCULK_STONE_TILE_WALL);

        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE, 0.1f, 200, "sculk_stone");
        stairBuilder(DDBlocks.SMOOTH_SCULK_STONE_STAIRS, Ingredient.of(DDBlocks.SMOOTH_SCULK_STONE));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_STAIRS, DDBlocks.SMOOTH_SCULK_STONE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_SLAB, DDBlocks.SMOOTH_SCULK_STONE, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_SCULK_STONE_WALL, DDBlocks.SMOOTH_SCULK_STONE);

        polished(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_SCULK_STONE, DDBlocks.SMOOTH_SCULK_STONE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.SMOOTH_SCULK_STONE, DDBlocks.CUT_SCULK_STONE, DDBlocks.CUT_SCULK_STONE_STAIRS, DDBlocks.CUT_SCULK_STONE_SLAB, DDBlocks.CUT_SCULK_STONE_WALL);

        chiseled(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CHISELED_SCULK_STONE, DDBlocks.SCULK_STONE_BRICK_SLAB);

        // Sculk Grime
        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME, DDItems.GRIME_BALL);
        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICKS, DDItems.GRIME_BRICK);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICKS, DDBlocks.SCULK_GRIME);
        stairBuilder(DDBlocks.SCULK_GRIME_BRICK_STAIRS, Ingredient.of(DDBlocks.SCULK_GRIME_BRICKS));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_STAIRS, DDBlocks.SCULK_GRIME_BRICKS);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_SLAB, DDBlocks.SCULK_GRIME_BRICKS, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SCULK_GRIME_BRICK_WALL, DDBlocks.SCULK_GRIME_BRICKS);

        // Gloomslate
        stairBuilder(DDBlocks.GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.GLOOMSLATE));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_STAIRS, DDBlocks.GLOOMSLATE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_SLAB, DDBlocks.GLOOMSLATE, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_WALL, DDBlocks.GLOOMSLATE);

        stairBuilder(DDBlocks.COBBLED_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.COBBLED_GLOOMSLATE)).unlockedBy(getHasName(DDBlocks.COBBLED_GLOOMSLATE), has(DDBlocks.COBBLED_GLOOMSLATE)).save(exporter);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_STAIRS, DDBlocks.COBBLED_GLOOMSLATE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_SLAB, DDBlocks.COBBLED_GLOOMSLATE, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.COBBLED_GLOOMSLATE_WALL, DDBlocks.COBBLED_GLOOMSLATE);

        polished(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.COBBLED_GLOOMSLATE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE, DDBlocks.POLISHED_GLOOMSLATE_STAIRS, DDBlocks.POLISHED_GLOOMSLATE_SLAB, DDBlocks.POLISHED_GLOOMSLATE_WALL);

        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.COBBLED_GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICKS, DDBlocks.GLOOMSLATE_BRICK_STAIRS, DDBlocks.GLOOMSLATE_BRICK_SLAB, DDBlocks.GLOOMSLATE_BRICK_WALL);

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.GLOOMSLATE_TILES, DDBlocks.COBBLED_GLOOMSLATE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.COBBLED_GLOOMSLATE, DDBlocks.GLOOMSLATE_TILES, DDBlocks.GLOOMSLATE_TILE_STAIRS, DDBlocks.GLOOMSLATE_TILE_SLAB, DDBlocks.GLOOMSLATE_TILE_WALL);

        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE), RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE, 0.1f, 200, "sculk_stone");
        stairBuilder(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, Ingredient.of(DDBlocks.SMOOTH_GLOOMSLATE));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_STAIRS, DDBlocks.SMOOTH_GLOOMSLATE);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_SLAB, DDBlocks.SMOOTH_GLOOMSLATE, 2);
        wall(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.SMOOTH_GLOOMSLATE_WALL, DDBlocks.SMOOTH_GLOOMSLATE);

        polished(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CUT_GLOOMSLATE, DDBlocks.SMOOTH_GLOOMSLATE);
        registerStairsSlabsAndWalls(exporter, DDBlocks.SMOOTH_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE, DDBlocks.CUT_GLOOMSLATE_STAIRS, DDBlocks.CUT_GLOOMSLATE_SLAB, DDBlocks.CUT_GLOOMSLATE_WALL);

        chiseled(exporter, RecipeCategory.BUILDING_BLOCKS, DDBlocks.CHISELED_GLOOMSLATE, DDBlocks.GLOOMSLATE_BRICK_SLAB);

        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 200, "coal");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 100, "coal");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "gold_ingot");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "gold_ingot");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "lapis_lazuli");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.SCULK_STONE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 200, "coal");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1f, 100, "coal");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "gold_ingot");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_GOLD_ORE), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "gold_ingot");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_REDSTONE_ORE), RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_LAPIS_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "lapis_lazuli");
        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(exporter, Collections.singletonList(DDBlocks.GLOOMSLATE_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");

        oreSmelting(exporter, Collections.singletonList(DDItems.GRIME_BALL), RecipeCategory.MISC, DDItems.GRIME_BRICK, 0.3f, 200, "grime_brick");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, 2).define('D', Items.DIAMOND).define('U', DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE).define('S', Items.SCULK).pattern("DUD").pattern("DSD").pattern("DDD").unlockedBy(FabricRecipeProvider.getHasName(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), FabricRecipeProvider.has(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDItems.REINFORCED_ECHO_SHARD).define('P', Items.PHANTOM_MEMBRANE).define('C', DDItems.WARDEN_CARAPACE).define('E', Items.ECHO_SHARD).pattern("PCP").pattern("CEC").pattern("PCP").unlockedBy(FabricRecipeProvider.getHasName(Items.ECHO_SHARD), FabricRecipeProvider.has(Items.ECHO_SHARD)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, DDItems.SOUL_ELYTRA).define('B', DDItems.SCULK_BONE).define('D', DDItems.SOUL_DUST).define('E', Items.ELYTRA).define('S', DDItems.SOUL_CRYSTAL).pattern("BDB").pattern("DED").pattern("BSB").unlockedBy(FabricRecipeProvider.getHasName(Items.ELYTRA), FabricRecipeProvider.has(Items.ELYTRA)).save(exporter);

        oreSmelting(exporter, Collections.singletonList(DDBlocks.GLOOMY_CACTUS), RecipeCategory.MISC, DDBlocks.GLOOMY_CACTUS, 1.0f, 200, "orange_dye");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDBlocks.SOUNDPROOF_GLASS, 16).define('S', DDItems.SOUL_DUST).define('C', DDItems.SOUL_CRYSTAL).define('G', Blocks.GLASS).pattern("SCS").pattern("CGC").pattern("SCS").unlockedBy(FabricRecipeProvider.getHasName(DDItems.SOUL_CRYSTAL), FabricRecipeProvider.has(DDItems.SOUL_CRYSTAL)).save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDItems.RESONARIUM_PLATE)
                .requires(DDItems.RESONARIUM, 4).requires(Items.ARMADILLO_SCUTE, 4)
                .unlockedBy(FabricRecipeProvider.getHasName(DDItems.RESONARIUM), FabricRecipeProvider.has(DDItems.RESONARIUM)).save(exporter);
    }

    private static void woodRecipes(RecipeOutput exporter, ItemLike planks, TagKey<Item> logs, ItemLike stairs, ItemLike slab, ItemLike fence, ItemLike fenceGate, ItemLike door, ItemLike trapdoor, ItemLike pressurePlate, ItemLike button, ItemLike sign, ItemLike hangingSign, ItemLike boat, ItemLike chestBoat) {
        planksFromLogs(exporter, planks, logs, 4);
        stairBuilder(stairs, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, slab, planks);
        fenceBuilder(fence, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        fenceGateBuilder(fenceGate, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        doorBuilder(door, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        trapdoorBuilder(trapdoor, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks)).save(exporter);
        pressurePlate(exporter, pressurePlate, planks);
        oneToOneConversionRecipe(exporter, button, planks, "wooden_button");
        signBuilder(sign, Ingredient.of(planks)).unlockedBy(FabricRecipeProvider.getHasName(planks), FabricRecipeProvider.has(planks));
        hangingSign(exporter, hangingSign, planks);
        woodenBoat(exporter, boat, planks);
        chestBoat(exporter, chestBoat, planks);
    }

    private static void registerStairsSlabsAndWalls(RecipeOutput exporter, ItemLike originalStone, ItemLike stone, ItemLike stairs, ItemLike slab, ItemLike wall) {
        stairBuilder(stairs, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(exporter);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, stairs, stone);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, stairs, originalStone);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(exporter, getConversionRecipeName(slab, stone));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(originalStone)).unlockedBy(getHasName(originalStone), has(originalStone)).save(exporter, getConversionRecipeName(slab, originalStone));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, slab, stone, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, slab, originalStone, 2);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(stone)).unlockedBy(getHasName(stone), has(stone)).save(exporter, getConversionRecipeName(wall, stone));
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(originalStone)).unlockedBy(getHasName(originalStone), has(originalStone)).save(exporter, getConversionRecipeName(wall, originalStone));
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, wall, stone);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, wall, originalStone);
    }
}