package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.network.LinkOwnedEntityPacket;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class SyncedOwnedEntity extends Entity implements TraceableEntity {
    public static final String OWNER_TAG = "owner";

    @Nullable
    private UUID ownerUUID;
    @Nullable
    private Entity owner;
    @Nullable
    private int delayedOwnerId;

    public SyncedOwnedEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public SyncedOwnedEntity(EntityType<?> entityType, Level level, @NotNull Entity owner) {
        this(entityType, level);
        ownerUUID = owner.getUUID();
    }

    @Override
    protected void defineSynchedData() {
    }

    public @Nullable UUID getOwnerUUID() {
        return ownerUUID;
    }

    @Override
    @Nullable
    public Entity getOwner() {
        if (owner == null && delayedOwnerId != 0 && level().isClientSide()) {
            owner = level().getEntity(delayedOwnerId);
        }
        return owner;
    }

    public void setOwner(Entity entity, boolean broadcast) {
        owner = entity;
        ownerUUID = null;
        if (entity == null) return;
        if (!level().isClientSide() && broadcast && level() instanceof ServerLevel serverLevel) {
            final FabricPacket packet = new LinkOwnedEntityPacket(owner, this);
            PlayerLookup.world(serverLevel).forEach(player -> ServerPlayNetworking.send(player, packet));
        }
    }

    public void setDelayedOwnerId(int value) {
        delayedOwnerId = value;
    }

    protected void tickOwner() {
        restoreOwnerFromSave();
        if (owner != null && !owner.isAlive()) discard();
    }

    private void restoreOwnerFromSave() {
        if (ownerUUID != null && level() instanceof ServerLevel serverLevel) {
            Entity entity = serverLevel.getEntity(ownerUUID);
            if (entity != null) {
                setOwner(entity, true);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide()) {
            tickOwner();
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.hasUUID(OWNER_TAG)) {
            ownerUUID = compoundTag.getUUID(OWNER_TAG);
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (owner != null) {
            compoundTag.putUUID(OWNER_TAG, owner.getUUID());
        } else if (ownerUUID != null) {
            compoundTag.putUUID(OWNER_TAG, ownerUUID);
        }
    }
}
