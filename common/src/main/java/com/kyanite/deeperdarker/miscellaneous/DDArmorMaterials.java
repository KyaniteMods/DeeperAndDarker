package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.paragon.api.ConfigOption;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DDArmorMaterials implements ArmorMaterial {
    WARDEN("warden", DDConfig.WARDEN_ARMOR_DURABILITY, new int[]{3, 6, 8, 3}, 21, SoundEvents.SCULK_BLOCK_PLACE, DDConfig.WARDEN_ARMOR_TOUGHNESS, DDConfig.WARDEN_ARMOR_KNOCKBACK_RESISTANCE, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final ConfigOption<Integer> durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final ConfigOption<Double> toughness;
    private final ConfigOption<Double> knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    DDArmorMaterials(String name, ConfigOption<Integer> durability, int[] protection, int enchantment, SoundEvent event, ConfigOption<Double> tough, ConfigOption<Double> knockback, Supplier<Ingredient> ingredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.slotProtections = protection;
        this.enchantmentValue = enchantment;
        this.sound = event;
        this.toughness = tough;
        this.knockbackResistance = knockback;
        this.repairIngredient = ingredient;
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier.get();
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
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
