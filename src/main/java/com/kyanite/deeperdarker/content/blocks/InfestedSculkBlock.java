package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;

@SuppressWarnings("NullableProblems")
public class InfestedSculkBlock extends Block {
    public InfestedSculkBlock(Block hostBlock, Properties properties) {
        super(properties.destroyTime(hostBlock.defaultDestroyTime() / 2.0f).explosionResistance(0.75f));
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof Player player) {
            level.setBlock(pos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1.5, player.getX() - pos.getX(), player.getZ() - pos.getZ());
            if(level instanceof ServerLevel serverLevel) DDEntities.SHRIEK_WORM.get().spawn(serverLevel, null, pos, EntitySpawnReason.TRIGGERED, true, false);
        }

        if(level.isClientSide() && entity instanceof LivingEntity) {
            RandomSource random = RandomSource.create();
            for(int i = 0; i < 20; i++) {
                double sX = random.nextGaussian() * 0.02;
                double sY = random.nextGaussian() * 0.02;
                double sZ = random.nextGaussian() * 0.02;
                level.addParticle(ParticleTypes.POOF, pos.getX() + random.nextDouble(), pos.above().getY(), pos.getZ() + random.nextDouble(), sX, sY, sZ);
            }
        }
    }

    @Override
    protected void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack tool, boolean dropExperience) {
        if(level.getGameRules().get(GameRules.BLOCK_DROPS) && !EnchantmentHelper.hasTag(tool, EnchantmentTags.PREVENTS_INFESTED_SPAWNS)) {
            SculkLeech leech = DDEntities.SCULK_LEECH.get().create(level, EntitySpawnReason.TRIGGERED);
            if(leech != null) {
                leech.snapTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0f, 0f);
                level.addFreshEntity(leech);
                leech.spawnAnim();
            }
        }
    }
}
