package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class OvercastVesselSliderPhase extends OvercastVesselPhase {
    public static final Codec<OvercastVesselSliderPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("max_phase_time").forGetter(phase -> phase.maxPhaseTime),
            Codec.INT.fieldOf("phase_time").forGetter(phase -> phase.phaseTime),
            Direction.CODEC.optionalFieldOf("direction").forGetter(phase -> phase.direction),
            Vec3.CODEC.optionalFieldOf("target").forGetter(phase -> phase.target),
            Vec3.CODEC.optionalFieldOf("override_target").forGetter(phase -> phase.overrideTarget),
            Codec.INT.fieldOf("move_time").forGetter(phase -> phase.moveTime)
    ).apply(instance, OvercastVesselSliderPhase::new));
    private final int maxPhaseTime;
    private int phaseTime;
    private Optional<Direction> direction;
    private Optional<Vec3> target;
    private Optional<Vec3> overrideTarget;
    private int moveTime;

    private OvercastVesselSliderPhase(int maxPhaseTime, int phaseTime, Optional<Direction> direction, Optional<Vec3> target, Optional<Vec3> overrideTarget, int moveTime) {
        this.maxPhaseTime = maxPhaseTime;
        this.phaseTime = phaseTime;
        this.direction = direction;
        this.target = target;
        this.overrideTarget = target;
        this.moveTime = moveTime;
    }

    public OvercastVesselSliderPhase(int maxPhaseTime) {
        this(maxPhaseTime, 0, Optional.empty(), Optional.empty(), Optional.empty(), 0);
    }

    @Override
    public boolean shouldContinue(OvercastVessel vessel) {
        return phaseTime < maxPhaseTime && target.isPresent();
    }

    public void initialize(OvercastVessel vessel) {
        vessel.setSnapToBlocks(false);
        recalculateTargetAndDirection(vessel);
    }

    @Override
    public void end(OvercastVessel vessel) {
        vessel.setSnapToBlocks(true);
    }

    @Override
    public void tick(OvercastVessel vessel) {
        if (vessel.level().isClientSide()) return;
        phaseTime++;

        if (target.isEmpty() && !recalculateTargetAndDirection(vessel)) return;

        if (moveTime > 0) {
            moveTime--;
            return;
        }

        Pair<Boolean, Vec3> slideResult = slideTowardTarget(vessel);
        if (slideResult.getFirst()) {
            Vec3 deltaMovement = vessel.getDeltaMovement();
            if ((vessel.verticalCollision || vessel.horizontalCollision) && slideResult.getSecond().lengthSqr() > 0.002 && !vessel.isCracked(direction.get())) {
                vessel.addCrackDirection(direction.get());
                moveTime = 20;
            } else {
                moveTime = 2;
            }
            if (!recalculateTargetAndDirection(vessel)) return;
        }

        vessel.hurtPlayersInside();
    }

    protected boolean recalculateTargetAndDirection(OvercastVessel vessel) {
        target = recalculateTarget(vessel);
        if (target.isEmpty()) return false;
        updateDirection(vessel, target.get());

        if (direction.get().getAxis().isHorizontal() && !isPathFree(vessel, direction.get())) {
            target = target.map(vec3 -> vec3.add(0.0, 1.0, 0.0));
            if (target.isEmpty()) return false;
            updateDirection(vessel, target.get());
        }
        return true;
    }

    /**
     * @return whether it stopped sliding and delta movement
     */
    protected Pair<Boolean, Vec3> slideTowardTarget(OvercastVessel vessel) {
        if (target.isEmpty() || direction.isEmpty()) return Pair.of(true, Vec3.ZERO);
        Vec3 target = this.target.get();

        Vec3 deltaMovement = vessel.getDeltaMovement();
        Vec3 oldPosition = vessel.position();
        Vec3 vectorToTarget = target.subtract(vessel.position()).multiply(
                Mth.abs(direction.get().getStepX()),
                Mth.abs(direction.get().getStepY()),
                Mth.abs(direction.get().getStepZ())
        );
        Vec3 newDeltaMovement = new Vec3(
                deltaMovement.x() + direction.get().getStepX() * 0.06,
                deltaMovement.y() + direction.get().getStepY() * 0.06,
                deltaMovement.z() + direction.get().getStepZ() * 0.06
        );
        double distanceToTarget = vectorToTarget.x() * direction.get().getStepX() + vectorToTarget.y() * direction.get().getStepY() + vectorToTarget.z() * direction.get().getStepZ();
        double distanceToMovement = newDeltaMovement.x() * direction.get().getStepX() + newDeltaMovement.y() * direction.get().getStepY() + newDeltaMovement.z() * direction.get().getStepZ();
        if (distanceToTarget < distanceToMovement) {
            newDeltaMovement = vectorToTarget;
        } else if (direction.get().getAxis().isHorizontal()) {
            Optional<Vec3> newTargetOptional = recalculateTarget(vessel);
            if (newTargetOptional.isPresent()) {
                Vec3 newTarget = newTargetOptional.get();
                this.target = this.target.map(vec3 -> vec3.add(
                        Mth.abs(direction.get().getStepX()) * (newTarget.x() - vec3.x()),
                        Mth.abs(direction.get().getStepY()) * (newTarget.y() - vec3.y()),
                        Mth.abs(direction.get().getStepZ()) * (newTarget.z() - vec3.z())
                ));
                target = this.target.get();
            }
        }

        vessel.setDeltaMovement(newDeltaMovement);
        vessel.move(MoverType.SELF, vessel.getDeltaMovement());
        if ((vessel.getX() - target.x()) * direction.get().getStepX() == 0
                && (vessel.getY() - target.y()) * direction.get().getStepY() == 0
                && (vessel.getZ() - target.z()) * direction.get().getStepZ() == 0) {
            vessel.setDeltaMovement(Vec3.ZERO);
            return Pair.of(true, newDeltaMovement);
        }
        return Pair.of(vessel.position().equals(oldPosition), newDeltaMovement);
    }

    protected boolean isPathFree(OvercastVessel vessel, Direction direction) {
        if (direction.getAxis().isVertical()) return true;
        AABB aabb = vessel.getBoundingBox().deflate(0.01).expandTowards(Vec3.atLowerCornerOf(direction.getNormal()));
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int z = Mth.floor(aabb.minZ); z < aabb.maxZ; z++) {
            for (int x = Mth.floor(aabb.minX); x < aabb.maxX; x++) {
                if (!vessel.level().getBlockState(mutablePos.set(x, Mth.floor(vessel.getY()), z)).isAir()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateDirection(OvercastVessel vessel, Vec3 target) {
        if (target.subtract(vessel.position()).y() > 0.5) {
            direction = Optional.of(Direction.UP);
            return;
        }
        direction = Optional.of(DDUtil.relativeDirection(target, vessel.getBoundingBox()));
    }

    public Optional<Vec3> recalculateTarget(OvercastVessel vessel) {
        if (vessel.getTarget() != null) {
            return Optional.of(vessel.getTarget().position());
        }
        return vessel.getHomePos() == null ? Optional.empty() : Optional.of(Vec3.atBottomCenterOf(vessel.getHomePos().pos()));
    }

    @Override
    public Codec<? extends OvercastVesselPhase> codec() {
        return CODEC;
    }

    @Override
    public OvercastVesselPhaseType getType() {
        return OvercastVesselPhaseType.SLIDER;
    }
}
