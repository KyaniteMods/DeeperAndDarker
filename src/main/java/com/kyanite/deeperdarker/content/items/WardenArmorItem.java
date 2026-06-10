package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;

@SuppressWarnings("NullableProblems")
public class WardenArmorItem extends Item {
    public WardenArmorItem(Properties properties, ArmorMaterial material, ArmorType type) {
        super(humanoidArmor(properties, material, type));
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, EquipmentSlot slot) {
        if(owner instanceof ServerPlayer player) {
            if(slot == EquipmentSlot.HEAD) {
                if(player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
                if(player.hasEffect(MobEffects.DARKNESS)) player.removeEffect(MobEffects.DARKNESS);
            }
        }
    }

    private static Item.Properties humanoidArmor(Item.Properties properties, ArmorMaterial material, ArmorType type) {
        return properties.durability(type.getDurability(material.durability()))
                .attributes(createAttributes(material, type))
                .enchantable(material.enchantmentValue())
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot()).setEquipSound(material.equipSound()).setAsset(material.assetId()).build())
                .repairable(material.repairIngredient());
    }

    private static ItemAttributeModifiers createAttributes(ArmorMaterial material, ArmorType type) {
        int defense = material.defense().getOrDefault(type, 0);
        ItemAttributeModifiers.Builder modifiers = ItemAttributeModifiers.builder();
        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
        Identifier modifierId = DeeperDarker.rl("armor." + type.getName());

        modifiers.add(Attributes.ARMOR, new AttributeModifier(modifierId, defense, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        modifiers.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(modifierId, material.toughness(), AttributeModifier.Operation.ADD_VALUE), slotGroup);
        if(material.knockbackResistance() > 0f) {
            modifiers.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(modifierId, material.knockbackResistance(), AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if(type == ArmorType.LEGGINGS) {
            modifiers.add(Attributes.MOVEMENT_SPEED, new AttributeModifier(modifierId, 0.05, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }

        return modifiers.build();
    }
}
