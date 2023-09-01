package com.kyanite.deeperdarker.content.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.world.effect.MobEffects.CONFUSION;

public class WardenStaffItem extends Item {

    public WardenStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> interactionResultHolder(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        player.getCooldowns().addCooldown(this, 3);
        if (!level.isClientSide) {
            player.addEffect(new MobEffectInstance(CONFUSION, 200, 0));
            return InteractionResultHolder.success(itemStack); // TODO: Add Sonic Boom effect
        }
        return InteractionResultHolder.success(itemStack);
    }

}
