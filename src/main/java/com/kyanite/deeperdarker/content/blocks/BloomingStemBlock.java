package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
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

@SuppressWarnings("NullableProblems")
public class BloomingStemBlock extends Block {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    private static final VoxelShape[] SHAPES = {
            Block.box(5, 5, 5, 11, 11, 11),  // CENTER
            Block.box(5, 11, 5, 11, 16, 11), // UP
            Block.box(5, 0, 5, 11, 5, 11),   // DOWN
            Block.box(5, 5, 0, 11, 11, 5),   // NORTH
            Block.box(11, 5, 5, 16, 11, 11), // EAST
            Block.box(5, 5, 11, 11, 11, 16), // SOUTH
            Block.box(0, 5, 5, 5, 11, 11)    // WEST
    };

    public BloomingStemBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(DOWN, false).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
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
        Direction clickedDir = context.getClickedFace();

        if(validBase(belowState)) return this.defaultBlockState().setValue(DOWN, true);
        return this.defaultBlockState().setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(clickedDir.getOpposite()), true);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = SHAPES[0];

        if(state.getValue(UP)) shape = Shapes.join(shape, SHAPES[1], BooleanOp.OR);
        if(state.getValue(DOWN)) shape = Shapes.join(shape, SHAPES[2], BooleanOp.OR);
        if(state.getValue(NORTH)) shape = Shapes.join(shape, SHAPES[3], BooleanOp.OR);
        if(state.getValue(EAST)) shape = Shapes.join(shape, SHAPES[4], BooleanOp.OR);
        if(state.getValue(SOUTH)) shape = Shapes.join(shape, SHAPES[5], BooleanOp.OR);
        if(state.getValue(WEST)) shape = Shapes.join(shape, SHAPES[6], BooleanOp.OR);

        return shape;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if(!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
            return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }

        if(isStem(neighborState) && neighborState.getValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()))) {
            return state.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction), true);
        }
        if(!isStem(neighborState)) {
            return state.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction), false);
        }
        return state;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!state.canSurvive(level, pos)) level.destroyBlock(pos, true);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if(validBase(level.getBlockState(pos.below()))) return true;

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState adjacent = level.getBlockState(pos.relative(direction));
            BlockState belowAdjacent = level.getBlockState(pos.relative(direction).below());
            if(isStem(adjacent) && validBase(belowAdjacent) && state.getValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction))) return true;
        }

        return false;
    }

    private boolean validBase(BlockState state) {
        return isStem(state) || state.is(DDBlocks.BLOOMING_SCULK_STONE);
    }

    private boolean isStem(BlockState state) {
        return state.is(DDTags.Blocks.BLOOMING_STEMS);
    }
}
