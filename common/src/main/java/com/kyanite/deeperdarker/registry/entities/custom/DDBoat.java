package com.kyanite.deeperdarker.registry.entities.custom;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class DDBoat extends Boat {
    private static final EntityDataAccessor<Integer> WOOD_TYPE = SynchedEntityData.defineId(DDBoat.class, EntityDataSerializers.INT);

    public DDBoat(EntityType<? extends Boat> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public static DDBoat create(Level level, double x, double y, double z) {
        DDBoat boat = DDEntities.BOAT.create(level);
        boat.setPos(x, y, z);
        boat.setDeltaMovement(Vec3.ZERO);
        boat.xo = x;
        boat.yo = y;
        boat.zo = z;
        return boat;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WOOD_TYPE, 0);
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if(pCompound.contains("Type", 8)) {
            this.setWoodType(Type.byName(pCompound.getString("Type")));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getWoodType().getName());
    }

    public Type getWoodType() {
        return Type.byId(this.entityData.get(WOOD_TYPE));
    }

    public void setWoodType(Type type) {
        this.entityData.set(WOOD_TYPE, type.ordinal());
    }

    @Override
    public Item getDropItem() {
        return this.getWoodType().getItem();
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public enum Type {
        ECHO("echo", DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);

        private final String name;
        private final Item item;
        private final Item chestItem;

        Type(String name, Item boatItem, Item chestBoatItem) {
            this.name = name;
            this.item = boatItem;
            this.chestItem = chestBoatItem;
        }

        public String getName() {
            return this.name;
        }

        public Item getItem() {
            return item;
        }

        public Item getChestItem() {
            return chestItem;
        }

        public static Type byId(int id) {
            Type[] values = values();
            if(id < 0 || id >= values.length) {
                id = 0;
            }

            return values[id];
        }

        public static Type byName(String name) {
            Type[] values = values();

            for(Type value : values) {
                if(value.getName().equals(name)) {
                    return value;
                }
            }

            return values[0];
        }
    }
}