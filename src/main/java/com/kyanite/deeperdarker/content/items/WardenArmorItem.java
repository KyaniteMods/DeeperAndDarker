package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WardenArmorItem extends ArmorItem {
    private final Multimap<Attribute, AttributeModifier> LEGGINGS_MODIFIERS;
    private final List<MobEffect> immunities;

    public WardenArmorItem(ArmorMaterial material, Type type, Properties properties) {
        this(material, type, properties, List.of());
    }

    public WardenArmorItem(ArmorMaterial material, Type type, Properties properties, List<MobEffect> immunities) {
        super(material, type, properties);
        this.immunities = immunities;

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
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemStack, level, entity, slot, selected);
        if (!level.isClientSide() && entity instanceof LivingEntity user) {
            if (this.getEquipmentSlot().getIndex() == slot) {
                this.immunities.forEach(user::removeEffect);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        if (!this.immunities.isEmpty()) {
            list.add(Component.translatable("item." + DeeperDarker.MOD_ID + ".perks.immunity").withStyle(ChatFormatting.GRAY));
            for (MobEffect effect : this.immunities) {
                list.add(effect.getDisplayName().copy().withStyle(ChatFormatting.GREEN));
            }
        }
    }
}
