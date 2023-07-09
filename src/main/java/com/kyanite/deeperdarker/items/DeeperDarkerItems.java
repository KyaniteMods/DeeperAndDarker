package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

import java.util.List;

import static com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks.ECHO_LOG;

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

        ECHO_LOG = registerItem("echo_log", new BlockItem(DeeperDarkerBlocks.ECHO_LOG, new Item.Settings()));
        ECHO_WOOD = registerItem("echo_wood", new BlockItem(DeeperDarkerBlocks.ECHO_WOOD, new Item.Settings()));
        STRIPPED_ECHO_LOG = registerItem("stripped_echo_log", new BlockItem(DeeperDarkerBlocks.STRIPPED_ECHO_LOG, new Item.Settings()));
        STRIPPED_ECHO_WOOD = registerItem("stripped_echo_wood", new BlockItem(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD, new Item.Settings()));
        ECHO_BUTTON = registerItem("echo_button", new BlockItem(DeeperDarkerBlocks.ECHO_BUTTON, new Item.Settings()));
        ECHO_DOOR = registerItem("echo_door", new TallBlockItem(DeeperDarkerBlocks.ECHO_DOOR, new Item.Settings()));
        ECHO_FENCE_GATE = registerItem("echo_fence_gate", new BlockItem(DeeperDarkerBlocks.ECHO_FENCE_GATE, new Item.Settings()));
        ECHO_FENCE = registerItem("echo_fence", new BlockItem(DeeperDarkerBlocks.ECHO_FENCE, new Item.Settings()));
        ECHO_HANGING_SIGN = registerItem("echo_hanging_sign", new HangingSignItem(DeeperDarkerBlocks.ECHO_HANGING_SIGN, DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN, new Item.Settings()));
        ECHO_LEAVES = registerItem("echo_leaves", new BlockItem(DeeperDarkerBlocks.ECHO_LEAVES, new Item.Settings()));
        ECHO_PLANKS = registerItem("echo_planks", new BlockItem(DeeperDarkerBlocks.ECHO_PLANKS, new Item.Settings()));
        ECHO_PRESSURE_PLATE = registerItem("echo_pressure_plate", new BlockItem(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE, new Item.Settings()));
        ECHO_SAPLING = registerItem("echo_sapling", new BlockItem(DeeperDarkerBlocks.ECHO_SAPLING, new Item.Settings()));
        ECHO_SIGN = registerItem("echo_sign", new SignItem(new Item.Settings(), DeeperDarkerBlocks.ECHO_SIGN, DeeperDarkerBlocks.ECHO_WALL_SIGN));
        ECHO_SLAB = registerItem("echo_slab", new BlockItem(DeeperDarkerBlocks.ECHO_SLAB, new Item.Settings()));
        ECHO_STAIRS = registerItem("echo_stairs", new BlockItem(DeeperDarkerBlocks.ECHO_STAIRS, new Item.Settings()));
        ECHO_TRAPDOOR = registerItem("echo_trapdoor", new BlockItem(DeeperDarkerBlocks.ECHO_TRAPDOOR, new Item.Settings()));
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
