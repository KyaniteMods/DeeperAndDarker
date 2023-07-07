package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

@SuppressWarnings("NullableProblems")
public enum DDArmorMaterials implements ArmorMaterial {
    WARDEN("warden", 40, Util.make(new EnumMap<>(ArmorItem.Type.class), protectionValue -> {
        protectionValue.put(ArmorItem.Type.BOOTS, 3);
        protectionValue.put(ArmorItem.Type.LEGGINGS, 6);
        protectionValue.put(ArmorItem.Type.CHESTPLATE, 8);
        protectionValue.put(ArmorItem.Type.HELMET, 3);
    }), 18, SoundEvents.ARMOR_EQUIP_NETHERITE, 4, 0.1f, Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;
    private static final EnumMap<ArmorItem.Type, Integer> DURABILITY_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (durabilityValue) -> {
        durabilityValue.put(ArmorItem.Type.BOOTS, 13);
        durabilityValue.put(ArmorItem.Type.LEGGINGS, 15);
        durabilityValue.put(ArmorItem.Type.CHESTPLATE, 16);
        durabilityValue.put(ArmorItem.Type.HELMET, 11);
    });

    DDArmorMaterials(String name, int durability, EnumMap<ArmorItem.Type, Integer> protection, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
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
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
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
        return DeeperDarker.MOD_ID + ":" + this.name;
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
