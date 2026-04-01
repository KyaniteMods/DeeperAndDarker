package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Bubblox extends Entity {
    public static final EntityDataAccessor<Byte> ID_SIZE = SynchedEntityData.defineId(Bubblox.class, EntityDataSerializers.BYTE);

    public Bubblox(EntityType<?> entityType, Level level) {
        super(entityType, level);
        fixupDimensions();
    }

    public Bubblox(Level level, double x, double y, double z) {
        this(DDEntities.BUBBLOX, level);
        setPos(x, y, z);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        byte size = getSize();
        if (size == 0) return EntityDimensions.fixed(5.0f/16.0f, 5.0f/16.0f);
        if (size == 1) return EntityDimensions.fixed(8.0f/16.0f, 8.0f/16.0f);
        if (size == 2) return EntityDimensions.fixed(12.0f/16.0f, 12.0f/16.0f);
        float x0 = 5.0f/16.0f;
        float d = 2.0f/16.0f;
        float scalar = 1.0f/16.0f;
        float value = x0 + d * size + scalar * (size * (size + 1)) / 2.0f;
        return EntityDimensions.fixed(value, value);
    }

    @Override
    public void tick() {
        setNoGravity(true);
        super.tick();
        setDeltaMovement(new Vec3(0.0, 0.04, 0.0));
        move(MoverType.SELF, getDeltaMovement());
        if (verticalCollision) {
            kill();
        }
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(ID_SIZE, (byte) 0);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        if (ID_SIZE.equals(entityDataAccessor)) {
            refreshDimensions();
        }
    }

    public void setSize(byte size) {
        entityData.set(ID_SIZE, (byte)(size % 3));
        refreshDimensions();
    }

    public byte getSize() {
        return entityData.get(ID_SIZE);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        setSize(compoundTag.getByte("size"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putByte("size", getSize());
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (this.isInvulnerableTo(damageSource)) {
            return false;
        }
        if (!this.isRemoved() && !this.level().isClientSide()) {
            this.kill();
            this.markHurt();
        }
        return true;
    }

    @Override
    public void kill() {
        super.kill();
        playSound(DDSounds.BUBBLOX_POP, 0.65f + 0.35f * getSize(), 1.0f + (random.nextFloat() - 0.5f) * 0.05f);
    }
}
