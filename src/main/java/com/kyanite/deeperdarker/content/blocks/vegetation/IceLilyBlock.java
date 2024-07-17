package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDDataComponents;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
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
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"deprecation", "NullableProblems"})
public class IceLilyBlock extends BushBlock {
    public static final BooleanProperty HAS_FLOWER = BooleanProperty.create("has_flower");
    private static final VoxelShape LILY_PAD = Block.box(1, 0, 1, 15, 1.5, 15);
    private static final VoxelShape FLOWER = Block.box(5, 0, 5, 11, 12, 11);
    private static final MapCodec<IceLilyBlock> CODEC = simpleCodec(IceLilyBlock::new);

    public IceLilyBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_FLOWER, true));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (stack.is(Items.SHEARS) && state.getValue(HAS_FLOWER)) {
            level.setBlock(pos, state.setValue(HAS_FLOWER, false), 3);
            level.playSound(player, pos, SoundEvents.BIG_DRIPLEAF_BREAK, SoundSource.BLOCKS);
            Block.popResource(level, pos, new ItemStack(DDBlocks.LILY_FLOWER));
            stack.hurtAndBreak(1, player, Player.getSlotForHand(hand));
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        ItemStack stack = pContext.getItemInHand();
        if (stack.getOrDefault(DDDataComponents.HAS_FLOWER, false)) return super.getStateForPlacement(pContext);
        return super.getStateForPlacement(pContext).setValue(HAS_FLOWER, false);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        FluidState fluidState = pLevel.getFluidState(pPos);
        FluidState fluidStateAbove = pLevel.getFluidState(pPos.above());
        return (fluidState.getType() == Fluids.WATER || pState.getBlock() instanceof IceBlock) && fluidStateAbove.getType() == Fluids.EMPTY;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        if (pLevel instanceof ServerLevel && pEntity instanceof Boat) {
            pLevel.destroyBlock(new BlockPos(pPos), true, pEntity);
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return mayPlaceOn(pLevel.getBlockState(pPos.below()), pLevel, pPos.below());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HAS_FLOWER);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(HAS_FLOWER) ? Shapes.or(LILY_PAD, FLOWER) : LILY_PAD;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return LILY_PAD;
    }
}
