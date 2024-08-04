package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("NullableProblems")
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

    public BloomingStemBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(DOWN, true).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockGetter level = context.getLevel();

        BlockState belowState = level.getBlockState(pos.below());
        BlockState northState = level.getBlockState(pos.north());
        BlockState eastState = level.getBlockState(pos.east());
        BlockState southState = level.getBlockState(pos.south());
        BlockState westState = level.getBlockState(pos.west());

        if(checkState(belowState) || belowState.is(DDBlocks.BLOOMING_SCULK_STONE.get())) return this.defaultBlockState();
        return this.defaultBlockState().setValue(DOWN, checkState(belowState) || belowState.is(DDBlocks.BLOOMING_SCULK_STONE.get())).setValue(NORTH, checkState(northState)).setValue(EAST, checkState(eastState)).setValue(SOUTH, checkState(southState)).setValue(WEST, checkState(westState));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = shapes[0];

        if(state.getValue(UP)) shape = Shapes.join(shape, shapes[1], BooleanOp.OR);
        if(state.getValue(DOWN)) shape = Shapes.join(shape, shapes[2], BooleanOp.OR);
        if(state.getValue(NORTH)) shape = Shapes.join(shape, shapes[3], BooleanOp.OR);
        if(state.getValue(EAST)) shape = Shapes.join(shape, shapes[4], BooleanOp.OR);
        if(state.getValue(SOUTH)) shape = Shapes.join(shape, shapes[5], BooleanOp.OR);
        if(state.getValue(WEST)) shape = Shapes.join(shape, shapes[6], BooleanOp.OR);

        return shape;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if(!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
            return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }

        if(direction == Direction.DOWN && neighborState.is(DDBlocks.BLOOMING_SCULK_STONE.get())) return state.setValue(DOWN, true);
        if(direction.getAxis().isHorizontal() && checkState(neighborState) && canSurvive(level.getBlockState(neighborPos.below()))) return state;
        return state.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction), checkState(neighborState));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(itemAbility == ItemAbilities.AXE_STRIP && state.is(DDBlocks.BLOOMING_STEM.get())) {
            return DDBlocks.STRIPPED_BLOOMING_STEM.get().defaultBlockState().setValue(UP, state.getValue(UP)).setValue(DOWN, state.getValue(DOWN)).setValue(NORTH, state.getValue(NORTH)).setValue(EAST, state.getValue(EAST)).setValue(SOUTH, state.getValue(SOUTH)).setValue(WEST, state.getValue(WEST));
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!state.canSurvive(level, pos)) level.destroyBlock(pos, true);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        if(canSurvive(below)) return true;
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos relativePos = pos.relative(direction);
            BlockState relativeState = level.getBlockState(relativePos);
            if(checkState(relativeState) && state.getValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction)) && canSurvive(level.getBlockState(pos.below()))) return true;
        }

        return false;
    }

    private boolean canSurvive(BlockState state) {
        return checkState(state) || state.is(DDBlocks.BLOOMING_SCULK_STONE.get());
    }

    private boolean checkState(BlockState state) {
        return state.is(DDBlocks.BLOOMING_STEM.get()) || state.is(DDBlocks.STRIPPED_BLOOMING_STEM.get());
    }
}
