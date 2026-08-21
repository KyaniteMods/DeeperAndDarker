package com.kyanite.deeperdarker.content.entities;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Overcaster extends Illusioner {
    private final ServerBossEvent bossEvent = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.NOTCHED_20).setDarkenScreen(true);

    public Overcaster(EntityType<? extends Illusioner> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createOvercasterAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 40).add(Attributes.ARMOR, 15).add(Attributes.ARMOR_TOUGHNESS, 7).add(Attributes.FOLLOW_RANGE, 100).add(Attributes.ATTACK_KNOCKBACK, 10.0).add(Attributes.KNOCKBACK_RESISTANCE, 10.0).build();
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float f) {
        ItemStack itemStack = getProjectile(getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
        AbstractArrow abstractArrow = ProjectileUtil.getMobArrow(this, itemStack, f);
        if (abstractArrow instanceof Arrow arrow) {
            arrow.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600));
        }
        double dx = livingEntity.getX() - getX();
        double dy = livingEntity.getY(1.0 / 3.0) - abstractArrow.getY();
        double dz = livingEntity.getZ() - getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);
        abstractArrow.shoot(dx, dy + distance * 0.2F, dz, 1.6F, 14 - level().getDifficulty().getId() * 4);
        playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        level().addFreshEntity(abstractArrow);
    }

    @Override
    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        bossEvent.setName(getDisplayName());
    }

    @Override
    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        bossEvent.addPlayer(serverPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        bossEvent.removePlayer(serverPlayer);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
    }
}
