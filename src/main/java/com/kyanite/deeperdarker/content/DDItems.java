package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.*;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.List;

public class DDItems {
    public static final Item GRIME_BALL = register("grime_ball", new Item(new Item.Properties()));
    public static final Item GRIME_BRICK = register("grime_brick", new Item(new Item.Properties()));

    public static final Item SOUL_ELYTRA = register("soul_elytra", new SoulElytraItem(new Item.Properties().durability(956).rarity(Rarity.UNCOMMON)));
    public static final Item ECHO_BOAT = register("echo_boat", new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBlocks.ECHO));
    public static final Item ECHO_CHEST_BOAT = register("echo_chest_boat", new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBlocks.ECHO));

    public static final Item SCULK_BONE = register("sculk_bone", new Item(new Item.Properties()));
    public static final Item SOUL_DUST = register("soul_dust", new Item(new Item.Properties()));
    public static final Item SOUL_CRYSTAL = register("soul_crystal", new Item(new Item.Properties()));
    public static final Item HEART_OF_THE_DEEP = register("heart_of_the_deep", new HeartOfTheDeepItem(new Item.Properties().rarity(Rarity.EPIC).fireResistant().stacksTo(1)));
    public static final Item WARDEN_CARAPACE = register("warden_carapace", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item REINFORCED_ECHO_SHARD = register("reinforced_echo_shard", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_UPGRADE_SMITHING_TEMPLATE = register("warden_upgrade_smithing_template", createWardenUpgradeSmithingTemplate());

    public static final Item WARDEN_SHOVEL = register("warden_shovel", new ShovelItem(DDTiers.WARDEN, 1.5f, -3, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_PICKAXE = register("warden_pickaxe", new PickaxeItem(DDTiers.WARDEN, 1, -2.8f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_AXE = register("warden_axe", new AxeItem(DDTiers.WARDEN, 5, -3, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_HOE = register("warden_hoe", new HoeItem(DDTiers.WARDEN, -4, 0, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_SWORD = register("warden_sword", new SwordItem(DDTiers.WARDEN, 3, -2.4f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_HELMET = register("warden_helmet", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_CHESTPLATE = register("warden_chestplate", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_LEGGINGS = register("warden_leggings", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_BOOTS = register("warden_boots", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final Item SCULK_TRANSMITTER = register("sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    // public static final Item SONOROUS_STAFF = register("sonorous_staff", new WardenStaffItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final Item SCULK_CENTIPEDE_SPAWN_EGG = register("sculk_centipede_spawn_egg", new SpawnEggItem(DDEntities.SCULK_CENTIPEDE, 0x1a2340, 0xded697, new Item.Properties()));
    public static final Item SCULK_LEECH_SPAWN_EGG = register("sculk_leech_spawn_egg", new SpawnEggItem(DDEntities.SCULK_LEECH, 0x152b38, 0x47e5ed, new Item.Properties()));
    public static final Item SCULK_SNAPPER_SPAWN_EGG = register("sculk_snapper_spawn_egg", new SpawnEggItem(DDEntities.SCULK_SNAPPER, 0xd1d6b6, 0x1d726f, new Item.Properties()));
    public static final Item SHATTERED_SPAWN_EGG = register("shattered_spawn_egg", new SpawnEggItem(DDEntities.SHATTERED, 0x0e181d, 0x819699, new Item.Properties()));
    public static final Item SHRIEK_WORM_SPAWN_EGG = register("shriek_worm_spawn_egg", new SpawnEggItem(DDEntities.SHRIEK_WORM, 0xd1d6b6, 0x009295, new Item.Properties()));
    public static final Item STALKER_SPAWN_EGG = register("stalker_spawn_egg", new SpawnEggItem(DDEntities.STALKER, 0x172226, 0x6abdd9, new Item.Properties()));

    public static final Item ECHO_SIGN = register("echo_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN));
    public static final Item ECHO_HANGING_SIGN = register("echo_hanging_sign", new HangingSignItem(DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));



    // Items that will be in the mod forever in every single update.
    public static final Item STALKER_EAR = register("stalker_ear", new Item(new Item.Properties().stacksTo(33)));
    public static final Item EARBUD = register("earbud", new Item(new Item.Properties().stacksTo(3)));
    public static final Item EARBUDS = register("earbuds", new EarbudsItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    public static final Item BIOSCULK_SIGN = register("biosculk_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.BIOSCULK_SIGN, DDBlocks.BIOSCULK_WALL_SIGN));
    public static final Item BIOSCULK_HANGING_SIGN = register("biosculk_hanging_sign", new HangingSignItem(DDBlocks.BIOSCULK_HANGING_SIGN, DDBlocks.BIOSCULK_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BIOSCULK_BOAT = register("biosculk_boat", new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBlocks.BIOSCULK));
    public static final Item BIOSCULK_CHEST_BOAT = register("biosculk_chest_boat", new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBlocks.BIOSCULK));
    public static final Item WARDEN_FLINT_AND_STEEL = register("warden_flint_and_steel", new FlintAndSteelItem(new Item.Properties().durability(64).rarity(Rarity.EPIC)));
    public static final Item HEART_NECKLACE = register("heart_necklace", new HeartNecklaceItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    public static final Item HONEYBOUND_TOTEM = register("honeybound_totem", new HoneyboundTotemItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    public static final Item WARDEN_PIE = register("warden_pie", new Item(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(8).saturationMod(1.3f).meat().build())));


    public static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, id), item);
    }

    private static Item createWardenUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(DeeperDarker.MOD_ID, "warden_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.warden_upgrade.additions_slot_description"))),
                getWardenEmptyBaseSlotTextures(),
                getWardenEmptyAdditionsSlotTextures());
    }

    private static List<ResourceLocation> getWardenEmptyBaseSlotTextures() {
        return List.of(new ResourceLocation("item/empty_armor_slot_helmet"),
                new ResourceLocation("item/empty_armor_slot_chestplate"),
                new ResourceLocation("item/empty_armor_slot_leggings"),
                new ResourceLocation("item/empty_armor_slot_boots"),
                new ResourceLocation("item/empty_slot_sword"),
                new ResourceLocation("item/empty_slot_pickaxe"),
                new ResourceLocation("item/empty_slot_axe"),
                new ResourceLocation("item/empty_slot_shovel"),
                new ResourceLocation("item/empty_slot_hoe"),
                new ResourceLocation(DeeperDarker.MOD_ID, "item/empty_slot_flint_and_steel"));
    }

    private static List<ResourceLocation> getWardenEmptyAdditionsSlotTextures() {
        return List.of(new ResourceLocation(DeeperDarker.MOD_ID, "item/empty_slot_reinforced_echo_shard"));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering items");
    }
}
