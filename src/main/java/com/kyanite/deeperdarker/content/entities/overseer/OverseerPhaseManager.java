package com.kyanite.deeperdarker.content.entities.overseer;

import com.kyanite.deeperdarker.content.entities.boss.BossPhaseManager;
import com.kyanite.deeperdarker.content.entities.overseer.phase.*;
import com.mojang.serialization.Codec;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;

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
            getPhases().add(new OverseerLasersPhase(3, 400));
            getPhases().add(new OverseerFloaterPhase(1000, ConstantInt.of(3), UniformInt.of(4, 6)));
            return true;
        } else if (healthPercentage > 0.5f) {
            getPhases().add(new OverseerCrystalsPhase(4, 400));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(4, 400));
            getPhases().add(new OverseerFloaterPhase(1000, ConstantInt.of(3), UniformInt.of(5, 8)));
            return true;
        } else if (healthPercentage > 0.25f) {
            getPhases().add(new OverseerCrystalsPhase(5, 500));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(5, 400));
            getPhases().add(new OverseerFloaterPhase(1000, ConstantInt.of(4), UniformInt.of(5, 8)));
            return true;
        } else {
            getPhases().add(new OverseerCrystalsPhase(5, 450));
            getPhases().add(new OverseerIdlePhase(100));
            getPhases().add(new OverseerLasersPhase(6, 300));
            getPhases().add(new OverseerFloaterPhase(1000, ConstantInt.of(4), UniformInt.of(6, 8)));
            return true;
        }
    }
}
