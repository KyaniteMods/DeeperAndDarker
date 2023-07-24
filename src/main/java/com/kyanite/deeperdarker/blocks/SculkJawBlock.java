package com.kyanite.deeperdarker.blocks;

import com.kyanite.deeperdarker.entities.DeeperDarkerEntityGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SculkJawBlock extends Block {
    public static final BooleanProperty BITING = BooleanProperty.of("biting");
    public static final BooleanProperty CAN_BITE = BooleanProperty.of("can_bite");

    public SculkJawBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(BITING, false).with(CAN_BITE, true));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof PlayerEntity player && (player.isCreative() || player.isSneaking())) return;
        if (entity instanceof HostileEntity hostileEntity && hostileEntity.getGroup() == DeeperDarkerEntityGroups.SCULK) return;
        if (state.get(CAN_BITE) && entity instanceof LivingEntity livingEntity) {
            world.setBlockState(pos, state.with(BITING, true), 3);
            livingEntity.damage(world.getDamageSources().magic(), 3);
            world.scheduleBlockTick(pos, this, 35);
        }
    }

    @Override
    public void randomTick(BlockState pState, ServerWorld pLevel, BlockPos pos, Random random) {
        if (pState.get(BITING)) {
            pLevel.setBlockState(pos, pState.with(BITING, false), 3);
        }
    }

    @Override
    public void onEntityCollision(BlockState pState, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) livingEntity.damage(world.getDamageSources().magic(), 3);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(BITING) ? Block.createCuboidShape(0, 0, 0, 0, 0, 0) : super.getCollisionShape(state, world, pos, context);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITING, CAN_BITE);
    }
}