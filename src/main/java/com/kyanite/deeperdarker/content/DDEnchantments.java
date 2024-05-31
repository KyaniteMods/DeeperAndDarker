package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.enchantments.CatalysisEnchantment;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

public class DDEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, DeeperDarker.MOD_ID);

    public static final DeferredHolder<Enchantment, Enchantment> CATALYSIS = ENCHANTMENTS.register("catalysis", () -> new CatalysisEnchantment(
            Enchantment.definition(ItemTags.WEAPON_ENCHANTABLE, ItemTags.SWORD_ENCHANTABLE, 4, 3, Enchantment.dynamicCost(10, 20), Enchantment.dynamicCost(15, 30), 3, EquipmentSlot.MAINHAND)
    ));
    public static final DeferredHolder<Enchantment, Enchantment> SCULK_SMITE = ENCHANTMENTS.register("sculk_smite", () -> new DamageEnchantment(
            Enchantment.definition(ItemTags.WEAPON_ENCHANTABLE, ItemTags.SWORD_ENCHANTABLE, 5, 5, Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2, EquipmentSlot.MAINHAND), Optional.of(DDTags.Misc.SENSITIVE_TO_SCULK_SMITE)
    ));
}
