package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public enum DDTiers implements Tier {
    RESONARIUM(3, 1193, 8, 3, 15, DDItems.RESONARIUM.get()),
    WARDEN(5, 2519, 10, 5, 18, DDItems.REINFORCED_ECHO_SHARD.get());

    private final int level;
    private final int durability;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    DDTiers(int level, int durability, float speed, float damage, int enchantmentValue, ItemLike repairIngredient) {
        this.level = level;
        this.durability = durability;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Ingredient.of(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
