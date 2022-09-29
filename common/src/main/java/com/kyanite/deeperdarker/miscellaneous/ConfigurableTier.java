package com.kyanite.deeperdarker.miscellaneous;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class ConfigurableTier implements Tier {
    private final int level;
    private final ForgeConfigSpec.ConfigValue<Integer> uses;
    private final ForgeConfigSpec.ConfigValue<Double> speed;
    private final ForgeConfigSpec.ConfigValue<Double> attackDamageBonus;
    private final int enchantmentValue;
    private final @NotNull TagKey<Block> tag;
    private final @NotNull Supplier<Ingredient> repairIngredient;

    public ConfigurableTier(int level, ForgeConfigSpec.ConfigValue<Integer> uses, ForgeConfigSpec.ConfigValue<Double> speed, ForgeConfigSpec.ConfigValue<Double> attackDamageBonus, int enchantmentValue, @NotNull TagKey<Block> tag, @NotNull Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.tag = tag;
        this.repairIngredient = repairIngredient;
    }

    public int getUses() {
        return this.uses.get();
    }

    public float getSpeed() {
        return this.speed.get().floatValue();
    }

    public float getAttackDamageBonus() {
        return this.attackDamageBonus.get().floatValue();
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull TagKey<Block> getTag() {
        return this.tag;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }

    public String toString() {
        return "ForgeTier[level=" + this.level + ", uses=" + this.uses + ", speed=" + this.speed + ", attackDamageBonus=" + this.attackDamageBonus + ", enchantmentValue=" + this.enchantmentValue + ", tag=" + this.tag + ", repairIngredient=" + this.repairIngredient + "]";
    }
}
