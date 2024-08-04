package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
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
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof Player player) {
            level.setBlock(pos, Blocks.SCULK.defaultBlockState(), 3);
            player.knockback(1.5, player.getX() - pos.getX(), player.getZ() - pos.getZ());
            if(level instanceof ServerLevel serverLevel) DDEntities.SHRIEK_WORM.get().spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
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
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
        super.spawnAfterBreak(state, level, pos, stack, dropExperience);
        HolderLookup.RegistryLookup<Enchantment> lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

        if(stack.getEnchantmentLevel(lookup.getOrThrow(Enchantments.SILK_TOUCH)) == 0) {
            SculkLeech leech = DDEntities.SCULK_LEECH.get().create(level);
            if(leech != null) {
                leech.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                level.addFreshEntity(leech);
                leech.spawnAnim();
            }
        }
    }
}
