package com.kyanite.deeperdarker.blocks;

import com.kyanite.deeperdarker.entities.DeeperDarkerEntityTypes;
import com.kyanite.deeperdarker.entities.SculkLeechEntity;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class AncientVaseBlock extends ExperienceDroppingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape BASE = Block.createCuboidShape(3, 0, 3, 13, 1, 13);
    private static final VoxelShape OUTLINE = Block.createCuboidShape(2, 1, 2, 14, 13, 14);
    private static final VoxelShape RIM = Block.createCuboidShape(4, 13, 4, 12, 16, 12);

    public AncientVaseBlock(Settings settings) {
        super(settings, UniformIntProvider.create(1, 3));
        this.setDefaultState(this.getDefaultState().with(Properties.WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).isOf(
                Fluids.WATER));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Stream.of(BASE, OUTLINE, RIM).reduce((v1, v2) -> VoxelShapes.combine(v1, v2, BooleanBiFunction.OR)).get();
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean movedByPiston) {
        super.onStateReplaced(state, world, pos, newState, movedByPiston);

        Random random = Random.create();
        if (random.nextFloat() < 0.125f) {
            for(int i = 0; i < random.nextBetween(1, 4); i++) {
                SculkLeechEntity entity = DeeperDarkerEntityTypes.SCULK_LEECH.create(world);
                assert entity != null;
                entity.refreshPositionAndAngles(pos.getX() + random.nextFloat(), pos.getY() + random.nextFloat() + 0.15f, pos.getZ() + random.nextFloat(), random.nextFloat() * 360, random.nextFloat() * 360);
                world.spawnEntity(entity);
            }
        }
    }
}
