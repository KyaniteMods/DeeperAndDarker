package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDParticleTypes;
import com.kyanite.deeperdarker.content.items.SoulItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class DDSoulFireBlock extends BaseFireBlock {
    private final Supplier<ItemStack> soulItem;

    public DDSoulFireBlock(Properties properties, Supplier<ItemStack> soulItem, float f) {
        super(properties, f);
        this.soulItem = soulItem;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return defaultBlockState();
    }

    @Override
    protected boolean canBurn(BlockState blockState) {
        return false;
    }

    public static boolean canBePlacedAt(Level level, BlockPos blockPos, Direction direction) {
        BlockState blockState = level.getBlockState(blockPos);
        if (!blockState.isAir()) {
            return false;
        }
        return level.getBlockState(blockPos.below()).isFaceSturdy(level, blockPos.below(), Direction.UP);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (blockState2.is(blockState.getBlock())) {
            return;
        }
        if (!blockState.canSurvive(level, blockPos)) {
            level.removeBlock(blockPos, false);
            if (!level.isClientSide()) {
                level.addFreshEntity(new ItemEntity(level, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, soulItem.get()));
            }
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide()) {
            level.levelEvent(null, 1009, blockPos, 0);
            if (!player.getAbilities().instabuild) level.addFreshEntity(new ItemEntity(level, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, soulItem.get()));
        }
        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return soulItem.get();
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(24) == 0) {
            level.playLocalSound((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0f + randomSource.nextFloat(), randomSource.nextFloat() * 0.7f + 0.3f, false);
        }
        if (!(soulItem.get().getItem() instanceof SoulItem soulItem)) return;
        for (int i = 0; i < 3; ++i) {
            double x = (double)blockPos.getX() + randomSource.nextDouble();
            double y = (double)blockPos.getY() + randomSource.nextDouble() * 0.5 + 0.5;
            double z = (double)blockPos.getZ() + randomSource.nextDouble();
            level.addParticle(soulItem.getParticle(), x, y, z, 0.0, 0.0, 0.0);
        }
    }
}
