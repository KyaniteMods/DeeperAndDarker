package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.custom.entity.AncientChestEntity;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class AncientChestBlock extends DirectionalBlock implements SimpleWaterloggedBlock, EntityBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty POLISHED = BooleanProperty.create("polished");

    private final VoxelShape openShape = Stream.of(Block.box(1, 0, 1, 15, 9, 15)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private final VoxelShape closedShape = Stream.of(
            Block.box(1, 9, 1, 15, 13, 15), Block.box(1, 0, 1, 15, 9, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public AncientChestBlock(Properties properties, boolean isPolished) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(POLISHED, isPolished));
    }

    public boolean isPolished(BlockPos pos, Level level) {
        return level.getBlockState(pos).getValue(AncientChestBlock.POLISHED);
    }

    public boolean isPolished(BlockState state) {
        return state.getValue(AncientChestBlock.POLISHED);
    }
    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    public boolean isSignalSource(BlockState blockState) {
        return true;
    }

    @Override
    public int getDirectSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return direction == Direction.UP ? blockState.getSignal(blockGetter, blockPos, direction) : 0;
    }

    @Override
    public int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return Mth.clamp(AncientChestEntity.getWiggleTicks(blockPos, blockGetter), 0, 15);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(WATERLOGGED);
        builder.add(POLISHED);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if(blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        DeeperAndDarker.LOGGER.info(String.valueOf(isPolished(blockState)));
        //return DDBlockEntityTypes.DEEPSLATE_CHEST.get().create(blockPos, blockState);
        return null;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING,
                blockPlaceContext.getHorizontalDirection().getClockWise().getClockWise());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return (level0, pos, state0, blockEntity) -> ((AncientChestEntity) blockEntity).tick();
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        AncientChestEntity entity = (AncientChestEntity) level.getBlockEntity(blockPos);
        ItemStack item = player.getItemInHand(interactionHand);
        if(item != null) {
            if(item.is(Items.SCULK) && isPolished(blockState)) {
//               level.setBlock(blockPos, DDBlocks.ANCIENT_CHEST.get().defaultBlockState(), 3);
               if(!player.isCreative()) item.shrink(1);
               if(level.isClientSide()) {
                    level.playSound(player, blockPos, SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.BLOCKS, 1, 1);
               }

               return InteractionResult.SUCCESS;
            }
        }
        if(entity != null) {
            if(entity.cooldownTicks == 0) {
                if(isPolished(blockState)) {
                    if(entity.closeTicks > 3) {
                        player.openMenu(entity);
                        return InteractionResult.SUCCESS;
                    }

                    if(entity.closeTicks == 0) {
                        if(level.isClientSide()) {
                            level.playSound(player, blockPos, DDSounds.ANCIENT_CHEST_OPEN.get(), SoundSource.BLOCKS, 2, 1);
                        }

                        player.openMenu(entity);
                        entity.closeTicks = 720;
                    }
                } else {
                    if(entity.closeTicks > 3) {
                        player.openMenu(entity);
                        return InteractionResult.SUCCESS;
                    }

                    if(entity.lidAttempts < 10) {
                        entity.lidAttempts = entity.lidAttempts + 3;
                        entity.wiggleTicks = 20;
                        if(level.isClientSide()) {
                            level.playSound(player, blockPos, SoundEvents.DEEPSLATE_TILES_STEP, SoundSource.BLOCKS, 1, 1);
                        }
                    } else if(entity.lidAttempts > 10 && entity.closeTicks == 0) {
                        if(level.isClientSide()) {
                            level.playSound(player, blockPos, DDSounds.ANCIENT_CHEST_OPEN.get(), SoundSource.BLOCKS, 2, 1);
                        }

                        player.openMenu(entity);
                        entity.closeTicks = 720;
                    }
                }
                level.gameEvent(GameEvent.BLOCK_ACTIVATE, blockPos, GameEvent.Context.of(blockState));
                entity.cooldownTicks = 65;
                return InteractionResult.CONSUME;
            }
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        AncientChestEntity entity = (AncientChestEntity) pLevel.getBlockEntity(pPos);
        if(entity == null) return closedShape;
        return(entity.lidAttempts == 10 ? openShape : closedShape);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
