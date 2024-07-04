package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
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
    public static final BooleanProperty FOSSILIZED = BooleanProperty.create("fossilized");
    private static final MapCodec<CrystallizedAmberBlock> CODEC = simpleCodec(CrystallizedAmberBlock::new);

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
        return this.defaultBlockState().setValue(FOSSILIZED, pContext.getItemInHand().has(DataComponents.BLOCK_ENTITY_DATA));
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
            if(!EnchantmentHelper.hasTag(itemStack, DDTags.Enchantments.PICKS_UP_CRYSTALLIZED_AMBER) && state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                if(crystallizedAmber.fossilizedEntity && level instanceof ServerLevel serverLevel) DDEntities.SCULK_LEECH.spawn(serverLevel, pos, MobSpawnType.TRIGGERED);
                else Block.popResource(level, pos, crystallizedAmber.getLoot());
            } else if(EnchantmentHelper.hasTag(itemStack, DDTags.Enchantments.PICKS_UP_CRYSTALLIZED_AMBER) && !level.isClientSide()) {
                ItemStack stack = new ItemStack(DDBlocks.CRYSTALLIZED_AMBER);
                if (state.getValue(CrystallizedAmberBlock.FOSSILIZED)) {
                    CompoundTag tag = new CompoundTag();
                    tag.put("item", crystallizedAmber.getLoot().save(level.registryAccess()));
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
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        CompoundTag tag = itemStack.getOrDefault(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY).copyTag();
        HolderLookup.Provider provider = context.registries();
        if (tag.contains("leech") && tag.getBoolean("leech")) {
            list.add(ComponentUtils.wrapInSquareBrackets(DDEntities.SCULK_LEECH.getDescription().copy()).withStyle(ChatFormatting.GRAY));
        } else if (tag.contains("item") && provider != null) {
            ItemStack stack = ItemStack.parse(provider, tag.getCompound("item")).orElse(ItemStack.EMPTY);
            list.add(stack.getDisplayName().copy().withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, context, list, tooltipFlag);
    }
}
