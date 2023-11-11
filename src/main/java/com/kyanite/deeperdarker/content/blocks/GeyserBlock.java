package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.util.DDConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("NullableProblems")
public class GeyserBlock extends Block {
    public GeyserBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextInt(50) == 0) {
            pLevel.playLocalSound(pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.5f + pRandom.nextFloat() * 0.5f, pRandom.nextFloat() * 0.1f + 0.85f, false);
            pLevel.addParticle(ParticleTypes.LAVA, pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5, pRandom.nextFloat() / 2.0f, 5.0e-5d, pRandom.nextFloat() / 2f);
        }
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ExperienceOrb) return;
//        pEntity.hurt(pLevel.damageSources().hotFloor(), 2);
        pEntity.setDeltaMovement(pEntity.getDeltaMovement().x(), 2.5, pEntity.getDeltaMovement().z());

        if (!pLevel.isClientSide() && DDConfig.HANDLER.getConfig().geysersApplySlowFalling && pEntity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 125));
        }

        if(pLevel.isClientSide()) {
            pLevel.playLocalSound( pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 2 + pLevel.random.nextFloat(), pLevel.random.nextFloat() * 0.7f + 0.6f, false);
            pLevel.addParticle(ParticleTypes.LARGE_SMOKE, pPos.getX(), pPos.getY(), pPos.getZ(), 0.05, 0.5, 0.05);
        }
    }
}
