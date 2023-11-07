package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.util.DDConfig;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HeartOfTheDeepItem extends Item {
    public HeartOfTheDeepItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pItemStack, Level pLevel, Entity pEntity, int i, boolean bl) {
        if(RandomSource.create().nextFloat() < 0.012f && DDConfig.HANDLER.instance().wardenHeartPulses) {
            pEntity.playSound(SoundEvents.WARDEN_HEARTBEAT, 1.7f, 1f);
        }
    }
}
