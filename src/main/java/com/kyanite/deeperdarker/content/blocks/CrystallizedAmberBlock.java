package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.List;

@SuppressWarnings("deprecation, NullableProblems")
public class CrystallizedAmberBlock extends BaseEntityBlock {
    public static final MapCodec<CrystallizedAmberBlock> CODEC = simpleCodec(CrystallizedAmberBlock::new);
    public static final BooleanProperty FOSSILIZED = BooleanProperty.create("fossilized");

    public CrystallizedAmberBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FOSSILIZED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FOSSILIZED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FOSSILIZED, pContext.getItemInHand().has(DataComponents.CUSTOM_DATA));
    }

    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pSide) {
        return pAdjacentBlockState.is(this);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        if(pState.getValue(FOSSILIZED) && !pState.is(pOldState.getBlock()) && pLevel.getBlockEntity(pPos) instanceof CrystallizedAmberBlockEntity blockEntity) {
            blockEntity.generateFossil(pLevel, pPos);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrystallizedAmberBlockEntity(pPos, pState);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(pStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = pStack.get(DataComponents.CUSTOM_DATA).copyTag();
            if(tag.contains("BlockEntityTag")) tag = tag.getCompound("BlockEntityTag");
            if(tag.contains("leech") && tag.getBoolean("leech")) pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.leech").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
            else if(tag.contains("item")) pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.item", ItemStack.parse(pContext.registries(), tag.getCompound("item")).get().getHoverName()).withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }
    }
}
