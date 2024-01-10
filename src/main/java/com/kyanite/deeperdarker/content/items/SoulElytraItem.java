package com.kyanite.deeperdarker.content.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DeeperDarkerConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SoulElytraItem extends ElytraItem {
    private final Multimap<Attribute, AttributeModifier> MODIFIERS;

    public SoulElytraItem(Properties pProperties) {
        super(pProperties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier("Soul Elytra armor", 3, AttributeModifier.Operation.ADDITION));
        this.MODIFIERS = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return slot == EquipmentSlot.CHEST ? this.MODIFIERS : super.getAttributeModifiers(slot, stack);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(DDItems.SOUL_CRYSTAL.get());
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(level.isClientSide() && player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA.get())) {
            float percent = player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA.get(), 0);
            player.displayClientMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.cooldown", (int) Math.ceil(percent * DeeperDarkerConfig.soulElytraCooldown / 20)), true);
        }
    }
}
