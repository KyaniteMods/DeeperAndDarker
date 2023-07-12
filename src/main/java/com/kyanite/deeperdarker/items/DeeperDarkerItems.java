package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

import java.util.List;

public class DeeperDarkerItems {
    public static final Item WARDEN_HELMET;
    public static final Item WARDEN_CHESTPLATE;
    public static final Item WARDEN_LEGGINGS;
    public static final Item WARDEN_BOOTS;
    public static final Item WARDEN_SWORD;
    public static final Item WARDEN_PICKAXE;
    public static final Item WARDEN_AXE;
    public static final Item WARDEN_SHOVEL;
    public static final Item WARDEN_HOE;
    public static final Item WARDEN_UPGRADE_SMITHING_TEMPLATE;
    public static final Item REINFORCED_ECHO_SHARD;
    public static final Item WARDEN_CARAPACE;
    public static final Item HEART_OF_THE_DEEP;
    public static final Item SOUL_CRYSTAL;
    public static final Item SOUL_DUST;
    public static final Item SCULK_BONE;
    public static final Item ECHO_LOG;
    public static final Item ECHO_WOOD;
    public static final Item STRIPPED_ECHO_LOG;
    public static final Item STRIPPED_ECHO_WOOD;
    public static final Item ECHO_BUTTON;
    public static final Item ECHO_DOOR;
    public static final Item ECHO_FENCE_GATE;
    public static final Item ECHO_FENCE;
    public static final Item ECHO_HANGING_SIGN;
    public static final Item ECHO_LEAVES;
    public static final Item ECHO_PLANKS;
    public static final Item ECHO_PRESSURE_PLATE;
    public static final Item ECHO_SAPLING;
    public static final Item ECHO_SIGN;
    public static final Item ECHO_SLAB;
    public static final Item ECHO_STAIRS;
    public static final Item ECHO_TRAPDOOR;
    public static final Item SCULK_STONE;
    public static final Item SCULK_STONE_STAIRS;
    public static final Item SCULK_STONE_SLAB;
    public static final Item SCULK_STONE_WALL;
    public static final Item COBBLED_SCULK_STONE;
    public static final Item COBBLED_SCULK_STONE_STAIRS;
    public static final Item COBBLED_SCULK_STONE_SLAB;
    public static final Item COBBLED_SCULK_STONE_WALL;
    public static final Item POLISHED_SCULK_STONE;
    public static final Item POLISHED_SCULK_STONE_STAIRS;
    public static final Item POLISHED_SCULK_STONE_SLAB;
    public static final Item POLISHED_SCULK_STONE_WALL;
    public static final Item SCULK_STONE_BRICKS;
    public static final Item SCULK_STONE_BRICK_STAIRS;
    public static final Item SCULK_STONE_BRICK_SLAB;
    public static final Item SCULK_STONE_BRICK_WALL;
    public static final Item SCULK_STONE_TILES;
    public static final Item SCULK_STONE_TILE_STAIRS;
    public static final Item SCULK_STONE_TILE_SLAB;
    public static final Item SCULK_STONE_TILE_WALL;
    public static final Item SMOOTH_SCULK_STONE;
    public static final Item SMOOTH_SCULK_STONE_STAIRS;
    public static final Item SMOOTH_SCULK_STONE_SLAB;
    public static final Item SMOOTH_SCULK_STONE_WALL;
    public static final Item CUT_SCULK_STONE;
    public static final Item CUT_SCULK_STONE_STAIRS;
    public static final Item CUT_SCULK_STONE_SLAB;
    public static final Item CUT_SCULK_STONE_WALL;
    public static final Item CHISELED_SCULK_STONE;
    public static final Item SCULK_GRIME;
    public static final Item SCULK_GRIME_BRICKS;
    public static final Item SCULK_GRIME_BRICK_STAIRS;
    public static final Item SCULK_GRIME_BRICK_SLAB;
    public static final Item SCULK_GRIME_BRICK_WALL;
    public static final Item GLOOMSLATE;
    public static final Item GLOOMSLATE_STAIRS;
    public static final Item GLOOMSLATE_SLAB;
    public static final Item GLOOMSLATE_WALL;
    public static final Item COBBLED_GLOOMSLATE;
    public static final Item COBBLED_GLOOMSLATE_STAIRS;
    public static final Item COBBLED_GLOOMSLATE_SLAB;
    public static final Item COBBLED_GLOOMSLATE_WALL;
    public static final Item POLISHED_GLOOMSLATE;
    public static final Item POLISHED_GLOOMSLATE_STAIRS;
    public static final Item POLISHED_GLOOMSLATE_SLAB;
    public static final Item POLISHED_GLOOMSLATE_WALL;
    public static final Item GLOOMSLATE_BRICKS;
    public static final Item GLOOMSLATE_BRICK_STAIRS;
    public static final Item GLOOMSLATE_BRICK_SLAB;
    public static final Item GLOOMSLATE_BRICK_WALL;
    public static final Item GLOOMSLATE_TILES;
    public static final Item GLOOMSLATE_TILE_STAIRS;
    public static final Item GLOOMSLATE_TILE_SLAB;
    public static final Item GLOOMSLATE_TILE_WALL;
    public static final Item SMOOTH_GLOOMSLATE;
    public static final Item SMOOTH_GLOOMSLATE_STAIRS;
    public static final Item SMOOTH_GLOOMSLATE_SLAB;
    public static final Item SMOOTH_GLOOMSLATE_WALL;
    public static final Item CUT_GLOOMSLATE;
    public static final Item CUT_GLOOMSLATE_STAIRS;
    public static final Item CUT_GLOOMSLATE_SLAB;
    public static final Item CUT_GLOOMSLATE_WALL;
    public static final Item CHISELED_GLOOMSLATE;
    public static final Item ECHO_SOIL;
    public static final Item SCULK_GLEAM;
    public static final Item SCULK_STONE_COAL_ORE;
    public static final Item SCULK_STONE_IRON_ORE;
    public static final Item SCULK_STONE_COPPER_ORE;
    public static final Item SCULK_STONE_GOLD_ORE;
    public static final Item SCULK_STONE_REDSTONE_ORE;
    public static final Item SCULK_STONE_EMERALD_ORE;
    public static final Item SCULK_STONE_LAPIS_ORE;
    public static final Item SCULK_STONE_DIAMOND_ORE;
    public static final Item GRIME_BALL;
    public static final Item GRIME_BRICK;
    public static final Item SCULK_TENDRILS;
    public static final Item SCULK_VINES;
    public static final Item GLOOMY_CACTUS;
    public static final Item GLOOMY_GRASS;
    public static final Item GLOOMY_SCULK;
    public static final Item GLOOMY_GEYSER;
    public static final Item ECHO_BOAT;
    public static final Item ECHO_CHEST_BOAT;
    public static final Item ANCIENT_VASE;
    public static final Item CRYSTALLIZED_AMBER;
    private static final ArmorMaterial WARDEN_ARMOR_MATERIAL = new WardenArmorMaterial();
    private static final ToolMaterial WARDEN_TOOL_MATERIAL = new WardenToolMaterial();

    static {
        WARDEN_HELMET = registerItem("warden_helmet", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_CHESTPLATE = registerItem("warden_chestplate", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_LEGGINGS = registerItem("warden_leggings", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_BOOTS = registerItem("warden_boots", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_SWORD = registerItem("warden_sword", new SwordItem(WARDEN_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_PICKAXE = registerItem("warden_pickaxe", new PickaxeItem(WARDEN_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_AXE = registerItem("warden_axe", new AxeItem(WARDEN_TOOL_MATERIAL, 5, -3.0f, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_SHOVEL = registerItem("warden_shovel", new ShovelItem(WARDEN_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_HOE = registerItem("warden_hoe", new HoeItem(WARDEN_TOOL_MATERIAL, -7, -2.4f, new Item.Settings().rarity(Rarity.RARE).fireproof()));
        WARDEN_UPGRADE_SMITHING_TEMPLATE = registerItem("warden_upgrade_smithing_template", createWardenUpgradeSmithingTemplate());

        REINFORCED_ECHO_SHARD = registerItem("reinforced_echo_shard", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
        WARDEN_CARAPACE = registerItem("warden_carapace", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
        HEART_OF_THE_DEEP = registerItem("heart_of_the_deep", new Item(new Item.Settings().fireproof().rarity(Rarity.EPIC)));
        SOUL_CRYSTAL = registerItem("soul_crystal", new Item(new Item.Settings().rarity(Rarity.RARE)));
        SOUL_DUST = registerItem("soul_dust", new Item(new Item.Settings().rarity(Rarity.RARE)));
        SCULK_BONE = registerItem("sculk_bone", new Item(new Item.Settings().fireproof().rarity(Rarity.EPIC)));
        GRIME_BALL = registerItem("grime_ball", new Item(new Item.Settings()));
        GRIME_BRICK = registerItem("grime_brick", new Item(new Item.Settings()));

        ECHO_LOG = registerItem("echo_log", new BlockItem(DeeperDarkerBlocks.ECHO_LOG, new Item.Settings()));
        ECHO_WOOD = registerItem("echo_wood", new BlockItem(DeeperDarkerBlocks.ECHO_WOOD, new Item.Settings()));
        STRIPPED_ECHO_LOG = registerItem("stripped_echo_log", new BlockItem(DeeperDarkerBlocks.STRIPPED_ECHO_LOG, new Item.Settings()));
        STRIPPED_ECHO_WOOD = registerItem("stripped_echo_wood", new BlockItem(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD, new Item.Settings()));
        ECHO_BUTTON = registerItem("echo_button", new BlockItem(DeeperDarkerBlocks.ECHO_BUTTON, new Item.Settings()));
        ECHO_DOOR = registerItem("echo_door", new TallBlockItem(DeeperDarkerBlocks.ECHO_DOOR, new Item.Settings()));
        ECHO_FENCE_GATE = registerItem("echo_fence_gate", new BlockItem(DeeperDarkerBlocks.ECHO_FENCE_GATE, new Item.Settings()));
        ECHO_FENCE = registerItem("echo_fence", new BlockItem(DeeperDarkerBlocks.ECHO_FENCE, new Item.Settings()));
        ECHO_HANGING_SIGN = registerItem("echo_hanging_sign", new HangingSignItem(DeeperDarkerBlocks.ECHO_HANGING_SIGN, DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
        ECHO_LEAVES = registerItem("echo_leaves", new BlockItem(DeeperDarkerBlocks.ECHO_LEAVES, new Item.Settings()));
        ECHO_PLANKS = registerItem("echo_planks", new BlockItem(DeeperDarkerBlocks.ECHO_PLANKS, new Item.Settings()));
        ECHO_PRESSURE_PLATE = registerItem("echo_pressure_plate", new BlockItem(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE, new Item.Settings()));
        ECHO_SAPLING = registerItem("echo_sapling", new BlockItem(DeeperDarkerBlocks.ECHO_SAPLING, new Item.Settings()));
        ECHO_SIGN = registerItem("echo_sign", new SignItem(new Item.Settings().maxCount(16), DeeperDarkerBlocks.ECHO_SIGN, DeeperDarkerBlocks.ECHO_WALL_SIGN));
        ECHO_SLAB = registerItem("echo_slab", new BlockItem(DeeperDarkerBlocks.ECHO_SLAB, new Item.Settings()));
        ECHO_STAIRS = registerItem("echo_stairs", new BlockItem(DeeperDarkerBlocks.ECHO_STAIRS, new Item.Settings()));
        ECHO_TRAPDOOR = registerItem("echo_trapdoor", new BlockItem(DeeperDarkerBlocks.ECHO_TRAPDOOR, new Item.Settings()));
        SCULK_STONE = registerItem("sculk_stone", new BlockItem(DeeperDarkerBlocks.SCULK_STONE, new Item.Settings()));
        SCULK_STONE_STAIRS = registerItem("sculk_stone_stairs", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_STAIRS, new Item.Settings()));
        SCULK_STONE_SLAB = registerItem("sculk_stone_slab", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_SLAB, new Item.Settings()));
        SCULK_STONE_WALL = registerItem("sculk_stone_wall", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_WALL, new Item.Settings()));
        COBBLED_SCULK_STONE = registerItem("cobbled_sculk_stone", new BlockItem(DeeperDarkerBlocks.COBBLED_SCULK_STONE, new Item.Settings()));
        COBBLED_SCULK_STONE_STAIRS = registerItem("cobbled_sculk_stone_stairs", new BlockItem(DeeperDarkerBlocks.COBBLED_SCULK_STONE_STAIRS, new Item.Settings()));
        COBBLED_SCULK_STONE_SLAB = registerItem("cobbled_sculk_stone_slab", new BlockItem(DeeperDarkerBlocks.COBBLED_SCULK_STONE_SLAB, new Item.Settings()));
        COBBLED_SCULK_STONE_WALL = registerItem("cobbled_sculk_stone_wall", new BlockItem(DeeperDarkerBlocks.COBBLED_SCULK_STONE_WALL, new Item.Settings()));
        POLISHED_SCULK_STONE = registerItem("polished_sculk_stone", new BlockItem(DeeperDarkerBlocks.POLISHED_SCULK_STONE, new Item.Settings()));
        POLISHED_SCULK_STONE_STAIRS = registerItem("polished_sculk_stone_stairs", new BlockItem(DeeperDarkerBlocks.POLISHED_SCULK_STONE_STAIRS, new Item.Settings()));
        POLISHED_SCULK_STONE_SLAB = registerItem("polished_sculk_stone_slab", new BlockItem(DeeperDarkerBlocks.POLISHED_SCULK_STONE_SLAB, new Item.Settings()));
        POLISHED_SCULK_STONE_WALL = registerItem("polished_sculk_stone_wall", new BlockItem(DeeperDarkerBlocks.POLISHED_SCULK_STONE_WALL, new Item.Settings()));
        SCULK_STONE_BRICKS = registerItem("sculk_stone_bricks", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_BRICKS, new Item.Settings()));
        SCULK_STONE_BRICK_STAIRS = registerItem("sculk_stone_brick_stairs", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_BRICK_STAIRS, new Item.Settings()));
        SCULK_STONE_BRICK_SLAB = registerItem("sculk_stone_brick_slab", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_BRICK_SLAB, new Item.Settings()));
        SCULK_STONE_BRICK_WALL = registerItem("sculk_stone_brick_wall", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_BRICK_WALL, new Item.Settings()));
        SCULK_STONE_TILES = registerItem("sculk_stone_tiles", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_TILES, new Item.Settings()));
        SCULK_STONE_TILE_STAIRS = registerItem("sculk_stone_tile_stairs", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_TILE_STAIRS, new Item.Settings()));
        SCULK_STONE_TILE_SLAB = registerItem("sculk_stone_tile_slab", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_TILE_SLAB, new Item.Settings()));
        SCULK_STONE_TILE_WALL = registerItem("sculk_stone_tile_wall", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_TILE_WALL, new Item.Settings()));
        SMOOTH_SCULK_STONE = registerItem("smooth_sculk_stone", new BlockItem(DeeperDarkerBlocks.SMOOTH_SCULK_STONE, new Item.Settings()));
        SMOOTH_SCULK_STONE_STAIRS = registerItem("smooth_sculk_stone_stairs", new BlockItem(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_STAIRS, new Item.Settings()));
        SMOOTH_SCULK_STONE_SLAB = registerItem("smooth_sculk_stone_slab", new BlockItem(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_SLAB, new Item.Settings()));
        SMOOTH_SCULK_STONE_WALL = registerItem("smooth_sculk_stone_wall", new BlockItem(DeeperDarkerBlocks.SMOOTH_SCULK_STONE_WALL, new Item.Settings()));
        CUT_SCULK_STONE = registerItem("cut_sculk_stone", new BlockItem(DeeperDarkerBlocks.CUT_SCULK_STONE, new Item.Settings()));
        CUT_SCULK_STONE_STAIRS = registerItem("cut_sculk_stone_stairs", new BlockItem(DeeperDarkerBlocks.CUT_SCULK_STONE_STAIRS, new Item.Settings()));
        CUT_SCULK_STONE_SLAB = registerItem("cut_sculk_stone_slab", new BlockItem(DeeperDarkerBlocks.CUT_SCULK_STONE_SLAB, new Item.Settings()));
        CUT_SCULK_STONE_WALL = registerItem("cut_sculk_stone_wall", new BlockItem(DeeperDarkerBlocks.CUT_SCULK_STONE_WALL, new Item.Settings()));
        CHISELED_SCULK_STONE = registerItem("chiseled_sculk_stone", new BlockItem(DeeperDarkerBlocks.CHISELED_SCULK_STONE, new Item.Settings()));
        SCULK_GRIME = registerItem("sculk_grime", new BlockItem(DeeperDarkerBlocks.SCULK_GRIME, new Item.Settings()));
        SCULK_GRIME_BRICKS = registerItem("sculk_grime_bricks", new BlockItem(DeeperDarkerBlocks.SCULK_GRIME_BRICKS, new Item.Settings()));
        SCULK_GRIME_BRICK_STAIRS = registerItem("sculk_grime_brick_stairs", new BlockItem(DeeperDarkerBlocks.SCULK_GRIME_BRICK_STAIRS, new Item.Settings()));
        SCULK_GRIME_BRICK_SLAB = registerItem("sculk_grime_brick_slab", new BlockItem(DeeperDarkerBlocks.SCULK_GRIME_BRICK_SLAB, new Item.Settings()));
        SCULK_GRIME_BRICK_WALL = registerItem("sculk_grime_brick_wall", new BlockItem(DeeperDarkerBlocks.SCULK_GRIME_BRICK_WALL, new Item.Settings()));
        GLOOMSLATE = registerItem("gloomslate", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE, new Item.Settings()));
        GLOOMSLATE_STAIRS = registerItem("gloomslate_stairs", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_STAIRS, new Item.Settings()));
        GLOOMSLATE_SLAB = registerItem("gloomslate_slab", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_SLAB, new Item.Settings()));
        GLOOMSLATE_WALL = registerItem("gloomslate_wall", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_WALL, new Item.Settings()));
        COBBLED_GLOOMSLATE = registerItem("cobbled_gloomslate", new BlockItem(DeeperDarkerBlocks.COBBLED_GLOOMSLATE, new Item.Settings()));
        COBBLED_GLOOMSLATE_STAIRS = registerItem("cobbled_gloomslate_stairs", new BlockItem(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_STAIRS, new Item.Settings()));
        COBBLED_GLOOMSLATE_SLAB = registerItem("cobbled_gloomslate_slab", new BlockItem(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_SLAB, new Item.Settings()));
        COBBLED_GLOOMSLATE_WALL = registerItem("cobbled_gloomslate_wall", new BlockItem(DeeperDarkerBlocks.COBBLED_GLOOMSLATE_WALL, new Item.Settings()));
        POLISHED_GLOOMSLATE = registerItem("polished_gloomslate", new BlockItem(DeeperDarkerBlocks.POLISHED_GLOOMSLATE, new Item.Settings()));
        POLISHED_GLOOMSLATE_STAIRS = registerItem("polished_gloomslate_stairs", new BlockItem(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_STAIRS, new Item.Settings()));
        POLISHED_GLOOMSLATE_SLAB = registerItem("polished_gloomslate_slab", new BlockItem(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_SLAB, new Item.Settings()));
        POLISHED_GLOOMSLATE_WALL = registerItem("polished_gloomslate_wall", new BlockItem(DeeperDarkerBlocks.POLISHED_GLOOMSLATE_WALL, new Item.Settings()));
        GLOOMSLATE_BRICKS = registerItem("gloomslate_bricks", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_BRICKS, new Item.Settings()));
        GLOOMSLATE_BRICK_STAIRS = registerItem("gloomslate_brick_stairs", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_BRICK_STAIRS, new Item.Settings()));
        GLOOMSLATE_BRICK_SLAB = registerItem("gloomslate_brick_slab", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_BRICK_SLAB, new Item.Settings()));
        GLOOMSLATE_BRICK_WALL = registerItem("gloomslate_brick_wall", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_BRICK_WALL, new Item.Settings()));
        GLOOMSLATE_TILES = registerItem("gloomslate_tiles", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_TILES, new Item.Settings()));
        GLOOMSLATE_TILE_STAIRS = registerItem("gloomslate_tile_stairs", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_TILE_STAIRS, new Item.Settings()));
        GLOOMSLATE_TILE_SLAB = registerItem("gloomslate_tile_slab", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_TILE_SLAB, new Item.Settings()));
        GLOOMSLATE_TILE_WALL = registerItem("gloomslate_tile_wall", new BlockItem(DeeperDarkerBlocks.GLOOMSLATE_TILE_WALL, new Item.Settings()));
        SMOOTH_GLOOMSLATE = registerItem("smooth_gloomslate", new BlockItem(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE, new Item.Settings()));
        SMOOTH_GLOOMSLATE_STAIRS = registerItem("smooth_gloomslate_stairs", new BlockItem(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_STAIRS, new Item.Settings()));
        SMOOTH_GLOOMSLATE_SLAB = registerItem("smooth_gloomslate_slab", new BlockItem(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_SLAB, new Item.Settings()));
        SMOOTH_GLOOMSLATE_WALL = registerItem("smooth_gloomslate_wall", new BlockItem(DeeperDarkerBlocks.SMOOTH_GLOOMSLATE_WALL, new Item.Settings()));
        CUT_GLOOMSLATE = registerItem("cut_gloomslate", new BlockItem(DeeperDarkerBlocks.CUT_GLOOMSLATE, new Item.Settings()));
        CUT_GLOOMSLATE_STAIRS = registerItem("cut_gloomslate_stairs", new BlockItem(DeeperDarkerBlocks.CUT_GLOOMSLATE_STAIRS, new Item.Settings()));
        CUT_GLOOMSLATE_SLAB = registerItem("cut_gloomslate_slab", new BlockItem(DeeperDarkerBlocks.CUT_GLOOMSLATE_SLAB, new Item.Settings()));
        CUT_GLOOMSLATE_WALL = registerItem("cut_gloomslate_wall", new BlockItem(DeeperDarkerBlocks.CUT_GLOOMSLATE_WALL, new Item.Settings()));
        CHISELED_GLOOMSLATE = registerItem("chiseled_gloomslate", new BlockItem(DeeperDarkerBlocks.CHISELED_GLOOMSLATE, new Item.Settings()));
        ECHO_SOIL = registerItem("echo_soil", new BlockItem(DeeperDarkerBlocks.ECHO_SOIL, new Item.Settings()));
        SCULK_GLEAM = registerItem("sculk_gleam", new BlockItem(DeeperDarkerBlocks.SCULK_GLEAM, new Item.Settings()));
        SCULK_STONE_COAL_ORE = registerItem("sculk_stone_coal_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_COAL_ORE, new Item.Settings()));
        SCULK_STONE_IRON_ORE = registerItem("sculk_stone_iron_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_IRON_ORE, new Item.Settings()));
        SCULK_STONE_COPPER_ORE = registerItem("sculk_stone_copper_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_COPPER_ORE, new Item.Settings()));
        SCULK_STONE_GOLD_ORE = registerItem("sculk_stone_gold_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_GOLD_ORE, new Item.Settings()));
        SCULK_STONE_REDSTONE_ORE = registerItem("sculk_stone_redstone_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_REDSTONE_ORE, new Item.Settings()));
        SCULK_STONE_EMERALD_ORE = registerItem("sculk_stone_emerald_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_EMERALD_ORE, new Item.Settings()));
        SCULK_STONE_LAPIS_ORE = registerItem("sculk_stone_lapis_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_LAPIS_ORE, new Item.Settings()));
        SCULK_STONE_DIAMOND_ORE = registerItem("sculk_stone_diamond_ore", new BlockItem(DeeperDarkerBlocks.SCULK_STONE_DIAMOND_ORE, new Item.Settings()));
        SCULK_TENDRILS = registerItem("sculk_tendrils", new BlockItem(DeeperDarkerBlocks.SCULK_TENDRILS, new Item.Settings()));
        SCULK_VINES = registerItem("sculk_vines", new BlockItem(DeeperDarkerBlocks.SCULK_VINES, new Item.Settings()));
        GLOOMY_CACTUS = registerItem("gloomy_cactus", new BlockItem(DeeperDarkerBlocks.GLOOMY_CACTUS, new Item.Settings()));
        GLOOMY_GRASS = registerItem("gloomy_grass", new BlockItem(DeeperDarkerBlocks.GLOOMY_GRASS, new Item.Settings()));
        GLOOMY_SCULK = registerItem("gloomy_sculk", new BlockItem(DeeperDarkerBlocks.GLOOMY_SCULK, new Item.Settings()));
        GLOOMY_GEYSER = registerItem("gloomy_geyser", new BlockItem(DeeperDarkerBlocks.GLOOMY_GEYSER, new Item.Settings()));
        ECHO_BOAT = registerItem("echo_boat", new DeeperDarkerBoatItem(false, DeeperDarkerBlocks.ECHO_WOOD_TYPE, new Item.Settings().maxCount(1)));
        ECHO_CHEST_BOAT = registerItem("echo_chest_boat", new DeeperDarkerBoatItem(true, DeeperDarkerBlocks.ECHO_WOOD_TYPE, new Item.Settings().maxCount(1)));
        ANCIENT_VASE = registerItem("ancient_vase", new BlockItem(DeeperDarkerBlocks.ANCIENT_VASE, new Item.Settings()));
        CRYSTALLIZED_AMBER = registerItem("crystallized_amber", new BlockItem(DeeperDarkerBlocks.CRYSTALLIZED_AMBER, new Item.Settings()));
    }

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DeeperDarker.MOD_ID, id), item);
    }

    private static Item createWardenUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(
                Text.translatable(Util.createTranslationKey("item", new Identifier(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.applies_to"))).formatted(Formatting.BLUE),
                Text.translatable(Util.createTranslationKey("item", new Identifier(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.ingredients"))).formatted(Formatting.BLUE),
                Text.translatable(Util.createTranslationKey("upgrade", new Identifier(DeeperDarker.MOD_ID, "warden_upgrade"))).formatted(Formatting.GRAY),
                Text.translatable(Util.createTranslationKey("item", new Identifier(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.base_slot_description"))),
                Text.translatable(Util.createTranslationKey("item", new Identifier(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.additions_slot_description"))),
                getWardenEmptyBaseSlotTextures(),
                getWardenEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getWardenEmptyBaseSlotTextures() {
        return List.of(new Identifier("item/empty_armor_slot_helmet"),
                new Identifier("item/empty_armor_slot_chestplate"),
                new Identifier("item/empty_armor_slot_leggings"),
                new Identifier("item/empty_armor_slot_boots"),
                new Identifier("item/empty_slot_sword"),
                new Identifier("item/empty_slot_pickaxe"),
                new Identifier("item/empty_slot_axe"),
                new Identifier("item/empty_slot_shovel"),
                new Identifier("item/empty_slot_hoe"));
    }

    private static List<Identifier> getWardenEmptyAdditionsSlotTextures() {
        return List.of(new Identifier(DeeperDarker.MOD_ID, "item/empty_slot_reinforced_echo_shard"));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker items");
    }
}