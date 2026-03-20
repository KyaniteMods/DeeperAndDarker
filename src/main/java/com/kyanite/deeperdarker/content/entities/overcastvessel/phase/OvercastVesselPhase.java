package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.mojang.serialization.Codec;

public abstract class OvercastVesselPhase {
    public static final Codec<OvercastVesselPhase> CODEC = OvercastVesselPhaseType.CODEC.dispatch(OvercastVesselPhase::getType, OvercastVesselPhaseType::getCodec);
    public abstract boolean shouldContinue(OvercastVessel vessel);
    public abstract Codec<? extends OvercastVesselPhase> codec();
    public abstract OvercastVesselPhaseType getType();
    public void start(OvercastVessel vessel) {

    }
    public void tick(OvercastVessel vessel) {

    }
    public void end(OvercastVessel vessel) {

    }
}
