package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.Multimap;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public interface ShieldAugmentItem {
    void onShieldDefended(LivingEntity entity, DamageSource source, float amount);
    Optional<Multimap<Attribute, AttributeModifier>> getAugmentAttributeModifiers(EquipmentSlot equipmentSlot, boolean defending);
    void onAugmentAdded(ItemStack shield, ItemStack previousStack, Slot slot, Player player);
    void onAugmentRemoved(ItemStack shield, Slot slot, Player player);
}
