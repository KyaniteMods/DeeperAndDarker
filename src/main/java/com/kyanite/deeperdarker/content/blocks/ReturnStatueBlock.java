package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.entities.blocks.ReturnStatueBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ReturnStatueBlock extends BaseEntityBlock {
    private static final VoxelShape LOWER = Shapes.or(Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.box(1.0, 4.0, 1.0, 15.0, 8.0, 15.0), Block.box(4.0, 8.0, 4.0, 12.0, 16.0, 12.0));
    private static final VoxelShape UPPER = Shapes.or(Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0));

    public ReturnStatueBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.ENABLED, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.ENABLED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.above()).canBeReplaced(blockPlaceContext)) {
            return defaultBlockState().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER);
        }
        return null;
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        DoubleBlockHalf doubleBlockHalf = blockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            if (blockState2.is(this) && blockState2.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) != doubleBlockHalf) {
                return blockState.setValue(BlockStateProperties.ENABLED, blockState2.getValue(BlockStateProperties.ENABLED));
            }
            return Blocks.AIR.defaultBlockState();
        }
        if (doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.below();
        BlockState blockState2 = levelReader.getBlockState(blockPos2);
        if (blockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            return true;
        }
        return blockState2.is(this);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ReturnStatueBlockEntity(blockPos, blockState);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide() && player.isCreative()) {
            BlockPos blockPos2;
            BlockState blockState2;
            DoubleBlockHalf doubleBlockHalf = blockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
            if (doubleBlockHalf == DoubleBlockHalf.UPPER && (blockState2 = level.getBlockState(blockPos2 = blockPos.below())).is(blockState.getBlock()) && blockState2.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState3 = blockState2.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockPos2, blockState3, 35);
                level.levelEvent(player, 2001, blockPos2, Block.getId(blockState2));
            }
        }
        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        level.setBlock(blockPos.above(), blockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? LOWER : UPPER;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        BlockPos blockEntityPos = pos;
        if (state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) blockEntityPos = pos.below();
        BlockEntity blockEntity = level.getBlockEntity(blockEntityPos);
        if (!(blockEntity instanceof ReturnStatueBlockEntity returnStatue) || returnStatue.teleportPos == null || !state.getValue(BlockStateProperties.ENABLED)) return InteractionResult.PASS;

        player.teleportTo(returnStatue.teleportPos.getX() + 0.5, returnStatue.teleportPos.getY(), returnStatue.teleportPos.getZ() + 0.5);
        level.gameEvent(GameEvent.TELEPORT, returnStatue.teleportPos, GameEvent.Context.of(player));
        if (level.isClientSide()) {
            for (int i = 0; i < 2; ++i) {
                level.addParticle(ParticleTypes.PORTAL, player.getRandomX(0.5), player.getRandomY() - 0.25, player.getRandomZ(0.5), (level.getRandom().nextDouble() - 0.5) * 2.0, -level.getRandom().nextDouble(), (level.getRandom().nextDouble() - 0.5) * 2.0);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }
}
