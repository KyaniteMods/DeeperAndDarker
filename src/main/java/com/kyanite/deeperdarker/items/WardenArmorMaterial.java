package com.kyanite.deeperdarker.items;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.HashMap;
import java.util.Map;

public class WardenArmorMaterial implements ArmorMaterial {
    Map<ArmorItem.Type, Integer> BASE_DURABILITY = new HashMap<>();
    Map<ArmorItem.Type, Integer> PROTECTION_VALUES = new HashMap<>();

    public WardenArmorMaterial() {
        BASE_DURABILITY.put(ArmorItem.Type.HELMET, 13);
        BASE_DURABILITY.put(ArmorItem.Type.CHESTPLATE, 15);
        BASE_DURABILITY.put(ArmorItem.Type.LEGGINGS, 16);
        BASE_DURABILITY.put(ArmorItem.Type.BOOTS, 11);

        PROTECTION_VALUES.put(ArmorItem.Type.HELMET, 3);
        PROTECTION_VALUES.put(ArmorItem.Type.CHESTPLATE, 6);
        PROTECTION_VALUES.put(ArmorItem.Type.LEGGINGS, 8);
        PROTECTION_VALUES.put(ArmorItem.Type.BOOTS, 3);
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY.get(type) * 40;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES.get(type);
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(DeeperDarkerItems.REINFORCED_ECHO_SHARD);
    }

    @Override
    public String getName() {
        return "warden";
    }

    @Override
    public float getToughness() {
        return 4.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}