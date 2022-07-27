package com.nitro.deeperdarker.registry.items;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.registry.properties.DDArmorMaterials;
import com.nitro.deeperdarker.util.DDCreativeModeTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MOD_ID);

    // Warden Carapace and armor
    public static final RegistryObject<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));

    // Sculk Reactor Core

}
