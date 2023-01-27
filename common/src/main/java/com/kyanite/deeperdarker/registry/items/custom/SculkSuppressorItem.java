package com.kyanite.deeperdarker.registry.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SculkSuppressorItem extends Item {
    public SculkSuppressorItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (!(livingEntity instanceof Player)) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                livingEntity.setSilent(true);
                if (livingEntity instanceof Mob) {
                    ((Mob)livingEntity).setPersistenceRequired();
                }

                itemStack.shrink(1);
            }

            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}