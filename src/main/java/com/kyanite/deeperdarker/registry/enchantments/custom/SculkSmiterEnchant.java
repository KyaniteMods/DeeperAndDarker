package com.kyanite.deeperdarker.registry.enchantments.custom;

import com.kyanite.deeperdarker.util.DDMobTypes;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SculkSmiterEnchant extends Enchantment {
    public SculkSmiterEnchant(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        return mobType == DDMobTypes.SCULK ? 10F : 0.0F;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
