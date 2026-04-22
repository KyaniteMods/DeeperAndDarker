package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.entities.boss.BossPhase;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.mojang.serialization.Codec;

public abstract class OverseerPhase extends BossPhase<Overseer, OverseerPhaseType, OverseerPhase> {
    public static final Codec<OverseerPhase> CODEC = OverseerPhaseType.CODEC.dispatch(OverseerPhase::getType, OverseerPhaseType::getCodec);
}
