package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.*;
import com.kyanite.deeperdarker.util.DDMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class DDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeeperDarker.MOD_ID);

    public static final DeferredItem<Item> ICE_LILY = ITEMS.registerItem("ice_lily", p -> new PlaceOnWaterBlockItem(DDBlocks.ICE_LILY.get(), p.useItemDescriptionPrefix()));
    public static final DeferredItem<Item> LILY_FLOWER = ITEMS.registerItem("lily_flower", p -> new LilyFlowerItem(DDBlocks.LILY_FLOWER.get(), p));
    public static final DeferredItem<Item> ECHO_SIGN = ITEMS.registerItem("echo_sign", p -> new SignItem(DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get(), p), p -> p.stacksTo(16));
    public static final DeferredItem<Item> ECHO_HANGING_SIGN = ITEMS.registerItem("echo_hanging_sign", p -> new HangingSignItem(DDBlocks.ECHO_HANGING_SIGN.get(), DDBlocks.ECHO_WALL_HANGING_SIGN.get(), p), p -> p.stacksTo(16));
    public static final DeferredItem<Item> BLOOM_SIGN = ITEMS.registerItem("bloom_sign", p -> new SignItem(DDBlocks.BLOOM_SIGN.get(), DDBlocks.BLOOM_WALL_SIGN.get(), p), p -> p.stacksTo(16));
    public static final DeferredItem<Item> BLOOM_HANGING_SIGN = ITEMS.registerItem("bloom_hanging_sign", p -> new HangingSignItem(DDBlocks.BLOOM_HANGING_SIGN.get(), DDBlocks.BLOOM_WALL_HANGING_SIGN.get(), p), p -> p.stacksTo(16));

    public static final DeferredItem<Item> BLOOM_BERRIES = ITEMS.registerItem("bloom_berries", p -> new BlockItem(DDBlocks.GLOWING_VINES.get(), p.useItemDescriptionPrefix()), p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build(), Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.8f)).build()));
    public static final DeferredItem<Item> GRIME_BALL = ITEMS.registerSimpleItem("grime_ball");
    public static final DeferredItem<Item> GRIME_BRICK = ITEMS.registerSimpleItem("grime_brick");
    public static final DeferredItem<Item> GLEAM_GEL = ITEMS.registerSimpleItem("gleam_gel");
    public static final DeferredItem<Item> LITE = ITEMS.registerSimpleItem("lite");

    public static final DeferredItem<Item> ANCIENT_COMPASS = ITEMS.registerItem("ancient_compass", AncientCompassItem::new, p -> p.stacksTo(1));
    public static final DeferredItem<Item> SOUL_ELYTRA = ITEMS.registerItem("soul_elytra", SoulElytraItem::new, p -> p.rarity(Rarity.RARE).component(DataComponents.GLIDER, Unit.INSTANCE).component(DataComponents.EQUIPPABLE, SoulElytraItem.equipableComponent()).repairable(DDItems.SOUL_CRYSTAL.get()).attributes(SoulElytraItem.attributes()));
    public static final DeferredItem<Item> ECHO_BOAT = ITEMS.registerItem("echo_boat", p -> new BoatItem(DDEntities.ECHO_BOAT.get(), p), p -> p.stacksTo(1));
    public static final DeferredItem<Item> ECHO_CHEST_BOAT = ITEMS.registerItem("echo_chest_boat", p -> new BoatItem(DDEntities.ECHO_CHEST_BOAT.get(), p), p -> p.stacksTo(1));
    public static final DeferredItem<Item> BLOOM_BOAT = ITEMS.registerItem("bloom_boat", p -> new BoatItem(DDEntities.BLOOM_BOAT.get(), p), p -> p.stacksTo(1));
    public static final DeferredItem<Item> BLOOM_CHEST_BOAT = ITEMS.registerItem("bloom_chest_boat", p -> new BoatItem(DDEntities.BLOOM_CHEST_BOAT.get(), p), p -> p.stacksTo(1));

    public static final DeferredItem<Item> ANGLER_FISH = ITEMS.registerSimpleItem("angler_fish", p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build()));
    public static final DeferredItem<Item> COOKED_ANGLER_FISH = ITEMS.registerSimpleItem("cooked_angler_fish", p -> p.food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build()));

    public static final DeferredItem<Item> SCULK_BONE = ITEMS.registerSimpleItem("sculk_bone");
    public static final DeferredItem<Item> SOUL_DUST = ITEMS.registerSimpleItem("soul_dust");
    public static final DeferredItem<Item> SOUL_CRYSTAL = ITEMS.registerSimpleItem("soul_crystal");
    public static final DeferredItem<Item> RESONARIUM = ITEMS.registerSimpleItem("resonarium");
    public static final DeferredItem<Item> RESONARIUM_PLATE = ITEMS.registerSimpleItem("resonarium_plate");
    public static final DeferredItem<Item> HEART_OF_THE_DEEP = ITEMS.registerItem("heart_of_the_deep", WardenHeartItem::new, p -> p.rarity(Rarity.RARE).stacksTo(1).fireResistant());
    public static final DeferredItem<Item> WARDEN_CARAPACE = ITEMS.registerSimpleItem("warden_carapace", p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> REINFORCED_ECHO_SHARD = ITEMS.registerSimpleItem("reinforced_echo_shard", p -> p.rarity(Rarity.RARE).fireResistant());

    public static final DeferredItem<Item> RESONARIUM_SWORD = ITEMS.registerSimpleItem("resonarium_sword", p -> p.sword(DDMaterials.Tool.RESONARIUM, 3f, -2.4f));
    public static final DeferredItem<Item> RESONARIUM_SHOVEL = ITEMS.registerItem("resonarium_shovel", p -> new ShovelItem(DDMaterials.Tool.RESONARIUM, 1.5f, -3f, p));
    public static final DeferredItem<Item> RESONARIUM_PICKAXE = ITEMS.registerSimpleItem("resonarium_pickaxe", p -> p.pickaxe(DDMaterials.Tool.RESONARIUM, 1f, -2.8f));
    public static final DeferredItem<Item> RESONARIUM_AXE = ITEMS.registerItem("resonarium_axe", p -> new AxeItem(DDMaterials.Tool.RESONARIUM, 5f, -3f, p));
    public static final DeferredItem<Item> RESONARIUM_HOE = ITEMS.registerItem("resonarium_hoe", p -> new HoeItem(DDMaterials.Tool.RESONARIUM, -3f, 0f, p));
    public static final DeferredItem<Item> RESONARIUM_HELMET = ITEMS.registerItem("resonarium_helmet", p -> new ResonariumArmorItem(p, DDMaterials.Armor.RESONARIUM, ArmorType.HELMET));
    public static final DeferredItem<Item> RESONARIUM_CHESTPLATE = ITEMS.registerItem("resonarium_chestplate", p -> new ResonariumArmorItem(p, DDMaterials.Armor.RESONARIUM, ArmorType.CHESTPLATE));
    public static final DeferredItem<Item> RESONARIUM_LEGGINGS = ITEMS.registerItem("resonarium_leggings", p -> new ResonariumArmorItem(p, DDMaterials.Armor.RESONARIUM, ArmorType.LEGGINGS));
    public static final DeferredItem<Item> RESONARIUM_BOOTS = ITEMS.registerItem("resonarium_boots", p -> new ResonariumArmorItem(p, DDMaterials.Armor.RESONARIUM, ArmorType.BOOTS));

    public static final DeferredItem<Item> WARDEN_SWORD = ITEMS.registerSimpleItem("warden_sword", p -> p.sword(DDMaterials.Tool.WARDEN, 3f, -2.4f).rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_SHOVEL = ITEMS.registerItem("warden_shovel", p -> new ShovelItem(DDMaterials.Tool.WARDEN, 1.5f, -3f, p), p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_PICKAXE = ITEMS.registerSimpleItem("warden_pickaxe", p -> p.pickaxe(DDMaterials.Tool.WARDEN, 1f, -2.8f).rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_AXE = ITEMS.registerItem("warden_axe", p -> new AxeItem(DDMaterials.Tool.WARDEN, 5f, -3f, p), p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_HOE = ITEMS.registerItem("warden_hoe", p -> new HoeItem(DDMaterials.Tool.WARDEN, -3f, 0f, p), p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_HELMET = ITEMS.registerItem("warden_helmet", p -> new WardenArmorItem(p, DDMaterials.Armor.WARDEN, ArmorType.HELMET), p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_CHESTPLATE = ITEMS.registerItem("warden_chestplate", p -> new WardenArmorItem(p, DDMaterials.Armor.WARDEN, ArmorType.CHESTPLATE), p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_LEGGINGS = ITEMS.registerItem("warden_leggings", p -> new WardenArmorItem(p, DDMaterials.Armor.WARDEN, ArmorType.LEGGINGS), p -> p.rarity(Rarity.RARE).fireResistant());
    public static final DeferredItem<Item> WARDEN_BOOTS = ITEMS.registerItem("warden_boots", p -> new WardenArmorItem(p, DDMaterials.Armor.WARDEN, ArmorType.BOOTS), p -> p.rarity(Rarity.RARE).fireResistant());

    public static final DeferredItem<Item> SCULK_TRANSMITTER = ITEMS.registerItem("sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> WHITE_SCULK_TRANSMITTER = ITEMS.registerItem("white_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> ORANGE_SCULK_TRANSMITTER = ITEMS.registerItem("orange_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> MAGENTA_SCULK_TRANSMITTER = ITEMS.registerItem("magenta_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> LIGHT_BLUE_SCULK_TRANSMITTER = ITEMS.registerItem("light_blue_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> YELLOW_SCULK_TRANSMITTER = ITEMS.registerItem("yellow_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> LIME_SCULK_TRANSMITTER = ITEMS.registerItem("lime_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> PINK_SCULK_TRANSMITTER = ITEMS.registerItem("pink_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> GRAY_SCULK_TRANSMITTER = ITEMS.registerItem("gray_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> LIGHT_GRAY_SCULK_TRANSMITTER = ITEMS.registerItem("light_gray_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> CYAN_SCULK_TRANSMITTER = ITEMS.registerItem("cyan_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> PURPLE_SCULK_TRANSMITTER = ITEMS.registerItem("purple_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> BLUE_SCULK_TRANSMITTER = ITEMS.registerItem("blue_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> BROWN_SCULK_TRANSMITTER = ITEMS.registerItem("brown_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> GREEN_SCULK_TRANSMITTER = ITEMS.registerItem("green_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> RED_SCULK_TRANSMITTER = ITEMS.registerItem("red_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> BLACK_SCULK_TRANSMITTER = ITEMS.registerItem("black_sculk_transmitter", SculkTransmitterItem::new, p -> p.stacksTo(1).rarity(Rarity.RARE));
    public static final DeferredItem<Item> SONOROUS_STAFF = ITEMS.registerItem("sonorous_staff", SonorousStaffItem::new, p -> p.repairable(DDItems.SOUL_CRYSTAL.get()).durability(320).rarity(Rarity.RARE));

    public static final DeferredItem<Item> GLOOMSHERD = ITEMS.registerSimpleItem("gloomsherd");
    public static final DeferredItem<Item> BRITTLE_GLOOMSHERD = ITEMS.registerSimpleItem("brittle_gloomsherd");
    public static final DeferredItem<Item> DARK_HEART_GLOOMSHERD = ITEMS.registerSimpleItem("dark_heart_gloomsherd");
    public static final DeferredItem<Item> LISTENER_GLOOMSHERD = ITEMS.registerSimpleItem("listener_gloomsherd");
    public static final DeferredItem<Item> SNAPPER_GLOOMSHERD = ITEMS.registerSimpleItem("snapper_gloomsherd");
    public static final DeferredItem<Item> TEMPLE_GLOOMSHERD = ITEMS.registerSimpleItem("temple_gloomsherd");
    public static final DeferredItem<Item> TRANSMISSION_GLOOMSHERD = ITEMS.registerSimpleItem("transmission_gloomsherd");
    public static final DeferredItem<Item> WARD_GLOOMSHERD = ITEMS.registerSimpleItem("ward_gloomsherd");
    public static final DeferredItem<Item> WAYFINDER_GLOOMSHERD = ITEMS.registerSimpleItem("wayfinder_gloomsherd");

    public static final DeferredItem<Item> RESONARIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerItem("resonarium_upgrade_smithing_template", p -> new SmithingTemplateItem(
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.resonarium_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.resonarium_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.resonarium_upgrade.base_slot_description"),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.resonarium_upgrade.additions_slot_description"),
            SmithingTemplateItem.createNetheriteUpgradeIconList(),
            List.of(DeeperDarker.rl("item/empty_slot_shard")),
            p
    ), p -> p.rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> WARDEN_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerItem("warden_upgrade_smithing_template", p -> new SmithingTemplateItem(
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.base_slot_description"),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.additions_slot_description"),
            SmithingTemplateItem.createNetheriteUpgradeIconList(),
            List.of(DeeperDarker.rl("item/empty_slot_shard")),
            p
    ), p -> p.rarity(Rarity.UNCOMMON));

    public static final DeferredItem<Item> ANGLER_FISH_SPAWN_EGG = ITEMS.registerItem("angler_fish_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.ANGLER_FISH.get()));
    public static final DeferredItem<Item> ANGER_POT_SPAWN_EGG = ITEMS.registerItem("anger_pot_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.ANGER_POT.get()));
    public static final DeferredItem<Item> FEAR_POT_SPAWN_EGG = ITEMS.registerItem("fear_pot_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.FEAR_POT.get()));
    public static final DeferredItem<Item> SORROW_POT_SPAWN_EGG = ITEMS.registerItem("sorrow_pot_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SORROW_POT.get()));
    public static final DeferredItem<Item> SCULK_CENTIPEDE_SPAWN_EGG = ITEMS.registerItem("sculk_centipede_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SCULK_CENTIPEDE.get()));
    public static final DeferredItem<Item> SCULK_LEECH_SPAWN_EGG = ITEMS.registerItem("sculk_leech_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SCULK_LEECH.get()));
    public static final DeferredItem<Item> SCULK_SNAPPER_SPAWN_EGG = ITEMS.registerItem("sculk_snapper_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SCULK_SNAPPER.get()));
    public static final DeferredItem<Item> SHATTERED_SPAWN_EGG = ITEMS.registerItem("shattered_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SHATTERED.get()));
    public static final DeferredItem<Item> SHRIEK_WORM_SPAWN_EGG = ITEMS.registerItem("shriek_worm_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SHRIEK_WORM.get()));
    public static final DeferredItem<Item> SLUDGE_SPAWN_EGG = ITEMS.registerItem("sludge_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.SLUDGE.get()));
    public static final DeferredItem<Item> STALKER_SPAWN_EGG = ITEMS.registerItem("stalker_spawn_egg", SpawnEggItem::new, p -> p.spawnEgg(DDEntities.STALKER.get()));
}
