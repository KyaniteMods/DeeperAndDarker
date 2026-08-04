package com.kyanite.deeperdarker.content.entities.overseer.phase;

import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.phys.Vec3;

public class OverseerShootCrystalsPhase extends OverseerPhase {
    public static final Codec<OverseerShootCrystalsPhase> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("crystals").forGetter(phase -> phase.crystals),
            Codec.INT.fieldOf("crystals_left").forGetter(phase -> phase.crystalsLeft),
            Codec.FLOAT.fieldOf("probability").forGetter(phase -> phase.probability)
    ).apply(instance, OverseerShootCrystalsPhase::new));
    private final int crystals;
    private int crystalsLeft;
    private final float probability;

    protected OverseerShootCrystalsPhase(int crystals, int crystalsLeft, float probability) {
        this.crystals = crystals;
        this.crystalsLeft = crystalsLeft;
        this.probability = probability;
    }

    public OverseerShootCrystalsPhase(int crystals, float probability) {
        this.crystals = crystals;
        crystalsLeft = crystals;
        this.probability = probability;
    }

    @Override
    public boolean shouldContinue(Overseer overseer) {
        return crystalsLeft > 0;
    }

    @Override
    public void tick(Overseer overseer) {
        if (overseer.getRandom().nextFloat() < probability) {
            Vec3 vec3 = Vec3.directionFromRotation(overseer.getRandom().nextFloat() * 360.0f, overseer.getRandom().nextFloat() * 360.0f).scale(0.01);
            overseer.performRangedAttack(vec3.x(), vec3.y(), vec3.z());
            crystalsLeft--;
        }
    }

    @Override
    public Codec<? extends OverseerPhase> codec() {
        return CODEC;
    }

    @Override
    public OverseerPhaseType getType() {
        return OverseerPhaseType.SHOOT_CRYSTALS;
    }
}
