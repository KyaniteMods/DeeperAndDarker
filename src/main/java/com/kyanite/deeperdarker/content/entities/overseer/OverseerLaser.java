package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class OverseerLaser extends Entity implements TraceableEntity {
    private static final EntityDataAccessor<Integer> DATA_ID_DESPAWN_TIME = SynchedEntityData.defineId(OverseerLaser.class, EntityDataSerializers.INT);

    public static final String OWNER_TAG = "owner";
    public static final String DESPAWN_TIME_TAG = "despawn_time";
    public static final String IS_DESPAWNING_TAG = "is_despawning";

    public static final int MAX_DESPAWN_TIME = 20;

    @Nullable
    private Entity owner;
    @Nullable
    private UUID ownerUUID;
    private boolean isDespawning = false;
    public int oldDespawnTime = MAX_DESPAWN_TIME;

    public OverseerLaser(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public OverseerLaser(Overseer owner) {
        this(DDEntities.OVERSEER_LASER, owner.level());
        ownerUUID = owner.getUUID();
    }

    public void setOwner(@Nullable Entity entity) {
        owner = entity;
        ownerUUID = entity == null ? null : entity.getUUID();
    }

    @Override
    @Nullable
    public Entity getOwner() {
        if (owner == null && ownerUUID != null && level() instanceof ServerLevel serverLevel) {
            owner = serverLevel.getEntity(ownerUUID);
        }
        return owner;
    }

    @Override
    public void tick() {
        super.tick();
        if (isDespawning) {
            setDespawnTime(getDespawnTime() - 1);
        } else {
            setDespawnTime(MAX_DESPAWN_TIME);
        }
        if (getDespawnTime() <= 0) {
            discard();
            return;
        }

        List<Entity> list = level().getEntities(this, new AABB(getX() - 0.5, level().getMinBuildHeight(), getZ() - 0.5, getX() + 0.5, level().getMaxBuildHeight(), getZ() + 0.5), Entity::isAlive);
        for (Entity entity : list) {
            entity.hurt(entity.damageSources().source(DDDamageTypes.DARK_FOUNTAIN, this, entity), 10.0f);
        }
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(DATA_ID_DESPAWN_TIME, MAX_DESPAWN_TIME);
    }

    public void setDespawnTime(int value) {
        entityData.set(DATA_ID_DESPAWN_TIME, value);
    }

    public int getDespawnTime() {
        return entityData.get(DATA_ID_DESPAWN_TIME);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.hasUUID(OWNER_TAG)) {
            ownerUUID = compoundTag.getUUID(OWNER_TAG);
        }
        setDespawnTime(compoundTag.getInt(DESPAWN_TIME_TAG));
        isDespawning = compoundTag.getBoolean(IS_DESPAWNING_TAG);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (ownerUUID != null) {
            compoundTag.putUUID(OWNER_TAG, ownerUUID);
        }
        compoundTag.putInt(DESPAWN_TIME_TAG, getDespawnTime());
        compoundTag.putBoolean(IS_DESPAWNING_TAG, isDespawning);
    }
}
