package com.kyanite.deeperdarker.registry.enchantments;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DeeperAndDarker.MOD_ID);

    public static RegistryObject<Enchantment> SCULK_SMITE = ENCHANTMENTS.register("sculk_smite", () -> new SculkSmiteEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
}
