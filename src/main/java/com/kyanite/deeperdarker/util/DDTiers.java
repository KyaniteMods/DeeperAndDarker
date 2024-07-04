package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public enum DDTiers implements Tier {
    RESONARIUM(DDTags.Blocks.INCORRECT_FOR_RESONARIUM_TOOL, 1193, 8, 3, 15, DDItems.RESONARIUM),
    WARDEN(DDTags.Blocks.INCORRECT_FOR_WARDEN_TOOL, 2519, 10.0f, 5.0f, 18, DDItems.REINFORCED_ECHO_SHARD);

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int durability;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    DDTiers(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float damage, int enchantmentValue, ItemLike repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
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
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
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
