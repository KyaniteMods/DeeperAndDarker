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

    public CrystallizedAmberBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FOSSILIZED, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FOSSILIZED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FOSSILIZED, context.getItemInHand().has(DataComponents.BLOCK_ENTITY_DATA));
    }

    public boolean skipRendering(BlockState state, BlockState adjacentState, Direction direction) {
        return adjacentState.is(this);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if(state.getValue(FOSSILIZED) && !state.is(oldState.getBlock()) && level.getBlockEntity(pos) instanceof CrystallizedAmberBlockEntity blockEntity) {
            blockEntity.generateFossil(level, pos);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrystallizedAmberBlockEntity(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(stack.has(DataComponents.BLOCK_ENTITY_DATA)) {
            CompoundTag tag = stack.get(DataComponents.BLOCK_ENTITY_DATA).copyTag();
            if(tag.contains("BlockEntityTag")) {
                System.out.println("tagging");
                tag = tag.getCompound("BlockEntityTag");
            }
            if(tag.contains("leech") && tag.getBoolean("leech")) {
                System.out.println("leech");
                tooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.leech").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
            }
            else if(tag.contains("item")) {
                System.out.println("item");
                tooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".crystallized_amber.item", ItemStack.parseOptional(context.registries(), tag.getCompound("item")).getHoverName()).withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
            }
        }
    }
}
