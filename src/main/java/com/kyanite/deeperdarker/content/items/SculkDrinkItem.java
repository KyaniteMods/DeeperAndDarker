package com.kyanite.deeperdarker.content.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class SculkDrinkItem extends Item {
    public SculkDrinkItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            player.eat(level, itemStack);
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }
        if (itemStack.isEmpty()) {
            return new ItemStack(Items.BUCKET);
        }
        return itemStack;
    }

    public int getUseDuration(ItemStack itemStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }
}
