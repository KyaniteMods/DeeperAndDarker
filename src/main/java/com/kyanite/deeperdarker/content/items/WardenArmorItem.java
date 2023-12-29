package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WardenArmorItem extends ArmorItem {
    private final Multimap<Attribute, AttributeModifier> LEGGINGS_MODIFIERS;

    public WardenArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier("Armor modifier", material.getDefenseForType(type), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier("Armor toughness", material.getToughness(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier("Armor knockback resistance", this.knockbackResistance, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier("Leggings speed boost", 0.05, AttributeModifier.Operation.ADDITION));
        this.LEGGINGS_MODIFIERS = builder.build();
    }

    @NotNull
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return this == DDItems.WARDEN_LEGGINGS && slot == EquipmentSlot.LEGS ? this.LEGGINGS_MODIFIERS : super.getDefaultAttributeModifiers(slot);
    }


    @Override
    public void onUseTick(Level level, LivingEntity user, ItemStack itemStack, int i) {
        if (!level.isClientSide()) {
            if (user.getItemBySlot(EquipmentSlot.HEAD).is(DDItems.WARDEN_HELMET)) {
                if (user.hasEffect(MobEffects.BLINDNESS)) user.removeEffect(MobEffects.BLINDNESS);
                if (user.hasEffect(MobEffects.DARKNESS)) user.removeEffect(MobEffects.DARKNESS);
            }
        }
    }
}
