package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.goals.FloaterFollowWormGoal;
import net.minecraft.nbt.CompoundTag;
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

import java.util.UUID;

public class Floater extends Vex {
    public static final EntityDataAccessor<Boolean> DATA_ID_SPECIAL = SynchedEntityData.defineId(Floater.class, EntityDataSerializers.BOOLEAN);

    @Nullable
    private Floater wormHead;
    @Nullable
    private Floater wormTail;

    @Nullable
    private UUID wormHeadUUID;

    public static final String WORM_HEAD = "worm_head";
    public static final String SPECIAL = "special";

    public Floater(EntityType<? extends Vex> entityType, Level level) {
        super(entityType, level);
        moveControl = new FloaterMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new FloaterFollowWormGoal(this));
        removeAllGoals(goal -> goal instanceof LookAtPlayerGoal);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_SPECIAL, false);
    }

    public static AttributeSupplier createFloaterAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 28.0).add(Attributes.ATTACK_DAMAGE, 8.0).build();
    }

    @Override
    public boolean isCurrentlyGlowing() {
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

    public void leaveWorm() {
        if (wormHead != null) {
            wormHead.wormTail = null;
        }
        wormHead = null;
        wormHeadUUID = null;
    }

    public void joinWorm(Floater floater) {
        wormHeadUUID = floater.getUUID();
        wormHead = floater;
        wormHead.wormTail = this;
    }

    public boolean hasWormTail() {
        return wormTail != null;
    }

    public boolean inWorm() {
        return wormHeadUUID != null;
    }

    public boolean isWormHead() {
        return hasWormTail() && !inWorm();
    }

    @Nullable
    public Floater getWormHead() {
        if (wormHead == null && wormHeadUUID != null && level() instanceof ServerLevel serverLevel) {
            Entity head = serverLevel.getEntity(wormHeadUUID);
            if (head instanceof Floater floater) {
                joinWorm(floater);
            }
        }
        return wormHead;
    }

    public static Floater generateWorm(int size, double x, double y, double z, ServerLevel level) {
        if (size == 0) throw new IllegalArgumentException("Floater worm size should be more than 0");
        Floater last = DDEntities.FLOATER.create(level);
        if (last != null) {
            last.setSpecial(true);
            last.moveTo(x, y, z);
            level.addFreshEntity(last);
        }
        if (size == 1) return last;
        for (int i = 0; i < size - 1; i++) {
            Floater floater = DDEntities.FLOATER.create(level);
            if (floater != null) {
                floater.moveTo(x, y, z);
                if (last != null) {
                    floater.joinWorm(last);
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
        if (wormHeadUUID != null) {
            compoundTag.putUUID(WORM_HEAD, wormHeadUUID);
        }
        compoundTag.putBoolean(SPECIAL, isSpecial());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.hasUUID(WORM_HEAD)) {
            wormHeadUUID = compoundTag.getUUID(WORM_HEAD);
        }
        setSpecial(compoundTag.getBoolean(SPECIAL));
    }

    public void setSpecial(boolean value) {
        entityData.set(DATA_ID_SPECIAL, value);
    }

    public boolean isSpecial() {
        return entityData.get(DATA_ID_SPECIAL);
    }
}
