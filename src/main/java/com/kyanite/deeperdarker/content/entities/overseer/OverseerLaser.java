package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.SyncedOwnedEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class OverseerLaser extends SyncedOwnedEntity {
    private static final EntityDataAccessor<Integer> DATA_ID_DESPAWN_TIME = SynchedEntityData.defineId(OverseerLaser.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_LASERS = SynchedEntityData.defineId(OverseerLaser.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_LASER_INDEX = SynchedEntityData.defineId(OverseerLaser.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_ROTATION_SPEED = SynchedEntityData.defineId(OverseerLaser.class, EntityDataSerializers.FLOAT);

    public static final String DESPAWN_TIME_TAG = "despawn_time";
    public static final String LASERS_TAG = "lasers";
    public static final String LASER_INDEX_TAG = "laser_index";
    public static final String ROTATION_SPEED_TAG = "rotation_speed";

    public static final String IS_DESPAWNING_TAG = "is_despawning";

    public static final int MAX_DESPAWN_TIME = 20;

    private boolean isDespawning = false;
    public int oldDespawnTime = MAX_DESPAWN_TIME;

    public OverseerLaser(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public OverseerLaser(@NotNull Overseer owner) {
        super(DDEntities.OVERSEER_LASER, owner.level(), owner);
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide()) {
            if (isDespawning) {
                setDespawnTime(getDespawnTime() - 1);
            } else {
                setDespawnTime(MAX_DESPAWN_TIME);
            }
        }

        updatePosition();

        if (getDespawnTime() <= 0) {
            discard();
            return;
        }

        List<Entity> list = level().getEntities(this, new AABB(getX() - 0.5, getY() - 128.0, getZ() - 0.5, getX() + 0.5, getY() + 129.0, getZ() + 0.5), Entity::isAlive);
        for (Entity entity : list) {
            entity.hurt(entity.damageSources().source(DDDamageTypes.DARK_FOUNTAIN, this, entity), 10.0f);
        }
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(DATA_ID_DESPAWN_TIME, MAX_DESPAWN_TIME);
        entityData.define(DATA_ID_LASERS, 1);
        entityData.define(DATA_ID_LASER_INDEX, 0);
        entityData.define(DATA_ID_ROTATION_SPEED, 0.0f);
    }

    public float getAngle() {
        if (getOwner() == null) return 0.0f;
        return 360.0f / getLasers() * getLaserIndex() + Mth.wrapDegrees(level().getGameTime() * getRotationSpeed());
    }

    public void setDespawnTime(int value) {
        entityData.set(DATA_ID_DESPAWN_TIME, value);
    }

    public int getDespawnTime() {
        return entityData.get(DATA_ID_DESPAWN_TIME);
    }

    public void setLasers(int value) {
        entityData.set(DATA_ID_LASERS, value);
    }

    public int getLasers() {
        return entityData.get(DATA_ID_LASERS);
    }

    public void setLaserIndex(int value) {
        entityData.set(DATA_ID_LASER_INDEX, value);
    }

    public int getLaserIndex() {
        return entityData.get(DATA_ID_LASER_INDEX);
    }

    public void setRotationSpeed(float value) {
        entityData.set(DATA_ID_ROTATION_SPEED, value);
    }

    public float getRotationSpeed() {
        return entityData.get(DATA_ID_ROTATION_SPEED);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        setDespawnTime(compoundTag.getInt(DESPAWN_TIME_TAG));
        setLasers(compoundTag.getInt(LASERS_TAG));
        setLaserIndex(compoundTag.getInt(LASER_INDEX_TAG));
        setRotationSpeed(compoundTag.getFloat(ROTATION_SPEED_TAG));
        isDespawning = compoundTag.getBoolean(IS_DESPAWNING_TAG);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt(DESPAWN_TIME_TAG, getDespawnTime());
        compoundTag.putInt(LASERS_TAG, getLasers());
        compoundTag.putInt(LASER_INDEX_TAG, getLaserIndex());
        compoundTag.putFloat(ROTATION_SPEED_TAG, getRotationSpeed());
        compoundTag.putBoolean(IS_DESPAWNING_TAG, isDespawning);
    }

    public void setDespawning() {
        isDespawning = true;
    }

    public boolean isDespawning() {
        return isDespawning;
    }

    public void updatePosition() {
        if (getOwner() != null && !isDespawning()) {
            Vec3 direction = Vec3.directionFromRotation(0.0f, getAngle());
            setPos(getOwner().position().add(direction.scale(3.0)));
        }
    }

    @Override
    public void setDeltaMovement(Vec3 vec3) {
    }

    @Override
    public Vec3 getDeltaMovement() {
        return Vec3.ZERO;
    }
}
