package com.kyanite.deeperdarker.registry.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GeyserBlock extends Block {
    public GeyserBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextInt(4) == 0) {
            for(int i = 0; i < pRandom.nextInt(1) + 1; ++i) {
                pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.5F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.6F, false);
                pLevel.addParticle(ParticleTypes.LAVA, (double) pPos.getX() + 0.5D, (double) pPos.getY() + 0.5D, (double) pPos.getZ() + 0.5D, pRandom.nextFloat() / 2.0F, 5.0E-5D, pRandom.nextFloat() / 2.0F);
            }
        }
    }
}
