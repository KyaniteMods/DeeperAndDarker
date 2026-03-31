package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public final class DDDamageTypes {
    private DDDamageTypes() {}

    public static final ResourceKey<DamageType> BITE = createKey("bite");
    public static final ResourceKey<DamageType> RING = createKey("ring");
    public static final ResourceKey<DamageType> DARK_FOUNTAIN = createKey("dark_fountain");
    public static final ResourceKey<DamageType> ICICLE = createKey("icicle");
    public static final ResourceKey<DamageType> ACID = createKey("acid");

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(BITE, new DamageType(DeeperDarker.MOD_ID + ".bite", 0.1f));
        context.register(RING, new DamageType(DeeperDarker.MOD_ID + ".ring", 0.1f));
        context.register(DARK_FOUNTAIN, new DamageType(DeeperDarker.MOD_ID + ".dark_fountain", 0.1f));
        context.register(ICICLE, new DamageType(DeeperDarker.MOD_ID + ".icicle", 0.1f));
        context.register(ACID, new DamageType(DeeperDarker.MOD_ID + ".acid", 0.1f));
    }

    public static DamageSource source(Level level, ResourceKey<DamageType> damageType, Entity target, Entity attacker) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType), target, attacker);
    }

    public static ResourceKey<DamageType> createKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}