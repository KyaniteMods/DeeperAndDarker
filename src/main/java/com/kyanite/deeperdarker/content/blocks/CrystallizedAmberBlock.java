package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
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
    public static final BooleanProperty FOSSILIZED = BooleanProperty.create("fossilized");

    public CrystallizedAmberBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FOSSILIZED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FOSSILIZED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FOSSILIZED, pContext.getItemInHand().hasTag());
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
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        if(blockEntity instanceof CrystallizedAmberBlockEntity crystallizedAmber) {
            if(!EnchantmentHelper.hasSilkTouch(itemStack) && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                if(crystallizedAmber.fossilizedEntity && level instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                else Block.popResource(level, pos, crystallizedAmber.getLoot());
            } else if(EnchantmentHelper.hasSilkTouch(itemStack) && !level.isClientSide()) {
                ItemStack stack = new ItemStack(DDBlocks.CRYSTALLIZED_AMBER);
                if (state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                    CompoundTag tag = new CompoundTag();
                    tag.put("item", crystallizedAmber.getLoot().save(new CompoundTag()));
                    tag.putBoolean("leech", crystallizedAmber.fossilizedEntity);
                    tag.putFloat("rotation", crystallizedAmber.rotation);
                    BlockItem.setBlockEntityData(stack, DDBlockEntities.CRYSTALLIZED_AMBER, tag);
                }

                Block.popResource(level, pos, stack);

                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag) {
        if (itemStack.hasTag() && itemStack.getTag().contains("BlockEntityTag")) {
            CompoundTag tag = itemStack.getTag().getCompound("BlockEntityTag");
            if (tag.contains("leech") && tag.getBoolean("leech")) {
                list.add(ComponentUtils.wrapInSquareBrackets(DDEntities.SCULK_LEECH.getDescription().copy()).withStyle(ChatFormatting.GRAY));
            } else if (tag.contains("item")) {
                ItemStack stack = ItemStack.of(tag.getCompound("item"));
                list.add(stack.getDisplayName().copy().withStyle(ChatFormatting.GRAY));
            }
        }
        super.appendHoverText(itemStack, blockGetter, list, tooltipFlag);
    }
}
