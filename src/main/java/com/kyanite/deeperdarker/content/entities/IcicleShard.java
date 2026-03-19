package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IcicleShard extends AbstractArrow {
    public static final float HIT_DAMAGE = 8.0f;
    public static final float TOUCH_DAMAGE = 6.0f;

    public IcicleShard(EntityType<? extends IcicleShard> entityType, Level level) {
        super(entityType, level);
    }

    public IcicleShard(double d, double e, double f, Level level) {
        super(DDEntities.ICICLE_SHARD, d, e, f, level);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();
        if (inGround) {
            List<LivingEntity> list = level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(0.0625), this::canTouchDamageEntity);
            if (!list.isEmpty()) {
                boolean hit = false;
                for (LivingEntity livingEntity : list) {
                    if (applyDamage(livingEntity, null, TOUCH_DAMAGE)) hit = true;
                }
                if (hit) {
                    playSound(getTouchDamageSoundEvent(), 1.0f, 1.0f);
                    discard();
                    return;
                }
            }
        }
        if (inGroundTime > 400) {
            discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Entity owner = getOwner();
        if (applyDamage(entity, owner, HIT_DAMAGE)) {
            playSound(getHitDamageSoundEvent(), 1.0f, 1.0f);
            discard();
        }
    }

    public boolean applyDamage(Entity entity, Entity owner, float damage) {
        DamageSource damageSource = damageSources().source(DDDamageTypes.ICICLE, this, owner == null ? this : owner);
        if (entity.hurt(damageSource, damage)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return false;
            }
            if (entity instanceof LivingEntity livingEntity) {
                if (owner instanceof LivingEntity livingOwner) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, livingOwner);
                    EnchantmentHelper.doPostDamageEffects(livingOwner, livingEntity);
                }
                doPostHurtEffects(livingEntity);
            }
            return true;
        }
        return false;
    }

    protected boolean canTouchDamageEntity(Entity entity) {
        if (!canHitEntity(entity)) return false;
        return entity instanceof LivingEntity && !entity.isCrouching();
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return super.canHitEntity(entity) && !entity.isInvulnerableTo(entity.damageSources().source(DDDamageTypes.ICICLE)) && !entity.is(this) && entity.getType() != EntityType.FALLING_BLOCK;
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return DDSounds.ICICLE_SHARD_LAND;
    }

    protected SoundEvent getHitDamageSoundEvent() {
        return DDSounds.ICICLE_SHARD_LAND;
    }

    protected SoundEvent getTouchDamageSoundEvent() {
        return DDSounds.ICICLE_SHARD_LAND;
    }
}
