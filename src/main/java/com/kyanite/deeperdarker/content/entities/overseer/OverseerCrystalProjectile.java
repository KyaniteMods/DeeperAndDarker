package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class OverseerCrystalProjectile extends AbstractHurtingProjectile {
    public static final String DAMAGE_TAG = "damage";

    private float damage = 10.0f;

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
    protected boolean canHitEntity(Entity entity) {
        return super.canHitEntity(entity) && entity.getType() != DDEntities.OVERSEER && entity.getType() != DDEntities.SCULK_MILLIPEDE;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!level().isClientSide()) {
            Entity entity = entityHitResult.getEntity();
            hurt(entity, damage);
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        level().addParticle(ParticleTypes.EXPLOSION, getX(), getY(), getZ(), 0.0f, 0.0f, 0.0f);

        if (!level().isClientSide()) {
            List<Entity> list = level().getEntities(this, getBoundingBox().inflate(1.5), entity -> entity.isAlive() && !(entity instanceof ItemEntity));
            for (Entity entity : list) {
                hurt(entity, 5.0f);
            }
            discard();
        }
    }

    protected boolean hurt(Entity entity, float amount) {
        boolean bl;
        if (getOwner() instanceof LivingEntity owner) {
            bl = entity.hurt(damageSources().source(DDDamageTypes.OVERSEER_CRYSTAL, owner), amount);
            if (bl && entity.isAlive()) {
                doEnchantDamageEffects(owner, entity);
            }
        } else {
            bl = entity.hurt(damageSources().source(DDDamageTypes.OVERSEER_CRYSTAL), amount);
        }
        return bl;
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

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getDamage() {
        return damage;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putFloat(DAMAGE_TAG, damage);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        damage = compoundTag.getFloat(DAMAGE_TAG);
    }
}
