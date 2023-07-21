package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.ShriekWorm;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("NullableProblems")
public class InfestedSculkBlock extends Block {
    public InfestedSculkBlock(Block hostBlock, Properties properties) {
        super(properties.destroyTime(hostBlock.defaultDestroyTime() / 2.0f).explosionResistance(0.75f));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player player) {
            pLevel.setBlock(pPos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1.5, 1.5, 1.5);
            ShriekWorm entity = DDEntities.SHRIEK_WORM.get().create(pLevel);
            assert entity != null;
            pLevel.addFreshEntity(entity);
            entity.moveTo(pPos.above(), 0, 0);
        }

        if(pLevel.isClientSide()) {
            RandomSource random = RandomSource.create();
            for(int i = 0; i < 20; ++i) {
                double sX = random.nextGaussian() * 0.02;
                double sY = random.nextGaussian() * 0.02;
                double sZ = random.nextGaussian() * 0.02;
                pLevel.addParticle(ParticleTypes.POOF, pPos.getX() + random.nextDouble(), pPos.above().getY(), pPos.getZ() + random.nextDouble(), sX, sY, sZ);
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
