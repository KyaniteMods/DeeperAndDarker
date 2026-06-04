package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("NullableProblems")
public class IceLilyBlock extends BushBlock {
    public static final BooleanProperty HAS_FLOWER = BooleanProperty.create("has_flower");
    private static final VoxelShape LILY_PAD = Block.box(1, 0, 1, 15, 1.5, 15);
    private static final VoxelShape FLOWER = Block.box(5, 0, 5, 11, 12, 11);

    public IceLilyBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_FLOWER, true));
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(itemStack.is(Items.SHEARS) && state.getValue(HAS_FLOWER)) {
            if(level.isClientSide()) return InteractionResult.SUCCESS;

            level.setBlock(pos, state.setValue(HAS_FLOWER, false), 3);
            level.playSound(player, pos, SoundEvents.BIG_DRIPLEAF_BREAK, SoundSource.BLOCKS);
            Block.popResource(level, pos, new ItemStack(DDBlocks.LILY_FLOWER));
            itemStack.hurtAndBreak(1, player, hand);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        ItemStack stack = context.getItemInHand();
        if (!stack.has(DataComponents.ENTITY_DATA)) return super.getStateForPlacement(context);
        return super.getStateForPlacement(context).setValue(HAS_FLOWER, false);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        FluidState fluidState = level.getFluidState(pos);
        FluidState fluidStateAbove = level.getFluidState(pos.above());
        return (fluidState.getType() == Fluids.WATER || state.getBlock() instanceof IceBlock) && fluidStateAbove.getType() == Fluids.EMPTY;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
        if(!level.isClientSide() && entity instanceof AbstractBoat) {
            level.destroyBlock(new BlockPos(pos), true, entity);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return mayPlaceOn(level.getBlockState(pos.below()), level, pos.below());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_FLOWER);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(HAS_FLOWER) ? Shapes.or(LILY_PAD, FLOWER) : LILY_PAD;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return LILY_PAD;
    }
}
