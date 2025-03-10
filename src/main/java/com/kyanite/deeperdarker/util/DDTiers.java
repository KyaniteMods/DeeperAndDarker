package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum DDTiers implements Tier {
    RESONARIUM(1193, 8, 3, DDTags.Blocks.INCORRECT_FOR_RESONARIUM_TOOL, 13, () -> Ingredient.of(DDItems.RESONARIUM.get())),
    WARDEN(2519, 10, 5, DDTags.Blocks.INCORRECT_FOR_WARDEN_TOOL, 18, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()));

    private final int durability;
    private final float speed;
    private final float damage;
    private final TagKey<Block> incorrectBlocks;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    DDTiers(int durability, float speed, float damage, TagKey<Block> incorrectBlocks, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.durability = durability;
        this.speed = speed;
        this.damage = damage;
        this.incorrectBlocks = incorrectBlocks;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
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
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocks;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
