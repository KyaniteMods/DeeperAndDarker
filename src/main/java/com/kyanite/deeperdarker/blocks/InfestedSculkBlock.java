package com.kyanite.deeperdarker.blocks;

import com.kyanite.deeperdarker.entities.DeeperDarkerEntityTypes;
import com.kyanite.deeperdarker.entities.ShriekWormEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class InfestedSculkBlock extends Block {
    public InfestedSculkBlock(Block hostBlock, AbstractBlock.Settings settings) {
        super(settings.hardness(hostBlock.getHardness() / 2.0f).resistance(0.75f));

    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof PlayerEntity player) {
            world.setBlockState(pos, Blocks.SCULK.getDefaultState(), 3);
            player.takeKnockback(1.5, 1.5, 1.5);
            ShriekWormEntity shriekWorm = DeeperDarkerEntityTypes.SHRIEK_WORM.create(world);
            assert shriekWorm != null;
            world.spawnEntity(shriekWorm);
            shriekWorm.refreshPositionAndAngles(pos.up(), 0, 0);
        }

        if (world.isClient()) {
            Random random = Random.create();
            for (int i = 0; i < 20; ++i) {
                double sX = random.nextGaussian() * 0.02;
                double sY = random.nextGaussian() * 0.02;
                double sZ = random.nextGaussian() * 0.02;
                world.addParticle(ParticleTypes.POOF, pos.getX() + random.nextDouble(), pos.up().getY(), pos.getZ() + random.nextDouble(), sX, sY, sZ);
            }
        }
    }
}