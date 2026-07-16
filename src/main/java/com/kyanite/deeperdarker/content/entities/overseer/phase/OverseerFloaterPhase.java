package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.entities.Floater;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;

public class OverseerFloaterPhase extends OverseerPhase {
    public static final Codec<OverseerFloaterPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("idle_time").forGetter(phase -> phase.idleTime),
            Codec.INT.fieldOf("ticks_left").forGetter(phase -> phase.ticksLeft),
            IntProvider.POSITIVE_CODEC.fieldOf("amount").forGetter(phase -> phase.amount),
            IntProvider.POSITIVE_CODEC.fieldOf("size").forGetter(phase -> phase.size)
    ).apply(instance, OverseerFloaterPhase::new));
    private final int idleTime;
    private int ticksLeft;
    private IntProvider amount;
    private IntProvider size;

    protected OverseerFloaterPhase(int idleTime, int ticksLeft, IntProvider amount, IntProvider size) {
        this.idleTime = idleTime;
        this.ticksLeft = ticksLeft;
        this.amount = amount;
        this.size = size;
    }

    public OverseerFloaterPhase(int idleTime, IntProvider amount, IntProvider size) {
        this.idleTime = idleTime;
        this.ticksLeft = idleTime;
        this.amount = amount;
        this.size = size;
    }

    @Override
    public void start(Overseer boss) {
        if (boss.level() instanceof ServerLevel serverLevel) {
            for (int i = 0; i < amount.sample(boss.getRandom()); i++) {
                Floater.generateWorm(size.sample(boss.getRandom()), boss.getX(), boss.getY(), boss.getZ(), serverLevel);
            }
        }
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
        return OverseerPhaseType.FLOATER;
    }
}
