package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class DDBoat extends Boat {
    private static final EntityDataAccessor<String> WOOD_TYPE = SynchedEntityData.defineId(DDBoat.class, EntityDataSerializers.STRING);

    public DDBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public DDBoat(Level level, double x, double y, double z, String woodType) {
        this(DDEntities.BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.entityData.set(WOOD_TYPE, woodType);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(WOOD_TYPE, DDBlocks.ECHO.name());
    }

    @Override
    public Item getDropItem() {
        return this.entityData.get(WOOD_TYPE).equals(DDBlocks.BLOOM.name()) ? DDItems.BLOOM_BOAT.get() : DDItems.ECHO_BOAT.get();
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getWoodType());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setWoodType(tag.getString("Type"));
    }

    public String getWoodType() {
        return this.entityData.get(WOOD_TYPE);
    }

    public void setWoodType(String woodType) {
        this.entityData.set(WOOD_TYPE, woodType);
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.getDropItem());
    }
}
