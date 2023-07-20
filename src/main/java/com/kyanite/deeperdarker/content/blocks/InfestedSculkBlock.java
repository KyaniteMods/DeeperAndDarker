package com.kyanite.deeperdarker.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation, NullableProblems")
public class InfestedSculkBlock extends Block {
    public InfestedSculkBlock(Block hostBlock, Properties properties) {
        super(properties.destroyTime(hostBlock.defaultDestroyTime() / 2.0f).explosionResistance(0.75f));

    }

    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);

        /*if(pStack.getEnchantmentLevel(Enchantments.SILK_TOUCH) == 0) {
            if(pLevel.isClientSide()) {
                RandomSource random = RandomSource.create();
                for(int i = 0; i < 20; ++i) {
                    double sX = random.nextGaussian() * 0.02;
                    double sY = random.nextGaussian() * 0.02;
                    double sZ = random.nextGaussian() * 0.02;
                    pLevel.addParticle(ParticleTypes.POOF, pPos.getX() - sX * 10, pPos.getY() - sY * 10, pPos.getZ() - sZ * 10, sX, sY, sZ);
                }
            }
        }*/
    }
}
