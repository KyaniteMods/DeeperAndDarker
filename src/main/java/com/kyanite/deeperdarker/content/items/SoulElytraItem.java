package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.DeeperDarkerConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;

@SuppressWarnings("NullableProblems")
public class SoulElytraItem extends Item {
    public SoulElytraItem(Properties properties) {
        super(properties);
    }

    public static Equippable equipableComponent() {
        return Equippable.builder(EquipmentSlot.CHEST)
                .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                .setAsset(EquipmentAssets.ELYTRA)
                .setDamageOnHurt(false)
                .build();
    }

    public static ItemAttributeModifiers attributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(DeeperDarker.rl("armor.soul"), 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
                .build();
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, EquipmentSlot slot) {
        if(level.isClientSide() && owner instanceof Player player && slot == EquipmentSlot.CHEST) {
            if(player.getCooldowns().isOnCooldown(itemStack)) {
                float percent = player.getCooldowns().getCooldownPercent(itemStack, 0);
                player.sendOverlayMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.cooldown", (int) Math.ceil(percent * DeeperDarkerConfig.CONFIG.soulElytraCooldown.get() / 20)));
            }
        }
    }
}
