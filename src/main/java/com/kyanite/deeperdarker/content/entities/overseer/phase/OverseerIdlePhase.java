package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhase;
import com.kyanite.deeperdarker.content.entities.overcastvessel.phase.OvercastVesselPhaseType;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class OverseerIdlePhase extends OverseerPhase {
    public static final Codec<OverseerIdlePhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("idle_time").forGetter(phase -> phase.idleTime),
            Codec.INT.fieldOf("ticks_left").forGetter(phase -> phase.ticksLeft)
    ).apply(instance, OverseerIdlePhase::new));
    private final int idleTime;
    private int ticksLeft;

    protected OverseerIdlePhase(int idleTime, int ticksLeft) {
        this.idleTime = idleTime;
        this.ticksLeft = ticksLeft;
    }

    public OverseerIdlePhase(int idleTime) {
        this.idleTime = idleTime;
        this.ticksLeft = idleTime;
    }

    @Override
    public boolean shouldContinue(Overseer overseer) {
        return ticksLeft > 0;
    }

    @Override
    public void tick(Overseer overseer) {
        ticksLeft--;
    }

    @Override
    public Codec<? extends OverseerPhase> codec() {
        return CODEC;
    }

    @Override
    public OverseerPhaseType getType() {
        return OverseerPhaseType.IDLE;
    }
}
