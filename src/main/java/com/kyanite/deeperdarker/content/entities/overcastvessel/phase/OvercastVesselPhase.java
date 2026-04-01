package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import com.mojang.serialization.Codec;
import net.minecraft.world.damagesource.DamageSource;

public abstract class OvercastVesselPhase {
    public static final Codec<OvercastVesselPhase> CODEC = OvercastVesselPhaseType.CODEC.dispatch(OvercastVesselPhase::getType, OvercastVesselPhaseType::getCodec);
    public abstract boolean shouldContinue(OvercastVessel vessel);
    public abstract Codec<? extends OvercastVesselPhase> codec();
    public abstract OvercastVesselPhaseType getType();
    // Runs on data loaded.
    public void initialize(OvercastVessel vessel) {

    }
    public void start(OvercastVessel vessel) {

    }
    public void tick(OvercastVessel vessel) {

    }
    public void end(OvercastVessel vessel) {

    }
    public float onHurt(OvercastVessel vessel, OvercastVesselPart part, DamageSource source, float amount) {
        return vessel.isCracked(part.direction) ? amount : 0.0f;
    }
}
