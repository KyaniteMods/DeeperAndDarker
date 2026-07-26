package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class DDParticleTypes {
    public static final SimpleParticleType SCULK_FIRE_FLAME = register("sculk_fire_flame", FabricParticleTypes.simple());
    public static final SimpleParticleType PATIENCE_SOUL = register("patience_soul", FabricParticleTypes.simple());
    public static final SimpleParticleType FORTITUDE_SOUL = register("fortitude_soul", FabricParticleTypes.simple());
    public static final SimpleParticleType CORRUPTION_SOUL = register("corruption_soul", FabricParticleTypes.simple());
    public static final SimpleParticleType PURITY_SOUL = register("purity_soul", FabricParticleTypes.simple());
    public static final SimpleParticleType VIRTUE_SOUL = register("virtue_soul", FabricParticleTypes.simple());
    public static final SimpleParticleType DRIPPING_ACID = register("dripping_acid", FabricParticleTypes.simple());
    public static final SimpleParticleType FALLING_ACID = register("falling_acid", FabricParticleTypes.simple());
    public static final SimpleParticleType LANDING_ACID = register("landing_acid", FabricParticleTypes.simple());

    private static <U extends ParticleOptions, T extends ParticleType<U>> T register(String id, T particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, DeeperDarker.id(id), particleType);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering particle types");
    }
}
