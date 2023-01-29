package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class SculkMealItem extends Item {

    public SculkMealItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        if (growPlant(useOnContext.getItemInHand(), level, blockPos)) {
            if (!level.isClientSide) {
                level.playSound(null, blockPos, DDSounds.SCULK_MEAL_USE.get(), SoundSource.BLOCKS, 1, 1);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public static boolean growPlant(ItemStack itemStack, Level level, BlockPos blockPos) {
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.getBlock() instanceof BonemealableBlock bonemealableBlock) {
            if (bonemealableBlock.isValidBonemealTarget(level, blockPos, blockState, level.isClientSide)) {
                if (level instanceof ServerLevel) {
                    if (bonemealableBlock instanceof SaplingBlock) {
                        bonemealableBlock.performBonemeal((ServerLevel)level, level.random, blockPos, blockState);
                    } else if (bonemealableBlock instanceof CropBlock) {
                        level.setBlock(blockPos, ((CropBlock) bonemealableBlock).getStateForAge(7), 2);
                    } else {
                        bonemealableBlock.performBonemeal((ServerLevel)level, level.random, blockPos, blockState);
                    }

                    itemStack.shrink(1);
                }

                return true;
            }
        } else if (blockState.getBlock() instanceof NetherWartBlock && blockState.getValue(NetherWartBlock.AGE) != NetherWartBlock.MAX_AGE) {
            if (level instanceof ServerLevel) {
                itemStack.shrink(1);
            }
            level.setBlock(blockPos, blockState.setValue(NetherWartBlock.AGE, NetherWartBlock.MAX_AGE), 2);

            return true;
        } else if (blockState.getBlock() instanceof CactusBlock && blockState.canSurvive(level, blockPos.above()) && level.getBlockState(blockPos.above()).isAir()) {
            if (level instanceof ServerLevel) {
                itemStack.shrink(1);
            }
            level.setBlock(blockPos, blockState.setValue(CactusBlock.AGE, 0), 2);
            level.setBlock(blockPos.above(), Blocks.CACTUS.defaultBlockState(), 11);

            return true;
        } else if (blockState.getBlock() instanceof SugarCaneBlock && blockState.canSurvive(level, blockPos.above()) && level.getBlockState(blockPos.above()).isAir()) {
            if (level instanceof ServerLevel) {
                itemStack.shrink(1);
            }
            level.setBlock(blockPos, blockState.setValue(SugarCaneBlock.AGE, 0), 2);
            level.setBlock(blockPos.above(), Blocks.SUGAR_CANE.defaultBlockState(), 11);

            return true;
        }

        return false;
    }

    public static void addGrowthParticles(LevelAccessor levelAccessor, BlockPos blockPos, int i) {
        if (i == 0) {
            i = 15;
        }

        BlockState blockState = levelAccessor.getBlockState(blockPos);
        if (!blockState.isAir()) {
            double d = 0.5;
            double e;
            if (blockState.isSolidRender(levelAccessor, blockPos)) {
                blockPos = blockPos.above();
                i *= 3;
                d = 3.0;
                e = 1.0;
            } else {
                e = blockState.getShape(levelAccessor, blockPos).max(Axis.Y);
            }

            levelAccessor.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, 0.0, 0.0, 0.0);
            RandomSource randomSource = levelAccessor.getRandom();

            for(int j = 0; j < i; ++j) {
                double f = randomSource.nextGaussian() * 0.02;
                double g = randomSource.nextGaussian() * 0.02;
                double h = randomSource.nextGaussian() * 0.02;
                double k = 0.5 - d;
                double l = (double)blockPos.getX() + k + randomSource.nextDouble() * d * 2.0;
                double m = (double)blockPos.getY() + randomSource.nextDouble() * e;
                double n = (double)blockPos.getZ() + k + randomSource.nextDouble() * d * 2.0;
                if (!levelAccessor.getBlockState((new BlockPos(l, m, n)).below()).isAir()) {
                    levelAccessor.addParticle(ParticleTypes.HAPPY_VILLAGER, l, m, n, f, g, h);
                }
            }

        }
    }
}
