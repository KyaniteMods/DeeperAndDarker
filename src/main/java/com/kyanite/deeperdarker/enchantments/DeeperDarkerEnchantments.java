package com.kyanite.deeperdarker.enchantments;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DeeperDarkerEnchantments {
    public static Enchantment CATALYSIS = register("catalysis", new CatalysisEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
    public static Enchantment SCULK_SMITE = register("sculk_smite", new SculkSmiteEnchantment(Enchantment.Rarity.UNCOMMON));

    private static Enchantment register(String id, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(DeeperDarker.MOD_ID, id), enchantment);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker enchantments");
    }
}
