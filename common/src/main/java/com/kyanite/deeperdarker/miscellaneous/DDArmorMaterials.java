package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.paragon.api.ConfigOption;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum DDArmorMaterials implements ArmorMaterial {
    WARDEN("warden", DDConfig.WARDEN_ARMOR_DURABILITY, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 3);
        enumMap.put(ArmorItem.Type.LEGGINGS, 6);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 8);
        enumMap.put(ArmorItem.Type.HELMET, 3);
    }), 21, SoundEvents.SCULK_BLOCK_PLACE, DDConfig.WARDEN_ARMOR_TOUGHNESS, DDConfig.WARDEN_ARMOR_KNOCKBACK_RESISTANCE, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 13);
        enumMap.put(ArmorItem.Type.LEGGINGS, 15);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 16);
        enumMap.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final ConfigOption<Integer> durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final ConfigOption<Float> toughness;
    private final ConfigOption<Float> knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    DDArmorMaterials(String name, ConfigOption<Integer> durability, EnumMap<ArmorItem.Type, Integer> slotProtections, int enchantmentValue, SoundEvent soundEvent, ConfigOption<Float> toughness, ConfigOption<Float> knockbackResistance, Supplier<Ingredient> ingredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.protectionFunctionForType = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = ingredient;
    }

    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier.get();
    }

    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return DeeperAndDarker.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness.get().floatValue();
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance.get().floatValue();
    }
}
