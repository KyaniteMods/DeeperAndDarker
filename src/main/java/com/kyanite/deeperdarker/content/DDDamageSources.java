package com.kyanite.deeperdarker.content;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

public class DDDamageSources {
    public static final DamageSource BITE = new DamageSource("deeperdarker.bite");
    public static DamageSource ring(Entity attacker, @Nullable Entity entity) {
        return new IndirectEntityDamageSource("deeperdarker.ring", attacker, entity);
    }
}
