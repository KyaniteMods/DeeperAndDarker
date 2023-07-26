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

import java.util.UUID;

public class WardenArmorItem extends ArmorItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> LEGGINGS_MODIFIERS;

    public WardenArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D");
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "Armor modifier", material.getProtection(type), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uuid, "Armor toughness", material.getToughness(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(uuid, "Armor knockback resistance", this.knockbackResistance, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier("Leggings speed boost", 0.05, EntityAttributeModifier.Operation.ADDITION));
        this.LEGGINGS_MODIFIERS = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack,
                                                                                    EquipmentSlot slot) {
        return stack.isOf(DeeperDarkerItems.WARDEN_LEGGINGS) && slot == EquipmentSlot.LEGS ? this.LEGGINGS_MODIFIERS : super.getAttributeModifiers(stack, slot);
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
