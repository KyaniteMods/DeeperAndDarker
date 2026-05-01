package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.entities.boss.BossPhaseManager;
import com.kyanite.deeperdarker.content.entities.overseer.phase.*;
import com.mojang.serialization.Codec;

public class OverseerPhaseManager extends BossPhaseManager<Overseer, OverseerPhaseType, OverseerPhase> {
    public OverseerPhaseManager(Overseer boss, Codec<OverseerPhase> phaseCodec) {
        super(boss, phaseCodec);
    }

    @Override
    public boolean populatePhases() {
        float healthPercentage = getBoss().getHealth() / getBoss().getMaxHealth();
        if (healthPercentage > 0.75f) {
            getPhases().add(new OverseerCrystalsPhase(3, 300));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(3, 2000));
            return true;
        } else if (healthPercentage > 0.5f) {
            getPhases().add(new OverseerCrystalsPhase(4, 400));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(4, 2000));
            return true;
        } else if (healthPercentage > 0.25f) {
            getPhases().add(new OverseerCrystalsPhase(5, 500));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(5, 2000));
            return true;
        } else {
            getPhases().add(new OverseerCrystalsPhase(5, 450));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(6, 2000));
            return true;
        }
    }
}
