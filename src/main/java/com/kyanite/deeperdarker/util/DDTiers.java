package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum DDTiers implements Tier {
    LEAD(DDTags.Blocks.INCORRECT_FOR_LEAD_TOOL, 250, 6.0f, 2.0f, 14, () -> Ingredient.of(DDItems.LEAD_INGOT)),
    RADIOACTIVE(DDTags.Blocks.INCORRECT_FOR_RADIOACTIVE_TOOL, 1661, 8.0f, 4.0f, 11, () -> Ingredient.of(DDItems.RADIOACTIVE_INGOT)),
    RESONARIUM(DDTags.Blocks.INCORRECT_FOR_RESONARIUM_TOOL, 1193, 8, 3, 15, () -> Ingredient.of(DDItems.RESONARIUM)),
    WARDEN(DDTags.Blocks.INCORRECT_FOR_WARDEN_TOOL, 2519, 10.0f, 5.0f, 18, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD)),
    GUARDIAN(DDTags.Blocks.INCORRECT_FOR_GUARDIAN_TOOL, 11508, 11.0f, 7.0f, 22, () -> Ingredient.of(DDBlockItems.VIRTUE_SOUL));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int durability;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    DDTiers(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.durability = durability;
        this.speed = speed;
        this.damage = damage;
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
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
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
