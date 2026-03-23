package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class OvercastVesselSliderPhase extends OvercastVesselPhase {
    public static final Codec<OvercastVesselSliderPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("max_slides").forGetter(phase -> phase.maxSlides),
            Codec.INT.fieldOf("slides").forGetter(phase -> phase.slides),
            Direction.CODEC.optionalFieldOf("direction").forGetter(phase -> phase.direction),
            Vec3.CODEC.optionalFieldOf("target").forGetter(phase -> phase.target)
    ).apply(instance, OvercastVesselSliderPhase::new));
    private final int maxSlides;
    private int slides;
    private Optional<Direction> direction;
    private Optional<Vec3> target;

    private OvercastVesselSliderPhase(int maxSlides, int slides, Optional<Direction> direction, Optional<Vec3> target) {
        this.maxSlides = maxSlides;
        this.slides = slides;
        this.direction = direction;
        this.target = target;
    }

    public OvercastVesselSliderPhase(int maxSlides) {
        this(maxSlides, 0, Optional.empty(), Optional.empty());
    }

    @Override
    public boolean shouldContinue(OvercastVessel vessel) {
        return slides < maxSlides && target.isPresent();
    }

    public void initialize(OvercastVessel vessel) {
        vessel.snapToBlocks = false;
        recalculateTarget(vessel);
    }

    @Override
    public void end(OvercastVessel vessel) {
        vessel.snapToBlocks = true;
    }

    @Override
    public void tick(OvercastVessel vessel) {
        if (vessel.level().isClientSide()) return;
        if (target.isEmpty()) recalculateTarget(vessel);
        if (direction.isEmpty()) updateDirection(vessel);

        Vec3 deltaMovement = vessel.getDeltaMovement();
        Vec3 position = vessel.position();
        Vec3 vectorToTarget = target.get().subtract(vessel.position()).multiply(Mth.abs(direction.get().getStepX()), Mth.abs(direction.get().getStepY()), Mth.abs(direction.get().getStepZ()));
        Vec3 newDeltaMovement = new Vec3(
                DDUtil.absMin(vectorToTarget.x(), deltaMovement.x() + direction.get().getStepX() * 0.04),
                DDUtil.absMin(vectorToTarget.y(), deltaMovement.y() + direction.get().getStepY() * 0.1),
                DDUtil.absMin(vectorToTarget.z(), deltaMovement.z() + direction.get().getStepZ() * 0.04)
        );

        vessel.setDeltaMovement(newDeltaMovement);
        vessel.move(MoverType.SELF, vessel.getDeltaMovement());
        Vec3 vectorToTarget2 = target.get().subtract(vessel.position()).multiply(Mth.abs(direction.get().getStepX()), Mth.abs(direction.get().getStepY()), Mth.abs(direction.get().getStepZ()));
        if (vessel.getDeltaMovement().equals(Vec3.ZERO) || vessel.position().equals(position) || vessel.verticalCollision || vessel.horizontalCollision || vectorToTarget2.lengthSqr() == 0) {
            vessel.setDeltaMovement(Vec3.ZERO);
            if (vessel.verticalCollision || vessel.horizontalCollision) {
                vessel.setCrackDirection(direction.get());
            }
            recalculateTarget(vessel);
            updateDirection(vessel);
        }

        vessel.hurtEntitiesInside();
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
