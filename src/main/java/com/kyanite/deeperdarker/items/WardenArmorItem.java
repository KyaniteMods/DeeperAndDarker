package com.kyanite.deeperdarker.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WardenArmorItem extends ArmorItem {
    public WardenArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack,
                                                                                    EquipmentSlot slot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = new ImmutableMultimap.Builder<>();

        if (stack.isOf(DeeperDarkerItems.WARDEN_LEGGINGS) && slot == EquipmentSlot.LEGS) {
            builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier("Warden leggings speed boost", 0.05, EntityAttributeModifier.Operation.ADDITION));
        }
        return builder.build();
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            if (user.getEquippedStack(EquipmentSlot.HEAD).isOf(DeeperDarkerItems.WARDEN_HELMET)) {
                if (user.hasStatusEffect(StatusEffects.BLINDNESS)) user.removeStatusEffect(StatusEffects.BLINDNESS);
                if (user.hasStatusEffect(StatusEffects.DARKNESS)) user.removeStatusEffect(StatusEffects.DARKNESS);
            }
        }
    }
}
