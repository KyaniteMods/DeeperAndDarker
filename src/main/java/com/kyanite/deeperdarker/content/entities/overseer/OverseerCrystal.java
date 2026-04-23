package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.network.LinkOverseerCrystalPacket;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class OverseerCrystal extends Entity implements TraceableEntity {
    @Nullable
    private UUID ownerUUID;
    @Nullable
    private Entity owner;
    @Nullable
    private int delayedOwnerId;

    public OverseerCrystal(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {

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
            final FabricPacket packet = new LinkOverseerCrystalPacket(owner, this);
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
        if (compoundTag.hasUUID("owner")) {
            ownerUUID = compoundTag.getUUID("owner");
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (owner != null) {
            compoundTag.putUUID("owner", owner.getUUID());
        } else if (ownerUUID != null) {
            compoundTag.putUUID("owner", ownerUUID);
        }
    }
}
