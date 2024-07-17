package com.kyanite.deeperdarker.content.enchantments;

import com.kyanite.deeperdarker.content.entities.DDMobType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import org.jetbrains.annotations.NotNull;

public class SculkSmiteEnchantment extends DamageEnchantment {
    public SculkSmiteEnchantment(Rarity pRarity) {
        super(pRarity, 3, EquipmentSlot.MAINHAND);
    }

    @Override
    public float getDamageBonus(int pLevel, @NotNull MobType pCreatureType) {
        if(this.type == 3 && pCreatureType.equals(DDMobType.SCULK)) {
            return pLevel * 2.5f;
        }
        return super.getDamageBonus(pLevel, pCreatureType);
    }

    @Override
    public int getMinCost(int pEnchantmentLevel) {
        return pEnchantmentLevel * 8 - 3;
    }

    @Override
    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 20;
    }
}
