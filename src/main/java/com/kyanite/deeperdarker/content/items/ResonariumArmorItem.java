package com.kyanite.deeperdarker.content.items;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

public class ResonariumArmorItem extends ArmorItem {
    public ResonariumArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack pStack) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) &&
                enchantment != Enchantments.ALL_DAMAGE_PROTECTION &&
                enchantment != Enchantments.FIRE_PROTECTION &&
                enchantment != Enchantments.BLAST_PROTECTION &&
                enchantment != Enchantments.PROJECTILE_PROTECTION &&
                enchantment != Enchantments.MENDING;
    }
}
