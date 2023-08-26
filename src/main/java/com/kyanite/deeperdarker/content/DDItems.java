package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.*;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DDTiers;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class DDItems {
    public static final Item GRIME_BALL = register("grime_ball", new Item(new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item GRIME_BRICK = register("grime_brick", new Item(new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));

    public static final Item SOUL_ELYTRA = register("soul_elytra", new SoulElytraItem(new FabricItemSettings().equipmentSlot((slot) -> EquipmentSlot.CHEST).durability(956).rarity(Rarity.UNCOMMON).tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item ECHO_BOAT = register("echo_boat", new DDBoatItem(false, new Item.Properties().stacksTo(1).tab(DDCreativeTab.DEEPER_AND_DARKER), DDBlocks.ECHO));
    public static final Item ECHO_CHEST_BOAT = register("echo_chest_boat", new DDBoatItem(true, new Item.Properties().stacksTo(1).tab(DDCreativeTab.DEEPER_AND_DARKER), DDBlocks.ECHO));

    public static final Item SCULK_BONE = register("sculk_bone", new Item(new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item SOUL_DUST = register("soul_dust", new Item(new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item SOUL_CRYSTAL = register("soul_crystal", new Item(new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item HEART_OF_THE_DEEP = register("heart_of_the_deep", new HeartOfTheDeepItem(new Item.Properties().rarity(Rarity.EPIC).fireResistant().stacksTo(1).tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_CARAPACE = register("warden_carapace", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item REINFORCED_ECHO_SHARD = register("reinforced_echo_shard", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));

    public static final Item WARDEN_SHOVEL = register("warden_shovel", new ShovelItem(DDTiers.WARDEN, 1.5f, -3, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_PICKAXE = register("warden_pickaxe", new PickaxeItem(DDTiers.WARDEN, 1, -2.8f, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_AXE = register("warden_axe", new AxeItem(DDTiers.WARDEN, 5, -3, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_HOE = register("warden_hoe", new DDHoeItem(DDTiers.WARDEN, -4, 0, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_SWORD = register("warden_sword", new SwordItem(DDTiers.WARDEN, 3, -2.4f, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_HELMET = register("warden_helmet", new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_CHESTPLATE = register("warden_chestplate", new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_LEGGINGS = register("warden_leggings", new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item WARDEN_BOOTS = register("warden_boots", new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().rarity(Rarity.RARE).fireResistant().tab(DDCreativeTab.DEEPER_AND_DARKER)));

    public static final Item SCULK_TRANSMITTER = register("sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(DDCreativeTab.DEEPER_AND_DARKER)));

    public static final Item SCULK_CENTIPEDE_SPAWN_EGG = register("sculk_centipede_spawn_egg", new SpawnEggItem(DDEntities.SCULK_CENTIPEDE, 0x1a2340, 0xded697, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item SCULK_LEECH_SPAWN_EGG = register("sculk_leech_spawn_egg", new SpawnEggItem(DDEntities.SCULK_LEECH, 0x152b38, 0x47e5ed, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item SCULK_SNAPPER_SPAWN_EGG = register("sculk_snapper_spawn_egg", new SpawnEggItem(DDEntities.SCULK_SNAPPER, 0xd1d6b6, 0x1d726f, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item SHATTERED_SPAWN_EGG = register("shattered_spawn_egg", new SpawnEggItem(DDEntities.SHATTERED, 0x0e181d, 0x819699, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item SHRIEK_WORM_SPAWN_EGG = register("shriek_worm_spawn_egg", new SpawnEggItem(DDEntities.SHRIEK_WORM, 0xd1d6b6, 0x009295, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
    public static final Item STALKER_SPAWN_EGG = register("stalker_spawn_egg", new SpawnEggItem(DDEntities.STALKER, 0x172226, 0x6abdd9, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));

    public static final Item ECHO_SIGN = register("echo_sign", new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeTab.DEEPER_AND_DARKER), DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN));

    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, id), item);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering items");
    }
}
