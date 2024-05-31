package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("NullableProblems")
public class WardenArmorItem extends ArmorItem {
    private final Multimap<Attribute, AttributeModifier> LEGGINGS_MODIFIERS;

    public WardenArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR.value(), new AttributeModifier("Armor modifier", material.value().getDefense(type), AttributeModifier.Operation.ADD_VALUE));
        builder.put(Attributes.ARMOR_TOUGHNESS.value(), new AttributeModifier("Armor toughness", material.value().toughness(), AttributeModifier.Operation.ADD_VALUE));
        builder.put(Attributes.KNOCKBACK_RESISTANCE.value(), new AttributeModifier("Armor knockback resistance", material.value().knockbackResistance(), AttributeModifier.Operation.ADD_VALUE));
        builder.put(Attributes.MOVEMENT_SPEED.value(), new AttributeModifier("Leggings speed boost", 0.05, AttributeModifier.Operation.ADD_VALUE));
        this.LEGGINGS_MODIFIERS = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return stack.is(DDItems.WARDEN_LEGGINGS.get()) && slot == EquipmentSlot.LEGS ? this.LEGGINGS_MODIFIERS : super.getAttributeModifiers(slot, stack);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity instanceof ServerPlayer player) {
            if(pStack.getEquipmentSlot() == EquipmentSlot.HEAD) {
                if(player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
                if(player.hasEffect(MobEffects.DARKNESS)) player.removeEffect(MobEffects.DARKNESS);
            }
        }
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return this.type.getSlot();
    }
}
