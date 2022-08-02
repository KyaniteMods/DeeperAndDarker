package com.kyanite.deeperdarker.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DDGenericUtils {
    public static void drop(ItemStack itemStack, BlockPos pos, Level level) {
        if (!itemStack.isEmpty()) {
            ItemEntity itementity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
            level.addFreshEntity(itementity);
        }
    }

}
