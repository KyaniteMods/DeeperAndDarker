package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.goals.FloaterInWormGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import java.util.function.Consumer;

public class Floater extends Vex {
    public static final String NEXT_WORM_TAG = "next_worm";
    public static final String WORM_HEAD_TAG = "worm_head";
    public static final String SPECIAL_TAG = "special";
    public static final String WORM_PARTS_TAG = "worm_parts";
    public static final int MAX_AGE = 3600;

    public static final EntityDataAccessor<Boolean> DATA_ID_SPECIAL = SynchedEntityData.defineId(Floater.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DATA_ID_IS_BODY = SynchedEntityData.defineId(Floater.class, EntityDataSerializers.BOOLEAN);

    @Nullable
    private Floater nextWormPart;
    @Nullable
    private Floater previousWormPart;
    @Nullable
    private Floater wormHead;

    @Nullable
    private UUID nextWormPartUUID;
    @Nullable
    private UUID wormHeadUUID;

    private HashSet<UUID> wormParts;

    private int age;

    public Floater(EntityType<? extends Vex> entityType, Level level) {
        super(entityType, level);
        wormParts = new HashSet<>();
        wormParts.add(getUUID());
        wormHeadUUID = getUUID();
        moveControl = new FloaterMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new FloaterInWormGoal(this));
        removeAllGoals(goal -> goal instanceof LookAtPlayerGoal);
        setPersistenceRequired();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_SPECIAL, false);
        entityData.define(DATA_ID_IS_BODY, false);
    }

    public static AttributeSupplier createFloaterAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 28.0).add(Attributes.ATTACK_DAMAGE, 12.0).add(Attributes.FOLLOW_RANGE, 64.0).build();
    }

    @Override
    public boolean isCurrentlyGlowing() {
        return true;
    }

    protected void tickWorm() {
        if (!inWormBody() || getNextWormPart() == null) {
            if (hasPreviousWormPart()) previousWormPart.tickWorm();
            return;
        }
        Floater floater = getNextWormPart();
        double d = distanceTo(floater);
        float f = floater.getBbWidth() / 2.0f;
        Vec3 vec3 = new Vec3(floater.getX() - getX(), floater.getY() - getY(), floater.getZ() - getZ()).normalize().scale(Math.max(d - f, 0.0));
        moveTo(getX() + vec3.x, getY() + vec3.y, getZ() + vec3.z);
        getLookControl().setLookAt(floater);
        if (hasPreviousWormPart()) previousWormPart.tickWorm();
    }

    @Override
    protected void customServerAiStep() {
        tickWorm();
    }

    @Override
    public void tick() {
        super.tick();
        if (age++ >= MAX_AGE && hasMaxAge() && isLeaderWormHead()) {
            executeOnEveryWormPart(Entity::discard);
        }
    }

    public boolean hasMaxAge() {
        return true;
    }

    class FloaterMoveControl
            extends MoveControl {
        public FloaterMoveControl(Vex vex2) {
            super(vex2);
        }

        @Override
        public void tick() {
            if (this.operation != Operation.MOVE_TO) {
                return;
            }
            Vec3 vec3 = new Vec3(this.wantedX - Floater.this.getX(), this.wantedY - Floater.this.getY(), this.wantedZ - Floater.this.getZ());
            double d = vec3.length();
            if (d < Floater.this.getBoundingBox().getSize()) {
                this.operation = Operation.WAIT;
                Floater.this.setDeltaMovement(Floater.this.getDeltaMovement().scale(0.5));
            } else {
                Floater.this.setDeltaMovement(Floater.this.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.05 / d)));
            }

            Floater.this.getLookControl().setLookAt(wantedX, wantedY, wantedZ);
            Floater.this.yBodyRot = Floater.this.getYRot();
        }
    }

    // Disconnects this segment of the worm, from this to all previous parts
    public void leaveWorm() {
        if (nextWormPart != null) {
            nextWormPart.previousWormPart = null;
        }
        nextWormPart = null;
        nextWormPartUUID = null;
        setIsBody(false);
    }

    // Joins a worm tail
    public void joinWorm(Floater floater) {
        if (this == floater) return;

        nextWormPartUUID = floater.getUUID();
        nextWormPart = floater;
        nextWormPart.previousWormPart = this;
        executeOnEveryWormPart((floater1) -> floater1.wormHeadUUID = floater.wormHeadUUID);
        nextWormPart.getWormParts().addAll(getWormParts());
        setIsBody(true);
    }

    public boolean hasPreviousWormPart() {
        return previousWormPart != null;
    }

    public boolean inWormBody() {
        return nextWormPartUUID != null;
    }

    public boolean isLeaderWormHead() {
        return hasPreviousWormPart() && !inWormBody();
    }

    @Nullable
    public Floater getNextWormPart() {
        if (nextWormPart == null && nextWormPartUUID != null && level() instanceof ServerLevel serverLevel) {
            Entity nextPart = serverLevel.getEntity(nextWormPartUUID);
            if (nextPart instanceof Floater floater) {
                joinWorm(floater);
            }
        }
        return nextWormPart;
    }

    @Nullable
    public Floater getWormHead() {
        if (wormHead == null && wormHeadUUID != null && level() instanceof ServerLevel serverLevel) {
            Entity nextPart = serverLevel.getEntity(wormHeadUUID);
            if (nextPart instanceof Floater floater) {
                wormHead = floater;
            }
        }
        return wormHead;
    }

    public void setWormParts(HashSet<UUID> wormParts) {
        this.wormParts = wormParts;
    }

    public HashSet<UUID> getWormParts() {
        return wormParts;
    }

    public void executeOnEveryWormPart(Consumer<Floater> consumer) {
        Floater previous = previousWormPart;
        consumer.accept(this);
        if (previous != null) previous.executeOnEveryWormPart(consumer);
    }

    public static Floater generateWorm(int size, double x, double y, double z, ServerLevel level) {
        return generateWorm(DDEntities.FLOATER, size, x, y, z, level);
    }

    public static <T extends Floater> T generateWorm(EntityType<T> entityType, int size, double x, double y, double z, ServerLevel level) {
        if (size == 0) throw new IllegalArgumentException("Floater worm size should be more than 0");
        T last = entityType.create(level);
        if (last != null) {
            last.setSpecial(true);
            last.moveTo(x, y, z);
            level.addFreshEntity(last);
        }
        if (size == 1) return last;
        for (int i = 0; i < size - 1; i++) {
            T floater = entityType.create(level);
            if (floater != null) {
                floater.moveTo(x, y, z);
                if (last != null) {
                    floater.joinWorm(last);
                    floater.getWormParts().remove(floater.getUUID());
                    floater.setWormParts(last.getWormHead().getWormParts());
                    floater.getWormParts().add(floater.getUUID());
                }
                last = floater;
                level.addFreshEntity(floater);
            }
        }
        return last;
    }

    @Override
    public void push(Entity entity) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void knockback(double strength, double x, double z) {
    }

    @Override
    public int getMaxHeadXRot() {
        return 90;
    }

    @Override
    public int getMaxHeadYRot() {
        return 90;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (nextWormPartUUID != null) {
            compoundTag.putUUID(NEXT_WORM_TAG, nextWormPartUUID);
        }
        if (wormHeadUUID != null) {
            compoundTag.putUUID(WORM_HEAD_TAG, wormHeadUUID);
        }
        if (!wormParts.isEmpty()) {
            ListTag listTag = new ListTag();
            for (UUID uuid : wormParts) {
                listTag.add(StringTag.valueOf(uuid.toString()));
            }
            compoundTag.put(WORM_PARTS_TAG, listTag);
        }
        compoundTag.putBoolean(SPECIAL_TAG, isSpecial());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.hasUUID(NEXT_WORM_TAG)) {
            nextWormPartUUID = compoundTag.getUUID(NEXT_WORM_TAG);
        }
        if (compoundTag.hasUUID(WORM_HEAD_TAG)) {
            wormHeadUUID = compoundTag.getUUID(WORM_HEAD_TAG);
        }
        if (compoundTag.contains(WORM_PARTS_TAG)) {
            wormParts = new HashSet<>();
            ListTag listTag = compoundTag.getList(WORM_PARTS_TAG, Tag.TAG_STRING);
            for (int i = 0; i < listTag.size(); i++) {
                UUID uuid = UUID.fromString(listTag.getString(i));
                wormParts.add(uuid);
            }
        }
        setSpecial(compoundTag.getBoolean(SPECIAL_TAG));
    }

    public void setSpecial(boolean value) {
        entityData.set(DATA_ID_SPECIAL, value);
    }

    public boolean isSpecial() {
        return entityData.get(DATA_ID_SPECIAL);
    }

    public void setIsBody(boolean value) {
        entityData.set(DATA_ID_IS_BODY, value);
    }

    public boolean isBody() {
        return entityData.get(DATA_ID_IS_BODY);
    }

    @Override
    public void remove(RemovalReason removalReason) {
        super.remove(removalReason);

        leaveWorm();

        if (previousWormPart != null) {
            previousWormPart.setIsBody(false);
            if (!inWormBody()) {
                previousWormPart.setWormParts(getWormParts());
                previousWormPart.getWormParts().remove(getUUID());
                return;
            }
        }

        Floater head;
        if (!inWormBody()) {
            head = this;
        } else {
            head = getWormHead();
        }

        if (head != null) {
            head.getWormParts().remove(getUUID());
            if (head.getWormParts().isEmpty()) {
                System.out.println("Worm parts empty");
            }
        }
    }
}
