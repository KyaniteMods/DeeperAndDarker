package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class DeeperDarkerChestBoatEntity extends ChestBoatEntity implements IDeeperDarkerBoatEntity {
    private static final TrackedData<String> WOOD_TYPE = DataTracker.registerData(DeeperDarkerChestBoatEntity.class, TrackedDataHandlerRegistry.STRING);

    public DeeperDarkerChestBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

    public DeeperDarkerChestBoatEntity(World world, double x, double y, double z, String woodType) {
        super(DeeperDarkerEntityTypes.CHEST_BOAT, world);
        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.dataTracker.set(WOOD_TYPE, woodType);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(WOOD_TYPE, "echo");
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("Type", this.getWoodType());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setWoodType(nbt.getString("Type"));
    }

    @Override
    public Item asItem() {
        return DeeperDarkerItems.ECHO_CHEST_BOAT;
    }

    public String getWoodType() {
        return switch (this.dataTracker.get(WOOD_TYPE)) {
            default -> "echo";
        };
    }

    public void setWoodType(String woodType) {
        this.dataTracker.set(WOOD_TYPE, woodType);
    }
}
