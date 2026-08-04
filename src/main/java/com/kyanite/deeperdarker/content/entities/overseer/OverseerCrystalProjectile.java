package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class OverseerCrystalProjectile extends AbstractHurtingProjectile {
    public OverseerCrystalProjectile(EntityType<? extends OverseerCrystalProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public OverseerCrystalProjectile(Level level, LivingEntity livingEntity, double d, double e, double f) {
        super(DDEntities.OVERSEER_CRYSTAL_PROJECTILE, livingEntity, d, e, f, level);
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!level().isClientSide()) {
            Entity entity = entityHitResult.getEntity();
            boolean bl;
            if (getOwner() instanceof LivingEntity owner) {
                bl = entity.hurt(damageSources().source(DDDamageTypes.OVERSEER_CRYSTAL, owner), 5.0f);
                if (bl && entity.isAlive()) {
                    doEnchantDamageEffects(owner, entity);
                }
            } else {
                entity.hurt(damageSources().source(DDDamageTypes.OVERSEER_CRYSTAL), 5.0f);
            }
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!level().isClientSide()) {
            discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (getY() > 500 || (getOwner() != null && distanceTo(getOwner()) > 160)) {
            discard();
        }
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.END_ROD;
    }
}
