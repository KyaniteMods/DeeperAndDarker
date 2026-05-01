package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.entities.SyncedOwnedEntity;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class OverseerCrystal extends SyncedOwnedEntity {
    private static final EntityDataAccessor<Integer> DATA_ID_HEALTH = SynchedEntityData.defineId(OverseerCrystal.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_LAST_HURT_TIME = SynchedEntityData.defineId(OverseerCrystal.class, EntityDataSerializers.INT);
    public int lastHurtTimeOld;

    public static final String LAST_HURT_TIME_TAG = "last_hurt_time";
    public static final String HEALTH_TAG = "health";

    public OverseerCrystal(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public OverseerCrystal(@NotNull Entity owner) {
        super(DDEntities.OVERSEER_CRYSTAL, owner.level(), owner);
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(DATA_ID_HEALTH, 3);
        entityData.define(DATA_ID_LAST_HURT_TIME, 0);
    }

    @Override
    public void setOwner(Entity entity, boolean broadcast) {
        super.setOwner(entity, broadcast);
        if (entity instanceof Overseer overseer) {
            overseer.addCrystal(this);
        }
    }

    public void setHealth(int value) {
        entityData.set(DATA_ID_HEALTH, value);
    }

    public int getHealth() {
        return entityData.get(DATA_ID_HEALTH);
    }

    public void setLastHurtTime(int value) {
        entityData.set(DATA_ID_LAST_HURT_TIME, value);
    }

    public int getLastHurtTime() {
        return entityData.get(DATA_ID_LAST_HURT_TIME);
    }

    @Override
    public void tick() {
        super.tick();
        setLastHurtTime(getLastHurtTime() + 1);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        setLastHurtTime(compoundTag.getInt(LAST_HURT_TIME_TAG));
        setHealth(compoundTag.getInt(HEALTH_TAG));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt(LAST_HURT_TIME_TAG, getLastHurtTime());
        compoundTag.putInt(HEALTH_TAG, getHealth());
    }

    @Override
    public void remove(RemovalReason removalReason) {
        if (getOwner() instanceof Overseer overseer) {
            overseer.removeCrystal(this);
        }
        super.remove(removalReason);
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (isInvulnerableTo(damageSource)) {
            return false;
        }
        if (getHealth() > 1) {
            setLastHurtTime(0);
            setHealth(getHealth() - 1);
            level().playSound(null, getX(), getY(0.5), getZ(), DDSounds.OVERSEER_CRYSTAL_HIT, SoundSource.HOSTILE, 1.0f, 1.0f);
            return true;
        }
        if (!isRemoved() && !level().isClientSide()) {
            kill();
            markHurt();
            destroyEffects();
        }
        return true;
    }

    public void destroyEffects() {
        if (level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.AMETHYST_BLOCK.defaultBlockState()), getX(), getY(0.5), getZ(), 5, getBbWidth() / 4.0f, getBbHeight() / 4.0f, getBbWidth() / 4.0f, 0.05);
        }
        level().playSound(null, getX(), getY(0.5), getZ(), DDSounds.OVERSEER_CRYSTAL_BREAK, SoundSource.HOSTILE, 1.0f, 1.0f);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return super.isInvulnerableTo(damageSource) || !damageSource.is(DamageTypes.PLAYER_ATTACK);
    }
}
