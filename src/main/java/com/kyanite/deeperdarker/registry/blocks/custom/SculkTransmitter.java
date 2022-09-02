package com.kyanite.deeperdarker.registry.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class SculkTransmitter extends Block {
    public SculkTransmitter(Properties pProperties) {
        super(pProperties);
    }

    public final RandomSource randomSource = RandomSource.create();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(
                Block.box(14, 0, 2, 16, 8, 14),
                Block.box(0, 0, 0, 16, 8, 2),
                Block.box(0, 0, 14, 16, 8, 16),
                Block.box(0, 0, 2, 2, 8, 14),
                Block.box(2, 0, 2, 14, 7, 14)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);

        for(int i = 0; i < 5; i++) {
            pLevel.addParticle(ParticleTypes.SCULK_SOUL, pPos.getX() + randomSource.nextDouble(), pPos.getY() + 0.5D, pPos.getZ() + randomSource.nextDouble(), 0.0D, 0.05D, 0.0D);
        }
    }

    public void teleportEntity(Entity entity, BlockPos pos, Level level) {
        if(entity == null) return;

        entity.teleportTo(pos.above().getX(), pos.above().getY(), pos.above().getZ());
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
        if(pLevel.hasNeighborSignal(pPos)) {
            Player player = pLevel.getNearestPlayer(pPos.getX(), pPos.getY(), pPos.getZ(), 50, true);
            if(player == null) return;
            teleportEntity(player, pPos, pLevel);
            pLevel.playSound(null, pPos, SoundEvents.SCULK_BLOCK_SPREAD, SoundSource.BLOCKS, 1  , 1);
        }
    }
}
