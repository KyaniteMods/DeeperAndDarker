package com.kyanite.deeperdarker.content.entities.overseer;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class OverseerCrystal extends Entity implements TraceableEntity {
    @Nullable
    private UUID owner;

    public OverseerCrystal(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    @Nullable
    public Entity getOwner() {
        Level level;
        if (owner != null && (level = this.level()) instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            return serverLevel.getEntity(owner);
        }
        return null;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.hasUUID("owner")) {
            owner = compoundTag.getUUID("owner");
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (owner != null) {
            compoundTag.putUUID("owner", owner);
        }
    }
}
