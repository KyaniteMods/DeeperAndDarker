package com.kyanite.deeperdarker.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("NullableProblems")
public class GeyserBlock extends Block {
    public GeyserBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(random.nextInt(50) == 0) {
            level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.5f + random.nextFloat() * 0.5f, random.nextFloat() * 0.1f + 0.85f, false);
            level.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, random.nextFloat() / 2.0f, 5.0e-5d, random.nextFloat() / 2f);
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ExperienceOrb) return;
//        entity.hurt(level.damageSources().hotFloor(), 2);
        entity.setDeltaMovement(entity.getDeltaMovement().x(), 2.5, entity.getDeltaMovement().z());
        if(level.isClientSide()) {
            level.playLocalSound( pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 2 + level.random.nextFloat(), level.random.nextFloat() * 0.7f + 0.6f, false);
            level.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0.05, 0.5, 0.05);
        }
    }
}
