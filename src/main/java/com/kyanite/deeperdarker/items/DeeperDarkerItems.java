package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

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
    private static final ArmorMaterial WARDEN_ARMOR_MATERIAL = new WardenArmorMaterial();
    private static final ToolMaterial WARDEN_TOOL_MATERIAL = new WardenToolMaterial();

    static {
        WARDEN_HELMET = registerItem("warden_helmet", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()));
        WARDEN_CHESTPLATE = registerItem("warden_chestplate", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
        WARDEN_LEGGINGS = registerItem("warden_leggings", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()));
        WARDEN_BOOTS = registerItem("warden_boots", new ArmorItem(WARDEN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()));
        WARDEN_SWORD = registerItem("warden_sword", new SwordItem(WARDEN_TOOL_MATERIAL, 3, -2.4f, new Item.Settings()));
        WARDEN_PICKAXE = registerItem("warden_pickaxe", new PickaxeItem(WARDEN_TOOL_MATERIAL, 1, -2.8f, new Item.Settings()));
        WARDEN_AXE = registerItem("warden_axe", new AxeItem(WARDEN_TOOL_MATERIAL, 5, -3.0f, new Item.Settings()));
        WARDEN_SHOVEL = registerItem("warden_shovel", new ShovelItem(WARDEN_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings()));
        WARDEN_HOE = registerItem("warden_hoe", new HoeItem(WARDEN_TOOL_MATERIAL, -7, -2.4f, new Item.Settings()));
    }

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DeeperDarker.MOD_ID, id), item);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker items");
    }
}
