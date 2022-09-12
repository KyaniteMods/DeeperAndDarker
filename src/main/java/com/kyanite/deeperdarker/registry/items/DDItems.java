package com.kyanite.deeperdarker.registry.items;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDArmorMaterials;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDTiers;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.BoatEntity;
import com.kyanite.deeperdarker.registry.items.custom.DDBoatItem;
import com.kyanite.deeperdarker.registry.items.custom.DeepHeartItem;
import com.kyanite.deeperdarker.registry.items.custom.SculkTransmitterItem;
import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<Item> BLOOM_BERRIES = ITEMS.register("bloom_berries", () -> new Item(new Item.Properties().food(Foods.GLOW_BERRIES).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> HEART_OF_THE_DEEP = ITEMS.register("heart_of_the_deep", () -> new DeepHeartItem(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> REINFORCED_ECHO_SHARD = ITEMS.register("reinforced_echo_shard", () -> new Item(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> SOUL_DUST = ITEMS.register("soul_dust", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> SCULK_TRANSMITTER = ITEMS.register("sculk_transmitter", () -> new SculkTransmitterItem(new Item.Properties().fireResistant().rarity(Rarity.RARE).stacksTo(1).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<Item> WARDEN_SWORD = ITEMS.register("warden_sword", () -> new SwordItem(DDTiers.WARDEN, 3, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_SHOVEL = ITEMS.register("warden_shovel", () -> new ShovelItem(DDTiers.WARDEN, 1.5F, -3.0F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_PICKAXE = ITEMS.register("warden_pickaxe", () -> new PickaxeItem(DDTiers.WARDEN, 1, -2.8F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_AXE = ITEMS.register("warden_axe", () -> new AxeItem(DDTiers.WARDEN, 5F, -3.5F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_HOE = ITEMS.register("warden_hoe", () -> new HoeItem(DDTiers.WARDEN, -4, 0, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<SpawnEggItem> CENTIPEDE_SPAWN_EGG = ITEMS.register("sculk_centipede_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.CENTIPEDE, 0x1a2340, 0xded697, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SCULK_LEECH_SPAWN_EGG = ITEMS.register("sculk_leech_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SCULK_LEECH, 0x152B38, 0x00FAFF, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SCULK_SNAPPER_SPAWN_EGG = ITEMS.register("sculk_snapper_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SCULK_SNAPPER, 0xD1D6B6, 0x1D726F, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SHATTERED_SPAWN_EGG = ITEMS.register("shattered_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SHATTERED, 0x0d1217, 0xD1D6B6, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SHRIEK_WORM_SPAWN_EGG = ITEMS.register("shriek_worm_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SHRIEK_WORM, 0x204C61, 0xF1F7D0, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> STALKER_SPAWN_EGG = ITEMS.register("stalker_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.STALKER, 0x172226 , 0x6abdd9, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<Item> ECHO_SIGN = ITEMS.register("echo_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB), DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get()));
    public static final RegistryObject<Item> ECHO_BOAT = ITEMS.register("echo_boat", () -> new DDBoatItem(false, BoatEntity.Type.ECHO, new Item.Properties().stacksTo(1).fireResistant().tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> ECHO_CHEST_BOAT = ITEMS.register("echo_chest_boat", () -> new DDBoatItem(true, BoatEntity.Type.ECHO, new Item.Properties().stacksTo(1).fireResistant().tab(DDCreativeModeTab.DD_TAB)));
}
