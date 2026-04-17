package com.kyanite.deeperdarker.content.entities.boss;

import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhaseType;
import com.mojang.serialization.Codec;
import net.minecraft.world.entity.LivingEntity;

public abstract class BossPhase<T extends LivingEntity> {
    public abstract boolean shouldContinue(T vessel);
    public abstract Codec<? extends BossPhase<T>> codec();
    public abstract OvercastVesselPhaseType getType();
    // Runs on data loaded.
    public void initialize(T boss) {

    }
    public void start(T boss) {

    }
    public void tick(T boss) {

    }
    public void end(T boss) {

    }
}
