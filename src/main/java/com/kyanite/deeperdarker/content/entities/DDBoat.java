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
    private static final EntityDataAccessor<String> WOOD_TYPE = SynchedEntityData.defineId(DDBoat.class, EntityDataSerializers.STRING);

    public DDBoat(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DDBoat(Level level, double x, double y, double z) {
        this(DDEntities.BOAT, level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WOOD_TYPE, "deeperdarker:echo");
    }

    @Override
    public Item getDropItem() {
        return switch (this.getWoodType()) {
            case BLOOM -> DDItems.BLOOM_BOAT;
            default -> DDItems.ECHO_BOAT;
        };
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getWoodType().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setWoodType(Type.byName(pCompound.getString("Type")));
    }

    @Override
    public Type getWoodType() {
        return Type.byName(this.entityData.get(WOOD_TYPE));
    }

    @Override
    public void setWoodType(Type woodType) {
        this.entityData.set(WOOD_TYPE, woodType.getSerializedName());
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.getDropItem());
    }

    public enum Type implements StringRepresentable {
        ECHO(DDBlocks.ECHO_PLANKS, "echo"),
        BLOOM(DDBlocks.BLOOM_PLANKS, "bloom");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<Type> CODEC;

        Type(Block block, String string2) {
            this.name = string2;
            this.planks = block;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Type byName(String string) {
            return CODEC.byName(string, ECHO);
        }

        static {
            CODEC = StringRepresentable.fromEnum(Type::values);
        }
    }
}
