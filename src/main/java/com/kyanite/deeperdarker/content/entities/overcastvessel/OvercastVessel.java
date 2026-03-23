package com.kyanite.deeperdarker.content.entities.overcastvessel;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.AbstractGolemBoss;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhaseType;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.Set;

public class OvercastVessel extends AbstractGolemBoss {
    private final OvercastVesselPhaseManager phaseManager;

    protected static final EntityDataAccessor<Boolean> DATA_CRACK_DOWN_ID = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> DATA_CRACK_UP_ID = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> DATA_CRACK_NORTH_ID = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> DATA_CRACK_SOUTH_ID = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> DATA_CRACK_WEST_ID = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> DATA_CRACK_EAST_ID = SynchedEntityData.defineId(OvercastVessel.class, EntityDataSerializers.BOOLEAN);

    public OvercastVessel(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        phaseManager = new OvercastVesselPhaseManager(this);
        xpReward = 50;
    }

    public OvercastVessel(Level level, double x, double y, double z) {
        this(DDEntities.OVERCAST_VESSEL, level);
        setPos(x, y, z);
        xo = x;
        yo = y;
        zo = z;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        entityData.set(DATA_CRACK_DOWN_ID, compoundTag.getBoolean("crack_down"));
        entityData.set(DATA_CRACK_UP_ID, compoundTag.getBoolean("crack_up"));
        entityData.set(DATA_CRACK_NORTH_ID, compoundTag.getBoolean("crack_north"));
        entityData.set(DATA_CRACK_SOUTH_ID, compoundTag.getBoolean("crack_south"));
        entityData.set(DATA_CRACK_WEST_ID, compoundTag.getBoolean("crack_west"));
        entityData.set(DATA_CRACK_EAST_ID, compoundTag.getBoolean("crack_east"));
        phaseManager.loadFrom(compoundTag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("crack_down", entityData.get(DATA_CRACK_DOWN_ID));
        compoundTag.putBoolean("crack_up", entityData.get(DATA_CRACK_UP_ID));
        compoundTag.putBoolean("crack_north", entityData.get(DATA_CRACK_NORTH_ID));
        compoundTag.putBoolean("crack_south", entityData.get(DATA_CRACK_SOUTH_ID));
        compoundTag.putBoolean("crack_west", entityData.get(DATA_CRACK_WEST_ID));
        compoundTag.putBoolean("crack_east", entityData.get(DATA_CRACK_EAST_ID));
        phaseManager.save(compoundTag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_CRACK_DOWN_ID, false);
        entityData.define(DATA_CRACK_UP_ID, false);
        entityData.define(DATA_CRACK_NORTH_ID, false);
        entityData.define(DATA_CRACK_SOUTH_ID, false);
        entityData.define(DATA_CRACK_WEST_ID, false);
        entityData.define(DATA_CRACK_EAST_ID, false);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 40).add(Attributes.ARMOR, 12).add(Attributes.ARMOR_TOUGHNESS, 4).add(Attributes.FOLLOW_RANGE, 100).add(Attributes.ATTACK_KNOCKBACK, 10.0).build();
    }

    @Override
    protected void golemServerAiStep() {
        phaseManager.tick();
    }

    public void addCrackDirection(Direction crackDirection) {
        switch (crackDirection) {
            case DOWN -> entityData.set(DATA_CRACK_DOWN_ID, true);
            case UP -> entityData.set(DATA_CRACK_UP_ID, true);
            case NORTH -> entityData.set(DATA_CRACK_NORTH_ID, true);
            case SOUTH -> entityData.set(DATA_CRACK_SOUTH_ID, true);
            case WEST -> entityData.set(DATA_CRACK_WEST_ID, true);
            case EAST -> entityData.set(DATA_CRACK_EAST_ID, true);
        }
    }

    public Set<Direction> getCrackDirections() {
        HashSet<Direction> set = new HashSet<>();
        if (entityData.get(DATA_CRACK_DOWN_ID)) set.add(Direction.DOWN);
        if (entityData.get(DATA_CRACK_UP_ID)) set.add(Direction.UP);
        if (entityData.get(DATA_CRACK_NORTH_ID)) set.add(Direction.NORTH);
        if (entityData.get(DATA_CRACK_SOUTH_ID)) set.add(Direction.SOUTH);
        if (entityData.get(DATA_CRACK_WEST_ID)) set.add(Direction.WEST);
        if (entityData.get(DATA_CRACK_EAST_ID)) set.add(Direction.EAST);
        return set;
    }

    public void repairCracks() {
        entityData.set(DATA_CRACK_DOWN_ID, false);
        entityData.set(DATA_CRACK_UP_ID, false);
        entityData.set(DATA_CRACK_NORTH_ID, false);
        entityData.set(DATA_CRACK_SOUTH_ID, false);
        entityData.set(DATA_CRACK_WEST_ID, false);
        entityData.set(DATA_CRACK_EAST_ID, false);
    }

    @Override
    public void reset() {
        super.reset();
        phaseManager.reset();
        level().addFreshEntity(new OvercastVesselItem(level(), Items.BRICK.getDefaultInstance(), this));
    }

    @Override
    public boolean canBeCollidedWith() {
        return phaseManager.getPhases().isEmpty() || phaseManager.getPhases().getFirst().getType() != OvercastVesselPhaseType.SLIDER;
    }

    @Override
    public BlockState getParticleState() {
        return DDBlocks.GLOOMSLATE_BRICKS.defaultBlockState();
    }
}
