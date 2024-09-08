package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.util.DDSonicBooms;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WardenStaffItem extends Item {
    public WardenStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> interactionResultHolder(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        player.getCooldowns().addCooldown(this, (DDSonicBooms.cooldown * 20));
        if (!level.isClientSide) {
            DDSonicBooms.sonicBoom((ServerLevel) level, player);
        }
        return InteractionResultHolder.success(itemStack);
    }
}
