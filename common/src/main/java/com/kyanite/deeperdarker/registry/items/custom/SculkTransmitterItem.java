package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

public class SculkTransmitterItem extends Item {
    public SculkTransmitterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(isLinked(pPlayer.getItemInHand(pUsedHand))) {
            transmit(pLevel, pPlayer, pUsedHand);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(isLinked(pContext.getItemInHand())) {
            return transmit(pContext.getLevel(), pContext.getPlayer(), pContext.getHand());
        }

        if(!pContext.getLevel().getBlockState(pContext.getClickedPos()).is(DDTags.Blocks.TRANSMITTABLE)) {
            pContext.getPlayer().displayClientMessage(Component.translatable("item.deeperdarker.sculk_transmitter.not_container"), true);
            return InteractionResult.FAIL;
        }

        if(!isLinked(pContext.getItemInHand())) {
            pContext.getPlayer().playSound(DDSounds.SCULK_LINK, 0.5f, pContext.getLevel().getRandom().nextFloat() * 0.4F + 0.8F);
            setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos());
            return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    public InteractionResult transmit(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        BlockPos linked = getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand));
        if (isLinked(pPlayer.getItemInHand(pUsedHand))) {
            BlockState state = pLevel.getBlockState(linked);

            if (state == null || linked == null || pPlayer.isCrouching()) {
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return InteractionResult.FAIL;
            }

            if (!pLevel.getBlockState(linked).is(DDTags.Blocks.TRANSMITTABLE)) {
                pPlayer.displayClientMessage(Component.translatable("item.deeperdarker.sculk_transmitter.not_found"), true);
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return InteractionResult.FAIL;
            }

            pPlayer.playSound(DDSounds.SCULK_TRANSMIT, 0.5f, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
            if (!pPlayer.isCreative()) {
                if (pPlayer.totalExperience > 1) pPlayer.giveExperiencePoints(-1);
            }

            pLevel.gameEvent(GameEvent.ENTITY_INTERACT, pPlayer.blockPosition(), GameEvent.Context.of(pPlayer));

            MenuProvider menuProvider = state.getMenuProvider(pLevel, linked);

            if (menuProvider != null) {
                pPlayer.openMenu(menuProvider);

                BlockEntity blockEntity = pLevel.getBlockEntity(linked);
                if (blockEntity instanceof ChestBlockEntity chestBlockEntity) {
                    chestBlockEntity.startOpen(pPlayer);
                }
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    public BlockPos getLinkedBlockPos(ItemStack stack) {
        if(!stack.hasTag()) return null;
        if(stack.getTag().contains("linked")) {
            return new BlockPos(
                    stack.getTag().getIntArray("linked")[0],
                    stack.getTag().getIntArray("linked")[1],
                    stack.getTag().getIntArray("linked")[2]
            );
        }

        return null;
    }

    public boolean isLinked(ItemStack stack) {
        if(!stack.hasTag()) return false;
        return stack.getTag().contains("linked");
    }

    public void setModelData(ItemStack stack, Player player, InteractionHand hand, int data) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("CustomModelData", data);
        player.getItemInHand(hand).setTag(tag);
    }

    public void setBlock(ItemStack stack, Player player, InteractionHand hand, BlockPos pos) {
        CompoundTag tag = stack.getOrCreateTag();
        if(pos == null) {
            setModelData(stack, player, hand, 0);
            tag.remove("linked");
            player.getItemInHand(hand).setTag(tag);
            return;
        }

        tag.putIntArray("linked", new int[]{pos.getX(), pos.getY(), pos.getZ()});
        setModelData(stack, player, hand, 1);
        player.getItemInHand(hand).setTag(tag);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(isLinked(pStack)) pTooltipComponents.add(Component.translatable("item.deeperdarker.sculk_transmitter.linked"));
        else pTooltipComponents.add(Component.translatable("item.deeperdarker.sculk_transmitter.not_linked"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}