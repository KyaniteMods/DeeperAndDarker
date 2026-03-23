package com.kyanite.deeperdarker.content.entities.overcastvessel;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.AbstractGolemBoss;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhaseType;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class OvercastVessel extends AbstractGolemBoss {
    private final OvercastVesselPhaseManager phaseManager;
    private Direction crackDirection;

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
        if (compoundTag.contains("crack_direction", CompoundTag.TAG_INT)) {
            crackDirection = Direction.from3DDataValue(compoundTag.getInt("crack_direction"));
        }
        phaseManager.loadFrom(compoundTag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (crackDirection != null) {
            compoundTag.putInt("crack_direction", crackDirection.get3DDataValue());
        }
        phaseManager.save(compoundTag);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 40).add(Attributes.ARMOR, 12).add(Attributes.ARMOR_TOUGHNESS, 4).add(Attributes.FOLLOW_RANGE, 100).build();
    }

    @Override
    protected void golemServerAiStep() {
        phaseManager.tick();
    }

    public void setCrackDirection(@Nullable Direction crackDirection) {
        this.crackDirection = crackDirection;
    }

    @Override
    public void reset() {
        super.reset();
        phaseManager.reset();
    }

    @Override
    public boolean canBeCollidedWith() {
        return phaseManager.getPhases().isEmpty() || phaseManager.getPhases().getFirst().getType() == OvercastVesselPhaseType.SLIDER;
    }
}
