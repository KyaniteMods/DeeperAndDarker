package com.nitro.deeperdarker.util;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.registry.items.DDItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DDArmorMaterials implements ArmorMaterial {
    WARDEN_CARAPACE("warden_carapace", 45, new int[]{3, 6, 8, 3}, 21, SoundEvents.SCULK_BLOCK_PLACE, 3.0F, 0.5F, () -> Ingredient.of(DDItems.WARDEN_CARAPACE.get()));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    DDArmorMaterials(String name, int durability, int[] protections, int enchantment, SoundEvent event, float tough, float knockback, Supplier<Ingredient> ingredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.slotProtections = protections;
        this.enchantmentValue = enchantment;
        this.sound = event;
        this.toughness = tough;
        this.knockbackResistance = knockback;
        this.repairIngredient = ingredient;
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
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
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
