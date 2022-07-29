package com.kyanite.deeperdarker.registry.particle;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DDParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DeeperAndDarker.MOD_ID);
}
