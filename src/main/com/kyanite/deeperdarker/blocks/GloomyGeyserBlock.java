package com.kyanite.deeperdarker.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class GloomyGeyserBlock extends Block {
    public GloomyGeyserBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(50) == 0) {
            world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.5f + random.nextFloat(), random.nextFloat() * 0.15f + 0.9f, false);
            world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5,  pos.getY() + 0.5,  pos.getZ() + 0.5, random.nextFloat() / 2.0f, 5.0e-5d, random.nextFloat() / 2f);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity.isLiving()) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (!EnchantmentHelper.hasFrostWalker(livingEntity)) {
                livingEntity.damage(world.getDamageSources().hotFloor(), 2);
            }
            livingEntity.addVelocity(0.0, 2.5, 0.0);
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 125, 0, true, false, false));

            if (world.isClient()) {
                world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 2 + world.random.nextFloat(), world.random.nextFloat() * 0.7f + 0.6f, false);
                world.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.05, 0.5, 0.05);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
