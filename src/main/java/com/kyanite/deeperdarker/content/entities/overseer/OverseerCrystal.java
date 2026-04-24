package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.network.LinkOverseerCrystalPacket;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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

    private static final EntityDataAccessor<Integer> DATA_ID_HEALTH = SynchedEntityData.defineId(OverseerCrystal.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_LAST_HURT_TIME = SynchedEntityData.defineId(OverseerCrystal.class, EntityDataSerializers.INT);
    public int lastHurtTimeOld;

    public static final String OWNER_TAG = "owner";
    public static final String LAST_HURT_TIME_TAG = "last_hurt_time";
    public static final String HEALTH_TAG = "health";

    public OverseerCrystal(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public OverseerCrystal(Level level, @NotNull Entity owner) {
        this(DDEntities.OVERSEER_CRYSTAL, level);
        ownerUUID = owner.getUUID();
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(DATA_ID_HEALTH, 3);
        entityData.define(DATA_ID_LAST_HURT_TIME, 0);
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
        if (!level().isClientSide()) {
            tickOwner();
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.hasUUID(OWNER_TAG)) {
            ownerUUID = compoundTag.getUUID(OWNER_TAG);
        }
        setLastHurtTime(compoundTag.getInt(LAST_HURT_TIME_TAG));
        setHealth(compoundTag.getInt(HEALTH_TAG));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (owner != null) {
            compoundTag.putUUID(OWNER_TAG, owner.getUUID());
        } else if (ownerUUID != null) {
            compoundTag.putUUID(OWNER_TAG, ownerUUID);
        }
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
