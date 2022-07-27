package com.nitro.deeperdarker.core.registry.items;

import com.mojang.datafixers.util.Pair;
import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.nitro.deeperdarker.core.registry.blocks.DDBlocks;
import com.nitro.deeperdarker.core.registry.misc.DDCreativeModeTab;
import com.nitro.deeperdarker.core.registry.properties.DDArmorMaterials;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDItems {
    private static final ItemSubRegistryHelper HELPER = DeeperAndDarker.REGISTRY_HELPER.getItemSubHelper();
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MODID);

    // Boats
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> BONE_BOAT = HELPER.createBoatAndChestBoatItem("bone", DDBlocks.BONE_PLANKS);
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> SCULK_BONE_BOAT = HELPER.createBoatAndChestBoatItem("sculk_bone", DDBlocks.SCULK_BONE_PLANKS);

    // Warden Carapace and armor
    public static final RegistryObject<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().fireResistant().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.HEAD, new Item.Properties().fireResistant().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.CHEST, new Item.Properties().fireResistant().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.LEGS, new Item.Properties().fireResistant().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots", () -> new ArmorItem(DDArmorMaterials.WARDEN_CARAPACE, EquipmentSlot.FEET, new Item.Properties().fireResistant().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC)));

    // Sculk Reactor Core


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
