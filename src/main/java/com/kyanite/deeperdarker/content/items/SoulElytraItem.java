package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DeeperDarkerConfig;
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
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NullableProblems")
public class SoulElytraItem extends ElytraItem {
    public SoulElytraItem(Properties pProperties) {
        super(pProperties);
    }

    public static ItemAttributeModifiers createAttributes() {
        ResourceLocation location = DeeperDarker.rl("armor.soul");
        return ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(location, 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST).build();
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(DDItems.SOUL_CRYSTAL.get());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pSlotId == 38 && pEntity instanceof Player player) {
            if(pLevel.isClientSide() && player.getCooldowns().isOnCooldown(DDItems.SOUL_ELYTRA.get())) {
                float percent = player.getCooldowns().getCooldownPercent(DDItems.SOUL_ELYTRA.get(), 0);
                player.displayClientMessage(Component.translatable("item." + DeeperDarker.MOD_ID + ".soul_elytra.cooldown", (int) Math.ceil(percent * DeeperDarkerConfig.soulElytraCooldown / 20)), true);
            }
        }
    }
}
