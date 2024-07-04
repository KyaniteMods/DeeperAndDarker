package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class DDDamageTypes {
    public static final ResourceKey<DamageType> BITE = ResourceKey.create(Registries.DAMAGE_TYPE, DeeperDarker.id("bite"));
    public static final ResourceKey<DamageType> RING = ResourceKey.create(Registries.DAMAGE_TYPE, DeeperDarker.id("ring"));

    public static DamageSource source(Level level, ResourceKey<DamageType> damageType, Entity target, Entity attacker) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType), target, attacker);
    }
}
