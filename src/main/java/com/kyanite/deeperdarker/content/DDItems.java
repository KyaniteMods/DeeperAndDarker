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

    public static final Item ICE_LILY = register("ice_lily", new IceLilyItem(DDBlocks.ICE_LILY, new Item.Properties()));
    public static final Item LILY_FLOWER = register("lily_flower", new LilyFlowerItem(DDBlocks.LILY_FLOWER, new Item.Properties()));

    public static final Item SCULK_BONE = register("sculk_bone", new Item(new Item.Properties()));
    public static final Item SOUL_DUST = register("soul_dust", new Item(new Item.Properties()));
    public static final Item SOUL_CRYSTAL = register("soul_crystal", new Item(new Item.Properties()));
    public static final Item HEART_OF_THE_DEEP = register("heart_of_the_deep", new HeartOfTheDeepItem(new Item.Properties().rarity(Rarity.RARE).fireResistant().stacksTo(1)));
    public static final Item WARDEN_CARAPACE = register("warden_carapace", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item REINFORCED_ECHO_SHARD = register("reinforced_echo_shard", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item RESONARIUM = register("resonarium", new Item(new Item.Properties().fireResistant()));
    public static final Item RESONARIUM_PLATE = register("resonarium_plate", new Item(new Item.Properties().fireResistant()));
    public static final Item WARDEN_UPGRADE_SMITHING_TEMPLATE = register("warden_upgrade_smithing_template", createWardenUpgradeSmithingTemplate());

    public static final Item WARDEN_SHOVEL = register("warden_shovel", new ShovelItem(DDTiers.WARDEN, new Item.Properties().attributes(ShovelItem.createAttributes(DDTiers.WARDEN, 1.5f, -3)).rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_PICKAXE = register("warden_pickaxe", new PickaxeItem(DDTiers.WARDEN, new Item.Properties().attributes(PickaxeItem.createAttributes(DDTiers.WARDEN, 1, -2.8f)).rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_AXE = register("warden_axe", new AxeItem(DDTiers.WARDEN, new Item.Properties().attributes(AxeItem.createAttributes(DDTiers.WARDEN, 5, -3)).rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_HOE = register("warden_hoe", new HoeItem(DDTiers.WARDEN, new Item.Properties().attributes(HoeItem.createAttributes(DDTiers.WARDEN, -4, 0)).rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_SWORD = register("warden_sword", new SwordItem(DDTiers.WARDEN, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 3, -2.4f)).rarity(Rarity.RARE).fireResistant()));
    public static final Item WARDEN_HELMET = register("warden_helmet", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40)), List.of(MobEffects.BLINDNESS, MobEffects.DARKNESS)));
    public static final Item WARDEN_CHESTPLATE = register("warden_chestplate", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final Item WARDEN_LEGGINGS = register("warden_leggings", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE).fireResistant().attributes(WardenArmorItem.createAttributes()).durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final Item WARDEN_BOOTS = register("warden_boots", new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40))));

    public static final Item RESONARIUM_HELMET = register("resonarium_helmet", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(30))));
    public static final Item RESONARIUM_CHESTPLATE = register("resonarium_chestplate", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(30))));
    public static final Item RESONARIUM_LEGGINGS = register("resonarium_leggings", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(30))));
    public static final Item RESONARIUM_BOOTS = register("resonarium_boots", new ResonariumArmorItem(DDArmorMaterials.RESONARIUM, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(30))));
    public static final Item RESONARIUM_SHOVEL = register("resonarium_shovel", new ShovelItem(DDTiers.RESONARIUM, new Item.Properties().attributes(ShovelItem.createAttributes(DDTiers.RESONARIUM, 1.5f, -3)).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_PICKAXE = register("resonarium_pickaxe", new PickaxeItem(DDTiers.RESONARIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(DDTiers.RESONARIUM, 1, -2.8f)).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_AXE = register("resonarium_axe", new AxeItem(DDTiers.RESONARIUM, new Item.Properties().attributes(AxeItem.createAttributes(DDTiers.RESONARIUM, 5, -3)).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_HOE = register("resonarium_hoe", new HoeItem(DDTiers.RESONARIUM, new Item.Properties().attributes(HoeItem.createAttributes(DDTiers.RESONARIUM, -4, 0)).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item RESONARIUM_SWORD = register("resonarium_sword", new SwordItem(DDTiers.RESONARIUM, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.RESONARIUM, 3, -2.4f)).rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item SCULK_TRANSMITTER = register("sculk_transmitter", new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Item SONOROUS_STAFF = register("sonorous_staff", new SonorousStaffItem(new Item.Properties().durability(320).rarity(Rarity.RARE)));

    public static final Item ANGLER_FISH_SPAWN_EGG = register("angler_fish_spawn_egg", new SpawnEggItem(DDEntities.ANGLER_FISH, 0x074857, 0x74faf3, new Item.Properties()));
    public static final Item SCULK_CENTIPEDE_SPAWN_EGG = register("sculk_centipede_spawn_egg", new SpawnEggItem(DDEntities.SCULK_CENTIPEDE, 0x1a2340, 0xded697, new Item.Properties()));
    public static final Item SCULK_LEECH_SPAWN_EGG = register("sculk_leech_spawn_egg", new SpawnEggItem(DDEntities.SCULK_LEECH, 0x152b38, 0x47e5ed, new Item.Properties()));
    public static final Item SCULK_SNAPPER_SPAWN_EGG = register("sculk_snapper_spawn_egg", new SpawnEggItem(DDEntities.SCULK_SNAPPER, 0xd1d6b6, 0x1d726f, new Item.Properties()));
    public static final Item SHATTERED_SPAWN_EGG = register("shattered_spawn_egg", new SpawnEggItem(DDEntities.SHATTERED, 0x0e181d, 0x819699, new Item.Properties()));
    public static final Item SHRIEK_WORM_SPAWN_EGG = register("shriek_worm_spawn_egg", new SpawnEggItem(DDEntities.SHRIEK_WORM, 0xd1d6b6, 0x009295, new Item.Properties()));
    public static final Item SLUDGE_SPAWN_EGG = register("sludge_spawn_egg", new SpawnEggItem(DDEntities.SLUDGE, 0x0f2824, 0x3ca195, new Item.Properties()));
    public static final Item STALKER_SPAWN_EGG = register("stalker_spawn_egg", new SpawnEggItem(DDEntities.STALKER, 0x172226, 0x6abdd9, new Item.Properties()));

    public static final Item ECHO_SIGN = register("echo_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.ECHO_SIGN, DDBlocks.ECHO_WALL_SIGN));
    public static final Item ECHO_HANGING_SIGN = register("echo_hanging_sign", new HangingSignItem(DDBlocks.ECHO_HANGING_SIGN, DDBlocks.ECHO_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BLOOM_SIGN = register("bloom_sign", new SignItem(new Item.Properties().stacksTo(16), DDBlocks.BLOOM_SIGN, DDBlocks.BLOOM_WALL_SIGN));
    public static final Item BLOOM_HANGING_SIGN = register("bloom_hanging_sign", new HangingSignItem(DDBlocks.BLOOM_HANGING_SIGN, DDBlocks.BLOOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));

    public static final Item BLOOM_BERRIES = register("bloom_berries", new ItemNameBlockItem(DDBlocks.GLOWING_VINES, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).effect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.8f).build())));

    public static final Item SHATTERED_HEAD = register("shattered_head", new StandingAndWallBlockItem(DDBlocks.SHATTERED_HEAD, DDBlocks.SHATTERED_WALL_HEAD, new Item.Properties().rarity(Rarity.UNCOMMON), Direction.DOWN));

    public static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, DeeperDarker.rl(id), item);
    }

    private static Item createWardenUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", DeeperDarker.rl("smithing_template.warden_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", DeeperDarker.rl("smithing_template.warden_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", DeeperDarker.rl("warden_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", DeeperDarker.rl("smithing_template.warden_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", DeeperDarker.rl("smithing_template.warden_upgrade.additions_slot_description"))),
                getWardenEmptyBaseSlotTextures(),
                getWardenEmptyAdditionsSlotTextures());
    }

    private static List<ResourceLocation> getWardenEmptyBaseSlotTextures() {
        return List.of(ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_hoe"));
    }

    private static List<ResourceLocation> getWardenEmptyAdditionsSlotTextures() {
        return List.of(DeeperDarker.rl("item/empty_slot_reinforced_echo_shard"));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering items");
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.ECHO_SAPLING.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.ECHO_LEAVES.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_FLOWERS.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_ROOTS.asItem(), 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BLOOM_BERRIES, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.SCULK_TENDRILS.asItem(), 0.5f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.GLOWING_GRASS.asItem(), 0.5f);
        CompostingChanceRegistry.INSTANCE.add(DDBlocks.SCULK_VINES.asItem(), 0.5f);
    }
}
