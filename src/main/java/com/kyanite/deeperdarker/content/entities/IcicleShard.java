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
import net.minecraft.world.phys.EntityHitResult;

public class IcicleShard extends AbstractArrow {
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
        if (this.inGroundTime > 4) {
            discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 8.0f;
        Entity owner = getOwner();
        DamageSource damageSource = damageSources().source(DDDamageTypes.ICICLE, this, owner == null ? this : owner);
        SoundEvent soundEvent = DDSounds.ICICLE_SHARD_LAND;
        if (entity.hurt(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity livingEntity) {
                if (owner instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, owner);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)owner, livingEntity);
                }
                doPostHurtEffects(livingEntity);
            }
        }
        playSound(soundEvent, 1.0f, 1.0f);
        discard();
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return DDSounds.ICICLE_SHARD_LAND;
    }
}
