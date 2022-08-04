package com.kyanite.deeperdarker.registry.enchantments;

import com.kyanite.deeperdarker.util.DDMobTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SculkSmiteEnchant extends Enchantment {
    public SculkSmiteEnchant(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
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
