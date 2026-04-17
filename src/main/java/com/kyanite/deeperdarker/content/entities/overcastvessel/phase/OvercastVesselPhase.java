package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.boss.BossPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import com.mojang.serialization.Codec;
import net.minecraft.world.damagesource.DamageSource;

public abstract class OvercastVesselPhase extends BossPhase<OvercastVessel> {
    public static final Codec<OvercastVesselPhase> CODEC = OvercastVesselPhaseType.CODEC.dispatch(OvercastVesselPhase::getType, OvercastVesselPhaseType::getCodec);

    public float onHurt(OvercastVessel vessel, OvercastVesselPart part, DamageSource source, float amount) {
        return vessel.isCracked(part.direction) ? amount : 0.0f;
    }
}
