package com.kyanite.deeperdarker.registry.particle;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class DDParticleUtils {
    public static void clientDiggingParticles(RandomSource randomSource, BlockState state, BlockPos pos, Level level) {
        for(int i = 0; i < 30; i++) {
            double d0 = pos.getX() + (double) Mth.randomBetween(randomSource, -0.7F, 0.7F);
            double d1 = pos.getY();
            double d2 = pos.getZ() + (double) Mth.randomBetween(randomSource, -0.7F, 0.7F);
            level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, state), d0, d1, d2, 0, 0, 0);
        }
    }

    public static void spawnHeartParticles(Entity entity, RandomSource randomSource) {
        ParticleOptions particle = ParticleTypes.HEART;
        for(int i = 0; i < 7; i++) {
            double x = randomSource.nextGaussian() * 0.02D;
            double y = randomSource.nextGaussian() * 0.02D;
            double z = randomSource.nextGaussian() * 0.02D;
            entity.level.addParticle(particle, entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1), x, y, z);
        }
    }
}
