package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.enchantments.CatalysisEnchantment;
import com.kyanite.deeperdarker.content.enchantments.SculkSmiteEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DeeperDarker.MOD_ID);

    public static final RegistryObject<Enchantment> CATALYSIS = ENCHANTMENTS.register("catalysis", () -> new CatalysisEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> SCULK_SMITE = ENCHANTMENTS.register("sculk_smite", () -> new SculkSmiteEnchantment(Enchantment.Rarity.UNCOMMON));
}
