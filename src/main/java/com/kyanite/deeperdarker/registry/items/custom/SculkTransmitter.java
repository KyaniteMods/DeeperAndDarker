package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkTransmitter extends Item {
    public SculkTransmitter(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) != null) {
            BlockState state = pLevel.getBlockState(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)));
            if(state == null || getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) == null) {
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return super.use(pLevel, pPlayer, pUsedHand);
            }
            MenuProvider menuProvider = state.getMenuProvider(pLevel, getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)));
            if(menuProvider != null) {
                pPlayer.openMenu(menuProvider);
            }else{
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().getBlockState(pContext.getClickedPos()).is(DDTags.Blocks.TRANSMITTABLE)) {
            pContext.getPlayer().displayClientMessage(Component.translatable("This block cannot be transmitted!"), true);
            return InteractionResult.FAIL;
        }

        if(!pContext.getItemInHand().hasTag()) // If the transmitter has no tag (which means no data has been added meaning no blockpos)
        {
            setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos()); // Set block pos
            return InteractionResult.SUCCESS;
        }
        return super.useOn(pContext);
    }

    @Nullable
    public BlockPos getLinkedBlockPos(ItemStack itemStack) {
        if(!itemStack.hasTag()) return null;
        if(itemStack.getTag().contains("linked"))
        {
            return new BlockPos(
                    itemStack.getTag().getIntArray("linked")[0],
                    itemStack.getTag().getIntArray("linked")[1],
                    itemStack.getTag().getIntArray("linked")[2]
            );
        }
        return null;
    }

    public void setBlock(ItemStack itemStack, Player plr, InteractionHand hand, BlockPos blockPos) {
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putIntArray("linked", new int[]{
                blockPos.getX(),
                blockPos.getY(),
                blockPos.getZ()
        });
        plr.getItemInHand(hand).setTag(tag);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()) {
            if(getLinkedBlockPos(pStack) != null)
                pTooltipComponents.add(Component.translatable("Linked"));
        }else
            pTooltipComponents.add(Component.translatable("Not Linked"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
