package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation, NullableProblems")
public class BloomingStemBlock extends Block {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    private static final VoxelShape[] shapes = {
            Block.box(5, 5, 5, 11, 11, 11),  // CUBE
            Block.box(5, 11, 5, 11, 16, 11), // UP
            Block.box(5, 0, 5, 11, 5, 11),   // DOWN
            Block.box(5, 5, 0, 11, 11, 5),   // NORTH
            Block.box(11, 5, 5, 16, 11, 11), // EAST
            Block.box(5, 5, 11, 11, 11, 16), // SOUTH
            Block.box(0, 5, 5, 5, 11, 11)    // WEST
    };

    public BloomingStemBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(DOWN, true).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos pos = pContext.getClickedPos();
        BlockGetter level = pContext.getLevel();

        BlockState aboveState = level.getBlockState(pos.above());
        BlockState belowState = level.getBlockState(pos.below());
        BlockState northState = level.getBlockState(pos.north());
        BlockState eastState = level.getBlockState(pos.east());
        BlockState southState = level.getBlockState(pos.south());
        BlockState westState = level.getBlockState(pos.west());

        if(checkState(belowState) || belowState.is(DDBlocks.BLOOMING_SCULK_STONE)) return this.defaultBlockState();
        return this.defaultBlockState().setValue(UP, checkState(aboveState)).setValue(DOWN, checkState(belowState) || belowState.is(DDBlocks.BLOOMING_SCULK_STONE)).setValue(NORTH, checkState(northState)).setValue(EAST, checkState(eastState)).setValue(SOUTH, checkState(southState)).setValue(WEST, checkState(westState));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        VoxelShape shape = shapes[0];

        if(pState.getValue(UP)) shape = Shapes.join(shape, shapes[1], BooleanOp.OR);
        if(pState.getValue(DOWN)) shape = Shapes.join(shape, shapes[2], BooleanOp.OR);
        if(pState.getValue(NORTH)) shape = Shapes.join(shape, shapes[3], BooleanOp.OR);
        if(pState.getValue(EAST)) shape = Shapes.join(shape, shapes[4], BooleanOp.OR);
        if(pState.getValue(SOUTH)) shape = Shapes.join(shape, shapes[5], BooleanOp.OR);
        if(pState.getValue(WEST)) shape = Shapes.join(shape, shapes[6], BooleanOp.OR);

        return shape;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if(!pState.canSurvive(pLevel, pPos)) {
            pLevel.scheduleTick(pPos, this, 1);
            return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
        }

        if(pDirection == Direction.DOWN && pNeighborState.is(DDBlocks.BLOOMING_SCULK_STONE)) return pState.setValue(DOWN, true);
        return pState.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(pDirection), checkState(pNeighborState));
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        if (canSurvive(pLevel.getBlockState(pPos.below()))) return true;
        Set<BlockPos> connectedBloomingStems = this.getConnectedBloomingStems(pLevel, pPos);
        for (BlockPos pos : connectedBloomingStems) {
            if (pLevel.getBlockState(pos).getValue(DOWN) && pLevel.getBlockState(pos.below()).is(DDBlocks.BLOOMING_SCULK_STONE)) return true;
        }
        return false;
    }

    public Set<BlockPos> getConnectedBloomingStems(LevelReader pLevel, BlockPos pPos) {
        return this.getConnectedBloomingStems(pLevel, pPos, new HashSet<>());
    }

    private Set<BlockPos> getConnectedBloomingStems(LevelReader pLevel, BlockPos pPos, Set<BlockPos> stemPositions) {
        if (checkState(pLevel.getBlockState(pPos))) stemPositions.add(pPos);
        for (Direction direction : Direction.values()) {
            if (checkState(pLevel.getBlockState(pPos.relative(direction))) && !stemPositions.contains(pPos.relative(direction))) {
                this.getConnectedBloomingStems(pLevel, pPos.relative(direction), stemPositions);
            }
        }
        return stemPositions;
    }

    private boolean canSurvive(BlockState state) {
        return checkState(state) || state.is(DDBlocks.BLOOMING_SCULK_STONE);
    }

    private boolean checkState(BlockState state) {
        return state.is(DDBlocks.BLOOMING_STEM) || state.is(DDBlocks.STRIPPED_BLOOMING_STEM);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        ItemStack stack = player.getItemInHand(interactionHand);
        BlockState strippedBlockState = DDBlocks.STRIPPED_BLOOMING_STEM.defaultBlockState().setValue(UP, state.getValue(UP)).setValue(DOWN, state.getValue(DOWN)).setValue(NORTH, state.getValue(NORTH)).setValue(EAST, state.getValue(EAST)).setValue(SOUTH, state.getValue(SOUTH)).setValue(WEST, state.getValue(WEST));
        if (stack.is(ItemTags.AXES)) {
            level.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, stack);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
            }
            level.setBlock(blockPos, strippedBlockState, 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, strippedBlockState));
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useItemOn(itemStack, state, level, blockPos, player, interactionHand, blockHitResult);
    }
}