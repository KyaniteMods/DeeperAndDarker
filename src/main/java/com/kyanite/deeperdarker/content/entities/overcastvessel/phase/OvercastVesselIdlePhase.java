package com.kyanite.deeperdarker.content.entities.overcastvessel.phase;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class OvercastVesselIdlePhase extends OvercastVesselPhase {
    public static final Codec<OvercastVesselIdlePhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("idle_time").forGetter(phase -> phase.idleTime),
            Codec.INT.fieldOf("ticks_left").forGetter(phase -> phase.ticksLeft)
    ).apply(instance, OvercastVesselIdlePhase::new));
    private final int idleTime;
    private int ticksLeft;

    protected OvercastVesselIdlePhase(int idleTime, int ticksLeft) {
        this.idleTime = idleTime;
        this.ticksLeft = ticksLeft;
    }

    public OvercastVesselIdlePhase(int idleTime) {
        this.idleTime = idleTime;
        this.ticksLeft = idleTime;
    }

    @Override
    public boolean shouldContinue(OvercastVessel vessel) {
        return ticksLeft > 0;
    }

    @Override
    public void tick(OvercastVessel vessel) {
        ticksLeft--;
    }

    @Override
    public Codec<? extends OvercastVesselPhase> codec() {
        return CODEC;
    }

    @Override
    public OvercastVesselPhaseType getType() {
        return OvercastVesselPhaseType.IDLE;
    }
}
