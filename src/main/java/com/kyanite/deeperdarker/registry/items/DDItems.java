package com.kyanite.deeperdarker.registry.items;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.custom.DeepHeartItem;
import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDCreativeModeTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<Item> BONE_SIGN = ITEMS.register("bone_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB), DDBlocks.BONE_SIGN.get(), DDBlocks.BONE_WALL_SIGN.get()));
    public static final RegistryObject<Item> SCULK_BONE_SIGN = ITEMS.register("sculk_bone_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB), DDBlocks.SCULK_BONE_SIGN.get(), DDBlocks.SCULK_BONE_WALL_SIGN.get()));

    public static final RegistryObject<Item> REINFORCED_ECHO_SHARD = ITEMS.register("reinforced_echo_shard", () -> new Item(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).fireResistant().stacksTo(3)));
    public static final RegistryObject<Item> HEART_OF_THE_DEEP = ITEMS.register("heart_of_the_deep", DeepHeartItem::new);
    public static final RegistryObject<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<Item> GLOOM_BERRIES = ITEMS.register("gloom_berries", () -> new ItemNameBlockItem(DDBlocks.GLOOM_VINES.get(), (new Item.Properties()).food(Foods.GLOW_BERRIES).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<SpawnEggItem> SHRIEK_WORM_SPAWN_EGG = ITEMS.register("shriek_worm_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SCULK_WORM, 0x204C61, 0xF1F7D0, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SCULK_SNAPPER_SPAWN_EGG = ITEMS.register("sculk_snapper_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SCULK_SNAPPER, 0xD1D6B6, 0x1D726F, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SCULK_LEECH_SPAWN_EGG = ITEMS.register("sculk_leech_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SCULK_LEECH, 0x152B38, 0x00FAFF, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<SpawnEggItem> SHATTERED_SPAWN_EGG = ITEMS.register("shattered_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SHATTERED, 0x0d1217, 0xD1D6B6, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
}
