package com.kyanite.deeperdarker.content.entities.overcastvessel;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OvercastVesselPart extends Entity {
    public final OvercastVessel parent;
    public final Direction direction;
    public final String name;

    public OvercastVesselPart(OvercastVessel parent, String name, Direction direction) {
        super(parent.getType(), parent.level());
        this.parent = parent;
        this.name = name;
        Validate.notNull(direction);
        this.direction = direction;
        setYRot(this.direction.get2DDataValue() * 90.0f);
        yRotO = getYRot();
        recalculateBoundingBox();
    }

    @Override
    protected void defineSynchedData() {
    }

    protected void recalculateBoundingBox() {
        double d = this.getX();
        double e = this.getY();
        double f = this.getZ();
        this.xo = d;
        this.yo = e;
        this.zo = f;
        this.xOld = d;
        this.yOld = e;
        this.zOld = f;

        double width = direction.getAxis() == Direction.Axis.X ? 1.0/16.0 : parent.getBbWidth();
        double depth = direction.getAxis() == Direction.Axis.Z ? 1.0/16.0 : parent.getBbWidth();
        double height = direction.getAxis().isVertical() ? 1.0/16.0 : parent.getBbHeight();
        setPosRaw(parent.getX() + direction.getStepX() * (parent.getBbWidth() + width) / 2.0, parent.getY() + parent.getBbHeight() / 2.0 + direction.getStepY() * (parent.getBbHeight() + height) / 2.0, parent.getZ() + direction.getStepZ() * (parent.getBbWidth() + depth) / 2.0);
        setBoundingBox(new AABB(getX() - width / 2.0, getY() - height / 2.0, getZ() - depth / 2.0, getX() + width / 2.0, getY() + height / 2.0, getZ() + depth / 2.0));
    }

    @Override
    public Vec3 getDeltaMovement() {
        return Vec3.ZERO;
    }

    @Override
    public void setDeltaMovement(Vec3 vec3) {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    @Nullable
    public ItemStack getPickResult() {
        return parent.getPickResult();
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (isInvulnerableTo(damageSource)) {
            return false;
        }
        return parent.hurt(this, damageSource, f);
    }

    @Override
    public boolean is(Entity entity) {
        return this == entity || parent == entity;
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }
}
