package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.entities.custom.projectiles.ShriekProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SculkTransmitterItem extends Item {
    public SculkTransmitterItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.getCooldowns().addCooldown(this, DDConfig.TRANSMITTER_COOLDOWN.get());

        if (!level.isClientSide()) {
            ShriekProjectile abstractarrowentity = new ShriekProjectile(level, player);
            abstractarrowentity.shootFromRotation(player, player.getXRot(), player.getYRot(),
                    0.0F, 1.0F * 5.0F, 1.0F);

            abstractarrowentity.tickCount = 35;
            abstractarrowentity.isNoGravity();

            level.addFreshEntity(abstractarrowentity);
            player.playSound(SoundEvents.WARDEN_SONIC_BOOM, 3.0F, 1.0F);
        }
        return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
    }
}
