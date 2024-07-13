package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.*;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class DDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeeperDarker.MOD_ID);

    public static final DeferredItem<Item> ICE_LILY = ITEMS.register("ice_lily", () -> new PlaceOnWaterBlockItem(DDBlocks.ICE_LILY.get(), new Item.Properties()));
    public static final DeferredItem<Item> ECHO_SIGN = ITEMS.register("echo_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DDBlocks.ECHO_SIGN.get(), DDBlocks.ECHO_WALL_SIGN.get()));
    public static final DeferredItem<Item> ECHO_HANGING_SIGN = ITEMS.register("echo_hanging_sign", () -> new HangingSignItem(DDBlocks.ECHO_HANGING_SIGN.get(), DDBlocks.ECHO_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> BLOOM_SIGN = ITEMS.register("bloom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DDBlocks.BLOOM_SIGN.get(), DDBlocks.BLOOM_WALL_SIGN.get()));
    public static final DeferredItem<Item> BLOOM_HANGING_SIGN = ITEMS.register("bloom_hanging_sign", () -> new HangingSignItem(DDBlocks.BLOOM_HANGING_SIGN.get(), DDBlocks.BLOOM_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> BLOOM_BERRIES = ITEMS.register("bloom_berries", () -> new ItemNameBlockItem(DDBlocks.GLOWING_VINES.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.8f).build())));

    public static final DeferredItem<Item> GRIME_BALL = ITEMS.registerSimpleItem("grime_ball");
    public static final DeferredItem<Item> GRIME_BRICK = ITEMS.registerSimpleItem("grime_brick");

    public static final DeferredItem<Item> SOUL_ELYTRA = ITEMS.register("soul_elytra", () -> new SoulElytraItem(new Item.Properties().durability(956).rarity(Rarity.UNCOMMON).attributes(SoulElytraItem.createAttributes())));
    public static final DeferredItem<Item> ECHO_BOAT = ITEMS.register("echo_boat", () -> new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBlocks.ECHO));
    public static final DeferredItem<Item> ECHO_CHEST_BOAT = ITEMS.register("echo_chest_boat", () -> new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBlocks.ECHO));
    public static final DeferredItem<Item> BLOOM_BOAT = ITEMS.register("bloom_boat", () -> new DDBoatItem(false, new Item.Properties().stacksTo(1), DDBlocks.BLOOM));
    public static final DeferredItem<Item> BLOOM_CHEST_BOAT = ITEMS.register("bloom_chest_boat", () -> new DDBoatItem(true, new Item.Properties().stacksTo(1), DDBlocks.BLOOM));

    public static final DeferredItem<Item> SCULK_BONE = ITEMS.registerSimpleItem("sculk_bone");
    public static final DeferredItem<Item> SOUL_DUST = ITEMS.registerSimpleItem("soul_dust");
    public static final DeferredItem<Item> SOUL_CRYSTAL = ITEMS.registerSimpleItem("soul_crystal");
    public static final DeferredItem<Item> HEART_OF_THE_DEEP = ITEMS.register("heart_of_the_deep", () -> new WardenHeartItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> REINFORCED_ECHO_SHARD = ITEMS.register("reinforced_echo_shard", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final DeferredItem<Item> WARDEN_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("warden_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade." + DeeperDarker.MOD_ID + ".warden_upgrade").withStyle(ChatFormatting.GRAY),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.base_slot_description"),
            Component.translatable("item." + DeeperDarker.MOD_ID + ".smithing_template.warden_upgrade.additions_slot_description"),
            SmithingTemplateItem.createNetheriteUpgradeIconList(), List.of(DeeperDarker.rl("item/empty_slot_shard"))
    ));

    public static final DeferredItem<Item> WARDEN_SHOVEL = ITEMS.register("warden_shovel", () -> new ShovelItem(DDTiers.WARDEN, new Item.Properties().attributes(ShovelItem.createAttributes(DDTiers.WARDEN, 1.5f, -3)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> WARDEN_PICKAXE = ITEMS.register("warden_pickaxe", () -> new PickaxeItem(DDTiers.WARDEN, new Item.Properties().attributes(PickaxeItem.createAttributes(DDTiers.WARDEN, 1, -2.8f)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> WARDEN_AXE = ITEMS.register("warden_axe", () -> new AxeItem(DDTiers.WARDEN, new Item.Properties().attributes(AxeItem.createAttributes(DDTiers.WARDEN, 5, -3)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> WARDEN_HOE = ITEMS.register("warden_hoe", () -> new HoeItem(DDTiers.WARDEN, new Item.Properties().attributes(HoeItem.createAttributes(DDTiers.WARDEN, -4, 0)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> WARDEN_SWORD = ITEMS.register("warden_sword", () -> new SwordItem(DDTiers.WARDEN, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 3, -2.4f)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> WARDEN_HELMET = ITEMS.register("warden_helmet", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40))));
    public static final DeferredItem<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredItem<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE).fireResistant().attributes(WardenArmorItem.createAttributes()).durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredItem<Item> WARDEN_BOOTS = ITEMS.register("warden_boots", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40))));

    public static final DeferredItem<Item> SCULK_TRANSMITTER = ITEMS.register("sculk_transmitter", () -> new SculkTransmitterItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final DeferredItem<Item> SONOROUS_STAFF = ITEMS.register("sonorous_staff", () -> new SonorousStaffItem(new Item.Properties().durability(320).rarity(Rarity.RARE)));

    public static final DeferredItem<Item> ANGLER_FISH_SPAWN_EGG = ITEMS.register("angler_fish_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.ANGLER_FISH, 0x074857, 0x74faf3, new Item.Properties()));
    public static final DeferredItem<Item> SCULK_CENTIPEDE_SPAWN_EGG = ITEMS.register("sculk_centipede_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.SCULK_CENTIPEDE, 0x1a2340, 0xded697, new Item.Properties()));
    public static final DeferredItem<Item> SCULK_LEECH_SPAWN_EGG = ITEMS.register("sculk_leech_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.SCULK_LEECH, 0x152b38, 0x47e5ed, new Item.Properties()));
    public static final DeferredItem<Item> SCULK_SNAPPER_SPAWN_EGG = ITEMS.register("sculk_snapper_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.SCULK_SNAPPER, 0xd1d6b6, 0x1d726f, new Item.Properties()));
    public static final DeferredItem<Item> SHATTERED_SPAWN_EGG = ITEMS.register("shattered_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.SHATTERED, 0x0e181d, 0x819699, new Item.Properties()));
    public static final DeferredItem<Item> SHRIEK_WORM_SPAWN_EGG = ITEMS.register("shriek_worm_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.SHRIEK_WORM, 0xd1d6b6, 0x009295, new Item.Properties()));
    public static final DeferredItem<Item> STALKER_SPAWN_EGG = ITEMS.register("stalker_spawn_egg", () -> new DeferredSpawnEggItem(DDEntities.STALKER, 0x172226, 0x6abdd9, new Item.Properties()));
}
