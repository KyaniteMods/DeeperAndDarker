package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Holder;
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
    public static final ResourceKey<DamageType> OVERSEER_CRYSTAL = createKey("overseer_crystal");

    public static void bootstrap(BootstapContext<DamageType> context) {
        register(context, BITE, 0.1f);
        register(context, RING, 0.1f);
        register(context, DARK_FOUNTAIN, 0.1f);
        register(context, ICICLE, 0.1f);
        register(context, ACID, 0.1f);
        register(context, OVERSEER_CRYSTAL, 0.1f);
    }

    private static Holder.Reference<DamageType> register(BootstapContext<DamageType> context, ResourceKey<DamageType> resourceKey, float f) {
        return context.register(resourceKey, new DamageType(DeeperDarker.MOD_ID + "." + resourceKey.location().getPath(), f));
    }

    public static DamageSource source(Level level, ResourceKey<DamageType> damageType, Entity target, Entity attacker) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType), target, attacker);
    }

    public static ResourceKey<DamageType> createKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, DeeperDarker.id(name));
    }
}