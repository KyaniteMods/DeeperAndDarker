package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class SoulElytraItem extends ElytraItem {
    public SoulElytraItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        ResourceLocation location = DeeperDarker.rl("armor.soul");
        return ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(location, 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST).build();
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(DDItems.SOUL_CRYSTAL.get());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(level.isClientSide() && entity instanceof Player player && slotId == 38) {
            if(player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA.get())) {
                float percent = player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA.get(), 0);
                player.displayClientMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.cooldown", (int) Math.ceil(percent * DeeperDarkerConfig.soulElytraCooldown / 20)), true);
            }
        }
    }
}
