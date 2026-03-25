package com.kyanite.deeperdarker.content.items;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class SoulItem extends BlockItem {
    private final ParticleOptions particle;

    public SoulItem(Block block, Properties properties, ParticleOptions particle) {
        super(block, properties);
        this.particle = particle;
    }

    public ParticleOptions getParticle() {
        return particle;
    }

    @Override
    public String getDescriptionId() {
        return getOrCreateDescriptionId();
    }
}
