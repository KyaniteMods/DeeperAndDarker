package com.kyanite.deeperdarker.registry.enchantments;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.function.Supplier;

public class DDEnchantments {
    public static Supplier<Enchantment> catalysisEnchant;
    public static void registerEnchantments() {
        RegistryHelper.registerEnchant("sculk_smite", () -> new SculkSmiteEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
        catalysisEnchant = RegistryHelper.registerEnchant("catalysis", () -> new CatalysisEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    }
}
