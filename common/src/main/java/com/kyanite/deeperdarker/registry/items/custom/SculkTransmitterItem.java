package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.registry.entities.custom.projectiles.ShriekProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class SculkTransmitterItem extends Item {
    public SculkTransmitterItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.getCooldowns().addCooldown(this, 15);

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
