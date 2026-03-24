package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
        target = recalculateTarget(vessel);
    }

    @Override
    public void end(OvercastVessel vessel) {
        vessel.setSnapToBlocks(true);
    }

    @Override
    public void tick(OvercastVessel vessel) {
        if (vessel.level().isClientSide()) return;
        phaseTime++;

        if (target.isEmpty()) recalculateTargetAndDirection(vessel);

        if (moveTime > 0) {
            moveTime--;
            return;
        }

        if (slideTowardTarget(vessel, target.get())) {
            Vec3 deltaMovement = vessel.getDeltaMovement();
            if (vessel.verticalCollision || vessel.horizontalCollision && deltaMovement.lengthSqr() > 0.2 && !vessel.isCracked(direction.get())) {
                vessel.addCrackDirection(direction.get());
                moveTime = 20;
            } else {
                moveTime = 2;
            }
            recalculateTargetAndDirection(vessel);
            if (direction.get().getAxis().isHorizontal() && !isPathFree(vessel, direction.get())) {
                target = target.map(vec3 -> vec3.add(0.0, 1.0, 0.0));
            }
        } else {
            overrideTarget = Optional.empty();
        }

        vessel.hurtPlayersInside();
    }

    protected void recalculateTargetAndDirection(OvercastVessel vessel) {
        target = recalculateTarget(vessel);
        updateDirection(vessel, target.get());

        if (!isPathFree(vessel, direction.get())) {
            target = target.map(vec3 -> vec3.add(0.0, 1.0, 0.0));
            updateDirection(vessel, target.get());
        }
    }

    /**
     * @return if the target was reached
     */
    protected boolean slideTowardTarget(OvercastVessel vessel, Vec3 target) {
        Vec3 deltaMovement = vessel.getDeltaMovement();
        Vec3 oldPosition = vessel.position();
        Vec3 vectorToTarget = target.subtract(vessel.position()).multiply(Mth.abs(direction.get().getStepX()), Mth.abs(direction.get().getStepY()), Mth.abs(direction.get().getStepZ()));
        Vec3 newDeltaMovement = new Vec3(
                deltaMovement.x() + direction.get().getStepX() * 0.06,
                deltaMovement.y() + direction.get().getStepY() * 0.06,
                deltaMovement.z() + direction.get().getStepZ() * 0.06
        );
        if (vectorToTarget.lengthSqr() < newDeltaMovement.lengthSqr()) {
            newDeltaMovement = vectorToTarget;
        } else {
            Vec3 newTarget = recalculateTarget(vessel).get();
            this.target = this.target.map(vec3 -> vec3.add(
                    direction.get().getStepX() * (newTarget.x() - vec3.x()),
                    direction.get().getStepY() * (newTarget.y() - vec3.y()),
                    direction.get().getStepZ() * (newTarget.z() - vec3.z())
            ));
        }

        vessel.setDeltaMovement(newDeltaMovement);
        vessel.move(MoverType.SELF, vessel.getDeltaMovement());
        if (vessel.getTarget() instanceof ServerPlayer serverPlayer) {
            serverPlayer.displayClientMessage(Component.literal("Direction: " + direction.get().getName()), true);
        }
        if ((vessel.getX() - target.x()) * direction.get().getStepX() == 0
                && (vessel.getY() - target.y()) * direction.get().getStepY() == 0
                && (vessel.getZ() - target.z()) * direction.get().getStepZ() == 0) {
            vessel.setDeltaMovement(Vec3.ZERO);
            return true;
        }
        return vessel.position().equals(oldPosition);
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
