package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WardenArmorItem extends ArmorItem {
    public WardenArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = new ImmutableMultimap.Builder<>();

        if(stack.is(DDItems.WARDEN_LEGGINGS.get()) && slot == EquipmentSlot.LEGS) {
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier("Warden leggings speed boost", 0.05, AttributeModifier.Operation.ADDITION));
        }
        return builder.build();
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide()) {
            if(stack.getEquipmentSlot() == EquipmentSlot.HEAD) {
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
