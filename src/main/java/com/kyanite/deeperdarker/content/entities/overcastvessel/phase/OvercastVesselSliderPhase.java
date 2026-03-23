package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class OvercastVesselSliderPhase extends OvercastVesselPhase {
    public static final Codec<OvercastVesselSliderPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("max_slides").forGetter(phase -> phase.maxSlides),
            Codec.INT.fieldOf("slides").forGetter(phase -> phase.slides),
            Direction.CODEC.optionalFieldOf("direction").forGetter(phase -> phase.direction),
            Vec3.CODEC.optionalFieldOf("target").forGetter(phase -> phase.target),
            Codec.INT.fieldOf("move_time").forGetter(phase -> phase.moveTime)
    ).apply(instance, OvercastVesselSliderPhase::new));
    private final int maxSlides;
    private int slides;
    private Optional<Direction> direction;
    private Optional<Vec3> target;
    private int moveTime;

    private OvercastVesselSliderPhase(int maxSlides, int slides, Optional<Direction> direction, Optional<Vec3> target, int moveTime) {
        this.maxSlides = maxSlides;
        this.slides = slides;
        this.direction = direction;
        this.target = target;
        this.moveTime = moveTime;
    }

    public OvercastVesselSliderPhase(int maxSlides) {
        this(maxSlides, 0, Optional.empty(), Optional.empty(), 0);
    }

    @Override
    public boolean shouldContinue(OvercastVessel vessel) {
        return slides < maxSlides && target.isPresent();
    }

    public void initialize(OvercastVessel vessel) {
        vessel.setSnapToBlocks(false);
        recalculateTarget(vessel);
    }

    @Override
    public void end(OvercastVessel vessel) {
        vessel.setSnapToBlocks(true);
    }

    @Override
    public void tick(OvercastVessel vessel) {
        if (vessel.level().isClientSide()) return;
        if (target.isEmpty()) recalculateTarget(vessel);
        if (direction.isEmpty()) updateDirection(vessel);
        if (moveTime > 0) {
            moveTime--;
            return;
        }

        Vec3 deltaMovement = vessel.getDeltaMovement();
        Vec3 oldPosition = vessel.position();
        Vec3 vectorToTarget = target.get().subtract(vessel.position()).multiply(Mth.abs(direction.get().getStepX()), Mth.abs(direction.get().getStepY()), Mth.abs(direction.get().getStepZ()));
        Vec3 newDeltaMovement = new Vec3(
                DDUtil.absMin(vectorToTarget.x(), deltaMovement.x() + direction.get().getStepX() * 0.04),
                DDUtil.absMin(vectorToTarget.y(), deltaMovement.y() + direction.get().getStepY() * 0.1),
                DDUtil.absMin(vectorToTarget.z(), deltaMovement.z() + direction.get().getStepZ() * 0.04)
        );

        vessel.setDeltaMovement(newDeltaMovement);
        vessel.move(MoverType.SELF, vessel.getDeltaMovement());
        Vec3 newPosition = vessel.position();
        Vec3 newVectorToTarget = target.get().subtract(vessel.position()).multiply(Mth.abs(direction.get().getStepX()), Mth.abs(direction.get().getStepY()), Mth.abs(direction.get().getStepZ()));
        if (vessel.getDeltaMovement().equals(Vec3.ZERO) || newPosition.equals(oldPosition) || vessel.verticalCollision || vessel.horizontalCollision || newVectorToTarget.lengthSqr() == 0) {
            if ((vessel.verticalCollision || vessel.horizontalCollision) && newDeltaMovement.lengthSqr() > newPosition.distanceToSqr(oldPosition) && newDeltaMovement.lengthSqr() > 0.2) {
                vessel.addCrackDirection(direction.get());
                moveTime = 40;
            } else {
                moveTime = 5;
            }
            vessel.setDeltaMovement(Vec3.ZERO);
            recalculateTarget(vessel);
            updateDirection(vessel);
        }

        vessel.hurtPlayersInside();
    }

    public void updateDirection(OvercastVessel vessel) {
        if (target.get().y() - vessel.getY() > 1.0E-6) {
            direction = Optional.of(Direction.UP);
            return;
        }
        direction = Optional.of(DDUtil.relativeDirection(target.get(), vessel.getBoundingBox()));
    }

    public void recalculateTarget(OvercastVessel vessel) {
        if (vessel.getTarget() != null) {
            target = Optional.of(vessel.getRandom().nextFloat() < 0.1f ? vessel.getTarget().position().add(0.0, 1.0, 0.0) : vessel.getTarget().position());
            return;
        }
        target = vessel.getHomePos() == null ? Optional.empty() : Optional.of(Vec3.atBottomCenterOf(vessel.getHomePos().pos()));
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
