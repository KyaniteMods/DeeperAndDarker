package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class DDDamageTypes {
    public static final ResourceKey<DamageType> JAW = createKey("jaw");
    public static final ResourceKey<DamageType> RING = createKey("ring");

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(JAW, new DamageType("jaw", DamageScaling.ALWAYS, 0.1f));
        context.register(RING, new DamageType("ring", 0.1f));
    }

    public static DamageSource source(Level level, ResourceKey<DamageType> damageType, Entity target, Entity attacker) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType), target, attacker);
    }

    public static ResourceKey<DamageType> createKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
