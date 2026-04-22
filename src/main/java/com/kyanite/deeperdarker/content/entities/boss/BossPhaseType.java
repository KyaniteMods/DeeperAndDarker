package com.kyanite.deeperdarker.content.entities.boss;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.LivingEntity;

public interface BossPhaseType<T extends LivingEntity, U extends BossPhaseType<T, U, V>, V extends BossPhase<T, U, V>> {
    Codec<? extends V> getCodec();
}
