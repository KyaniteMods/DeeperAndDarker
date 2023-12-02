package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.DeeperDarker;
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
public class DDBoat extends Boat implements DDBoatLike {
    private static final EntityDataAccessor<String> WOOD_TYPE = SynchedEntityData.defineId(DDBoat.class, EntityDataSerializers.STRING);

    public DDBoat(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DDBoat(Level level, double x, double y, double z, String woodType) {
        this(DDEntities.BOAT, level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.entityData.set(WOOD_TYPE, woodType);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WOOD_TYPE, "deeperdarker:echo");
    }

    @Override
    public Item getDropItem() {
        return switch (this.getWoodType()) {
            case (DeeperDarker.MOD_ID + ":bloom") -> DDItems.BLOOM_BOAT;
            default -> DDItems.ECHO_BOAT;
        };
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getWoodType());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setWoodType(pCompound.getString("Type"));
    }

    @Override
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
