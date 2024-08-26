package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import java.util.List;

public class WardenArmorItem extends ArmorItem {
    private final List<Holder<MobEffect>> immunities;

    public WardenArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        this(material, type, properties, List.of());
    }

    public WardenArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, List<Holder<MobEffect>> immunities) {
        super(material, type, properties);
        this.immunities = immunities;
    }

    public static ItemAttributeModifiers createAttributes() {
        ResourceLocation location = DeeperDarker.rl("armor.warden");
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(location, DDArmorMaterials.WARDEN.value().getDefense(Type.LEGGINGS), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
                .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(location, DDArmorMaterials.WARDEN.value().toughness(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
                .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(location, DDArmorMaterials.WARDEN.value().knockbackResistance(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
                .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(location, 0.05, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS).build();
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
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, list, tooltipFlag);
        if (!this.immunities.isEmpty()) {
            list.add(Component.translatable("item." + DeeperDarker.MOD_ID + ".perks.immunity").withStyle(ChatFormatting.GRAY));
            for (Holder<MobEffect> effect : this.immunities) {
                list.add(effect.value().getDisplayName().copy().withStyle(ChatFormatting.GREEN));
            }
        }
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, Holder<Enchantment> enchantment, EnchantingContext context) {
        return super.canBeEnchantedWith(stack, enchantment, context);
    }
}
