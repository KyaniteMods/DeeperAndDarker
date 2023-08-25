package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.enchantments.CatalysisEnchantment;
import com.kyanite.deeperdarker.content.enchantments.SculkSmiteEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class DDEnchantments {
    public static final Enchantment CATALYSIS = register("catalysis", new CatalysisEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
    public static final Enchantment SCULK_SMITE = register("sculk_smite", new SculkSmiteEnchantment(Enchantment.Rarity.UNCOMMON));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering enchantments");
    }

    private static Enchantment register(String id, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new ResourceLocation(DeeperDarker.MOD_ID, id), enchantment);
    }
}
