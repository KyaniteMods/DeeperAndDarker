package com.kyanite.deeperdarker.enchantments;

import com.kyanite.deeperdarker.entities.DeeperDarkerEntityGroups;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;

public class SculkSmiteEnchantment extends DamageEnchantment {
    public SculkSmiteEnchantment(Rarity rarity) {
        super(rarity, 3, EquipmentSlot.MAINHAND);
    }

    @Override
    public float getAttackDamage(int pLevel, EntityGroup entityGroup) {
        if(this.typeIndex == 3 && entityGroup.equals(DeeperDarkerEntityGroups.SCULK)) {
            return pLevel * 2.5f;
        }
        return super.getAttackDamage(pLevel, entityGroup);
    }

    @Override
    public int getMinPower(int enchantmentLevel) {
        return 5 + (enchantmentLevel - 1) * 8;
    }

    @Override
    public int getMaxPower(int enchantmentLevel) {
        return this.getMinPower(enchantmentLevel) + 20;
    }
}