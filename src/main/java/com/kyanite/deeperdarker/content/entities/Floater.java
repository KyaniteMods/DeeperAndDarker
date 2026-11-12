package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDCriteriaTriggers;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Floater extends Vex {
    public static final String NEXT_WORM_TAG = "next_worm";
    public static final String WORM_HEAD_TAG = "worm_head";
    public static final String SPECIAL_TAG = "special";
    public static final String WORM_PARTS_TAG = "worm_parts";
    public static final String TOTAL_MAX_HEALTH_TAG = "total_max_health";

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
    private float totalMaxHealth;

    public Floater(EntityType<? extends Vex> entityType, Level level) {
        super(entityType, level);
        wormParts = new HashSet<>();
        wormParts.add(getUUID());
        wormHeadUUID = getUUID();
        setTotalMaxHealth(getMaxHealth());
        moveControl = new FloaterMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new FloaterInWormGoal(this));
        removeAllGoals(goal -> goal instanceof LookAtPlayerGoal);
        removeAllGoals(goal -> goal instanceof VexChargeAttackGoal);
        goalSelector.addGoal(4, new FloaterChargeAttackGoal());
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
        if (!isBody() || getNextWormPart() == null) {
            if (hasPreviousWormPart()) previousWormPart.tickWorm();
            return;
        }
        Floater floater = getNextWormPart();
        double d = distanceTo(floater);
        float f = floater.getBbWidth();
        Vec3 vec3 = new Vec3(floater.getX() - getX(), floater.getY() - getY(), floater.getZ() - getZ()).normalize().scale(Math.max(d - f, 0.0));
        moveTo(getX() + vec3.x, getY() + vec3.y, getZ() + vec3.z);
        getLookControl().setLookAt(floater, 90, 90);
        if (hasPreviousWormPart()) previousWormPart.tickWorm();
    }

    @Override
    protected void customServerAiStep() {
        tickWorm();
    }

    @Override
    public void tick() {
        super.tick();
        if (getMaxAge().isPresent() && age++ >= getMaxAge().getAsInt() && isLeaderWormHead()) {
            executeOnEveryConnectedWormPart(Entity::discard);
        }
    }

    public OptionalInt getMaxAge() {
        return OptionalInt.of(MAX_AGE);
    }

    class FloaterChargeAttackGoal extends VexChargeAttackGoal {
        public FloaterChargeAttackGoal() {
            super();
        }

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = Floater.this.getTarget();
            if (livingEntity != null && livingEntity.isAlive() && !Floater.this.getMoveControl().hasWanted() && Floater.this.random.nextInt(reducedTickDelay(Floater.this.chargeDelay())) == 0) {
                return Floater.this.distanceToSqr(livingEntity) > (Floater.this.chargeMinimumDistance() * Floater.this.chargeMinimumDistance());
            }
            return false;
        }

        @Override
        public void start() {
            LivingEntity livingEntity = Floater.this.getTarget();
            if (livingEntity != null) {
                Vec3 vec3 = livingEntity.getEyePosition();
                Floater.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0F);
            }

            Floater.this.setIsCharging(true);
            if (Floater.this.getChargeSound() != null) {
                Floater.this.playSound(Floater.this.getChargeSound(), 1.0F, 1.0F);
            }
        }
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
        setNextWormPartUUID(null);
    }

    // Joins a worm tail
    public void joinWorm(Floater floater) {
        if (this == floater) return;

        setNextWormPartUUID(floater.getUUID());
        nextWormPart = floater;
        nextWormPart.previousWormPart = this;
        executeOnEveryConnectedWormPart((floater1) -> floater1.wormHeadUUID = floater.wormHeadUUID);
        nextWormPart.getWormParts().addAll(getWormParts());
    }

    public boolean hasPreviousWormPart() {
        return previousWormPart != null;
    }

    public boolean isLeaderWormHead() {
        return hasPreviousWormPart() && !isBody();
    }

    public void setNextWormPartUUID(@Nullable UUID nextWormPartUUID) {
        this.nextWormPartUUID = nextWormPartUUID;
        updateIsBody();
    }

    @Nullable
    public Floater getNextWormPart() {
        if (nextWormPart == null && isBody() && level() instanceof ServerLevel serverLevel) {
            Entity nextPart = serverLevel.getEntity(nextWormPartUUID);
            if (nextPart instanceof Floater floater) {
                joinWorm(floater);
            }
        }
        return nextWormPart;
    }

    public Floater getWormHead() {
        if (wormHeadUUID == getUUID() || wormHeadUUID == null) return this;
        if (wormHead == null && level() instanceof ServerLevel serverLevel) {
            Entity nextPart = serverLevel.getEntity(wormHeadUUID);
            if (nextPart instanceof Floater floater) {
                wormHead = floater;
            }
        }
        return wormHead == null ? this : wormHead;
    }

    public void setWormParts(HashSet<UUID> wormParts) {
        this.wormParts = wormParts;
    }

    public HashSet<UUID> getWormParts() {
        return wormParts;
    }

    public void executeOnEveryConnectedWormPart(Consumer<Floater> consumer) {
        Floater previous = previousWormPart;
        consumer.accept(this);
        if (previous != null) previous.executeOnEveryConnectedWormPart(consumer);
    }

    public Set<Floater> getWormPartEntities() {
        if (!(level() instanceof ServerLevel serverLevel)) return Set.of();
        return getWormParts().stream()
                .map(serverLevel::getEntity)
                .filter(Objects::nonNull)
                .filter(floater -> floater instanceof Floater)
                .map(floater -> (Floater) floater)
                .collect(Collectors.toSet());
    }

    public double executeOnEveryWormPart(Function<Floater, Double> function) {
        if (!(level() instanceof ServerLevel serverLevel)) return 0;
        return getWormParts().stream().map(serverLevel::getEntity)
                .mapToDouble(floater -> floater instanceof Floater ? function.apply((Floater) floater) : 0.0f)
                .sum();
    }

    public void executeOnEveryWormPart(Consumer<Floater> consumer) {
        if (!(level() instanceof ServerLevel serverLevel)) return;
        getWormParts().stream()
                .map(serverLevel::getEntity)
                .forEach(floater -> {
                    if (floater instanceof Floater) {
                        consumer.accept((Floater) floater);
                    }
                });
    }

    public float getTotalHealth() {
        return (float) executeOnEveryWormPart(floater -> (double) floater.getHealth());
    }

    public boolean isLastRemaining() {
        Floater head = getWormHead();
        return head.getWormPartEntities().stream().filter(floater -> !floater.isDeadOrDying()).findFirst().isEmpty();
    }

    public static Floater generateWorm(int size, double x, double y, double z, ServerLevel level) {
        return generateWorm(DDEntities.FLOATER, size, x, y, z, level);
    }

    public static <T extends Floater> T generateWorm(EntityType<T> entityType, int size, double x, double y, double z, ServerLevel level) {
        if (size == 0) throw new IllegalArgumentException("Floater worm size should be more than 0");
        T parent = entityType.create(level);
        if (parent != null) {
            parent.setSpecial(true);
            parent.moveTo(x, y, z);
            level.addFreshEntity(parent);
        }
        if (size == 1 || parent == null) return parent;
        T head = parent;
        for (int i = 0; i < size - 1; i++) {
            T tail = entityType.create(level);
            if (tail != null) {
                tail.moveTo(x, y, z);
                tail.joinWorm(parent);
                tail.setWormParts(head.getWormParts());
                tail.getWormParts().add(tail.getUUID());
                head.setTotalMaxHealth(head.getTotalMaxHealth() + tail.getTotalMaxHealth());
                parent = tail;
                level.addFreshEntity(tail);
            }
        }
        return parent;
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
        return 180;
    }

    @Override
    public int getMaxHeadYRot() {
        return 180;
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
        compoundTag.putFloat(TOTAL_MAX_HEALTH_TAG, totalMaxHealth);
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
            setNextWormPartUUID(compoundTag.getUUID(NEXT_WORM_TAG));
        }
        if (compoundTag.hasUUID(WORM_HEAD_TAG)) {
            wormHeadUUID = compoundTag.getUUID(WORM_HEAD_TAG);
        }
        totalMaxHealth = compoundTag.getFloat(TOTAL_MAX_HEALTH_TAG);
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

    public void updateIsBody() {
        entityData.set(DATA_ID_IS_BODY, nextWormPartUUID != null);
    }

    public boolean isBody() {
        return entityData.get(DATA_ID_IS_BODY);
    }

    public void setTotalMaxHealth(float totalMaxHealth) {
        this.totalMaxHealth = totalMaxHealth;
    }

    public float getTotalMaxHealth() {
        return totalMaxHealth;
    }

    public void onWormRemoved(RemovalReason removalReason) {
        if (removalReason != RemovalReason.KILLED) return;
        if (!(getKillCredit() instanceof ServerPlayer serverPlayer)) return;
        if (isLastRemaining()) {
            DamageSource damageSource = getLastDamageSource();
            if (damageSource == null) {
                damageSource = damageSources().generic();
            }
            DDCriteriaTriggers.PLAYER_KILLED_WORM.trigger(serverPlayer, this, damageSource);
        }
    }

    public void remove(RemovalReason removalReason, Floater oldHead, @Nullable Floater newHead) {
        if (oldHead == this && newHead != null && oldHead != newHead) {
            executeOnEveryWormPart(floater -> {
                floater.wormHeadUUID = newHead.getUUID();
                floater.wormHead = newHead;
            });
            newHead.setWormParts(getWormParts());
            newHead.setTotalMaxHealth(getTotalMaxHealth());
        }

        if (newHead != null) {
            newHead.getWormParts().remove(getUUID());
        } else {
            onWormRemoved(removalReason);
        }
    }

    @Override
    public void remove(RemovalReason removalReason) {
        super.remove(removalReason);

        leaveWorm();

        if (previousWormPart != null) {
            previousWormPart.setNextWormPartUUID(null);
        }

        Floater newHead;
        Floater head = getWormHead();
        if (head == this) {
            if (previousWormPart != null) {
                newHead = previousWormPart;
            } else {
                newHead = getWormPartEntities().stream().filter(floater -> !floater.isDeadOrDying()).findFirst().orElse(null);
            }
        } else {
            newHead = head;
        }

        remove(removalReason, head, newHead);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    public SoundEvent getChargeSound() {
        return null;
    }

    public int chargeDelay() {
        return 7;
    }

    public double chargeMinimumDistance() {
        return 2.0;
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
        return entityDimensions.height / 2.0f;
    }

    @Override
    public MobType getMobType() {
        return DDMobType.SCULK;
    }
}
