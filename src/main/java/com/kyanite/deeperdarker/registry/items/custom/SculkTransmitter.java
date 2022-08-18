package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkTransmitter extends Item {
    public SculkTransmitter(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult transmit(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        BlockPos linked = getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand));
        if(linked != null) {
            if(pPlayer.totalExperience < 1) return InteractionResult.FAIL;

            BlockState state = pLevel.getBlockState(linked);
            if(state == null || pPlayer.isCrouching()) {
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return InteractionResult.FAIL;
            }

            pPlayer.playSound(DDSounds.SCULK_TRANSMIT.get(), 0.5f, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
            if(pLevel.isClientSide) return InteractionResult.sidedSuccess(true);

            if(!pPlayer.isCreative()) pPlayer.giveExperiencePoints(-1);
            pLevel.gameEvent(GameEvent.ENTITY_INTERACT, pPlayer.blockPosition(), GameEvent.Context.of(pPlayer));

            MenuProvider menuProvider = state.getMenuProvider(pLevel, linked);
            if(menuProvider != null) {
                pPlayer.openMenu(menuProvider);

                if(pLevel.getBlockEntity(linked) instanceof ChestBlockEntity chestBlockEntity) {
                    chestBlockEntity.startOpen(pPlayer);
                }
            }
        }else{
            setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) != null) {
            transmit(pLevel, pPlayer, pUsedHand);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(getLinkedBlockPos(pContext.getPlayer().getItemInHand(pContext.getHand())) != null) {
            return transmit(pContext.getLevel(), pContext.getPlayer(), pContext.getHand());
        }

        if(!pContext.getLevel().getBlockState(pContext.getClickedPos()).is(DDTags.Blocks.TRANSMITTABLE)) {
            pContext.getPlayer().displayClientMessage(Component.translatable("item.deeperdarker.sculk_transmitter.untransmittable"), true);
            return InteractionResult.FAIL;
        }

        if(pContext.getItemInHand().hasTag()) {
            if(!pContext.getItemInHand().getTag().contains("linked")) {
                pContext.getPlayer().playSound(DDSounds.SCULK_LINK.get(), 0.5f, pContext.getLevel().getRandom().nextFloat() * 0.4F + 0.8F);
                setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos());
                return InteractionResult.SUCCESS;
            }
        } else {
            pContext.getPlayer().playSound(DDSounds.SCULK_LINK.get(), 0.5f, pContext.getLevel().getRandom().nextFloat() * 0.4F + 0.8F);
            setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos());
            return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    @Nullable
    public BlockPos getLinkedBlockPos(ItemStack itemStack) {
        if(!itemStack.hasTag()) return null;
        if(itemStack.getTag().contains("linked")) {
            return new BlockPos(
                    itemStack.getTag().getIntArray("linked")[0],
                    itemStack.getTag().getIntArray("linked")[1],
                    itemStack.getTag().getIntArray("linked")[2]
            );
        }

        return null;
    }

    public void setModelData(ItemStack itemStack, Player plr, InteractionHand hand, int data) {
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putInt("CustomModelData", data);
        plr.getItemInHand(hand).setTag(tag);
    }

    public void setBlock(ItemStack itemStack, Player player, InteractionHand hand, BlockPos pos) {
        CompoundTag tag = itemStack.getOrCreateTag();
        if(pos == null) {
            setModelData(itemStack, player, hand, 0);
            tag.remove("linked");
            player.getItemInHand(hand).setTag(tag);
            return;
        }

        tag.putIntArray("linked", new int[]{ pos.getX(), pos.getY(), pos.getZ() });
        setModelData(itemStack, player, hand, 1);

        player.getItemInHand(hand).setTag(tag);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(pStack.hasTag()) {
            if(getLinkedBlockPos(pStack) != null) pTooltipComponents.add(Component.translatable("item.deeperdarker.sculk_transmitter.linked"));
            else pTooltipComponents.add(Component.translatable("item.deeperdarker.sculk_transmitter.not_linked"));
        } else pTooltipComponents.add(Component.translatable("item.deeperdarker.sculk_transmitter.not_linked"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
