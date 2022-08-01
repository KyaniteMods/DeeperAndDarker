package com.kyanite.deeperdarker.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public class DDParticleUtils {
    public static void clientDiggingParticles(RandomSource randomsource, BlockState blockstate, BlockPos pos, Level level) {
        if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            for (int i = 0; i < 30; i++) {
                double d0 = pos.getX() + (double) Mth.randomBetween(randomsource, -0.7F, 0.7F);
                double d1 = pos.getY();
                double d2 = pos.getZ() + (double) Mth.randomBetween(randomsource, -0.7F, 0.7F);
                level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
