package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.network.LinkOverseerCrystalPacket;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
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

    public OverseerCrystal(Level level, @NotNull Entity owner) {
        this(DDEntities.OVERSEER_CRYSTAL, level);
        ownerUUID = owner.getUUID();
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
        if (entity instanceof Overseer overseer) {
            overseer.addCrystal(this);
        }
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
        if (!isRemoved() && !level().isClientSide()) {
            kill();
            markHurt();
        }
        return true;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return super.isInvulnerableTo(damageSource) || !damageSource.is(DamageTypes.PLAYER_ATTACK);
    }
}
