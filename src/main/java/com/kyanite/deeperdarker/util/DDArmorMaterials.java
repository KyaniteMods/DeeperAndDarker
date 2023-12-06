package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

@SuppressWarnings("NullableProblems")
public enum DDArmorMaterials implements ArmorMaterial {
    WARDEN("warden", 40, Util.make(new EnumMap<>(EquipmentSlot.class), protectionValue -> {
        protectionValue.put(EquipmentSlot.FEET, 4);
        protectionValue.put(EquipmentSlot.LEGS, 7);
        protectionValue.put(EquipmentSlot.CHEST, 9);
        protectionValue.put(EquipmentSlot.HEAD, 4);
    }), 18, SoundEvents.ARMOR_EQUIP_NETHERITE, 4, 0.1f, Ingredient.of(DDItems.REINFORCED_ECHO_SHARD));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<EquipmentSlot, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;
    private static final EnumMap<EquipmentSlot, Integer> DURABILITY_FOR_TYPE = Util.make(new EnumMap<>(EquipmentSlot.class), (durabilityValue) -> {
        durabilityValue.put(EquipmentSlot.FEET, 13);
        durabilityValue.put(EquipmentSlot.LEGS, 15);
        durabilityValue.put(EquipmentSlot.CHEST, 16);
        durabilityValue.put(EquipmentSlot.HEAD, 11);
    });

    DDArmorMaterials(String name, int durability, EnumMap<EquipmentSlot, Integer> protection, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.protectionFunctionForType = protection;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABILITY_FOR_TYPE.get(slot) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protectionFunctionForType.get(slot);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
