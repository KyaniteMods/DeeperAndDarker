package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class SoulElytraItem extends ElytraItem implements Wearable {
    private final Multimap<Attribute, AttributeModifier> MODIFIERS;

    public SoulElytraItem(Properties pProperties) {
        super(pProperties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier("Soul Elytra armor", 3, AttributeModifier.Operation.ADDITION));
        this.MODIFIERS = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return slot == EquipmentSlot.CHEST ? this.MODIFIERS : super.getAttributeModifiers(slot, stack);
    }

    public static boolean isFlyEnabled(ItemStack pElytra) {
        return pElytra.getDamageValue() < pElytra.getMaxDamage() - 1;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(DDItems.SOUL_CRYSTAL.get());
    }

    @Override
    public boolean canElytraFly(@NotNull ItemStack stack, LivingEntity entity) {
        return isFlyEnabled(stack);
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level.isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(1, entity, (e) -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
                }
                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }
}
