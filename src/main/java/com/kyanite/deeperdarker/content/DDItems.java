package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.DDBoat;
import com.kyanite.deeperdarker.content.items.*;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTiers;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.List;

@SuppressWarnings("unused")
public class DDItems {
    public static final Item GRIME_BALL = register("grime_ball", new Item(new Item.Properties()));
    public static final Item GRIME_BRICK = register("grime_brick", new Item(new Item.Properties()));

    public static final Item SOUL_ELYTRA = register("soul_elytra", new SoulElytraItem(new Item.Properties().durability(956).rarity(Rarity.UNCOMMON)));
    public static final Item ECHO_BOAT = register("echo_boat", new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBoat.Type.ECHO));
    public static final Item ECHO_CHEST_BOAT = register("echo_chest_boat", new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBoat.Type.ECHO));
    public static final Item BLOOM_BOAT = register("bloom_boat", new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBoat.Type.BLOOM));
    public static final Item BLOOM_CHEST_BOAT = register("bloom_chest_boat", new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBoat.Type.BLOOM));
    public static final Item SCULK_SPRUCE_BOAT = register("sculk_spruce_boat", new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBoat.Type.SCULK_SPRUCE));
    public static final Item SCULK_SPRUCE_CHEST_BOAT = register("sculk_spruce_chest_boat", new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBoat.Type.SCULK_SPRUCE));

    public static final Item ICE_LILY = register("ice_lily", new IceLilyItem(DDBlocks.ICE_LILY, new Item.Properties()));
    public static final Item LILY_FLOWER = register("lily_flower", new LilyFlowerItem(DDBlocks.LILY_FLOWER, new Item.Properties()));

    public static final Item SCULK_BONE = register("sculk_bone", new Item(new Item.Properties()));
    public static final Item SCULK_BONE_SHARD = register("sculk_bone_shard", new Item(new Item.Properties()));
    public static final Item OTHERSIDE_FIRE_STRIKER = register("otherside_fire_striker", new OthersideFireStrikerItem(new Item.Properties().durability(64)));
    public static final Item SOUL_DUST = register("soul_dust", new Item(new Item.Properties()));
    public static final Item SOUL_CRYSTAL = register("soul_crystal", new Item(new Item.Properties()));
    public static final Item HEART_OF_THE_DEEP = register("heart_of_the_deep", new HeartOfTheDeepItem(new Item.Properties().rarity(Rarity.RARE).fireResistant().stacksTo(1)));
    public static final Item WARDEN_CARAPACE = register("warden_carapace", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item REINFORCED_ECHO_SHARD = register("reinforced_echo_shard", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item RESONARIUM = register("resonarium", new Item(new Item.Properties().fireResistant()));
    public static final Item RESONARIUM_PLATE = register("resonarium_plate", new Item(new Item.Properties().fireResistant()));
    public static final Item RAW_LEAD = register("raw_lead", new Item(new Item.Properties()));
    public static final Item LEAD_INGOT = register("lead_ingot", new Item(new Item.Properties()));
    public static final Item RADIOACTIVE_INGOT = register("radioactive_ingot", new Item(new Item.Properties()));
    public static final Item WARDEN_UPGRADE_SMITHING_TEMPLATE = register("warden_upgrade_smithing_template", createWardenUpgradeSmithingTemplate());
    public static final Item GUARDIAN_UPGRADE_SMITHING_TEMPLATE = register("guardian_upgrade_smithing_template", createGuardianUpgradeSmithingTemplate());
    public static final Item ROYAL_SCEPTER = register("royal_scepter", new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

    public static final Item WARDEN_SHOVEL = register("warden_shovel", new ShovelItem(DDTiers.WARDEN, 1.5f, -3, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_PICKAXE = register("warden_pickaxe", new PickaxeItem(DDTiers.WARDEN, 1, -2.8f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_AXE = register("warden_axe", new AxeItem(DDTiers.WARDEN, 5, -3, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_HOE = register("warden_hoe", new HoeItem(DDTiers.WARDEN, -4, 0, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_SWORD = register("warden_sword", new SwordItem(DDTiers.WARDEN, 3, -2.4f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_HELMET = register("warden_helmet", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE).fireResistant(), List.of(MobEffects.BLINDNESS, MobEffects.DARKNESS)));
    public static final Item WARDEN_CHESTPLATE = register("warden_chestplate", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_LEGGINGS = register("warden_leggings", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_BOOTS = register("warden_boots", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final Item RESONARIUM_HELMET = register("resonarium_helmet", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_CHESTPLATE = register("resonarium_chestplate", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_LEGGINGS = register("resonarium_leggings", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_BOOTS = register("resonarium_boots", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_SHOVEL = register("resonarium_shovel", new ShovelItem(DDTiers.RESONARIUM, 1.5f, -3, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_PICKAXE = register("resonarium_pickaxe", new PickaxeItem(DDTiers.RESONARIUM, 1, -2.8f, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_AXE = register("resonarium_axe", new AxeItem(DDTiers.RESONARIUM, 5, -3, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_HOE = register("resonarium_hoe", new HoeItem(DDTiers.RESONARIUM, -4, 0, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_SWORD = register("resonarium_sword", new SwordItem(DDTiers.RESONARIUM, 3, -2.4f, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item LEAD_HELMET = register("lead_helmet", new ArmorItem(DDArmorMaterials.LEAD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Item LEAD_CHESTPLATE = register("lead_chestplate", new ArmorItem(DDArmorMaterials.LEAD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Item LEAD_LEGGINGS = register("lead_leggings", new ArmorItem(DDArmorMaterials.LEAD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Item LEAD_BOOTS = register("lead_boots", new ArmorItem(DDArmorMaterials.LEAD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final Item LEAD_SHOVEL = register("lead_shovel", new ShovelItem(DDTiers.LEAD, 1.5f, -3.0f, new Item.Properties()));
    public static final Item LEAD_PICKAXE = register("lead_pickaxe", new PickaxeItem(DDTiers.LEAD, 1, -2.8f, new Item.Properties()));
    public static final Item LEAD_AXE = register("lead_axe", new AxeItem(DDTiers.LEAD, 6.0f, -3.1f, new Item.Properties()));
    public static final Item LEAD_HOE = register("lead_hoe", new HoeItem(DDTiers.LEAD, -2, -1.0f, new Item.Properties()));
    public static final Item LEAD_SWORD = register("lead_sword", new SwordItem(DDTiers.LEAD, 3, -2.4f, new Item.Properties()));

    public static final Item RADIOACTIVE_HELMET = register("radioactive_helmet", new ArmorItem(DDArmorMaterials.RADIOACTIVE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Item RADIOACTIVE_CHESTPLATE = register("radioactive_chestplate", new ArmorItem(DDArmorMaterials.RADIOACTIVE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Item RADIOACTIVE_LEGGINGS = register("radioactive_leggings", new ArmorItem(DDArmorMaterials.RADIOACTIVE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Item RADIOACTIVE_BOOTS = register("radioactive_boots", new ArmorItem(DDArmorMaterials.RADIOACTIVE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final Item RADIOACTIVE_SHOVEL = register("radioactive_shovel", new ShovelItem(DDTiers.RADIOACTIVE, 1.5f, -3.0f, new Item.Properties()));
    public static final Item RADIOACTIVE_PICKAXE = register("radioactive_pickaxe", new PickaxeItem(DDTiers.RADIOACTIVE, 1, -2.8f, new Item.Properties()));
    public static final Item RADIOACTIVE_AXE = register("radioactive_axe", new AxeItem(DDTiers.RADIOACTIVE, 5.0f, -3.1f, new Item.Properties()));
    public static final Item RADIOACTIVE_HOE = register("radioactive_hoe", new HoeItem(DDTiers.RADIOACTIVE, -3, 0.0f, new Item.Properties()));
    public static final Item RADIOACTIVE_SWORD = register("radioactive_sword", new SwordItem(DDTiers.RADIOACTIVE, 3, -2.4f, new Item.Properties()));

    public static final Item SCULK_TRANSMITTER = register("sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item WHITE_SCULK_TRANSMITTER = register("white_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item ORANGE_SCULK_TRANSMITTER = register("orange_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item MAGENTA_SCULK_TRANSMITTER = register("magenta_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item LIGHT_BLUE_SCULK_TRANSMITTER = register("light_blue_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item YELLOW_SCULK_TRANSMITTER = register("yellow_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item LIME_SCULK_TRANSMITTER = register("lime_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item PINK_SCULK_TRANSMITTER = register("pink_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item GRAY_SCULK_TRANSMITTER = register("gray_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item LIGHT_GRAY_SCULK_TRANSMITTER = register("light_gray_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item CYAN_SCULK_TRANSMITTER = register("cyan_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item PURPLE_SCULK_TRANSMITTER = register("purple_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item BLUE_SCULK_TRANSMITTER = register("blue_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item BROWN_SCULK_TRANSMITTER = register("brown_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item GREEN_SCULK_TRANSMITTER = register("green_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item RED_SCULK_TRANSMITTER = register("red_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item BLACK_SCULK_TRANSMITTER = register("black_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item SUPER_SCULK_TRANSMITTER = register("super_sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    public static final Item SONOROUS_STAFF = register("sonorous_staff", new SonorousStaffItem(new Item.Properties().durability(320).rarity(Rarity.RARE)));

    public static final Item ANGLER_FISH_SPAWN_EGG = register("angler_fish_spawn_egg", new SpawnEggItem(DDEntities.ANGLER_FISH, 0x074857, 0x74faf3, new Item.Properties()));
    public static final Item SCULK_CENTIPEDE_SPAWN_EGG = register("sculk_centipede_spawn_egg", new SpawnEggItem(DDEntities.SCULK_CENTIPEDE, 0x1a2340, 0xded697, new Item.Properties()));
    public static final Item SCULK_LEECH_SPAWN_EGG = register("sculk_leech_spawn_egg", new SpawnEggItem(DDEntities.SCULK_LEECH, 0x152b38, 0x47e5ed, new Item.Properties()));
    public static final Item SCULK_SNAPPER_SPAWN_EGG = register("sculk_snapper_spawn_egg", new SpawnEggItem(DDEntities.SCULK_SNAPPER, 0xd1d6b6, 0x1d726f, new Item.Properties()));
    public static final Item SHATTERED_SPAWN_EGG = register("shattered_spawn_egg", new SpawnEggItem(DDEntities.SHATTERED, 0x0e181d, 0x819699, new Item.Properties()));
    public static final Item SHRIEK_WORM_SPAWN_EGG = register("shriek_worm_spawn_egg", new SpawnEggItem(DDEntities.SHRIEK_WORM, 0xd1d6b6, 0x009295, new Item.Properties()));
    public static final Item SLUDGE_SPAWN_EGG = register("sludge_spawn_egg", new SpawnEggItem(DDEntities.SLUDGE, 0x0f2824, 0x3ca195, new Item.Properties()));
    public static final Item STALKER_SPAWN_EGG = register("stalker_spawn_egg", new SpawnEggItem(DDEntities.STALKER, 0x172226, 0x6abdd9, new Item.Properties()));
    public static final Item POTTY_SPAWN_EGG = register("potty_spawn_egg", new SpawnEggItem(DDEntities.POTTY, 0x3b2d29, 0x433733, new Item.Properties()));
    public static final Item POT_SPAWN_EGG = register("pot_spawn_egg", new SpawnEggItem(DDEntities.POT, 0x3b2d29, 0x433733, new Item.Properties()));
    public static final Item POTTER_SPAWN_EGG = register("potter_spawn_egg", new SpawnEggItem(DDEntities.POTTER, 0x3b2d29, 0x433733, new Item.Properties()));
    public static final Item ACID_SPRITE_SPAWN_EGG = register("acid_sprite_spawn_egg", new SpawnEggItem(DDEntities.ACID_SPRITE, 0x28d43d, 0x86ee93, new Item.Properties()));

    public static final Item ECHO_SIGN = register("echo_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN));
    public static final Item ECHO_HANGING_SIGN = register("echo_hanging_sign", new HangingSignItem(DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BLOOM_SIGN = register("bloom_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.BLOOM_SIGN, DDBlocks.BLOOM_WALL_SIGN));
    public static final Item BLOOM_HANGING_SIGN = register("bloom_hanging_sign", new HangingSignItem(DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item SCULK_SPRUCE_SIGN = register("sculk_spruce_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.SCULK_SPRUCE_SIGN, DDBlocks.SCULK_SPRUCE_WALL_SIGN));
    public static final Item SCULK_SPRUCE_HANGING_SIGN = register("sculk_spruce_hanging_sign", new HangingSignItem(DDBlocks.SCULK_SPRUCE_HANGING_SIGN, DDBlocks.SCULK_SPRUCE_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));

    public static final Item BLOOM_BERRIES = register("bloom_berries", new ItemNameBlockItem(DDBlocks.GLOWING_VINES, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.8f).build())));
    public static final Item SCULK_TUBER = register("sculk_tuber", new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6f).build())));
    public static final Item SCULK_BERRY = register("sculk_berry", new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).build())));
    public static final Item SCULK_BERRY_SPROUT = register("sculk_berry_sprout", new ItemNameBlockItem(DDBlocks.SCULK_BERRY, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build())));

    public static final Item SCULK_TISSUE_BRICK = register("sculk_tissue_brick", new Item(new Item.Properties()));
    public static final Item SHADOW_CRYSTAL = register("shadow_crystal", new Item(new Item.Properties()));
    public static final Item SUNGLASSES = register("sunglasses", new SunglassesItem(new Item.Properties().stacksTo(1)));
    public static final Item DAINTY_KEY = register("dainty_key", new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
    public static final Item KEYBRAND = register("keybrand", new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    public static final Item SHATTERED_HEAD = register("shattered_head", new StandingAndWallBlockItem(DDBlocks.SHATTERED_HEAD, DDBlocks.SHATTERED_WALL_HEAD, new Item.Properties().rarity(Rarity.UNCOMMON), Direction.DOWN));

    public static final Item PATIENCE_SOUL = register("patience_soul", new PatienceSoulItem(DDBlocks.PATIENCE_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.PATIENCE_SOUL));
    public static final Item FORTITUDE_SOUL = register("fortitude_soul", new FortitudeSoulItem(DDBlocks.FORTITUDE_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.FORTITUDE_SOUL));
    public static final Item CORRUPTION_SOUL = register("corruption_soul", new CorruptionSoulItem(DDBlocks.CORRUPTION_SOUL_FIRE, new Item.Properties().rarity(Rarity.RARE).fireResistant(), DDParticleTypes.CORRUPTION_SOUL));
    public static final Item SCULK_TORCH = register("sculk_torch", new StandingAndWallBlockItem(DDBlocks.SCULK_TORCH, DDBlocks.SCULK_WALL_TORCH, new Item.Properties(), Direction.DOWN));

    public static final Item ACID_BUCKET = register("acid_bucket", new BucketItem(DDFluids.ACID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item FIZZ = register("fizz", new Item(new Item.Properties()));
    public static final Item SCULK_DRINK = register("sculk_drink", new SculkDrinkItem(new Item.Properties().craftRemainder(Items.BUCKET).food(new FoodProperties.Builder().nutrition(10).saturationMod(1.2f).build()).stacksTo(1)));
    public static final Item SHIELD_AUGMENT = register("shield_augment", new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

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
                new ResourceLocation("item/empty_slot_hoe"));
    }

    private static List<ResourceLocation> getWardenEmptyAdditionsSlotTextures() {
        return List.of(new ResourceLocation(DeeperDarker.MOD_ID, "item/empty_slot_reinforced_echo_shard"));
    }

    private static Item createGuardianUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.guardian_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.guardian_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(DeeperDarker.MOD_ID, "guardian_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.guardian_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DeeperDarker.MOD_ID, "smithing_template.guardian_upgrade.additions_slot_description"))),
                getGuardianEmptyBaseSlotTextures(),
                getGuardianEmptyAdditionsSlotTextures());
    }

    private static List<ResourceLocation> getGuardianEmptyBaseSlotTextures() {
        return List.of(new ResourceLocation("item/empty_armor_slot_helmet"),
                new ResourceLocation("item/empty_armor_slot_chestplate"),
                new ResourceLocation("item/empty_armor_slot_leggings"),
                new ResourceLocation("item/empty_armor_slot_boots"),
                new ResourceLocation("item/empty_slot_sword"),
                new ResourceLocation("item/empty_slot_pickaxe"),
                new ResourceLocation("item/empty_slot_axe"),
                new ResourceLocation("item/empty_slot_shovel"),
                new ResourceLocation("item/empty_slot_hoe"));
    }

    private static List<ResourceLocation> getGuardianEmptyAdditionsSlotTextures() {
        return List.of(new ResourceLocation(DeeperDarker.MOD_ID, "item/empty_slot_virtue_shard"));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering items");
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.ECHO_SAPLING.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.ECHO_LEAVES.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_FLOWERS.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_ROOTS.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BLOOM_BERRIES, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(SCULK_TUBER, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.SCULK_TENDRILS.asItem(), 0.5f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_GRASS.asItem(), 0.5f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.SCULK_VINES.asItem(), 0.5f);
    }
}
