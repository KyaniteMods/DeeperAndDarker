package com.kyanite.deeperdarker.registry.enchantments;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DDEnchantments {
    public static void registerEnchantments() {
        RegistryHelper.registerEnchant("sculk_smite", () -> new SculkSmiteEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    }
}
