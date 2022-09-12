package com.kyanite.deeperdarker.registry.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class GeyserBlock extends Block {
    public GeyserBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextInt(2) == 0) {
            for(int i = 0; i < pRandom.nextInt(1) + 1; i++) {
                pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.5F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.6F, false);
                pLevel.addParticle(ParticleTypes.LAVA, (double) pPos.getX() + 0.5D, (double) pPos.getY() + 0.5D, (double) pPos.getZ() + 0.5D, pRandom.nextFloat() / 2.0F, 5.0E-5D, pRandom.nextFloat() / 2.0F);
            }
        }
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        bounceUp(pEntity, pPos);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private void bounceUp(Entity pEntity, BlockPos pos) {
        pEntity.hurt(DamageSource.GENERIC, 2);
        if(pEntity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 125, 1, true, false, false));
        }

        Vec3 vec3 = pEntity.getDeltaMovement();
        double d0 = 2.5;
        pEntity.setDeltaMovement(vec3.x, d0, vec3.z);

        if(pEntity.level.isClientSide()) {
            pEntity.level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 2 + pEntity.level.random.nextFloat(), pEntity.level.random.nextFloat() * 0.7F + 0.6F, false);
            pEntity.level.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0.05d, 0.5d, 0.05d);
        }
    }
}
