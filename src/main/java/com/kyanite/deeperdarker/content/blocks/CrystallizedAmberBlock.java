package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.items.components.*;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation, NullableProblems")
public class CrystallizedAmberBlock extends BaseEntityBlock {
    public static final MapCodec<CrystallizedAmberBlock> CODEC = simpleCodec(CrystallizedAmberBlock::new);
    public static final BooleanProperty FOSSILIZED = BooleanProperty.create("fossilized");
    public static final BooleanProperty INTACT = BooleanProperty.create("intact");

    public CrystallizedAmberBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FOSSILIZED, false).setValue(INTACT, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FOSSILIZED, INTACT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FOSSILIZED, pContext.getItemInHand().has(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT));
    }

    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pSide) {
        return pAdjacentBlockState.is(this);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onPlace(BlockState pState, Level level, BlockPos pos, BlockState pOldState, boolean pMovedByPiston) {
        if (level.isClientSide()) return;
        if(pState.getValue(FOSSILIZED) && !pState.is(pOldState.getBlock()) && level.getBlockEntity(pos) instanceof final CrystallizedAmberBlockEntity blockEntity) {
            CrystallizedAmberContent.getRandom((ServerLevel) level, pos).ifPresent(blockEntity::setContent);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrystallizedAmberBlockEntity(pPos, pState);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        ItemStack itemStack = player.getMainHandItem();
        BlockState newState = state;
        if (EnchantmentHelper.hasTag(itemStack, DDTags.Enchantments.PICKS_UP_CRYSTALLIZED_AMBER) || player.getAbilities().instabuild) {
            newState = state.setValue(INTACT, true);
            level.setBlock(pos, newState, Block.UPDATE_INVISIBLE);
        }
        return super.playerWillDestroy(level, pos, newState, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        if(blockEntity instanceof CrystallizedAmberBlockEntity crystallizedAmber) {
            boolean picksUp = EnchantmentHelper.hasTag(itemStack, DDTags.Enchantments.PICKS_UP_CRYSTALLIZED_AMBER);
            if (picksUp && !level.isClientSide()) {
                ItemStack stack = new ItemStack(DDBlocks.CRYSTALLIZED_AMBER);
                if (state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                    stack.set(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT, crystallizedAmber.getContent());
                }

                Block.popResource(level, pos, stack);

                level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean bl) {
        if (state.is(newState.getBlock())) {
            return;
        }
        if (!state.getValue(INTACT) && level.getBlockEntity(pos) instanceof CrystallizedAmberBlockEntity blockEntity) {
            if (blockEntity.getContent() != null) {
                blockEntity.getContent().onDestroy(level, pos, state, blockEntity);
            }
        }
        super.onRemove(state, level, pos, newState, bl);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        if (itemStack.has(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT)) {
            CrystallizedAmberContent<?> content = itemStack.get(DDDataComponents.CRYSTALLIZED_AMBER_CONTENT);
            content.getDisplayName().ifPresent(component -> {
                list.add(component.copy().withStyle(ChatFormatting.GRAY));
            });
        }
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }
}
