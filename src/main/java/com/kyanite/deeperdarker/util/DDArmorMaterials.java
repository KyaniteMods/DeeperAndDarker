package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.EnumMap;

@SuppressWarnings("NullableProblems")
public enum DDArmorMaterials implements ArmorMaterial {
    RESONARIUM("resonarium", 30, new int[] {2, 6, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1, 0, DDItems.RESONARIUM),
    WARDEN("warden", 40, new int[] {4, 7, 9, 4}, 18, SoundEvents.ARMOR_EQUIP_NETHERITE, 4, 0.1f, DDItems.REINFORCED_ECHO_SHARD);

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> defensePoints;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;
    private static final EnumMap<ArmorItem.Type, Integer> DURABILITY_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });

    DDArmorMaterials(String name, int durability, int[] defensePoints, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, ItemLike repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.defensePoints = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, defensePoints[0]);
            map.put(ArmorItem.Type.LEGGINGS, defensePoints[1]);
            map.put(ArmorItem.Type.CHESTPLATE, defensePoints[2]);
            map.put(ArmorItem.Type.HELMET, defensePoints[3]);
        });
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Ingredient.of(repairIngredient);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.defensePoints.get(type);
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
