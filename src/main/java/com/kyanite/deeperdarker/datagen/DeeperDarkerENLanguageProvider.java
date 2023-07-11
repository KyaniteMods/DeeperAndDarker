package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Util;

public class DeeperDarkerENLanguageProvider extends FabricLanguageProvider {
    protected DeeperDarkerENLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.deeperdarker", "Deeper and Darker");
        translationBuilder.add(DeeperDarkerItems.WARDEN_HELMET, "Warden Helmet");
        translationBuilder.add(DeeperDarkerItems.WARDEN_CHESTPLATE, "Warden Chestplate");
        translationBuilder.add(DeeperDarkerItems.WARDEN_LEGGINGS, "Warden Leggings");
        translationBuilder.add(DeeperDarkerItems.WARDEN_BOOTS, "Warden Boots");
        translationBuilder.add(DeeperDarkerItems.WARDEN_SWORD, "Warden Sword");
        translationBuilder.add(DeeperDarkerItems.WARDEN_PICKAXE, "Warden Pickaxe");
        translationBuilder.add(DeeperDarkerItems.WARDEN_AXE, "Warden Axe");
        translationBuilder.add(DeeperDarkerItems.WARDEN_SHOVEL, "Warden Shovel");
        translationBuilder.add(DeeperDarkerItems.WARDEN_HOE, "Warden Hoe");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.applies_to", "Netherite Equipment");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.ingredients", "Reinforced Echo Shard");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.base_slot_description", "Add netherite armor, weapon, or tool");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.additions_slot_description", "Add Reinforced Echo Shard");
        translationBuilder.add("upgrade.deeperdarker.warden_upgrade", "Warden Upgrade");
        translationBuilder.add(DeeperDarkerItems.REINFORCED_ECHO_SHARD, "Reinforced Echo Shard");
        translationBuilder.add(DeeperDarkerItems.WARDEN_CARAPACE, "Warden Carapace");
        translationBuilder.add(DeeperDarkerItems.HEART_OF_THE_DEEP, "Heart of the Deep");
        translationBuilder.add(DeeperDarkerItems.SOUL_CRYSTAL, "Soul Crystal");
        translationBuilder.add(DeeperDarkerItems.SOUL_DUST, "Soul Dust");
        translationBuilder.add(DeeperDarkerItems.SCULK_BONE, "Sculk Bone");
        translationBuilder.add(DeeperDarkerItems.GRIME_BALL, "Grime Ball");
        translationBuilder.add(DeeperDarkerItems.GRIME_BRICK, "Grime Brick");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_LOG, "Echo Log");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_WOOD, "Echo Wood");
        translationBuilder.add(DeeperDarkerBlocks.STRIPPED_ECHO_LOG, "Stripped Echo Log");
        translationBuilder.add(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD, "Stripped Echo Wood");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_BUTTON, "Echo Button");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_DOOR, "Echo Door");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_FENCE_GATE, "Echo Fence Gate");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_FENCE, "Echo Fence");
        translationBuilder.add(Util.createTranslationKey("block", Registries.BLOCK.getId(DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN)), "Echo Wall Hanging Sign");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_HANGING_SIGN, "Echo Hanging Sign");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_LEAVES, "Echo Leaves");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_PLANKS, "Echo Planks");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE, "Echo Pressure Plate");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SAPLING, "Echo Sapling");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SIGN, "Echo Sign");
        translationBuilder.add(Util.createTranslationKey("block", Registries.BLOCK.getId(DeeperDarkerBlocks.ECHO_WALL_SIGN)), "Echo Wall Sign");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SLAB, "Echo Slab");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_TRAPDOOR, "Echo Trapdoor");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE, "Sculk Stone");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_STAIRS, "Sculk Stone Stairs");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_SLAB, "Sculk Stone Slab");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_WALL, "Sculk Stone Wall");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_SCULK_STONE, "Cobbled Sculk Stone");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS, "Cobbled Sculk Stone Stairs");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB, "Cobbled Sculk Stone Slab");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL, "Cobbled Sculk Stone Wall");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_SCULK_STONE, "Polished Sculk Stone");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS, "Polished Sculk Stone Stairs");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB, "Polished Sculk Stone Slab");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL, "Polished Sculk Stone Wall");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_BRICKS, "Sculk Stone Bricks");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS, "Sculk Stone Brick Stairs");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB, "Sculk Stone Brick Slab");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL, "Sculk Stone Brick Wall");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_TILES, "Sculk Stone Tiles");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS, "Sculk Stone Tile Stairs");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB, "Sculk Stone Tile Slab");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_TILE_WALL, "Sculk Stone Tile Wall");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_SCULK_STONE, "Smooth Sculk Stone");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS, "Smooth Sculk Stone Stairs");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB, "Smooth Sculk Stone Slab");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL, "Smooth Sculk Stone Wall");
        translationBuilder.add(DeeperDarkerBlocks.CUT_SCULK_STONE, "Cut Sculk Stone");
        translationBuilder.add(DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS, "Cut Sculk Stone Stairs");
        translationBuilder.add(DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB, "Cut Sculk Stone Slab");
        translationBuilder.add(DeeperDarkerBlocks.CUT_SCULK_STONE_WALL, "Cut Sculk Stone Wall");
        translationBuilder.add(DeeperDarkerBlocks.CHISELED_SCULK_STONE, "Chiseled Sculk Stone");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_GRIME, "Sculk Grime");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_GRIME_BRICKS, "Sculk Grime Bricks");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS, "Sculk Grime Brick Stairs");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB, "Sculk Grime Brick Slab");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_GRIME_BRICK_WALL, "Sculk Grime Brick Wall");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE, "Gloomslate");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_STAIRS, "Gloomslate Stairs");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_SLAB, "Gloomslate Slab");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_WALL, "Gloomslate Wall");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_GLOOMSLATE, "Cobbled Gloomslate");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS, "Cobbled Gloomslate Stairs");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB, "Cobbled Gloomslate Slab");
        translationBuilder.add(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_WALL, "Cobbled Gloomslate Wall");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_GLOOMSLATE, "Polished Gloomslate");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS, "Polished Gloomslate Stairs");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB, "Polished Gloomslate Slab");
        translationBuilder.add(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_WALL, "Polished Gloomslate Wall");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_BRICKS, "Gloomslate Bricks");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS, "Gloomslate Brick Stairs");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB, "Gloomslate Brick Slab");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_BRICK_WALL, "Gloomslate Brick Wall");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_TILES, "Gloomslate Tiles");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS, "Gloomslate Tile Stairs");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB, "Gloomslate Tile Slab");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMSLATE_TILE_WALL, "Gloomslate Tile Wall");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE, "Smooth Gloomslate");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS, "Smooth Gloomslate Stairs");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB, "Smooth Gloomslate Slab");
        translationBuilder.add(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_WALL, "Smooth Gloomslate Wall");
        translationBuilder.add(DeeperDarkerBlocks.CUT_GLOOMSLATE, "Cut Gloomslate");
        translationBuilder.add(DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS, "Cut Gloomslate Stairs");
        translationBuilder.add(DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB, "Cut Gloomslate Slab");
        translationBuilder.add(DeeperDarkerBlocks.CUT_GLOOMSLATE_WALL, "Cut Gloomslate Wall");
        translationBuilder.add(DeeperDarkerBlocks.CHISELED_GLOOMSLATE, "Chiseled Gloomslate");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SOIL, "Echo Soil");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_GLEAM, "Sculk Gleam");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_COAL_ORE, "Sculk Stone Coal Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_IRON_ORE, "Sculk Stone Iron Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE, "Sculk Stone Copper Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE, "Sculk Stone Gold Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE, "Sculk Stone Redstone Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE, "Sculk Stone Emerald Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE, "Sculk Stone Lapis Lazuli Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE, "Sculk Stone Diamond Ore");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_TENDRILS_PLANT, "Sculk Tendrils Plant");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_TENDRILS, "Sculk Tendrils");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_VINES_PLANT, "Sculk Vines Plant");
        translationBuilder.add(DeeperDarkerBlocks.SCULK_VINES, "Sculk Vines");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMY_CACTUS, "Gloomy Cactus");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMY_GRASS, "Gloomy Grass");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMY_SCULK, "Gloomy Sculk");
        translationBuilder.add(DeeperDarkerBlocks.GLOOMY_GEYSER, "Gloomy Geyser");
    }
}