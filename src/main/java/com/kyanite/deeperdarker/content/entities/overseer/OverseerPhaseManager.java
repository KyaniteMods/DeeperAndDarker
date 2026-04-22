package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.entities.boss.BossPhaseManager;
import com.kyanite.deeperdarker.content.entities.overseer.phase.OverseerPhase;
import com.kyanite.deeperdarker.content.entities.overseer.phase.OverseerPhaseType;
import com.mojang.serialization.Codec;

public class OverseerPhaseManager extends BossPhaseManager<Overseer, OverseerPhaseType, OverseerPhase> {
    public OverseerPhaseManager(Overseer boss, Codec<OverseerPhase> phaseCodec) {
        super(boss, phaseCodec);
    }

    @Override
    public boolean populatePhases() {
        return false;
    }
}
