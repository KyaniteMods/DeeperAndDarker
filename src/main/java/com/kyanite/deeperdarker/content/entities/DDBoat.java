package com.kyanite.deeperdarker.content.entities;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("NullableProblems")
public class DDBoat extends Boat implements DDBoatLike {
    public static final String TYPE_TAG = "Type";

    private static final EntityDataAccessor<String> WOOD_TYPE = SynchedEntityData.defineId(DDBoat.class, EntityDataSerializers.STRING);

    public DDBoat(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DDBoat(Level level, double x, double y, double z) {
        this(DDEntities.BOAT, level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(WOOD_TYPE, Type.ECHO.getSerializedName());
    }

    @Override
    public Item getDropItem() {
        return switch (getWoodType()) {
            case BLOOM -> DDItems.BLOOM_BOAT;
            case SCULK_SPRUCE -> DDItems.SCULK_SPRUCE_BOAT;
            default -> DDItems.ECHO_BOAT;
        };
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString(TYPE_TAG, getWoodType().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setWoodType(Type.byName(pCompound.getString(TYPE_TAG)));
    }

    @Override
    public Type getWoodType() {
        return Type.byName(entityData.get(WOOD_TYPE));
    }

    @Override
    public void setWoodType(Type woodType) {
        entityData.set(WOOD_TYPE, woodType.getSerializedName());
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(getDropItem());
    }

    public enum Type implements StringRepresentable {
        ECHO(DDBlocks.ECHO_PLANKS, "echo"),
        BLOOM(DDBlocks.BLOOM_PLANKS, "bloom"),
        SCULK_SPRUCE(DDBlocks.SCULK_SPRUCE_PLANKS, "sculk_spruce");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<Type> CODEC;

        Type(Block planks, String name) {
            this.name = name;
            this.planks = planks;
        }

        @Override
        public String getSerializedName() {
            return name;
        }

        public String getName() {
            return name;
        }

        public Block getPlanks() {
            return planks;
        }

        public String toString() {
            return name;
        }

        public static Type byName(String string) {
            return CODEC.byName(string, ECHO);
        }

        static {
            CODEC = StringRepresentable.fromEnum(Type::values);
        }
    }
}
