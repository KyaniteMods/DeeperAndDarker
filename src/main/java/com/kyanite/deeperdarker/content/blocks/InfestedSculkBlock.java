package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation, NullableProblems")
public class InfestedSculkBlock extends Block {
    public InfestedSculkBlock(Block hostBlock, Properties properties) {
        super(properties.destroyTime(hostBlock.defaultDestroyTime() / 2.0f).explosionResistance(0.75f));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player player) {
            pLevel.setBlock(pPos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1.5, player.getX() - pPos.getX(), player.getZ() - pPos.getZ());
            if(pLevel instanceof ServerLevel serverLevel) DDEntities.SHRIEK_WORM.get().spawn(serverLevel, pPos, MobSpawnType.TRIGGERED);
        }

        if(pLevel.isClientSide() && pEntity instanceof LivingEntity) {
            RandomSource random = RandomSource.create();
            for(int i = 0; i < 20; i++) {
                double sX = random.nextGaussian() * 0.02;
                double sY = random.nextGaussian() * 0.02;
                double sZ = random.nextGaussian() * 0.02;
                pLevel.addParticle(ParticleTypes.POOF, pPos.getX() + random.nextDouble(), pPos.above().getY(), pPos.getZ() + random.nextDouble(), sX, sY, sZ);
            }
        }
    }

    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if(pStack.getEnchantmentLevel(Enchantments.SILK_TOUCH) == 0) {
            SculkLeech leech = DDEntities.SCULK_LEECH.get().create(pLevel);
            if(leech != null) {
                leech.moveTo(pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5, 0, 0);
                pLevel.addFreshEntity(leech);
                leech.spawnAnim();
            }
        }
    }
}
