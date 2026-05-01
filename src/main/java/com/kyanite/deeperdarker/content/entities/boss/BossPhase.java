package com.kyanite.deeperdarker.content.entities.boss;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.LivingEntity;

public abstract class BossPhase<T extends LivingEntity, U extends BossPhaseType<T, U, V>, V extends BossPhase<T, U, V>> {
    public abstract boolean shouldContinue(T vessel);
    public abstract Codec<? extends V> codec();
    public abstract U getType();

    public void dataSaved(T boss) {

    }
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
