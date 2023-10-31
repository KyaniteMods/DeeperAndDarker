package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
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

        if(belowState.is(this) || belowState.is(DDBlocks.BLOOMING_SCULK.get())) return this.defaultBlockState();
        return this.defaultBlockState().setValue(UP, aboveState.is(this)).setValue(DOWN, belowState.is(this) || belowState.is(DDBlocks.BLOOMING_SCULK.get())).setValue(NORTH, northState.is(this)).setValue(EAST, eastState.is(this)).setValue(SOUTH, southState.is(this)).setValue(WEST, westState.is(this));
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

        if(pDirection == Direction.DOWN && pNeighborState.is(DDBlocks.BLOOMING_SCULK.get())) return pState.setValue(DOWN, true);
        if(pDirection.getAxis().isHorizontal() && !pLevel.getBlockState(pNeighborPos.below()).isAir()) return pState;
        return pState.setValue(PipeBlock.PROPERTY_BY_DIRECTION.get(pDirection), pNeighborState.is(this));
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState below = pLevel.getBlockState(pPos.below());

        if(below.is(this) || below.is(DDBlocks.BLOOMING_SCULK.get())) return true;


        if(canSurvive(below)) return true;

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos pos = pPos.relative(direction);
            BlockState state = pLevel.getBlockState(pos);
            if(state.is(this) && canSurvive(pLevel.getBlockState(pos.below()))) return true;
        }

        return false;
    }

    private boolean canSurvive(BlockState state) {
        return state.is(this) || state.is(DDBlocks.BLOOMING_SCULK.get());
    }
}
