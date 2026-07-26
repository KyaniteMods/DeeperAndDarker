package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class DDChestBoat extends ChestBoat implements DDBoatLike {
    private static final EntityDataAccessor<String> WOOD_TYPE = SynchedEntityData.defineId(DDChestBoat.class, EntityDataSerializers.STRING);

    public DDChestBoat(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DDChestBoat(Level level, double x, double y, double z) {
        this(DDEntities.CHEST_BOAT, level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(WOOD_TYPE, DDBoat.Type.ECHO.getSerializedName());
    }

    @Override
    public Item getDropItem() {
        return switch (getWoodType()) {
            case BLOOM -> DDItems.BLOOM_CHEST_BOAT;
            default -> DDItems.ECHO_CHEST_BOAT;
        };
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString(DDBoat.TYPE_TAG, getWoodType().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setWoodType(DDBoat.Type.byName(pCompound.getString(DDBoat.TYPE_TAG)));
    }

    @Override
    public DDBoat.Type getWoodType() {
        return DDBoat.Type.byName(entityData.get(WOOD_TYPE));
    }

    @Override
    public void setWoodType(DDBoat.Type woodType) {
        entityData.set(WOOD_TYPE, woodType.getSerializedName());
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(getDropItem());
    }
}
