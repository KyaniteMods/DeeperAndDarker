package com.kyanite.deeperdarker.content.items;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.Item;

public class SoulItem extends Item {
    private final ParticleOptions particle;

    public SoulItem(Properties properties, ParticleOptions particle) {
        super(properties);
        this.particle = particle;
    }

    public ParticleOptions getParticle() {
        return particle;
    }
}
