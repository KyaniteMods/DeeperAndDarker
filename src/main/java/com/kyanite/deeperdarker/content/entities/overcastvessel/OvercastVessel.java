package com.kyanite.deeperdarker.content.entities.overcastvessel;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.AbstractGolemBoss;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhaseType;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
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

    private final OvercastVesselPart[] subEntities;
    private final OvercastVesselPart downPart;
    private final OvercastVesselPart upPart;
    private final OvercastVesselPart northPart;
    private final OvercastVesselPart southPart;
    private final OvercastVesselPart westPart;
    private final OvercastVesselPart eastPart;

    public OvercastVessel(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
        downPart = new OvercastVesselPart(this, "down", Direction.DOWN);
        upPart = new OvercastVesselPart(this, "up", Direction.UP);
        northPart = new OvercastVesselPart(this, "north", Direction.NORTH);
        southPart = new OvercastVesselPart(this, "south", Direction.SOUTH);
        westPart = new OvercastVesselPart(this, "west", Direction.WEST);
        eastPart = new OvercastVesselPart(this, "east", Direction.EAST);
        subEntities = new OvercastVesselPart[]{downPart, upPart, northPart, southPart, westPart, eastPart};
        phaseManager = new OvercastVesselPhaseManager(this, OvercastVesselPhase.CODEC);
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
    public void tick() {
        setNoGravity(true);
        super.tick();
        for (OvercastVesselPart part : subEntities) {
            tickPart(part);
        }
    }

    protected void tickPart(OvercastVesselPart part) {
        part.recalculateBoundingBox();
    }

    @Override
    protected void golemServerAiStep() {
        phaseManager.tick();
    }

    public OvercastVesselPart[] getSubEntities() {
        return subEntities;
    }

    public void addCrackDirection(Direction direction) {
        entityData.set(getCrackDataAccessor(direction), true);
    }

    public void removeCrackDirection(Direction direction) {
        entityData.set(getCrackDataAccessor(direction), false);
    }

    public Set<Direction> getCrackDirections() {
        HashSet<Direction> set = new HashSet<>();
        for (Direction direction : Direction.values()) {
            if (isCracked(direction)) set.add(direction);
        }
        return set;
    }

    public void repairCracks() {
        for (Direction direction : Direction.values()) {
            entityData.set(getCrackDataAccessor(direction), false);
        }
    }

    public boolean isCracked(Direction direction) {
        return entityData.get(getCrackDataAccessor(direction));
    }

    protected EntityDataAccessor<Boolean> getCrackDataAccessor(Direction direction) {
        return switch (direction) {
            case DOWN -> DATA_CRACK_DOWN_ID;
            case UP -> DATA_CRACK_UP_ID;
            case NORTH -> DATA_CRACK_NORTH_ID;
            case SOUTH -> DATA_CRACK_SOUTH_ID;
            case WEST -> DATA_CRACK_WEST_ID;
            case EAST -> DATA_CRACK_EAST_ID;
        };
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

    public boolean hurt(OvercastVesselPart part, DamageSource damageSource, float f) {
        if (this.phaseManager.getPhases().isEmpty()) {
            if (damageSource.getEntity() instanceof LivingEntity livingEntity) {
                setLastHurtByMob(livingEntity);
            }
            return true;
        }
        f = this.phaseManager.getPhases().getFirst().onHurt(this, part, damageSource, f);
        if (f < 0.01f) {
            return false;
        }
        if (damageSource.getEntity() instanceof Player) {
            this.reallyHurt(damageSource, f);
        }
        return true;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (!this.level().isClientSide()) {
            return hurt(southPart, damageSource, f);
        }
        return false;
    }

    protected boolean reallyHurt(DamageSource damageSource, float f) {
        return super.hurt(damageSource, f);
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        OvercastVesselPart[] parts = getSubEntities();
        for (int i = 0; i < parts.length; ++i) {
            parts[i].setId(i + clientboundAddEntityPacket.getId());
        }
    }
}
