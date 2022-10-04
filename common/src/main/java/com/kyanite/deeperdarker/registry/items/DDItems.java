package com.kyanite.deeperdarker.registry.items;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDArmorMaterials;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDTiers;
import com.kyanite.deeperdarker.platform.PortalHelper;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.DDBoat;
import com.kyanite.deeperdarker.registry.items.custom.CustomHoeItem;
import com.kyanite.deeperdarker.registry.items.custom.DDBoatItem;
import com.kyanite.deeperdarker.registry.items.custom.SculkTransmitterItem;
import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

import static com.kyanite.deeperdarker.platform.RegistryHelper.registerItem;

public class DDItems {

    public static final Supplier<Item> HEART_OF_THE_DEEP = registerItem("heart_of_the_deep", PortalHelper.getHeartItem());
    public static final Supplier<Item> REINFORCED_ECHO_SHARD = registerItem("reinforced_echo_shard", () -> new Item(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> WARDEN_CARAPACE = registerItem("warden_carapace", () -> new Item(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> SOUL_DUST = registerItem("soul_dust", () -> new Item(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> SCULK_TRANSMITTER = registerItem("sculk_transmitter", () -> new SculkTransmitterItem(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final Supplier<Item> WARDEN_HELMET = registerItem("warden_helmet", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> WARDEN_CHESTPLATE = registerItem("warden_chestplate", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> WARDEN_LEGGINGS = registerItem("warden_leggings", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> WARDEN_BOOTS = registerItem("warden_boots", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> SHATTERED_SPAWN_EGG = registerItem("shattered_spawn_egg", () -> new SpawnEggItem(DDEntities.SHATTERED.get(), 0x0d1217, 0xD1D6B6, new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> SCULK_LEECH_SPAWN_EGG = registerItem("sculk_leech_spawn_egg", () -> new SpawnEggItem(DDEntities.SCULK_LEECH.get(), 0x152B38, 0x00FAFF, new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> SCULK_SNAPPER_SPAWN_EGG = registerItem("sculk_snapper_spawn_egg", () -> new SpawnEggItem(DDEntities.SCULK_SNAPPER.get(), 0xD1D6B6, 0x1D726F, new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> SHRIEK_WORM_SPAWN_EGG = registerItem("shriek_worm_spawn_egg", () -> new SpawnEggItem(DDEntities.SCULK_WORM.get(), 0x204C61, 0xF1F7D0, new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> SCULK_CENTIPEDE_SPAWN_EGG = registerItem("sculk_centipede_spawn_egg", () -> new SpawnEggItem(DDEntities.SCULK_CENTIPEDE.get(), 0x1a2340, 0xded697, new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> STALKER_SPAWN_EGG = registerItem("stalker_spawn_egg", () -> new SpawnEggItem(DDEntities.STALKER.get(), 0x172226 , 0x6abdd9, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> GLOOM_GLARE_SPAWN_EGG = registerItem("gloom_glare_spawn_egg", () -> new SpawnEggItem(DDEntities.GLOOM_GLARE.get(), 0xfd9d22, 0xe35909, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> ECHO_BOAT = registerItem("echo_boat", () -> new DDBoatItem(false, DDBoat.Type.ECHO, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> ECHO_CHEST_BOAT = registerItem("echo_chest_boat", () -> new DDBoatItem(true, DDBoat.Type.ECHO, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> WARDEN_SWORD = registerItem("warden_sword", () -> new SwordItem(DDTiers.WARDEN, 2, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> WARDEN_SHOVEL = registerItem("warden_shovel", () -> new ShovelItem(DDTiers.WARDEN, 1.2F, -3.0F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> WARDEN_PICKAXE = registerItem("warden_pickaxe", () -> new PickaxeItem(DDTiers.WARDEN, 1, -2.8F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> WARDEN_AXE = registerItem("warden_axe", () -> new AxeItem(DDTiers.WARDEN, 3.5F, -3.0F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> WARDEN_HOE = registerItem("warden_hoe", () -> new CustomHoeItem(DDTiers.WARDEN, -4, 0, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));

    public static void registerItems() {
        DeeperAndDarker.LOGGER.info("Deeper And Darker items have been registered");
    }
}
