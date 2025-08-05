package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.blocks.entity.GloomslatePotBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("deprecation, NullableProblems")
public class GloomslatePotBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<GloomslatePotBlock> CODEC = simpleCodec(GloomslatePotBlock::new);
    private static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty CRACKED = BlockStateProperties.CRACKED;
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);

    public GloomslatePotBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(CRACKED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, WATERLOGGED, CRACKED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER).setValue(CRACKED, false);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(HORIZONTAL_FACING, rotation.rotate(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!(level.getBlockEntity(pos) instanceof GloomslatePotBlockEntity blockEntity)) return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        if(!(level instanceof ServerLevel serverLevel)) return ItemInteractionResult.CONSUME;
        if(stack.isEmpty()) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        ItemStack storedItem = blockEntity.getTheItem();
        if(storedItem.isEmpty() || (ItemStack.isSameItemSameComponents(storedItem, stack) && storedItem.getCount() < storedItem.getMaxStackSize())) {
            blockEntity.wobble(DecoratedPotBlockEntity.WobbleStyle.POSITIVE);
            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            ItemStack storingItem = stack.consumeAndReturn(1, player);

            float stackSizePercent;
            if(blockEntity.isEmpty()) {
                blockEntity.setTheItem(storingItem);
                stackSizePercent = (float)storingItem.getCount() / storingItem.getMaxStackSize();
            } else {
                storedItem.grow(1);
                stackSizePercent = (float)storedItem.getCount() / storedItem.getMaxStackSize();
            }

            level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1f, 0.7f + 0.5f * stackSizePercent);
            serverLevel.sendParticles(ParticleTypes.DUST_PLUME, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 7, 0, 0, 0, 0);

            blockEntity.setChanged();
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return ItemInteractionResult.SUCCESS;
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof GloomslatePotBlockEntity blockEntity) {
            level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS);
            blockEntity.wobble(DecoratedPotBlockEntity.WobbleStyle.NEGATIVE);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        }

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        ItemStack stack = player.getMainHandItem();
        BlockState newState = state;
        if(stack.is(ItemTags.BREAKS_DECORATED_POTS) && !EnchantmentHelper.hasTag(stack, EnchantmentTags.PREVENTS_DECORATED_POT_SHATTERING)) {
            newState = state.setValue(CRACKED, true);
            level.setBlock(pos, newState, 4);
        }

        return super.playerWillDestroy(level, pos, newState, player);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        Containers.dropContentsOnDestroy(state, newState, level, pos);
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        BlockEntity lootBlockEntity = params.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if(lootBlockEntity instanceof GloomslatePotBlockEntity blockEntity) {
            params.withDynamicDrop(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID, consumer -> {
                for(Item item : blockEntity.getDecorations().ordered()) {
                    ItemStack drop = new ItemStack(item);
                    if(item == Items.BRICK) drop = new ItemStack(DDItems.GLOOMSHERD.get());
                    consumer.accept(drop);
                }
            });
        }

        return super.getDrops(state, params);
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos pos = hit.getBlockPos();
        if(!level.isClientSide() && projectile.mayInteract(level, pos) && projectile.mayBreak(level)) {
            level.setBlock(pos, state.setValue(CRACKED, true), 4);
            level.destroyBlock(pos, true, projectile);
        }
    }

    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        return state.getValue(CRACKED) ? SoundType.DECORATED_POT_CRACKED : SoundType.DECORATED_POT;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return level.getBlockEntity(pos) instanceof GloomslatePotBlockEntity blockEntity ? blockEntity.getPotAsItem() : super.getCloneItemStack(state, target, level, pos, player);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GloomslatePotBlockEntity(pos, state);
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

        PotDecorations decorations = stack.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
        if(!decorations.equals(PotDecorations.EMPTY)) {
            tooltipComponents.add(CommonComponents.EMPTY);
            Stream.of(decorations.front(), decorations.left(), decorations.right(), decorations.back()).forEach(item -> tooltipComponents.add(new ItemStack(item.orElse(DDItems.GLOOMSHERD.get()), 1).getHoverName().plainCopy().withStyle(ChatFormatting.GRAY)));
        }
    }
}
